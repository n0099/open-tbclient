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
    private boolean fGn;
    final PbActivity fGo;
    private d fGp;
    private c fGq;
    private as fGr;
    private k fGs;
    private View.OnClickListener fGt;
    private View.OnClickListener fGu;
    private TbRichTextView.h fGv;
    private com.baidu.tieba.pb.a.c fGw;
    private final MoreGodReplyModel fGx;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e cgx = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fGx.DR()) {
                a.this.fGx.aZS();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fGB = -1;

        private boolean sC(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!sC(this.fGB) && sC(i) && a.this.fGo != null && a.this.fGo.bam() != null) {
                a.this.fGo.bam().bdk();
                a.this.fGo.bam().bec();
            }
            this.fGB = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fGy = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fGr.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void J(List<PostData> list) {
            a.this.aZQ();
        }
    };
    private PbActivity.a fGz = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aZN();
            return true;
        }
    };

    public a(PbActivity pbActivity, as asVar, ViewStub viewStub) {
        this.fGx = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aZT());
        this.fGx.a(this.fGy);
        this.fGr = asVar;
        this.fGo = pbActivity;
        this.fGp = new d(pbActivity, viewStub);
        this.fGq = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.fGx.cancelLoadData();
        this.fGo.baZ();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.fGq.aZV()) {
            this.fGp.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fGp.hide();
                    a.this.fGn = false;
                    if (a.this.fGo != null) {
                        if (a.this.fGo.bam() != null) {
                            a.this.fGo.bam().kD(false);
                            h bdA = a.this.fGo.bam().bdA();
                            bdA.a(a.this.fGo.aZT().getPbData(), true);
                            bdA.notifyDataSetChanged();
                        }
                        a.this.fGo.c(a.this.fGz);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void aZN() {
        j(null);
    }

    private void ce() {
        boolean aZX = this.fGp.aZX();
        this.fGp.show();
        if (!aZX) {
            this.fGp.aZY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aZN();
                }
            });
            this.fGp.aZZ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aZN();
                }
            });
            this.fGp.bab().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fGx.DR()) {
                        a.this.fGx.aZS();
                    }
                }
            });
            this.fGp.getListView().setOnScrollListener(this.onScrollListener);
        }
    }

    public void aZO() {
        if (!isActive()) {
            this.fGo.baZ();
            this.fGn = true;
            this.fGq.setFullscreen(false);
            this.fGq.jJ(true);
            ce();
            aZQ();
            this.fGp.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fGq.jJ(false);
                }
            });
            this.fGo.b(this.fGz);
            this.fGx.aZS();
        }
        this.fGo.bam().bec();
    }

    public void aZP() {
        if (isActive()) {
            aZQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZQ() {
        List<i> aZU = this.fGx.aZU();
        if (aZU != null) {
            f pbData = this.fGx.aZT().getPbData();
            this.fGp.show();
            this.fGp.getListView().setOnSrollToBottomListener(this.cgx);
            BdTypeListView listView = this.fGp.getListView();
            this.fGq.DS();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(aZU));
            this.fGp.auu().setCenterTextTitle(String.format(this.fGo.getResources().getString(d.j.more_god_reply_count), am.H(pbData.aYW().fET.size())));
            this.fGp.jK(this.fGx.aho());
            if (listView.getAdapter() instanceof e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fGs == null) {
            this.fGs = new k(this.fGo, PostData.gYA);
            this.fGs.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fGs);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(f fVar) {
        this.fGs.b(fVar);
        h bdA = this.fGr.bdA();
        this.fGs.setFromCDN(bdA.isFromCDN());
        this.fGs.setHostId(fVar.aYL().yT().getUserId());
        this.fGs.jG(bdA.bbq());
        this.fGs.l(this.fGt);
        this.fGs.E(this.fGu);
        this.fGs.setOnImageClickListener(this.fGv);
        this.fGs.setOnLongClickListener(this.onLongClickListener);
        this.fGs.setTbGestureDetector(this.fGw);
    }

    public void onChangeSkinType(int i) {
        this.fGp.onChangeSkinType(i);
    }

    public void l(View.OnClickListener onClickListener) {
        this.fGt = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fGu = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fGv = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fGw = cVar;
    }

    public boolean isActive() {
        return this.fGn;
    }

    public d aZR() {
        return this.fGp;
    }
}
