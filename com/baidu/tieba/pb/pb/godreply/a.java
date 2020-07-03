package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment kaO;
    private d kaP;
    private c kaQ;
    private av kaR;
    private k kaS;
    private View.OnClickListener kaT;
    private View.OnClickListener kaU;
    private TbRichTextView.i kaV;
    private com.baidu.tieba.pb.a.c kaW;
    private final MoreGodReplyModel kaX;
    private long kaY;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fGA = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.kaX.isLoading()) {
                a.this.kaX.cId();
            }
        }
    };
    private AbsListView.OnScrollListener kaZ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int kbd = -1;

        private boolean Bb(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!Bb(this.kbd) && Bb(i) && a.this.kaO != null && a.this.kaO.cIU() != null) {
                a.this.kaO.cIU().cLN();
                a.this.kaO.cIU().cML();
            }
            this.kbd = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ae.a kba = new ae.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.kaR.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aX(List<PostData> list) {
            a.this.cIb();
        }
    };
    private PbFragment.a kbb = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cHY();
            return true;
        }
    };

    public a(PbFragment pbFragment, av avVar, ViewStub viewStub) {
        this.kaX = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cIe());
        this.kaX.a(this.kba);
        this.kaR = avVar;
        this.kaO = pbFragment;
        this.kaP = new d(pbFragment, viewStub);
        this.kaQ = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(final Runnable runnable) {
        this.kaX.cancelLoadData();
        this.kaO.cJD();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.kaQ.cIg()) {
            this.kaP.z(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kaP.hide();
                    a.this.isActive = false;
                    if (a.this.kaO != null) {
                        if (a.this.kaO.cIU() != null) {
                            a.this.kaO.cIU().so(false);
                            g cMe = a.this.kaO.cIU().cMe();
                            cMe.a(a.this.kaO.cIe().getPbData(), true);
                            cMe.notifyDataSetChanged();
                        }
                        a.this.kaO.c(a.this.kbb);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.kaY != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.kaY;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bhB().a(this.kaO.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cHY() {
        x(null);
    }

    private void showView() {
        boolean cIj = this.kaP.cIj();
        this.kaP.show();
        if (!cIj) {
            this.kaP.cIk().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cHY();
                }
            });
            this.kaP.cIl().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cHY();
                }
            });
            this.kaP.cIn().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.kaX.isLoading()) {
                        a.this.kaX.cId();
                    }
                }
            });
            this.kaP.getListView().setOnScrollListener(this.kaZ);
        }
        this.kaY = System.currentTimeMillis();
    }

    public void cHZ() {
        if (!isActive()) {
            this.kaO.cJD();
            this.isActive = true;
            this.kaQ.setFullscreen(false);
            this.kaQ.ru(true);
            showView();
            cIb();
            this.kaP.A(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kaQ.ru(false);
                }
            });
            this.kaO.b(this.kbb);
            this.kaX.cId();
        }
        this.kaO.cIU().cML();
    }

    public void cIa() {
        if (isActive()) {
            cIb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIb() {
        List<q> cIf = this.kaX.cIf();
        if (cIf != null) {
            com.baidu.tieba.pb.data.e pbData = this.kaX.cIe().getPbData();
            this.kaP.show();
            this.kaP.getListView().setOnSrollToBottomListener(this.fGA);
            BdTypeListView listView = this.kaP.getListView();
            this.kaQ.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cIf));
            this.kaP.bwV().setCenterTextTitle(String.format(this.kaO.getResources().getString(R.string.more_god_reply_count), ar.numFormatOver10000(pbData.cHb().kap.size())));
            this.kaP.rv(this.kaX.apb());
            if (listView.getAdapter() instanceof f) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.kaS == null) {
            this.kaS = new k(this.kaO, PostData.lFM);
            this.kaS.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.kaS);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.kaS.setData(eVar);
        g cMe = this.kaR.cMe();
        this.kaS.setFromCDN(cMe.isFromCDN());
        this.kaS.fr(eVar.cGN().aSp().getUserId());
        this.kaS.rr(cMe.cIE());
        this.kaS.z(this.kaT);
        this.kaS.R(this.kaU);
        this.kaS.setOnImageClickListener(this.kaV);
        this.kaS.setOnLongClickListener(this.onLongClickListener);
        this.kaS.setTbGestureDetector(this.kaW);
    }

    public void onChangeSkinType(int i) {
        this.kaP.onChangeSkinType(i);
    }

    public void z(View.OnClickListener onClickListener) {
        this.kaT = onClickListener;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kaU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kaV = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.kaW = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cIc() {
        return this.kaP;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.kaO == null) {
            return null;
        }
        return this.kaO.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (w.isEmpty(arrayList2)) {
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
            PbModel cIe = this.kaO.cIe();
            if (cIe != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cIe.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cIe.cJZ(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
