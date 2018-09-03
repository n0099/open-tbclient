package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean ftR;
    final PbActivity ftS;
    private d ftT;
    private c ftU;
    private at ftV;
    private i ftW;
    private View.OnClickListener ftX;
    private View.OnClickListener ftY;
    private TbRichTextView.h ftZ;
    private com.baidu.tieba.pb.a.c fua;
    private final MoreGodReplyModel fub;
    private long fuc;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bCA = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fub.AB()) {
                a.this.fub.ban();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fug = -1;

        private boolean qq(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qq(this.fug) && qq(i) && a.this.ftS != null && a.this.ftS.baF() != null) {
                a.this.ftS.baF().bdC();
                a.this.ftS.baF().beu();
            }
            this.fug = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fud = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.ftV.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void G(List<PostData> list) {
            a.this.bal();
        }
    };
    private PbActivity.a fue = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bai();
            return true;
        }
    };

    public a(PbActivity pbActivity, at atVar, ViewStub viewStub) {
        this.fub = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bao());
        this.fub.a(this.fud);
        this.ftV = atVar;
        this.ftS = pbActivity;
        this.ftT = new d(pbActivity, viewStub);
        this.ftU = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.fub.cancelLoadData();
        this.ftS.bbq();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.ftU.baq()) {
            this.ftT.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ftT.hide();
                    a.this.ftR = false;
                    if (a.this.ftS != null) {
                        if (a.this.ftS.baF() != null) {
                            a.this.ftS.baF().kq(false);
                            f bdS = a.this.ftS.baF().bdS();
                            bdS.a(a.this.ftS.bao().getPbData(), true);
                            bdS.notifyDataSetChanged();
                        }
                        a.this.ftS.c(a.this.fue);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fuc != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fuc;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aa(currentTimeMillis);
            e.Kq().a(this.ftS, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bai() {
        h(null);
    }

    private void showView() {
        boolean bas = this.ftT.bas();
        this.ftT.show();
        if (!bas) {
            this.ftT.bat().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bai();
                }
            });
            this.ftT.bau().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bai();
                }
            });
            this.ftT.baw().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fub.AB()) {
                        a.this.fub.ban();
                    }
                }
            });
            this.ftT.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fuc = System.currentTimeMillis();
    }

    public void baj() {
        if (!isActive()) {
            this.ftS.bbq();
            this.ftR = true;
            this.ftU.setFullscreen(false);
            this.ftU.jw(true);
            showView();
            bal();
            this.ftT.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ftU.jw(false);
                }
            });
            this.ftS.b(this.fue);
            this.fub.ban();
        }
        this.ftS.baF().beu();
    }

    public void bak() {
        if (isActive()) {
            bal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bal() {
        List<h> bap = this.fub.bap();
        if (bap != null) {
            com.baidu.tieba.pb.data.d pbData = this.fub.bao().getPbData();
            this.ftT.show();
            this.ftT.getListView().setOnSrollToBottomListener(this.bCA);
            BdTypeListView listView = this.ftT.getListView();
            this.ftU.AC();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bap));
            this.ftT.Vj().setCenterTextTitle(String.format(this.ftS.getResources().getString(f.j.more_god_reply_count), ap.F(pbData.aZt().ftv.size())));
            this.ftT.jx(this.fub.agV());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.ftW == null) {
            this.ftW = new i(this.ftS, PostData.gNW);
            this.ftW.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.ftW);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.ftW.b(dVar);
        com.baidu.tieba.pb.pb.main.f bdS = this.ftV.bdS();
        this.ftW.setFromCDN(bdS.isFromCDN());
        this.ftW.setHostId(dVar.aZi().vj().getUserId());
        this.ftW.jt(bdS.bbK());
        this.ftW.q(this.ftX);
        this.ftW.G(this.ftY);
        this.ftW.setOnImageClickListener(this.ftZ);
        this.ftW.setOnLongClickListener(this.onLongClickListener);
        this.ftW.setTbGestureDetector(this.fua);
    }

    public void onChangeSkinType(int i) {
        this.ftT.onChangeSkinType(i);
    }

    public void q(View.OnClickListener onClickListener) {
        this.ftX = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.ftY = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ftZ = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fua = cVar;
    }

    public boolean isActive() {
        return this.ftR;
    }

    public d bam() {
        return this.ftT;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.ftS == null) {
            return null;
        }
        return this.ftS.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (w.z(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Kl()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.L(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.hn(getCurrentPageKey());
            PbModel bao = this.ftS.bao();
            if (bao != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bao.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bao.bcd(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
