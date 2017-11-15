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
    private boolean eJl;
    final PbActivity eJm;
    private d eJn;
    private c eJo;
    private ap eJp;
    private k eJq;
    private View.OnClickListener eJr;
    private View.OnClickListener eJs;
    private TbRichTextView.f eJt;
    private com.baidu.tieba.pb.a.c eJu;
    private final MoreGodReplyModel eJv;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e bmh = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.eJv.wz()) {
                a.this.eJv.aQZ();
            }
        }
    };
    private AbsListView.OnScrollListener bko = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int eJz = -1;

        private boolean pv(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!pv(this.eJz) && pv(i) && a.this.eJm != null && a.this.eJm.aRs() != null) {
                a.this.eJm.aRs().aUe();
                a.this.eJm.aRs().aUU();
            }
            this.eJz = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a eJw = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.eJp.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void B(List<PostData> list) {
            a.this.aQX();
        }
    };
    private PbActivity.a eJx = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aQV();
            return true;
        }
    };

    public a(PbActivity pbActivity, ap apVar, ViewStub viewStub) {
        this.eJv = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aRa());
        this.eJv.a(this.eJw);
        this.eJp = apVar;
        this.eJm = pbActivity;
        this.eJn = new d(pbActivity, viewStub);
        this.eJo = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.eJv.cancelLoadData();
        this.eJm.aSe();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.eJo.aRc()) {
            this.eJn.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eJn.hide();
                    a.this.eJl = false;
                    if (a.this.eJm != null) {
                        if (a.this.eJm.aRs() != null) {
                            a.this.eJm.aRs().hi(false);
                            h aUv = a.this.eJm.aRs().aUv();
                            aUv.a(a.this.eJm.aRa().getPbData(), true);
                            aUv.notifyDataSetChanged();
                        }
                        a.this.eJm.b(a.this.eJx);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void aQV() {
        j(null);
    }

    private void Wx() {
        boolean aRf = this.eJn.aRf();
        this.eJn.show();
        if (!aRf) {
            this.eJn.aRg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aQV();
                }
            });
            this.eJn.aRh().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aQV();
                }
            });
            this.eJn.aRj().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.eJv.wz()) {
                        a.this.eJv.aQZ();
                    }
                }
            });
            this.eJn.getListView().setOnScrollListener(this.bko);
        }
    }

    public void aQW() {
        if (!isActive()) {
            this.eJm.aSe();
            this.eJl = true;
            this.eJo.setFullscreen(false);
            this.eJo.iJ(true);
            Wx();
            aQX();
            this.eJn.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eJo.iJ(false);
                }
            });
            this.eJm.a(this.eJx);
            this.eJv.aQZ();
        }
        this.eJm.aRs().aUU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQX() {
        List<f> aRb = this.eJv.aRb();
        if (aRb != null) {
            com.baidu.tieba.pb.data.f pbData = this.eJv.aRa().getPbData();
            this.eJn.show();
            this.eJn.getListView().setOnSrollToBottomListener(this.bmh);
            BdTypeListView listView = this.eJn.getListView();
            this.eJo.wA();
            e(listView);
            c(pbData);
            listView.setData(new ArrayList(aRb));
            this.eJn.ajA().setCenterTextTitle(String.format(this.eJm.getResources().getString(d.j.more_god_reply_count), am.y(pbData.aQg().eHE.size())));
            this.eJn.iK(this.eJv.Yg());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) listView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private void e(BdTypeListView bdTypeListView) {
        if (this.eJq == null) {
            this.eJq = new k(this.eJm, PostData.gqn);
            this.eJq.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.eJq);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar) {
        this.eJq.b(fVar);
        h aUv = this.eJp.aUv();
        this.eJq.setFromCDN(aUv.isFromCDN());
        this.eJq.setHostId(fVar.aPW().rt().getUserId());
        this.eJq.iE(aUv.aSt());
        this.eJq.setCommonClickListener(this.eJr);
        this.eJq.D(this.eJs);
        this.eJq.setOnImageClickListener(this.eJt);
        this.eJq.setOnLongClickListener(this.onLongClickListener);
        this.eJq.setTbGestureDetector(this.eJu);
    }

    public void onChangeSkinType(int i) {
        this.eJn.onChangeSkinType(i);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eJr = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eJs = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.eJt = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eJu = cVar;
    }

    public boolean isActive() {
        return this.eJl;
    }

    public d aQY() {
        return this.eJn;
    }
}
