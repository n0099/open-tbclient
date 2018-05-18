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
    private c feA;
    private as feB;
    private i feC;
    private View.OnClickListener feD;
    private View.OnClickListener feE;
    private TbRichTextView.h feF;
    private com.baidu.tieba.pb.a.c feG;
    private final MoreGodReplyModel feH;
    private long feI;
    private boolean fex;
    final PbActivity fey;
    private d fez;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e brM = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.feH.wW()) {
                a.this.feH.aWw();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int feM = -1;

        private boolean qa(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qa(this.feM) && qa(i) && a.this.fey != null && a.this.fey.aWO() != null) {
                a.this.fey.aWO().aZI();
                a.this.fey.aWO().baA();
            }
            this.feM = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private y.a feJ = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.feB.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void D(List<PostData> list) {
            a.this.aWu();
        }
    };
    private PbActivity.a feK = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aWr();
            return true;
        }
    };

    public a(PbActivity pbActivity, as asVar, ViewStub viewStub) {
        this.feH = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aWx());
        this.feH.a(this.feJ);
        this.feB = asVar;
        this.fey = pbActivity;
        this.fez = new d(pbActivity, viewStub);
        this.feA = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        this.feH.cancelLoadData();
        this.fey.aXz();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.feA.aWz()) {
            this.fez.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fez.hide();
                    a.this.fex = false;
                    if (a.this.fey != null) {
                        if (a.this.fey.aWO() != null) {
                            a.this.fey.aWO().ko(false);
                            f aZY = a.this.fey.aWO().aZY();
                            aZY.a(a.this.fey.aWx().getPbData(), true);
                            aZY.notifyDataSetChanged();
                        }
                        a.this.fey.c(a.this.feK);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.feI != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.feI;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.U(currentTimeMillis);
            e.Gr().a(this.fey, pageStayDurationItem, getPageStayFilter());
        }
    }

    void aWr() {
        i(null);
    }

    private void showView() {
        boolean aWB = this.fez.aWB();
        this.fez.show();
        if (!aWB) {
            this.fez.aWC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aWr();
                }
            });
            this.fez.aWD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aWr();
                }
            });
            this.fez.aWF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.feH.wW()) {
                        a.this.feH.aWw();
                    }
                }
            });
            this.fez.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.feI = System.currentTimeMillis();
    }

    public void aWs() {
        if (!isActive()) {
            this.fey.aXz();
            this.fex = true;
            this.feA.setFullscreen(false);
            this.feA.ju(true);
            showView();
            aWu();
            this.fez.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.feA.ju(false);
                }
            });
            this.fey.b(this.feK);
            this.feH.aWw();
        }
        this.fey.aWO().baA();
    }

    public void aWt() {
        if (isActive()) {
            aWu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWu() {
        List<h> aWy = this.feH.aWy();
        if (aWy != null) {
            com.baidu.tieba.pb.data.d pbData = this.feH.aWx().getPbData();
            this.fez.show();
            this.fez.getListView().setOnSrollToBottomListener(this.brM);
            BdTypeListView listView = this.fez.getListView();
            this.feA.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(aWy));
            this.fez.Rd().setCenterTextTitle(String.format(this.fey.getResources().getString(d.k.more_god_reply_count), an.z(pbData.aVD().fec.size())));
            this.fez.jv(this.feH.acw());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.feC == null) {
            this.feC = new i(this.fey, PostData.gxw);
            this.feC.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.feC);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.feC.b(dVar);
        f aZY = this.feB.aZY();
        this.feC.setFromCDN(aZY.isFromCDN());
        this.feC.setHostId(dVar.aVs().rP().getUserId());
        this.feC.jr(aZY.aXQ());
        this.feC.n(this.feD);
        this.feC.F(this.feE);
        this.feC.setOnImageClickListener(this.feF);
        this.feC.setOnLongClickListener(this.onLongClickListener);
        this.feC.setTbGestureDetector(this.feG);
    }

    public void onChangeSkinType(int i) {
        this.fez.onChangeSkinType(i);
    }

    public void n(View.OnClickListener onClickListener) {
        this.feD = onClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.feE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.feF = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.feG = cVar;
    }

    public boolean isActive() {
        return this.fex;
    }

    public d aWv() {
        return this.fez;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fey == null) {
            return null;
        }
        return this.fey.getNextPageSourceKeyList();
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
        if ((getPageStayFilter() == null || getPageStayFilter().Gm()) && !StringUtils.isNull(currentPageKey)) {
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
            PbModel aWx = this.fey.aWx();
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
