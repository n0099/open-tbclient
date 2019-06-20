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
    private boolean hCP;
    final PbActivity hCQ;
    private d hCR;
    private c hCS;
    private aq hCT;
    private i hCU;
    private View.OnClickListener hCV;
    private View.OnClickListener hCW;
    private TbRichTextView.h hCX;
    private com.baidu.tieba.pb.a.c hCY;
    private final MoreGodReplyModel hCZ;
    private long hDa;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dvS = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hCZ.pu()) {
                a.this.hCZ.bQR();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hDe = -1;

        private boolean xd(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!xd(this.hDe) && xd(i) && a.this.hCQ != null && a.this.hCQ.bRi() != null) {
                a.this.hCQ.bRi().bUh();
                a.this.hCQ.bRi().bVc();
            }
            this.hDe = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hDb = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hCT.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
            a.this.bQP();
        }
    };
    private PbActivity.a hDc = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bQM();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hCZ = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bQS());
        this.hCZ.a(this.hDb);
        this.hCT = aqVar;
        this.hCQ = pbActivity;
        this.hCR = new d(pbActivity, viewStub);
        this.hCS = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(final Runnable runnable) {
        this.hCZ.cancelLoadData();
        this.hCQ.bRU();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hCS.bQU()) {
            this.hCR.r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hCR.hide();
                    a.this.hCP = false;
                    if (a.this.hCQ != null) {
                        if (a.this.hCQ.bRi() != null) {
                            a.this.hCQ.bRi().oK(false);
                            f bUy = a.this.hCQ.bRi().bUy();
                            bUy.a(a.this.hCQ.bQS().getPbData(), true);
                            bUy.notifyDataSetChanged();
                        }
                        a.this.hCQ.c(a.this.hDc);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hDa != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hDa;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bh(currentTimeMillis);
            e.atQ().a(this.hCQ, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bQM() {
        p(null);
    }

    private void showView() {
        boolean bQW = this.hCR.bQW();
        this.hCR.show();
        if (!bQW) {
            this.hCR.bQX().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQM();
                }
            });
            this.hCR.bQY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQM();
                }
            });
            this.hCR.bRa().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hCZ.pu()) {
                        a.this.hCZ.bQR();
                    }
                }
            });
            this.hCR.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hDa = System.currentTimeMillis();
    }

    public void bQN() {
        if (!isActive()) {
            this.hCQ.bRU();
            this.hCP = true;
            this.hCS.setFullscreen(false);
            this.hCS.nV(true);
            showView();
            bQP();
            this.hCR.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hCS.nV(false);
                }
            });
            this.hCQ.b(this.hDc);
            this.hCZ.bQR();
        }
        this.hCQ.bRi().bVc();
    }

    public void bQO() {
        if (isActive()) {
            bQP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQP() {
        List<m> bQT = this.hCZ.bQT();
        if (bQT != null) {
            com.baidu.tieba.pb.data.d pbData = this.hCZ.bQS().getPbData();
            this.hCR.show();
            this.hCR.getListView().setOnSrollToBottomListener(this.dvS);
            BdTypeListView listView = this.hCR.getListView();
            this.hCS.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bQT));
            this.hCR.aJC().setCenterTextTitle(String.format(this.hCQ.getResources().getString(R.string.more_god_reply_count), ap.aL(pbData.bPX().hCp.size())));
            this.hCR.nW(this.hCZ.JO());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hCU == null) {
            this.hCU = new i(this.hCQ, PostData.iYG);
            this.hCU.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hCU);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hCU.setData(dVar);
        f bUy = this.hCT.bUy();
        this.hCU.setFromCDN(bUy.isFromCDN());
        this.hCU.setHostId(dVar.bPM().adv().getUserId());
        this.hCU.nS(bUy.bSp());
        this.hCU.v(this.hCV);
        this.hCU.L(this.hCW);
        this.hCU.setOnImageClickListener(this.hCX);
        this.hCU.setOnLongClickListener(this.onLongClickListener);
        this.hCU.setTbGestureDetector(this.hCY);
    }

    public void onChangeSkinType(int i) {
        this.hCR.onChangeSkinType(i);
    }

    public void v(View.OnClickListener onClickListener) {
        this.hCV = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hCW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCX = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hCY = cVar;
    }

    public boolean isActive() {
        return this.hCP;
    }

    public d bQQ() {
        return this.hCR;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hCQ == null) {
            return null;
        }
        return this.hCQ.getNextPageSourceKeyList();
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
            this.pageStayDurationItem.qC(getCurrentPageKey());
            PbModel bQS = this.hCQ.bQS();
            if (bQS != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bQS.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bQS.bSJ(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
