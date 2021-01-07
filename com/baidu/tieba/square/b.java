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
import com.baidu.tbadk.core.util.ao;
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
    private View cDU;
    private CustomMessageListener eYa = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.square.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                b.this.changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };
    private g gLj;
    public ForumHeaderView iIn;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout nkg;
    private TextView nkh;
    private View nki;
    private com.baidu.tieba.square.view.b nkj;
    private RelativeLayout nkk;
    private View.OnClickListener nkl;

    public b(Context context, TbPageContext tbPageContext) {
        this.mActivity = context;
        this.mTbPageContext = tbPageContext;
        this.cDU = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.eYa);
    }

    public View getRootLayout() {
        return this.cDU;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cDU.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.nki = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.nkh = (TextView) this.nki.findViewById(R.id.right_textview);
        this.nkh.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.nkg = (RelativeLayout) this.cDU.findViewById(R.id.forum_header_serch_container);
        this.iIn = (ForumHeaderView) this.cDU.findViewById(R.id.forum_header_serch_view);
        this.iIn.setFrom(1);
        this.iIn.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.nkj = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.cDU);
        this.nkk = (RelativeLayout) this.cDU.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dMW() {
        this.mNavigationBar.setVisibility(8);
        this.iIn.setVisibility(8);
        this.nkg.setVisibility(8);
        ((LinearLayout.LayoutParams) this.nkk.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void xS(boolean z) {
        this.nki.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dMY() {
        return this.nkj != null ? this.nkj.dMY() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nkj != null) {
            this.nkj.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nkj != null) {
            this.nkj.a(aVar);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.nkj != null) {
            this.nkj.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nkj != null) {
            this.nkj.b(onScrollListener);
        }
    }

    public String dMZ() {
        return this.nkj.dMZ();
    }

    public void SR(String str) {
        if (this.nkj != null) {
            this.nkj.SR(str);
        }
    }

    public void d(String str, List<String> list, boolean z) {
        if (this.nkj != null) {
            this.nkj.d(str, list, z);
        }
    }

    public void fS(List<n> list) {
        if (this.nkj != null) {
            this.nkj.fS(list);
        }
    }

    public void v(List<n> list, int i) {
        if (this.nkj != null) {
            this.nkj.v(list, i);
        }
    }

    public void dNa() {
        if (this.nkj != null) {
            this.nkj.dNa();
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.nkh != null) {
            this.nkh.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iIn != null) {
            this.iIn.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.nkj != null) {
            this.nkj.onChangeSkinType(i);
        }
        if (this.gLj != null) {
            this.gLj.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ao.setViewTextColor(this.nkh, R.color.CAM_X0105, 1);
        ao.setBackgroundColor(this.cDU, R.color.CAM_X0205);
        ao.setBackgroundColor(this.nkg, R.color.CAM_X0207);
        ao.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.iIn != null) {
            this.iIn.setSearchHint(str);
        }
    }

    public void al(View.OnClickListener onClickListener) {
        this.nkl = onClickListener;
    }

    public void pU(boolean z) {
        if (!ctu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.nkl);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.nkk, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean ctu() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.nkk);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.nkk);
            this.gLj = null;
        }
    }

    public boolean ctt() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void it(boolean z) {
        if (!ctt()) {
            if (this.gLj == null) {
                this.gLj = new g(this.mActivity);
                this.gLj.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gLj.onChangeSkinType();
            this.gLj.attachView(this.nkk, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dNb() {
        hideLoadingView();
        hideNoDataView();
        pU(true);
        if (this.nkj != null) {
            this.nkj.In(8);
        }
    }

    public void dNc() {
        Zj();
        hideNoDataView();
        it(true);
    }

    public void dNd() {
        hideLoadingView();
        Zj();
        hideNoDataView();
        if (this.nkj != null) {
            this.nkj.hideLoadingView();
            this.nkj.In(0);
        }
    }

    public void dNe() {
        hideLoadingView();
        Zj();
        hideNoDataView();
        if (this.nkj != null) {
            this.nkj.it(true);
            this.nkj.KF(8);
        }
    }

    public void dNf() {
        if (this.nkj != null) {
            this.nkj.dNf();
        }
    }

    public void dNg() {
        if (this.nkj != null) {
            this.nkj.dNg();
        }
    }

    public void dNh() {
        if (this.nkj != null) {
            this.nkj.dNh();
        }
    }

    public void bVG() {
        if (this.nkj != null) {
            this.nkj.bVG();
        }
    }

    public boolean xT(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dNh();
            } else {
                dNf();
            }
            return true;
        }
        dNg();
        return false;
    }
}
