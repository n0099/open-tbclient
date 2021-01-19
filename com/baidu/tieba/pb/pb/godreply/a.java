package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment lDB;
    private d lDC;
    private c lDD;
    private ap lDE;
    private k lDF;
    private View.OnClickListener lDG;
    private View.OnClickListener lDH;
    private TbRichTextView.i lDI;
    private com.baidu.tieba.pb.a.c lDJ;
    private final MoreGodReplyModel lDK;
    private long lDL;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gTh = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lDK.isLoading()) {
                a.this.lDK.dkc();
            }
        }
    };
    private AbsListView.OnScrollListener lDM = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lDQ = -1;

        private boolean Ff(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Ff(this.lDQ) && Ff(i) && a.this.lDB != null && a.this.lDB.dkW() != null) {
                a.this.lDB.dkW().dnX();
                a.this.lDB.dkW().doY();
            }
            this.lDQ = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ab.a lDN = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lDE.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void ai(List<PostData> list) {
            a.this.dka();
        }
    };
    private PbFragment.a lDO = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.djY();
            return true;
        }
    };

    public a(PbFragment pbFragment, ap apVar, ViewStub viewStub) {
        this.lDK = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dkd());
        this.lDK.a(this.lDN);
        this.lDE = apVar;
        this.lDB = pbFragment;
        this.lDC = new d(pbFragment, viewStub);
        this.lDD = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(final Runnable runnable) {
        this.lDK.cancelLoadData();
        this.lDB.dlG();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lDD.dkf()) {
            this.lDC.u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lDC.hide();
                    a.this.isActive = false;
                    if (a.this.lDB != null) {
                        if (a.this.lDB.dkW() != null) {
                            a.this.lDB.dkW().vv(false);
                            g dop = a.this.lDB.dkW().dop();
                            dop.a(a.this.lDB.dkd().getPbData(), true);
                            dop.notifyDataSetChanged();
                        }
                        a.this.lDB.c(a.this.lDO);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lDL != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lDL;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bDA().a(this.lDB.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void djY() {
        s(null);
    }

    private void showView() {
        boolean dki = this.lDC.dki();
        this.lDC.show();
        if (!dki) {
            this.lDC.dkj().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.djY();
                }
            });
            this.lDC.dkk().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.djY();
                }
            });
            this.lDC.dkm().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lDK.isLoading()) {
                        a.this.lDK.dkc();
                    }
                }
            });
            this.lDC.getListView().setOnScrollListener(this.lDM);
        }
        this.lDL = System.currentTimeMillis();
    }

    public void djZ() {
        if (!isActive()) {
            this.lDB.dlG();
            this.isActive = true;
            this.lDD.setFullscreen(false);
            this.lDD.uy(true);
            showView();
            dka();
            this.lDC.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lDD.uy(false);
                }
            });
            this.lDB.b(this.lDO);
            this.lDK.dkc();
        }
        this.lDB.dkW().doY();
    }

    public void bOp() {
        if (isActive()) {
            dka();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dka() {
        List<n> dke = this.lDK.dke();
        if (dke != null) {
            f pbData = this.lDK.dkd().getPbData();
            this.lDC.show();
            this.lDC.getListView().setOnSrollToBottomListener(this.gTh);
            BdTypeListView listView = this.lDC.getListView();
            this.lDD.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dke));
            this.lDC.bUz().setCenterTextTitle(String.format(this.lDB.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.djb().lCT.size())));
            this.lDC.uz(this.lDK.aHa());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lDF == null) {
            this.lDF = new k(this.lDB, PostData.nmO);
            this.lDF.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lDF);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lDF.setData(fVar);
        g dop = this.lDE.dop();
        this.lDF.setFromCDN(dop.isFromCDN());
        this.lDF.gy(fVar.diN().bnx().getUserId());
        this.lDF.uv(dop.dkF());
        this.lDF.C(this.lDG);
        this.lDF.U(this.lDH);
        this.lDF.setOnImageClickListener(this.lDI);
        this.lDF.setOnLongClickListener(this.onLongClickListener);
        this.lDF.setTbGestureDetector(this.lDJ);
    }

    public void onChangeSkinType(int i) {
        this.lDC.onChangeSkinType(i);
    }

    public void C(View.OnClickListener onClickListener) {
        this.lDG = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lDH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lDI = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lDJ = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d dkb() {
        return this.lDC;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lDB == null) {
            return null;
        }
        return this.lDB.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (x.isEmpty(arrayList2)) {
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

    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.m.d();
            this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
            PbModel dkd = this.lDB.dkd();
            if (dkd != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dkd.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dkd.dme(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
