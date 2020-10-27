package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.at;
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
    final PbFragment lja;
    private d ljb;
    private c ljc;
    private az ljd;
    private m lje;
    private View.OnClickListener ljf;
    private View.OnClickListener ljg;
    private TbRichTextView.i ljh;
    private com.baidu.tieba.pb.a.c lji;
    private final MoreGodReplyModel ljj;
    private long ljk;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gxH = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.ljj.isLoading()) {
                a.this.ljj.dgW();
            }
        }
    };
    private AbsListView.OnScrollListener ljl = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int ljp = -1;

        private boolean Ft(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Ft(this.ljp) && Ft(i) && a.this.lja != null && a.this.lja.dhN() != null) {
                a.this.lja.dhN().dkK();
                a.this.lja.dhN().dlI();
            }
            this.ljp = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a ljm = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.ljd.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void aa(List<PostData> list) {
            a.this.dgU();
        }
    };
    private PbFragment.a ljn = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dgS();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.ljj = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dgX());
        this.ljj.a(this.ljm);
        this.ljd = azVar;
        this.lja = pbFragment;
        this.ljb = new d(pbFragment, viewStub);
        this.ljc = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        this.ljj.cancelLoadData();
        this.lja.dix();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.ljc.dgZ()) {
            this.ljb.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ljb.hide();
                    a.this.isActive = false;
                    if (a.this.lja != null) {
                        if (a.this.lja.dhN() != null) {
                            a.this.lja.dhN().uJ(false);
                            g dlb = a.this.lja.dhN().dlb();
                            dlb.a(a.this.lja.dgX().getPbData(), true);
                            dlb.notifyDataSetChanged();
                        }
                        a.this.lja.c(a.this.ljn);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.ljk != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.ljk;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bzH().a(this.lja.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dgS() {
        t(null);
    }

    private void showView() {
        boolean dhc = this.ljb.dhc();
        this.ljb.show();
        if (!dhc) {
            this.ljb.dhd().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dgS();
                }
            });
            this.ljb.dhe().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dgS();
                }
            });
            this.ljb.dhg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.ljj.isLoading()) {
                        a.this.ljj.dgW();
                    }
                }
            });
            this.ljb.getListView().setOnScrollListener(this.ljl);
        }
        this.ljk = System.currentTimeMillis();
    }

    public void dgT() {
        if (!isActive()) {
            this.lja.dix();
            this.isActive = true;
            this.ljc.setFullscreen(false);
            this.ljc.tN(true);
            showView();
            dgU();
            this.ljb.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ljc.tN(false);
                }
            });
            this.lja.b(this.ljn);
            this.ljj.dgW();
        }
        this.lja.dhN().dlI();
    }

    public void bKe() {
        if (isActive()) {
            dgU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgU() {
        List<q> dgY = this.ljj.dgY();
        if (dgY != null) {
            f pbData = this.ljj.dgX().getPbData();
            this.ljb.show();
            this.ljb.getListView().setOnSrollToBottomListener(this.gxH);
            BdTypeListView listView = this.ljb.getListView();
            this.ljc.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dgY));
            this.ljb.bQh().setCenterTextTitle(String.format(this.lja.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.dfW().liD.size())));
            this.ljb.tO(this.ljj.aEj());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lje == null) {
            this.lje = new m(this.lja, PostData.mQN);
            this.lje.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lje);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lje.setData(fVar);
        g dlb = this.ljd.dlb();
        this.lje.setFromCDN(dlb.isFromCDN());
        this.lje.hx(fVar.dfI().bka().getUserId());
        this.lje.tK(dlb.dhx());
        this.lje.A(this.ljf);
        this.lje.S(this.ljg);
        this.lje.setOnImageClickListener(this.ljh);
        this.lje.setOnLongClickListener(this.onLongClickListener);
        this.lje.setTbGestureDetector(this.lji);
    }

    public void onChangeSkinType(int i) {
        this.ljb.onChangeSkinType(i);
    }

    public void A(View.OnClickListener onClickListener) {
        this.ljf = onClickListener;
    }

    public void S(View.OnClickListener onClickListener) {
        this.ljg = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ljh = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lji = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d dgV() {
        return this.ljb;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lja == null) {
            return null;
        }
        return this.lja.getNextPageSourceKeyList();
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
            PbModel dgX = this.lja.dgX();
            if (dgX != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dgX.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dgX.diV(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
