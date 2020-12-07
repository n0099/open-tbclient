package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment lCZ;
    private d lDa;
    private c lDb;
    private az lDc;
    private m lDd;
    private View.OnClickListener lDe;
    private View.OnClickListener lDf;
    private TbRichTextView.i lDg;
    private com.baidu.tieba.pb.a.c lDh;
    private final MoreGodReplyModel lDi;
    private long lDj;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gLZ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lDi.isLoading()) {
                a.this.lDi.doj();
            }
        }
    };
    private AbsListView.OnScrollListener lDk = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lDo = -1;

        private boolean GT(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!GT(this.lDo) && GT(i) && a.this.lCZ != null && a.this.lCZ.dpb() != null) {
                a.this.lCZ.dpb().dsb();
                a.this.lCZ.dpb().dta();
            }
            this.lDo = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a lDl = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void p(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lDc.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void ah(List<PostData> list) {
            a.this.doh();
        }
    };
    private PbFragment.a lDm = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dof();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.lDi = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dok());
        this.lDi.a(this.lDl);
        this.lDc = azVar;
        this.lCZ = pbFragment;
        this.lDa = new d(pbFragment, viewStub);
        this.lDb = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.lDi.cancelLoadData();
        this.lCZ.dpL();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lDb.dom()) {
            this.lDa.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lDa.hide();
                    a.this.isActive = false;
                    if (a.this.lCZ != null) {
                        if (a.this.lCZ.dpb() != null) {
                            a.this.lCZ.dpb().vy(false);
                            g dst = a.this.lCZ.dpb().dst();
                            dst.a(a.this.lCZ.dok().getPbData(), true);
                            dst.notifyDataSetChanged();
                        }
                        a.this.lCZ.c(a.this.lDm);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lDj != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lDj;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bEZ().a(this.lCZ.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dof() {
        t(null);
    }

    private void showView() {
        boolean dop = this.lDa.dop();
        this.lDa.show();
        if (!dop) {
            this.lDa.doq().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dof();
                }
            });
            this.lDa.dor().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dof();
                }
            });
            this.lDa.dot().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lDi.isLoading()) {
                        a.this.lDi.doj();
                    }
                }
            });
            this.lDa.getListView().setOnScrollListener(this.lDk);
        }
        this.lDj = System.currentTimeMillis();
    }

    public void dog() {
        if (!isActive()) {
            this.lCZ.dpL();
            this.isActive = true;
            this.lDb.setFullscreen(false);
            this.lDb.uB(true);
            showView();
            doh();
            this.lDa.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lDb.uB(false);
                }
            });
            this.lCZ.b(this.lDm);
            this.lDi.doj();
        }
        this.lCZ.dpb().dta();
    }

    public void bPF() {
        if (isActive()) {
            doh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doh() {
        List<q> dol = this.lDi.dol();
        if (dol != null) {
            f pbData = this.lDi.dok().getPbData();
            this.lDa.show();
            this.lDa.getListView().setOnSrollToBottomListener(this.gLZ);
            BdTypeListView listView = this.lDa.getListView();
            this.lDb.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dol));
            this.lDa.bVK().setCenterTextTitle(String.format(this.lCZ.getResources().getString(R.string.more_god_reply_count), au.numFormatOver10000(pbData.dnh().lCr.size())));
            this.lDa.uC(this.lDi.aJj());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lDd == null) {
            this.lDd = new m(this.lCZ, PostData.nlH);
            this.lDd.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lDd);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lDd.setData(fVar);
        g dst = this.lDc.dst();
        this.lDd.setFromCDN(dst.isFromCDN());
        this.lDd.hY(fVar.dmT().boP().getUserId());
        this.lDd.uy(dst.doK());
        this.lDd.B(this.lDe);
        this.lDd.S(this.lDf);
        this.lDd.setOnImageClickListener(this.lDg);
        this.lDd.setOnLongClickListener(this.onLongClickListener);
        this.lDd.setTbGestureDetector(this.lDh);
    }

    public void onChangeSkinType(int i) {
        this.lDa.onChangeSkinType(i);
    }

    public void B(View.OnClickListener onClickListener) {
        this.lDe = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lDf = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lDg = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lDh = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d doi() {
        return this.lDa;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lCZ == null) {
            return null;
        }
        return this.lCZ.getNextPageSourceKeyList();
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
            PbModel dok = this.lCZ.dok();
            if (dok != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dok.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dok.dqj(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
