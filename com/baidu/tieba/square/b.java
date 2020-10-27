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
/* loaded from: classes22.dex */
public class b {
    private View cnT;
    private g gmB;
    public ForumHeaderView iet;
    private Context mActivity;
    private RelativeLayout mJE;
    private TextView mJF;
    private View mJG;
    private com.baidu.tieba.square.view.b mJH;
    private RelativeLayout mJI;
    private View.OnClickListener mJJ;
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
        this.cnT = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.skinChangeListener);
    }

    public View getRootLayout() {
        return this.cnT;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cnT.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.mJG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mJF = (TextView) this.mJG.findViewById(R.id.right_textview);
        this.mJF.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.mJE = (RelativeLayout) this.cnT.findViewById(R.id.forum_header_serch_container);
        this.iet = (ForumHeaderView) this.cnT.findViewById(R.id.forum_header_serch_view);
        this.iet.setFrom(1);
        this.iet.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.mJH = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.cnT);
        this.mJI = (RelativeLayout) this.cnT.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dFt() {
        this.mNavigationBar.setVisibility(8);
        this.iet.setVisibility(8);
        this.mJE.setVisibility(8);
        ((LinearLayout.LayoutParams) this.mJI.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void wZ(boolean z) {
        this.mJG.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dFv() {
        return this.mJH != null ? this.mJH.dFv() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mJH != null) {
            this.mJH.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0831a interfaceC0831a) {
        if (this.mJH != null) {
            this.mJH.a(interfaceC0831a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.mJH != null) {
            this.mJH.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mJH != null) {
            this.mJH.b(onScrollListener);
        }
    }

    public String dFw() {
        return this.mJH.dFw();
    }

    public void Sd(String str) {
        if (this.mJH != null) {
            this.mJH.Sd(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.mJH != null) {
            this.mJH.c(str, list, z);
        }
    }

    public void fx(List<q> list) {
        if (this.mJH != null) {
            this.mJH.fx(list);
        }
    }

    public void v(List<q> list, int i) {
        if (this.mJH != null) {
            this.mJH.v(list, i);
        }
    }

    public void dFx() {
        if (this.mJH != null) {
            this.mJH.dFx();
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.mJF != null) {
            this.mJF.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iet != null) {
            this.iet.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.mJH != null) {
            this.mJH.onChangeSkinType(i);
        }
        if (this.gmB != null) {
            this.gmB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.mJF, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.cnT, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mJE, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.iet != null) {
            this.iet.setSearchHint(str);
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        this.mJJ = onClickListener;
    }

    public void oP(boolean z) {
        if (!cki()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.mJJ);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.mJI, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cki() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mJI);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.mJI);
            this.gmB = null;
        }
    }

    public boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(this.mActivity);
                this.gmB.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gmB.onChangeSkinType();
            this.gmB.attachView(this.mJI, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dFy() {
        hideLoadingView();
        hideNoDataView();
        oP(true);
        if (this.mJH != null) {
            this.mJH.GR(8);
        }
    }

    public void dFz() {
        TK();
        hideNoDataView();
        hA(true);
    }

    public void dFA() {
        hideLoadingView();
        TK();
        hideNoDataView();
        if (this.mJH != null) {
            this.mJH.hideLoadingView();
            this.mJH.GR(0);
        }
    }

    public void dFB() {
        hideLoadingView();
        TK();
        hideNoDataView();
        if (this.mJH != null) {
            this.mJH.hA(true);
            this.mJH.Jf(8);
        }
    }

    public void dFC() {
        if (this.mJH != null) {
            this.mJH.dFC();
        }
    }

    public void dFD() {
        if (this.mJH != null) {
            this.mJH.dFD();
        }
    }

    public void dFE() {
        if (this.mJH != null) {
            this.mJH.dFE();
        }
    }

    public void bNw() {
        if (this.mJH != null) {
            this.mJH.bNw();
        }
    }

    public boolean xa(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dFE();
            } else {
                dFC();
            }
            return true;
        }
        dFD();
        return false;
    }
}
