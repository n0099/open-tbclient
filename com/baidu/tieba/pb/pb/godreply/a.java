package com.baidu.tieba.pb.pb.godreply;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.pageStayDuration.a {
    private boolean ftY;
    final PbActivity ftZ;
    private d fua;
    private c fub;
    private at fuc;
    private i fud;
    private View.OnClickListener fue;
    private View.OnClickListener fuf;
    private TbRichTextView.h fug;
    private com.baidu.tieba.pb.a.c fuh;
    private final MoreGodReplyModel fui;
    private long fuj;
    private View.OnLongClickListener onLongClickListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdListView.e bCy = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.godreply.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!a.this.fui.AE()) {
                a.this.fui.bas();
            }
        }
    };
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.2
        private int fun = -1;

        private boolean qq(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!qq(this.fun) && qq(i) && a.this.ftZ != null && a.this.ftZ.baK() != null) {
                a.this.ftZ.baK().bdH();
                a.this.ftZ.baK().bez();
            }
            this.fun = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private z.a fuk = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.3
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                a.this.fuc.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void G(List<PostData> list) {
            a.this.baq();
        }
    };
    private PbActivity.a ful = new PbActivity.a() { // from class: com.baidu.tieba.pb.pb.godreply.a.8
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            a.this.ban();
            return true;
        }
    };

    public a(PbActivity pbActivity, at atVar, ViewStub viewStub) {
        this.fui = new MoreGodReplyModel(pbActivity.getPageContext(), pbActivity.bat());
        this.fui.a(this.fuk);
        this.fuc = atVar;
        this.ftZ = pbActivity;
        this.fua = new d(pbActivity, viewStub);
        this.fub = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Runnable runnable) {
        this.fui.cancelLoadData();
        this.ftZ.bbv();
        if (!isActive() && runnable != null) {
            runnable.run();
            return;
        }
        if (isActive() && !this.fub.bav()) {
            this.fua.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fua.hide();
                    a.this.ftY = false;
                    if (a.this.ftZ != null) {
                        if (a.this.ftZ.baK() != null) {
                            a.this.ftZ.baK().kq(false);
                            f bdX = a.this.ftZ.baK().bdX();
                            bdX.a(a.this.ftZ.bat().getPbData(), true);
                            bdX.notifyDataSetChanged();
                        }
                        a.this.ftZ.c(a.this.ful);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
        if (this.fuj != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.fuj;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.aa(currentTimeMillis);
            e.Km().a(this.ftZ, pageStayDurationItem, getPageStayFilter());
        }
    }

    void ban() {
        h(null);
    }

    private void showView() {
        boolean bax = this.fua.bax();
        this.fua.show();
        if (!bax) {
            this.fua.bay().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ban();
                }
            });
            this.fua.baz().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ban();
                }
            });
            this.fua.baB().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.godreply.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!a.this.fui.AE()) {
                        a.this.fui.bas();
                    }
                }
            });
            this.fua.getListView().setOnScrollListener(this.onScrollListener);
        }
        this.fuj = System.currentTimeMillis();
    }

    public void bao() {
        if (!isActive()) {
            this.ftZ.bbv();
            this.ftY = true;
            this.fub.setFullscreen(false);
            this.fub.jw(true);
            showView();
            baq();
            this.fua.k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fub.jw(false);
                }
            });
            this.ftZ.b(this.ful);
            this.fui.bas();
        }
        this.ftZ.baK().bez();
    }

    public void bap() {
        if (isActive()) {
            baq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baq() {
        List<h> bau = this.fui.bau();
        if (bau != null) {
            com.baidu.tieba.pb.data.d pbData = this.fui.bat().getPbData();
            this.fua.show();
            this.fua.getListView().setOnSrollToBottomListener(this.bCy);
            BdTypeListView listView = this.fua.getListView();
            this.fub.AF();
            a(listView);
            c(pbData);
            listView.setData(new ArrayList(bau));
            this.fua.Vf().setCenterTextTitle(String.format(this.ftZ.getResources().getString(d.j.more_god_reply_count), ap.F(pbData.aZy().ftC.size())));
            this.fua.jx(this.fui.agT());
            if (listView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        if (this.fud == null) {
            this.fud = new i(this.ftZ, PostData.gNU);
            this.fud.setDuiEnabled(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.fud);
            bdTypeListView.addAdapters(arrayList);
        }
    }

    private void c(com.baidu.tieba.pb.data.d dVar) {
        this.fud.b(dVar);
        f bdX = this.fuc.bdX();
        this.fud.setFromCDN(bdX.isFromCDN());
        this.fud.setHostId(dVar.aZn().vk().getUserId());
        this.fud.jt(bdX.bbP());
        this.fud.q(this.fue);
        this.fud.G(this.fuf);
        this.fud.setOnImageClickListener(this.fug);
        this.fud.setOnLongClickListener(this.onLongClickListener);
        this.fud.setTbGestureDetector(this.fuh);
    }

    public void onChangeSkinType(int i) {
        this.fua.onChangeSkinType(i);
    }

    public void q(View.OnClickListener onClickListener) {
        this.fue = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fuf = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fug = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fuh = cVar;
    }

    public boolean isActive() {
        return this.ftY;
    }

    public d bar() {
        return this.fua;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (this.ftZ == null) {
            return null;
        }
        return this.ftZ.getNextPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (w.z(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Kh()) && !StringUtils.isNull(currentPageKey)) {
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
            this.pageStayDurationItem.L(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.hn(getCurrentPageKey());
            PbModel bat = this.ftZ.bat();
            if (bat != null) {
                this.pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(bat.getForumId(), 0L));
                this.pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(bat.bci(), 0L));
            }
        }
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
