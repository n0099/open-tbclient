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
    final PbActivity fJA;
    private d fJB;
    private c fJC;
    private ar fJD;
    private i fJE;
    private View.OnClickListener fJF;
    private View.OnClickListener fJG;
    private TbRichTextView.h fJH;
    private com.baidu.tieba.pb.a.c fJI;
    private final MoreGodReplyModel fJJ;
    private boolean fJz;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e cke = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fJJ.Ek()) {
                a.this.fJJ.bby();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fJN = -1;

        private boolean sG(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!sG(this.fJN) && sG(i) && a.this.fJA != null && a.this.fJA.bbQ() != null) {
                a.this.fJA.bbQ().beK();
                a.this.fJA.bbQ().bfD();
            }
            this.fJN = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private y.a fJK = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fJD.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void L(List<PostData> list) {
            a.this.bbw();
        }
    };
    private PbActivity.a fJL = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bbt();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fJJ = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bbz());
        this.fJJ.a(this.fJK);
        this.fJD = arVar;
        this.fJA = pbActivity;
        this.fJB = new d(pbActivity, viewStub);
        this.fJC = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.fJJ.cancelLoadData();
        this.fJA.bcA();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.fJC.bbB()) {
            this.fJB.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJB.hide();
                    a.this.fJz = false;
                    if (a.this.fJA != null) {
                        if (a.this.fJA.bbQ() != null) {
                            a.this.fJA.bbQ().kM(false);
                            f bfa = a.this.fJA.bbQ().bfa();
                            bfa.a(a.this.fJA.bbz().getPbData(), true);
                            bfa.notifyDataSetChanged();
                        }
                        a.this.fJA.c(a.this.fJL);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void bbt() {
        j(null);
    }

    private void ce() {
        boolean bbD = this.fJB.bbD();
        this.fJB.show();
        if (!bbD) {
            this.fJB.bbE().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbt();
                }
            });
            this.fJB.bbF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bbt();
                }
            });
            this.fJB.bbH().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fJJ.Ek()) {
                        a.this.fJJ.bby();
                    }
                }
            });
            this.fJB.getListView().setOnScrollListener(this.onScrollListener);
        }
    }

    public void bbu() {
        if (!isActive()) {
            this.fJA.bcA();
            this.fJz = true;
            this.fJC.setFullscreen(false);
            this.fJC.jS(true);
            ce();
            bbw();
            this.fJB.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJC.jS(false);
                }
            });
            this.fJA.b(this.fJL);
            this.fJJ.bby();
        }
        this.fJA.bbQ().bfD();
    }

    public void bbv() {
        if (isActive()) {
            bbw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbw() {
        List<com.baidu.adp.widget.ListView.i> bbA = this.fJJ.bbA();
        if (bbA != null) {
            com.baidu.tieba.pb.data.d pbData = this.fJJ.bbz().getPbData();
            this.fJB.show();
            this.fJB.getListView().setOnSrollToBottomListener(this.cke);
            BdTypeListView listView = this.fJB.getListView();
            this.fJC.El();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bbA));
            this.fJB.avj().setCenterTextTitle(String.format(this.fJA.getResources().getString(d.j.more_god_reply_count), am.H(pbData.baE().fIf.size())));
            this.fJB.jT(this.fJJ.aip());
            if (listView.getAdapter() instanceof e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fJE == null) {
            this.fJE = new i(this.fJA, PostData.haB);
            this.fJE.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fJE);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fJE.b(dVar);
        f bfa = this.fJD.bfa();
        this.fJE.setFromCDN(bfa.isFromCDN());
        this.fJE.setHostId(dVar.bat().zn().getUserId());
        this.fJE.jP(bfa.bcR());
        this.fJE.l(this.fJF);
        this.fJE.E(this.fJG);
        this.fJE.setOnImageClickListener(this.fJH);
        this.fJE.setOnLongClickListener(this.onLongClickListener);
        this.fJE.setTbGestureDetector(this.fJI);
    }

    public void onChangeSkinType(int i) {
        this.fJB.onChangeSkinType(i);
    }

    public void l(View.OnClickListener onClickListener) {
        this.fJF = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fJG = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fJH = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fJI = cVar;
    }

    public boolean isActive() {
        return this.fJz;
    }

    public d bbx() {
        return this.fJB;
    }
}
