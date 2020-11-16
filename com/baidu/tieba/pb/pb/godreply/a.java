package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    private long lpA;
    final PbFragment lpq;
    private d lpr;
    private c lps;
    private az lpt;
    private m lpu;
    private View.OnClickListener lpv;
    private View.OnClickListener lpw;
    private TbRichTextView.i lpx;
    private com.baidu.tieba.pb.a.c lpy;
    private final MoreGodReplyModel lpz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gDc = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lpz.isLoading()) {
                a.this.lpz.diU();
            }
        }
    };
    private AbsListView.OnScrollListener lpB = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lpF = -1;

        private boolean Ge(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Ge(this.lpF) && Ge(i) && a.this.lpq != null && a.this.lpq.djM() != null) {
                a.this.lpq.djM().dmK();
                a.this.lpq.djM().dnK();
            }
            this.lpF = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a lpC = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lpt.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void af(List<PostData> list) {
            a.this.diS();
        }
    };
    private PbFragment.a lpD = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.diQ();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.lpz = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.diV());
        this.lpz.a(this.lpC);
        this.lpt = azVar;
        this.lpq = pbFragment;
        this.lpr = new d(pbFragment, viewStub);
        this.lps = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.lpz.cancelLoadData();
        this.lpq.dkw();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lps.diX()) {
            this.lpr.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lpr.hide();
                    a.this.isActive = false;
                    if (a.this.lpq != null) {
                        if (a.this.lpq.djM() != null) {
                            a.this.lpq.djM().uV(false);
                            g dnc = a.this.lpq.djM().dnc();
                            dnc.a(a.this.lpq.diV().getPbData(), true);
                            dnc.notifyDataSetChanged();
                        }
                        a.this.lpq.c(a.this.lpD);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lpA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lpA;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bBw().a(this.lpq.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void diQ() {
        t(null);
    }

    private void showView() {
        boolean dja = this.lpr.dja();
        this.lpr.show();
        if (!dja) {
            this.lpr.djb().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.diQ();
                }
            });
            this.lpr.djc().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.diQ();
                }
            });
            this.lpr.dje().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lpz.isLoading()) {
                        a.this.lpz.diU();
                    }
                }
            });
            this.lpr.getListView().setOnScrollListener(this.lpB);
        }
        this.lpA = System.currentTimeMillis();
    }

    public void diR() {
        if (!isActive()) {
            this.lpq.dkw();
            this.isActive = true;
            this.lps.setFullscreen(false);
            this.lps.tZ(true);
            showView();
            diS();
            this.lpr.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lps.tZ(false);
                }
            });
            this.lpq.b(this.lpD);
            this.lpz.diU();
        }
        this.lpq.djM().dnK();
    }

    public void bLW() {
        if (isActive()) {
            diS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diS() {
        List<q> diW = this.lpz.diW();
        if (diW != null) {
            f pbData = this.lpz.diV().getPbData();
            this.lpr.show();
            this.lpr.getListView().setOnSrollToBottomListener(this.gDc);
            BdTypeListView listView = this.lpr.getListView();
            this.lps.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(diW));
            this.lpr.bSa().setCenterTextTitle(String.format(this.lpq.getResources().getString(R.string.more_god_reply_count), au.numFormatOver10000(pbData.dhV().loV.size())));
            this.lpr.ua(this.lpz.aGb());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lpu == null) {
            this.lpu = new m(this.lpq, PostData.mXJ);
            this.lpu.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lpu);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lpu.setData(fVar);
        g dnc = this.lpt.dnc();
        this.lpu.setFromCDN(dnc.isFromCDN());
        this.lpu.hy(fVar.dhH().blC().getUserId());
        this.lpu.tW(dnc.djv());
        this.lpu.B(this.lpv);
        this.lpu.S(this.lpw);
        this.lpu.setOnImageClickListener(this.lpx);
        this.lpu.setOnLongClickListener(this.onLongClickListener);
        this.lpu.setTbGestureDetector(this.lpy);
    }

    public void onChangeSkinType(int i) {
        this.lpr.onChangeSkinType(i);
    }

    public void B(View.OnClickListener onClickListener) {
        this.lpv = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lpw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lpx = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lpy = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d diT() {
        return this.lpr;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lpq == null) {
            return null;
        }
        return this.lpq.getNextPageSourceKeyList();
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
            PbModel diV = this.lpq.diV();
            if (diV != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(diV.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(diV.dkU(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
