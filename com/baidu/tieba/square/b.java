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
    private View cfu;
    private g gcx;
    public ForumHeaderView hRS;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout mwU;
    private TextView mwV;
    private View mwW;
    private com.baidu.tieba.square.view.b mwX;
    private RelativeLayout mwY;
    private View.OnClickListener mwZ;
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
        this.cfu = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.skinChangeListener);
    }

    public View getRootLayout() {
        return this.cfu;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cfu.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.mwW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mwV = (TextView) this.mwW.findViewById(R.id.right_textview);
        this.mwV.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.mwU = (RelativeLayout) this.cfu.findViewById(R.id.forum_header_serch_container);
        this.hRS = (ForumHeaderView) this.cfu.findViewById(R.id.forum_header_serch_view);
        this.hRS.setFrom(1);
        this.hRS.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.mwX = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.cfu);
        this.mwY = (RelativeLayout) this.cfu.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dCl() {
        this.mNavigationBar.setVisibility(8);
        this.hRS.setVisibility(8);
        this.mwU.setVisibility(8);
        ((LinearLayout.LayoutParams) this.mwY.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void wI(boolean z) {
        this.mwW.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dCn() {
        return this.mwX != null ? this.mwX.dCn() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mwX != null) {
            this.mwX.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0816a interfaceC0816a) {
        if (this.mwX != null) {
            this.mwX.a(interfaceC0816a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.mwX != null) {
            this.mwX.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mwX != null) {
            this.mwX.b(onScrollListener);
        }
    }

    public String dCo() {
        return this.mwX.dCo();
    }

    public void RE(String str) {
        if (this.mwX != null) {
            this.mwX.RE(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.mwX != null) {
            this.mwX.c(str, list, z);
        }
    }

    public void fo(List<q> list) {
        if (this.mwX != null) {
            this.mwX.fo(list);
        }
    }

    public void u(List<q> list, int i) {
        if (this.mwX != null) {
            this.mwX.u(list, i);
        }
    }

    public void dCp() {
        if (this.mwX != null) {
            this.mwX.dCp();
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.mwV != null) {
            this.mwV.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.hRS != null) {
            this.hRS.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.mwX != null) {
            this.mwX.onChangeSkinType(i);
        }
        if (this.gcx != null) {
            this.gcx.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.mwV, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.cfu, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mwU, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.hRS != null) {
            this.hRS.setSearchHint(str);
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        this.mwZ = onClickListener;
    }

    public void ox(boolean z) {
        if (!chb()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.mwZ);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.mwY, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean chb() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mwY);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.mwY);
            this.gcx = null;
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(this.mActivity);
                this.gcx.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gcx.onChangeSkinType();
            this.gcx.attachView(this.mwY, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dCq() {
        hideLoadingView();
        hideNoDataView();
        ox(true);
        if (this.mwX != null) {
            this.mwX.Gy(8);
        }
    }

    public void dCr() {
        SK();
        hideNoDataView();
        hn(true);
    }

    public void dCs() {
        hideLoadingView();
        SK();
        hideNoDataView();
        if (this.mwX != null) {
            this.mwX.hideLoadingView();
            this.mwX.Gy(0);
        }
    }

    public void dCt() {
        hideLoadingView();
        SK();
        hideNoDataView();
        if (this.mwX != null) {
            this.mwX.hn(true);
            this.mwX.IN(8);
        }
    }

    public void dCu() {
        if (this.mwX != null) {
            this.mwX.dCu();
        }
    }

    public void dCv() {
        if (this.mwX != null) {
            this.mwX.dCv();
        }
    }

    public void dCw() {
        if (this.mwX != null) {
            this.mwX.dCw();
        }
    }

    public void bKU() {
        if (this.mwX != null) {
            this.mwX.bKU();
        }
    }

    public boolean wJ(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dCw();
            } else {
                dCu();
            }
            return true;
        }
        dCv();
        return false;
    }
}
