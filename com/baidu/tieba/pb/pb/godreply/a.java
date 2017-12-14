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
    private boolean eRM;
    final PbActivity eRN;
    private d eRO;
    private c eRP;
    private ar eRQ;
    private k eRR;
    private View.OnClickListener eRS;
    private View.OnClickListener eRT;
    private TbRichTextView.g eRU;
    private com.baidu.tieba.pb.a.c eRV;
    private final MoreGodReplyModel eRW;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e bsL = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.eRW.wA()) {
                a.this.eRW.aSw();
            }
        }
    };
    private AbsListView.OnScrollListener bqZ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int eSa = -1;

        private boolean pP(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!pP(this.eSa) && pP(i) && a.this.eRN != null && a.this.eRN.aSR() != null) {
                a.this.eRN.aSR().aVO();
                a.this.eRN.aSR().aWE();
            }
            this.eSa = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a eRX = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.eRQ.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void C(List<PostData> list) {
            a.this.aSu();
        }
    };
    private PbActivity.a eRY = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aSr();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.eRW = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aSx());
        this.eRW.a(this.eRX);
        this.eRQ = arVar;
        this.eRN = pbActivity;
        this.eRO = new d(pbActivity, viewStub);
        this.eRP = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.eRW.cancelLoadData();
        this.eRN.aTE();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.eRP.aSz()) {
            this.eRO.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eRO.hide();
                    a.this.eRM = false;
                    if (a.this.eRN != null) {
                        if (a.this.eRN.aSR() != null) {
                            a.this.eRN.aSR().jW(false);
                            h aWe = a.this.eRN.aSR().aWe();
                            aWe.a(a.this.eRN.aSx().getPbData(), true);
                            aWe.notifyDataSetChanged();
                        }
                        a.this.eRN.b(a.this.eRY);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    void aSr() {
        j(null);
    }

    private void Yl() {
        boolean aSC = this.eRO.aSC();
        this.eRO.show();
        if (!aSC) {
            this.eRO.aSD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aSr();
                }
            });
            this.eRO.aSE().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aSr();
                }
            });
            this.eRO.aSG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.eRW.wA()) {
                        a.this.eRW.aSw();
                    }
                }
            });
            this.eRO.getListView().setOnScrollListener(this.bqZ);
        }
    }

    public void aSs() {
        if (!isActive()) {
            this.eRN.aTE();
            this.eRM = true;
            this.eRP.setFullscreen(false);
            this.eRP.jb(true);
            Yl();
            aSu();
            this.eRO.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eRP.jb(false);
                }
            });
            this.eRN.a(this.eRY);
            this.eRW.aSw();
        }
        this.eRN.aSR().aWE();
    }

    public void aSt() {
        if (isActive()) {
            aSu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        List<f> aSy = this.eRW.aSy();
        if (aSy != null) {
            com.baidu.tieba.pb.data.f pbData = this.eRW.aSx().getPbData();
            this.eRO.show();
            this.eRO.getListView().setOnSrollToBottomListener(this.bsL);
            BdTypeListView listView = this.eRO.getListView();
            this.eRP.wB();
            e(listView);
            c(pbData);
            listView.setData(new ArrayList(aSy));
            this.eRO.alE().setCenterTextTitle(String.format(this.eRN.getResources().getString(d.j.more_god_reply_count), am.y(pbData.aRA().eQs.size())));
            this.eRO.jc(this.eRW.ZR());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) listView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private void e(BdTypeListView bdTypeListView) {
        if (this.eRR == null) {
            this.eRR = new k(this.eRN, PostData.gBO);
            this.eRR.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.eRR);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar) {
        this.eRR.b(fVar);
        h aWe = this.eRQ.aWe();
        this.eRR.setFromCDN(aWe.isFromCDN());
        this.eRR.setHostId(fVar.aRq().rv().getUserId());
        this.eRR.iY(aWe.aTW());
        this.eRR.setCommonClickListener(this.eRS);
        this.eRR.D(this.eRT);
        this.eRR.setOnImageClickListener(this.eRU);
        this.eRR.setOnLongClickListener(this.onLongClickListener);
        this.eRR.setTbGestureDetector(this.eRV);
    }

    public void onChangeSkinType(int i) {
        this.eRO.onChangeSkinType(i);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eRS = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eRT = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.eRU = gVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eRV = cVar;
    }

    public boolean isActive() {
        return this.eRM;
    }

    public d aSv() {
        return this.eRO;
    }
}
