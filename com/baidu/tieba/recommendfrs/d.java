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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
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
    private BdListView aKe;
    private boolean aKl;
    private boolean aKm;
    private boolean aSL;
    private PbListView aWL;
    private int ajj;
    private m cHJ;
    private TextView cHK;
    private c cHL;
    private int cHM;
    private int cHN;
    private int cHO;
    private long cHP;
    private com.baidu.tieba.recommendfrs.a cHQ;
    private f cHR;
    private b cHS;
    private String cHT;
    private boolean cHU;
    private boolean mHasMore;
    private r mPullView;
    private TbPageContext<?> pageContext;

    public d(Context context) {
        super(context);
        this.cHM = 0;
        this.cHN = 0;
        this.cHO = 0;
        this.cHU = false;
        init(context);
    }

    private void init(Context context) {
        h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        g(context, LayoutInflater.from(context).inflate(i.g.recommend_frs_activity, this));
        this.cHL = new c(this.pageContext, null);
        this.aKe.setAdapter((ListAdapter) this.cHL);
        this.cHM = k.K(context);
        this.cHN = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.cHO = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20);
        this.ajj = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.recommendfrs.a aVar) {
        this.cHQ = aVar;
    }

    public void setScrollCallback(b bVar) {
        this.cHS = bVar;
    }

    public void apK() {
        this.cHP = System.currentTimeMillis();
        if (!this.aKm) {
            if (this.aKl && !k.jd()) {
                if (this.cHL.Dn() <= 0) {
                    this.cHL.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajj), NoDataViewFactory.d.cK(i.h.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    this.cHL.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a((View) this, false, getResources().getDimensionPixelSize(i.d.ds300));
            startLoad();
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cHP) / 1000));
        }
    }

    private void g(Context context, View view) {
        this.cHK = (TextView) view.findViewById(i.f.time);
        this.cHK.setVisibility(8);
        this.aKe = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new r(this.pageContext);
        this.aKe.setPullRefresh(this.mPullView);
        this.aWL = new PbListView(context);
        this.aWL.no();
        this.aWL.cN(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.aKe.setOnSrollToBottomListener(this);
        this.aKe.setOnItemClickListener(this);
        this.aKe.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.e eVar, boolean z) {
        if (this.aKe != null) {
            this.aKe.completePullRefresh();
        }
        if (this.aWL != null) {
            this.aWL.vy();
        }
        if (eVar == null) {
            ap(this);
            this.cHL.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajj), NoDataViewFactory.d.cK(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cHL.notifyDataSetChanged();
            return;
        }
        this.aSL = false;
        this.aKm = eVar.aqf();
        this.aKl = eVar.aqe();
        this.cHT = eVar.getTag();
        this.cHU = eVar.aqc();
        setHasMore(eVar.hasMore());
        bn(eVar.aqh());
        List<Object> aqg = eVar.aqg();
        if (this.cHL != null) {
            if (aqg == null || aqg.size() <= 0) {
                if (this.aKl && this.aKm) {
                    this.cHL.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajj), NoDataViewFactory.d.cK(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                } else {
                    this.cHL.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
            }
            this.cHL.r(aqg);
        }
        if (z) {
            this.aKe.setSelection(eVar.aqd());
        }
        if (this.aKm || (aqg != null && !aqg.isEmpty())) {
            ap(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.aKe != null) {
            if (this.mHasMore) {
                if (this.aWL != null && this.aWL.getView().getParent() == null) {
                    this.aKe.setNextPage(this.aWL);
                    return;
                }
                return;
            }
            this.aKe.setNextPage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.aKl) {
            this.cHQ.b(0, this.cHT, 0);
        } else {
            this.cHQ.kS(this.cHT);
        }
    }

    public void Z(String str, int i) {
        if (this.aKe != null) {
            this.aKe.completePullRefresh();
        }
        this.aSL = false;
        this.aWL.vy();
        if (this.cHL.Dn() <= 0 && this.aKl) {
            this.cHL.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajj), NoDataViewFactory.d.dC(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cHL.r(new ArrayList());
        }
        ap(this);
    }

    private void bn(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list == null || list.isEmpty()) {
            if (this.cHJ != null) {
                this.aKe.removeHeaderView(this.cHJ.getView());
                this.cHJ = null;
                return;
            }
            return;
        }
        if (this.cHJ == null) {
            apL();
            this.aKe.addHeaderView(this.cHJ.getView());
        }
        this.cHJ.setTitle(UtilHelper.getFixedText(list.get(0).apP(), 14, true));
        this.cHJ.setData(list);
    }

    private void apL() {
        this.cHJ = new m(getContext());
        this.cHJ.e(this.pageContext);
        this.cHJ.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(String str, String str2) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), com.baidu.adp.lib.g.b.c(str, 0L), str2)));
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ch("from_frs").bs(18003).rk()));
            TiebaStatic.log("c10258");
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v13 long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.cHL.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            String str = (bVar.apW() == null || bVar.apW().isEmpty()) ? null : bVar.apW().get(0);
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(bVar.apV()));
            if (bVar.apZ() == 33) {
                a(bVar.aqa());
            } else {
                bb(String.valueOf(bVar.apV()), str);
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.lI(String.valueOf(bVar.apV()))) {
                readThreadHistory.lH(String.valueOf(bVar.apV()));
                this.cHL.A(item);
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            TiebaStatic.eventStat(getContext(), "kantie_3", null);
            long longValue = ((com.baidu.tieba.recommendfrs.data.c) item).aqb().thread_id.longValue();
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(longValue));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(new StringBuilder().append(longValue).toString(), null, "")));
        } else if ((item instanceof com.baidu.tieba.recommendfrs.data.d) && ((com.baidu.tieba.recommendfrs.data.d) item).getType() == "text_type_check_more" && bc.ah(getContext())) {
            TiebaStatic.eventStat(getContext(), "kantie_4", null);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChosenPostActivityConfig(getContext())));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i <= 1 || !this.cHU) {
            if (this.cHK.getVisibility() != 8) {
                this.cHK.setVisibility(8);
                return;
            }
            return;
        }
        Object item = this.cHL.getItem(i - this.aKe.getHeaderViewsCount());
        if (item instanceof String) {
            this.cHK.setText((String) item);
            this.cHK.setVisibility(0);
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.i) {
            this.cHK.setVisibility(0);
            this.cHK.setText(((com.baidu.tieba.recommendfrs.data.i) item).aqp());
        }
        if (this.cHL.getItem(this.aKe.pointToPosition(0, this.cHK.getBottom() + 5) - this.aKe.getHeaderViewsCount()) instanceof String) {
            fN(true);
        } else {
            fN(false);
        }
    }

    private void fN(boolean z) {
        View childAt = this.aKe.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() + this.cHO : 0;
        if (z && bottom < this.cHN) {
            this.cHK.layout(0, bottom - this.cHN, this.cHM, bottom);
        } else {
            this.cHK.layout(0, 0, this.cHM, this.cHN);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && k.jd() && !this.aSL) {
            this.aSL = true;
            this.aWL.startLoadData();
            if (this.cHQ != null) {
                if (this.cHL == null) {
                    this.cHQ.b(0, this.cHT, 0);
                    return;
                }
                com.baidu.tieba.recommendfrs.data.b apJ = this.cHL.apJ();
                if (apJ != null) {
                    this.cHQ.b(apJ.apX(), this.cHT, apJ.apS());
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.pageContext, this);
        am.d(this, i.c.cp_bg_line_d, i);
        if (this.cHL != null) {
            this.cHL.a(this.pageContext, i);
        }
        if (this.cHJ != null) {
            this.cHJ.e(this.pageContext);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aWL != null) {
            this.aWL.cN(i);
        }
    }

    public boolean kT(String str) {
        return TextUtils.equals(str, this.cHT);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cHS != null) {
            this.cHS.Y(this.cHT, this.aKe.getFirstVisiblePosition());
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
            if (d.this.cHQ != null) {
                d.this.startLoad();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cHR == null) {
            if (i < 0) {
                this.cHR = new f(getContext());
            } else {
                this.cHR = new f(getContext(), i);
            }
            this.cHR.tc();
        }
        this.cHR.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.cHL != null) {
            this.cHL.bo(false);
            this.cHL.notifyDataSetChanged();
        }
    }

    private void ap(View view) {
        if (this.cHR != null) {
            this.cHR.u(view);
            this.cHR = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.cHL != null) {
            this.cHL.bo(true);
            this.cHL.notifyDataSetChanged();
        }
    }
}
