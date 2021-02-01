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
    private g gJn;
    public ForumHeaderView iJq;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout npk;
    private TextView npl;
    private View npm;
    private com.baidu.tieba.square.view.b npn;
    private RelativeLayout npo;
    private View.OnClickListener npp;

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
        this.npm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.npl = (TextView) this.npm.findViewById(R.id.right_textview);
        this.npl.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.npk = (RelativeLayout) this.cBE.findViewById(R.id.forum_header_serch_container);
        this.iJq = (ForumHeaderView) this.cBE.findViewById(R.id.forum_header_serch_view);
        this.iJq.setFrom(1);
        this.iJq.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.npn = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.cBE);
        this.npo = (RelativeLayout) this.cBE.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dLp() {
        this.mNavigationBar.setVisibility(8);
        this.iJq.setVisibility(8);
        this.npk.setVisibility(8);
        ((LinearLayout.LayoutParams) this.npo.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void yh(boolean z) {
        this.npm.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dLr() {
        return this.npn != null ? this.npn.dLr() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.npn != null) {
            this.npn.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.npn != null) {
            this.npn.a(aVar);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.npn != null) {
            this.npn.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.npn != null) {
            this.npn.b(onScrollListener);
        }
    }

    public String dLs() {
        return this.npn.dLs();
    }

    public void SH(String str) {
        if (this.npn != null) {
            this.npn.SH(str);
        }
    }

    public void e(String str, List<String> list, boolean z) {
        if (this.npn != null) {
            this.npn.e(str, list, z);
        }
    }

    public void fQ(List<n> list) {
        if (this.npn != null) {
            this.npn.fQ(list);
        }
    }

    public void v(List<n> list, int i) {
        if (this.npn != null) {
            this.npn.v(list, i);
        }
    }

    public void dLt() {
        if (this.npn != null) {
            this.npn.dLt();
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.npl != null) {
            this.npl.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iJq != null) {
            this.iJq.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.npn != null) {
            this.npn.onChangeSkinType(i);
        }
        if (this.gJn != null) {
            this.gJn.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.npl, R.color.CAM_X0105, 1);
        ap.setBackgroundColor(this.cBE, R.color.CAM_X0205);
        ap.setBackgroundColor(this.npk, R.color.CAM_X0207);
        ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.iJq != null) {
            this.iJq.setSearchHint(str);
        }
    }

    public void al(View.OnClickListener onClickListener) {
        this.npp = onClickListener;
    }

    public void qa(boolean z) {
        if (!cqM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.npp);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.npo, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cqM() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.npo);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.npo);
            this.gJn = null;
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(this.mActivity);
                this.gJn.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gJn.onChangeSkinType();
            this.gJn.attachView(this.npo, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dLu() {
        hideLoadingView();
        hideNoDataView();
        qa(true);
        if (this.npn != null) {
            this.npn.GY(8);
        }
    }

    public void dLv() {
        WZ();
        hideNoDataView();
        ir(true);
    }

    public void dLw() {
        hideLoadingView();
        WZ();
        hideNoDataView();
        if (this.npn != null) {
            this.npn.hideLoadingView();
            this.npn.GY(0);
        }
    }

    public void dLx() {
        hideLoadingView();
        WZ();
        hideNoDataView();
        if (this.npn != null) {
            this.npn.ir(true);
            this.npn.Js(8);
        }
    }

    public void dLy() {
        if (this.npn != null) {
            this.npn.dLy();
        }
    }

    public void dLz() {
        if (this.npn != null) {
            this.npn.dLz();
        }
    }

    public void dLA() {
        if (this.npn != null) {
            this.npn.dLA();
        }
    }

    public void bSr() {
        if (this.npn != null) {
            this.npn.bSr();
        }
    }

    public boolean yi(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dLA();
            } else {
                dLy();
            }
            return true;
        }
        dLz();
        return false;
    }
}
