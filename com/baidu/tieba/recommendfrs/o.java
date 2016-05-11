package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class o extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private BdUniqueId aOT;
    private int ajh;
    private boolean bfs;
    private PbListView bkd;
    private int bmL;
    private TextView bzI;
    private boolean cFA;
    private com.baidu.tbadk.f.f cFC;
    private boolean cFG;
    private CustomMessageListener cFH;
    private boolean cFz;
    private com.baidu.tieba.recommendfrs.personalize.a.ad dXR;
    private BdTypeListView dYa;
    private n dYb;
    private long dYc;
    private b dYd;
    private d dYe;
    private TagInfo dYf;
    private com.baidu.tieba.recommendfrs.data.l dYg;
    private int dYh;
    private com.baidu.tbadk.performanceLog.m dYi;
    public com.baidu.tieba.recommendfrs.control.m dYj;
    private boolean mHasMore;
    private com.baidu.tbadk.core.view.w mPullView;
    private TbPageContext<?> pageContext;

    public void a(com.baidu.tieba.recommendfrs.control.m mVar, View.OnTouchListener onTouchListener) {
        this.dYj = mVar;
        if (this.dYa != null) {
            this.dYa.setOnTouchListener(onTouchListener);
        }
    }

    public void RS() {
        if (this.dYj != null) {
            this.dYj.iN(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            on(i2);
        }
    }

    private void on(int i) {
        this.dYh = i;
        if (this.bzI != null) {
            ViewGroup.LayoutParams layoutParams = this.bzI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.bzI.setLayoutParams(layoutParams);
        }
    }

    public o(Context context) {
        super(context);
        this.cFG = false;
        this.dYi = null;
        this.bmL = 0;
        this.cFH = new p(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        g(context, LayoutInflater.from(context).inflate(t.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.dYb = new n(this.pageContext, viewEventCenter);
        this.dYa.setAdapter((ListAdapter) this.dYb);
        this.ajh = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aOT = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cFH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFH);
        }
    }

    public void setCallback(b bVar) {
        this.dYd = bVar;
    }

    public void setScrollCallback(d dVar) {
        this.dYe = dVar;
    }

    public void anz() {
        com.baidu.tieba.recommendfrs.a.aLN().r(System.currentTimeMillis(), getLogType());
        this.dYc = System.currentTimeMillis();
        if (this.dYf != null && !StringUtils.isNull(this.dYf.tag_name)) {
            TiebaStatic.log(new aw("kantie_1").ac("obj_name", this.dYf.tag_name));
        }
        if (this.cFA && this.dYg != null && this.dYg.aMr() != null && this.dYg.aMr().size() > 0) {
            if (this.dYg.getDataType() == 1) {
                this.dYb.notifyDataSetChanged();
            } else {
                this.dXR.notifyDataSetChanged();
            }
        } else if (this.cFz && !com.baidu.adp.lib.util.k.fH()) {
            if (this.dYb.DS() <= 0) {
                this.dYb.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajh), NoDataViewFactory.d.cP(t.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.dYb.notifyDataSetChanged();
            }
        } else {
            if (this.cFG) {
                this.cFG = false;
                com.baidu.adp.lib.h.h.dL().postDelayed(new q(this), 200L);
            } else {
                anA();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.dYc) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anA() {
        a((View) this, false, getResources().getDimensionPixelSize(t.e.ds520));
        aiJ();
    }

    private void g(Context context, View view) {
        this.dYa = (BdTypeListView) view.findViewById(t.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.w(this.pageContext);
        this.dYa.setPullRefresh(this.mPullView);
        this.bkd = new PbListView(context);
        this.bkd.jn();
        this.bkd.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bkd.cS(TbadkCoreApplication.m11getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.dYa.setOnSrollToBottomListener(this);
        this.dYa.setOnScrollListener(this);
        this.bzI = new TextView(context);
        on(this.dYh);
        this.dYa.f(this.bzI, 0);
    }

    public void a(com.baidu.tieba.recommendfrs.data.l lVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dYa != null) {
            this.dYa.k(2000L);
        }
        if (this.bkd != null) {
            this.bkd.vh();
        }
        if (lVar == null) {
            oo(1);
            aH(this);
            this.dYb.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajh), NoDataViewFactory.d.cP(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dYb.notifyDataSetChanged();
            com.baidu.tieba.recommendfrs.a.aLN().s(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.dYg = lVar;
        this.bfs = false;
        this.cFA = lVar.aob();
        this.cFz = lVar.aoa();
        this.dYf = lVar.aMq();
        setHasMore(lVar.hasMore());
        List<Object> aMr = lVar.aMr();
        if (this.dYb != null) {
            if (aMr == null || aMr.size() <= 0) {
                if (!z2) {
                    oo(1);
                }
                if (this.cFz && this.cFA) {
                    this.dYb.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajh), NoDataViewFactory.d.cP(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.dYb.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.dYb.z((List) aMr);
                this.dYb.notifyDataSetChanged();
            } else if (lVar.getDataType() == 1) {
                if (!z2) {
                    oo(lVar.getDataType());
                }
                this.dYb.z((List) aMr);
            } else if (lVar.getDataType() == 2) {
                if (this.dXR == null) {
                    this.dXR = new com.baidu.tieba.recommendfrs.personalize.a.ad(getContext(), this.dYa);
                    this.dXR.setPageUniqueId(this.aOT);
                    aLS();
                } else if (!z2) {
                    oo(lVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : aMr) {
                    if (obj instanceof com.baidu.adp.widget.ListView.v) {
                        arrayList.add((com.baidu.adp.widget.ListView.v) obj);
                    }
                }
                this.dXR.co(arrayList);
            }
            if (this.dYf != null && !StringUtils.isNull(this.dYf.tag_name) && com.baidu.tbadk.core.util.y.r(aMr) > 0) {
                TiebaStatic.log(new aw("kantie_1").ac("obj_name", this.dYf.tag_name));
            }
            com.baidu.tieba.recommendfrs.a.aLN().s(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.dYa.setSelection(lVar.anZ());
        }
        if (this.cFA || (aMr != null && !aMr.isEmpty())) {
            aH(this);
        }
        if (!z) {
            aLT();
        }
    }

    public void iH(boolean z) {
        if (this.dYa != null) {
            RS();
            if (!z || this.dYg == null || this.dYg.aMr() == null || this.dYg.aMr().size() <= 0) {
                this.dYa.setSelection(0);
                this.dYa.jy();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.dYa != null && this.bkd != null) {
            if (this.bkd.getView().getParent() == null) {
                this.dYa.setNextPage(this.bkd);
            }
            if (this.mHasMore) {
                this.bkd.vj();
                this.bkd.cT(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds110));
                return;
            }
            this.bkd.cU(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiJ() {
        int logType = getLogType();
        if (com.baidu.tieba.recommendfrs.a.aLN().om(logType) == -1) {
            com.baidu.tieba.recommendfrs.a.aLN().u(System.currentTimeMillis(), logType);
        }
        if (this.cFz) {
            this.dYd.b(1, this.dYf.tag_code.longValue(), 0L);
        } else {
            this.dYd.bP(this.dYf.tag_code.longValue());
        }
    }

    public void an(String str, int i) {
        int i2 = 0;
        if (this.dYa != null) {
            this.dYa.k(2000L);
        }
        this.bfs = false;
        this.bkd.vh();
        if (this.dYg != null && this.dYg.aMr() != null) {
            i2 = this.dYg.aMr().size();
        }
        if (i2 <= 0 && (this.cFz || i == -53)) {
            oo(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m11getInst().getString(t.j.neterror);
            }
            this.dYb.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajh), NoDataViewFactory.d.dP(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dYb.z((List) new ArrayList());
        }
        aH(this);
        aLT();
    }

    private void r(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void ns(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(str, null, null)));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cj("from_frs").bp(18003).oq()));
            TiebaStatic.log("c10258");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dYj != null) {
            this.dYj.a(absListView, this.bmL, i, i2, i3);
        }
        this.bmL = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.fH() && !this.bfs) {
            this.bfs = true;
            this.bkd.vg();
            if (this.dYd != null) {
                if (this.dYg == null || this.dYg.getDataType() == 1) {
                    if (this.dYb == null) {
                        this.dYd.b(1, this.dYf.tag_code.longValue(), 0L);
                        return;
                    }
                    com.baidu.tieba.recommendfrs.data.p aLQ = this.dYb.aLQ();
                    if (aLQ != null) {
                        this.dYd.b(this.dYg != null ? this.dYg.getPn() + 1 : 1, this.dYf.tag_code.longValue(), aLQ.aMw());
                    }
                } else if (this.dYg.getDataType() == 2) {
                    int pn = this.dYg.getPn() + 1;
                    aLR();
                    this.dYd.b(pn, this.dYf.tag_code.longValue(), this.dYg.aMs());
                }
            }
        }
    }

    private void aLR() {
        if (this.dYg != null && this.dYg.getDataType() == 2 && this.dYg.aMr() != null && this.dYg.aMr().size() >= TbadkCoreApplication.m11getInst().getListItemRule().wA() - 30) {
            int wB = TbadkCoreApplication.m11getInst().getListItemRule().wB();
            if (wB < 0) {
                wB = 0;
            }
            ArrayList arrayList = new ArrayList(this.dYg.aMr());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= wB && i < wB + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= wB + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.dYg.cm(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.adp.widget.ListView.v) {
                    arrayList3.add((com.baidu.adp.widget.ListView.v) next);
                }
            }
            this.dXR.co(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        at.e(this, t.d.cp_bg_line_d, i);
        if (this.dYg == null || this.dYg.getDataType() == 1) {
            if (this.dYb != null) {
                this.dYb.a(this.pageContext, i);
            }
        } else if (this.dYg.getDataType() == 2 && this.dXR != null) {
            this.dXR.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.cS(i);
        }
        if (this.bkd != null) {
            this.bkd.setTextColor(at.getColor(t.d.cp_cont_d));
            this.bkd.cS(i);
        }
    }

    public boolean bS(long j) {
        return this.dYf != null && j == this.dYf.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.dYe != null && this.dYf != null) {
            this.dYe.v(this.dYf.tag_code.longValue(), this.dYa.getFirstVisiblePosition());
        }
        if (this.dYj != null) {
            this.dYj.onScrollStateChanged(absListView, i);
        }
        if (this.dYi == null) {
            this.dYi = new com.baidu.tbadk.performanceLog.m();
            this.dYi.eM(1005);
        }
        this.dYi.pageType = getLogType();
        this.dYi.Et();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Dj();
        com.baidu.tbadk.mvc.b.a Dk = bVar.Dk();
        if (this.dYg == null || this.dYg.getDataType() == 1) {
            if (Dk instanceof com.baidu.tieba.recommendfrs.data.p) {
                com.baidu.tieba.recommendfrs.data.p pVar = (com.baidu.tieba.recommendfrs.data.p) Dk;
                int i = 0;
                while (true) {
                    if (i < this.dYb.getCount()) {
                        com.baidu.tieba.recommendfrs.data.p pVar2 = (com.baidu.tieba.recommendfrs.data.p) this.dYb.getItem(i);
                        if (pVar2 != null && pVar2.getThreadId() == pVar.getThreadId()) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                String str = null;
                if (pVar.aMA() != null && !pVar.aMA().isEmpty()) {
                    str = pVar.aMA().get(0);
                }
                if (pVar.aMB() == 33) {
                    b(pVar.aMC());
                } else if (pVar.aMD() == 1) {
                    r(pVar.aMz(), str);
                    TiebaStatic.log(new aw("kantie_card").ac("obj_name", pVar.dZX).s("obj_type", 1).s("obj_locate", i).ac("obj_source", pVar.eam).s("obj_param1", 1).ac("abtest", pVar.abtest));
                } else if (pVar.aMD() == 3) {
                    ns(new StringBuilder(String.valueOf(pVar.getThreadId())).toString());
                    TiebaStatic.log(new aw("kantie_card").ac("obj_name", pVar.dZX).s("obj_type", 2).s("obj_locate", i).ac("obj_source", pVar.eam).s("obj_param1", 1).ac("abtest", pVar.abtest));
                }
                com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.od(String.valueOf(pVar.getThreadId()))) {
                    readThreadHistory.oc(String.valueOf(pVar.getThreadId()));
                    this.dYb.A((n) Dk);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kO() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements t.b {
        private a() {
        }

        /* synthetic */ a(o oVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.t.b
        public void aG(boolean z) {
            TiebaStatic.eventStat(o.this.getContext(), "kantie_update", null);
            if (o.this.dYd != null) {
                o.this.aiJ();
                if (com.baidu.tieba.recommendfrs.control.a.q.aMp().cyC == com.baidu.tieba.recommendfrs.control.a.q.aMp().dZI) {
                    com.baidu.tieba.recommendfrs.control.a.q.aMp().dZJ = 0;
                    com.baidu.tieba.recommendfrs.control.a.t.or(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cFC == null) {
            if (i < 0) {
                this.cFC = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.cFC = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.cFC.sf();
        }
        this.cFC.c(view, z);
        if (this.mPullView != null) {
            this.mPullView.Q(false);
        }
        if (this.dYb != null) {
            oo(1);
            this.dYb.bM(false);
            this.dYb.notifyDataSetChanged();
        }
    }

    private void aH(View view) {
        if (this.cFC != null) {
            this.cFC.L(view);
            this.cFC = null;
        }
        if (this.mPullView != null) {
            this.mPullView.Q(true);
        }
        if (this.dYb != null) {
            this.dYb.bM(true);
            this.dYb.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.dYi != null) {
            this.dYi.onDestroy();
        }
    }

    public void aLP() {
    }

    private void oo(int i) {
        if (i == 1) {
            if ((this.dYa.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.dYa.getAdapter()).getWrappedAdapter() instanceof n)) {
                this.dYa.setAdapter((ListAdapter) this.dYb);
                aLS();
            }
        } else if (i == 2 && (this.dYa.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.dYa.getAdapter()).getWrappedAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            this.dYa.a((com.baidu.adp.widget.ListView.a<com.baidu.adp.widget.ListView.v, y.a>) null);
            aLS();
        }
    }

    private void aLS() {
        this.dYa.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new com.baidu.tbadk.core.view.w(this.pageContext);
        this.dYa.setPullRefresh(this.mPullView);
        this.dYa.removeHeaderView(this.bzI);
        this.bzI = new TextView(this.pageContext.getPageActivity());
        on(this.dYh);
        this.dYa.f(this.bzI, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aOT);
    }

    private void aLT() {
        int logType = getLogType();
        long om = com.baidu.tieba.recommendfrs.a.aLN().om(logType);
        if (om > 0) {
            com.baidu.tieba.recommendfrs.a.aLN().t(System.currentTimeMillis() - om, logType);
            com.baidu.tieba.recommendfrs.a.aLN().u(0L, logType);
        }
    }

    private int getLogType() {
        if (this.dYf == null) {
            return 2;
        }
        return this.dYf.tag_type.intValue();
    }

    public void jx() {
        if (this.dYa != null) {
            this.dYa.jx();
        }
    }
}
