package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean hll;
    final PbActivity hlm;
    private d hln;
    private c hlo;
    private aq hlp;
    private i hlq;
    private View.OnClickListener hlr;
    private View.OnClickListener hls;
    private TbRichTextView.h hlt;
    private com.baidu.tieba.pb.a.c hlu;
    private final MoreGodReplyModel hlv;
    private long hlw;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e dlk = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hlv.qz()) {
                a.this.hlv.bIW();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hlA = -1;

        private boolean vX(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!vX(this.hlA) && vX(i) && a.this.hlm != null && a.this.hlm.bJn() != null) {
                a.this.hlm.bJn().bMm();
                a.this.hlm.bJn().bNg();
            }
            this.hlA = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hlx = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hlp.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
            a.this.bIU();
        }
    };
    private PbActivity.a hly = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bIR();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hlv = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bIX());
        this.hlv.a(this.hlx);
        this.hlp = aqVar;
        this.hlm = pbActivity;
        this.hln = new d(pbActivity, viewStub);
        this.hlo = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final Runnable runnable) {
        this.hlv.cancelLoadData();
        this.hlm.bJZ();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hlo.bIZ()) {
            this.hln.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hln.hide();
                    a.this.hll = false;
                    if (a.this.hlm != null) {
                        if (a.this.hlm.bJn() != null) {
                            a.this.hlm.bJn().nU(false);
                            f bMC = a.this.hlm.bJn().bMC();
                            bMC.a(a.this.hlm.bIX().getPbData(), true);
                            bMC.notifyDataSetChanged();
                        }
                        a.this.hlm.c(a.this.hly);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hlw != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hlw;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aS(currentTimeMillis);
            e.aoM().a(this.hlm, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bIR() {
        n(null);
    }

    private void showView() {
        boolean bJb = this.hln.bJb();
        this.hln.show();
        if (!bJb) {
            this.hln.bJc().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIR();
                }
            });
            this.hln.bJd().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIR();
                }
            });
            this.hln.bJf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hlv.qz()) {
                        a.this.hlv.bIW();
                    }
                }
            });
            this.hln.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hlw = System.currentTimeMillis();
    }

    public void bIS() {
        if (!isActive()) {
            this.hlm.bJZ();
            this.hll = true;
            this.hlo.setFullscreen(false);
            this.hlo.nf(true);
            showView();
            bIU();
            this.hln.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlo.nf(false);
                }
            });
            this.hlm.b(this.hly);
            this.hlv.bIW();
        }
        this.hlm.bJn().bNg();
    }

    public void bIT() {
        if (isActive()) {
            bIU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIU() {
        List<m> bIY = this.hlv.bIY();
        if (bIY != null) {
            com.baidu.tieba.pb.data.d pbData = this.hlv.bIX().getPbData();
            this.hln.show();
            this.hln.getListView().setOnSrollToBottomListener(this.dlk);
            BdTypeListView listView = this.hln.getListView();
            this.hlo.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bIY));
            this.hln.aDm().setCenterTextTitle(String.format(this.hlm.getResources().getString(d.j.more_god_reply_count), ap.ax(pbData.bIh().hkL.size())));
            this.hln.ng(this.hlv.Hy());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hlq == null) {
            this.hlq = new i(this.hlm, PostData.iFN);
            this.hlq.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hlq);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.hlq.b(dVar);
        f bMC = this.hlp.bMC();
        this.hlq.setFromCDN(bMC.isFromCDN());
        this.hlq.setHostId(dVar.bHW().YO().getUserId());
        this.hlq.nc(bMC.bKu());
        this.hlq.t(this.hlr);
        this.hlq.J(this.hls);
        this.hlq.setOnImageClickListener(this.hlt);
        this.hlq.setOnLongClickListener(this.onLongClickListener);
        this.hlq.setTbGestureDetector(this.hlu);
    }

    public void onChangeSkinType(int i) {
        this.hln.onChangeSkinType(i);
    }

    public void t(View.OnClickListener onClickListener) {
        this.hlr = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hls = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hlt = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hlu = cVar;
    }

    public boolean isActive() {
        return this.hll;
    }

    public d bIV() {
        return this.hln;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hlm == null) {
            return null;
        }
        return this.hlm.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.T(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().aoH()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.pageStayDuration.d();
            this.pageStayDurationItem.ah(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.pu(getCurrentPageKey());
            PbModel bIX = this.hlm.bIX();
            if (bIX != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bIX.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bIX.bKO(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
