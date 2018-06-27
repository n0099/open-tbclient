package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean ftN;
    final PbActivity ftO;
    private d ftP;
    private c ftQ;
    private at ftR;
    private i ftS;
    private View.OnClickListener ftT;
    private View.OnClickListener ftU;
    private TbRichTextView.h ftV;
    private com.baidu.tieba.pb.a.c ftW;
    private final MoreGodReplyModel ftX;
    private long ftY;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bBR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.ftX.AO()) {
                a.this.ftX.bbZ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fuc = -1;

        private boolean qt(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qt(this.fuc) && qt(i) && a.this.ftO != null && a.this.ftO.bcr() != null) {
                a.this.ftO.bcr().bfo();
                a.this.ftO.bcr().bgg();
            }
            this.fuc = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a ftZ = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.ftR.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void H(List<PostData> list) {
            a.this.bbX();
        }
    };
    private PbActivity.a fua = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bbU();
            return true;
        }
    };

    public a(PbActivity pbActivity, at atVar, ViewStub viewStub) {
        this.ftX = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bca());
        this.ftX.a(this.ftZ);
        this.ftR = atVar;
        this.ftO = pbActivity;
        this.ftP = new d(pbActivity, viewStub);
        this.ftQ = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.ftX.cancelLoadData();
        this.ftO.bdc();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.ftQ.bcc()) {
            this.ftP.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ftP.hide();
                    a.this.ftN = false;
                    if (a.this.ftO != null) {
                        if (a.this.ftO.bcr() != null) {
                            a.this.ftO.bcr().kE(false);
                            f bfE = a.this.ftO.bcr().bfE();
                            bfE.a(a.this.ftO.bca().getPbData(), true);
                            bfE.notifyDataSetChanged();
                        }
                        a.this.ftO.c(a.this.fua);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.ftY != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.ftY;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.Y(currentTimeMillis);
            e.Kr().a(this.ftO, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bbU() {
        h(null);
    }

    private void showView() {
        boolean bce = this.ftP.bce();
        this.ftP.show();
        if (!bce) {
            this.ftP.bcf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbU();
                }
            });
            this.ftP.bcg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbU();
                }
            });
            this.ftP.bci().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.ftX.AO()) {
                        a.this.ftX.bbZ();
                    }
                }
            });
            this.ftP.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.ftY = System.currentTimeMillis();
    }

    public void bbV() {
        if (!isActive()) {
            this.ftO.bdc();
            this.ftN = true;
            this.ftQ.setFullscreen(false);
            this.ftQ.jK(true);
            showView();
            bbX();
            this.ftP.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ftQ.jK(false);
                }
            });
            this.ftO.b(this.fua);
            this.ftX.bbZ();
        }
        this.ftO.bcr().bgg();
    }

    public void bbW() {
        if (isActive()) {
            bbX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbX() {
        List<h> bcb = this.ftX.bcb();
        if (bcb != null) {
            com.baidu.tieba.pb.data.d pbData = this.ftX.bca().getPbData();
            this.ftP.show();
            this.ftP.getListView().setOnSrollToBottomListener(this.bBR);
            BdTypeListView listView = this.ftP.getListView();
            this.ftQ.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bcb));
            this.ftP.UW().setCenterTextTitle(String.format(this.ftO.getResources().getString(d.k.more_god_reply_count), ap.D(pbData.bbg().ftr.size())));
            this.ftP.jL(this.ftX.agy());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.ftS == null) {
            this.ftS = new i(this.ftO, PostData.gMW);
            this.ftS.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.ftS);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.ftS.b(dVar);
        f bfE = this.ftR.bfE();
        this.ftS.setFromCDN(bfE.isFromCDN());
        this.ftS.setHostId(dVar.baV().vw().getUserId());
        this.ftS.jH(bfE.bdw());
        this.ftS.q(this.ftT);
        this.ftS.I(this.ftU);
        this.ftS.setOnImageClickListener(this.ftV);
        this.ftS.setOnLongClickListener(this.onLongClickListener);
        this.ftS.setTbGestureDetector(this.ftW);
    }

    public void onChangeSkinType(int i) {
        this.ftP.onChangeSkinType(i);
    }

    public void q(View.OnClickListener onClickListener) {
        this.ftT = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.ftU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ftV = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ftW = cVar;
    }

    public boolean isActive() {
        return this.ftN;
    }

    public d bbY() {
        return this.ftP;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.ftO == null) {
            return null;
        }
        return this.ftO.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (w.A(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Km()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.M(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.hq(getCurrentPageKey());
            PbModel bca = this.ftO.bca();
            if (bca != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bca.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bca.bdP(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
