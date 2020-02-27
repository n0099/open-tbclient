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
    private BdListView.e eCo = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.iDy.isLoading()) {
                a.this.iDy.cly();
            }
        }
    };
    private AbsListView.OnScrollListener iDA = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int iDE = -1;

        private boolean yE(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!yE(this.iDE) && yE(i) && a.this.iDp != null && a.this.iDp.cmr() != null) {
                a.this.iDp.cmr().cpi();
                a.this.iDp.cmr().cqg();
            }
            this.iDE = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a iDB = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.iDs.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
            a.this.clw();
        }
    };
    private PbFragment.a iDC = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.clt();
            return true;
        }
    };
    final PbFragment iDp;
    private d iDq;
    private c iDr;
    private an iDs;
    private j iDt;
    private View.OnClickListener iDu;
    private View.OnClickListener iDv;
    private TbRichTextView.i iDw;
    private com.baidu.tieba.pb.a.c iDx;
    private final MoreGodReplyModel iDy;
    private long iDz;
    private boolean isActive;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;

    public a(PbFragment pbFragment, an anVar, ViewStub viewStub) {
        this.iDy = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.clz());
        this.iDy.a(this.iDB);
        this.iDs = anVar;
        this.iDp = pbFragment;
        this.iDq = new d(pbFragment, viewStub);
        this.iDr = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.iDy.cancelLoadData();
        this.iDp.cnb();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.iDr.clB()) {
            this.iDq.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iDq.hide();
                    a.this.isActive = false;
                    if (a.this.iDp != null) {
                        if (a.this.iDp.cmr() != null) {
                            a.this.iDp.cmr().qr(false);
                            f cpz = a.this.iDp.cmr().cpz();
                            cpz.a(a.this.iDp.clz().getPbData(), true);
                            cpz.notifyDataSetChanged();
                        }
                        a.this.iDp.c(a.this.iDC);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.iDz != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.iDz;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aQV().a(this.iDp.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void clt() {
        q(null);
    }

    private void showView() {
        boolean clE = this.iDq.clE();
        this.iDq.show();
        if (!clE) {
            this.iDq.clF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clt();
                }
            });
            this.iDq.clG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clt();
                }
            });
            this.iDq.clI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.iDy.isLoading()) {
                        a.this.iDy.cly();
                    }
                }
            });
            this.iDq.getListView().setOnScrollListener(this.iDA);
        }
        this.iDz = System.currentTimeMillis();
    }

    public void clu() {
        if (!isActive()) {
            this.iDp.cnb();
            this.isActive = true;
            this.iDr.setFullscreen(false);
            this.iDr.pz(true);
            showView();
            clw();
            this.iDq.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iDr.pz(false);
                }
            });
            this.iDp.b(this.iDC);
            this.iDy.cly();
        }
        this.iDp.cmr().cqg();
    }

    public void clv() {
        if (isActive()) {
            clw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clw() {
        List<m> clA = this.iDy.clA();
        if (clA != null) {
            com.baidu.tieba.pb.data.e pbData = this.iDy.clz().getPbData();
            this.iDq.show();
            this.iDq.getListView().setOnSrollToBottomListener(this.eCo);
            BdTypeListView listView = this.iDq.getListView();
            this.iDr.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(clA));
            this.iDq.beJ().setCenterTextTitle(String.format(this.iDp.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.ckD().iCR.size())));
            this.iDq.pA(this.iDy.abY());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.iDt == null) {
            this.iDt = new j(this.iDp, PostData.kgr);
            this.iDt.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.iDt);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.iDt.setData(eVar);
        f cpz = this.iDs.cpz();
        this.iDt.setFromCDN(cpz.isFromCDN());
        this.iDt.dI(eVar.cks().aCm().getUserId());
        this.iDt.pw(cpz.cmb());
        this.iDt.y(this.iDu);
        this.iDt.P(this.iDv);
        this.iDt.setOnImageClickListener(this.iDw);
        this.iDt.setOnLongClickListener(this.onLongClickListener);
        this.iDt.setTbGestureDetector(this.iDx);
    }

    public void onChangeSkinType(int i) {
        this.iDq.onChangeSkinType(i);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iDu = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iDv = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iDw = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.iDx = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d clx() {
        return this.iDq;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.iDp == null) {
            return null;
        }
        return this.iDp.getNextPageSourceKeyList();
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
            PbModel clz = this.iDp.clz();
            if (clz != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(clz.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(clz.cnw(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
