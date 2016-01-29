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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class m extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private BdUniqueId aPF;
    private PbListView aXw;
    private int anc;
    private boolean beG;
    private com.baidu.tieba.recommendfrs.personalize.a.l dDf;
    private BdTypeListView dDn;
    private l dDo;
    private boolean dDp;
    private boolean dDq;
    private long dDr;
    private b dDs;
    private d dDt;
    private TagInfo dDu;
    private com.baidu.tieba.recommendfrs.data.h dDv;
    private boolean dDw;
    private com.baidu.tbadk.performanceLog.m dDx;
    private CustomMessageListener dDy;
    private com.baidu.tbadk.f.f dig;
    private boolean mHasMore;
    private com.baidu.tbadk.core.view.t mPullView;
    private TbPageContext<?> pageContext;

    public m(Context context) {
        super(context);
        this.dDw = false;
        this.dDx = null;
        this.dDy = new n(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        i(context, LayoutInflater.from(context).inflate(t.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.dDo = new l(this.pageContext, viewEventCenter);
        this.dDn.setAdapter((ListAdapter) this.dDo);
        this.anc = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aPF = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.dDy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dDy);
        }
    }

    public void setCallback(b bVar) {
        this.dDs = bVar;
    }

    public void setScrollCallback(d dVar) {
        this.dDt = dVar;
    }

    public void aEU() {
        int i = 2;
        if (this.dDv != null && this.dDv.getDataType() != 1) {
            i = this.dDv.getDataType() == 2 ? 3 : 0;
        }
        com.baidu.tieba.recommendfrs.a.aER().e(System.currentTimeMillis(), i);
        this.dDr = System.currentTimeMillis();
        if (this.dDu != null && !StringUtils.isNull(this.dDu.tag_name)) {
            TiebaStatic.log(new au("kantie_1").aa("obj_name", this.dDu.tag_name));
        }
        if (this.dDq && this.dDv != null && this.dDv.aFs() != null && this.dDv.aFs().size() > 0) {
            if (this.dDv.getDataType() == 1) {
                this.dDo.notifyDataSetChanged();
            } else {
                this.dDf.notifyDataSetChanged();
            }
        } else if (this.dDp && !com.baidu.adp.lib.util.k.jq()) {
            if (this.dDo.Fn() <= 0) {
                this.dDo.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anc), NoDataViewFactory.d.dd(t.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.dDo.notifyDataSetChanged();
            }
        } else {
            if (this.dDw) {
                this.dDw = false;
                com.baidu.adp.lib.h.h.hr().postDelayed(new o(this), 200L);
            } else {
                aEY();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.dDr) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEY() {
        a((View) this, false, getResources().getDimensionPixelSize(t.e.ds300));
        startLoad();
    }

    private void i(Context context, View view) {
        this.dDn = (BdTypeListView) view.findViewById(t.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.pageContext);
        this.dDn.setPullRefresh(this.mPullView);
        this.aXw = new PbListView(context);
        this.aXw.ni();
        this.aXw.setTextColor(ar.getColor(t.d.cp_cont_d));
        this.aXw.dg(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.dDn.setOnSrollToBottomListener(this);
        this.dDn.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.h hVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dDn != null) {
            this.dDn.nr();
        }
        if (this.aXw != null) {
            this.aXw.xc();
        }
        if (hVar == null) {
            ns(1);
            aK(this);
            this.dDo.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anc), NoDataViewFactory.d.dd(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dDo.notifyDataSetChanged();
            com.baidu.tieba.recommendfrs.a.aER().f(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.dDv = hVar;
        this.beG = false;
        this.dDq = hVar.aFq();
        this.dDp = hVar.aFp();
        this.dDu = hVar.aFr();
        setHasMore(hVar.hasMore());
        List<Object> aFs = hVar.aFs();
        if (this.dDo != null) {
            if (aFs == null || aFs.size() <= 0) {
                if (!z2) {
                    ns(1);
                }
                if (this.dDp && this.dDq) {
                    this.dDo.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anc), NoDataViewFactory.d.dd(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.dDo.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.dDo.w(aFs);
                this.dDo.notifyDataSetChanged();
            } else if (hVar.getDataType() == 1) {
                if (!z2) {
                    ns(hVar.getDataType());
                }
                this.dDo.w(aFs);
            } else if (hVar.getDataType() == 2) {
                if (this.dDf == null) {
                    this.dDf = new com.baidu.tieba.recommendfrs.personalize.a.l(getContext(), this.dDn);
                    this.dDf.setPageUniqueId(this.aPF);
                    aFa();
                } else if (!z2) {
                    ns(hVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : aFs) {
                    if (obj instanceof com.baidu.adp.widget.ListView.u) {
                        arrayList.add((com.baidu.adp.widget.ListView.u) obj);
                    }
                }
                this.dDf.bV(arrayList);
            }
            if (this.dDu != null && !StringUtils.isNull(this.dDu.tag_name) && com.baidu.tbadk.core.util.x.o(aFs) > 0) {
                TiebaStatic.log(new au("kantie_1").aa("obj_name", this.dDu.tag_name));
            }
            com.baidu.tieba.recommendfrs.a.aER().f(System.currentTimeMillis() - currentTimeMillis, hVar.getDataType() == 1 ? 2 : 3);
        }
        if (z) {
            this.dDn.setSelection(hVar.aFo());
        }
        if (this.dDq || (aFs != null && !aFs.isEmpty())) {
            aK(this);
        }
    }

    public void hl(boolean z) {
        if (this.dDn != null) {
            if (!z || this.dDv == null || this.dDv.aFs() == null || this.dDv.aFs().size() <= 0) {
                this.dDn.setSelection(0);
                this.dDn.ns();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.dDn != null) {
            if (this.mHasMore) {
                if (this.aXw != null) {
                    if (this.aXw.getView().getParent() == null) {
                        this.dDn.setNextPage(this.aXw);
                    }
                    this.aXw.xe();
                    return;
                }
                return;
            }
            this.aXw.di(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.dDp) {
            this.dDs.b(1, this.dDu.tag_code.longValue(), 0L);
        } else {
            this.dDs.bF(this.dDu.tag_code.longValue());
        }
    }

    public void ah(String str, int i) {
        int i2 = 0;
        if (this.dDn != null) {
            this.dDn.nr();
        }
        this.beG = false;
        this.aXw.xc();
        if (this.dDv != null && this.dDv.aFs() != null) {
            i2 = this.dDv.aFs().size();
        }
        if (i2 <= 0 && (this.dDp || i == -53)) {
            ns(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m411getInst().getString(t.j.neterror);
            }
            this.dDo.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anc), NoDataViewFactory.d.dM(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dDo.w(new ArrayList());
        }
        aK(this);
    }

    private void i(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void mk(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(str, null, null)));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).co("from_frs").bD(18003).rC()));
            TiebaStatic.log("c10258");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.jq() && !this.beG) {
            this.beG = true;
            this.aXw.xb();
            if (this.dDs != null) {
                if (this.dDv == null || this.dDv.getDataType() == 1) {
                    if (this.dDo == null) {
                        this.dDs.b(1, this.dDu.tag_code.longValue(), 0L);
                        return;
                    }
                    com.baidu.tieba.recommendfrs.data.l aEX = this.dDo.aEX();
                    if (aEX != null) {
                        this.dDs.b(this.dDv != null ? this.dDv.getPn() + 1 : 1, this.dDu.tag_code.longValue(), aEX.aFx());
                    }
                } else if (this.dDv.getDataType() == 2) {
                    int pn = this.dDv.getPn() + 1;
                    aEZ();
                    this.dDs.b(pn, this.dDu.tag_code.longValue(), this.dDv.aFt());
                }
            }
        }
    }

    private void aEZ() {
        if (this.dDv != null && this.dDv.getDataType() == 2 && this.dDv.aFs() != null && this.dDv.aFs().size() >= TbadkCoreApplication.m411getInst().getListItemRule().yg() - 30) {
            int yh = TbadkCoreApplication.m411getInst().getListItemRule().yh();
            if (yh < 0) {
                yh = 0;
            }
            ArrayList arrayList = new ArrayList(this.dDv.aFs());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= yh && i < yh + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= yh + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.dDv.bS(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.adp.widget.ListView.u) {
                    arrayList3.add((com.baidu.adp.widget.ListView.u) next);
                }
            }
            this.dDf.bV(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        ar.d(this, t.d.cp_bg_line_d, i);
        if (this.dDv == null || this.dDv.getDataType() == 1) {
            if (this.dDo != null) {
                this.dDo.a(this.pageContext, i);
            }
        } else if (this.dDv.getDataType() == 2 && this.dDf != null) {
            this.dDf.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.aXw != null) {
            this.aXw.setTextColor(ar.getColor(t.d.cp_cont_d));
            this.aXw.dg(i);
        }
    }

    public boolean bI(long j) {
        return this.dDu != null && j == this.dDu.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.dDt != null && this.dDu != null) {
            this.dDt.g(this.dDu.tag_code.longValue(), this.dDn.getFirstVisiblePosition());
        }
        if (this.dDx == null) {
            this.dDx = new com.baidu.tbadk.performanceLog.m();
            this.dDx.eZ(1005);
        }
        if (this.dDv == null || this.dDv.getDataType() == 1) {
            this.dDx.pageType = 2;
        } else if (this.dDv.getDataType() == 2) {
            this.dDx.pageType = 3;
        }
        this.dDx.FF();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.EE();
        com.baidu.tbadk.mvc.b.a EF = bVar.EF();
        if (this.dDv == null || this.dDv.getDataType() == 1) {
            if (EF instanceof com.baidu.tieba.recommendfrs.data.l) {
                com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) EF;
                int i = 0;
                while (true) {
                    if (i < this.dDo.getCount()) {
                        com.baidu.tieba.recommendfrs.data.l lVar2 = (com.baidu.tieba.recommendfrs.data.l) this.dDo.getItem(i);
                        if (lVar2 != null && lVar2.getThreadId() == lVar.getThreadId()) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                String str = null;
                if (lVar.aFB() != null && !lVar.aFB().isEmpty()) {
                    str = lVar.aFB().get(0);
                }
                if (lVar.aFC() == 33) {
                    b(lVar.aFD());
                } else if (lVar.aFE() == 1) {
                    i(lVar.aFA(), str);
                    TiebaStatic.log(new au("kantie_card").aa("obj_name", lVar.dFc).r("obj_type", 1).r("obj_locate", i).aa("obj_source", lVar.dFd).r("obj_param1", 1).aa("abtest", lVar.abtest));
                } else if (lVar.aFE() == 3) {
                    mk(new StringBuilder(String.valueOf(lVar.getThreadId())).toString());
                    TiebaStatic.log(new au("kantie_card").aa("obj_name", lVar.dFc).r("obj_type", 2).r("obj_locate", i).aa("obj_source", lVar.dFd).r("obj_param1", 1).aa("abtest", lVar.abtest));
                }
                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.mU(String.valueOf(lVar.getThreadId()))) {
                    readThreadHistory.mT(String.valueOf(lVar.getThreadId()));
                    this.dDo.A(EF);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements r.a {
        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.r.a
        public void az(boolean z) {
            TiebaStatic.eventStat(m.this.getContext(), "kantie_update", null);
            if (m.this.dDs != null) {
                m.this.startLoad();
                if (com.baidu.tieba.recommendfrs.control.a.n.aFn().cnb == com.baidu.tieba.recommendfrs.control.a.n.aFn().dEB) {
                    com.baidu.tieba.recommendfrs.control.a.n.aFn().dEC = 0;
                    com.baidu.tieba.recommendfrs.control.a.q.nv(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.dig == null) {
            if (i < 0) {
                this.dig = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.dig = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.dig.uv();
        }
        this.dig.c(view, z);
        if (this.mPullView != null) {
            this.mPullView.R(false);
        }
        if (this.dDo != null) {
            ns(1);
            this.dDo.bB(false);
            this.dDo.notifyDataSetChanged();
        }
    }

    private void aK(View view) {
        if (this.dig != null) {
            this.dig.H(view);
            this.dig = null;
        }
        if (this.mPullView != null) {
            this.mPullView.R(true);
        }
        if (this.dDo != null) {
            this.dDo.bB(true);
            this.dDo.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.dDx != null) {
            this.dDx.onDestroy();
        }
    }

    public void aEW() {
    }

    private void ns(int i) {
        if (i == 1) {
            if ((this.dDn.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.dDn.getAdapter()).getWrappedAdapter() instanceof l)) {
                this.dDn.setAdapter((ListAdapter) this.dDo);
                aFa();
            }
        } else if (i == 2 && (this.dDn.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.dDn.getAdapter()).getWrappedAdapter() instanceof com.baidu.adp.widget.ListView.x)) {
            this.dDn.a((com.baidu.adp.widget.ListView.a<com.baidu.adp.widget.ListView.u, x.a>) null);
            aFa();
        }
    }

    private void aFa() {
        this.dDn.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new com.baidu.tbadk.core.view.t(this.pageContext);
        this.dDn.setPullRefresh(this.mPullView);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aPF);
    }
}
