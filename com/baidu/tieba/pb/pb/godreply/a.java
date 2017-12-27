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
    private TbRichTextView.h fEA;
    private com.baidu.tieba.pb.a.c fEB;
    private final MoreGodReplyModel fEC;
    private boolean fEs;
    final PbActivity fEt;
    private d fEu;
    private c fEv;
    private as fEw;
    private k fEx;
    private View.OnClickListener fEy;
    private View.OnClickListener fEz;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e cgi = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fEC.DY()) {
                a.this.fEC.aZJ();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fEG = -1;

        private boolean sJ(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!sJ(this.fEG) && sJ(i) && a.this.fEt != null && a.this.fEt.bad() != null) {
                a.this.fEt.bad().bdb();
                a.this.fEt.bad().bdT();
            }
            this.fEG = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fED = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void i(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fEw.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void L(List<PostData> list) {
            a.this.aZH();
        }
    };
    private PbActivity.a fEE = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aZE();
            return true;
        }
    };

    public a(PbActivity pbActivity, as asVar, ViewStub viewStub) {
        this.fEC = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aZK());
        this.fEC.a(this.fED);
        this.fEw = asVar;
        this.fEt = pbActivity;
        this.fEu = new d(pbActivity, viewStub);
        this.fEv = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.fEC.cancelLoadData();
        this.fEt.baQ();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.fEv.aZM()) {
            this.fEu.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fEu.hide();
                    a.this.fEs = false;
                    if (a.this.fEt != null) {
                        if (a.this.fEt.bad() != null) {
                            a.this.fEt.bad().ky(false);
                            h bdr = a.this.fEt.bad().bdr();
                            bdr.a(a.this.fEt.aZK().getPbData(), true);
                            bdr.notifyDataSetChanged();
                        }
                        a.this.fEt.c(a.this.fEE);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void aZE() {
        j(null);
    }

    private void ce() {
        boolean aZO = this.fEu.aZO();
        this.fEu.show();
        if (!aZO) {
            this.fEu.aZP().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aZE();
                }
            });
            this.fEu.aZQ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aZE();
                }
            });
            this.fEu.aZS().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fEC.DY()) {
                        a.this.fEC.aZJ();
                    }
                }
            });
            this.fEu.getListView().setOnScrollListener(this.onScrollListener);
        }
    }

    public void aZF() {
        if (!isActive()) {
            this.fEt.baQ();
            this.fEs = true;
            this.fEv.setFullscreen(false);
            this.fEv.jD(true);
            ce();
            aZH();
            this.fEu.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fEv.jD(false);
                }
            });
            this.fEt.b(this.fEE);
            this.fEC.aZJ();
        }
        this.fEt.bad().bdT();
    }

    public void aZG() {
        if (isActive()) {
            aZH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZH() {
        List<i> aZL = this.fEC.aZL();
        if (aZL != null) {
            f pbData = this.fEC.aZK().getPbData();
            this.fEu.show();
            this.fEu.getListView().setOnSrollToBottomListener(this.cgi);
            BdTypeListView listView = this.fEu.getListView();
            this.fEv.DZ();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(aZL));
            this.fEu.atm().setCenterTextTitle(String.format(this.fEt.getResources().getString(d.j.more_god_reply_count), am.G(pbData.aYM().fCY.size())));
            this.fEu.jE(this.fEC.ahx());
            if (listView.getAdapter() instanceof e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fEx == null) {
            this.fEx = new k(this.fEt, PostData.hiG);
            this.fEx.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fEx);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(f fVar) {
        this.fEx.b(fVar);
        h bdr = this.fEw.bdr();
        this.fEx.setFromCDN(bdr.isFromCDN());
        this.fEx.setHostId(fVar.aYA().yX().getUserId());
        this.fEx.jA(bdr.bbh());
        this.fEx.setCommonClickListener(this.fEy);
        this.fEx.D(this.fEz);
        this.fEx.setOnImageClickListener(this.fEA);
        this.fEx.setOnLongClickListener(this.onLongClickListener);
        this.fEx.setTbGestureDetector(this.fEB);
    }

    public void onChangeSkinType(int i) {
        this.fEu.onChangeSkinType(i);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.fEy = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.fEz = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fEA = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fEB = cVar;
    }

    public boolean isActive() {
        return this.fEs;
    }

    public d aZI() {
        return this.fEu;
    }
}
