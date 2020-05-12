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
    private boolean isActive;
    final PbFragment jpp;
    private d jpq;
    private c jpr;
    private an jps;
    private j jpt;
    private View.OnClickListener jpu;
    private View.OnClickListener jpv;
    private TbRichTextView.i jpw;
    private com.baidu.tieba.pb.a.c jpx;
    private final MoreGodReplyModel jpy;
    private long jpz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fhw = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.jpy.isLoading()) {
                a.this.jpy.cwA();
            }
        }
    };
    private AbsListView.OnScrollListener jpA = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int jpE = -1;

        private boolean zn(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!zn(this.jpE) && zn(i) && a.this.jpp != null && a.this.jpp.cxt() != null) {
                a.this.jpp.cxt().cAk();
                a.this.jpp.cxt().cBi();
            }
            this.jpE = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a jpB = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.jps.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void aS(List<PostData> list) {
            a.this.cwy();
        }
    };
    private PbFragment.a jpC = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cwv();
            return true;
        }
    };

    public a(PbFragment pbFragment, an anVar, ViewStub viewStub) {
        this.jpy = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cwB());
        this.jpy.a(this.jpB);
        this.jps = anVar;
        this.jpp = pbFragment;
        this.jpq = new d(pbFragment, viewStub);
        this.jpr = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(final Runnable runnable) {
        this.jpy.cancelLoadData();
        this.jpp.cyd();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.jpr.cwD()) {
            this.jpq.x(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jpq.hide();
                    a.this.isActive = false;
                    if (a.this.jpp != null) {
                        if (a.this.jpp.cxt() != null) {
                            a.this.jpp.cxt().rB(false);
                            f cAB = a.this.jpp.cxt().cAB();
                            cAB.a(a.this.jpp.cwB().getPbData(), true);
                            cAB.notifyDataSetChanged();
                        }
                        a.this.jpp.c(a.this.jpC);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.jpz != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.jpz;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aZk().a(this.jpp.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cwv() {
        v(null);
    }

    private void showView() {
        boolean cwG = this.jpq.cwG();
        this.jpq.show();
        if (!cwG) {
            this.jpq.cwH().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cwv();
                }
            });
            this.jpq.cwI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cwv();
                }
            });
            this.jpq.cwK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.jpy.isLoading()) {
                        a.this.jpy.cwA();
                    }
                }
            });
            this.jpq.getListView().setOnScrollListener(this.jpA);
        }
        this.jpz = System.currentTimeMillis();
    }

    public void cww() {
        if (!isActive()) {
            this.jpp.cyd();
            this.isActive = true;
            this.jpr.setFullscreen(false);
            this.jpr.qJ(true);
            showView();
            cwy();
            this.jpq.y(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jpr.qJ(false);
                }
            });
            this.jpp.b(this.jpC);
            this.jpy.cwA();
        }
        this.jpp.cxt().cBi();
    }

    public void cwx() {
        if (isActive()) {
            cwy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwy() {
        List<m> cwC = this.jpy.cwC();
        if (cwC != null) {
            com.baidu.tieba.pb.data.e pbData = this.jpy.cwB().getPbData();
            this.jpq.show();
            this.jpq.getListView().setOnSrollToBottomListener(this.fhw);
            BdTypeListView listView = this.jpq.getListView();
            this.jpr.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cwC));
            this.jpq.bof().setCenterTextTitle(String.format(this.jpp.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.cvD().joQ.size())));
            this.jpq.qK(this.jpy.akh());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.jpt == null) {
            this.jpt = new j(this.jpp, PostData.kSs);
            this.jpt.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.jpt);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.jpt.setData(eVar);
        f cAB = this.jps.cAB();
        this.jpt.setFromCDN(cAB.isFromCDN());
        this.jpt.eA(eVar.cvs().aKC().getUserId());
        this.jpt.qG(cAB.cxd());
        this.jpt.z(this.jpu);
        this.jpt.Q(this.jpv);
        this.jpt.setOnImageClickListener(this.jpw);
        this.jpt.setOnLongClickListener(this.onLongClickListener);
        this.jpt.setTbGestureDetector(this.jpx);
    }

    public void onChangeSkinType(int i) {
        this.jpq.onChangeSkinType(i);
    }

    public void z(View.OnClickListener onClickListener) {
        this.jpu = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jpv = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jpw = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.jpx = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cwz() {
        return this.jpq;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.jpp == null) {
            return null;
        }
        return this.jpp.getNextPageSourceKeyList();
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
            PbModel cwB = this.jpp.cwB();
            if (cwB != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cwB.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cwB.cyy(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
