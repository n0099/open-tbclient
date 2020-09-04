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
    final PbFragment kyT;
    private d kyU;
    private c kyV;
    private az kyW;
    private m kyX;
    private View.OnClickListener kyY;
    private View.OnClickListener kyZ;
    private TbRichTextView.i kza;
    private com.baidu.tieba.pb.a.c kzb;
    private final MoreGodReplyModel kzc;
    private long kzd;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fXX = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.kzc.isLoading()) {
                a.this.kzc.cWD();
            }
        }
    };
    private AbsListView.OnScrollListener kze = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int kzi = -1;

        private boolean DT(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!DT(this.kzi) && DT(i) && a.this.kyT != null && a.this.kyT.cXu() != null) {
                a.this.kyT.cXu().dar();
                a.this.kyT.cXu().dbp();
            }
            this.kzi = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a kzf = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.kyW.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bd(List<PostData> list) {
            a.this.cWB();
        }
    };
    private PbFragment.a kzg = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cWy();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.kzc = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cWE());
        this.kzc.a(this.kzf);
        this.kyW = azVar;
        this.kyT = pbFragment;
        this.kyU = new d(pbFragment, viewStub);
        this.kyV = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.kzc.cancelLoadData();
        this.kyT.cYe();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.kyV.cWG()) {
            this.kyU.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kyU.hide();
                    a.this.isActive = false;
                    if (a.this.kyT != null) {
                        if (a.this.kyT.cXu() != null) {
                            a.this.kyT.cXu().tE(false);
                            g daI = a.this.kyT.cXu().daI();
                            daI.a(a.this.kyT.cWE().getPbData(), true);
                            daI.notifyDataSetChanged();
                        }
                        a.this.kyT.c(a.this.kzg);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.kzd != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.kzd;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bua().a(this.kyT.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cWy() {
        t(null);
    }

    private void showView() {
        boolean cWJ = this.kyU.cWJ();
        this.kyU.show();
        if (!cWJ) {
            this.kyU.cWK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cWy();
                }
            });
            this.kyU.cWL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cWy();
                }
            });
            this.kyU.cWN().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.kzc.isLoading()) {
                        a.this.kzc.cWD();
                    }
                }
            });
            this.kyU.getListView().setOnScrollListener(this.kze);
        }
        this.kzd = System.currentTimeMillis();
    }

    public void cWz() {
        if (!isActive()) {
            this.kyT.cYe();
            this.isActive = true;
            this.kyV.setFullscreen(false);
            this.kyV.sI(true);
            showView();
            cWB();
            this.kyU.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kyV.sI(false);
                }
            });
            this.kyT.b(this.kzg);
            this.kzc.cWD();
        }
        this.kyT.cXu().dbp();
    }

    public void cWA() {
        if (isActive()) {
            cWB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWB() {
        List<q> cWF = this.kzc.cWF();
        if (cWF != null) {
            f pbData = this.kzc.cWE().getPbData();
            this.kyU.show();
            this.kyU.getListView().setOnSrollToBottomListener(this.fXX);
            BdTypeListView listView = this.kyU.getListView();
            this.kyV.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cWF));
            this.kyU.bJI().setCenterTextTitle(String.format(this.kyT.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.cVA().kyw.size())));
            this.kyU.sJ(this.kzc.ayX());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.kyX == null) {
            this.kyX = new m(this.kyT, PostData.mfc);
            this.kyX.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.kyX);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.kyX.setData(fVar);
        g daI = this.kyW.daI();
        this.kyX.setFromCDN(daI.isFromCDN());
        this.kyX.gM(fVar.cVm().beE().getUserId());
        this.kyX.sF(daI.cXe());
        this.kyX.A(this.kyY);
        this.kyX.S(this.kyZ);
        this.kyX.setOnImageClickListener(this.kza);
        this.kyX.setOnLongClickListener(this.onLongClickListener);
        this.kyX.setTbGestureDetector(this.kzb);
    }

    public void onChangeSkinType(int i) {
        this.kyU.onChangeSkinType(i);
    }

    public void A(View.OnClickListener onClickListener) {
        this.kyY = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kyZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kza = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.kzb = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cWC() {
        return this.kyU;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.kyT == null) {
            return null;
        }
        return this.kyT.getNextPageSourceKeyList();
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
            PbModel cWE = this.kyT.cWE();
            if (cWE != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cWE.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cWE.cYC(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
