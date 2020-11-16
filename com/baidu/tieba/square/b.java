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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.square.a.a;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private View csf;
    private g grV;
    public ForumHeaderView ile;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private RelativeLayout mQu;
    private TextView mQv;
    private View mQw;
    private com.baidu.tieba.square.view.b mQx;
    private RelativeLayout mQy;
    private View.OnClickListener mQz;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.square.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                b.this.changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    public b(Context context, TbPageContext tbPageContext) {
        this.mActivity = context;
        this.mTbPageContext = tbPageContext;
        this.csf = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.skinChangeListener);
    }

    public View getRootLayout() {
        return this.csf;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.csf.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.mQw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mQv = (TextView) this.mQw.findViewById(R.id.right_textview);
        this.mQv.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.mQu = (RelativeLayout) this.csf.findViewById(R.id.forum_header_serch_container);
        this.ile = (ForumHeaderView) this.csf.findViewById(R.id.forum_header_serch_view);
        this.ile.setFrom(1);
        this.ile.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.mQx = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.csf);
        this.mQy = (RelativeLayout) this.csf.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dHM() {
        this.mNavigationBar.setVisibility(8);
        this.ile.setVisibility(8);
        this.mQu.setVisibility(8);
        ((LinearLayout.LayoutParams) this.mQy.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void xm(boolean z) {
        this.mQw.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dHO() {
        return this.mQx != null ? this.mQx.dHO() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mQx != null) {
            this.mQx.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0849a interfaceC0849a) {
        if (this.mQx != null) {
            this.mQx.a(interfaceC0849a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.mQx != null) {
            this.mQx.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mQx != null) {
            this.mQx.b(onScrollListener);
        }
    }

    public String dHP() {
        return this.mQx.dHP();
    }

    public void RV(String str) {
        if (this.mQx != null) {
            this.mQx.RV(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.mQx != null) {
            this.mQx.c(str, list, z);
        }
    }

    public void fF(List<q> list) {
        if (this.mQx != null) {
            this.mQx.fF(list);
        }
    }

    public void v(List<q> list, int i) {
        if (this.mQx != null) {
            this.mQx.v(list, i);
        }
    }

    public void dHQ() {
        if (this.mQx != null) {
            this.mQx.dHQ();
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        if (this.mQv != null) {
            this.mQv.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.ile != null) {
            this.ile.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.mQx != null) {
            this.mQx.onChangeSkinType(i);
        }
        if (this.grV != null) {
            this.grV.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.mQv, R.color.CAM_X0105, 1);
        ap.setBackgroundColor(this.csf, R.color.CAM_X0205);
        ap.setBackgroundColor(this.mQu, R.color.CAM_X0207);
        ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.ile != null) {
            this.ile.setSearchHint(str);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        this.mQz = onClickListener;
    }

    public void pb(boolean z) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.mQz);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.mQy, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cmm() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mQy);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this.mQy);
            this.grV = null;
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(this.mActivity);
                this.grV.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.grV.onChangeSkinType();
            this.grV.attachView(this.mQy, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dHR() {
        hideLoadingView();
        hideNoDataView();
        pb(true);
        if (this.mQx != null) {
            this.mQx.HC(8);
        }
    }

    public void dHS() {
        VB();
        hideNoDataView();
        hM(true);
    }

    public void dHT() {
        hideLoadingView();
        VB();
        hideNoDataView();
        if (this.mQx != null) {
            this.mQx.hideLoadingView();
            this.mQx.HC(0);
        }
    }

    public void dHU() {
        hideLoadingView();
        VB();
        hideNoDataView();
        if (this.mQx != null) {
            this.mQx.hM(true);
            this.mQx.JU(8);
        }
    }

    public void dHV() {
        if (this.mQx != null) {
            this.mQx.dHV();
        }
    }

    public void dHW() {
        if (this.mQx != null) {
            this.mQx.dHW();
        }
    }

    public void dHX() {
        if (this.mQx != null) {
            this.mQx.dHX();
        }
    }

    public void bPp() {
        if (this.mQx != null) {
            this.mQx.bPp();
        }
    }

    public boolean xn(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dHX();
            } else {
                dHV();
            }
            return true;
        }
        dHW();
        return false;
    }
}
