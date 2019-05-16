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
    private boolean hCL;
    final PbActivity hCM;
    private d hCN;
    private c hCO;
    private aq hCP;
    private i hCQ;
    private View.OnClickListener hCR;
    private View.OnClickListener hCS;
    private TbRichTextView.h hCT;
    private com.baidu.tieba.pb.a.c hCU;
    private final MoreGodReplyModel hCV;
    private long hCW;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dvR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hCV.pu()) {
                a.this.hCV.bQN();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hDa = -1;

        private boolean xd(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!xd(this.hDa) && xd(i) && a.this.hCM != null && a.this.hCM.bRe() != null) {
                a.this.hCM.bRe().bUd();
                a.this.hCM.bRe().bUY();
            }
            this.hDa = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hCX = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hCP.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
            a.this.bQL();
        }
    };
    private PbActivity.a hCY = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bQI();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hCV = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bQO());
        this.hCV.a(this.hCX);
        this.hCP = aqVar;
        this.hCM = pbActivity;
        this.hCN = new d(pbActivity, viewStub);
        this.hCO = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(final Runnable runnable) {
        this.hCV.cancelLoadData();
        this.hCM.bRQ();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hCO.bQQ()) {
            this.hCN.r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hCN.hide();
                    a.this.hCL = false;
                    if (a.this.hCM != null) {
                        if (a.this.hCM.bRe() != null) {
                            a.this.hCM.bRe().oJ(false);
                            f bUu = a.this.hCM.bRe().bUu();
                            bUu.a(a.this.hCM.bQO().getPbData(), true);
                            bUu.notifyDataSetChanged();
                        }
                        a.this.hCM.c(a.this.hCY);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hCW != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hCW;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bh(currentTimeMillis);
            e.atQ().a(this.hCM, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bQI() {
        p(null);
    }

    private void showView() {
        boolean bQS = this.hCN.bQS();
        this.hCN.show();
        if (!bQS) {
            this.hCN.bQT().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQI();
                }
            });
            this.hCN.bQU().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQI();
                }
            });
            this.hCN.bQW().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hCV.pu()) {
                        a.this.hCV.bQN();
                    }
                }
            });
            this.hCN.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hCW = System.currentTimeMillis();
    }

    public void bQJ() {
        if (!isActive()) {
            this.hCM.bRQ();
            this.hCL = true;
            this.hCO.setFullscreen(false);
            this.hCO.nU(true);
            showView();
            bQL();
            this.hCN.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hCO.nU(false);
                }
            });
            this.hCM.b(this.hCY);
            this.hCV.bQN();
        }
        this.hCM.bRe().bUY();
    }

    public void bQK() {
        if (isActive()) {
            bQL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQL() {
        List<m> bQP = this.hCV.bQP();
        if (bQP != null) {
            com.baidu.tieba.pb.data.d pbData = this.hCV.bQO().getPbData();
            this.hCN.show();
            this.hCN.getListView().setOnSrollToBottomListener(this.dvR);
            BdTypeListView listView = this.hCN.getListView();
            this.hCO.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bQP));
            this.hCN.aJz().setCenterTextTitle(String.format(this.hCM.getResources().getString(R.string.more_god_reply_count), ap.aL(pbData.bPT().hCl.size())));
            this.hCN.nV(this.hCV.JO());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hCQ == null) {
            this.hCQ = new i(this.hCM, PostData.iYA);
            this.hCQ.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hCQ);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hCQ.setData(dVar);
        f bUu = this.hCP.bUu();
        this.hCQ.setFromCDN(bUu.isFromCDN());
        this.hCQ.setHostId(dVar.bPI().adv().getUserId());
        this.hCQ.nR(bUu.bSl());
        this.hCQ.v(this.hCR);
        this.hCQ.L(this.hCS);
        this.hCQ.setOnImageClickListener(this.hCT);
        this.hCQ.setOnLongClickListener(this.onLongClickListener);
        this.hCQ.setTbGestureDetector(this.hCU);
    }

    public void onChangeSkinType(int i) {
        this.hCN.onChangeSkinType(i);
    }

    public void v(View.OnClickListener onClickListener) {
        this.hCR = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hCS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCT = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hCU = cVar;
    }

    public boolean isActive() {
        return this.hCL;
    }

    public d bQM() {
        return this.hCN;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hCM == null) {
            return null;
        }
        return this.hCM.getNextPageSourceKeyList();
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
            PbModel bQO = this.hCM.bQO();
            if (bQO != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bQO.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bQO.bSF(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
