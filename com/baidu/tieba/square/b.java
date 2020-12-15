package com.baidu.tieba.square;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.square.a.a;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private View czb;
    private CustomMessageListener eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.square.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                b.this.changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };
    private g gAg;
    public ForumHeaderView iwa;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout neB;
    private TextView neC;
    private View neD;
    private com.baidu.tieba.square.view.b neE;
    private RelativeLayout neF;
    private View.OnClickListener neG;

    public b(Context context, TbPageContext tbPageContext) {
        this.mActivity = context;
        this.mTbPageContext = tbPageContext;
        this.czb = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.eOd);
    }

    public View getRootLayout() {
        return this.czb;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.czb.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.neD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.neC = (TextView) this.neD.findViewById(R.id.right_textview);
        this.neC.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.neB = (RelativeLayout) this.czb.findViewById(R.id.forum_header_serch_container);
        this.iwa = (ForumHeaderView) this.czb.findViewById(R.id.forum_header_serch_view);
        this.iwa.setFrom(1);
        this.iwa.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.neE = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.czb);
        this.neF = (RelativeLayout) this.czb.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dNd() {
        this.mNavigationBar.setVisibility(8);
        this.iwa.setVisibility(8);
        this.neB.setVisibility(8);
        ((LinearLayout.LayoutParams) this.neF.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void xQ(boolean z) {
        this.neD.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dNf() {
        return this.neE != null ? this.neE.dNf() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.neE != null) {
            this.neE.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0864a interfaceC0864a) {
        if (this.neE != null) {
            this.neE.a(interfaceC0864a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.neE != null) {
            this.neE.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.neE != null) {
            this.neE.b(onScrollListener);
        }
    }

    public String dNg() {
        return this.neE.dNg();
    }

    public void Tj(String str) {
        if (this.neE != null) {
            this.neE.Tj(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.neE != null) {
            this.neE.c(str, list, z);
        }
    }

    public void fT(List<q> list) {
        if (this.neE != null) {
            this.neE.fT(list);
        }
    }

    public void v(List<q> list, int i) {
        if (this.neE != null) {
            this.neE.v(list, i);
        }
    }

    public void dNh() {
        if (this.neE != null) {
            this.neE.dNh();
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        if (this.neC != null) {
            this.neC.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iwa != null) {
            this.iwa.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.neE != null) {
            this.neE.onChangeSkinType(i);
        }
        if (this.gAg != null) {
            this.gAg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.neC, R.color.CAM_X0105, 1);
        ap.setBackgroundColor(this.czb, R.color.CAM_X0205);
        ap.setBackgroundColor(this.neB, R.color.CAM_X0207);
        ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.iwa != null) {
            this.iwa.setSearchHint(str);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        this.neG = onClickListener;
    }

    public void px(boolean z) {
        if (!cqA()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.neG);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.neF, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cqA() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.neF);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.neF);
            this.gAg = null;
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(this.mActivity);
                this.gAg.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gAg.onChangeSkinType();
            this.gAg.attachView(this.neF, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dNi() {
        hideLoadingView();
        hideNoDataView();
        px(true);
        if (this.neE != null) {
            this.neE.It(8);
        }
    }

    public void dNj() {
        Yb();
        hideNoDataView();
        ib(true);
    }

    public void dNk() {
        hideLoadingView();
        Yb();
        hideNoDataView();
        if (this.neE != null) {
            this.neE.hideLoadingView();
            this.neE.It(0);
        }
    }

    public void dNl() {
        hideLoadingView();
        Yb();
        hideNoDataView();
        if (this.neE != null) {
            this.neE.ib(true);
            this.neE.KK(8);
        }
    }

    public void dNm() {
        if (this.neE != null) {
            this.neE.dNm();
        }
    }

    public void dNn() {
        if (this.neE != null) {
            this.neE.dNn();
        }
    }

    public void dNo() {
        if (this.neE != null) {
            this.neE.dNo();
        }
    }

    public void bTb() {
        if (this.neE != null) {
            this.neE.bTb();
        }
    }

    public boolean xR(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dNo();
            } else {
                dNm();
            }
            return true;
        }
        dNn();
        return false;
    }
}
