package com.baidu.tieba.square;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tieba.square.adapter.LeftAdapter;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private View cBE;
    private CustomMessageListener eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.square.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                b.this.changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };
    private g gJB;
    public ForumHeaderView iJE;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout npK;
    private TextView npL;
    private View npM;
    private com.baidu.tieba.square.view.b npN;
    private RelativeLayout npO;
    private View.OnClickListener npP;

    public b(Context context, TbPageContext tbPageContext) {
        this.mActivity = context;
        this.mTbPageContext = tbPageContext;
        this.cBE = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.eVF);
    }

    public View getRootLayout() {
        return this.cBE;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cBE.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.npM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.npL = (TextView) this.npM.findViewById(R.id.right_textview);
        this.npL.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.npK = (RelativeLayout) this.cBE.findViewById(R.id.forum_header_serch_container);
        this.iJE = (ForumHeaderView) this.cBE.findViewById(R.id.forum_header_serch_view);
        this.iJE.setFrom(1);
        this.iJE.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.npN = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.cBE);
        this.npO = (RelativeLayout) this.cBE.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dLx() {
        this.mNavigationBar.setVisibility(8);
        this.iJE.setVisibility(8);
        this.npK.setVisibility(8);
        ((LinearLayout.LayoutParams) this.npO.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void yh(boolean z) {
        this.npM.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dLz() {
        return this.npN != null ? this.npN.dLz() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.npN != null) {
            this.npN.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.npN != null) {
            this.npN.a(aVar);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.npN != null) {
            this.npN.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.npN != null) {
            this.npN.b(onScrollListener);
        }
    }

    public String dLA() {
        return this.npN.dLA();
    }

    public void ST(String str) {
        if (this.npN != null) {
            this.npN.ST(str);
        }
    }

    public void e(String str, List<String> list, boolean z) {
        if (this.npN != null) {
            this.npN.e(str, list, z);
        }
    }

    public void fQ(List<n> list) {
        if (this.npN != null) {
            this.npN.fQ(list);
        }
    }

    public void v(List<n> list, int i) {
        if (this.npN != null) {
            this.npN.v(list, i);
        }
    }

    public void dLB() {
        if (this.npN != null) {
            this.npN.dLB();
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.npL != null) {
            this.npL.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iJE != null) {
            this.iJE.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.npN != null) {
            this.npN.onChangeSkinType(i);
        }
        if (this.gJB != null) {
            this.gJB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.npL, R.color.CAM_X0105, 1);
        ap.setBackgroundColor(this.cBE, R.color.CAM_X0205);
        ap.setBackgroundColor(this.npK, R.color.CAM_X0207);
        ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.iJE != null) {
            this.iJE.setSearchHint(str);
        }
    }

    public void al(View.OnClickListener onClickListener) {
        this.npP = onClickListener;
    }

    public void qa(boolean z) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.npP);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.npO, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cqT() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.npO);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.npO);
            this.gJB = null;
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(this.mActivity);
                this.gJB.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gJB.onChangeSkinType();
            this.gJB.attachView(this.npO, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dLC() {
        hideLoadingView();
        hideNoDataView();
        qa(true);
        if (this.npN != null) {
            this.npN.GY(8);
        }
    }

    public void dLD() {
        WZ();
        hideNoDataView();
        ir(true);
    }

    public void dLE() {
        hideLoadingView();
        WZ();
        hideNoDataView();
        if (this.npN != null) {
            this.npN.hideLoadingView();
            this.npN.GY(0);
        }
    }

    public void dLF() {
        hideLoadingView();
        WZ();
        hideNoDataView();
        if (this.npN != null) {
            this.npN.ir(true);
            this.npN.Js(8);
        }
    }

    public void dLG() {
        if (this.npN != null) {
            this.npN.dLG();
        }
    }

    public void dLH() {
        if (this.npN != null) {
            this.npN.dLH();
        }
    }

    public void dLI() {
        if (this.npN != null) {
            this.npN.dLI();
        }
    }

    public void bSy() {
        if (this.npN != null) {
            this.npN.bSy();
        }
    }

    public boolean yi(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dLI();
            } else {
                dLG();
            }
            return true;
        }
        dLH();
        return false;
    }
}
