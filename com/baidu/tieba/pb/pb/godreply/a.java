package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.m.a {
    private boolean isActive;
    final PbFragment jpl;
    private d jpm;
    private c jpn;
    private an jpo;
    private j jpp;
    private View.OnClickListener jpq;
    private View.OnClickListener jpr;
    private TbRichTextView.i jps;
    private com.baidu.tieba.pb.a.c jpt;
    private final MoreGodReplyModel jpu;
    private long jpv;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e fhr = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.jpu.isLoading()) {
                a.this.jpu.cwC();
            }
        }
    };
    private AbsListView.OnScrollListener jpw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int jpA = -1;

        private boolean zn(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!zn(this.jpA) && zn(i) && a.this.jpl != null && a.this.jpl.cxv() != null) {
                a.this.jpl.cxv().cAm();
                a.this.jpl.cxv().cBk();
            }
            this.jpA = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private x.a jpx = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.jpo.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void aS(List<PostData> list) {
            a.this.cwA();
        }
    };
    private PbFragment.a jpy = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.cwx();
            return true;
        }
    };

    public a(PbFragment pbFragment, an anVar, ViewStub viewStub) {
        this.jpu = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.cwD());
        this.jpu.a(this.jpx);
        this.jpo = anVar;
        this.jpl = pbFragment;
        this.jpm = new d(pbFragment, viewStub);
        this.jpn = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(final Runnable runnable) {
        this.jpu.cancelLoadData();
        this.jpl.cyf();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.jpn.cwF()) {
            this.jpm.x(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jpm.hide();
                    a.this.isActive = false;
                    if (a.this.jpl != null) {
                        if (a.this.jpl.cxv() != null) {
                            a.this.jpl.cxv().rB(false);
                            f cAD = a.this.jpl.cxv().cAD();
                            cAD.a(a.this.jpl.cwD().getPbData(), true);
                            cAD.notifyDataSetChanged();
                        }
                        a.this.jpl.c(a.this.jpy);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.jpv != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.jpv;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.aZm().a(this.jpl.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void cwx() {
        v(null);
    }

    private void showView() {
        boolean cwI = this.jpm.cwI();
        this.jpm.show();
        if (!cwI) {
            this.jpm.cwJ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cwx();
                }
            });
            this.jpm.cwK().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cwx();
                }
            });
            this.jpm.cwM().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.jpu.isLoading()) {
                        a.this.jpu.cwC();
                    }
                }
            });
            this.jpm.getListView().setOnScrollListener(this.jpw);
        }
        this.jpv = System.currentTimeMillis();
    }

    public void cwy() {
        if (!isActive()) {
            this.jpl.cyf();
            this.isActive = true;
            this.jpn.setFullscreen(false);
            this.jpn.qJ(true);
            showView();
            cwA();
            this.jpm.y(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jpn.qJ(false);
                }
            });
            this.jpl.b(this.jpy);
            this.jpu.cwC();
        }
        this.jpl.cxv().cBk();
    }

    public void cwz() {
        if (isActive()) {
            cwA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwA() {
        List<m> cwE = this.jpu.cwE();
        if (cwE != null) {
            com.baidu.tieba.pb.data.e pbData = this.jpu.cwD().getPbData();
            this.jpm.show();
            this.jpm.getListView().setOnSrollToBottomListener(this.fhr);
            BdTypeListView listView = this.jpm.getListView();
            this.jpn.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(cwE));
            this.jpm.boh().setCenterTextTitle(String.format(this.jpl.getResources().getString(R.string.more_god_reply_count), aq.numFormatOver10000(pbData.cvF().joM.size())));
            this.jpm.qK(this.jpu.aki());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.jpp == null) {
            this.jpp = new j(this.jpl, PostData.kSo);
            this.jpp.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.jpp);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(com.baidu.tieba.pb.data.e eVar) {
        this.jpp.setData(eVar);
        f cAD = this.jpo.cAD();
        this.jpp.setFromCDN(cAD.isFromCDN());
        this.jpp.eA(eVar.cvu().aKE().getUserId());
        this.jpp.qG(cAD.cxf());
        this.jpp.z(this.jpq);
        this.jpp.Q(this.jpr);
        this.jpp.setOnImageClickListener(this.jps);
        this.jpp.setOnLongClickListener(this.onLongClickListener);
        this.jpp.setTbGestureDetector(this.jpt);
    }

    public void onChangeSkinType(int i) {
        this.jpm.onChangeSkinType(i);
    }

    public void z(View.OnClickListener onClickListener) {
        this.jpq = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jpr = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jps = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.jpt = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d cwB() {
        return this.jpm;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.jpl == null) {
            return null;
        }
        return this.jpl.getNextPageSourceKeyList();
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
            PbModel cwD = this.jpl.cwD();
            if (cwD != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(cwD.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(cwD.cyA(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
