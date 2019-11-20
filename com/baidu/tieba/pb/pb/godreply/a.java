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
    final PbActivity hJF;
    private d hJG;
    private c hJH;
    private aq hJI;
    private i hJJ;
    private View.OnClickListener hJK;
    private View.OnClickListener hJL;
    private TbRichTextView.h hJM;
    private com.baidu.tieba.pb.a.c hJN;
    private final MoreGodReplyModel hJO;
    private long hJP;
    private boolean isActive;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dIG = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hJO.isLoading()) {
                a.this.hJO.bRC();
            }
        }
    };
    private AbsListView.OnScrollListener hJQ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hJU = -1;

        private boolean wq(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!wq(this.hJU) && wq(i) && a.this.hJF != null && a.this.hJF.bRV() != null) {
                a.this.hJF.bRV().bUY();
                a.this.hJF.bRV().bVU();
            }
            this.hJU = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hJR = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hJI.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aD(List<PostData> list) {
            a.this.bRA();
        }
    };
    private PbActivity.a hJS = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bRx();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hJO = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bRD());
        this.hJO.a(this.hJR);
        this.hJI = aqVar;
        this.hJF = pbActivity;
        this.hJG = new d(pbActivity, viewStub);
        this.hJH = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final Runnable runnable) {
        this.hJO.cancelLoadData();
        this.hJF.bSH();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hJH.bRF()) {
            this.hJG.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hJG.hide();
                    a.this.isActive = false;
                    if (a.this.hJF != null) {
                        if (a.this.hJF.bRV() != null) {
                            a.this.hJF.bRV().oL(false);
                            f bVp = a.this.hJF.bRV().bVp();
                            bVp.a(a.this.hJF.bRD().getPbData(), true);
                            bVp.notifyDataSetChanged();
                        }
                        a.this.hJF.c(a.this.hJS);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hJP != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hJP;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.awx().a(this.hJF, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bRx() {
        n(null);
    }

    private void showView() {
        boolean bRI = this.hJG.bRI();
        this.hJG.show();
        if (!bRI) {
            this.hJG.bRJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bRx();
                }
            });
            this.hJG.bRK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bRx();
                }
            });
            this.hJG.bRM().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hJO.isLoading()) {
                        a.this.hJO.bRC();
                    }
                }
            });
            this.hJG.getListView().setOnScrollListener(this.hJQ);
        }
        this.hJP = System.currentTimeMillis();
    }

    public void bRy() {
        if (!isActive()) {
            this.hJF.bSH();
            this.isActive = true;
            this.hJH.setFullscreen(false);
            this.hJH.nW(true);
            showView();
            bRA();
            this.hJG.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hJH.nW(false);
                }
            });
            this.hJF.b(this.hJS);
            this.hJO.bRC();
        }
        this.hJF.bRV().bVU();
    }

    public void bRz() {
        if (isActive()) {
            bRA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRA() {
        List<m> bRE = this.hJO.bRE();
        if (bRE != null) {
            com.baidu.tieba.pb.data.d pbData = this.hJO.bRD().getPbData();
            this.hJG.show();
            this.hJG.getListView().setOnSrollToBottomListener(this.dIG);
            BdTypeListView listView = this.hJG.getListView();
            this.hJH.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bRE));
            this.hJG.aKP().setCenterTextTitle(String.format(this.hJF.getResources().getString(R.string.more_god_reply_count), com.baidu.tbadk.core.util.aq.numFormatOver10000(pbData.bQI().hJh.size())));
            this.hJG.nX(this.hJO.Pz());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hJJ == null) {
            this.hJJ = new i(this.hJF, PostData.jhw);
            this.hJJ.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hJJ);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hJJ.setData(dVar);
        f bVp = this.hJI.bVp();
        this.hJJ.setFromCDN(bVp.isFromCDN());
        this.hJJ.cD(dVar.bQx().aiE().getUserId());
        this.hJJ.nT(bVp.bTe());
        this.hJJ.w(this.hJK);
        this.hJJ.O(this.hJL);
        this.hJJ.setOnImageClickListener(this.hJM);
        this.hJJ.setOnLongClickListener(this.onLongClickListener);
        this.hJJ.setTbGestureDetector(this.hJN);
    }

    public void onChangeSkinType(int i) {
        this.hJG.onChangeSkinType(i);
    }

    public void w(View.OnClickListener onClickListener) {
        this.hJK = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hJL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hJM = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hJN = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d bRB() {
        return this.hJG;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hJF == null) {
            return null;
        }
        return this.hJF.getNextPageSourceKeyList();
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
            PbModel bRD = this.hJF.bRD();
            if (bRD != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(bRD.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(bRD.bTy(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
