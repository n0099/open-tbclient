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
    final PbFragment jHe;
    private d jHf;
    private c jHg;
    private av jHh;
    private k jHi;
    private View.OnClickListener jHj;
    private View.OnClickListener jHk;
    private TbRichTextView.i jHl;
    private com.baidu.tieba.pb.a.c jHm;
    private final MoreGodReplyModel jHn;
    private long jHo;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fvq = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.jHn.isLoading()) {
                a.this.jHn.cDN();
            }
        }
    };
    private AbsListView.OnScrollListener jHp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int jHt = -1;

        private boolean zZ(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!zZ(this.jHt) && zZ(i) && a.this.jHe != null && a.this.jHe.cEE() != null) {
                a.this.jHe.cEE().cHw();
                a.this.jHe.cEE().cIu();
            }
            this.jHt = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ae.a jHq = new ae.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.jHh.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aN(List<PostData> list) {
            a.this.cDL();
        }
    };
    private PbFragment.a jHr = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cDI();
            return true;
        }
    };

    public a(PbFragment pbFragment, av avVar, ViewStub viewStub) {
        this.jHn = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cDO());
        this.jHn.a(this.jHq);
        this.jHh = avVar;
        this.jHe = pbFragment;
        this.jHf = new d(pbFragment, viewStub);
        this.jHg = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(final Runnable runnable) {
        this.jHn.cancelLoadData();
        this.jHe.cFn();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.jHg.cDQ()) {
            this.jHf.z(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jHf.hide();
                    a.this.isActive = false;
                    if (a.this.jHe != null) {
                        if (a.this.jHe.cEE() != null) {
                            a.this.jHe.cEE().sa(false);
                            g cHN = a.this.jHe.cEE().cHN();
                            cHN.a(a.this.jHe.cDO().getPbData(), true);
                            cHN.notifyDataSetChanged();
                        }
                        a.this.jHe.c(a.this.jHr);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.jHo != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.jHo;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bfv().a(this.jHe.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cDI() {
        x(null);
    }

    private void showView() {
        boolean cDT = this.jHf.cDT();
        this.jHf.show();
        if (!cDT) {
            this.jHf.cDU().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDI();
                }
            });
            this.jHf.cDV().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDI();
                }
            });
            this.jHf.cDX().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.jHn.isLoading()) {
                        a.this.jHn.cDN();
                    }
                }
            });
            this.jHf.getListView().setOnScrollListener(this.jHp);
        }
        this.jHo = System.currentTimeMillis();
    }

    public void cDJ() {
        if (!isActive()) {
            this.jHe.cFn();
            this.isActive = true;
            this.jHg.setFullscreen(false);
            this.jHg.rh(true);
            showView();
            cDL();
            this.jHf.A(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jHg.rh(false);
                }
            });
            this.jHe.b(this.jHr);
            this.jHn.cDN();
        }
        this.jHe.cEE().cIu();
    }

    public void cDK() {
        if (isActive()) {
            cDL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDL() {
        List<o> cDP = this.jHn.cDP();
        if (cDP != null) {
            com.baidu.tieba.pb.data.e pbData = this.jHn.cDO().getPbData();
            this.jHf.show();
            this.jHf.getListView().setOnSrollToBottomListener(this.fvq);
            BdTypeListView listView = this.jHf.getListView();
            this.jHg.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cDP));
            this.jHf.bua().setCenterTextTitle(String.format(this.jHe.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.cCM().jGF.size())));
            this.jHf.ri(this.jHn.anV());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.jHi == null) {
            this.jHi = new k(this.jHe, PostData.llS);
            this.jHi.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.jHi);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.jHi.setData(eVar);
        g cHN = this.jHh.cHN();
        this.jHi.setFromCDN(cHN.isFromCDN());
        this.jHi.fl(eVar.cCy().aQx().getUserId());
        this.jHi.re(cHN.cEo());
        this.jHi.y(this.jHj);
        this.jHi.Q(this.jHk);
        this.jHi.setOnImageClickListener(this.jHl);
        this.jHi.setOnLongClickListener(this.onLongClickListener);
        this.jHi.setTbGestureDetector(this.jHm);
    }

    public void onChangeSkinType(int i) {
        this.jHf.onChangeSkinType(i);
    }

    public void y(View.OnClickListener onClickListener) {
        this.jHj = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jHk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jHl = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.jHm = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cDM() {
        return this.jHf;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.jHe == null) {
            return null;
        }
        return this.jHe.getNextPageSourceKeyList();
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
            PbModel cDO = this.jHe.cDO();
            if (cDO != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cDO.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cDO.cFJ(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
