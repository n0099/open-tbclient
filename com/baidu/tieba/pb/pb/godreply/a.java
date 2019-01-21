package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private final MoreGodReplyModel fVA;
    private long fVB;
    private boolean fVq;
    final PbActivity fVr;
    private d fVs;
    private c fVt;
    private ar fVu;
    private i fVv;
    private View.OnClickListener fVw;
    private View.OnClickListener fVx;
    private TbRichTextView.h fVy;
    private com.baidu.tieba.pb.a.c fVz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bWi = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fVA.Fv()) {
                a.this.fVA.biC();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fVF = -1;

        private boolean ss(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!ss(this.fVF) && ss(i) && a.this.fVr != null && a.this.fVr.biU() != null) {
                a.this.fVr.biU().blU();
                a.this.fVr.biU().bmO();
            }
            this.fVF = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fVC = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fVu.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void Q(List<PostData> list) {
            a.this.biA();
        }
    };
    private PbActivity.a fVD = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bix();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fVA = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.biD());
        this.fVA.a(this.fVC);
        this.fVu = arVar;
        this.fVr = pbActivity;
        this.fVs = new d(pbActivity, viewStub);
        this.fVt = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        this.fVA.cancelLoadData();
        this.fVr.bjG();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fVt.biF()) {
            this.fVs.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fVs.hide();
                    a.this.fVq = false;
                    if (a.this.fVr != null) {
                        if (a.this.fVr.biU() != null) {
                            a.this.fVr.biU().lv(false);
                            f bml = a.this.fVr.biU().bml();
                            bml.a(a.this.fVr.biD().getPbData(), true);
                            bml.notifyDataSetChanged();
                        }
                        a.this.fVr.c(a.this.fVD);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fVB != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fVB;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aq(currentTimeMillis);
            e.Pk().a(this.fVr, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bix() {
        i(null);
    }

    private void showView() {
        boolean biH = this.fVs.biH();
        this.fVs.show();
        if (!biH) {
            this.fVs.biI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bix();
                }
            });
            this.fVs.biJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bix();
                }
            });
            this.fVs.biL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fVA.Fv()) {
                        a.this.fVA.biC();
                    }
                }
            });
            this.fVs.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fVB = System.currentTimeMillis();
    }

    public void biy() {
        if (!isActive()) {
            this.fVr.bjG();
            this.fVq = true;
            this.fVt.setFullscreen(false);
            this.fVt.kF(true);
            showView();
            biA();
            this.fVs.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fVt.kF(false);
                }
            });
            this.fVr.b(this.fVD);
            this.fVA.biC();
        }
        this.fVr.biU().bmO();
    }

    public void biz() {
        if (isActive()) {
            biA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biA() {
        List<h> biE = this.fVA.biE();
        if (biE != null) {
            com.baidu.tieba.pb.data.d pbData = this.fVA.biD().getPbData();
            this.fVs.show();
            this.fVs.getListView().setOnSrollToBottomListener(this.bWi);
            BdTypeListView listView = this.fVs.getListView();
            this.fVt.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(biE));
            this.fVs.act().setCenterTextTitle(String.format(this.fVr.getResources().getString(e.j.more_god_reply_count), ao.V(pbData.bhK().fUL.size())));
            this.fVs.kG(this.fVA.hasMoreData());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fVv == null) {
            this.fVv = new i(this.fVr, PostData.hpE);
            this.fVv.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fVv);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fVv.b(dVar);
        f bml = this.fVu.bml();
        this.fVv.setFromCDN(bml.isFromCDN());
        this.fVv.setHostId(dVar.bhz().zT().getUserId());
        this.fVv.kC(bml.bkb());
        this.fVv.s(this.fVw);
        this.fVv.I(this.fVx);
        this.fVv.setOnImageClickListener(this.fVy);
        this.fVv.setOnLongClickListener(this.onLongClickListener);
        this.fVv.setTbGestureDetector(this.fVz);
    }

    public void onChangeSkinType(int i) {
        this.fVs.onChangeSkinType(i);
    }

    public void s(View.OnClickListener onClickListener) {
        this.fVw = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fVx = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fVy = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fVz = cVar;
    }

    public boolean isActive() {
        return this.fVq;
    }

    public d biB() {
        return this.fVs;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fVr == null) {
            return null;
        }
        return this.fVr.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.I(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Pf()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.V(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.iF(getCurrentPageKey());
            PbModel biD = this.fVr.biD();
            if (biD != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(biD.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(biD.bkt(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
