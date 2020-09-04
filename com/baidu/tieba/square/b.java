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
    private View bRg;
    private g fMR;
    public ForumHeaderView hvS;
    private RelativeLayout lXQ;
    private TextView lXR;
    private com.baidu.tieba.square.view.b lXS;
    private RelativeLayout lXT;
    private View.OnClickListener lXU;
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
        this.bRg = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.skinChangeListener);
    }

    public View getRootLayout() {
        return this.bRg;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bRg.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.lXR = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.lXR.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.lXQ = (RelativeLayout) this.bRg.findViewById(R.id.forum_header_serch_container);
        this.hvS = (ForumHeaderView) this.bRg.findViewById(R.id.forum_header_serch_view);
        this.hvS.setFrom(1);
        this.hvS.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.lXS = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.bRg);
        this.lXT = (RelativeLayout) this.bRg.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void duH() {
        this.mNavigationBar.setVisibility(8);
        this.hvS.setVisibility(8);
        this.lXQ.setVisibility(8);
        ((LinearLayout.LayoutParams) this.lXT.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public Pair<Integer, Integer> duJ() {
        return this.lXS != null ? this.lXS.duJ() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lXS != null) {
            this.lXS.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0801a interfaceC0801a) {
        if (this.lXS != null) {
            this.lXS.a(interfaceC0801a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.lXS != null) {
            this.lXS.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lXS != null) {
            this.lXS.b(onScrollListener);
        }
    }

    public String duK() {
        return this.lXS.duK();
    }

    public void Qq(String str) {
        if (this.lXS != null) {
            this.lXS.Qq(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.lXS != null) {
            this.lXS.c(str, list, z);
        }
    }

    public void fc(List<q> list) {
        if (this.lXS != null) {
            this.lXS.fc(list);
        }
    }

    public void s(List<q> list, int i) {
        if (this.lXS != null) {
            this.lXS.s(list, i);
        }
    }

    public void duL() {
        if (this.lXS != null) {
            this.lXS.duL();
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.lXR != null) {
            this.lXR.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.hvS != null) {
            this.hvS.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.lXS != null) {
            this.lXS.onChangeSkinType(i);
        }
        if (this.fMR != null) {
            this.fMR.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.lXR, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.bRg, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.lXQ, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.hvS != null) {
            this.hvS.setSearchHint(str);
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        this.lXU = onClickListener;
    }

    public void nM(boolean z) {
        if (!cgx()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.lXU);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.lXT, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cgx() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lXT);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.lXT);
            this.fMR = null;
        }
    }

    public boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(this.mActivity);
                this.fMR.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.fMR.onChangeSkinType();
            this.fMR.attachView(this.lXT, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void duM() {
        hideLoadingView();
        hideNoDataView();
        nM(true);
        if (this.lXS != null) {
            this.lXS.Fr(8);
        }
    }

    public void duN() {
        bFX();
        hideNoDataView();
        gT(true);
    }

    public void duO() {
        hideLoadingView();
        bFX();
        hideNoDataView();
        if (this.lXS != null) {
            this.lXS.hideLoadingView();
            this.lXS.Fr(0);
        }
    }

    public void duP() {
        hideLoadingView();
        bFX();
        hideNoDataView();
        if (this.lXS != null) {
            this.lXS.gT(true);
            this.lXS.HE(8);
        }
    }

    public void duQ() {
        if (this.lXS != null) {
            this.lXS.duQ();
        }
    }

    public void duR() {
        if (this.lXS != null) {
            this.lXS.duR();
        }
    }

    public void duS() {
        if (this.lXS != null) {
            this.lXS.duS();
        }
    }

    public void bGU() {
        if (this.lXS != null) {
            this.lXS.bGU();
        }
    }

    public boolean vT(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                duS();
            } else {
                duQ();
            }
            return true;
        }
        duR();
        return false;
    }
}
