package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean hlC;
    final PbActivity hlD;
    private d hlE;
    private c hlF;
    private aq hlG;
    private i hlH;
    private View.OnClickListener hlI;
    private View.OnClickListener hlJ;
    private TbRichTextView.h hlK;
    private com.baidu.tieba.pb.a.c hlL;
    private final MoreGodReplyModel hlM;
    private long hlN;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e dlk = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hlM.qz()) {
                a.this.hlM.bJa();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hlR = -1;

        private boolean wb(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!wb(this.hlR) && wb(i) && a.this.hlD != null && a.this.hlD.bJr() != null) {
                a.this.hlD.bJr().bMq();
                a.this.hlD.bJr().bNj();
            }
            this.hlR = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hlO = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hlG.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
            a.this.bIY();
        }
    };
    private PbActivity.a hlP = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bIV();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hlM = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bJb());
        this.hlM.a(this.hlO);
        this.hlG = aqVar;
        this.hlD = pbActivity;
        this.hlE = new d(pbActivity, viewStub);
        this.hlF = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final Runnable runnable) {
        this.hlM.cancelLoadData();
        this.hlD.bKd();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hlF.bJd()) {
            this.hlE.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlE.hide();
                    a.this.hlC = false;
                    if (a.this.hlD != null) {
                        if (a.this.hlD.bJr() != null) {
                            a.this.hlD.bJr().nU(false);
                            f bMG = a.this.hlD.bJr().bMG();
                            bMG.a(a.this.hlD.bJb().getPbData(), true);
                            bMG.notifyDataSetChanged();
                        }
                        a.this.hlD.c(a.this.hlP);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hlN != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hlN;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aS(currentTimeMillis);
            e.aoQ().a(this.hlD, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bIV() {
        n(null);
    }

    private void showView() {
        boolean bJf = this.hlE.bJf();
        this.hlE.show();
        if (!bJf) {
            this.hlE.bJg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIV();
                }
            });
            this.hlE.bJh().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIV();
                }
            });
            this.hlE.bJj().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hlM.qz()) {
                        a.this.hlM.bJa();
                    }
                }
            });
            this.hlE.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hlN = System.currentTimeMillis();
    }

    public void bIW() {
        if (!isActive()) {
            this.hlD.bKd();
            this.hlC = true;
            this.hlF.setFullscreen(false);
            this.hlF.nf(true);
            showView();
            bIY();
            this.hlE.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlF.nf(false);
                }
            });
            this.hlD.b(this.hlP);
            this.hlM.bJa();
        }
        this.hlD.bJr().bNj();
    }

    public void bIX() {
        if (isActive()) {
            bIY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIY() {
        List<m> bJc = this.hlM.bJc();
        if (bJc != null) {
            com.baidu.tieba.pb.data.d pbData = this.hlM.bJb().getPbData();
            this.hlE.show();
            this.hlE.getListView().setOnSrollToBottomListener(this.dlk);
            BdTypeListView listView = this.hlE.getListView();
            this.hlF.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bJc));
            this.hlE.aDq().setCenterTextTitle(String.format(this.hlD.getResources().getString(d.j.more_god_reply_count), ap.ax(pbData.bIl().hkY.size())));
            this.hlE.ng(this.hlM.HA());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hlH == null) {
            this.hlH = new i(this.hlD, PostData.iGk);
            this.hlH.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hlH);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.hlH.b(dVar);
        f bMG = this.hlG.bMG();
        this.hlH.setFromCDN(bMG.isFromCDN());
        this.hlH.setHostId(dVar.bIa().YR().getUserId());
        this.hlH.nc(bMG.bKy());
        this.hlH.t(this.hlI);
        this.hlH.J(this.hlJ);
        this.hlH.setOnImageClickListener(this.hlK);
        this.hlH.setOnLongClickListener(this.onLongClickListener);
        this.hlH.setTbGestureDetector(this.hlL);
    }

    public void onChangeSkinType(int i) {
        this.hlE.onChangeSkinType(i);
    }

    public void t(View.OnClickListener onClickListener) {
        this.hlI = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hlJ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hlK = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hlL = cVar;
    }

    public boolean isActive() {
        return this.hlC;
    }

    public d bIZ() {
        return this.hlE;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hlD == null) {
            return null;
        }
        return this.hlD.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.T(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().aoL()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.ah(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.pt(getCurrentPageKey());
            PbModel bJb = this.hlD.bJb();
            if (bJb != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bJb.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bJb.bKS(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
