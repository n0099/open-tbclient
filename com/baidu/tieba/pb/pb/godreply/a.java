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
/* loaded from: classes16.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment kyM;
    private d kyN;
    private c kyO;
    private az kyP;
    private m kyQ;
    private View.OnClickListener kyR;
    private View.OnClickListener kyS;
    private TbRichTextView.i kyT;
    private com.baidu.tieba.pb.a.c kyU;
    private final MoreGodReplyModel kyV;
    private long kyW;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fXT = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.kyV.isLoading()) {
                a.this.kyV.cWC();
            }
        }
    };
    private AbsListView.OnScrollListener kyX = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int kzb = -1;

        private boolean DT(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!DT(this.kzb) && DT(i) && a.this.kyM != null && a.this.kyM.cXt() != null) {
                a.this.kyM.cXt().daq();
                a.this.kyM.cXt().dbo();
            }
            this.kzb = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a kyY = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.kyP.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bd(List<PostData> list) {
            a.this.cWA();
        }
    };
    private PbFragment.a kyZ = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cWx();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.kyV = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cWD());
        this.kyV.a(this.kyY);
        this.kyP = azVar;
        this.kyM = pbFragment;
        this.kyN = new d(pbFragment, viewStub);
        this.kyO = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.kyV.cancelLoadData();
        this.kyM.cYd();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.kyO.cWF()) {
            this.kyN.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kyN.hide();
                    a.this.isActive = false;
                    if (a.this.kyM != null) {
                        if (a.this.kyM.cXt() != null) {
                            a.this.kyM.cXt().tC(false);
                            g daH = a.this.kyM.cXt().daH();
                            daH.a(a.this.kyM.cWD().getPbData(), true);
                            daH.notifyDataSetChanged();
                        }
                        a.this.kyM.c(a.this.kyZ);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.kyW != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.kyW;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.btZ().a(this.kyM.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cWx() {
        t(null);
    }

    private void showView() {
        boolean cWI = this.kyN.cWI();
        this.kyN.show();
        if (!cWI) {
            this.kyN.cWJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cWx();
                }
            });
            this.kyN.cWK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cWx();
                }
            });
            this.kyN.cWM().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.kyV.isLoading()) {
                        a.this.kyV.cWC();
                    }
                }
            });
            this.kyN.getListView().setOnScrollListener(this.kyX);
        }
        this.kyW = System.currentTimeMillis();
    }

    public void cWy() {
        if (!isActive()) {
            this.kyM.cYd();
            this.isActive = true;
            this.kyO.setFullscreen(false);
            this.kyO.sG(true);
            showView();
            cWA();
            this.kyN.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kyO.sG(false);
                }
            });
            this.kyM.b(this.kyZ);
            this.kyV.cWC();
        }
        this.kyM.cXt().dbo();
    }

    public void cWz() {
        if (isActive()) {
            cWA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWA() {
        List<q> cWE = this.kyV.cWE();
        if (cWE != null) {
            f pbData = this.kyV.cWD().getPbData();
            this.kyN.show();
            this.kyN.getListView().setOnSrollToBottomListener(this.fXT);
            BdTypeListView listView = this.kyN.getListView();
            this.kyO.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cWE));
            this.kyN.bJH().setCenterTextTitle(String.format(this.kyM.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.cVz().kyp.size())));
            this.kyN.sH(this.kyV.ayX());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.kyQ == null) {
            this.kyQ = new m(this.kyM, PostData.meN);
            this.kyQ.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.kyQ);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.kyQ.setData(fVar);
        g daH = this.kyP.daH();
        this.kyQ.setFromCDN(daH.isFromCDN());
        this.kyQ.gL(fVar.cVl().beE().getUserId());
        this.kyQ.sD(daH.cXd());
        this.kyQ.A(this.kyR);
        this.kyQ.S(this.kyS);
        this.kyQ.setOnImageClickListener(this.kyT);
        this.kyQ.setOnLongClickListener(this.onLongClickListener);
        this.kyQ.setTbGestureDetector(this.kyU);
    }

    public void onChangeSkinType(int i) {
        this.kyN.onChangeSkinType(i);
    }

    public void A(View.OnClickListener onClickListener) {
        this.kyR = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kyS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kyT = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.kyU = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cWB() {
        return this.kyN;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.kyM == null) {
            return null;
        }
        return this.kyM.getNextPageSourceKeyList();
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
            PbModel cWD = this.kyM.cWD();
            if (cWD != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cWD.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cWD.cYB(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
