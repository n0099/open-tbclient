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
    private long fVA;
    private boolean fVp;
    final PbActivity fVq;
    private d fVr;
    private c fVs;
    private ar fVt;
    private i fVu;
    private View.OnClickListener fVv;
    private View.OnClickListener fVw;
    private TbRichTextView.h fVx;
    private com.baidu.tieba.pb.a.c fVy;
    private final MoreGodReplyModel fVz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bWh = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fVz.Fv()) {
                a.this.fVz.biC();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fVE = -1;

        private boolean ss(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!ss(this.fVE) && ss(i) && a.this.fVq != null && a.this.fVq.biU() != null) {
                a.this.fVq.biU().blU();
                a.this.fVq.biU().bmO();
            }
            this.fVE = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fVB = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fVt.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void Q(List<PostData> list) {
            a.this.biA();
        }
    };
    private PbActivity.a fVC = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bix();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fVz = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.biD());
        this.fVz.a(this.fVB);
        this.fVt = arVar;
        this.fVq = pbActivity;
        this.fVr = new d(pbActivity, viewStub);
        this.fVs = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        this.fVz.cancelLoadData();
        this.fVq.bjG();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fVs.biF()) {
            this.fVr.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fVr.hide();
                    a.this.fVp = false;
                    if (a.this.fVq != null) {
                        if (a.this.fVq.biU() != null) {
                            a.this.fVq.biU().lv(false);
                            f bml = a.this.fVq.biU().bml();
                            bml.a(a.this.fVq.biD().getPbData(), true);
                            bml.notifyDataSetChanged();
                        }
                        a.this.fVq.c(a.this.fVC);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fVA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fVA;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aq(currentTimeMillis);
            e.Pk().a(this.fVq, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bix() {
        i(null);
    }

    private void showView() {
        boolean biH = this.fVr.biH();
        this.fVr.show();
        if (!biH) {
            this.fVr.biI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bix();
                }
            });
            this.fVr.biJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bix();
                }
            });
            this.fVr.biL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fVz.Fv()) {
                        a.this.fVz.biC();
                    }
                }
            });
            this.fVr.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fVA = System.currentTimeMillis();
    }

    public void biy() {
        if (!isActive()) {
            this.fVq.bjG();
            this.fVp = true;
            this.fVs.setFullscreen(false);
            this.fVs.kF(true);
            showView();
            biA();
            this.fVr.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fVs.kF(false);
                }
            });
            this.fVq.b(this.fVC);
            this.fVz.biC();
        }
        this.fVq.biU().bmO();
    }

    public void biz() {
        if (isActive()) {
            biA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biA() {
        List<h> biE = this.fVz.biE();
        if (biE != null) {
            com.baidu.tieba.pb.data.d pbData = this.fVz.biD().getPbData();
            this.fVr.show();
            this.fVr.getListView().setOnSrollToBottomListener(this.bWh);
            BdTypeListView listView = this.fVr.getListView();
            this.fVs.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(biE));
            this.fVr.act().setCenterTextTitle(String.format(this.fVq.getResources().getString(e.j.more_god_reply_count), ao.V(pbData.bhK().fUK.size())));
            this.fVr.kG(this.fVz.hasMoreData());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fVu == null) {
            this.fVu = new i(this.fVq, PostData.hpD);
            this.fVu.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fVu);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fVu.b(dVar);
        f bml = this.fVt.bml();
        this.fVu.setFromCDN(bml.isFromCDN());
        this.fVu.setHostId(dVar.bhz().zT().getUserId());
        this.fVu.kC(bml.bkb());
        this.fVu.s(this.fVv);
        this.fVu.I(this.fVw);
        this.fVu.setOnImageClickListener(this.fVx);
        this.fVu.setOnLongClickListener(this.onLongClickListener);
        this.fVu.setTbGestureDetector(this.fVy);
    }

    public void onChangeSkinType(int i) {
        this.fVr.onChangeSkinType(i);
    }

    public void s(View.OnClickListener onClickListener) {
        this.fVv = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fVw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fVx = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fVy = cVar;
    }

    public boolean isActive() {
        return this.fVp;
    }

    public d biB() {
        return this.fVr;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fVq == null) {
            return null;
        }
        return this.fVq.getNextPageSourceKeyList();
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
            PbModel biD = this.fVq.biD();
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
