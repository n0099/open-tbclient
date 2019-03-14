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
    private c hlA;
    private aq hlB;
    private i hlC;
    private View.OnClickListener hlD;
    private View.OnClickListener hlE;
    private TbRichTextView.h hlF;
    private com.baidu.tieba.pb.a.c hlG;
    private final MoreGodReplyModel hlH;
    private long hlI;
    private boolean hlx;
    final PbActivity hly;
    private d hlz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e dlg = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hlH.qz()) {
                a.this.hlH.bIZ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hlM = -1;

        private boolean wb(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!wb(this.hlM) && wb(i) && a.this.hly != null && a.this.hly.bJq() != null) {
                a.this.hly.bJq().bMp();
                a.this.hly.bJq().bNj();
            }
            this.hlM = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hlJ = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hlB.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
            a.this.bIX();
        }
    };
    private PbActivity.a hlK = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bIU();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hlH = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bJa());
        this.hlH.a(this.hlJ);
        this.hlB = aqVar;
        this.hly = pbActivity;
        this.hlz = new d(pbActivity, viewStub);
        this.hlA = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final Runnable runnable) {
        this.hlH.cancelLoadData();
        this.hly.bKc();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hlA.bJc()) {
            this.hlz.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlz.hide();
                    a.this.hlx = false;
                    if (a.this.hly != null) {
                        if (a.this.hly.bJq() != null) {
                            a.this.hly.bJq().nU(false);
                            f bMF = a.this.hly.bJq().bMF();
                            bMF.a(a.this.hly.bJa().getPbData(), true);
                            bMF.notifyDataSetChanged();
                        }
                        a.this.hly.c(a.this.hlK);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hlI != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hlI;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aS(currentTimeMillis);
            e.aoP().a(this.hly, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bIU() {
        n(null);
    }

    private void showView() {
        boolean bJe = this.hlz.bJe();
        this.hlz.show();
        if (!bJe) {
            this.hlz.bJf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIU();
                }
            });
            this.hlz.bJg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIU();
                }
            });
            this.hlz.bJi().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hlH.qz()) {
                        a.this.hlH.bIZ();
                    }
                }
            });
            this.hlz.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hlI = System.currentTimeMillis();
    }

    public void bIV() {
        if (!isActive()) {
            this.hly.bKc();
            this.hlx = true;
            this.hlA.setFullscreen(false);
            this.hlA.nf(true);
            showView();
            bIX();
            this.hlz.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hlA.nf(false);
                }
            });
            this.hly.b(this.hlK);
            this.hlH.bIZ();
        }
        this.hly.bJq().bNj();
    }

    public void bIW() {
        if (isActive()) {
            bIX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIX() {
        List<m> bJb = this.hlH.bJb();
        if (bJb != null) {
            com.baidu.tieba.pb.data.d pbData = this.hlH.bJa().getPbData();
            this.hlz.show();
            this.hlz.getListView().setOnSrollToBottomListener(this.dlg);
            BdTypeListView listView = this.hlz.getListView();
            this.hlA.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bJb));
            this.hlz.aDp().setCenterTextTitle(String.format(this.hly.getResources().getString(d.j.more_god_reply_count), ap.ax(pbData.bIk().hkX.size())));
            this.hlz.ng(this.hlH.HA());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hlC == null) {
            this.hlC = new i(this.hly, PostData.iGc);
            this.hlC.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hlC);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.hlC.b(dVar);
        f bMF = this.hlB.bMF();
        this.hlC.setFromCDN(bMF.isFromCDN());
        this.hlC.setHostId(dVar.bHZ().YR().getUserId());
        this.hlC.nc(bMF.bKx());
        this.hlC.t(this.hlD);
        this.hlC.J(this.hlE);
        this.hlC.setOnImageClickListener(this.hlF);
        this.hlC.setOnLongClickListener(this.onLongClickListener);
        this.hlC.setTbGestureDetector(this.hlG);
    }

    public void onChangeSkinType(int i) {
        this.hlz.onChangeSkinType(i);
    }

    public void t(View.OnClickListener onClickListener) {
        this.hlD = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hlE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hlF = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hlG = cVar;
    }

    public boolean isActive() {
        return this.hlx;
    }

    public d bIY() {
        return this.hlz;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hly == null) {
            return null;
        }
        return this.hly.getNextPageSourceKeyList();
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
        if ((getPageStayFilter() == null || getPageStayFilter().aoK()) && !StringUtils.isNull(currentPageKey)) {
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
            PbModel bJa = this.hly.bJa();
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
