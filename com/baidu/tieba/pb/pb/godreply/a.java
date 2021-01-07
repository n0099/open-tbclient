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
    final PbFragment lIg;
    private d lIh;
    private c lIi;
    private ap lIj;
    private k lIk;
    private View.OnClickListener lIl;
    private View.OnClickListener lIm;
    private TbRichTextView.i lIn;
    private com.baidu.tieba.pb.a.c lIo;
    private final MoreGodReplyModel lIp;
    private long lIq;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.lIp.isLoading()) {
                a.this.lIp.dnV();
            }
        }
    };
    private AbsListView.OnScrollListener lIr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int lIv = -1;

        private boolean GL(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!GL(this.lIv) && GL(i) && a.this.lIg != null && a.this.lIg.doP() != null) {
                a.this.lIg.doP().drP();
                a.this.lIg.doP().dsQ();
            }
            this.lIv = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ab.a lIs = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.lIj.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void ai(List<PostData> list) {
            a.this.dnT();
        }
    };
    private PbFragment.a lIt = new PbFragment.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            a.this.dnR();
            return true;
        }
    };

    public a(PbFragment pbFragment, ap apVar, ViewStub viewStub) {
        this.lIp = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.dnW());
        this.lIp.a(this.lIs);
        this.lIj = apVar;
        this.lIg = pbFragment;
        this.lIh = new d(pbFragment, viewStub);
        this.lIi = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(final Runnable runnable) {
        this.lIp.cancelLoadData();
        this.lIg.dpz();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.lIi.dnY()) {
            this.lIh.u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lIh.hide();
                    a.this.isActive = false;
                    if (a.this.lIg != null) {
                        if (a.this.lIg.doP() != null) {
                            a.this.lIg.doP().vz(false);
                            g dsh = a.this.lIg.doP().dsh();
                            dsh.a(a.this.lIg.dnW().getPbData(), true);
                            dsh.notifyDataSetChanged();
                        }
                        a.this.lIg.c(a.this.lIt);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.lIq != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lIq;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            e.bHt().a(this.lIg.getContext(), pageStayDurationItem, getPageStayFilter());
        }
    }

    void dnR() {
        s(null);
    }

    private void showView() {
        boolean dob = this.lIh.dob();
        this.lIh.show();
        if (!dob) {
            this.lIh.doc().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dnR();
                }
            });
            this.lIh.dod().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dnR();
                }
            });
            this.lIh.dof().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.lIp.isLoading()) {
                        a.this.lIp.dnV();
                    }
                }
            });
            this.lIh.getListView().setOnScrollListener(this.lIr);
        }
        this.lIq = System.currentTimeMillis();
    }

    public void dnS() {
        if (!isActive()) {
            this.lIg.dpz();
            this.isActive = true;
            this.lIi.setFullscreen(false);
            this.lIi.uC(true);
            showView();
            dnT();
            this.lIh.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.lIi.uC(false);
                }
            });
            this.lIg.b(this.lIt);
            this.lIp.dnV();
        }
        this.lIg.doP().dsQ();
    }

    public void bSh() {
        if (isActive()) {
            dnT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnT() {
        List<n> dnX = this.lIp.dnX();
        if (dnX != null) {
            f pbData = this.lIp.dnW().getPbData();
            this.lIh.show();
            this.lIh.getListView().setOnSrollToBottomListener(this.gXN);
            BdTypeListView listView = this.lIh.getListView();
            this.lIi.initialize();
            a(listView);
            b(pbData);
            listView.setData(new ArrayList(dnX));
            this.lIh.bYr().setCenterTextTitle(String.format(this.lIg.getResources().getString(R.string.more_god_reply_count), at.numFormatOver10000(pbData.dmT().lHy.size())));
            this.lIh.uD(this.lIp.aKU());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.lIk == null) {
            this.lIk = new k(this.lIg, PostData.nru);
            this.lIk.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.lIk);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void b(f fVar) {
        this.lIk.setData(fVar);
        g dsh = this.lIj.dsh();
        this.lIk.setFromCDN(dsh.isFromCDN());
        this.lIk.hJ(fVar.dmF().brr().getUserId());
        this.lIk.uz(dsh.doy());
        this.lIk.C(this.lIl);
        this.lIk.U(this.lIm);
        this.lIk.setOnImageClickListener(this.lIn);
        this.lIk.setOnLongClickListener(this.onLongClickListener);
        this.lIk.setTbGestureDetector(this.lIo);
    }

    public void onChangeSkinType(int i) {
        this.lIh.onChangeSkinType(i);
    }

    public void C(View.OnClickListener onClickListener) {
        this.lIl = onClickListener;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lIm = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lIn = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.lIo = cVar;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public d dnU() {
        return this.lIh;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_PB_BY_GOD_REPLAY;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.lIg == null) {
            return null;
        }
        return this.lIg.getNextPageSourceKeyList();
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
            PbModel dnW = this.lIg.dnW();
            if (dnW != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(dnW.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(dnW.dpX(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }
}
