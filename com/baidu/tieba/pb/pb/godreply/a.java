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
    private boolean hlB;
    final PbActivity hlC;
    private d hlD;
    private c hlE;
    private aq hlF;
    private i hlG;
    private View.OnClickListener hlH;
    private View.OnClickListener hlI;
    private TbRichTextView.h hlJ;
    private com.baidu.tieba.pb.a.c hlK;
    private final MoreGodReplyModel hlL;
    private long hlM;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e dlk = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hlL.qz()) {
                a.this.hlL.bIZ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hlQ = -1;

        private boolean wb(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!wb(this.hlQ) && wb(i) && a.this.hlC != null && a.this.hlC.bJq() != null) {
                a.this.hlC.bJq().bMp();
                a.this.hlC.bJq().bNi();
            }
            this.hlQ = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hlN = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hlF.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
            a.this.bIX();
        }
    };
    private PbActivity.a hlO = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bIU();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hlL = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bJa());
        this.hlL.a(this.hlN);
        this.hlF = aqVar;
        this.hlC = pbActivity;
        this.hlD = new d(pbActivity, viewStub);
        this.hlE = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final Runnable runnable) {
        this.hlL.cancelLoadData();
        this.hlC.bKc();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hlE.bJc()) {
            this.hlD.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlD.hide();
                    a.this.hlB = false;
                    if (a.this.hlC != null) {
                        if (a.this.hlC.bJq() != null) {
                            a.this.hlC.bJq().nU(false);
                            f bMF = a.this.hlC.bJq().bMF();
                            bMF.a(a.this.hlC.bJa().getPbData(), true);
                            bMF.notifyDataSetChanged();
                        }
                        a.this.hlC.c(a.this.hlO);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hlM != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hlM;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aS(currentTimeMillis);
            e.aoQ().a(this.hlC, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bIU() {
        n(null);
    }

    private void showView() {
        boolean bJe = this.hlD.bJe();
        this.hlD.show();
        if (!bJe) {
            this.hlD.bJf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIU();
                }
            });
            this.hlD.bJg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIU();
                }
            });
            this.hlD.bJi().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hlL.qz()) {
                        a.this.hlL.bIZ();
                    }
                }
            });
            this.hlD.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hlM = System.currentTimeMillis();
    }

    public void bIV() {
        if (!isActive()) {
            this.hlC.bKc();
            this.hlB = true;
            this.hlE.setFullscreen(false);
            this.hlE.nf(true);
            showView();
            bIX();
            this.hlD.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlE.nf(false);
                }
            });
            this.hlC.b(this.hlO);
            this.hlL.bIZ();
        }
        this.hlC.bJq().bNi();
    }

    public void bIW() {
        if (isActive()) {
            bIX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIX() {
        List<m> bJb = this.hlL.bJb();
        if (bJb != null) {
            com.baidu.tieba.pb.data.d pbData = this.hlL.bJa().getPbData();
            this.hlD.show();
            this.hlD.getListView().setOnSrollToBottomListener(this.dlk);
            BdTypeListView listView = this.hlD.getListView();
            this.hlE.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bJb));
            this.hlD.aDp().setCenterTextTitle(String.format(this.hlC.getResources().getString(d.j.more_god_reply_count), ap.ax(pbData.bIk().hkX.size())));
            this.hlD.ng(this.hlL.HA());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hlG == null) {
            this.hlG = new i(this.hlC, PostData.iGj);
            this.hlG.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hlG);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.hlG.b(dVar);
        f bMF = this.hlF.bMF();
        this.hlG.setFromCDN(bMF.isFromCDN());
        this.hlG.setHostId(dVar.bHZ().YR().getUserId());
        this.hlG.nc(bMF.bKx());
        this.hlG.t(this.hlH);
        this.hlG.J(this.hlI);
        this.hlG.setOnImageClickListener(this.hlJ);
        this.hlG.setOnLongClickListener(this.onLongClickListener);
        this.hlG.setTbGestureDetector(this.hlK);
    }

    public void onChangeSkinType(int i) {
        this.hlD.onChangeSkinType(i);
    }

    public void t(View.OnClickListener onClickListener) {
        this.hlH = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hlI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hlJ = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hlK = cVar;
    }

    public boolean isActive() {
        return this.hlB;
    }

    public d bIY() {
        return this.hlD;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hlC == null) {
            return null;
        }
        return this.hlC.getNextPageSourceKeyList();
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
            PbModel bJa = this.hlC.bJa();
            if (bJa != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bJa.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bJa.bKR(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
