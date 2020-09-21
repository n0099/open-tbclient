package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.at;
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
    private long kHA;
    final PbFragment kHq;
    private d kHr;
    private c kHs;
    private az kHt;
    private m kHu;
    private View.OnClickListener kHv;
    private View.OnClickListener kHw;
    private TbRichTextView.i kHx;
    private com.baidu.tieba.pb.a.c kHy;
    private final MoreGodReplyModel kHz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gbl = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.kHz.isLoading()) {
                a.this.kHz.dag();
            }
        }
    };
    private AbsListView.OnScrollListener kHB = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int kHF = -1;

        private boolean Eu(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Eu(this.kHF) && Eu(i) && a.this.kHq != null && a.this.kHq.daX() != null) {
                a.this.kHq.daX().ddU();
                a.this.kHq.daX().deS();
            }
            this.kHF = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a kHC = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.kHt.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bh(List<PostData> list) {
            a.this.dae();
        }
    };
    private PbFragment.a kHD = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dab();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.kHz = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dah());
        this.kHz.a(this.kHC);
        this.kHt = azVar;
        this.kHq = pbFragment;
        this.kHr = new d(pbFragment, viewStub);
        this.kHs = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.kHz.cancelLoadData();
        this.kHq.dbH();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.kHs.daj()) {
            this.kHr.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kHr.hide();
                    a.this.isActive = false;
                    if (a.this.kHq != null) {
                        if (a.this.kHq.daX() != null) {
                            a.this.kHq.daX().tL(false);
                            g del = a.this.kHq.daX().del();
                            del.a(a.this.kHq.dah().getPbData(), true);
                            del.notifyDataSetChanged();
                        }
                        a.this.kHq.c(a.this.kHD);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.kHA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.kHA;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bve().a(this.kHq.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dab() {
        t(null);
    }

    private void showView() {
        boolean dam = this.kHr.dam();
        this.kHr.show();
        if (!dam) {
            this.kHr.dan().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dab();
                }
            });
            this.kHr.dao().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dab();
                }
            });
            this.kHr.daq().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.kHz.isLoading()) {
                        a.this.kHz.dag();
                    }
                }
            });
            this.kHr.getListView().setOnScrollListener(this.kHB);
        }
        this.kHA = System.currentTimeMillis();
    }

    public void dac() {
        if (!isActive()) {
            this.kHq.dbH();
            this.isActive = true;
            this.kHs.setFullscreen(false);
            this.kHs.sP(true);
            showView();
            dae();
            this.kHr.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kHs.sP(false);
                }
            });
            this.kHq.b(this.kHD);
            this.kHz.dag();
        }
        this.kHq.daX().deS();
    }

    public void dad() {
        if (isActive()) {
            dae();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dae() {
        List<q> dai = this.kHz.dai();
        if (dai != null) {
            f pbData = this.kHz.dah().getPbData();
            this.kHr.show();
            this.kHr.getListView().setOnSrollToBottomListener(this.gbl);
            BdTypeListView listView = this.kHr.getListView();
            this.kHs.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dai));
            this.kHr.bKS().setCenterTextTitle(String.format(this.kHq.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.cZf().kGT.size())));
            this.kHr.sQ(this.kHz.azG());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.kHu == null) {
            this.kHu = new m(this.kHq, PostData.moB);
            this.kHu.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.kHu);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.kHu.setData(fVar);
        g del = this.kHt.del();
        this.kHu.setFromCDN(del.isFromCDN());
        this.kHu.gY(fVar.cYR().bfy().getUserId());
        this.kHu.sM(del.daH());
        this.kHu.A(this.kHv);
        this.kHu.S(this.kHw);
        this.kHu.setOnImageClickListener(this.kHx);
        this.kHu.setOnLongClickListener(this.onLongClickListener);
        this.kHu.setTbGestureDetector(this.kHy);
    }

    public void onChangeSkinType(int i) {
        this.kHr.onChangeSkinType(i);
    }

    public void A(View.OnClickListener onClickListener) {
        this.kHv = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kHw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kHx = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.kHy = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d daf() {
        return this.kHr;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.kHq == null) {
            return null;
        }
        return this.kHq.getNextPageSourceKeyList();
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
            PbModel dah = this.kHq.dah();
            if (dah != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dah.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dah.dcf(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
