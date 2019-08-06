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
    private boolean hJV;
    final PbActivity hJW;
    private d hJX;
    private c hJY;
    private aq hJZ;
    private i hKa;
    private View.OnClickListener hKb;
    private View.OnClickListener hKc;
    private TbRichTextView.h hKd;
    private com.baidu.tieba.pb.a.c hKe;
    private final MoreGodReplyModel hKf;
    private long hKg;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dyY = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hKf.pP()) {
                a.this.hKf.bTQ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hKk = -1;

        private boolean xJ(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!xJ(this.hKk) && xJ(i) && a.this.hJW != null && a.this.hJW.bUj() != null) {
                a.this.hJW.bUj().bXl();
                a.this.hJW.bUj().bYh();
            }
            this.hKk = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hKh = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hJZ.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
            a.this.bTO();
        }
    };
    private PbActivity.a hKi = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bTL();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hKf = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bTR());
        this.hKf.a(this.hKh);
        this.hJZ = aqVar;
        this.hJW = pbActivity;
        this.hJX = new d(pbActivity, viewStub);
        this.hJY = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.hKf.cancelLoadData();
        this.hJW.bUV();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hJY.bTT()) {
            this.hJX.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hJX.hide();
                    a.this.hJV = false;
                    if (a.this.hJW != null) {
                        if (a.this.hJW.bUj() != null) {
                            a.this.hJW.bUj().oY(false);
                            f bXC = a.this.hJW.bUj().bXC();
                            bXC.a(a.this.hJW.bTR().getPbData(), true);
                            bXC.notifyDataSetChanged();
                        }
                        a.this.hJW.c(a.this.hKi);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hKg != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hKg;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bi(currentTimeMillis);
            e.avb().a(this.hJW, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bTL() {
        q(null);
    }

    private void showView() {
        boolean bTW = this.hJX.bTW();
        this.hJX.show();
        if (!bTW) {
            this.hJX.bTX().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTL();
                }
            });
            this.hJX.bTY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bTL();
                }
            });
            this.hJX.bUa().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hKf.pP()) {
                        a.this.hKf.bTQ();
                    }
                }
            });
            this.hJX.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hKg = System.currentTimeMillis();
    }

    public void bTM() {
        if (!isActive()) {
            this.hJW.bUV();
            this.hJV = true;
            this.hJY.setFullscreen(false);
            this.hJY.oj(true);
            showView();
            bTO();
            this.hJX.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hJY.oj(false);
                }
            });
            this.hJW.b(this.hKi);
            this.hKf.bTQ();
        }
        this.hJW.bUj().bYh();
    }

    public void bTN() {
        if (isActive()) {
            bTO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTO() {
        List<m> bTS = this.hKf.bTS();
        if (bTS != null) {
            com.baidu.tieba.pb.data.d pbData = this.hKf.bTR().getPbData();
            this.hJX.show();
            this.hJX.getListView().setOnSrollToBottomListener(this.dyY);
            BdTypeListView listView = this.hJX.getListView();
            this.hJY.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bTS));
            this.hJX.aLj().setCenterTextTitle(String.format(this.hJW.getResources().getString(R.string.more_god_reply_count), com.baidu.tbadk.core.util.aq.aM(pbData.bSW().hJv.size())));
            this.hJX.ok(this.hKf.KB());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hKa == null) {
            this.hKa = new i(this.hJW, PostData.jge);
            this.hKa.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hKa);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hKa.setData(dVar);
        f bXC = this.hJZ.bXC();
        this.hKa.setFromCDN(bXC.isFromCDN());
        this.hKa.setHostId(dVar.bSL().aey().getUserId());
        this.hKa.og(bXC.bVr());
        this.hKa.v(this.hKb);
        this.hKa.N(this.hKc);
        this.hKa.setOnImageClickListener(this.hKd);
        this.hKa.setOnLongClickListener(this.onLongClickListener);
        this.hKa.setTbGestureDetector(this.hKe);
    }

    public void onChangeSkinType(int i) {
        this.hJX.onChangeSkinType(i);
    }

    public void v(View.OnClickListener onClickListener) {
        this.hKb = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hKc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hKd = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hKe = cVar;
    }

    public boolean isActive() {
        return this.hJV;
    }

    public d bTP() {
        return this.hJX;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hJW == null) {
            return null;
        }
        return this.hJW.getNextPageSourceKeyList();
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
        if ((getPageStayFilter() == null || getPageStayFilter().auV()) && !StringUtils.isNull(currentPageKey)) {
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
            PbModel bTR = this.hJW.bTR();
            if (bTR != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bTR.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bTR.bVL(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
