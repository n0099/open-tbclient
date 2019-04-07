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
    private boolean hlk;
    final PbActivity hll;
    private d hlm;
    private c hln;
    private aq hlo;
    private i hlp;
    private View.OnClickListener hlq;
    private View.OnClickListener hlr;
    private TbRichTextView.h hls;
    private com.baidu.tieba.pb.a.c hlt;
    private final MoreGodReplyModel hlu;
    private long hlv;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e dlj = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hlu.qz()) {
                a.this.hlu.bIW();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hlz = -1;

        private boolean vX(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!vX(this.hlz) && vX(i) && a.this.hll != null && a.this.hll.bJn() != null) {
                a.this.hll.bJn().bMm();
                a.this.hll.bJn().bNg();
            }
            this.hlz = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hlw = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hlo.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
            a.this.bIU();
        }
    };
    private PbActivity.a hlx = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bIR();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hlu = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bIX());
        this.hlu.a(this.hlw);
        this.hlo = aqVar;
        this.hll = pbActivity;
        this.hlm = new d(pbActivity, viewStub);
        this.hln = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final Runnable runnable) {
        this.hlu.cancelLoadData();
        this.hll.bJZ();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hln.bIZ()) {
            this.hlm.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlm.hide();
                    a.this.hlk = false;
                    if (a.this.hll != null) {
                        if (a.this.hll.bJn() != null) {
                            a.this.hll.bJn().nU(false);
                            f bMC = a.this.hll.bJn().bMC();
                            bMC.a(a.this.hll.bIX().getPbData(), true);
                            bMC.notifyDataSetChanged();
                        }
                        a.this.hll.c(a.this.hlx);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hlv != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hlv;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aS(currentTimeMillis);
            e.aoM().a(this.hll, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bIR() {
        n(null);
    }

    private void showView() {
        boolean bJb = this.hlm.bJb();
        this.hlm.show();
        if (!bJb) {
            this.hlm.bJc().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIR();
                }
            });
            this.hlm.bJd().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIR();
                }
            });
            this.hlm.bJf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hlu.qz()) {
                        a.this.hlu.bIW();
                    }
                }
            });
            this.hlm.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hlv = System.currentTimeMillis();
    }

    public void bIS() {
        if (!isActive()) {
            this.hll.bJZ();
            this.hlk = true;
            this.hln.setFullscreen(false);
            this.hln.nf(true);
            showView();
            bIU();
            this.hlm.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hln.nf(false);
                }
            });
            this.hll.b(this.hlx);
            this.hlu.bIW();
        }
        this.hll.bJn().bNg();
    }

    public void bIT() {
        if (isActive()) {
            bIU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIU() {
        List<m> bIY = this.hlu.bIY();
        if (bIY != null) {
            com.baidu.tieba.pb.data.d pbData = this.hlu.bIX().getPbData();
            this.hlm.show();
            this.hlm.getListView().setOnSrollToBottomListener(this.dlj);
            BdTypeListView listView = this.hlm.getListView();
            this.hln.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bIY));
            this.hlm.aDm().setCenterTextTitle(String.format(this.hll.getResources().getString(d.j.more_god_reply_count), ap.ax(pbData.bIh().hkK.size())));
            this.hlm.ng(this.hlu.Hy());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hlp == null) {
            this.hlp = new i(this.hll, PostData.iFM);
            this.hlp.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hlp);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.hlp.b(dVar);
        f bMC = this.hlo.bMC();
        this.hlp.setFromCDN(bMC.isFromCDN());
        this.hlp.setHostId(dVar.bHW().YO().getUserId());
        this.hlp.nc(bMC.bKu());
        this.hlp.t(this.hlq);
        this.hlp.J(this.hlr);
        this.hlp.setOnImageClickListener(this.hls);
        this.hlp.setOnLongClickListener(this.onLongClickListener);
        this.hlp.setTbGestureDetector(this.hlt);
    }

    public void onChangeSkinType(int i) {
        this.hlm.onChangeSkinType(i);
    }

    public void t(View.OnClickListener onClickListener) {
        this.hlq = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hlr = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hls = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hlt = cVar;
    }

    public boolean isActive() {
        return this.hlk;
    }

    public d bIV() {
        return this.hlm;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hll == null) {
            return null;
        }
        return this.hll.getNextPageSourceKeyList();
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
            PbModel bIX = this.hll.bIX();
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
