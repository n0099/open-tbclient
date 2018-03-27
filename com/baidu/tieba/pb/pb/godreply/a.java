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
    private boolean fJP;
    final PbActivity fJQ;
    private d fJR;
    private c fJS;
    private ar fJT;
    private i fJU;
    private View.OnClickListener fJV;
    private View.OnClickListener fJW;
    private TbRichTextView.h fJX;
    private com.baidu.tieba.pb.a.c fJY;
    private final MoreGodReplyModel fJZ;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e ckh = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fJZ.El()) {
                a.this.fJZ.bbz();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fKd = -1;

        private boolean sG(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!sG(this.fKd) && sG(i) && a.this.fJQ != null && a.this.fJQ.bbR() != null) {
                a.this.fJQ.bbR().beL();
                a.this.fJQ.bbR().bfE();
            }
            this.fKd = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private y.a fKa = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fJT.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void L(List<PostData> list) {
            a.this.bbx();
        }
    };
    private PbActivity.a fKb = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bbu();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fJZ = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bbA());
        this.fJZ.a(this.fKa);
        this.fJT = arVar;
        this.fJQ = pbActivity;
        this.fJR = new d(pbActivity, viewStub);
        this.fJS = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.fJZ.cancelLoadData();
        this.fJQ.bcB();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.fJS.bbC()) {
            this.fJR.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJR.hide();
                    a.this.fJP = false;
                    if (a.this.fJQ != null) {
                        if (a.this.fJQ.bbR() != null) {
                            a.this.fJQ.bbR().kR(false);
                            f bfb = a.this.fJQ.bbR().bfb();
                            bfb.a(a.this.fJQ.bbA().getPbData(), true);
                            bfb.notifyDataSetChanged();
                        }
                        a.this.fJQ.c(a.this.fKb);
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
        boolean bbE = this.fJR.bbE();
        this.fJR.show();
        if (!bbE) {
            this.fJR.bbF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbu();
                }
            });
            this.fJR.bbG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbu();
                }
            });
            this.fJR.bbI().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fJZ.El()) {
                        a.this.fJZ.bbz();
                    }
                }
            });
            this.fJR.getListView().setOnScrollListener(this.onScrollListener);
        }
    }

    public void bbv() {
        if (!isActive()) {
            this.fJQ.bcB();
            this.fJP = true;
            this.fJS.setFullscreen(false);
            this.fJS.jX(true);
            ce();
            bbx();
            this.fJR.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJS.jX(false);
                }
            });
            this.fJQ.b(this.fKb);
            this.fJZ.bbz();
        }
        this.fJQ.bbR().bfE();
    }

    public void bbw() {
        if (isActive()) {
            bbx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbx() {
        List<com.baidu.adp.widget.ListView.i> bbB = this.fJZ.bbB();
        if (bbB != null) {
            com.baidu.tieba.pb.data.d pbData = this.fJZ.bbA().getPbData();
            this.fJR.show();
            this.fJR.getListView().setOnSrollToBottomListener(this.ckh);
            BdTypeListView listView = this.fJR.getListView();
            this.fJS.Em();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bbB));
            this.fJR.avk().setCenterTextTitle(String.format(this.fJQ.getResources().getString(d.j.more_god_reply_count), am.H(pbData.baF().fIv.size())));
            this.fJR.jY(this.fJZ.aiq());
            if (listView.getAdapter() instanceof e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fJU == null) {
            this.fJU = new i(this.fJQ, PostData.haZ);
            this.fJU.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fJU);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fJU.b(dVar);
        f bfb = this.fJT.bfb();
        this.fJU.setFromCDN(bfb.isFromCDN());
        this.fJU.setHostId(dVar.bau().zn().getUserId());
        this.fJU.jU(bfb.bcS());
        this.fJU.l(this.fJV);
        this.fJU.E(this.fJW);
        this.fJU.setOnImageClickListener(this.fJX);
        this.fJU.setOnLongClickListener(this.onLongClickListener);
        this.fJU.setTbGestureDetector(this.fJY);
    }

    public void onChangeSkinType(int i) {
        this.fJR.onChangeSkinType(i);
    }

    public void l(View.OnClickListener onClickListener) {
        this.fJV = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fJW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fJX = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fJY = cVar;
    }

    public boolean isActive() {
        return this.fJP;
    }

    public d bby() {
        return this.fJR;
    }
}
