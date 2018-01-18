package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private boolean fFS;
    final PbActivity fFT;
    private d fFU;
    private c fFV;
    private as fFW;
    private k fFX;
    private View.OnClickListener fFY;
    private View.OnClickListener fFZ;
    private TbRichTextView.h fGa;
    private com.baidu.tieba.pb.a.c fGb;
    private final MoreGodReplyModel fGc;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e cgp = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fGc.DP()) {
                a.this.fGc.aZN();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fGg = -1;

        private boolean sC(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!sC(this.fGg) && sC(i) && a.this.fFT != null && a.this.fFT.bah() != null) {
                a.this.fFT.bah().bdf();
                a.this.fFT.bah().bdX();
            }
            this.fGg = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fGd = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fFW.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void J(List<PostData> list) {
            a.this.aZL();
        }
    };
    private PbActivity.a fGe = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aZI();
            return true;
        }
    };

    public a(PbActivity pbActivity, as asVar, ViewStub viewStub) {
        this.fGc = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aZO());
        this.fGc.a(this.fGd);
        this.fFW = asVar;
        this.fFT = pbActivity;
        this.fFU = new d(pbActivity, viewStub);
        this.fFV = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.fGc.cancelLoadData();
        this.fFT.baU();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.fFV.aZQ()) {
            this.fFU.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fFU.hide();
                    a.this.fFS = false;
                    if (a.this.fFT != null) {
                        if (a.this.fFT.bah() != null) {
                            a.this.fFT.bah().kA(false);
                            h bdv = a.this.fFT.bah().bdv();
                            bdv.a(a.this.fFT.aZO().getPbData(), true);
                            bdv.notifyDataSetChanged();
                        }
                        a.this.fFT.c(a.this.fGe);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void aZI() {
        j(null);
    }

    private void ce() {
        boolean aZS = this.fFU.aZS();
        this.fFU.show();
        if (!aZS) {
            this.fFU.aZT().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aZI();
                }
            });
            this.fFU.aZU().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aZI();
                }
            });
            this.fFU.aZW().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fGc.DP()) {
                        a.this.fGc.aZN();
                    }
                }
            });
            this.fFU.getListView().setOnScrollListener(this.onScrollListener);
        }
    }

    public void aZJ() {
        if (!isActive()) {
            this.fFT.baU();
            this.fFS = true;
            this.fFV.setFullscreen(false);
            this.fFV.jG(true);
            ce();
            aZL();
            this.fFU.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fFV.jG(false);
                }
            });
            this.fFT.b(this.fGe);
            this.fGc.aZN();
        }
        this.fFT.bah().bdX();
    }

    public void aZK() {
        if (isActive()) {
            aZL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZL() {
        List<i> aZP = this.fGc.aZP();
        if (aZP != null) {
            f pbData = this.fGc.aZO().getPbData();
            this.fFU.show();
            this.fFU.getListView().setOnSrollToBottomListener(this.cgp);
            BdTypeListView listView = this.fFU.getListView();
            this.fFV.DQ();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(aZP));
            this.fFU.aup().setCenterTextTitle(String.format(this.fFT.getResources().getString(d.j.more_god_reply_count), am.H(pbData.aYR().fEy.size())));
            this.fFU.jH(this.fGc.ahl());
            if (listView.getAdapter() instanceof e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fFX == null) {
            this.fFX = new k(this.fFT, PostData.gYg);
            this.fFX.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fFX);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(f fVar) {
        this.fFX.b(fVar);
        h bdv = this.fFW.bdv();
        this.fFX.setFromCDN(bdv.isFromCDN());
        this.fFX.setHostId(fVar.aYG().yS().getUserId());
        this.fFX.jD(bdv.bbl());
        this.fFX.l(this.fFY);
        this.fFX.E(this.fFZ);
        this.fFX.setOnImageClickListener(this.fGa);
        this.fFX.setOnLongClickListener(this.onLongClickListener);
        this.fFX.setTbGestureDetector(this.fGb);
    }

    public void onChangeSkinType(int i) {
        this.fFU.onChangeSkinType(i);
    }

    public void l(View.OnClickListener onClickListener) {
        this.fFY = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fGa = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fGb = cVar;
    }

    public boolean isActive() {
        return this.fFS;
    }

    public d aZM() {
        return this.fFU;
    }
}
