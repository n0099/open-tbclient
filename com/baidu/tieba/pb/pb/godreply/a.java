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
    final PbFragment kWB;
    private d kWC;
    private c kWD;
    private az kWE;
    private m kWF;
    private View.OnClickListener kWG;
    private View.OnClickListener kWH;
    private TbRichTextView.i kWI;
    private com.baidu.tieba.pb.a.c kWJ;
    private final MoreGodReplyModel kWK;
    private long kWL;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gnC = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.kWK.isLoading()) {
                a.this.kWK.ddP();
            }
        }
    };
    private AbsListView.OnScrollListener kWM = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int kWQ = -1;

        private boolean Fa(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Fa(this.kWQ) && Fa(i) && a.this.kWB != null && a.this.kWB.deG() != null) {
                a.this.kWB.deG().dhD();
                a.this.kWB.deG().diB();
            }
            this.kWQ = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a kWN = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.kWE.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bk(List<PostData> list) {
            a.this.ddN();
        }
    };
    private PbFragment.a kWO = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.ddK();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.kWK = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.ddQ());
        this.kWK.a(this.kWN);
        this.kWE = azVar;
        this.kWB = pbFragment;
        this.kWC = new d(pbFragment, viewStub);
        this.kWD = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.kWK.cancelLoadData();
        this.kWB.dfq();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.kWD.ddS()) {
            this.kWC.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kWC.hide();
                    a.this.isActive = false;
                    if (a.this.kWB != null) {
                        if (a.this.kWB.deG() != null) {
                            a.this.kWB.deG().us(false);
                            g dhU = a.this.kWB.deG().dhU();
                            dhU.a(a.this.kWB.ddQ().getPbData(), true);
                            dhU.notifyDataSetChanged();
                        }
                        a.this.kWB.c(a.this.kWO);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.kWL != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.kWL;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bxO().a(this.kWB.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void ddK() {
        t(null);
    }

    private void showView() {
        boolean ddV = this.kWC.ddV();
        this.kWC.show();
        if (!ddV) {
            this.kWC.ddW().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ddK();
                }
            });
            this.kWC.ddX().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ddK();
                }
            });
            this.kWC.ddZ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.kWK.isLoading()) {
                        a.this.kWK.ddP();
                    }
                }
            });
            this.kWC.getListView().setOnScrollListener(this.kWM);
        }
        this.kWL = System.currentTimeMillis();
    }

    public void ddL() {
        if (!isActive()) {
            this.kWB.dfq();
            this.isActive = true;
            this.kWD.setFullscreen(false);
            this.kWD.tw(true);
            showView();
            ddN();
            this.kWC.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kWD.tw(false);
                }
            });
            this.kWB.b(this.kWO);
            this.kWK.ddP();
        }
        this.kWB.deG().diB();
    }

    public void ddM() {
        if (isActive()) {
            ddN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddN() {
        List<q> ddR = this.kWK.ddR();
        if (ddR != null) {
            f pbData = this.kWK.ddQ().getPbData();
            this.kWC.show();
            this.kWC.getListView().setOnSrollToBottomListener(this.gnC);
            BdTypeListView listView = this.kWC.getListView();
            this.kWD.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(ddR));
            this.kWC.bNC().setCenterTextTitle(String.format(this.kWB.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.dcO().kWe.size())));
            this.kWC.tx(this.kWK.aCp());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.kWF == null) {
            this.kWF = new m(this.kWB, PostData.mEh);
            this.kWF.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.kWF);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.kWF.setData(fVar);
        g dhU = this.kWE.dhU();
        this.kWF.setFromCDN(dhU.isFromCDN());
        this.kWF.hp(fVar.dcA().bih().getUserId());
        this.kWF.tt(dhU.deq());
        this.kWF.A(this.kWG);
        this.kWF.S(this.kWH);
        this.kWF.setOnImageClickListener(this.kWI);
        this.kWF.setOnLongClickListener(this.onLongClickListener);
        this.kWF.setTbGestureDetector(this.kWJ);
    }

    public void onChangeSkinType(int i) {
        this.kWC.onChangeSkinType(i);
    }

    public void A(View.OnClickListener onClickListener) {
        this.kWG = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kWH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kWI = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.kWJ = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d ddO() {
        return this.kWC;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.kWB == null) {
            return null;
        }
        return this.kWB.getNextPageSourceKeyList();
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
            PbModel ddQ = this.kWB.ddQ();
            if (ddQ != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(ddQ.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(ddQ.dfO(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
