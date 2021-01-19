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
    private View czi;
    private CustomMessageListener eTp = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.square.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                b.this.changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };
    private g gGD;
    public ForumHeaderView iDG;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout nfB;
    private TextView nfC;
    private View nfD;
    private com.baidu.tieba.square.view.b nfE;
    private RelativeLayout nfF;
    private View.OnClickListener nfG;

    public b(Context context, TbPageContext tbPageContext) {
        this.mActivity = context;
        this.mTbPageContext = tbPageContext;
        this.czi = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.eTp);
    }

    public View getRootLayout() {
        return this.czi;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.czi.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.nfD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.nfC = (TextView) this.nfD.findViewById(R.id.right_textview);
        this.nfC.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.nfB = (RelativeLayout) this.czi.findViewById(R.id.forum_header_serch_container);
        this.iDG = (ForumHeaderView) this.czi.findViewById(R.id.forum_header_serch_view);
        this.iDG.setFrom(1);
        this.iDG.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.nfE = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.czi);
        this.nfF = (RelativeLayout) this.czi.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dJe() {
        this.mNavigationBar.setVisibility(8);
        this.iDG.setVisibility(8);
        this.nfB.setVisibility(8);
        ((LinearLayout.LayoutParams) this.nfF.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void xO(boolean z) {
        this.nfD.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dJg() {
        return this.nfE != null ? this.nfE.dJg() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nfE != null) {
            this.nfE.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nfE != null) {
            this.nfE.a(aVar);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.nfE != null) {
            this.nfE.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nfE != null) {
            this.nfE.b(onScrollListener);
        }
    }

    public String dJh() {
        return this.nfE.dJh();
    }

    public void RK(String str) {
        if (this.nfE != null) {
            this.nfE.RK(str);
        }
    }

    public void d(String str, List<String> list, boolean z) {
        if (this.nfE != null) {
            this.nfE.d(str, list, z);
        }
    }

    public void fS(List<n> list) {
        if (this.nfE != null) {
            this.nfE.fS(list);
        }
    }

    public void v(List<n> list, int i) {
        if (this.nfE != null) {
            this.nfE.v(list, i);
        }
    }

    public void dJi() {
        if (this.nfE != null) {
            this.nfE.dJi();
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.nfC != null) {
            this.nfC.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iDG != null) {
            this.iDG.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.nfE != null) {
            this.nfE.onChangeSkinType(i);
        }
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ao.setViewTextColor(this.nfC, R.color.CAM_X0105, 1);
        ao.setBackgroundColor(this.czi, R.color.CAM_X0205);
        ao.setBackgroundColor(this.nfB, R.color.CAM_X0207);
        ao.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.iDG != null) {
            this.iDG.setSearchHint(str);
        }
    }

    public void al(View.OnClickListener onClickListener) {
        this.nfG = onClickListener;
    }

    public void pQ(boolean z) {
        if (!cpC()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.nfG);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.nfF, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cpC() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.nfF);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.nfF);
            this.gGD = null;
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(this.mActivity);
                this.gGD.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gGD.onChangeSkinType();
            this.gGD.attachView(this.nfF, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dJj() {
        hideLoadingView();
        hideNoDataView();
        pQ(true);
        if (this.nfE != null) {
            this.nfE.GG(8);
        }
    }

    public void dJk() {
        Vq();
        hideNoDataView();
        ip(true);
    }

    public void dJl() {
        hideLoadingView();
        Vq();
        hideNoDataView();
        if (this.nfE != null) {
            this.nfE.hideLoadingView();
            this.nfE.GG(0);
        }
    }

    public void dJm() {
        hideLoadingView();
        Vq();
        hideNoDataView();
        if (this.nfE != null) {
            this.nfE.ip(true);
            this.nfE.IY(8);
        }
    }

    public void dJn() {
        if (this.nfE != null) {
            this.nfE.dJn();
        }
    }

    public void dJo() {
        if (this.nfE != null) {
            this.nfE.dJo();
        }
    }

    public void dJp() {
        if (this.nfE != null) {
            this.nfE.dJp();
        }
    }

    public void bRO() {
        if (this.nfE != null) {
            this.nfE.bRO();
        }
    }

    public boolean xP(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dJp();
            } else {
                dJn();
            }
            return true;
        }
        dJo();
        return false;
    }
}
