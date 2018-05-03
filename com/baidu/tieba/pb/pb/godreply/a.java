package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private final MoreGodReplyModel fdA;
    private long fdB;
    private boolean fdq;
    final PbActivity fdr;
    private d fds;
    private c fdt;
    private as fdu;
    private i fdv;
    private View.OnClickListener fdw;
    private View.OnClickListener fdx;
    private TbRichTextView.h fdy;
    private com.baidu.tieba.pb.a.c fdz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e brx = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fdA.wX()) {
                a.this.fdA.aWw();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fdF = -1;

        private boolean qb(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qb(this.fdF) && qb(i) && a.this.fdr != null && a.this.fdr.aWO() != null) {
                a.this.fdr.aWO().aZI();
                a.this.fdr.aWO().baA();
            }
            this.fdF = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private y.a fdC = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fdu.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void D(List<PostData> list) {
            a.this.aWu();
        }
    };
    private PbActivity.a fdD = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aWr();
            return true;
        }
    };

    public a(PbActivity pbActivity, as asVar, ViewStub viewStub) {
        this.fdA = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aWx());
        this.fdA.a(this.fdC);
        this.fdu = asVar;
        this.fdr = pbActivity;
        this.fds = new d(pbActivity, viewStub);
        this.fdt = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        this.fdA.cancelLoadData();
        this.fdr.aXz();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fdt.aWz()) {
            this.fds.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fds.hide();
                    a.this.fdq = false;
                    if (a.this.fdr != null) {
                        if (a.this.fdr.aWO() != null) {
                            a.this.fdr.aWO().kn(false);
                            f aZY = a.this.fdr.aWO().aZY();
                            aZY.a(a.this.fdr.aWx().getPbData(), true);
                            aZY.notifyDataSetChanged();
                        }
                        a.this.fdr.c(a.this.fdD);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fdB != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fdB;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.U(currentTimeMillis);
            e.Gt().a(this.fdr, pageStayDurationItem, getPageStayFilter());
        }
    }

    void aWr() {
        i(null);
    }

    private void showView() {
        boolean aWB = this.fds.aWB();
        this.fds.show();
        if (!aWB) {
            this.fds.aWC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aWr();
                }
            });
            this.fds.aWD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aWr();
                }
            });
            this.fds.aWF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.fdA.wX()) {
                        a.this.fdA.aWw();
                    }
                }
            });
            this.fds.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fdB = System.currentTimeMillis();
    }

    public void aWs() {
        if (!isActive()) {
            this.fdr.aXz();
            this.fdq = true;
            this.fdt.setFullscreen(false);
            this.fdt.jt(true);
            showView();
            aWu();
            this.fds.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fdt.jt(false);
                }
            });
            this.fdr.b(this.fdD);
            this.fdA.aWw();
        }
        this.fdr.aWO().baA();
    }

    public void aWt() {
        if (isActive()) {
            aWu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWu() {
        List<h> aWy = this.fdA.aWy();
        if (aWy != null) {
            com.baidu.tieba.pb.data.d pbData = this.fdA.aWx().getPbData();
            this.fds.show();
            this.fds.getListView().setOnSrollToBottomListener(this.brx);
            BdTypeListView listView = this.fds.getListView();
            this.fdt.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(aWy));
            this.fds.Rg().setCenterTextTitle(String.format(this.fdr.getResources().getString(d.k.more_god_reply_count), an.z(pbData.aVD().fcV.size())));
            this.fds.ju(this.fdA.acw());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fdv == null) {
            this.fdv = new i(this.fdr, PostData.gws);
            this.fdv.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fdv);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fdv.b(dVar);
        f aZY = this.fdu.aZY();
        this.fdv.setFromCDN(aZY.isFromCDN());
        this.fdv.setHostId(dVar.aVs().rQ().getUserId());
        this.fdv.jq(aZY.aXQ());
        this.fdv.n(this.fdw);
        this.fdv.F(this.fdx);
        this.fdv.setOnImageClickListener(this.fdy);
        this.fdv.setOnLongClickListener(this.onLongClickListener);
        this.fdv.setTbGestureDetector(this.fdz);
    }

    public void onChangeSkinType(int i) {
        this.fds.onChangeSkinType(i);
    }

    public void n(View.OnClickListener onClickListener) {
        this.fdw = onClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fdx = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fdy = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fdz = cVar;
    }

    public boolean isActive() {
        return this.fdq;
    }

    public d aWv() {
        return this.fds;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fdr == null) {
            return null;
        }
        return this.fdr.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.w(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Go()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.I(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.gO(getCurrentPageKey());
            PbModel aWx = this.fdr.aWx();
            if (aWx != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(aWx.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(aWx.aYj(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
