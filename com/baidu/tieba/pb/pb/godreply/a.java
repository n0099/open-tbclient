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
    private TbRichTextView.h fUA;
    private com.baidu.tieba.pb.a.c fUB;
    private final MoreGodReplyModel fUC;
    private long fUD;
    private boolean fUs;
    final PbActivity fUt;
    private d fUu;
    private c fUv;
    private ar fUw;
    private i fUx;
    private View.OnClickListener fUy;
    private View.OnClickListener fUz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bVw = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fUC.Fi()) {
                a.this.fUC.bhY();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fUH = -1;

        private boolean so(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!so(this.fUH) && so(i) && a.this.fUt != null && a.this.fUt.biq() != null) {
                a.this.fUt.biq().blm();
                a.this.fUt.biq().bmg();
            }
            this.fUH = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fUE = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fUw.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void P(List<PostData> list) {
            a.this.bhW();
        }
    };
    private PbActivity.a fUF = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bhT();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fUC = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bhZ());
        this.fUC.a(this.fUE);
        this.fUw = arVar;
        this.fUt = pbActivity;
        this.fUu = new d(pbActivity, viewStub);
        this.fUv = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        this.fUC.cancelLoadData();
        this.fUt.bjc();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fUv.bib()) {
            this.fUu.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fUu.hide();
                    a.this.fUs = false;
                    if (a.this.fUt != null) {
                        if (a.this.fUt.biq() != null) {
                            a.this.fUt.biq().lv(false);
                            f blD = a.this.fUt.biq().blD();
                            blD.a(a.this.fUt.bhZ().getPbData(), true);
                            blD.notifyDataSetChanged();
                        }
                        a.this.fUt.c(a.this.fUF);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fUD != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fUD;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aq(currentTimeMillis);
            e.OS().a(this.fUt, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bhT() {
        i(null);
    }

    private void showView() {
        boolean bid = this.fUu.bid();
        this.fUu.show();
        if (!bid) {
            this.fUu.bie().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bhT();
                }
            });
            this.fUu.bif().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bhT();
                }
            });
            this.fUu.bih().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fUC.Fi()) {
                        a.this.fUC.bhY();
                    }
                }
            });
            this.fUu.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fUD = System.currentTimeMillis();
    }

    public void bhU() {
        if (!isActive()) {
            this.fUt.bjc();
            this.fUs = true;
            this.fUv.setFullscreen(false);
            this.fUv.kF(true);
            showView();
            bhW();
            this.fUu.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fUv.kF(false);
                }
            });
            this.fUt.b(this.fUF);
            this.fUC.bhY();
        }
        this.fUt.biq().bmg();
    }

    public void bhV() {
        if (isActive()) {
            bhW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhW() {
        List<h> bia = this.fUC.bia();
        if (bia != null) {
            com.baidu.tieba.pb.data.d pbData = this.fUC.bhZ().getPbData();
            this.fUu.show();
            this.fUu.getListView().setOnSrollToBottomListener(this.bVw);
            BdTypeListView listView = this.fUu.getListView();
            this.fUv.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bia));
            this.fUu.abW().setCenterTextTitle(String.format(this.fUt.getResources().getString(e.j.more_god_reply_count), ao.V(pbData.bhg().fTN.size())));
            this.fUu.kG(this.fUC.hasMoreData());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fUx == null) {
            this.fUx = new i(this.fUt, PostData.hoy);
            this.fUx.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fUx);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fUx.b(dVar);
        f blD = this.fUw.blD();
        this.fUx.setFromCDN(blD.isFromCDN());
        this.fUx.setHostId(dVar.bgV().zG().getUserId());
        this.fUx.kC(blD.bjx());
        this.fUx.s(this.fUy);
        this.fUx.I(this.fUz);
        this.fUx.setOnImageClickListener(this.fUA);
        this.fUx.setOnLongClickListener(this.onLongClickListener);
        this.fUx.setTbGestureDetector(this.fUB);
    }

    public void onChangeSkinType(int i) {
        this.fUu.onChangeSkinType(i);
    }

    public void s(View.OnClickListener onClickListener) {
        this.fUy = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fUz = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fUA = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fUB = cVar;
    }

    public boolean isActive() {
        return this.fUs;
    }

    public d bhX() {
        return this.fUu;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fUt == null) {
            return null;
        }
        return this.fUt.getNextPageSourceKeyList();
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
        if ((getPageStayFilter() == null || getPageStayFilter().ON()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.U(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.ir(getCurrentPageKey());
            PbModel bhZ = this.fUt.bhZ();
            if (bhZ != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bhZ.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bhZ.bjP(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
