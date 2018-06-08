package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
    private boolean fpU;
    final PbActivity fpV;
    private d fpW;
    private c fpX;
    private as fpY;
    private i fpZ;
    private View.OnClickListener fqa;
    private View.OnClickListener fqb;
    private TbRichTextView.h fqc;
    private com.baidu.tieba.pb.a.c fqd;
    private final MoreGodReplyModel fqe;
    private long fqf;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bzR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fqe.Ax()) {
                a.this.fqe.bbs();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fqj = -1;

        private boolean qm(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qm(this.fqj) && qm(i) && a.this.fpV != null && a.this.fpV.bbK() != null) {
                a.this.fpV.bbK().beG();
                a.this.fpV.bbK().bfy();
            }
            this.fqj = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private y.a fqg = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fpY.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void G(List<PostData> list) {
            a.this.bbq();
        }
    };
    private PbActivity.a fqh = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bbn();
            return true;
        }
    };

    public a(PbActivity pbActivity, as asVar, ViewStub viewStub) {
        this.fqe = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bbt());
        this.fqe.a(this.fqg);
        this.fpY = asVar;
        this.fpV = pbActivity;
        this.fpW = new d(pbActivity, viewStub);
        this.fpX = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.fqe.cancelLoadData();
        this.fpV.bcv();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fpX.bbv()) {
            this.fpW.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fpW.hide();
                    a.this.fpU = false;
                    if (a.this.fpV != null) {
                        if (a.this.fpV.bbK() != null) {
                            a.this.fpV.bbK().ku(false);
                            f beW = a.this.fpV.bbK().beW();
                            beW.a(a.this.fpV.bbt().getPbData(), true);
                            beW.notifyDataSetChanged();
                        }
                        a.this.fpV.c(a.this.fqh);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fqf != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fqf;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.X(currentTimeMillis);
            e.JZ().a(this.fpV, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bbn() {
        h(null);
    }

    private void showView() {
        boolean bbx = this.fpW.bbx();
        this.fpW.show();
        if (!bbx) {
            this.fpW.bby().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbn();
                }
            });
            this.fpW.bbz().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbn();
                }
            });
            this.fpW.bbB().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fqe.Ax()) {
                        a.this.fqe.bbs();
                    }
                }
            });
            this.fpW.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fqf = System.currentTimeMillis();
    }

    public void bbo() {
        if (!isActive()) {
            this.fpV.bcv();
            this.fpU = true;
            this.fpX.setFullscreen(false);
            this.fpX.jA(true);
            showView();
            bbq();
            this.fpW.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fpX.jA(false);
                }
            });
            this.fpV.b(this.fqh);
            this.fqe.bbs();
        }
        this.fpV.bbK().bfy();
    }

    public void bbp() {
        if (isActive()) {
            bbq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbq() {
        List<h> bbu = this.fqe.bbu();
        if (bbu != null) {
            com.baidu.tieba.pb.data.d pbData = this.fqe.bbt().getPbData();
            this.fpW.show();
            this.fpW.getListView().setOnSrollToBottomListener(this.bzR);
            BdTypeListView listView = this.fpW.getListView();
            this.fpX.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bbu));
            this.fpW.UB().setCenterTextTitle(String.format(this.fpV.getResources().getString(d.k.more_god_reply_count), ao.C(pbData.baz().fpz.size())));
            this.fpW.jB(this.fqe.afT());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fpZ == null) {
            this.fpZ = new i(this.fpV, PostData.gIV);
            this.fpZ.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fpZ);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fpZ.b(dVar);
        f beW = this.fpY.beW();
        this.fpZ.setFromCDN(beW.isFromCDN());
        this.fpZ.setHostId(dVar.bao().vm().getUserId());
        this.fpZ.jx(beW.bcO());
        this.fpZ.n(this.fqa);
        this.fpZ.F(this.fqb);
        this.fpZ.setOnImageClickListener(this.fqc);
        this.fpZ.setOnLongClickListener(this.onLongClickListener);
        this.fpZ.setTbGestureDetector(this.fqd);
    }

    public void onChangeSkinType(int i) {
        this.fpW.onChangeSkinType(i);
    }

    public void n(View.OnClickListener onClickListener) {
        this.fqa = onClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fqb = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fqc = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fqd = cVar;
    }

    public boolean isActive() {
        return this.fpU;
    }

    public d bbr() {
        return this.fpW;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fpV == null) {
            return null;
        }
        return this.fpV.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (w.z(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().JU()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.L(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.hm(getCurrentPageKey());
            PbModel bbt = this.fpV.bbt();
            if (bbt != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bbt.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bbt.bdh(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
