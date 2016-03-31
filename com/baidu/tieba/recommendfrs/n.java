package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.x;
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
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class n extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private BdUniqueId aSu;
    private int ant;
    private PbListView bcf;
    private boolean bjs;
    private boolean cFH;
    private boolean cFI;
    private com.baidu.tbadk.f.f cFK;
    private boolean cFO;
    private CustomMessageListener cFP;
    private com.baidu.tieba.recommendfrs.personalize.a.ad dUZ;
    private BdTypeListView dVh;
    private m dVi;
    private long dVj;
    private b dVk;
    private d dVl;
    private TagInfo dVm;
    private com.baidu.tieba.recommendfrs.data.l dVn;
    private com.baidu.tbadk.performanceLog.m dVo;
    private boolean mHasMore;
    private com.baidu.tbadk.core.view.u mPullView;
    private TbPageContext<?> pageContext;

    public n(Context context) {
        super(context);
        this.cFO = false;
        this.dVo = null;
        this.cFP = new o(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        i(context, LayoutInflater.from(context).inflate(t.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.dVi = new m(this.pageContext, viewEventCenter);
        this.dVh.setAdapter((ListAdapter) this.dVi);
        this.ant = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aSu = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cFP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFP);
        }
    }

    public void setCallback(b bVar) {
        this.dVk = bVar;
    }

    public void setScrollCallback(d dVar) {
        this.dVl = dVar;
    }

    public void anC() {
        com.baidu.tieba.recommendfrs.a.aLJ().q(System.currentTimeMillis(), getLogType());
        this.dVj = System.currentTimeMillis();
        if (this.dVm != null && !StringUtils.isNull(this.dVm.tag_name)) {
            TiebaStatic.log(new aw("kantie_1").ac("obj_name", this.dVm.tag_name));
        }
        if (this.cFI && this.dVn != null && this.dVn.aMg() != null && this.dVn.aMg().size() > 0) {
            if (this.dVn.getDataType() == 1) {
                this.dVi.notifyDataSetChanged();
            } else {
                this.dUZ.notifyDataSetChanged();
            }
        } else if (this.cFH && !com.baidu.adp.lib.util.k.jw()) {
            if (this.dVi.Ga() <= 0) {
                this.dVi.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ant), NoDataViewFactory.d.dg(t.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.dVi.notifyDataSetChanged();
            }
        } else {
            if (this.cFO) {
                this.cFO = false;
                com.baidu.adp.lib.h.h.hx().postDelayed(new p(this), 200L);
            } else {
                anD();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.dVj) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        a((View) this, false, getResources().getDimensionPixelSize(t.e.ds300));
        aiC();
    }

    private void i(Context context, View view) {
        this.dVh = (BdTypeListView) view.findViewById(t.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.u(this.pageContext);
        this.dVh.setPullRefresh(this.mPullView);
        this.bcf = new PbListView(context);
        this.bcf.mZ();
        this.bcf.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bcf.dj(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.dVh.setOnSrollToBottomListener(this);
        this.dVh.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.l lVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dVh != null) {
            this.dVh.nj();
        }
        if (this.bcf != null) {
            this.bcf.xv();
        }
        if (lVar == null) {
            ox(1);
            aD(this);
            this.dVi.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ant), NoDataViewFactory.d.dg(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dVi.notifyDataSetChanged();
            com.baidu.tieba.recommendfrs.a.aLJ().r(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.dVn = lVar;
        this.bjs = false;
        this.cFI = lVar.anY();
        this.cFH = lVar.anX();
        this.dVm = lVar.aMf();
        setHasMore(lVar.hasMore());
        List<Object> aMg = lVar.aMg();
        if (this.dVi != null) {
            if (aMg == null || aMg.size() <= 0) {
                if (!z2) {
                    ox(1);
                }
                if (this.cFH && this.cFI) {
                    this.dVi.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ant), NoDataViewFactory.d.dg(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.dVi.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.dVi.x(aMg);
                this.dVi.notifyDataSetChanged();
            } else if (lVar.getDataType() == 1) {
                if (!z2) {
                    ox(lVar.getDataType());
                }
                this.dVi.x(aMg);
            } else if (lVar.getDataType() == 2) {
                if (this.dUZ == null) {
                    this.dUZ = new com.baidu.tieba.recommendfrs.personalize.a.ad(getContext(), this.dVh);
                    this.dUZ.setPageUniqueId(this.aSu);
                    aLO();
                } else if (!z2) {
                    ox(lVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : aMg) {
                    if (obj instanceof com.baidu.adp.widget.ListView.u) {
                        arrayList.add((com.baidu.adp.widget.ListView.u) obj);
                    }
                }
                this.dUZ.cm(arrayList);
            }
            if (this.dVm != null && !StringUtils.isNull(this.dVm.tag_name) && com.baidu.tbadk.core.util.y.p(aMg) > 0) {
                TiebaStatic.log(new aw("kantie_1").ac("obj_name", this.dVm.tag_name));
            }
            com.baidu.tieba.recommendfrs.a.aLJ().r(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.dVh.setSelection(lVar.anW());
        }
        if (this.cFI || (aMg != null && !aMg.isEmpty())) {
            aD(this);
        }
        if (!z) {
            aLP();
        }
    }

    public void hX(boolean z) {
        if (this.dVh != null) {
            if (!z || this.dVn == null || this.dVn.aMg() == null || this.dVn.aMg().size() <= 0) {
                this.dVh.setSelection(0);
                this.dVh.nk();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.dVh != null && this.bcf != null) {
            if (this.bcf.getView().getParent() == null) {
                this.dVh.setNextPage(this.bcf);
            }
            if (this.mHasMore) {
                this.bcf.xx();
            } else {
                this.bcf.dl(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds140));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        int logType = getLogType();
        if (com.baidu.tieba.recommendfrs.a.aLJ().ow(logType) == -1) {
            com.baidu.tieba.recommendfrs.a.aLJ().t(System.currentTimeMillis(), logType);
        }
        if (this.cFH) {
            this.dVk.b(1, this.dVm.tag_code.longValue(), 0L);
        } else {
            this.dVk.bP(this.dVm.tag_code.longValue());
        }
    }

    public void ai(String str, int i) {
        int i2 = 0;
        if (this.dVh != null) {
            this.dVh.nj();
        }
        this.bjs = false;
        this.bcf.xv();
        if (this.dVn != null && this.dVn.aMg() != null) {
            i2 = this.dVn.aMg().size();
        }
        if (i2 <= 0 && (this.cFH || i == -53)) {
            ox(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m411getInst().getString(t.j.neterror);
            }
            this.dVi.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ant), NoDataViewFactory.d.dS(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dVi.x(new ArrayList());
        }
        aD(this);
        aLP();
    }

    private void r(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void nt(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(str, null, null)));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cl("from_frs").bC(18003).qT()));
            TiebaStatic.log("c10258");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.jw() && !this.bjs) {
            this.bjs = true;
            this.bcf.xu();
            if (this.dVk != null) {
                if (this.dVn == null || this.dVn.getDataType() == 1) {
                    if (this.dVi == null) {
                        this.dVk.b(1, this.dVm.tag_code.longValue(), 0L);
                        return;
                    }
                    com.baidu.tieba.recommendfrs.data.p aLM = this.dVi.aLM();
                    if (aLM != null) {
                        this.dVk.b(this.dVn != null ? this.dVn.getPn() + 1 : 1, this.dVm.tag_code.longValue(), aLM.aMl());
                    }
                } else if (this.dVn.getDataType() == 2) {
                    int pn = this.dVn.getPn() + 1;
                    aLN();
                    this.dVk.b(pn, this.dVm.tag_code.longValue(), this.dVn.aMh());
                }
            }
        }
    }

    private void aLN() {
        if (this.dVn != null && this.dVn.getDataType() == 2 && this.dVn.aMg() != null && this.dVn.aMg().size() >= TbadkCoreApplication.m411getInst().getListItemRule().yH() - 30) {
            int yI = TbadkCoreApplication.m411getInst().getListItemRule().yI();
            if (yI < 0) {
                yI = 0;
            }
            ArrayList arrayList = new ArrayList(this.dVn.aMg());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= yI && i < yI + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= yI + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.dVn.ck(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.adp.widget.ListView.u) {
                    arrayList3.add((com.baidu.adp.widget.ListView.u) next);
                }
            }
            this.dUZ.cm(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        at.d(this, t.d.cp_bg_line_d, i);
        if (this.dVn == null || this.dVn.getDataType() == 1) {
            if (this.dVi != null) {
                this.dVi.a(this.pageContext, i);
            }
        } else if (this.dVn.getDataType() == 2 && this.dUZ != null) {
            this.dUZ.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.bcf != null) {
            this.bcf.setTextColor(at.getColor(t.d.cp_cont_d));
            this.bcf.dj(i);
        }
    }

    public boolean bS(long j) {
        return this.dVm != null && j == this.dVm.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.dVl != null && this.dVm != null) {
            this.dVl.u(this.dVm.tag_code.longValue(), this.dVh.getFirstVisiblePosition());
        }
        if (this.dVo == null) {
            this.dVo = new com.baidu.tbadk.performanceLog.m();
            this.dVo.fh(1005);
        }
        this.dVo.pageType = getLogType();
        this.dVo.GB();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Fr();
        com.baidu.tbadk.mvc.b.a Fs = bVar.Fs();
        if (this.dVn == null || this.dVn.getDataType() == 1) {
            if (Fs instanceof com.baidu.tieba.recommendfrs.data.p) {
                com.baidu.tieba.recommendfrs.data.p pVar = (com.baidu.tieba.recommendfrs.data.p) Fs;
                int i = 0;
                while (true) {
                    if (i < this.dVi.getCount()) {
                        com.baidu.tieba.recommendfrs.data.p pVar2 = (com.baidu.tieba.recommendfrs.data.p) this.dVi.getItem(i);
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
                if (pVar.aMp() != null && !pVar.aMp().isEmpty()) {
                    str = pVar.aMp().get(0);
                }
                if (pVar.aMq() == 33) {
                    b(pVar.aMr());
                } else if (pVar.aMs() == 1) {
                    r(pVar.aMo(), str);
                    TiebaStatic.log(new aw("kantie_card").ac("obj_name", pVar.dWN).r("obj_type", 1).r("obj_locate", i).ac("obj_source", pVar.dXd).r("obj_param1", 1).ac("abtest", pVar.abtest));
                } else if (pVar.aMs() == 3) {
                    nt(new StringBuilder(String.valueOf(pVar.getThreadId())).toString());
                    TiebaStatic.log(new aw("kantie_card").ac("obj_name", pVar.dWN).r("obj_type", 2).r("obj_locate", i).ac("obj_source", pVar.dXd).r("obj_param1", 1).ac("abtest", pVar.abtest));
                }
                com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.oh(String.valueOf(pVar.getThreadId()))) {
                    readThreadHistory.og(String.valueOf(pVar.getThreadId()));
                    this.dVi.A(Fs);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oB() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements s.a {
        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.s.a
        public void aB(boolean z) {
            TiebaStatic.eventStat(n.this.getContext(), "kantie_update", null);
            if (n.this.dVk != null) {
                n.this.aiC();
                if (com.baidu.tieba.recommendfrs.control.a.q.aMe().cxD == com.baidu.tieba.recommendfrs.control.a.q.aMe().dWy) {
                    com.baidu.tieba.recommendfrs.control.a.q.aMe().dWz = 0;
                    com.baidu.tieba.recommendfrs.control.a.t.oz(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cFK == null) {
            if (i < 0) {
                this.cFK = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.cFK = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.cFK.uA();
        }
        this.cFK.c(view, z);
        if (this.mPullView != null) {
            this.mPullView.Q(false);
        }
        if (this.dVi != null) {
            ox(1);
            this.dVi.bG(false);
            this.dVi.notifyDataSetChanged();
        }
    }

    private void aD(View view) {
        if (this.cFK != null) {
            this.cFK.K(view);
            this.cFK = null;
        }
        if (this.mPullView != null) {
            this.mPullView.Q(true);
        }
        if (this.dVi != null) {
            this.dVi.bG(true);
            this.dVi.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.dVo != null) {
            this.dVo.onDestroy();
        }
    }

    public void aLL() {
    }

    private void ox(int i) {
        if (i == 1) {
            if ((this.dVh.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.dVh.getAdapter()).getWrappedAdapter() instanceof m)) {
                this.dVh.setAdapter((ListAdapter) this.dVi);
                aLO();
            }
        } else if (i == 2 && (this.dVh.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.dVh.getAdapter()).getWrappedAdapter() instanceof com.baidu.adp.widget.ListView.x)) {
            this.dVh.a((com.baidu.adp.widget.ListView.a<com.baidu.adp.widget.ListView.u, x.a>) null);
            aLO();
        }
    }

    private void aLO() {
        this.dVh.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new com.baidu.tbadk.core.view.u(this.pageContext);
        this.dVh.setPullRefresh(this.mPullView);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aSu);
    }

    private void aLP() {
        int logType = getLogType();
        long ow = com.baidu.tieba.recommendfrs.a.aLJ().ow(logType);
        if (ow > 0) {
            com.baidu.tieba.recommendfrs.a.aLJ().s(System.currentTimeMillis() - ow, logType);
            com.baidu.tieba.recommendfrs.a.aLJ().t(0L, logType);
        }
    }

    private int getLogType() {
        if (this.dVm == null) {
            return 2;
        }
        return this.dVm.tag_type.intValue();
    }
}
