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
    final PbFragment lDb;
    private d lDc;
    private c lDd;
    private az lDe;
    private m lDf;
    private View.OnClickListener lDg;
    private View.OnClickListener lDh;
    private TbRichTextView.i lDi;
    private com.baidu.tieba.pb.a.c lDj;
    private final MoreGodReplyModel lDk;
    private long lDl;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gMb = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lDk.isLoading()) {
                a.this.lDk.dok();
            }
        }
    };
    private AbsListView.OnScrollListener lDm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lDq = -1;

        private boolean GT(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!GT(this.lDq) && GT(i) && a.this.lDb != null && a.this.lDb.dpc() != null) {
                a.this.lDb.dpc().dsc();
                a.this.lDb.dpc().dtb();
            }
            this.lDq = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a lDn = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void p(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lDe.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void ah(List<PostData> list) {
            a.this.doi();
        }
    };
    private PbFragment.a lDo = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dog();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.lDk = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dol());
        this.lDk.a(this.lDn);
        this.lDe = azVar;
        this.lDb = pbFragment;
        this.lDc = new d(pbFragment, viewStub);
        this.lDd = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.lDk.cancelLoadData();
        this.lDb.dpM();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lDd.don()) {
            this.lDc.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lDc.hide();
                    a.this.isActive = false;
                    if (a.this.lDb != null) {
                        if (a.this.lDb.dpc() != null) {
                            a.this.lDb.dpc().vy(false);
                            g dsu = a.this.lDb.dpc().dsu();
                            dsu.a(a.this.lDb.dol().getPbData(), true);
                            dsu.notifyDataSetChanged();
                        }
                        a.this.lDb.c(a.this.lDo);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lDl != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lDl;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bEZ().a(this.lDb.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dog() {
        t(null);
    }

    private void showView() {
        boolean doq = this.lDc.doq();
        this.lDc.show();
        if (!doq) {
            this.lDc.dor().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dog();
                }
            });
            this.lDc.dos().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dog();
                }
            });
            this.lDc.dou().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lDk.isLoading()) {
                        a.this.lDk.dok();
                    }
                }
            });
            this.lDc.getListView().setOnScrollListener(this.lDm);
        }
        this.lDl = System.currentTimeMillis();
    }

    public void doh() {
        if (!isActive()) {
            this.lDb.dpM();
            this.isActive = true;
            this.lDd.setFullscreen(false);
            this.lDd.uB(true);
            showView();
            doi();
            this.lDc.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lDd.uB(false);
                }
            });
            this.lDb.b(this.lDo);
            this.lDk.dok();
        }
        this.lDb.dpc().dtb();
    }

    public void bPG() {
        if (isActive()) {
            doi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doi() {
        List<q> dom = this.lDk.dom();
        if (dom != null) {
            f pbData = this.lDk.dol().getPbData();
            this.lDc.show();
            this.lDc.getListView().setOnSrollToBottomListener(this.gMb);
            BdTypeListView listView = this.lDc.getListView();
            this.lDd.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dom));
            this.lDc.bVL().setCenterTextTitle(String.format(this.lDb.getResources().getString(R.string.more_god_reply_count), au.numFormatOver10000(pbData.dni().lCt.size())));
            this.lDc.uC(this.lDk.aJj());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lDf == null) {
            this.lDf = new m(this.lDb, PostData.nlJ);
            this.lDf.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lDf);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lDf.setData(fVar);
        g dsu = this.lDe.dsu();
        this.lDf.setFromCDN(dsu.isFromCDN());
        this.lDf.hY(fVar.dmU().boP().getUserId());
        this.lDf.uy(dsu.doL());
        this.lDf.B(this.lDg);
        this.lDf.S(this.lDh);
        this.lDf.setOnImageClickListener(this.lDi);
        this.lDf.setOnLongClickListener(this.onLongClickListener);
        this.lDf.setTbGestureDetector(this.lDj);
    }

    public void onChangeSkinType(int i) {
        this.lDc.onChangeSkinType(i);
    }

    public void B(View.OnClickListener onClickListener) {
        this.lDg = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lDh = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lDi = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lDj = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d doj() {
        return this.lDc;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lDb == null) {
            return null;
        }
        return this.lDb.getNextPageSourceKeyList();
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
            PbModel dol = this.lDb.dol();
            if (dol != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dol.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dol.dqk(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
