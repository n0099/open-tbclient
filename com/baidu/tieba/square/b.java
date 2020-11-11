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
    private View ctR;
    private g gso;
    public ForumHeaderView ikq;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private RelativeLayout mPB;
    private TextView mPC;
    private View mPD;
    private com.baidu.tieba.square.view.b mPE;
    private RelativeLayout mPF;
    private View.OnClickListener mPG;
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
        this.ctR = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.skinChangeListener);
    }

    public View getRootLayout() {
        return this.ctR;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.ctR.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.mPD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mPC = (TextView) this.mPD.findViewById(R.id.right_textview);
        this.mPC.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.mPB = (RelativeLayout) this.ctR.findViewById(R.id.forum_header_serch_container);
        this.ikq = (ForumHeaderView) this.ctR.findViewById(R.id.forum_header_serch_view);
        this.ikq.setFrom(1);
        this.ikq.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.mPE = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.ctR);
        this.mPF = (RelativeLayout) this.ctR.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dHV() {
        this.mNavigationBar.setVisibility(8);
        this.ikq.setVisibility(8);
        this.mPB.setVisibility(8);
        ((LinearLayout.LayoutParams) this.mPF.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void xi(boolean z) {
        this.mPD.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dHX() {
        return this.mPE != null ? this.mPE.dHX() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mPE != null) {
            this.mPE.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0846a interfaceC0846a) {
        if (this.mPE != null) {
            this.mPE.a(interfaceC0846a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.mPE != null) {
            this.mPE.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mPE != null) {
            this.mPE.b(onScrollListener);
        }
    }

    public String dHY() {
        return this.mPE.dHY();
    }

    public void Su(String str) {
        if (this.mPE != null) {
            this.mPE.Su(str);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        if (this.mPE != null) {
            this.mPE.c(str, list, z);
        }
    }

    public void fF(List<q> list) {
        if (this.mPE != null) {
            this.mPE.fF(list);
        }
    }

    public void v(List<q> list, int i) {
        if (this.mPE != null) {
            this.mPE.v(list, i);
        }
    }

    public void dHZ() {
        if (this.mPE != null) {
            this.mPE.dHZ();
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        if (this.mPC != null) {
            this.mPC.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.ikq != null) {
            this.ikq.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.mPE != null) {
            this.mPE.onChangeSkinType(i);
        }
        if (this.gso != null) {
            this.gso.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.mPC, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.ctR, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mPB, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.ikq != null) {
            this.ikq.setSearchHint(str);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        this.mPG = onClickListener;
    }

    public void oY(boolean z) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.mPG);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.mPF, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cmK() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mPF);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.mPF);
            this.gso = null;
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(this.mActivity);
                this.gso.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gso.onChangeSkinType();
            this.gso.attachView(this.mPF, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dIa() {
        hideLoadingView();
        hideNoDataView();
        oY(true);
        if (this.mPE != null) {
            this.mPE.He(8);
        }
    }

    public void dIb() {
        Wk();
        hideNoDataView();
        hJ(true);
    }

    public void dIc() {
        hideLoadingView();
        Wk();
        hideNoDataView();
        if (this.mPE != null) {
            this.mPE.hideLoadingView();
            this.mPE.He(0);
        }
    }

    public void dId() {
        hideLoadingView();
        Wk();
        hideNoDataView();
        if (this.mPE != null) {
            this.mPE.hJ(true);
            this.mPE.Js(8);
        }
    }

    public void dIe() {
        if (this.mPE != null) {
            this.mPE.dIe();
        }
    }

    public void dIf() {
        if (this.mPE != null) {
            this.mPE.dIf();
        }
    }

    public void dIg() {
        if (this.mPE != null) {
            this.mPE.dIg();
        }
    }

    public void bPW() {
        if (this.mPE != null) {
            this.mPE.bPW();
        }
    }

    public boolean xj(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dIg();
            } else {
                dIe();
            }
            return true;
        }
        dIf();
        return false;
    }
}
