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
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean fBJ;
    final PbActivity fBK;
    private d fBL;
    private c fBM;
    private ar fBN;
    private i fBO;
    private View.OnClickListener fBP;
    private View.OnClickListener fBQ;
    private TbRichTextView.h fBR;
    private com.baidu.tieba.pb.a.c fBS;
    private final MoreGodReplyModel fBT;
    private long fBU;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bIp = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fBT.BO()) {
                a.this.fBT.bcN();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fBY = -1;

        private boolean qR(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qR(this.fBY) && qR(i) && a.this.fBK != null && a.this.fBK.bdf() != null) {
                a.this.fBK.bdf().bga();
                a.this.fBK.bdf().bgT();
            }
            this.fBY = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fBV = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fBN.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void H(List<PostData> list) {
            a.this.bcL();
        }
    };
    private PbActivity.a fBW = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bcI();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fBT = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bcO());
        this.fBT.a(this.fBV);
        this.fBN = arVar;
        this.fBK = pbActivity;
        this.fBL = new d(pbActivity, viewStub);
        this.fBM = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.fBT.cancelLoadData();
        this.fBK.bdR();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fBM.bcQ()) {
            this.fBL.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fBL.hide();
                    a.this.fBJ = false;
                    if (a.this.fBK != null) {
                        if (a.this.fBK.bdf() != null) {
                            a.this.fBK.bdf().kN(false);
                            f bgr = a.this.fBK.bdf().bgr();
                            bgr.a(a.this.fBK.bcO().getPbData(), true);
                            bgr.notifyDataSetChanged();
                        }
                        a.this.fBK.c(a.this.fBW);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fBU != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fBU;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.ae(currentTimeMillis);
            e.LG().a(this.fBK, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bcI() {
        h(null);
    }

    private void showView() {
        boolean bcS = this.fBL.bcS();
        this.fBL.show();
        if (!bcS) {
            this.fBL.bcT().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bcI();
                }
            });
            this.fBL.bcU().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bcI();
                }
            });
            this.fBL.bcW().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fBT.BO()) {
                        a.this.fBT.bcN();
                    }
                }
            });
            this.fBL.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fBU = System.currentTimeMillis();
    }

    public void bcJ() {
        if (!isActive()) {
            this.fBK.bdR();
            this.fBJ = true;
            this.fBM.setFullscreen(false);
            this.fBM.jX(true);
            showView();
            bcL();
            this.fBL.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fBM.jX(false);
                }
            });
            this.fBK.b(this.fBW);
            this.fBT.bcN();
        }
        this.fBK.bdf().bgT();
    }

    public void bcK() {
        if (isActive()) {
            bcL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcL() {
        List<h> bcP = this.fBT.bcP();
        if (bcP != null) {
            com.baidu.tieba.pb.data.d pbData = this.fBT.bcO().getPbData();
            this.fBL.show();
            this.fBL.getListView().setOnSrollToBottomListener(this.bIp);
            BdTypeListView listView = this.fBL.getListView();
            this.fBM.BP();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bcP));
            this.fBL.WW().setCenterTextTitle(String.format(this.fBK.getResources().getString(e.j.more_god_reply_count), ao.J(pbData.bbU().fBe.size())));
            this.fBL.jY(this.fBT.aiH());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fBO == null) {
            this.fBO = new i(this.fBK, PostData.gVA);
            this.fBO.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fBO);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fBO.b(dVar);
        f bgr = this.fBN.bgr();
        this.fBO.setFromCDN(bgr.isFromCDN());
        this.fBO.setHostId(dVar.bbJ().wm().getUserId());
        this.fBO.jU(bgr.bel());
        this.fBO.q(this.fBP);
        this.fBO.G(this.fBQ);
        this.fBO.setOnImageClickListener(this.fBR);
        this.fBO.setOnLongClickListener(this.onLongClickListener);
        this.fBO.setTbGestureDetector(this.fBS);
    }

    public void onChangeSkinType(int i) {
        this.fBL.onChangeSkinType(i);
    }

    public void q(View.OnClickListener onClickListener) {
        this.fBP = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fBQ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fBR = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fBS = cVar;
    }

    public boolean isActive() {
        return this.fBJ;
    }

    public d bcM() {
        return this.fBL;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fBK == null) {
            return null;
        }
        return this.fBK.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.z(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().LB()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.hJ(getCurrentPageKey());
            PbModel bcO = this.fBK.bcO();
            if (bcO != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bcO.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bcO.beD(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
