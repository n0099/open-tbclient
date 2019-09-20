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
    private boolean hLS;
    final PbActivity hLT;
    private d hLU;
    private c hLV;
    private aq hLW;
    private i hLX;
    private View.OnClickListener hLY;
    private View.OnClickListener hLZ;
    private TbRichTextView.h hMa;
    private com.baidu.tieba.pb.a.c hMb;
    private final MoreGodReplyModel hMc;
    private long hMd;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdListView.e dAJ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.hMc.pQ()) {
                a.this.hMc.bUD();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int hMh = -1;

        private boolean xM(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!xM(this.hMh) && xM(i) && a.this.hLT != null && a.this.hLT.bUW() != null) {
                a.this.hLT.bUW().bXY();
                a.this.hLT.bUW().bYU();
            }
            this.hMh = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a hMe = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.hLW.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
            a.this.bUB();
        }
    };
    private PbActivity.a hMf = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bUy();
            return true;
        }
    };

    public a(PbActivity pbActivity, aq aqVar, ViewStub viewStub) {
        this.hMc = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bUE());
        this.hMc.a(this.hMe);
        this.hLW = aqVar;
        this.hLT = pbActivity;
        this.hLU = new d(pbActivity, viewStub);
        this.hLV = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.hMc.cancelLoadData();
        this.hLT.bVI();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.hLV.bUG()) {
            this.hLU.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hLU.hide();
                    a.this.hLS = false;
                    if (a.this.hLT != null) {
                        if (a.this.hLT.bUW() != null) {
                            a.this.hLT.bUW().pc(false);
                            f bYp = a.this.hLT.bUW().bYp();
                            bYp.a(a.this.hLT.bUE().getPbData(), true);
                            bYp.notifyDataSetChanged();
                        }
                        a.this.hLT.c(a.this.hMf);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.hMd != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.hMd;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bl(currentTimeMillis);
            e.avn().a(this.hLT, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bUy() {
        q(null);
    }

    private void showView() {
        boolean bUJ = this.hLU.bUJ();
        this.hLU.show();
        if (!bUJ) {
            this.hLU.bUK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bUy();
                }
            });
            this.hLU.bUL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bUy();
                }
            });
            this.hLU.bUN().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.hMc.pQ()) {
                        a.this.hMc.bUD();
                    }
                }
            });
            this.hLU.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.hMd = System.currentTimeMillis();
    }

    public void bUz() {
        if (!isActive()) {
            this.hLT.bVI();
            this.hLS = true;
            this.hLV.setFullscreen(false);
            this.hLV.on(true);
            showView();
            bUB();
            this.hLU.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hLV.on(false);
                }
            });
            this.hLT.b(this.hMf);
            this.hMc.bUD();
        }
        this.hLT.bUW().bYU();
    }

    public void bUA() {
        if (isActive()) {
            bUB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUB() {
        List<m> bUF = this.hMc.bUF();
        if (bUF != null) {
            com.baidu.tieba.pb.data.d pbData = this.hMc.bUE().getPbData();
            this.hLU.show();
            this.hLU.getListView().setOnSrollToBottomListener(this.dAJ);
            BdTypeListView listView = this.hLU.getListView();
            this.hLV.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(bUF));
            this.hLU.aLN().setCenterTextTitle(String.format(this.hLT.getResources().getString(R.string.more_god_reply_count), com.baidu.tbadk.core.util.aq.aM(pbData.bTJ().hLs.size())));
            this.hLU.oo(this.hMc.KF());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.hLX == null) {
            this.hLX = new i(this.hLT, PostData.jiA);
            this.hLX.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hLX);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.d dVar) {
        this.hLX.setData(dVar);
        f bYp = this.hLW.bYp();
        this.hLX.setFromCDN(bYp.isFromCDN());
        this.hLX.setHostId(dVar.bTy().aeC().getUserId());
        this.hLX.ok(bYp.bWe());
        this.hLX.v(this.hLY);
        this.hLX.N(this.hLZ);
        this.hLX.setOnImageClickListener(this.hMa);
        this.hLX.setOnLongClickListener(this.onLongClickListener);
        this.hLX.setTbGestureDetector(this.hMb);
    }

    public void onChangeSkinType(int i) {
        this.hLU.onChangeSkinType(i);
    }

    public void v(View.OnClickListener onClickListener) {
        this.hLY = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hLZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hMa = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.hMb = cVar;
    }

    public boolean isActive() {
        return this.hLS;
    }

    public d bUC() {
        return this.hLU;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.hLT == null) {
            return null;
        }
        return this.hLT.getNextPageSourceKeyList();
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
        if ((getPageStayFilter() == null || getPageStayFilter().avh()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.re(getCurrentPageKey());
            PbModel bUE = this.hLT.bUE();
            if (bUE != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.e(bUE.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.e(bUE.bWy(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }
}
