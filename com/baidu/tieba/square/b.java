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
    private RelativeLayout nkh;
    private TextView nki;
    private View nkj;
    private com.baidu.tieba.square.view.b nkk;
    private RelativeLayout nkl;
    private View.OnClickListener nkm;

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
        this.nkj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.nki = (TextView) this.nkj.findViewById(R.id.right_textview);
        this.nki.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.nkh = (RelativeLayout) this.cDU.findViewById(R.id.forum_header_serch_container);
        this.iIn = (ForumHeaderView) this.cDU.findViewById(R.id.forum_header_serch_view);
        this.iIn.setFrom(1);
        this.iIn.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.nkk = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.cDU);
        this.nkl = (RelativeLayout) this.cDU.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dMV() {
        this.mNavigationBar.setVisibility(8);
        this.iIn.setVisibility(8);
        this.nkh.setVisibility(8);
        ((LinearLayout.LayoutParams) this.nkl.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void xS(boolean z) {
        this.nkj.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dMX() {
        return this.nkk != null ? this.nkk.dMX() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nkk != null) {
            this.nkk.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nkk != null) {
            this.nkk.a(aVar);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.nkk != null) {
            this.nkk.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nkk != null) {
            this.nkk.b(onScrollListener);
        }
    }

    public String dMY() {
        return this.nkk.dMY();
    }

    public void SS(String str) {
        if (this.nkk != null) {
            this.nkk.SS(str);
        }
    }

    public void d(String str, List<String> list, boolean z) {
        if (this.nkk != null) {
            this.nkk.d(str, list, z);
        }
    }

    public void fS(List<n> list) {
        if (this.nkk != null) {
            this.nkk.fS(list);
        }
    }

    public void v(List<n> list, int i) {
        if (this.nkk != null) {
            this.nkk.v(list, i);
        }
    }

    public void dMZ() {
        if (this.nkk != null) {
            this.nkk.dMZ();
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.nki != null) {
            this.nki.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iIn != null) {
            this.iIn.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.nkk != null) {
            this.nkk.onChangeSkinType(i);
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
        ao.setViewTextColor(this.nki, R.color.CAM_X0105, 1);
        ao.setBackgroundColor(this.cDU, R.color.CAM_X0205);
        ao.setBackgroundColor(this.nkh, R.color.CAM_X0207);
        ao.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.iIn != null) {
            this.iIn.setSearchHint(str);
        }
    }

    public void al(View.OnClickListener onClickListener) {
        this.nkm = onClickListener;
    }

    public void pU(boolean z) {
        if (!ctt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.nkm);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.nkl, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean ctt() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void Zi() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.nkl);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.nkl);
            this.gLj = null;
        }
    }

    public boolean cts() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void it(boolean z) {
        if (!cts()) {
            if (this.gLj == null) {
                this.gLj = new g(this.mActivity);
                this.gLj.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gLj.onChangeSkinType();
            this.gLj.attachView(this.nkl, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dNa() {
        hideLoadingView();
        hideNoDataView();
        pU(true);
        if (this.nkk != null) {
            this.nkk.In(8);
        }
    }

    public void dNb() {
        Zi();
        hideNoDataView();
        it(true);
    }

    public void dNc() {
        hideLoadingView();
        Zi();
        hideNoDataView();
        if (this.nkk != null) {
            this.nkk.hideLoadingView();
            this.nkk.In(0);
        }
    }

    public void dNd() {
        hideLoadingView();
        Zi();
        hideNoDataView();
        if (this.nkk != null) {
            this.nkk.it(true);
            this.nkk.KF(8);
        }
    }

    public void dNe() {
        if (this.nkk != null) {
            this.nkk.dNe();
        }
    }

    public void dNf() {
        if (this.nkk != null) {
            this.nkk.dNf();
        }
    }

    public void dNg() {
        if (this.nkk != null) {
            this.nkk.dNg();
        }
    }

    public void bVF() {
        if (this.nkk != null) {
            this.nkk.bVF();
        }
    }

    public boolean xT(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dNg();
            } else {
                dNe();
            }
            return true;
        }
        dNf();
        return false;
    }
}
