package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean fRA;
    final PbActivity fRB;
    private d fRC;
    private c fRD;
    private ar fRE;
    private i fRF;
    private View.OnClickListener fRG;
    private View.OnClickListener fRH;
    private TbRichTextView.h fRI;
    private com.baidu.tieba.pb.a.c fRJ;
    private final MoreGodReplyModel fRK;
    private long fRL;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bVt = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fRK.Fi()) {
                a.this.fRK.bhn();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fRP = -1;

        private boolean sb(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!sb(this.fRP) && sb(i) && a.this.fRB != null && a.this.fRB.bhF() != null) {
                a.this.fRB.bhF().bkB();
                a.this.fRB.bhF().blv();
            }
            this.fRP = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fRM = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fRE.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void P(List<PostData> list) {
            a.this.bhl();
        }
    };
    private PbActivity.a fRN = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.bhi();
            return true;
        }
    };

    public a(PbActivity pbActivity, ar arVar, ViewStub viewStub) {
        this.fRK = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bho());
        this.fRK.a(this.fRM);
        this.fRE = arVar;
        this.fRB = pbActivity;
        this.fRC = new d(pbActivity, viewStub);
        this.fRD = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        this.fRK.cancelLoadData();
        this.fRB.bir();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fRD.bhq()) {
            this.fRC.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fRC.hide();
                    a.this.fRA = false;
                    if (a.this.fRB != null) {
                        if (a.this.fRB.bhF() != null) {
                            a.this.fRB.bhF().ls(false);
                            f bkS = a.this.fRB.bhF().bkS();
                            bkS.a(a.this.fRB.bho().getPbData(), true);
                            bkS.notifyDataSetChanged();
                        }
                        a.this.fRB.c(a.this.fRN);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fRL != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fRL;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.ap(currentTimeMillis);
            e.OR().a(this.fRB, pageStayDurationItem, getPageStayFilter());
        }
    }

    void bhi() {
        i(null);
    }

    private void showView() {
        boolean bhs = this.fRC.bhs();
        this.fRC.show();
        if (!bhs) {
            this.fRC.bht().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bhi();
                }
            });
            this.fRC.bhu().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bhi();
                }
            });
            this.fRC.bhw().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fRK.Fi()) {
                        a.this.fRK.bhn();
                    }
                }
            });
            this.fRC.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fRL = System.currentTimeMillis();
    }

    public void bhj() {
        if (!isActive()) {
            this.fRB.bir();
            this.fRA = true;
            this.fRD.setFullscreen(false);
            this.fRD.kC(true);
            showView();
            bhl();
            this.fRC.l(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fRD.kC(false);
                }
            });
            this.fRB.b(this.fRN);
            this.fRK.bhn();
        }
        this.fRB.bhF().blv();
    }

    public void bhk() {
        if (isActive()) {
            bhl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        List<h> bhp = this.fRK.bhp();
        if (bhp != null) {
            com.baidu.tieba.pb.data.d pbData = this.fRK.bho().getPbData();
            this.fRC.show();
            this.fRC.getListView().setOnSrollToBottomListener(this.bVt);
            BdTypeListView listView = this.fRC.getListView();
            this.fRD.initialize();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bhp));
            this.fRC.abU().setCenterTextTitle(String.format(this.fRB.getResources().getString(e.j.more_god_reply_count), ao.U(pbData.bgv().fQV.size())));
            this.fRC.kD(this.fRK.hasMoreData());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fRF == null) {
            this.fRF = new i(this.fRB, PostData.hln);
            this.fRF.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fRF);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fRF.b(dVar);
        f bkS = this.fRE.bkS();
        this.fRF.setFromCDN(bkS.isFromCDN());
        this.fRF.setHostId(dVar.bgk().zG().getUserId());
        this.fRF.kz(bkS.biM());
        this.fRF.s(this.fRG);
        this.fRF.I(this.fRH);
        this.fRF.setOnImageClickListener(this.fRI);
        this.fRF.setOnLongClickListener(this.onLongClickListener);
        this.fRF.setTbGestureDetector(this.fRJ);
    }

    public void onChangeSkinType(int i) {
        this.fRC.onChangeSkinType(i);
    }

    public void s(View.OnClickListener onClickListener) {
        this.fRG = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fRH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fRI = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fRJ = cVar;
    }

    public boolean isActive() {
        return this.fRA;
    }

    public d bhm() {
        return this.fRC;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.fRB == null) {
            return null;
        }
        return this.fRB.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.I(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().OM()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.pageStayDuration.d();
            this.pageStayDurationItem.U(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.iq(getCurrentPageKey());
            PbModel bho = this.fRB.bho();
            if (bho != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(bho.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(bho.bje(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
