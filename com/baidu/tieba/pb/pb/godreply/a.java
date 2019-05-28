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
import com.baidu.tbadk.o.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
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
public class a implements com.baidu.tbadk.o.a {
    private boolean hCO;
    final PbActivity hCP;
    private d hCQ;
    private c hCR;
    private aq hCS;
    private i hCT;
    private View.OnClickListener hCU;
    private View.OnClickListener hCV;
    private TbRichTextView.h hCW;
    private com.baidu.tieba.pb.a.c hCX;
    private final MoreGodReplyModel hCY;
    private long hCZ;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dvS = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hCY.pu()) {
                a.this.hCY.bQQ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hDd = -1;

        private boolean xd(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!xd(this.hDd) && xd(i) && a.this.hCP != null && a.this.hCP.bRh() != null) {
                a.this.hCP.bRh().bUg();
                a.this.hCP.bRh().bVb();
            }
            this.hDd = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hDa = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hCS.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
            a.this.bQO();
        }
    };
    private PbActivity.a hDb = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bQL();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hCY = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bQR());
        this.hCY.a(this.hDa);
        this.hCS = aqVar;
        this.hCP = pbActivity;
        this.hCQ = new d(pbActivity, viewStub);
        this.hCR = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(final Runnable runnable) {
        this.hCY.cancelLoadData();
        this.hCP.bRT();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hCR.bQT()) {
            this.hCQ.r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hCQ.hide();
                    a.this.hCO = false;
                    if (a.this.hCP != null) {
                        if (a.this.hCP.bRh() != null) {
                            a.this.hCP.bRh().oJ(false);
                            f bUx = a.this.hCP.bRh().bUx();
                            bUx.a(a.this.hCP.bQR().getPbData(), true);
                            bUx.notifyDataSetChanged();
                        }
                        a.this.hCP.c(a.this.hDb);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hCZ != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hCZ;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bh(currentTimeMillis);
            e.atQ().a(this.hCP, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bQL() {
        p(null);
    }

    private void showView() {
        boolean bQV = this.hCQ.bQV();
        this.hCQ.show();
        if (!bQV) {
            this.hCQ.bQW().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQL();
                }
            });
            this.hCQ.bQX().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQL();
                }
            });
            this.hCQ.bQZ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hCY.pu()) {
                        a.this.hCY.bQQ();
                    }
                }
            });
            this.hCQ.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hCZ = System.currentTimeMillis();
    }

    public void bQM() {
        if (!isActive()) {
            this.hCP.bRT();
            this.hCO = true;
            this.hCR.setFullscreen(false);
            this.hCR.nU(true);
            showView();
            bQO();
            this.hCQ.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hCR.nU(false);
                }
            });
            this.hCP.b(this.hDb);
            this.hCY.bQQ();
        }
        this.hCP.bRh().bVb();
    }

    public void bQN() {
        if (isActive()) {
            bQO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQO() {
        List<m> bQS = this.hCY.bQS();
        if (bQS != null) {
            com.baidu.tieba.pb.data.d pbData = this.hCY.bQR().getPbData();
            this.hCQ.show();
            this.hCQ.getListView().setOnSrollToBottomListener(this.dvS);
            BdTypeListView listView = this.hCQ.getListView();
            this.hCR.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bQS));
            this.hCQ.aJC().setCenterTextTitle(String.format(this.hCP.getResources().getString(R.string.more_god_reply_count), ap.aL(pbData.bPW().hCo.size())));
            this.hCQ.nV(this.hCY.JO());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hCT == null) {
            this.hCT = new i(this.hCP, PostData.iYC);
            this.hCT.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hCT);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hCT.setData(dVar);
        f bUx = this.hCS.bUx();
        this.hCT.setFromCDN(bUx.isFromCDN());
        this.hCT.setHostId(dVar.bPL().adv().getUserId());
        this.hCT.nR(bUx.bSo());
        this.hCT.v(this.hCU);
        this.hCT.L(this.hCV);
        this.hCT.setOnImageClickListener(this.hCW);
        this.hCT.setOnLongClickListener(this.onLongClickListener);
        this.hCT.setTbGestureDetector(this.hCX);
    }

    public void onChangeSkinType(int i) {
        this.hCQ.onChangeSkinType(i);
    }

    public void v(View.OnClickListener onClickListener) {
        this.hCU = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hCV = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCW = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hCX = cVar;
    }

    public boolean isActive() {
        return this.hCO;
    }

    public d bQP() {
        return this.hCQ;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hCP == null) {
            return null;
        }
        return this.hCP.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.aa(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().atL()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.o.d();
            this.pageStayDurationItem.ao(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.qD(getCurrentPageKey());
            PbModel bQR = this.hCP.bQR();
            if (bQR != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bQR.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bQR.bSI(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
