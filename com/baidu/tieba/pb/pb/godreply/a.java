package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean fJl;
    final PbActivity fJm;
    private d fJn;
    private c fJo;
    private ar fJp;
    private i fJq;
    private View.OnClickListener fJr;
    private View.OnClickListener fJs;
    private TbRichTextView.h fJt;
    private com.baidu.tieba.pb.a.c fJu;
    private final MoreGodReplyModel fJv;
    private long fJw;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bQS = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fJv.DU()) {
                a.this.fJv.bfZ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fJA = -1;

        private boolean ro(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!ro(this.fJA) && ro(i) && a.this.fJm != null && a.this.fJm.bgr() != null) {
                a.this.fJm.bgr().bjm();
                a.this.fJm.bgr().bkf();
            }
            this.fJA = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fJx = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void i(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fJp.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void Q(List<PostData> list) {
            a.this.bfX();
        }
    };
    private PbActivity.a fJy = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bfU();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fJv = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bga());
        this.fJv.a(this.fJx);
        this.fJp = arVar;
        this.fJm = pbActivity;
        this.fJn = new d(pbActivity, viewStub);
        this.fJo = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.fJv.cancelLoadData();
        this.fJm.bhd();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fJo.bgc()) {
            this.fJn.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJn.hide();
                    a.this.fJl = false;
                    if (a.this.fJm != null) {
                        if (a.this.fJm.bgr() != null) {
                            a.this.fJm.bgr().le(false);
                            f bjD = a.this.fJm.bgr().bjD();
                            bjD.a(a.this.fJm.bga().getPbData(), true);
                            bjD.notifyDataSetChanged();
                        }
                        a.this.fJm.c(a.this.fJy);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fJw != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fJw;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.ag(currentTimeMillis);
            e.NE().a(this.fJm, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bfU() {
        h(null);
    }

    private void showView() {
        boolean bge = this.fJn.bge();
        this.fJn.show();
        if (!bge) {
            this.fJn.bgf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bfU();
                }
            });
            this.fJn.bgg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bfU();
                }
            });
            this.fJn.bgi().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fJv.DU()) {
                        a.this.fJv.bfZ();
                    }
                }
            });
            this.fJn.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fJw = System.currentTimeMillis();
    }

    public void bfV() {
        if (!isActive()) {
            this.fJm.bhd();
            this.fJl = true;
            this.fJo.setFullscreen(false);
            this.fJo.ko(true);
            showView();
            bfX();
            this.fJn.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJo.ko(false);
                }
            });
            this.fJm.b(this.fJy);
            this.fJv.bfZ();
        }
        this.fJm.bgr().bkf();
    }

    public void bfW() {
        if (isActive()) {
            bfX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfX() {
        List<h> bgb = this.fJv.bgb();
        if (bgb != null) {
            com.baidu.tieba.pb.data.d pbData = this.fJv.bga().getPbData();
            this.fJn.show();
            this.fJn.getListView().setOnSrollToBottomListener(this.bQS);
            BdTypeListView listView = this.fJn.getListView();
            this.fJo.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bgb));
            this.fJn.aaE().setCenterTextTitle(String.format(this.fJm.getResources().getString(e.j.more_god_reply_count), ao.L(pbData.bfg().fIH.size())));
            this.fJn.kp(this.fJv.hasMoreData());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fJq == null) {
            this.fJq = new i(this.fJm, PostData.hcW);
            this.fJq.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fJq);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fJq.b(dVar);
        f bjD = this.fJp.bjD();
        this.fJq.setFromCDN(bjD.isFromCDN());
        this.fJq.setHostId(dVar.beV().yv().getUserId());
        this.fJq.kl(bjD.bhx());
        this.fJq.q(this.fJr);
        this.fJq.G(this.fJs);
        this.fJq.setOnImageClickListener(this.fJt);
        this.fJq.setOnLongClickListener(this.onLongClickListener);
        this.fJq.setTbGestureDetector(this.fJu);
    }

    public void onChangeSkinType(int i) {
        this.fJn.onChangeSkinType(i);
    }

    public void q(View.OnClickListener onClickListener) {
        this.fJr = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fJs = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fJt = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fJu = cVar;
    }

    public boolean isActive() {
        return this.fJl;
    }

    public d bfY() {
        return this.fJn;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fJm == null) {
            return null;
        }
        return this.fJm.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.J(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Nz()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.V(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.hX(getCurrentPageKey());
            PbModel bga = this.fJm.bga();
            if (bga != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bga.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bga.bhP(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
