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
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment lpb;
    private d lpc;
    private c lpd;
    private az lpe;
    private m lpf;
    private View.OnClickListener lpg;
    private View.OnClickListener lph;
    private TbRichTextView.i lpi;
    private com.baidu.tieba.pb.a.c lpj;
    private final MoreGodReplyModel lpk;
    private long lpl;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gDv = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lpk.isLoading()) {
                a.this.lpk.djy();
            }
        }
    };
    private AbsListView.OnScrollListener lpm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lpq = -1;

        private boolean FG(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!FG(this.lpq) && FG(i) && a.this.lpb != null && a.this.lpb.dkp() != null) {
                a.this.lpb.dkp().dnm();
                a.this.lpb.dkp().dol();
            }
            this.lpq = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a lpn = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lpe.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void af(List<PostData> list) {
            a.this.djw();
        }
    };
    private PbFragment.a lpo = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dju();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.lpk = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.djz());
        this.lpk.a(this.lpn);
        this.lpe = azVar;
        this.lpb = pbFragment;
        this.lpc = new d(pbFragment, viewStub);
        this.lpd = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.lpk.cancelLoadData();
        this.lpb.dkZ();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lpd.djB()) {
            this.lpc.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lpc.hide();
                    a.this.isActive = false;
                    if (a.this.lpb != null) {
                        if (a.this.lpb.dkp() != null) {
                            a.this.lpb.dkp().uS(false);
                            g dnE = a.this.lpb.dkp().dnE();
                            dnE.a(a.this.lpb.djz().getPbData(), true);
                            dnE.notifyDataSetChanged();
                        }
                        a.this.lpb.c(a.this.lpo);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lpl != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lpl;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bCg().a(this.lpb.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dju() {
        t(null);
    }

    private void showView() {
        boolean djE = this.lpc.djE();
        this.lpc.show();
        if (!djE) {
            this.lpc.djF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dju();
                }
            });
            this.lpc.djG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dju();
                }
            });
            this.lpc.djI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lpk.isLoading()) {
                        a.this.lpk.djy();
                    }
                }
            });
            this.lpc.getListView().setOnScrollListener(this.lpm);
        }
        this.lpl = System.currentTimeMillis();
    }

    public void djv() {
        if (!isActive()) {
            this.lpb.dkZ();
            this.isActive = true;
            this.lpd.setFullscreen(false);
            this.lpd.tW(true);
            showView();
            djw();
            this.lpc.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lpd.tW(false);
                }
            });
            this.lpb.b(this.lpo);
            this.lpk.djy();
        }
        this.lpb.dkp().dol();
    }

    public void bMD() {
        if (isActive()) {
            djw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djw() {
        List<q> djA = this.lpk.djA();
        if (djA != null) {
            f pbData = this.lpk.djz().getPbData();
            this.lpc.show();
            this.lpc.getListView().setOnSrollToBottomListener(this.gDv);
            BdTypeListView listView = this.lpc.getListView();
            this.lpd.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(djA));
            this.lpc.bSH().setCenterTextTitle(String.format(this.lpb.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.diy().loE.size())));
            this.lpc.tX(this.lpk.aGJ());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lpf == null) {
            this.lpf = new m(this.lpb, PostData.mWR);
            this.lpf.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lpf);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lpf.setData(fVar);
        g dnE = this.lpe.dnE();
        this.lpf.setFromCDN(dnE.isFromCDN());
        this.lpf.hE(fVar.dik().bmA().getUserId());
        this.lpf.tT(dnE.djZ());
        this.lpf.B(this.lpg);
        this.lpf.T(this.lph);
        this.lpf.setOnImageClickListener(this.lpi);
        this.lpf.setOnLongClickListener(this.onLongClickListener);
        this.lpf.setTbGestureDetector(this.lpj);
    }

    public void onChangeSkinType(int i) {
        this.lpc.onChangeSkinType(i);
    }

    public void B(View.OnClickListener onClickListener) {
        this.lpg = onClickListener;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lph = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lpi = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lpj = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d djx() {
        return this.lpc;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lpb == null) {
            return null;
        }
        return this.lpb.getNextPageSourceKeyList();
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
            PbModel djz = this.lpb.djz();
            if (djz != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(djz.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(djz.dlx(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
