package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class n extends com.baidu.adp.base.c<ReplyMessageActivity> {
    private View amv;
    private com.baidu.tbadk.mvc.g.a bZW;
    private NoNetworkView bgM;
    private final AbsListView.OnScrollListener cyU;
    private final ReplyMessageActivity dRW;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dRj;
    private NavigationBar dRl;
    private BdListView dSf;
    private ReplyMeModel dSg;
    private com.baidu.tbadk.editortools.pb.f dSh;
    private FeedData dSi;
    private String dSj;
    private long dSk;
    private long dSl;
    private DataModel<g> dSm;
    private final ReplyMeModel.a dSn;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dSf = null;
        this.dSg = null;
        this.dSn = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dSj = str;
                n.this.dSk = j2;
                n.this.dSl = j3;
                if (n.this.dSh != null) {
                    if (!n.this.dSi.getIsFloor() || n.this.dSi.getReplyer() == null) {
                        n.this.dSh.gb(null);
                    } else {
                        n.this.dSh.gb(n.this.dSi.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cyU = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dSh != null) {
                    n.this.dSh.DS();
                }
            }
        };
        this.dRW = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dRj != null) {
                this.dRj.D(fVar.aDh());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Pl() {
        this.mRootView = (RelativeLayout) this.dRW.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.dRW.setContentView(this.mRootView);
        this.dSf = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.dRl = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.dRl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dRl.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.dRl.showBottomLine();
        this.dRj = new com.baidu.tbadk.mvc.f.d<>(this.dRW.getPageContext(), k.class, d.h.mention_replyme_item, this.dRW.FI());
        this.dRj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dRW.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dSf.setAdapter((ListAdapter) this.dRj);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dRW.getPageContext());
        this.mPullView.a(this.dRW);
        this.bZW = new com.baidu.tbadk.mvc.g.a(this.dRW);
        this.bZW.kX();
        this.amv = new TextView(this.dRW.getPageContext().getPageActivity());
        this.amv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dRW.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amv, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dSf.setNextPage(this.bZW);
        this.dSf.setPullRefresh(this.mPullView);
        this.dSf.addHeaderView(this.amv, 0);
        this.bgM = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.bgM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bgM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                n.this.gV(z);
            }
        });
        this.dSg = new ReplyMeModel(this.dRW);
        this.dSg.a(this.dSn);
        this.dSf.setOnScrollListener(this.cyU);
        this.dSf.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dRW.Os();
            }
        });
        this.dSm = new DataModel<g>(com.baidu.adp.base.i.Y(this.dRW.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Dn() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fQ(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dSj);
                writeData.setThreadId(n.this.dSi.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dSi.getIsFloor()) {
                    writeData.setFloor(n.this.dSk > 0 ? String.valueOf(n.this.dSk) : n.this.dSi.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dSi.getPost_id());
                }
                if (n.this.dSl > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dSl));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Do() {
                return null;
            }
        };
        this.dSh = (com.baidu.tbadk.editortools.pb.f) new com.baidu.tbadk.editortools.pb.g().aW(this.dRW.getPageContext().getPageActivity());
        this.dSh.a(this.dRW.getPageContext());
        this.dSh.b(this.dSm);
        this.dSh.e(this.dRW.getPageContext());
        this.dSh.CU().bx(true);
        this.dSh.CU().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dSh.CU() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dSh.CU(), layoutParams);
            this.dSh.CU().hide();
        }
        this.dSh.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Dr() {
                n.this.dRW.showProgressBar();
            }
        });
        this.dSh.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
                n.this.dRW.hideProgressBar();
                n.this.dSh.CU().hide();
                if (postWriteCallBackData != null && rVar == null && !AntiHelper.ua(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dRW.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dRj != null) {
            this.dRj.notifyDataSetChanged();
            this.dRj.b(tbPageContext, i);
        }
        if (this.dSh != null && this.dSh.CU() != null) {
            this.dSh.CU().onChangeSkinType(i);
        }
        this.dRl.onChangeSkinType(tbPageContext, i);
        if (this.bZW != null) {
            this.bZW.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dSh == null || this.dSh.CU() == null || this.dSh.CU().getVisibility() != 0) {
            return false;
        }
        this.dSh.DS();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fa() == 9486) {
            FeedData feedData = (FeedData) bVar.Fb();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dSf) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dSf && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dSf.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dSi = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dSg.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aCZ() {
        if (this.dSf != null) {
            this.dSf.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bZW != null) {
                if (aVar.FC()) {
                    this.bZW.lG();
                    if (aVar.FA()) {
                        this.bZW.fm(d.j.loading);
                    } else if (aVar.FB()) {
                        this.bZW.fm(d.j.loading);
                    } else {
                        this.bZW.fn(d.j.no_more_msg);
                    }
                } else {
                    this.bZW.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aDa();
            } else {
                aCZ();
            }
        }
    }

    public void aDa() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dSf != null) {
            this.dSf.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dRW);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dSh != null) {
            this.dSh.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.amv, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dSf != null && this.dSf.getWrappedAdapter() != null && this.dSf.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dSf.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dSh != null) {
            this.dSh.onDestory();
        }
    }
}
