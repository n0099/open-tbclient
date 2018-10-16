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
    private boolean fJk;
    final PbActivity fJl;
    private d fJm;
    private c fJn;
    private ar fJo;
    private i fJp;
    private View.OnClickListener fJq;
    private View.OnClickListener fJr;
    private TbRichTextView.h fJs;
    private com.baidu.tieba.pb.a.c fJt;
    private final MoreGodReplyModel fJu;
    private long fJv;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bQS = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fJu.DU()) {
                a.this.fJu.bfZ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fJz = -1;

        private boolean ro(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!ro(this.fJz) && ro(i) && a.this.fJl != null && a.this.fJl.bgr() != null) {
                a.this.fJl.bgr().bjm();
                a.this.fJl.bgr().bkf();
            }
            this.fJz = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fJw = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void i(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fJo.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void Q(List<PostData> list) {
            a.this.bfX();
        }
    };
    private PbActivity.a fJx = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bfU();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fJu = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bga());
        this.fJu.a(this.fJw);
        this.fJo = arVar;
        this.fJl = pbActivity;
        this.fJm = new d(pbActivity, viewStub);
        this.fJn = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.fJu.cancelLoadData();
        this.fJl.bhd();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fJn.bgc()) {
            this.fJm.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJm.hide();
                    a.this.fJk = false;
                    if (a.this.fJl != null) {
                        if (a.this.fJl.bgr() != null) {
                            a.this.fJl.bgr().le(false);
                            f bjD = a.this.fJl.bgr().bjD();
                            bjD.a(a.this.fJl.bga().getPbData(), true);
                            bjD.notifyDataSetChanged();
                        }
                        a.this.fJl.c(a.this.fJx);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fJv != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fJv;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.ag(currentTimeMillis);
            e.NE().a(this.fJl, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bfU() {
        h(null);
    }

    private void showView() {
        boolean bge = this.fJm.bge();
        this.fJm.show();
        if (!bge) {
            this.fJm.bgf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bfU();
                }
            });
            this.fJm.bgg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bfU();
                }
            });
            this.fJm.bgi().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fJu.DU()) {
                        a.this.fJu.bfZ();
                    }
                }
            });
            this.fJm.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fJv = System.currentTimeMillis();
    }

    public void bfV() {
        if (!isActive()) {
            this.fJl.bhd();
            this.fJk = true;
            this.fJn.setFullscreen(false);
            this.fJn.ko(true);
            showView();
            bfX();
            this.fJm.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJn.ko(false);
                }
            });
            this.fJl.b(this.fJx);
            this.fJu.bfZ();
        }
        this.fJl.bgr().bkf();
    }

    public void bfW() {
        if (isActive()) {
            bfX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfX() {
        List<h> bgb = this.fJu.bgb();
        if (bgb != null) {
            com.baidu.tieba.pb.data.d pbData = this.fJu.bga().getPbData();
            this.fJm.show();
            this.fJm.getListView().setOnSrollToBottomListener(this.bQS);
            BdTypeListView listView = this.fJm.getListView();
            this.fJn.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bgb));
            this.fJm.aaD().setCenterTextTitle(String.format(this.fJl.getResources().getString(e.j.more_god_reply_count), ao.L(pbData.bfg().fIG.size())));
            this.fJm.kp(this.fJu.hasMoreData());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fJp == null) {
            this.fJp = new i(this.fJl, PostData.hcV);
            this.fJp.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fJp);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fJp.b(dVar);
        f bjD = this.fJo.bjD();
        this.fJp.setFromCDN(bjD.isFromCDN());
        this.fJp.setHostId(dVar.beV().yv().getUserId());
        this.fJp.kl(bjD.bhx());
        this.fJp.q(this.fJq);
        this.fJp.G(this.fJr);
        this.fJp.setOnImageClickListener(this.fJs);
        this.fJp.setOnLongClickListener(this.onLongClickListener);
        this.fJp.setTbGestureDetector(this.fJt);
    }

    public void onChangeSkinType(int i) {
        this.fJm.onChangeSkinType(i);
    }

    public void q(View.OnClickListener onClickListener) {
        this.fJq = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fJr = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fJs = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fJt = cVar;
    }

    public boolean isActive() {
        return this.fJk;
    }

    public d bfY() {
        return this.fJm;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fJl == null) {
            return null;
        }
        return this.fJl.getNextPageSourceKeyList();
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
            PbModel bga = this.fJl.bga();
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
