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
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private boolean eQJ;
    final PbActivity eQK;
    private d eQL;
    private c eQM;
    private ar eQN;
    private k eQO;
    private View.OnClickListener eQP;
    private View.OnClickListener eQQ;
    private TbRichTextView.f eQR;
    private com.baidu.tieba.pb.a.c eQS;
    private final MoreGodReplyModel eQT;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e bsK = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.eQT.wC()) {
                a.this.eQT.aSn();
            }
        }
    };
    private AbsListView.OnScrollListener bqY = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int eQX = -1;

        private boolean pI(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!pI(this.eQX) && pI(i) && a.this.eQK != null && a.this.eQK.aSI() != null) {
                a.this.eQK.aSI().aVF();
                a.this.eQK.aSI().aWv();
            }
            this.eQX = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a eQU = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.eQN.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void C(List<PostData> list) {
            a.this.aSl();
        }
    };
    private PbActivity.a eQV = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aSi();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.eQT = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aSo());
        this.eQT.a(this.eQU);
        this.eQN = arVar;
        this.eQK = pbActivity;
        this.eQL = new d(pbActivity, viewStub);
        this.eQM = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.eQT.cancelLoadData();
        this.eQK.aTv();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.eQM.aSq()) {
            this.eQL.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eQL.hide();
                    a.this.eQJ = false;
                    if (a.this.eQK != null) {
                        if (a.this.eQK.aSI() != null) {
                            a.this.eQK.aSI().jV(false);
                            h aVV = a.this.eQK.aSI().aVV();
                            aVV.a(a.this.eQK.aSo().getPbData(), true);
                            aVV.notifyDataSetChanged();
                        }
                        a.this.eQK.b(a.this.eQV);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void aSi() {
        j(null);
    }

    private void Yk() {
        boolean aSt = this.eQL.aSt();
        this.eQL.show();
        if (!aSt) {
            this.eQL.aSu().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aSi();
                }
            });
            this.eQL.aSv().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aSi();
                }
            });
            this.eQL.aSx().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.eQT.wC()) {
                        a.this.eQT.aSn();
                    }
                }
            });
            this.eQL.getListView().setOnScrollListener(this.bqY);
        }
    }

    public void aSj() {
        if (!isActive()) {
            this.eQK.aTv();
            this.eQJ = true;
            this.eQM.setFullscreen(false);
            this.eQM.ja(true);
            Yk();
            aSl();
            this.eQL.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eQM.ja(false);
                }
            });
            this.eQK.a(this.eQV);
            this.eQT.aSn();
        }
        this.eQK.aSI().aWv();
    }

    public void aSk() {
        if (isActive()) {
            aSl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSl() {
        List<f> aSp = this.eQT.aSp();
        if (aSp != null) {
            com.baidu.tieba.pb.data.f pbData = this.eQT.aSo().getPbData();
            this.eQL.show();
            this.eQL.getListView().setOnSrollToBottomListener(this.bsK);
            BdTypeListView listView = this.eQL.getListView();
            this.eQM.wD();
            e(listView);
            c(pbData);
            listView.setData(new ArrayList(aSp));
            this.eQL.alu().setCenterTextTitle(String.format(this.eQK.getResources().getString(d.j.more_god_reply_count), am.y(pbData.aRr().ePp.size())));
            this.eQL.jb(this.eQT.ZQ());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) listView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private void e(BdTypeListView bdTypeListView) {
        if (this.eQO == null) {
            this.eQO = new k(this.eQK, PostData.gzf);
            this.eQO.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.eQO);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar) {
        this.eQO.b(fVar);
        h aVV = this.eQN.aVV();
        this.eQO.setFromCDN(aVV.isFromCDN());
        this.eQO.setHostId(fVar.aRh().rx().getUserId());
        this.eQO.iX(aVV.aTN());
        this.eQO.setCommonClickListener(this.eQP);
        this.eQO.D(this.eQQ);
        this.eQO.setOnImageClickListener(this.eQR);
        this.eQO.setOnLongClickListener(this.onLongClickListener);
        this.eQO.setTbGestureDetector(this.eQS);
    }

    public void onChangeSkinType(int i) {
        this.eQL.onChangeSkinType(i);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eQP = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQQ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.eQR = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eQS = cVar;
    }

    public boolean isActive() {
        return this.eQJ;
    }

    public d aSm() {
        return this.eQL;
    }
}
