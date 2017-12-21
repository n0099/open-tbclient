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
    private boolean eRR;
    final PbActivity eRS;
    private d eRT;
    private c eRU;
    private ar eRV;
    private k eRW;
    private View.OnClickListener eRX;
    private View.OnClickListener eRY;
    private TbRichTextView.g eRZ;
    private com.baidu.tieba.pb.a.c eSa;
    private final MoreGodReplyModel eSb;
    private View.OnLongClickListener onLongClickListener;
    private BdListView.e bsP = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.eSb.wA()) {
                a.this.eSb.aSw();
            }
        }
    };
    private AbsListView.OnScrollListener brd = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int eSf = -1;

        private boolean pP(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!pP(this.eSf) && pP(i) && a.this.eRS != null && a.this.eRS.aSR() != null) {
                a.this.eRS.aSR().aVO();
                a.this.eRS.aSR().aWE();
            }
            this.eSf = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a eSc = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.eRV.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void C(List<PostData> list) {
            a.this.aSu();
        }
    };
    private PbActivity.a eSd = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.aSr();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.eSb = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.aSx());
        this.eSb.a(this.eSc);
        this.eRV = arVar;
        this.eRS = pbActivity;
        this.eRT = new d(pbActivity, viewStub);
        this.eRU = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        this.eSb.cancelLoadData();
        this.eRS.aTE();
        if (!isActive() && runnable != null) {
            runnable.run();
        } else if (isActive() && !this.eRU.aSz()) {
            this.eRT.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eRT.hide();
                    a.this.eRR = false;
                    if (a.this.eRS != null) {
                        if (a.this.eRS.aSR() != null) {
                            a.this.eRS.aSR().jW(false);
                            h aWe = a.this.eRS.aSR().aWe();
                            aWe.a(a.this.eRS.aSx().getPbData(), true);
                            aWe.notifyDataSetChanged();
                        }
                        a.this.eRS.b(a.this.eSd);
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
        boolean aSC = this.eRT.aSC();
        this.eRT.show();
        if (!aSC) {
            this.eRT.aSD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aSr();
                }
            });
            this.eRT.aSE().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aSr();
                }
            });
            this.eRT.aSG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.eSb.wA()) {
                        a.this.eSb.aSw();
                    }
                }
            });
            this.eRT.getListView().setOnScrollListener(this.brd);
        }
    }

    public void aSs() {
        if (!isActive()) {
            this.eRS.aTE();
            this.eRR = true;
            this.eRU.setFullscreen(false);
            this.eRU.jb(true);
            Yl();
            aSu();
            this.eRT.m(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eRU.jb(false);
                }
            });
            this.eRS.a(this.eSd);
            this.eSb.aSw();
        }
        this.eRS.aSR().aWE();
    }

    public void aSt() {
        if (isActive()) {
            aSu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        List<f> aSy = this.eSb.aSy();
        if (aSy != null) {
            com.baidu.tieba.pb.data.f pbData = this.eSb.aSx().getPbData();
            this.eRT.show();
            this.eRT.getListView().setOnSrollToBottomListener(this.bsP);
            BdTypeListView listView = this.eRT.getListView();
            this.eRU.wB();
            e(listView);
            c(pbData);
            listView.setData(new ArrayList(aSy));
            this.eRT.alD().setCenterTextTitle(String.format(this.eRS.getResources().getString(d.j.more_god_reply_count), am.y(pbData.aRA().eQx.size())));
            this.eRT.jc(this.eSb.ZR());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) listView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private void e(BdTypeListView bdTypeListView) {
        if (this.eRW == null) {
            this.eRW = new k(this.eRS, PostData.gBT);
            this.eRW.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.eRW);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar) {
        this.eRW.b(fVar);
        h aWe = this.eRV.aWe();
        this.eRW.setFromCDN(aWe.isFromCDN());
        this.eRW.setHostId(fVar.aRq().rv().getUserId());
        this.eRW.iY(aWe.aTW());
        this.eRW.setCommonClickListener(this.eRX);
        this.eRW.D(this.eRY);
        this.eRW.setOnImageClickListener(this.eRZ);
        this.eRW.setOnLongClickListener(this.onLongClickListener);
        this.eRW.setTbGestureDetector(this.eSa);
    }

    public void onChangeSkinType(int i) {
        this.eRT.onChangeSkinType(i);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eRX = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eRY = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.eRZ = gVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eSa = cVar;
    }

    public boolean isActive() {
        return this.eRR;
    }

    public d aSv() {
        return this.eRT;
    }
}
