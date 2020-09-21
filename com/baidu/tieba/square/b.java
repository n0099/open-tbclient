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
    private View bTg;
    private g fQf;
    public ForumHeaderView hCW;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout mhr;
    private TextView mhs;
    private View mht;
    private com.baidu.tieba.square.view.b mhu;
    private RelativeLayout mhv;
    private View.OnClickListener mhw;
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
        this.bTg = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.skinChangeListener);
    }

    public View getRootLayout() {
        return this.bTg;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bTg.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.mht = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mhs = (TextView) this.mht.findViewById(R.id.right_textview);
        this.mhs.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.mhr = (RelativeLayout) this.bTg.findViewById(R.id.forum_header_serch_container);
        this.hCW = (ForumHeaderView) this.bTg.findViewById(R.id.forum_header_serch_view);
        this.hCW.setFrom(1);
        this.hCW.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.mhu = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.bTg);
        this.mhv = (RelativeLayout) this.bTg.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dyA() {
        this.mNavigationBar.setVisibility(8);
        this.hCW.setVisibility(8);
        this.mhr.setVisibility(8);
        ((LinearLayout.LayoutParams) this.mhv.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void wb(boolean z) {
        this.mht.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dyC() {
        return this.mhu != null ? this.mhu.dyC() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mhu != null) {
            this.mhu.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0798a interfaceC0798a) {
        if (this.mhu != null) {
            this.mhu.a(interfaceC0798a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.mhu != null) {
            this.mhu.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mhu != null) {
            this.mhu.b(onScrollListener);
        }
    }

    public String dyD() {
        return this.mhu.dyD();
    }

    public void QQ(String str) {
        if (this.mhu != null) {
            this.mhu.QQ(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.mhu != null) {
            this.mhu.c(str, list, z);
        }
    }

    public void fl(List<q> list) {
        if (this.mhu != null) {
            this.mhu.fl(list);
        }
    }

    public void s(List<q> list, int i) {
        if (this.mhu != null) {
            this.mhu.s(list, i);
        }
    }

    public void dyE() {
        if (this.mhu != null) {
            this.mhu.dyE();
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.mhs != null) {
            this.mhs.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.hCW != null) {
            this.hCW.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.mhu != null) {
            this.mhu.onChangeSkinType(i);
        }
        if (this.fQf != null) {
            this.fQf.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.mhs, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.bTg, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mhr, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.hCW != null) {
            this.hCW.setSearchHint(str);
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        this.mhw = onClickListener;
    }

    public void nS(boolean z) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.mhw);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.mhv, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cdF() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mhv);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.mhv);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(this.mActivity);
                this.fQf.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.fQf.onChangeSkinType();
            this.fQf.attachView(this.mhv, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dyF() {
        hideLoadingView();
        hideNoDataView();
        nS(true);
        if (this.mhu != null) {
            this.mhu.FS(8);
        }
    }

    public void dyG() {
        bHn();
        hideNoDataView();
        gR(true);
    }

    public void dyH() {
        hideLoadingView();
        bHn();
        hideNoDataView();
        if (this.mhu != null) {
            this.mhu.hideLoadingView();
            this.mhu.FS(0);
        }
    }

    public void dyI() {
        hideLoadingView();
        bHn();
        hideNoDataView();
        if (this.mhu != null) {
            this.mhu.gR(true);
            this.mhu.Ih(8);
        }
    }

    public void dyJ() {
        if (this.mhu != null) {
            this.mhu.dyJ();
        }
    }

    public void dyK() {
        if (this.mhu != null) {
            this.mhu.dyK();
        }
    }

    public void dyL() {
        if (this.mhu != null) {
            this.mhu.dyL();
        }
    }

    public void bIk() {
        if (this.mhu != null) {
            this.mhu.bIk();
        }
    }

    public boolean wc(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dyL();
            } else {
                dyJ();
            }
            return true;
        }
        dyK();
        return false;
    }
}
