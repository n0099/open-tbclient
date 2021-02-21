package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment lMF;
    private d lMG;
    private c lMH;
    private ap lMI;
    private k lMJ;
    private View.OnClickListener lMK;
    private View.OnClickListener lML;
    private TbRichTextView.i lMM;
    private com.baidu.tieba.pb.a.c lMN;
    private final MoreGodReplyModel lMO;
    private long lMP;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gWf = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lMO.isLoading()) {
                a.this.lMO.dmw();
            }
        }
    };
    private AbsListView.OnScrollListener lMQ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lMU = -1;

        private boolean Fy(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Fy(this.lMU) && Fy(i) && a.this.lMF != null && a.this.lMF.dnr() != null) {
                a.this.lMF.dnr().dqs();
                a.this.lMF.dnr().drt();
            }
            this.lMU = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ab.a lMR = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lMI.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void aj(List<PostData> list) {
            a.this.dmu();
        }
    };
    private PbFragment.a lMS = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dms();
            return true;
        }
    };

    public a(PbFragment pbFragment, ap apVar, ViewStub viewStub) {
        this.lMO = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dmx());
        this.lMO.a(this.lMR);
        this.lMI = apVar;
        this.lMF = pbFragment;
        this.lMG = new d(pbFragment, viewStub);
        this.lMH = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.lMO.cancelLoadData();
        this.lMF.doc();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lMH.dmz()) {
            this.lMG.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lMG.hide();
                    a.this.isActive = false;
                    if (a.this.lMF != null) {
                        if (a.this.lMF.dnr() != null) {
                            a.this.lMF.dnr().vK(false);
                            g dqK = a.this.lMF.dnr().dqK();
                            dqK.a(a.this.lMF.dmx().getPbData(), true);
                            dqK.notifyDataSetChanged();
                        }
                        a.this.lMF.c(a.this.lMS);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lMP != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lMP;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bDS().a(this.lMF.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dms() {
        q(null);
    }

    private void showView() {
        boolean dmC = this.lMG.dmC();
        this.lMG.show();
        if (!dmC) {
            this.lMG.dmD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dms();
                }
            });
            this.lMG.dmE().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dms();
                }
            });
            this.lMG.dmG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lMO.isLoading()) {
                        a.this.lMO.dmw();
                    }
                }
            });
            this.lMG.getListView().setOnScrollListener(this.lMQ);
        }
        this.lMP = System.currentTimeMillis();
    }

    public void dmt() {
        if (!isActive()) {
            this.lMF.doc();
            this.isActive = true;
            this.lMH.setFullscreen(false);
            this.lMH.uM(true);
            showView();
            dmu();
            this.lMG.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lMH.uM(false);
                }
            });
            this.lMF.b(this.lMS);
            this.lMO.dmw();
        }
        this.lMF.dnr().drt();
    }

    public void bPa() {
        if (isActive()) {
            dmu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmu() {
        List<n> dmy = this.lMO.dmy();
        if (dmy != null) {
            f pbData = this.lMO.dmx().getPbData();
            this.lMG.show();
            this.lMG.getListView().setOnSrollToBottomListener(this.gWf);
            BdTypeListView listView = this.lMG.getListView();
            this.lMH.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dmy));
            this.lMG.bVk().setCenterTextTitle(String.format(this.lMF.getResources().getString(R.string.more_god_reply_count), au.numFormatOver10000(pbData.dlu().lLX.size())));
            this.lMG.uN(this.lMO.aHt());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lMJ == null) {
            this.lMJ = new k(this.lMF, PostData.nwY);
            this.lMJ.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lMJ);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lMJ.setData(fVar);
        g dqK = this.lMI.dqK();
        this.lMJ.setFromCDN(dqK.isFromCDN());
        this.lMJ.gW(fVar.dlg().bnQ().getUserId());
        this.lMJ.uJ(dqK.dmZ());
        this.lMJ.C(this.lMK);
        this.lMJ.U(this.lML);
        this.lMJ.setOnImageClickListener(this.lMM);
        this.lMJ.setOnLongClickListener(this.onLongClickListener);
        this.lMJ.setTbGestureDetector(this.lMN);
    }

    public void onChangeSkinType(int i) {
        this.lMG.onChangeSkinType(i);
    }

    public void C(View.OnClickListener onClickListener) {
        this.lMK = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lML = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lMM = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lMN = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d dmv() {
        return this.lMG;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lMF == null) {
            return null;
        }
        return this.lMF.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (y.isEmpty(arrayList2)) {
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
            PbModel dmx = this.lMF.dmx();
            if (dmx != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dmx.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dmx.doA(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
