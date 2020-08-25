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
/* loaded from: classes16.dex */
public class b {
    private View bRc;
    private g fMN;
    public ForumHeaderView hvM;
    private RelativeLayout lXB;
    private TextView lXC;
    private com.baidu.tieba.square.view.b lXD;
    private RelativeLayout lXE;
    private View.OnClickListener lXF;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
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
        this.bRc = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.skinChangeListener);
    }

    public View getRootLayout() {
        return this.bRc;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bRc.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.lXC = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.lXC.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.lXB = (RelativeLayout) this.bRc.findViewById(R.id.forum_header_serch_container);
        this.hvM = (ForumHeaderView) this.bRc.findViewById(R.id.forum_header_serch_view);
        this.hvM.setFrom(1);
        this.hvM.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.lXD = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.bRc);
        this.lXE = (RelativeLayout) this.bRc.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void duC() {
        this.mNavigationBar.setVisibility(8);
        this.hvM.setVisibility(8);
        this.lXB.setVisibility(8);
        ((LinearLayout.LayoutParams) this.lXE.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public Pair<Integer, Integer> duE() {
        return this.lXD != null ? this.lXD.duE() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lXD != null) {
            this.lXD.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0801a interfaceC0801a) {
        if (this.lXD != null) {
            this.lXD.a(interfaceC0801a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.lXD != null) {
            this.lXD.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lXD != null) {
            this.lXD.b(onScrollListener);
        }
    }

    public String duF() {
        return this.lXD.duF();
    }

    public void Qq(String str) {
        if (this.lXD != null) {
            this.lXD.Qq(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.lXD != null) {
            this.lXD.c(str, list, z);
        }
    }

    public void fc(List<q> list) {
        if (this.lXD != null) {
            this.lXD.fc(list);
        }
    }

    public void s(List<q> list, int i) {
        if (this.lXD != null) {
            this.lXD.s(list, i);
        }
    }

    public void duG() {
        if (this.lXD != null) {
            this.lXD.duG();
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.lXC != null) {
            this.lXC.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.hvM != null) {
            this.hvM.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.lXD != null) {
            this.lXD.onChangeSkinType(i);
        }
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.lXC, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.bRc, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.lXB, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.hvM != null) {
            this.hvM.setSearchHint(str);
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        this.lXF = onClickListener;
    }

    public void nK(boolean z) {
        if (!cgw()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.lXF);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.lXE, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cgw() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lXE);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.lXE);
            this.fMN = null;
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(this.mActivity);
                this.fMN.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.fMN.onChangeSkinType();
            this.fMN.attachView(this.lXE, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void duH() {
        hideLoadingView();
        hideNoDataView();
        nK(true);
        if (this.lXD != null) {
            this.lXD.Fr(8);
        }
    }

    public void duI() {
        bFW();
        hideNoDataView();
        gS(true);
    }

    public void duJ() {
        hideLoadingView();
        bFW();
        hideNoDataView();
        if (this.lXD != null) {
            this.lXD.hideLoadingView();
            this.lXD.Fr(0);
        }
    }

    public void duK() {
        hideLoadingView();
        bFW();
        hideNoDataView();
        if (this.lXD != null) {
            this.lXD.gS(true);
            this.lXD.HE(8);
        }
    }

    public void duL() {
        if (this.lXD != null) {
            this.lXD.duL();
        }
    }

    public void duM() {
        if (this.lXD != null) {
            this.lXD.duM();
        }
    }

    public void duN() {
        if (this.lXD != null) {
            this.lXD.duN();
        }
    }

    public void bGT() {
        if (this.lXD != null) {
            this.lXD.bGT();
        }
    }

    public boolean vR(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                duN();
            } else {
                duL();
            }
            return true;
        }
        duM();
        return false;
    }
}
