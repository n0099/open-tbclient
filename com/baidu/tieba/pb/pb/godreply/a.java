package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
    final PbFragment lIh;
    private d lIi;
    private c lIj;
    private ap lIk;
    private k lIl;
    private View.OnClickListener lIm;
    private View.OnClickListener lIn;
    private TbRichTextView.i lIo;
    private com.baidu.tieba.pb.a.c lIp;
    private final MoreGodReplyModel lIq;
    private long lIr;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lIq.isLoading()) {
                a.this.lIq.dnU();
            }
        }
    };
    private AbsListView.OnScrollListener lIs = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lIw = -1;

        private boolean GL(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!GL(this.lIw) && GL(i) && a.this.lIh != null && a.this.lIh.doO() != null) {
                a.this.lIh.doO().drO();
                a.this.lIh.doO().dsP();
            }
            this.lIw = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ab.a lIt = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lIk.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void ai(List<PostData> list) {
            a.this.dnS();
        }
    };
    private PbFragment.a lIu = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dnQ();
            return true;
        }
    };

    public a(PbFragment pbFragment, ap apVar, ViewStub viewStub) {
        this.lIq = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dnV());
        this.lIq.a(this.lIt);
        this.lIk = apVar;
        this.lIh = pbFragment;
        this.lIi = new d(pbFragment, viewStub);
        this.lIj = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(final Runnable runnable) {
        this.lIq.cancelLoadData();
        this.lIh.dpy();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lIj.dnX()) {
            this.lIi.u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lIi.hide();
                    a.this.isActive = false;
                    if (a.this.lIh != null) {
                        if (a.this.lIh.doO() != null) {
                            a.this.lIh.doO().vz(false);
                            g dsg = a.this.lIh.doO().dsg();
                            dsg.a(a.this.lIh.dnV().getPbData(), true);
                            dsg.notifyDataSetChanged();
                        }
                        a.this.lIh.c(a.this.lIu);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lIr != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lIr;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bHs().a(this.lIh.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dnQ() {
        s(null);
    }

    private void showView() {
        boolean doa = this.lIi.doa();
        this.lIi.show();
        if (!doa) {
            this.lIi.dob().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dnQ();
                }
            });
            this.lIi.doc().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dnQ();
                }
            });
            this.lIi.doe().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lIq.isLoading()) {
                        a.this.lIq.dnU();
                    }
                }
            });
            this.lIi.getListView().setOnScrollListener(this.lIs);
        }
        this.lIr = System.currentTimeMillis();
    }

    public void dnR() {
        if (!isActive()) {
            this.lIh.dpy();
            this.isActive = true;
            this.lIj.setFullscreen(false);
            this.lIj.uC(true);
            showView();
            dnS();
            this.lIi.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lIj.uC(false);
                }
            });
            this.lIh.b(this.lIu);
            this.lIq.dnU();
        }
        this.lIh.doO().dsP();
    }

    public void bSg() {
        if (isActive()) {
            dnS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnS() {
        List<n> dnW = this.lIq.dnW();
        if (dnW != null) {
            f pbData = this.lIq.dnV().getPbData();
            this.lIi.show();
            this.lIi.getListView().setOnSrollToBottomListener(this.gXN);
            BdTypeListView listView = this.lIi.getListView();
            this.lIj.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dnW));
            this.lIi.bYq().setCenterTextTitle(String.format(this.lIh.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.dmS().lHz.size())));
            this.lIi.uD(this.lIq.aKT());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lIl == null) {
            this.lIl = new k(this.lIh, PostData.nrv);
            this.lIl.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lIl);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lIl.setData(fVar);
        g dsg = this.lIk.dsg();
        this.lIl.setFromCDN(dsg.isFromCDN());
        this.lIl.hJ(fVar.dmE().brq().getUserId());
        this.lIl.uz(dsg.dox());
        this.lIl.C(this.lIm);
        this.lIl.U(this.lIn);
        this.lIl.setOnImageClickListener(this.lIo);
        this.lIl.setOnLongClickListener(this.onLongClickListener);
        this.lIl.setTbGestureDetector(this.lIp);
    }

    public void onChangeSkinType(int i) {
        this.lIi.onChangeSkinType(i);
    }

    public void C(View.OnClickListener onClickListener) {
        this.lIm = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lIn = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lIo = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lIp = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d dnT() {
        return this.lIi;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lIh == null) {
            return null;
        }
        return this.lIh.getNextPageSourceKeyList();
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
            PbModel dnV = this.lIh.dnV();
            if (dnV != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dnV.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dnV.dpW(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
