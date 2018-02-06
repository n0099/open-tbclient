package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private boolean fJK;
    final PbActivity fJL;
    private d fJM;
    private c fJN;
    private ar fJO;
    private i fJP;
    private View.OnClickListener fJQ;
    private View.OnClickListener fJR;
    private TbRichTextView.h fJS;
    private com.baidu.tieba.pb.a.c fJT;
    private final MoreGodReplyModel fJU;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e ckq = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fJU.El()) {
                a.this.fJU.bbz();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fJY = -1;

        private boolean sF(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!sF(this.fJY) && sF(i) && a.this.fJL != null && a.this.fJL.bbR() != null) {
                a.this.fJL.bbR().beL();
                a.this.fJL.bbR().bfE();
            }
            this.fJY = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private y.a fJV = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fJO.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void L(List<PostData> list) {
            a.this.bbx();
        }
    };
    private PbActivity.a fJW = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bbu();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fJU = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bbA());
        this.fJU.a(this.fJV);
        this.fJO = arVar;
        this.fJL = pbActivity;
        this.fJM = new d(pbActivity, viewStub);
        this.fJN = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.fJU.cancelLoadData();
        this.fJL.bcB();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.fJN.bbC()) {
            this.fJM.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJM.hide();
                    a.this.fJK = false;
                    if (a.this.fJL != null) {
                        if (a.this.fJL.bbR() != null) {
                            a.this.fJL.bbR().kM(false);
                            f bfb = a.this.fJL.bbR().bfb();
                            bfb.a(a.this.fJL.bbA().getPbData(), true);
                            bfb.notifyDataSetChanged();
                        }
                        a.this.fJL.c(a.this.fJW);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void bbu() {
        j(null);
    }

    private void ce() {
        boolean bbE = this.fJM.bbE();
        this.fJM.show();
        if (!bbE) {
            this.fJM.bbF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbu();
                }
            });
            this.fJM.bbG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbu();
                }
            });
            this.fJM.bbI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fJU.El()) {
                        a.this.fJU.bbz();
                    }
                }
            });
            this.fJM.getListView().setOnScrollListener(this.onScrollListener);
        }
    }

    public void bbv() {
        if (!isActive()) {
            this.fJL.bcB();
            this.fJK = true;
            this.fJN.setFullscreen(false);
            this.fJN.jS(true);
            ce();
            bbx();
            this.fJM.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJN.jS(false);
                }
            });
            this.fJL.b(this.fJW);
            this.fJU.bbz();
        }
        this.fJL.bbR().bfE();
    }

    public void bbw() {
        if (isActive()) {
            bbx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbx() {
        List<com.baidu.adp.widget.ListView.i> bbB = this.fJU.bbB();
        if (bbB != null) {
            com.baidu.tieba.pb.data.d pbData = this.fJU.bbA().getPbData();
            this.fJM.show();
            this.fJM.getListView().setOnSrollToBottomListener(this.ckq);
            BdTypeListView listView = this.fJM.getListView();
            this.fJN.Em();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bbB));
            this.fJM.avk().setCenterTextTitle(String.format(this.fJL.getResources().getString(d.j.more_god_reply_count), am.H(pbData.baF().fIq.size())));
            this.fJM.jT(this.fJU.aiq());
            if (listView.getAdapter() instanceof e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fJP == null) {
            this.fJP = new i(this.fJL, PostData.haQ);
            this.fJP.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fJP);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fJP.b(dVar);
        f bfb = this.fJO.bfb();
        this.fJP.setFromCDN(bfb.isFromCDN());
        this.fJP.setHostId(dVar.bau().zn().getUserId());
        this.fJP.jP(bfb.bcS());
        this.fJP.l(this.fJQ);
        this.fJP.E(this.fJR);
        this.fJP.setOnImageClickListener(this.fJS);
        this.fJP.setOnLongClickListener(this.onLongClickListener);
        this.fJP.setTbGestureDetector(this.fJT);
    }

    public void onChangeSkinType(int i) {
        this.fJM.onChangeSkinType(i);
    }

    public void l(View.OnClickListener onClickListener) {
        this.fJQ = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fJR = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fJS = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fJT = cVar;
    }

    public boolean isActive() {
        return this.fJK;
    }

    public d bby() {
        return this.fJM;
    }
}
