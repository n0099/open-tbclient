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
    private View.OnClickListener fdA;
    private TbRichTextView.h fdB;
    private com.baidu.tieba.pb.a.c fdC;
    private final MoreGodReplyModel fdD;
    private long fdE;
    private boolean fdt;
    final PbActivity fdu;
    private d fdv;
    private c fdw;
    private as fdx;
    private i fdy;
    private View.OnClickListener fdz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e brx = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fdD.wX()) {
                a.this.fdD.aWw();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fdI = -1;

        private boolean qc(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qc(this.fdI) && qc(i) && a.this.fdu != null && a.this.fdu.aWO() != null) {
                a.this.fdu.aWO().aZI();
                a.this.fdu.aWO().baA();
            }
            this.fdI = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private y.a fdF = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fdx.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void D(List<PostData> list) {
            a.this.aWu();
        }
    };
    private PbActivity.a fdG = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aWr();
            return true;
        }
    };

    public a(PbActivity pbActivity, as asVar, ViewStub viewStub) {
        this.fdD = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aWx());
        this.fdD.a(this.fdF);
        this.fdx = asVar;
        this.fdu = pbActivity;
        this.fdv = new d(pbActivity, viewStub);
        this.fdw = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        this.fdD.cancelLoadData();
        this.fdu.aXz();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fdw.aWz()) {
            this.fdv.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fdv.hide();
                    a.this.fdt = false;
                    if (a.this.fdu != null) {
                        if (a.this.fdu.aWO() != null) {
                            a.this.fdu.aWO().kn(false);
                            f aZY = a.this.fdu.aWO().aZY();
                            aZY.a(a.this.fdu.aWx().getPbData(), true);
                            aZY.notifyDataSetChanged();
                        }
                        a.this.fdu.c(a.this.fdG);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fdE != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fdE;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.U(currentTimeMillis);
            e.Gt().a(this.fdu, pageStayDurationItem, getPageStayFilter());
        }
    }

    void aWr() {
        i(null);
    }

    private void showView() {
        boolean aWB = this.fdv.aWB();
        this.fdv.show();
        if (!aWB) {
            this.fdv.aWC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aWr();
                }
            });
            this.fdv.aWD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aWr();
                }
            });
            this.fdv.aWF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.fdD.wX()) {
                        a.this.fdD.aWw();
                    }
                }
            });
            this.fdv.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fdE = System.currentTimeMillis();
    }

    public void aWs() {
        if (!isActive()) {
            this.fdu.aXz();
            this.fdt = true;
            this.fdw.setFullscreen(false);
            this.fdw.jt(true);
            showView();
            aWu();
            this.fdv.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fdw.jt(false);
                }
            });
            this.fdu.b(this.fdG);
            this.fdD.aWw();
        }
        this.fdu.aWO().baA();
    }

    public void aWt() {
        if (isActive()) {
            aWu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWu() {
        List<h> aWy = this.fdD.aWy();
        if (aWy != null) {
            com.baidu.tieba.pb.data.d pbData = this.fdD.aWx().getPbData();
            this.fdv.show();
            this.fdv.getListView().setOnSrollToBottomListener(this.brx);
            BdTypeListView listView = this.fdv.getListView();
            this.fdw.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(aWy));
            this.fdv.Rg().setCenterTextTitle(String.format(this.fdu.getResources().getString(d.k.more_god_reply_count), an.z(pbData.aVD().fcY.size())));
            this.fdv.ju(this.fdD.acw());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fdy == null) {
            this.fdy = new i(this.fdu, PostData.gwv);
            this.fdy.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fdy);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fdy.b(dVar);
        f aZY = this.fdx.aZY();
        this.fdy.setFromCDN(aZY.isFromCDN());
        this.fdy.setHostId(dVar.aVs().rQ().getUserId());
        this.fdy.jq(aZY.aXQ());
        this.fdy.n(this.fdz);
        this.fdy.F(this.fdA);
        this.fdy.setOnImageClickListener(this.fdB);
        this.fdy.setOnLongClickListener(this.onLongClickListener);
        this.fdy.setTbGestureDetector(this.fdC);
    }

    public void onChangeSkinType(int i) {
        this.fdv.onChangeSkinType(i);
    }

    public void n(View.OnClickListener onClickListener) {
        this.fdz = onClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fdA = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fdB = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fdC = cVar;
    }

    public boolean isActive() {
        return this.fdt;
    }

    public d aWv() {
        return this.fdv;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fdu == null) {
            return null;
        }
        return this.fdu.getNextPageSourceKeyList();
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
            PbModel aWx = this.fdu.aWx();
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
