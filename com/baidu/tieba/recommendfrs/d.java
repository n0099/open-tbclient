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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.c.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChosenPostActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabRootView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.a.l;
import com.baidu.tieba.tbadkCore.util.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends FragmentTabRootView implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, BdListView.e {
    private BdListView aKZ;
    private boolean aLg;
    private boolean aLh;
    private boolean aTB;
    private PbListView aXu;
    private int csA;
    private l csn;
    private TextView cso;
    private FrameLayout csp;
    private c csq;
    private int csr;
    private int css;
    private int cst;
    private long csu;
    private com.baidu.tieba.recommendfrs.a csv;
    private f csw;
    private b csx;
    private String csy;
    private boolean csz;
    private boolean mHasMore;
    private z mPullView;
    private TbPageContext<?> pageContext;

    public d(Context context) {
        super(context);
        this.csr = 0;
        this.css = 0;
        this.cst = 0;
        this.csz = false;
        init(context);
    }

    private void init(Context context) {
        h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        setOrientation(1);
        g(context, LayoutInflater.from(context).inflate(i.g.recommend_frs_activity, this));
        this.csq = new c(this.pageContext, null);
        this.aKZ.setAdapter((ListAdapter) this.csq);
        this.csr = k.K(context);
        this.css = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.cst = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20);
        this.csA = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.recommendfrs.a aVar) {
        this.csv = aVar;
    }

    public void setScrollCallback(b bVar) {
        this.csx = bVar;
    }

    public void ajo() {
        this.csu = System.currentTimeMillis();
        TiebaStatic.eventStat(getContext(), "kantie_entry", null);
        if (!this.aLh) {
            if (this.aLg && !k.jf()) {
                if (this.csq.Dq() <= 0) {
                    this.csq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.csA), NoDataViewFactory.d.cD(i.C0057i.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    this.csq.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a((View) this.csp, false, getResources().getDimensionPixelSize(i.d.ds300));
            startLoad();
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.csu) / 1000));
        }
    }

    private void g(Context context, View view) {
        this.csp = (FrameLayout) view.findViewById(i.f.content_root);
        this.cso = (TextView) view.findViewById(i.f.time);
        this.cso.setVisibility(8);
        this.aKZ = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new z(this.pageContext);
        this.aKZ.setPullRefresh(this.mPullView);
        this.aXu = new PbListView(context);
        this.aXu.nq();
        this.aXu.cG(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.aKZ.setOnSrollToBottomListener(this);
        this.aKZ.setOnItemClickListener(this);
        this.aKZ.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.e eVar, boolean z) {
        if (this.aKZ != null) {
            this.aKZ.completePullRefresh();
        }
        if (this.aXu != null) {
            this.aXu.vB();
        }
        if (eVar == null) {
            af(this.csp);
            this.csq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.csA), NoDataViewFactory.d.cD(i.C0057i.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.csq.notifyDataSetChanged();
            return;
        }
        this.aTB = false;
        this.aLh = eVar.ajH();
        this.aLg = eVar.ajG();
        this.csy = eVar.getTag();
        this.csz = eVar.ajE();
        setHasMore(eVar.hasMore());
        bd(eVar.ajJ());
        List<Object> ajI = eVar.ajI();
        if (this.csq != null) {
            if (ajI == null || ajI.size() <= 0) {
                if (this.aLg && this.aLh) {
                    this.csq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.csA), NoDataViewFactory.d.cD(i.C0057i.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                } else {
                    this.csq.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
            }
            this.csq.r(ajI);
        }
        if (z) {
            this.aKZ.setSelection(eVar.ajF());
        }
        if (this.aLh || (ajI != null && !ajI.isEmpty())) {
            af(this.csp);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.aKZ != null) {
            if (this.mHasMore) {
                if (this.aXu != null && this.aXu.getView().getParent() == null) {
                    this.aKZ.setNextPage(this.aXu);
                    return;
                }
                return;
            }
            this.aKZ.setNextPage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.aLg) {
            this.csv.b(0, this.csy, 0);
        } else {
            this.csv.jP(this.csy);
        }
    }

    public void V(String str, int i) {
        if (this.aKZ != null) {
            this.aKZ.completePullRefresh();
        }
        this.aTB = false;
        this.aXu.vB();
        if (this.csq.Dq() <= 0 && this.aLg) {
            this.csq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.csA), NoDataViewFactory.d.dr(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.csq.r(new ArrayList());
        }
        af(this.csp);
    }

    private void bd(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list == null || list.isEmpty()) {
            if (this.csn != null) {
                this.aKZ.removeHeaderView(this.csn.getView());
                this.csn = null;
                return;
            }
            return;
        }
        if (this.csn == null) {
            ajp();
            this.aKZ.addHeaderView(this.csn.getView());
        }
        this.csn.setTitle(UtilHelper.getFixedText(list.get(0).ajt(), 14, true));
        this.csn.setData(list);
    }

    private void ajp() {
        this.csn = new l(getContext());
        this.csn.e(this.pageContext);
        this.csn.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, String str2) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), com.baidu.adp.lib.g.b.c(str, 0L), str2)));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v13 long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.csq.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            String str = (bVar.ajA() == null || bVar.ajA().isEmpty()) ? null : bVar.ajA().get(0);
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(bVar.ajz()));
            aX(String.valueOf(bVar.ajz()), str);
            m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.kE(String.valueOf(bVar.ajz()))) {
                readThreadHistory.kD(String.valueOf(bVar.ajz()));
                this.csq.z(item);
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            TiebaStatic.eventStat(getContext(), "kantie_3", null);
            long longValue = ((com.baidu.tieba.recommendfrs.data.c) item).ajD().thread_id.longValue();
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(longValue));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(new StringBuilder().append(longValue).toString(), null, "")));
        } else if ((item instanceof com.baidu.tieba.recommendfrs.data.d) && ((com.baidu.tieba.recommendfrs.data.d) item).getType() == "text_type_check_more" && bb.ah(getContext())) {
            TiebaStatic.eventStat(getContext(), "kantie_4", null);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChosenPostActivityConfig(getContext())));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i <= 1 || !this.csz) {
            if (this.cso.getVisibility() != 8) {
                this.cso.setVisibility(8);
                return;
            }
            return;
        }
        Object item = this.csq.getItem(i - this.aKZ.getHeaderViewsCount());
        if (item instanceof String) {
            this.cso.setText((String) item);
            this.cso.setVisibility(0);
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.i) {
            this.cso.setVisibility(0);
            this.cso.setText(((com.baidu.tieba.recommendfrs.data.i) item).ajR());
        }
        if (this.csq.getItem(this.aKZ.pointToPosition(0, this.cso.getBottom() + 5) - this.aKZ.getHeaderViewsCount()) instanceof String) {
            eQ(true);
        } else {
            eQ(false);
        }
    }

    private void eQ(boolean z) {
        View childAt = this.aKZ.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() + this.cst : 0;
        if (z && bottom < this.css) {
            this.cso.layout(0, bottom - this.css, this.csr, bottom);
        } else {
            this.cso.layout(0, 0, this.csr, this.css);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && k.jf() && !this.aTB) {
            this.aTB = true;
            this.aXu.startLoadData();
            if (this.csv != null) {
                if (this.csq == null) {
                    this.csv.b(0, this.csy, 0);
                    return;
                }
                com.baidu.tieba.recommendfrs.data.b ajn = this.csq.ajn();
                if (ajn != null) {
                    this.csv.b(ajn.ajB(), this.csy, ajn.ajw());
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.pageContext, this);
        al.d(this, i.c.cp_bg_line_d, i);
        if (this.csq != null) {
            this.csq.a(this.pageContext, i);
        }
        if (this.csn != null) {
            this.csn.e(this.pageContext);
        }
        if (this.mPullView != null) {
            this.mPullView.cG(i);
        }
        if (this.aXu != null) {
            this.aXu.cG(i);
        }
    }

    public boolean jQ(String str) {
        return TextUtils.equals(str, this.csy);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.csx != null) {
            this.csx.U(this.csy, this.aKZ.getFirstVisiblePosition());
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
            if (d.this.csv != null) {
                d.this.startLoad();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.csw == null) {
            if (i < 0) {
                this.csw = new f(getContext());
            } else {
                this.csw = new f(getContext(), i);
            }
            this.csw.ta();
        }
        this.csw.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.csq != null) {
            this.csq.bj(false);
            this.csq.notifyDataSetChanged();
        }
    }

    private void af(View view) {
        if (this.csw != null) {
            this.csw.u(view);
            this.csw = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.csq != null) {
            this.csq.bj(true);
            this.csq.notifyDataSetChanged();
        }
    }
}
