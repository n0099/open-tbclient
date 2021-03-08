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
    final PbFragment lOH;
    private d lOI;
    private c lOJ;
    private ap lOK;
    private k lOL;
    private View.OnClickListener lOM;
    private View.OnClickListener lON;
    private TbRichTextView.i lOO;
    private com.baidu.tieba.pb.a.c lOP;
    private final MoreGodReplyModel lOQ;
    private long lOR;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gXO = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lOQ.isLoading()) {
                a.this.lOQ.dmF();
            }
        }
    };
    private AbsListView.OnScrollListener lOS = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lOW = -1;

        private boolean FB(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!FB(this.lOW) && FB(i) && a.this.lOH != null && a.this.lOH.dnB() != null) {
                a.this.lOH.dnB().dqB();
                a.this.lOH.dnB().drC();
            }
            this.lOW = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ab.a lOT = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lOK.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void aj(List<PostData> list) {
            a.this.dmD();
        }
    };
    private PbFragment.a lOU = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dmB();
            return true;
        }
    };

    public a(PbFragment pbFragment, ap apVar, ViewStub viewStub) {
        this.lOQ = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dmG());
        this.lOQ.a(this.lOT);
        this.lOK = apVar;
        this.lOH = pbFragment;
        this.lOI = new d(pbFragment, viewStub);
        this.lOJ = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(final Runnable runnable) {
        this.lOQ.cancelLoadData();
        this.lOH.dol();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lOJ.dmI()) {
            this.lOI.r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lOI.hide();
                    a.this.isActive = false;
                    if (a.this.lOH != null) {
                        if (a.this.lOH.dnB() != null) {
                            a.this.lOH.dnB().vK(false);
                            g dqT = a.this.lOH.dnB().dqT();
                            dqT.a(a.this.lOH.dmG().getPbData(), true);
                            dqT.notifyDataSetChanged();
                        }
                        a.this.lOH.c(a.this.lOU);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lOR != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lOR;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bDW().a(this.lOH.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dmB() {
        p(null);
    }

    private void showView() {
        boolean dmL = this.lOI.dmL();
        this.lOI.show();
        if (!dmL) {
            this.lOI.dmM().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dmB();
                }
            });
            this.lOI.dmN().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dmB();
                }
            });
            this.lOI.dmP().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lOQ.isLoading()) {
                        a.this.lOQ.dmF();
                    }
                }
            });
            this.lOI.getListView().setOnScrollListener(this.lOS);
        }
        this.lOR = System.currentTimeMillis();
    }

    public void dmC() {
        if (!isActive()) {
            this.lOH.dol();
            this.isActive = true;
            this.lOJ.setFullscreen(false);
            this.lOJ.uM(true);
            showView();
            dmD();
            this.lOI.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lOJ.uM(false);
                }
            });
            this.lOH.b(this.lOU);
            this.lOQ.dmF();
        }
        this.lOH.dnB().drC();
    }

    public void bPg() {
        if (isActive()) {
            dmD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmD() {
        List<n> dmH = this.lOQ.dmH();
        if (dmH != null) {
            f pbData = this.lOQ.dmG().getPbData();
            this.lOI.show();
            this.lOI.getListView().setOnSrollToBottomListener(this.gXO);
            BdTypeListView listView = this.lOI.getListView();
            this.lOJ.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dmH));
            this.lOI.bVq().setCenterTextTitle(String.format(this.lOH.getResources().getString(R.string.more_god_reply_count), au.numFormatOver10000(pbData.dlD().lNZ.size())));
            this.lOI.uN(this.lOQ.aHw());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lOL == null) {
            this.lOL = new k(this.lOH, PostData.nzd);
            this.lOL.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lOL);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lOL.setData(fVar);
        g dqT = this.lOK.dqT();
        this.lOL.setFromCDN(dqT.isFromCDN());
        this.lOL.hc(fVar.dlp().bnS().getUserId());
        this.lOL.uJ(dqT.dni());
        this.lOL.C(this.lOM);
        this.lOL.V(this.lON);
        this.lOL.setOnImageClickListener(this.lOO);
        this.lOL.setOnLongClickListener(this.onLongClickListener);
        this.lOL.setTbGestureDetector(this.lOP);
    }

    public void onChangeSkinType(int i) {
        this.lOI.onChangeSkinType(i);
    }

    public void C(View.OnClickListener onClickListener) {
        this.lOM = onClickListener;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lON = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lOO = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lOP = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d dmE() {
        return this.lOI;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lOH == null) {
            return null;
        }
        return this.lOH.getNextPageSourceKeyList();
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
            PbModel dmG = this.lOH.dmG();
            if (dmG != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dmG.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dmG.doJ(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
