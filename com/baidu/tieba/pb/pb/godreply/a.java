package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.o.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
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
public class a implements com.baidu.tbadk.o.a {
    private i hKA;
    private View.OnClickListener hKB;
    private View.OnClickListener hKC;
    private TbRichTextView.h hKD;
    private com.baidu.tieba.pb.a.c hKE;
    private final MoreGodReplyModel hKF;
    private long hKG;
    final PbActivity hKw;
    private d hKx;
    private c hKy;
    private aq hKz;
    private boolean isActive;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dJx = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hKF.isLoading()) {
                a.this.hKF.bRE();
            }
        }
    };
    private AbsListView.OnScrollListener hKH = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hKL = -1;

        private boolean wr(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!wr(this.hKL) && wr(i) && a.this.hKw != null && a.this.hKw.bRX() != null) {
                a.this.hKw.bRX().bVa();
                a.this.hKw.bRX().bVW();
            }
            this.hKL = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hKI = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hKz.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aD(List<PostData> list) {
            a.this.bRC();
        }
    };
    private PbActivity.a hKJ = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bRz();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hKF = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bRF());
        this.hKF.a(this.hKI);
        this.hKz = aqVar;
        this.hKw = pbActivity;
        this.hKx = new d(pbActivity, viewStub);
        this.hKy = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final Runnable runnable) {
        this.hKF.cancelLoadData();
        this.hKw.bSJ();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hKy.bRH()) {
            this.hKx.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hKx.hide();
                    a.this.isActive = false;
                    if (a.this.hKw != null) {
                        if (a.this.hKw.bRX() != null) {
                            a.this.hKw.bRX().oL(false);
                            f bVr = a.this.hKw.bRX().bVr();
                            bVr.a(a.this.hKw.bRF().getPbData(), true);
                            bVr.notifyDataSetChanged();
                        }
                        a.this.hKw.c(a.this.hKJ);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hKG != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hKG;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.awz().a(this.hKw, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bRz() {
        n(null);
    }

    private void showView() {
        boolean bRK = this.hKx.bRK();
        this.hKx.show();
        if (!bRK) {
            this.hKx.bRL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bRz();
                }
            });
            this.hKx.bRM().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bRz();
                }
            });
            this.hKx.bRO().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hKF.isLoading()) {
                        a.this.hKF.bRE();
                    }
                }
            });
            this.hKx.getListView().setOnScrollListener(this.hKH);
        }
        this.hKG = System.currentTimeMillis();
    }

    public void bRA() {
        if (!isActive()) {
            this.hKw.bSJ();
            this.isActive = true;
            this.hKy.setFullscreen(false);
            this.hKy.nW(true);
            showView();
            bRC();
            this.hKx.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hKy.nW(false);
                }
            });
            this.hKw.b(this.hKJ);
            this.hKF.bRE();
        }
        this.hKw.bRX().bVW();
    }

    public void bRB() {
        if (isActive()) {
            bRC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRC() {
        List<m> bRG = this.hKF.bRG();
        if (bRG != null) {
            com.baidu.tieba.pb.data.d pbData = this.hKF.bRF().getPbData();
            this.hKx.show();
            this.hKx.getListView().setOnSrollToBottomListener(this.dJx);
            BdTypeListView listView = this.hKx.getListView();
            this.hKy.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bRG));
            this.hKx.aKR().setCenterTextTitle(String.format(this.hKw.getResources().getString(R.string.more_god_reply_count), com.baidu.tbadk.core.util.aq.numFormatOver10000(pbData.bQK().hJY.size())));
            this.hKx.nX(this.hKF.Py());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hKA == null) {
            this.hKA = new i(this.hKw, PostData.jio);
            this.hKA.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hKA);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hKA.setData(dVar);
        f bVr = this.hKz.bVr();
        this.hKA.setFromCDN(bVr.isFromCDN());
        this.hKA.cD(dVar.bQz().aiG().getUserId());
        this.hKA.nT(bVr.bTg());
        this.hKA.w(this.hKB);
        this.hKA.O(this.hKC);
        this.hKA.setOnImageClickListener(this.hKD);
        this.hKA.setOnLongClickListener(this.onLongClickListener);
        this.hKA.setTbGestureDetector(this.hKE);
    }

    public void onChangeSkinType(int i) {
        this.hKx.onChangeSkinType(i);
    }

    public void w(View.OnClickListener onClickListener) {
        this.hKB = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hKC = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hKD = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hKE = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d bRD() {
        return this.hKx;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hKw == null) {
            return null;
        }
        return this.hKw.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.o.d();
            this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
            PbModel bRF = this.hKw.bRF();
            if (bRF != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(bRF.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(bRF.bTA(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
