package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
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
    private boolean hJc;
    final PbActivity hJd;
    private d hJe;
    private c hJf;
    private aq hJg;
    private i hJh;
    private View.OnClickListener hJi;
    private View.OnClickListener hJj;
    private TbRichTextView.h hJk;
    private com.baidu.tieba.pb.a.c hJl;
    private final MoreGodReplyModel hJm;
    private long hJn;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dyR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hJm.pP()) {
                a.this.hJm.bTC();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hJr = -1;

        private boolean xH(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!xH(this.hJr) && xH(i) && a.this.hJd != null && a.this.hJd.bTU() != null) {
                a.this.hJd.bTU().bWU();
                a.this.hJd.bTU().bXQ();
            }
            this.hJr = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hJo = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hJg.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
            a.this.bTA();
        }
    };
    private PbActivity.a hJp = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bTx();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hJm = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bTD());
        this.hJm.a(this.hJo);
        this.hJg = aqVar;
        this.hJd = pbActivity;
        this.hJe = new d(pbActivity, viewStub);
        this.hJf = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.hJm.cancelLoadData();
        this.hJd.bUG();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hJf.bTF()) {
            this.hJe.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hJe.hide();
                    a.this.hJc = false;
                    if (a.this.hJd != null) {
                        if (a.this.hJd.bTU() != null) {
                            a.this.hJd.bTU().oY(false);
                            f bXl = a.this.hJd.bTU().bXl();
                            bXl.a(a.this.hJd.bTD().getPbData(), true);
                            bXl.notifyDataSetChanged();
                        }
                        a.this.hJd.c(a.this.hJp);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hJn != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hJn;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bi(currentTimeMillis);
            e.auZ().a(this.hJd, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bTx() {
        q(null);
    }

    private void showView() {
        boolean bTI = this.hJe.bTI();
        this.hJe.show();
        if (!bTI) {
            this.hJe.bTJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTx();
                }
            });
            this.hJe.bTK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTx();
                }
            });
            this.hJe.bTM().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hJm.pP()) {
                        a.this.hJm.bTC();
                    }
                }
            });
            this.hJe.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hJn = System.currentTimeMillis();
    }

    public void bTy() {
        if (!isActive()) {
            this.hJd.bUG();
            this.hJc = true;
            this.hJf.setFullscreen(false);
            this.hJf.oj(true);
            showView();
            bTA();
            this.hJe.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hJf.oj(false);
                }
            });
            this.hJd.b(this.hJp);
            this.hJm.bTC();
        }
        this.hJd.bTU().bXQ();
    }

    public void bTz() {
        if (isActive()) {
            bTA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTA() {
        List<m> bTE = this.hJm.bTE();
        if (bTE != null) {
            com.baidu.tieba.pb.data.d pbData = this.hJm.bTD().getPbData();
            this.hJe.show();
            this.hJe.getListView().setOnSrollToBottomListener(this.dyR);
            BdTypeListView listView = this.hJe.getListView();
            this.hJf.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bTE));
            this.hJe.aLh().setCenterTextTitle(String.format(this.hJd.getResources().getString(R.string.more_god_reply_count), com.baidu.tbadk.core.util.aq.aM(pbData.bSI().hIC.size())));
            this.hJe.ok(this.hJm.KB());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hJh == null) {
            this.hJh = new i(this.hJd, PostData.jeX);
            this.hJh.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hJh);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hJh.setData(dVar);
        f bXl = this.hJg.bXl();
        this.hJh.setFromCDN(bXl.isFromCDN());
        this.hJh.setHostId(dVar.bSx().aex().getUserId());
        this.hJh.og(bXl.bVb());
        this.hJh.v(this.hJi);
        this.hJh.N(this.hJj);
        this.hJh.setOnImageClickListener(this.hJk);
        this.hJh.setOnLongClickListener(this.onLongClickListener);
        this.hJh.setTbGestureDetector(this.hJl);
    }

    public void onChangeSkinType(int i) {
        this.hJe.onChangeSkinType(i);
    }

    public void v(View.OnClickListener onClickListener) {
        this.hJi = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hJj = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hJk = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hJl = cVar;
    }

    public boolean isActive() {
        return this.hJc;
    }

    public d bTB() {
        return this.hJe;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hJd == null) {
            return null;
        }
        return this.hJd.getNextPageSourceKeyList();
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
        if ((getPageStayFilter() == null || getPageStayFilter().auT()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.qT(getCurrentPageKey());
            PbModel bTD = this.hJd.bTD();
            if (bTD != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bTD.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bTD.bVv(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
