package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private boolean eIR;
    final PbActivity eIS;
    private d eIT;
    private c eIU;
    private ap eIV;
    private k eIW;
    private View.OnClickListener eIX;
    private View.OnClickListener eIY;
    private TbRichTextView.f eIZ;
    private com.baidu.tieba.pb.a.c eJa;
    private final MoreGodReplyModel eJb;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e blY = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.eJb.wz()) {
                a.this.eJb.aQR();
            }
        }
    };
    private AbsListView.OnScrollListener bkf = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int eJf = -1;

        private boolean pu(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!pu(this.eJf) && pu(i) && a.this.eIS != null && a.this.eIS.aRk() != null) {
                a.this.eIS.aRk().aTW();
                a.this.eIS.aRk().aUM();
            }
            this.eJf = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a eJc = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.eIV.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void B(List<PostData> list) {
            a.this.aQP();
        }
    };
    private PbActivity.a eJd = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aQN();
            return true;
        }
    };

    public a(PbActivity pbActivity, ap apVar, ViewStub viewStub) {
        this.eJb = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aQS());
        this.eJb.a(this.eJc);
        this.eIV = apVar;
        this.eIS = pbActivity;
        this.eIT = new d(pbActivity, viewStub);
        this.eIU = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.eJb.cancelLoadData();
        this.eIS.aRW();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.eIU.aQU()) {
            this.eIT.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eIT.hide();
                    a.this.eIR = false;
                    if (a.this.eIS != null) {
                        if (a.this.eIS.aRk() != null) {
                            a.this.eIS.aRk().hc(false);
                            h aUn = a.this.eIS.aRk().aUn();
                            aUn.a(a.this.eIS.aQS().getPbData(), true);
                            aUn.notifyDataSetChanged();
                        }
                        a.this.eIS.b(a.this.eJd);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void aQN() {
        j(null);
    }

    private void Wm() {
        boolean aQX = this.eIT.aQX();
        this.eIT.show();
        if (!aQX) {
            this.eIT.aQY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aQN();
                }
            });
            this.eIT.aQZ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aQN();
                }
            });
            this.eIT.aRb().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.eJb.wz()) {
                        a.this.eJb.aQR();
                    }
                }
            });
            this.eIT.getListView().setOnScrollListener(this.bkf);
        }
    }

    public void aQO() {
        if (!isActive()) {
            this.eIS.aRW();
            this.eIR = true;
            this.eIU.setFullscreen(false);
            this.eIU.iD(true);
            Wm();
            aQP();
            this.eIT.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eIU.iD(false);
                }
            });
            this.eIS.a(this.eJd);
            this.eJb.aQR();
        }
        this.eIS.aRk().aUM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQP() {
        List<f> aQT = this.eJb.aQT();
        if (aQT != null) {
            com.baidu.tieba.pb.data.f pbData = this.eJb.aQS().getPbData();
            this.eIT.show();
            this.eIT.getListView().setOnSrollToBottomListener(this.blY);
            BdTypeListView listView = this.eIT.getListView();
            this.eIU.wA();
            e(listView);
            c(pbData);
            listView.setData(new ArrayList(aQT));
            this.eIT.ajm().setCenterTextTitle(String.format(this.eIS.getResources().getString(d.j.more_god_reply_count), am.y(pbData.aPY().eHk.size())));
            this.eIT.iE(this.eJb.XU());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) listView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private void e(BdTypeListView bdTypeListView) {
        if (this.eIW == null) {
            this.eIW = new k(this.eIS, PostData.gpk);
            this.eIW.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.eIW);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar) {
        this.eIW.b(fVar);
        h aUn = this.eIV.aUn();
        this.eIW.setFromCDN(aUn.isFromCDN());
        this.eIW.setHostId(fVar.aPO().rt().getUserId());
        this.eIW.iy(aUn.aSl());
        this.eIW.setCommonClickListener(this.eIX);
        this.eIW.D(this.eIY);
        this.eIW.setOnImageClickListener(this.eIZ);
        this.eIW.setOnLongClickListener(this.onLongClickListener);
        this.eIW.setTbGestureDetector(this.eJa);
    }

    public void onChangeSkinType(int i) {
        this.eIT.onChangeSkinType(i);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eIX = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eIY = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.eIZ = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eJa = cVar;
    }

    public boolean isActive() {
        return this.eIR;
    }

    public d aQQ() {
        return this.eIT;
    }
}
