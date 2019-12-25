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
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment ixS;
    private d ixT;
    private c ixU;
    private aq ixV;
    private k ixW;
    private View.OnClickListener ixX;
    private View.OnClickListener ixY;
    private TbRichTextView.i ixZ;
    private com.baidu.tieba.pb.a.c iya;
    private final MoreGodReplyModel iyb;
    private long iyc;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e ewT = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.iyb.isLoading()) {
                a.this.iyb.ciT();
            }
        }
    };
    private AbsListView.OnScrollListener iyd = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int iyh = -1;

        private boolean ys(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!ys(this.iyh) && ys(i) && a.this.ixS != null && a.this.ixS.cjP() != null) {
                a.this.ixS.cjP().cmK();
                a.this.ixS.cjP().cnH();
            }
            this.iyh = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private aa.a iye = new aa.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.ixV.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void onSuccess(List<PostData> list) {
            a.this.ciR();
        }
    };
    private PbFragment.a iyf = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.ciO();
            return true;
        }
    };

    public a(PbFragment pbFragment, aq aqVar, ViewStub viewStub) {
        this.iyb = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.ciU());
        this.iyb.a(this.iye);
        this.ixV = aqVar;
        this.ixS = pbFragment;
        this.ixT = new d(pbFragment, viewStub);
        this.ixU = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        this.iyb.cancelLoadData();
        this.ixS.ckz();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.ixU.ciW()) {
            this.ixT.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ixT.hide();
                    a.this.isActive = false;
                    if (a.this.ixS != null) {
                        if (a.this.ixS.cjP() != null) {
                            a.this.ixS.cjP().qc(false);
                            f cnb = a.this.ixS.cjP().cnb();
                            cnb.a(a.this.ixS.ciU().getPbData(), true);
                            cnb.notifyDataSetChanged();
                        }
                        a.this.ixS.c(a.this.iyf);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.iyc != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.iyc;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aOm().a(this.ixS.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void ciO() {
        q(null);
    }

    private void showView() {
        boolean ciZ = this.ixT.ciZ();
        this.ixT.show();
        if (!ciZ) {
            this.ixT.cja().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ciO();
                }
            });
            this.ixT.cjb().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ciO();
                }
            });
            this.ixT.cjd().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.iyb.isLoading()) {
                        a.this.iyb.ciT();
                    }
                }
            });
            this.ixT.getListView().setOnScrollListener(this.iyd);
        }
        this.iyc = System.currentTimeMillis();
    }

    public void ciP() {
        if (!isActive()) {
            this.ixS.ckz();
            this.isActive = true;
            this.ixU.setFullscreen(false);
            this.ixU.pk(true);
            showView();
            ciR();
            this.ixT.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ixU.pk(false);
                }
            });
            this.ixS.b(this.iyf);
            this.iyb.ciT();
        }
        this.ixS.cjP().cnH();
    }

    public void ciQ() {
        if (isActive()) {
            ciR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciR() {
        List<m> ciV = this.iyb.ciV();
        if (ciV != null) {
            com.baidu.tieba.pb.data.f pbData = this.iyb.ciU().getPbData();
            this.ixT.show();
            this.ixT.getListView().setOnSrollToBottomListener(this.ewT);
            BdTypeListView listView = this.ixT.getListView();
            this.ixU.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(ciV));
            this.ixT.bcb().setCenterTextTitle(String.format(this.ixS.getResources().getString(R.string.more_god_reply_count), com.baidu.tbadk.core.util.aq.numFormatOver10000(pbData.chV().ixu.size())));
            this.ixT.pl(this.iyb.Zn());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.ixW == null) {
            this.ixW = new k(this.ixS, PostData.kbJ);
            this.ixW.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.ixW);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.f fVar) {
        this.ixW.setData(fVar);
        f cnb = this.ixV.cnb();
        this.ixW.setFromCDN(cnb.isFromCDN());
        this.ixW.dv(fVar.chK().azE().getUserId());
        this.ixW.ph(cnb.cjy());
        this.ixW.y(this.ixX);
        this.ixW.P(this.ixY);
        this.ixW.setOnImageClickListener(this.ixZ);
        this.ixW.setOnLongClickListener(this.onLongClickListener);
        this.ixW.setTbGestureDetector(this.iya);
    }

    public void onChangeSkinType(int i) {
        this.ixT.onChangeSkinType(i);
    }

    public void y(View.OnClickListener onClickListener) {
        this.ixX = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.ixY = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ixZ = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.iya = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d ciS() {
        return this.ixT;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.ixS == null) {
            return null;
        }
        return this.ixS.getNextPageSourceKeyList();
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
            PbModel ciU = this.ixS.ciU();
            if (ciU != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(ciU.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(ciU.ckU(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
