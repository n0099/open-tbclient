package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements com.baidu.tbadk.m.a {
    private k iBA;
    private View.OnClickListener iBB;
    private View.OnClickListener iBC;
    private TbRichTextView.i iBD;
    private com.baidu.tieba.pb.a.c iBE;
    private final MoreGodReplyModel iBF;
    private long iBG;
    final PbFragment iBw;
    private d iBx;
    private c iBy;
    private aq iBz;
    private boolean isActive;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e eyg = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.iBF.isLoading()) {
                a.this.iBF.ckb();
            }
        }
    };
    private AbsListView.OnScrollListener iBH = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int iBL = -1;

        private boolean yx(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!yx(this.iBL) && yx(i) && a.this.iBw != null && a.this.iBw.ckX() != null) {
                a.this.iBw.ckX().cnR();
                a.this.iBw.ckX().coO();
            }
            this.iBL = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private aa.a iBI = new aa.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.iBz.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void onSuccess(List<PostData> list) {
            a.this.cjZ();
        }
    };
    private PbFragment.a iBJ = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cjW();
            return true;
        }
    };

    public a(PbFragment pbFragment, aq aqVar, ViewStub viewStub) {
        this.iBF = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.ckc());
        this.iBF.a(this.iBI);
        this.iBz = aqVar;
        this.iBw = pbFragment;
        this.iBx = new d(pbFragment, viewStub);
        this.iBy = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.iBF.cancelLoadData();
        this.iBw.clH();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.iBy.cke()) {
            this.iBx.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iBx.hide();
                    a.this.isActive = false;
                    if (a.this.iBw != null) {
                        if (a.this.iBw.ckX() != null) {
                            a.this.iBw.ckX().qo(false);
                            f coi = a.this.iBw.ckX().coi();
                            coi.a(a.this.iBw.ckc().getPbData(), true);
                            coi.notifyDataSetChanged();
                        }
                        a.this.iBw.c(a.this.iBJ);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.iBG != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.iBG;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aOF().a(this.iBw.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cjW() {
        q(null);
    }

    private void showView() {
        boolean ckh = this.iBx.ckh();
        this.iBx.show();
        if (!ckh) {
            this.iBx.cki().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cjW();
                }
            });
            this.iBx.ckj().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cjW();
                }
            });
            this.iBx.ckl().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.iBF.isLoading()) {
                        a.this.iBF.ckb();
                    }
                }
            });
            this.iBx.getListView().setOnScrollListener(this.iBH);
        }
        this.iBG = System.currentTimeMillis();
    }

    public void cjX() {
        if (!isActive()) {
            this.iBw.clH();
            this.isActive = true;
            this.iBy.setFullscreen(false);
            this.iBy.pw(true);
            showView();
            cjZ();
            this.iBx.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iBy.pw(false);
                }
            });
            this.iBw.b(this.iBJ);
            this.iBF.ckb();
        }
        this.iBw.ckX().coO();
    }

    public void cjY() {
        if (isActive()) {
            cjZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjZ() {
        List<m> ckd = this.iBF.ckd();
        if (ckd != null) {
            com.baidu.tieba.pb.data.f pbData = this.iBF.ckc().getPbData();
            this.iBx.show();
            this.iBx.getListView().setOnSrollToBottomListener(this.eyg);
            BdTypeListView listView = this.iBx.getListView();
            this.iBy.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(ckd));
            this.iBx.bcw().setCenterTextTitle(String.format(this.iBw.getResources().getString(R.string.more_god_reply_count), com.baidu.tbadk.core.util.aq.numFormatOver10000(pbData.cjd().iAY.size())));
            this.iBx.px(this.iBF.ZK());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.iBA == null) {
            this.iBA = new k(this.iBw, PostData.kfr);
            this.iBA.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.iBA);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.f fVar) {
        this.iBA.setData(fVar);
        f coi = this.iBz.coi();
        this.iBA.setFromCDN(coi.isFromCDN());
        this.iBA.dx(fVar.ciS().azX().getUserId());
        this.iBA.pt(coi.ckG());
        this.iBA.x(this.iBB);
        this.iBA.O(this.iBC);
        this.iBA.setOnImageClickListener(this.iBD);
        this.iBA.setOnLongClickListener(this.onLongClickListener);
        this.iBA.setTbGestureDetector(this.iBE);
    }

    public void onChangeSkinType(int i) {
        this.iBx.onChangeSkinType(i);
    }

    public void x(View.OnClickListener onClickListener) {
        this.iBB = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.iBC = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iBD = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.iBE = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cka() {
        return this.iBx;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.iBw == null) {
            return null;
        }
        return this.iBw.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.isEmpty(arrayList2)) {
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
            PbModel ckc = this.iBw.ckc();
            if (ckc != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(ckc.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(ckc.cmc(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
