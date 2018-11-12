package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean fKK;
    final PbActivity fKL;
    private d fKM;
    private c fKN;
    private ar fKO;
    private i fKP;
    private View.OnClickListener fKQ;
    private View.OnClickListener fKR;
    private TbRichTextView.h fKS;
    private com.baidu.tieba.pb.a.c fKT;
    private final MoreGodReplyModel fKU;
    private long fKV;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bRC = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fKU.Ee()) {
                a.this.fKU.bfw();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fKZ = -1;

        private boolean rH(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!rH(this.fKZ) && rH(i) && a.this.fKL != null && a.this.fKL.bfO() != null) {
                a.this.fKL.bfO().biJ();
                a.this.fKL.bfO().bjC();
            }
            this.fKZ = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fKW = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void i(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fKO.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void P(List<PostData> list) {
            a.this.bfu();
        }
    };
    private PbActivity.a fKX = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bfr();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fKU = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bfx());
        this.fKU.a(this.fKW);
        this.fKO = arVar;
        this.fKL = pbActivity;
        this.fKM = new d(pbActivity, viewStub);
        this.fKN = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.fKU.cancelLoadData();
        this.fKL.bgA();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fKN.bfz()) {
            this.fKM.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fKM.hide();
                    a.this.fKK = false;
                    if (a.this.fKL != null) {
                        if (a.this.fKL.bfO() != null) {
                            a.this.fKL.bfO().lp(false);
                            f bja = a.this.fKL.bfO().bja();
                            bja.a(a.this.fKL.bfx().getPbData(), true);
                            bja.notifyDataSetChanged();
                        }
                        a.this.fKL.c(a.this.fKX);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fKV != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fKV;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.ai(currentTimeMillis);
            e.NN().a(this.fKL, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bfr() {
        h(null);
    }

    private void showView() {
        boolean bfB = this.fKM.bfB();
        this.fKM.show();
        if (!bfB) {
            this.fKM.bfC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bfr();
                }
            });
            this.fKM.bfD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bfr();
                }
            });
            this.fKM.bfF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fKU.Ee()) {
                        a.this.fKU.bfw();
                    }
                }
            });
            this.fKM.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fKV = System.currentTimeMillis();
    }

    public void bfs() {
        if (!isActive()) {
            this.fKL.bgA();
            this.fKK = true;
            this.fKN.setFullscreen(false);
            this.fKN.kz(true);
            showView();
            bfu();
            this.fKM.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fKN.kz(false);
                }
            });
            this.fKL.b(this.fKX);
            this.fKU.bfw();
        }
        this.fKL.bfO().bjC();
    }

    public void bft() {
        if (isActive()) {
            bfu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfu() {
        List<h> bfy = this.fKU.bfy();
        if (bfy != null) {
            com.baidu.tieba.pb.data.d pbData = this.fKU.bfx().getPbData();
            this.fKM.show();
            this.fKM.getListView().setOnSrollToBottomListener(this.bRC);
            BdTypeListView listView = this.fKM.getListView();
            this.fKN.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bfy));
            this.fKM.aaO().setCenterTextTitle(String.format(this.fKL.getResources().getString(e.j.more_god_reply_count), ao.N(pbData.beE().fKf.size())));
            this.fKM.kA(this.fKU.hasMoreData());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fKP == null) {
            this.fKP = new i(this.fKL, PostData.het);
            this.fKP.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fKP);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fKP.b(dVar);
        f bja = this.fKO.bja();
        this.fKP.setFromCDN(bja.isFromCDN());
        this.fKP.setHostId(dVar.bet().yC().getUserId());
        this.fKP.kw(bja.bgU());
        this.fKP.s(this.fKQ);
        this.fKP.I(this.fKR);
        this.fKP.setOnImageClickListener(this.fKS);
        this.fKP.setOnLongClickListener(this.onLongClickListener);
        this.fKP.setTbGestureDetector(this.fKT);
    }

    public void onChangeSkinType(int i) {
        this.fKM.onChangeSkinType(i);
    }

    public void s(View.OnClickListener onClickListener) {
        this.fKQ = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fKR = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fKS = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fKT = cVar;
    }

    public boolean isActive() {
        return this.fKK;
    }

    public d bfv() {
        return this.fKM;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fKL == null) {
            return null;
        }
        return this.fKL.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.I(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().NI()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.pageStayDuration.d();
            this.pageStayDurationItem.U(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.hY(getCurrentPageKey());
            PbModel bfx = this.fKL.bfx();
            if (bfx != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bfx.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bfx.bhm(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
