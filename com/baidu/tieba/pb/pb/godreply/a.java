package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
    private long lMA;
    final PbFragment lMq;
    private d lMr;
    private c lMs;
    private ap lMt;
    private k lMu;
    private View.OnClickListener lMv;
    private View.OnClickListener lMw;
    private TbRichTextView.i lMx;
    private com.baidu.tieba.pb.a.c lMy;
    private final MoreGodReplyModel lMz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gVR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lMz.isLoading()) {
                a.this.lMz.dmp();
            }
        }
    };
    private AbsListView.OnScrollListener lMB = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lMF = -1;

        private boolean Fy(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Fy(this.lMF) && Fy(i) && a.this.lMq != null && a.this.lMq.dnk() != null) {
                a.this.lMq.dnk().dql();
                a.this.lMq.dnk().drm();
            }
            this.lMF = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ab.a lMC = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lMt.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void aj(List<PostData> list) {
            a.this.dmn();
        }
    };
    private PbFragment.a lMD = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dml();
            return true;
        }
    };

    public a(PbFragment pbFragment, ap apVar, ViewStub viewStub) {
        this.lMz = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dmq());
        this.lMz.a(this.lMC);
        this.lMt = apVar;
        this.lMq = pbFragment;
        this.lMr = new d(pbFragment, viewStub);
        this.lMs = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.lMz.cancelLoadData();
        this.lMq.dnV();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lMs.dms()) {
            this.lMr.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lMr.hide();
                    a.this.isActive = false;
                    if (a.this.lMq != null) {
                        if (a.this.lMq.dnk() != null) {
                            a.this.lMq.dnk().vK(false);
                            g dqD = a.this.lMq.dnk().dqD();
                            dqD.a(a.this.lMq.dmq().getPbData(), true);
                            dqD.notifyDataSetChanged();
                        }
                        a.this.lMq.c(a.this.lMD);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lMA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lMA;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bDS().a(this.lMq.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dml() {
        q(null);
    }

    private void showView() {
        boolean dmv = this.lMr.dmv();
        this.lMr.show();
        if (!dmv) {
            this.lMr.dmw().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dml();
                }
            });
            this.lMr.dmx().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dml();
                }
            });
            this.lMr.dmz().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lMz.isLoading()) {
                        a.this.lMz.dmp();
                    }
                }
            });
            this.lMr.getListView().setOnScrollListener(this.lMB);
        }
        this.lMA = System.currentTimeMillis();
    }

    public void dmm() {
        if (!isActive()) {
            this.lMq.dnV();
            this.isActive = true;
            this.lMs.setFullscreen(false);
            this.lMs.uM(true);
            showView();
            dmn();
            this.lMr.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lMs.uM(false);
                }
            });
            this.lMq.b(this.lMD);
            this.lMz.dmp();
        }
        this.lMq.dnk().drm();
    }

    public void bOT() {
        if (isActive()) {
            dmn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmn() {
        List<n> dmr = this.lMz.dmr();
        if (dmr != null) {
            f pbData = this.lMz.dmq().getPbData();
            this.lMr.show();
            this.lMr.getListView().setOnSrollToBottomListener(this.gVR);
            BdTypeListView listView = this.lMr.getListView();
            this.lMs.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dmr));
            this.lMr.bVd().setCenterTextTitle(String.format(this.lMq.getResources().getString(R.string.more_god_reply_count), au.numFormatOver10000(pbData.dln().lLI.size())));
            this.lMr.uN(this.lMz.aHt());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lMu == null) {
            this.lMu = new k(this.lMq, PostData.nwy);
            this.lMu.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lMu);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lMu.setData(fVar);
        g dqD = this.lMt.dqD();
        this.lMu.setFromCDN(dqD.isFromCDN());
        this.lMu.gW(fVar.dkZ().bnQ().getUserId());
        this.lMu.uJ(dqD.dmS());
        this.lMu.C(this.lMv);
        this.lMu.U(this.lMw);
        this.lMu.setOnImageClickListener(this.lMx);
        this.lMu.setOnLongClickListener(this.onLongClickListener);
        this.lMu.setTbGestureDetector(this.lMy);
    }

    public void onChangeSkinType(int i) {
        this.lMr.onChangeSkinType(i);
    }

    public void C(View.OnClickListener onClickListener) {
        this.lMv = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lMw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lMx = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lMy = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d dmo() {
        return this.lMr;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lMq == null) {
            return null;
        }
        return this.lMq.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (y.isEmpty(arrayList2)) {
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
            PbModel dmq = this.lMq.dmq();
            if (dmq != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dmq.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dmq.dot(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
