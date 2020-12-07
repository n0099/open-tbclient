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
    private g gAe;
    public ForumHeaderView ivY;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private TextView neA;
    private View neB;
    private com.baidu.tieba.square.view.b neC;
    private RelativeLayout neD;
    private View.OnClickListener neE;
    private RelativeLayout nez;

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
        this.neB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.neA = (TextView) this.neB.findViewById(R.id.right_textview);
        this.neA.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.nez = (RelativeLayout) this.czb.findViewById(R.id.forum_header_serch_container);
        this.ivY = (ForumHeaderView) this.czb.findViewById(R.id.forum_header_serch_view);
        this.ivY.setFrom(1);
        this.ivY.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.neC = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.czb);
        this.neD = (RelativeLayout) this.czb.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dNc() {
        this.mNavigationBar.setVisibility(8);
        this.ivY.setVisibility(8);
        this.nez.setVisibility(8);
        ((LinearLayout.LayoutParams) this.neD.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void xQ(boolean z) {
        this.neB.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dNe() {
        return this.neC != null ? this.neC.dNe() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.neC != null) {
            this.neC.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0864a interfaceC0864a) {
        if (this.neC != null) {
            this.neC.a(interfaceC0864a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.neC != null) {
            this.neC.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.neC != null) {
            this.neC.b(onScrollListener);
        }
    }

    public String dNf() {
        return this.neC.dNf();
    }

    public void Tj(String str) {
        if (this.neC != null) {
            this.neC.Tj(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.neC != null) {
            this.neC.c(str, list, z);
        }
    }

    public void fT(List<q> list) {
        if (this.neC != null) {
            this.neC.fT(list);
        }
    }

    public void v(List<q> list, int i) {
        if (this.neC != null) {
            this.neC.v(list, i);
        }
    }

    public void dNg() {
        if (this.neC != null) {
            this.neC.dNg();
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        if (this.neA != null) {
            this.neA.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.ivY != null) {
            this.ivY.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.neC != null) {
            this.neC.onChangeSkinType(i);
        }
        if (this.gAe != null) {
            this.gAe.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.neA, R.color.CAM_X0105, 1);
        ap.setBackgroundColor(this.czb, R.color.CAM_X0205);
        ap.setBackgroundColor(this.nez, R.color.CAM_X0207);
        ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.ivY != null) {
            this.ivY.setSearchHint(str);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        this.neE = onClickListener;
    }

    public void px(boolean z) {
        if (!cqz()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.neE);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.neD, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cqz() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.neD);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.neD);
            this.gAe = null;
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(this.mActivity);
                this.gAe.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gAe.onChangeSkinType();
            this.gAe.attachView(this.neD, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dNh() {
        hideLoadingView();
        hideNoDataView();
        px(true);
        if (this.neC != null) {
            this.neC.It(8);
        }
    }

    public void dNi() {
        Yb();
        hideNoDataView();
        ib(true);
    }

    public void dNj() {
        hideLoadingView();
        Yb();
        hideNoDataView();
        if (this.neC != null) {
            this.neC.hideLoadingView();
            this.neC.It(0);
        }
    }

    public void dNk() {
        hideLoadingView();
        Yb();
        hideNoDataView();
        if (this.neC != null) {
            this.neC.ib(true);
            this.neC.KK(8);
        }
    }

    public void dNl() {
        if (this.neC != null) {
            this.neC.dNl();
        }
    }

    public void dNm() {
        if (this.neC != null) {
            this.neC.dNm();
        }
    }

    public void dNn() {
        if (this.neC != null) {
            this.neC.dNn();
        }
    }

    public void bTa() {
        if (this.neC != null) {
            this.neC.bTa();
        }
    }

    public boolean xR(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dNn();
            } else {
                dNl();
            }
            return true;
        }
        dNm();
        return false;
    }
}
