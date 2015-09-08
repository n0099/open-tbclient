package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChosenPostActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.e.f;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.a.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class d extends FrameLayout implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, BdListView.e {
    private BdListView aLm;
    private boolean aLt;
    private boolean aLu;
    private boolean aTP;
    private PbListView aXr;
    private int akk;
    private m cAH;
    private TextView cAI;
    private c cAJ;
    private int cAK;
    private int cAL;
    private int cAM;
    private long cAN;
    private com.baidu.tieba.recommendfrs.a cAO;
    private f cAP;
    private b cAQ;
    private String cAR;
    private boolean cAS;
    private boolean mHasMore;
    private z mPullView;
    private TbPageContext<?> pageContext;

    public d(Context context) {
        super(context);
        this.cAK = 0;
        this.cAL = 0;
        this.cAM = 0;
        this.cAS = false;
        init(context);
    }

    private void init(Context context) {
        h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        g(context, LayoutInflater.from(context).inflate(i.g.recommend_frs_activity, this));
        this.cAJ = new c(this.pageContext, null);
        this.aLm.setAdapter((ListAdapter) this.cAJ);
        this.cAK = k.K(context);
        this.cAL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.cAM = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20);
        this.akk = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.recommendfrs.a aVar) {
        this.cAO = aVar;
    }

    public void setScrollCallback(b bVar) {
        this.cAQ = bVar;
    }

    public void ans() {
        this.cAN = System.currentTimeMillis();
        if (!this.aLu) {
            if (this.aLt && !k.jc()) {
                if (this.cAJ.DA() <= 0) {
                    this.cAJ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akk), NoDataViewFactory.d.cJ(i.h.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    this.cAJ.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a((View) this, false, getResources().getDimensionPixelSize(i.d.ds300));
            startLoad();
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cAN) / 1000));
        }
    }

    private void g(Context context, View view) {
        this.cAI = (TextView) view.findViewById(i.f.time);
        this.cAI.setVisibility(8);
        this.aLm = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new z(this.pageContext);
        this.aLm.setPullRefresh(this.mPullView);
        this.aXr = new PbListView(context);
        this.aXr.nn();
        this.aXr.cM(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.aLm.setOnSrollToBottomListener(this);
        this.aLm.setOnItemClickListener(this);
        this.aLm.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.e eVar, boolean z) {
        if (this.aLm != null) {
            this.aLm.completePullRefresh();
        }
        if (this.aXr != null) {
            this.aXr.vG();
        }
        if (eVar == null) {
            ao(this);
            this.cAJ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akk), NoDataViewFactory.d.cJ(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cAJ.notifyDataSetChanged();
            return;
        }
        this.aTP = false;
        this.aLu = eVar.anN();
        this.aLt = eVar.anM();
        this.cAR = eVar.getTag();
        this.cAS = eVar.anK();
        setHasMore(eVar.hasMore());
        bl(eVar.anP());
        List<Object> anO = eVar.anO();
        if (this.cAJ != null) {
            if (anO == null || anO.size() <= 0) {
                if (this.aLt && this.aLu) {
                    this.cAJ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akk), NoDataViewFactory.d.cJ(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                } else {
                    this.cAJ.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
            }
            this.cAJ.s(anO);
        }
        if (z) {
            this.aLm.setSelection(eVar.anL());
        }
        if (this.aLu || (anO != null && !anO.isEmpty())) {
            ao(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.aLm != null) {
            if (this.mHasMore) {
                if (this.aXr != null && this.aXr.getView().getParent() == null) {
                    this.aLm.setNextPage(this.aXr);
                    return;
                }
                return;
            }
            this.aLm.setNextPage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.aLt) {
            this.cAO.b(0, this.cAR, 0);
        } else {
            this.cAO.ku(this.cAR);
        }
    }

    public void X(String str, int i) {
        if (this.aLm != null) {
            this.aLm.completePullRefresh();
        }
        this.aTP = false;
        this.aXr.vG();
        if (this.cAJ.DA() <= 0 && this.aLt) {
            this.cAJ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akk), NoDataViewFactory.d.dy(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cAJ.s(new ArrayList());
        }
        ao(this);
    }

    private void bl(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list == null || list.isEmpty()) {
            if (this.cAH != null) {
                this.aLm.removeHeaderView(this.cAH.getView());
                this.cAH = null;
                return;
            }
            return;
        }
        if (this.cAH == null) {
            ant();
            this.aLm.addHeaderView(this.cAH.getView());
        }
        this.cAH.setTitle(UtilHelper.getFixedText(list.get(0).anx(), 14, true));
        this.cAH.setData(list);
    }

    private void ant() {
        this.cAH = new m(getContext());
        this.cAH.e(this.pageContext);
        this.cAH.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(String str, String str2) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), com.baidu.adp.lib.g.b.c(str, 0L), str2)));
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ch("from_frs").bs(18003).ro()));
            TiebaStatic.log("c10258");
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v13 long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.cAJ.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            String str = (bVar.anE() == null || bVar.anE().isEmpty()) ? null : bVar.anE().get(0);
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(bVar.anD()));
            if (bVar.anH() == 33) {
                a(bVar.anI());
            } else {
                bb(String.valueOf(bVar.anD()), str);
            }
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.lj(String.valueOf(bVar.anD()))) {
                readThreadHistory.li(String.valueOf(bVar.anD()));
                this.cAJ.A(item);
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            TiebaStatic.eventStat(getContext(), "kantie_3", null);
            long longValue = ((com.baidu.tieba.recommendfrs.data.c) item).anJ().thread_id.longValue();
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(longValue));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(new StringBuilder().append(longValue).toString(), null, "")));
        } else if ((item instanceof com.baidu.tieba.recommendfrs.data.d) && ((com.baidu.tieba.recommendfrs.data.d) item).getType() == "text_type_check_more" && bb.ah(getContext())) {
            TiebaStatic.eventStat(getContext(), "kantie_4", null);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChosenPostActivityConfig(getContext())));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i <= 1 || !this.cAS) {
            if (this.cAI.getVisibility() != 8) {
                this.cAI.setVisibility(8);
                return;
            }
            return;
        }
        Object item = this.cAJ.getItem(i - this.aLm.getHeaderViewsCount());
        if (item instanceof String) {
            this.cAI.setText((String) item);
            this.cAI.setVisibility(0);
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.i) {
            this.cAI.setVisibility(0);
            this.cAI.setText(((com.baidu.tieba.recommendfrs.data.i) item).anX());
        }
        if (this.cAJ.getItem(this.aLm.pointToPosition(0, this.cAI.getBottom() + 5) - this.aLm.getHeaderViewsCount()) instanceof String) {
            fC(true);
        } else {
            fC(false);
        }
    }

    private void fC(boolean z) {
        View childAt = this.aLm.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() + this.cAM : 0;
        if (z && bottom < this.cAL) {
            this.cAI.layout(0, bottom - this.cAL, this.cAK, bottom);
        } else {
            this.cAI.layout(0, 0, this.cAK, this.cAL);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && k.jc() && !this.aTP) {
            this.aTP = true;
            this.aXr.startLoadData();
            if (this.cAO != null) {
                if (this.cAJ == null) {
                    this.cAO.b(0, this.cAR, 0);
                    return;
                }
                com.baidu.tieba.recommendfrs.data.b anr = this.cAJ.anr();
                if (anr != null) {
                    this.cAO.b(anr.anF(), this.cAR, anr.anA());
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.pageContext, this);
        al.d(this, i.c.cp_bg_line_d, i);
        if (this.cAJ != null) {
            this.cAJ.a(this.pageContext, i);
        }
        if (this.cAH != null) {
            this.cAH.e(this.pageContext);
        }
        if (this.mPullView != null) {
            this.mPullView.cM(i);
        }
        if (this.aXr != null) {
            this.aXr.cM(i);
        }
    }

    public boolean kv(String str) {
        return TextUtils.equals(str, this.cAR);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cAQ != null) {
            this.cAQ.W(this.cAR, this.aLm.getFirstVisiblePosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements x.a {
        private a() {
        }

        /* synthetic */ a(d dVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.x.a
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(d.this.getContext(), "kantie_update", null);
            if (d.this.cAO != null) {
                d.this.startLoad();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cAP == null) {
            if (i < 0) {
                this.cAP = new f(getContext());
            } else {
                this.cAP = new f(getContext(), i);
            }
            this.cAP.tf();
        }
        this.cAP.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.cAJ != null) {
            this.cAJ.bq(false);
            this.cAJ.notifyDataSetChanged();
        }
    }

    private void ao(View view) {
        if (this.cAP != null) {
            this.cAP.u(view);
            this.cAP = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.cAJ != null) {
            this.cAJ.bq(true);
            this.cAJ.notifyDataSetChanged();
        }
    }
}
