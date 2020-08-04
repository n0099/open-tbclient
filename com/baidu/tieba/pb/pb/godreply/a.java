package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    private View.OnClickListener kjA;
    private TbRichTextView.i kjB;
    private com.baidu.tieba.pb.a.c kjC;
    private final MoreGodReplyModel kjD;
    private long kjE;
    final PbFragment kju;
    private d kjv;
    private c kjw;
    private az kjx;
    private m kjy;
    private View.OnClickListener kjz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.kjD.isLoading()) {
                a.this.kjD.cLO();
            }
        }
    };
    private AbsListView.OnScrollListener kjF = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int kjJ = -1;

        private boolean BA(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!BA(this.kjJ) && BA(i) && a.this.kju != null && a.this.kju.cMF() != null) {
                a.this.kju.cMF().cPA();
                a.this.kju.cMF().cQy();
            }
            this.kjJ = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a kjG = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.kjx.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bd(List<PostData> list) {
            a.this.cLM();
        }
    };
    private PbFragment.a kjH = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cLJ();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.kjD = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cLP());
        this.kjD.a(this.kjG);
        this.kjx = azVar;
        this.kju = pbFragment;
        this.kjv = new d(pbFragment, viewStub);
        this.kjw = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(final Runnable runnable) {
        this.kjD.cancelLoadData();
        this.kju.cNo();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.kjw.cLR()) {
            this.kjv.y(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kjv.hide();
                    a.this.isActive = false;
                    if (a.this.kju != null) {
                        if (a.this.kju.cMF() != null) {
                            a.this.kju.cMF().sT(false);
                            g cPR = a.this.kju.cMF().cPR();
                            cPR.a(a.this.kju.cLP().getPbData(), true);
                            cPR.notifyDataSetChanged();
                        }
                        a.this.kju.c(a.this.kjH);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.kjE != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.kjE;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.blm().a(this.kju.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cLJ() {
        w(null);
    }

    private void showView() {
        boolean cLU = this.kjv.cLU();
        this.kjv.show();
        if (!cLU) {
            this.kjv.cLV().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cLJ();
                }
            });
            this.kjv.cLW().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cLJ();
                }
            });
            this.kjv.cLY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.kjD.isLoading()) {
                        a.this.kjD.cLO();
                    }
                }
            });
            this.kjv.getListView().setOnScrollListener(this.kjF);
        }
        this.kjE = System.currentTimeMillis();
    }

    public void cLK() {
        if (!isActive()) {
            this.kju.cNo();
            this.isActive = true;
            this.kjw.setFullscreen(false);
            this.kjw.rZ(true);
            showView();
            cLM();
            this.kjv.z(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kjw.rZ(false);
                }
            });
            this.kju.b(this.kjH);
            this.kjD.cLO();
        }
        this.kju.cMF().cQy();
    }

    public void cLL() {
        if (isActive()) {
            cLM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLM() {
        List<q> cLQ = this.kjD.cLQ();
        if (cLQ != null) {
            f pbData = this.kjD.cLP().getPbData();
            this.kjv.show();
            this.kjv.getListView().setOnSrollToBottomListener(this.fLV);
            BdTypeListView listView = this.kjv.getListView();
            this.kjw.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cLQ));
            this.kjv.bAm().setCenterTextTitle(String.format(this.kju.getResources().getString(R.string.more_god_reply_count), as.numFormatOver10000(pbData.cKL().kiX.size())));
            this.kjv.sa(this.kjD.aqL());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.kjy == null) {
            this.kjy = new m(this.kju, PostData.lNd);
            this.kjy.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.kjy);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.kjy.setData(fVar);
        g cPR = this.kjx.cPR();
        this.kjy.setFromCDN(cPR.isFromCDN());
        this.kjy.fq(fVar.cKx().aWl().getUserId());
        this.kjy.rW(cPR.cMp());
        this.kjy.z(this.kjz);
        this.kjy.R(this.kjA);
        this.kjy.setOnImageClickListener(this.kjB);
        this.kjy.setOnLongClickListener(this.onLongClickListener);
        this.kjy.setTbGestureDetector(this.kjC);
    }

    public void onChangeSkinType(int i) {
        this.kjv.onChangeSkinType(i);
    }

    public void z(View.OnClickListener onClickListener) {
        this.kjz = onClickListener;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kjA = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kjB = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.kjC = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cLN() {
        return this.kjv;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.kju == null) {
            return null;
        }
        return this.kju.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (x.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.m.d();
            this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
            PbModel cLP = this.kju.cLP();
            if (cLP != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cLP.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cLP.cNL(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
