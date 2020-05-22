package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment jFY;
    private d jFZ;
    private c jGa;
    private av jGb;
    private k jGc;
    private View.OnClickListener jGd;
    private View.OnClickListener jGe;
    private TbRichTextView.i jGf;
    private com.baidu.tieba.pb.a.c jGg;
    private final MoreGodReplyModel jGh;
    private long jGi;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fvf = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.jGh.isLoading()) {
                a.this.jGh.cDx();
            }
        }
    };
    private AbsListView.OnScrollListener jGj = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int jGn = -1;

        private boolean zX(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!zX(this.jGn) && zX(i) && a.this.jFY != null && a.this.jFY.cEo() != null) {
                a.this.jFY.cEo().cHg();
                a.this.jFY.cEo().cIe();
            }
            this.jGn = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ae.a jGk = new ae.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.jGb.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aN(List<PostData> list) {
            a.this.cDv();
        }
    };
    private PbFragment.a jGl = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cDs();
            return true;
        }
    };

    public a(PbFragment pbFragment, av avVar, ViewStub viewStub) {
        this.jGh = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cDy());
        this.jGh.a(this.jGk);
        this.jGb = avVar;
        this.jFY = pbFragment;
        this.jFZ = new d(pbFragment, viewStub);
        this.jGa = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(final Runnable runnable) {
        this.jGh.cancelLoadData();
        this.jFY.cEX();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.jGa.cDA()) {
            this.jFZ.z(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jFZ.hide();
                    a.this.isActive = false;
                    if (a.this.jFY != null) {
                        if (a.this.jFY.cEo() != null) {
                            a.this.jFY.cEo().sa(false);
                            g cHx = a.this.jFY.cEo().cHx();
                            cHx.a(a.this.jFY.cDy().getPbData(), true);
                            cHx.notifyDataSetChanged();
                        }
                        a.this.jFY.c(a.this.jGl);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.jGi != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.jGi;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bfu().a(this.jFY.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cDs() {
        x(null);
    }

    private void showView() {
        boolean cDD = this.jFZ.cDD();
        this.jFZ.show();
        if (!cDD) {
            this.jFZ.cDE().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDs();
                }
            });
            this.jFZ.cDF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDs();
                }
            });
            this.jFZ.cDH().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.jGh.isLoading()) {
                        a.this.jGh.cDx();
                    }
                }
            });
            this.jFZ.getListView().setOnScrollListener(this.jGj);
        }
        this.jGi = System.currentTimeMillis();
    }

    public void cDt() {
        if (!isActive()) {
            this.jFY.cEX();
            this.isActive = true;
            this.jGa.setFullscreen(false);
            this.jGa.rh(true);
            showView();
            cDv();
            this.jFZ.A(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jGa.rh(false);
                }
            });
            this.jFY.b(this.jGl);
            this.jGh.cDx();
        }
        this.jFY.cEo().cIe();
    }

    public void cDu() {
        if (isActive()) {
            cDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDv() {
        List<o> cDz = this.jGh.cDz();
        if (cDz != null) {
            com.baidu.tieba.pb.data.e pbData = this.jGh.cDy().getPbData();
            this.jFZ.show();
            this.jFZ.getListView().setOnSrollToBottomListener(this.fvf);
            BdTypeListView listView = this.jFZ.getListView();
            this.jGa.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cDz));
            this.jFZ.btY().setCenterTextTitle(String.format(this.jFY.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.cCw().jFz.size())));
            this.jFZ.ri(this.jGh.anV());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.jGc == null) {
            this.jGc = new k(this.jFY, PostData.lkJ);
            this.jGc.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.jGc);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.jGc.setData(eVar);
        g cHx = this.jGb.cHx();
        this.jGc.setFromCDN(cHx.isFromCDN());
        this.jGc.fl(eVar.cCi().aQx().getUserId());
        this.jGc.re(cHx.cDY());
        this.jGc.y(this.jGd);
        this.jGc.Q(this.jGe);
        this.jGc.setOnImageClickListener(this.jGf);
        this.jGc.setOnLongClickListener(this.onLongClickListener);
        this.jGc.setTbGestureDetector(this.jGg);
    }

    public void onChangeSkinType(int i) {
        this.jFZ.onChangeSkinType(i);
    }

    public void y(View.OnClickListener onClickListener) {
        this.jGd = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jGe = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jGf = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.jGg = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cDw() {
        return this.jFZ;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.jFY == null) {
            return null;
        }
        return this.jFY.getNextPageSourceKeyList();
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
            PbModel cDy = this.jFY.cDy();
            if (cDy != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cDy.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cDy.cFt(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
