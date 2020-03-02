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
    private final MoreGodReplyModel iDA;
    private long iDB;
    final PbFragment iDr;
    private d iDs;
    private c iDt;
    private an iDu;
    private j iDv;
    private View.OnClickListener iDw;
    private View.OnClickListener iDx;
    private TbRichTextView.i iDy;
    private com.baidu.tieba.pb.a.c iDz;
    private boolean isActive;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e eCp = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.iDA.isLoading()) {
                a.this.iDA.clA();
            }
        }
    };
    private AbsListView.OnScrollListener iDC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int iDG = -1;

        private boolean yE(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!yE(this.iDG) && yE(i) && a.this.iDr != null && a.this.iDr.cmt() != null) {
                a.this.iDr.cmt().cpk();
                a.this.iDr.cmt().cqi();
            }
            this.iDG = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a iDD = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.iDu.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
            a.this.cly();
        }
    };
    private PbFragment.a iDE = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.clv();
            return true;
        }
    };

    public a(PbFragment pbFragment, an anVar, ViewStub viewStub) {
        this.iDA = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.clB());
        this.iDA.a(this.iDD);
        this.iDu = anVar;
        this.iDr = pbFragment;
        this.iDs = new d(pbFragment, viewStub);
        this.iDt = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.iDA.cancelLoadData();
        this.iDr.cnd();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.iDt.clD()) {
            this.iDs.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iDs.hide();
                    a.this.isActive = false;
                    if (a.this.iDr != null) {
                        if (a.this.iDr.cmt() != null) {
                            a.this.iDr.cmt().qr(false);
                            f cpB = a.this.iDr.cmt().cpB();
                            cpB.a(a.this.iDr.clB().getPbData(), true);
                            cpB.notifyDataSetChanged();
                        }
                        a.this.iDr.c(a.this.iDE);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.iDB != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.iDB;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aQX().a(this.iDr.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void clv() {
        q(null);
    }

    private void showView() {
        boolean clG = this.iDs.clG();
        this.iDs.show();
        if (!clG) {
            this.iDs.clH().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clv();
                }
            });
            this.iDs.clI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clv();
                }
            });
            this.iDs.clK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.iDA.isLoading()) {
                        a.this.iDA.clA();
                    }
                }
            });
            this.iDs.getListView().setOnScrollListener(this.iDC);
        }
        this.iDB = System.currentTimeMillis();
    }

    public void clw() {
        if (!isActive()) {
            this.iDr.cnd();
            this.isActive = true;
            this.iDt.setFullscreen(false);
            this.iDt.pz(true);
            showView();
            cly();
            this.iDs.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iDt.pz(false);
                }
            });
            this.iDr.b(this.iDE);
            this.iDA.clA();
        }
        this.iDr.cmt().cqi();
    }

    public void clx() {
        if (isActive()) {
            cly();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        List<m> clC = this.iDA.clC();
        if (clC != null) {
            com.baidu.tieba.pb.data.e pbData = this.iDA.clB().getPbData();
            this.iDs.show();
            this.iDs.getListView().setOnSrollToBottomListener(this.eCp);
            BdTypeListView listView = this.iDs.getListView();
            this.iDt.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(clC));
            this.iDs.beL().setCenterTextTitle(String.format(this.iDr.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.ckF().iCT.size())));
            this.iDs.pA(this.iDA.aca());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.iDv == null) {
            this.iDv = new j(this.iDr, PostData.kgt);
            this.iDv.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.iDv);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.iDv.setData(eVar);
        f cpB = this.iDu.cpB();
        this.iDv.setFromCDN(cpB.isFromCDN());
        this.iDv.dI(eVar.cku().aCo().getUserId());
        this.iDv.pw(cpB.cmd());
        this.iDv.y(this.iDw);
        this.iDv.P(this.iDx);
        this.iDv.setOnImageClickListener(this.iDy);
        this.iDv.setOnLongClickListener(this.onLongClickListener);
        this.iDv.setTbGestureDetector(this.iDz);
    }

    public void onChangeSkinType(int i) {
        this.iDs.onChangeSkinType(i);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iDw = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iDx = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iDy = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.iDz = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d clz() {
        return this.iDs;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.iDr == null) {
            return null;
        }
        return this.iDr.getNextPageSourceKeyList();
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
            PbModel clB = this.iDr.clB();
            if (clB != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(clB.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(clB.cny(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
