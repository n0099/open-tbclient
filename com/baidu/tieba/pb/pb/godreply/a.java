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
    final PbFragment iDD;
    private d iDE;
    private c iDF;
    private an iDG;
    private j iDH;
    private View.OnClickListener iDI;
    private View.OnClickListener iDJ;
    private TbRichTextView.i iDK;
    private com.baidu.tieba.pb.a.c iDL;
    private final MoreGodReplyModel iDM;
    private long iDN;
    private boolean isActive;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e eCC = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.iDM.isLoading()) {
                a.this.iDM.clB();
            }
        }
    };
    private AbsListView.OnScrollListener iDO = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int iDS = -1;

        private boolean yE(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!yE(this.iDS) && yE(i) && a.this.iDD != null && a.this.iDD.cmu() != null) {
                a.this.iDD.cmu().cpl();
                a.this.iDD.cmu().cqj();
            }
            this.iDS = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a iDP = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.iDG.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
            a.this.clz();
        }
    };
    private PbFragment.a iDQ = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.clw();
            return true;
        }
    };

    public a(PbFragment pbFragment, an anVar, ViewStub viewStub) {
        this.iDM = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.clC());
        this.iDM.a(this.iDP);
        this.iDG = anVar;
        this.iDD = pbFragment;
        this.iDE = new d(pbFragment, viewStub);
        this.iDF = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.iDM.cancelLoadData();
        this.iDD.cne();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.iDF.clE()) {
            this.iDE.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iDE.hide();
                    a.this.isActive = false;
                    if (a.this.iDD != null) {
                        if (a.this.iDD.cmu() != null) {
                            a.this.iDD.cmu().qr(false);
                            f cpC = a.this.iDD.cmu().cpC();
                            cpC.a(a.this.iDD.clC().getPbData(), true);
                            cpC.notifyDataSetChanged();
                        }
                        a.this.iDD.c(a.this.iDQ);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.iDN != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.iDN;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aQY().a(this.iDD.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void clw() {
        q(null);
    }

    private void showView() {
        boolean clH = this.iDE.clH();
        this.iDE.show();
        if (!clH) {
            this.iDE.clI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clw();
                }
            });
            this.iDE.clJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clw();
                }
            });
            this.iDE.clL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.iDM.isLoading()) {
                        a.this.iDM.clB();
                    }
                }
            });
            this.iDE.getListView().setOnScrollListener(this.iDO);
        }
        this.iDN = System.currentTimeMillis();
    }

    public void clx() {
        if (!isActive()) {
            this.iDD.cne();
            this.isActive = true;
            this.iDF.setFullscreen(false);
            this.iDF.pz(true);
            showView();
            clz();
            this.iDE.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iDF.pz(false);
                }
            });
            this.iDD.b(this.iDQ);
            this.iDM.clB();
        }
        this.iDD.cmu().cqj();
    }

    public void cly() {
        if (isActive()) {
            clz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clz() {
        List<m> clD = this.iDM.clD();
        if (clD != null) {
            com.baidu.tieba.pb.data.e pbData = this.iDM.clC().getPbData();
            this.iDE.show();
            this.iDE.getListView().setOnSrollToBottomListener(this.eCC);
            BdTypeListView listView = this.iDE.getListView();
            this.iDF.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(clD));
            this.iDE.beM().setCenterTextTitle(String.format(this.iDD.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.ckG().iDf.size())));
            this.iDE.pA(this.iDM.aca());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.iDH == null) {
            this.iDH = new j(this.iDD, PostData.kgF);
            this.iDH.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.iDH);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.iDH.setData(eVar);
        f cpC = this.iDG.cpC();
        this.iDH.setFromCDN(cpC.isFromCDN());
        this.iDH.dI(eVar.ckv().aCo().getUserId());
        this.iDH.pw(cpC.cme());
        this.iDH.y(this.iDI);
        this.iDH.P(this.iDJ);
        this.iDH.setOnImageClickListener(this.iDK);
        this.iDH.setOnLongClickListener(this.onLongClickListener);
        this.iDH.setTbGestureDetector(this.iDL);
    }

    public void onChangeSkinType(int i) {
        this.iDE.onChangeSkinType(i);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iDI = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iDJ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iDK = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.iDL = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d clA() {
        return this.iDE;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.iDD == null) {
            return null;
        }
        return this.iDD.getNextPageSourceKeyList();
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
            PbModel clC = this.iDD.clC();
            if (clC != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(clC.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(clC.cnz(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
