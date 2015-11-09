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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.e.f;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.a.m;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class d extends FrameLayout implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, BdListView.e {
    private BdListView aJj;
    private boolean aJq;
    private boolean aJr;
    private boolean aTe;
    private PbListView aXe;
    private int ajp;
    private m cJE;
    private TextView cJF;
    private c cJG;
    private int cJH;
    private int cJI;
    private int cJJ;
    private long cJK;
    private com.baidu.tieba.recommendfrs.a cJL;
    private f cJM;
    private b cJN;
    private String cJO;
    private boolean cJP;
    private boolean mHasMore;
    private r mPullView;
    private TbPageContext<?> pageContext;

    public d(Context context) {
        super(context);
        this.cJH = 0;
        this.cJI = 0;
        this.cJJ = 0;
        this.cJP = false;
        init(context);
    }

    private void init(Context context) {
        h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        g(context, LayoutInflater.from(context).inflate(i.g.recommend_frs_activity, this));
        this.cJG = new c(this.pageContext, null);
        this.aJj.setAdapter((ListAdapter) this.cJG);
        this.cJH = k.K(context);
        this.cJI = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.cJJ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20);
        this.ajp = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.recommendfrs.a aVar) {
        this.cJL = aVar;
    }

    public void setScrollCallback(b bVar) {
        this.cJN = bVar;
    }

    public void aqs() {
        this.cJK = System.currentTimeMillis();
        if (!this.aJr) {
            if (this.aJq && !k.je()) {
                if (this.cJG.Dd() <= 0) {
                    this.cJG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajp), NoDataViewFactory.d.cK(i.h.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    this.cJG.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a((View) this, false, getResources().getDimensionPixelSize(i.d.ds300));
            startLoad();
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cJK) / 1000));
        }
    }

    private void g(Context context, View view) {
        this.cJF = (TextView) view.findViewById(i.f.time);
        this.cJF.setVisibility(8);
        this.aJj = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new r(this.pageContext);
        this.aJj.setPullRefresh(this.mPullView);
        this.aXe = new PbListView(context);
        this.aXe.np();
        this.aXe.cN(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.aJj.setOnSrollToBottomListener(this);
        this.aJj.setOnItemClickListener(this);
        this.aJj.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.e eVar, boolean z) {
        if (this.aJj != null) {
            this.aJj.completePullRefresh();
        }
        if (this.aXe != null) {
            this.aXe.vz();
        }
        if (eVar == null) {
            ao(this);
            this.cJG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajp), NoDataViewFactory.d.cK(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cJG.notifyDataSetChanged();
            return;
        }
        this.aTe = false;
        this.aJr = eVar.aqN();
        this.aJq = eVar.aqM();
        this.cJO = eVar.getTag();
        this.cJP = eVar.aqK();
        setHasMore(eVar.hasMore());
        bs(eVar.aqP());
        List<Object> aqO = eVar.aqO();
        if (this.cJG != null) {
            if (aqO == null || aqO.size() <= 0) {
                if (this.aJq && this.aJr) {
                    this.cJG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajp), NoDataViewFactory.d.cK(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                } else {
                    this.cJG.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
            }
            this.cJG.s(aqO);
        }
        if (z) {
            this.aJj.setSelection(eVar.aqL());
        }
        if (this.aJr || (aqO != null && !aqO.isEmpty())) {
            ao(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.aJj != null) {
            if (this.mHasMore) {
                if (this.aXe != null && this.aXe.getView().getParent() == null) {
                    this.aJj.setNextPage(this.aXe);
                    return;
                }
                return;
            }
            this.aJj.setNextPage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.aJq) {
            this.cJL.b(0, this.cJO, 0);
        } else {
            this.cJL.kZ(this.cJO);
        }
    }

    public void Z(String str, int i) {
        if (this.aJj != null) {
            this.aJj.completePullRefresh();
        }
        this.aTe = false;
        this.aXe.vz();
        if (this.cJG.Dd() <= 0 && this.aJq) {
            this.cJG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajp), NoDataViewFactory.d.dC(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cJG.s(new ArrayList());
        }
        ao(this);
    }

    private void bs(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list == null || list.isEmpty()) {
            if (this.cJE != null) {
                this.aJj.removeHeaderView(this.cJE.getView());
                this.cJE = null;
                return;
            }
            return;
        }
        if (this.cJE == null) {
            aqt();
            this.aJj.addHeaderView(this.cJE.getView());
        }
        this.cJE.setTitle(UtilHelper.getFixedText(list.get(0).aqx(), 14, true));
        this.cJE.setData(list);
    }

    private void aqt() {
        this.cJE = new m(getContext());
        this.cJE.e(this.pageContext);
        this.cJE.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(String str, String str2) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), com.baidu.adp.lib.g.b.c(str, 0L), str2)));
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cg("from_frs").bs(18003).ri()));
            TiebaStatic.log("c10258");
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v13 long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.cJG.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            String str = (bVar.aqE() == null || bVar.aqE().isEmpty()) ? null : bVar.aqE().get(0);
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(bVar.aqD()));
            if (bVar.aqH() == 33) {
                a(bVar.aqI());
            } else {
                ba(String.valueOf(bVar.aqD()), str);
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.lR(String.valueOf(bVar.aqD()))) {
                readThreadHistory.lQ(String.valueOf(bVar.aqD()));
                this.cJG.A(item);
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            TiebaStatic.eventStat(getContext(), "kantie_3", null);
            long longValue = ((com.baidu.tieba.recommendfrs.data.c) item).aqJ().thread_id.longValue();
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(longValue));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(new StringBuilder().append(longValue).toString(), null, "")));
        } else if ((item instanceof com.baidu.tieba.recommendfrs.data.d) && ((com.baidu.tieba.recommendfrs.data.d) item).getType() == "text_type_check_more" && bd.ah(getContext())) {
            TiebaStatic.eventStat(getContext(), "kantie_4", null);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChosenPostActivityConfig(getContext())));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i <= 1 || !this.cJP) {
            if (this.cJF.getVisibility() != 8) {
                this.cJF.setVisibility(8);
                return;
            }
            return;
        }
        Object item = this.cJG.getItem(i - this.aJj.getHeaderViewsCount());
        if (item instanceof String) {
            this.cJF.setText((String) item);
            this.cJF.setVisibility(0);
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.i) {
            this.cJF.setVisibility(0);
            this.cJF.setText(((com.baidu.tieba.recommendfrs.data.i) item).aqX());
        }
        if (this.cJG.getItem(this.aJj.pointToPosition(0, this.cJF.getBottom() + 5) - this.aJj.getHeaderViewsCount()) instanceof String) {
            fQ(true);
        } else {
            fQ(false);
        }
    }

    private void fQ(boolean z) {
        View childAt = this.aJj.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() + this.cJJ : 0;
        if (z && bottom < this.cJI) {
            this.cJF.layout(0, bottom - this.cJI, this.cJH, bottom);
        } else {
            this.cJF.layout(0, 0, this.cJH, this.cJI);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && k.je() && !this.aTe) {
            this.aTe = true;
            this.aXe.startLoadData();
            if (this.cJL != null) {
                if (this.cJG == null) {
                    this.cJL.b(0, this.cJO, 0);
                    return;
                }
                com.baidu.tieba.recommendfrs.data.b aqr = this.cJG.aqr();
                if (aqr != null) {
                    this.cJL.b(aqr.aqF(), this.cJO, aqr.aqA());
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.pageContext, this);
        an.d(this, i.c.cp_bg_line_d, i);
        if (this.cJG != null) {
            this.cJG.a(this.pageContext, i);
        }
        if (this.cJE != null) {
            this.cJE.e(this.pageContext);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aXe != null) {
            this.aXe.cN(i);
        }
    }

    public boolean la(String str) {
        return TextUtils.equals(str, this.cJO);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cJN != null) {
            this.cJN.Y(this.cJO, this.aJj.getFirstVisiblePosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements p.a {
        private a() {
        }

        /* synthetic */ a(d dVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.p.a
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(d.this.getContext(), "kantie_update", null);
            if (d.this.cJL != null) {
                d.this.startLoad();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cJM == null) {
            if (i < 0) {
                this.cJM = new f(getContext());
            } else {
                this.cJM = new f(getContext(), i);
            }
            this.cJM.tc();
        }
        this.cJM.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.cJG != null) {
            this.cJG.br(false);
            this.cJG.notifyDataSetChanged();
        }
    }

    private void ao(View view) {
        if (this.cJM != null) {
            this.cJM.u(view);
            this.cJM = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.cJG != null) {
            this.cJG.br(true);
            this.cJG.notifyDataSetChanged();
        }
    }
}
