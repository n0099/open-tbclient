package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.m.a {
    final PbFragment iFe;
    private d iFf;
    private c iFg;
    private an iFh;
    private j iFi;
    private View.OnClickListener iFj;
    private View.OnClickListener iFk;
    private TbRichTextView.i iFl;
    private com.baidu.tieba.pb.a.c iFm;
    private final MoreGodReplyModel iFn;
    private long iFo;
    private boolean isActive;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e eCY = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.iFn.isLoading()) {
                a.this.iFn.clW();
            }
        }
    };
    private AbsListView.OnScrollListener iFp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int iFt = -1;

        private boolean yM(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!yM(this.iFt) && yM(i) && a.this.iFe != null && a.this.iFe.cmP() != null) {
                a.this.iFe.cmP().cpG();
                a.this.iFe.cmP().cqE();
            }
            this.iFt = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a iFq = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.iFh.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
            a.this.clU();
        }
    };
    private PbFragment.a iFr = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.clR();
            return true;
        }
    };

    public a(PbFragment pbFragment, an anVar, ViewStub viewStub) {
        this.iFn = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.clX());
        this.iFn.a(this.iFq);
        this.iFh = anVar;
        this.iFe = pbFragment;
        this.iFf = new d(pbFragment, viewStub);
        this.iFg = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.iFn.cancelLoadData();
        this.iFe.cnz();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.iFg.clZ()) {
            this.iFf.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iFf.hide();
                    a.this.isActive = false;
                    if (a.this.iFe != null) {
                        if (a.this.iFe.cmP() != null) {
                            a.this.iFe.cmP().qx(false);
                            f cpX = a.this.iFe.cmP().cpX();
                            cpX.a(a.this.iFe.clX().getPbData(), true);
                            cpX.notifyDataSetChanged();
                        }
                        a.this.iFe.c(a.this.iFr);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.iFo != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.iFo;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aRc().a(this.iFe.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void clR() {
        q(null);
    }

    private void showView() {
        boolean cmc = this.iFf.cmc();
        this.iFf.show();
        if (!cmc) {
            this.iFf.cmd().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clR();
                }
            });
            this.iFf.cme().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clR();
                }
            });
            this.iFf.cmg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.iFn.isLoading()) {
                        a.this.iFn.clW();
                    }
                }
            });
            this.iFf.getListView().setOnScrollListener(this.iFp);
        }
        this.iFo = System.currentTimeMillis();
    }

    public void clS() {
        if (!isActive()) {
            this.iFe.cnz();
            this.isActive = true;
            this.iFg.setFullscreen(false);
            this.iFg.pF(true);
            showView();
            clU();
            this.iFf.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iFg.pF(false);
                }
            });
            this.iFe.b(this.iFr);
            this.iFn.clW();
        }
        this.iFe.cmP().cqE();
    }

    public void clT() {
        if (isActive()) {
            clU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clU() {
        List<m> clY = this.iFn.clY();
        if (clY != null) {
            com.baidu.tieba.pb.data.e pbData = this.iFn.clX().getPbData();
            this.iFf.show();
            this.iFf.getListView().setOnSrollToBottomListener(this.eCY);
            BdTypeListView listView = this.iFf.getListView();
            this.iFg.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(clY));
            this.iFf.beR().setCenterTextTitle(String.format(this.iFe.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.cla().iEG.size())));
            this.iFf.pG(this.iFn.acd());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.iFi == null) {
            this.iFi = new j(this.iFe, PostData.kii);
            this.iFi.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.iFi);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.iFi.setData(eVar);
        f cpX = this.iFh.cpX();
        this.iFi.setFromCDN(cpX.isFromCDN());
        this.iFi.dH(eVar.ckP().aCr().getUserId());
        this.iFi.pC(cpX.cmz());
        this.iFi.y(this.iFj);
        this.iFi.P(this.iFk);
        this.iFi.setOnImageClickListener(this.iFl);
        this.iFi.setOnLongClickListener(this.onLongClickListener);
        this.iFi.setTbGestureDetector(this.iFm);
    }

    public void onChangeSkinType(int i) {
        this.iFf.onChangeSkinType(i);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iFj = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iFk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iFl = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.iFm = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d clV() {
        return this.iFf;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.iFe == null) {
            return null;
        }
        return this.iFe.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.m.a
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

    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.m.d();
            this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
            PbModel clX = this.iFe.clX();
            if (clX != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(clX.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(clX.cnU(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
