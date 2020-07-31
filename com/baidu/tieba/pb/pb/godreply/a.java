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
    private com.baidu.tieba.pb.a.c kjA;
    private final MoreGodReplyModel kjB;
    private long kjC;
    final PbFragment kjs;
    private d kjt;
    private c kju;
    private az kjv;
    private m kjw;
    private View.OnClickListener kjx;
    private View.OnClickListener kjy;
    private TbRichTextView.i kjz;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.kjB.isLoading()) {
                a.this.kjB.cLO();
            }
        }
    };
    private AbsListView.OnScrollListener kjD = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int kjH = -1;

        private boolean BA(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!BA(this.kjH) && BA(i) && a.this.kjs != null && a.this.kjs.cMF() != null) {
                a.this.kjs.cMF().cPA();
                a.this.kjs.cMF().cQy();
            }
            this.kjH = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ai.a kjE = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.kjv.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bd(List<PostData> list) {
            a.this.cLM();
        }
    };
    private PbFragment.a kjF = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cLJ();
            return true;
        }
    };

    public a(PbFragment pbFragment, az azVar, ViewStub viewStub) {
        this.kjB = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cLP());
        this.kjB.a(this.kjE);
        this.kjv = azVar;
        this.kjs = pbFragment;
        this.kjt = new d(pbFragment, viewStub);
        this.kju = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(final Runnable runnable) {
        this.kjB.cancelLoadData();
        this.kjs.cNo();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.kju.cLR()) {
            this.kjt.y(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kjt.hide();
                    a.this.isActive = false;
                    if (a.this.kjs != null) {
                        if (a.this.kjs.cMF() != null) {
                            a.this.kjs.cMF().sT(false);
                            g cPR = a.this.kjs.cMF().cPR();
                            cPR.a(a.this.kjs.cLP().getPbData(), true);
                            cPR.notifyDataSetChanged();
                        }
                        a.this.kjs.c(a.this.kjF);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.kjC != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.kjC;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.blm().a(this.kjs.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cLJ() {
        w(null);
    }

    private void showView() {
        boolean cLU = this.kjt.cLU();
        this.kjt.show();
        if (!cLU) {
            this.kjt.cLV().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cLJ();
                }
            });
            this.kjt.cLW().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cLJ();
                }
            });
            this.kjt.cLY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.kjB.isLoading()) {
                        a.this.kjB.cLO();
                    }
                }
            });
            this.kjt.getListView().setOnScrollListener(this.kjD);
        }
        this.kjC = System.currentTimeMillis();
    }

    public void cLK() {
        if (!isActive()) {
            this.kjs.cNo();
            this.isActive = true;
            this.kju.setFullscreen(false);
            this.kju.rZ(true);
            showView();
            cLM();
            this.kjt.z(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kju.rZ(false);
                }
            });
            this.kjs.b(this.kjF);
            this.kjB.cLO();
        }
        this.kjs.cMF().cQy();
    }

    public void cLL() {
        if (isActive()) {
            cLM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLM() {
        List<q> cLQ = this.kjB.cLQ();
        if (cLQ != null) {
            f pbData = this.kjB.cLP().getPbData();
            this.kjt.show();
            this.kjt.getListView().setOnSrollToBottomListener(this.fLV);
            BdTypeListView listView = this.kjt.getListView();
            this.kju.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cLQ));
            this.kjt.bAm().setCenterTextTitle(String.format(this.kjs.getResources().getString(R.string.more_god_reply_count), as.numFormatOver10000(pbData.cKL().kiV.size())));
            this.kjt.sa(this.kjB.aqL());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.kjw == null) {
            this.kjw = new m(this.kjs, PostData.lNb);
            this.kjw.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.kjw);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.kjw.setData(fVar);
        g cPR = this.kjv.cPR();
        this.kjw.setFromCDN(cPR.isFromCDN());
        this.kjw.fq(fVar.cKx().aWl().getUserId());
        this.kjw.rW(cPR.cMp());
        this.kjw.z(this.kjx);
        this.kjw.R(this.kjy);
        this.kjw.setOnImageClickListener(this.kjz);
        this.kjw.setOnLongClickListener(this.onLongClickListener);
        this.kjw.setTbGestureDetector(this.kjA);
    }

    public void onChangeSkinType(int i) {
        this.kjt.onChangeSkinType(i);
    }

    public void z(View.OnClickListener onClickListener) {
        this.kjx = onClickListener;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kjy = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kjz = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.kjA = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cLN() {
        return this.kjt;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.kjs == null) {
            return null;
        }
        return this.kjs.getNextPageSourceKeyList();
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
            PbModel cLP = this.kjs.cLP();
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
