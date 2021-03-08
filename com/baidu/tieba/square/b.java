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
import com.baidu.tbadk.core.util.ap;
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
    private View cDe;
    private CustomMessageListener eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.square.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                b.this.changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };
    private g gLk;
    public ForumHeaderView iLn;
    private Context mActivity;
    public NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;
    private final TbPageContext mTbPageContext;
    private RelativeLayout nrO;
    private TextView nrP;
    private View nrQ;
    private com.baidu.tieba.square.view.b nrR;
    private RelativeLayout nrS;
    private View.OnClickListener nrT;

    public b(Context context, TbPageContext tbPageContext) {
        this.mActivity = context;
        this.mTbPageContext = tbPageContext;
        this.cDe = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.eXe);
    }

    public View getRootLayout() {
        return this.cDe;
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.cDe.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forum_square));
        this.nrQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.nrP = (TextView) this.nrQ.findViewById(R.id.right_textview);
        this.nrP.setText(this.mActivity.getString(R.string.forum_square_create_bar));
        this.nrO = (RelativeLayout) this.cDe.findViewById(R.id.forum_header_serch_container);
        this.iLn = (ForumHeaderView) this.cDe.findViewById(R.id.forum_header_serch_view);
        this.iLn.setFrom(1);
        this.iLn.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.nrR = new com.baidu.tieba.square.view.b(this.mTbPageContext, this.cDe);
        this.nrS = (RelativeLayout) this.cDe.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dLF() {
        this.mNavigationBar.setVisibility(8);
        this.iLn.setVisibility(8);
        this.nrO.setVisibility(8);
        ((LinearLayout.LayoutParams) this.nrS.getLayoutParams()).bottomMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
    }

    public void yh(boolean z) {
        this.nrQ.setVisibility(z ? 0 : 8);
    }

    public Pair<Integer, Integer> dLH() {
        return this.nrR != null ? this.nrR.dLH() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nrR != null) {
            this.nrR.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nrR != null) {
            this.nrR.a(aVar);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.nrR != null) {
            this.nrR.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nrR != null) {
            this.nrR.b(onScrollListener);
        }
    }

    public String dLI() {
        return this.nrR.dLI();
    }

    public void SZ(String str) {
        if (this.nrR != null) {
            this.nrR.SZ(str);
        }
    }

    public void e(String str, List<String> list, boolean z) {
        if (this.nrR != null) {
            this.nrR.e(str, list, z);
        }
    }

    public void fQ(List<n> list) {
        if (this.nrR != null) {
            this.nrR.fQ(list);
        }
    }

    public void v(List<n> list, int i) {
        if (this.nrR != null) {
            this.nrR.v(list, i);
        }
    }

    public void dLJ() {
        if (this.nrR != null) {
            this.nrR.dLJ();
        }
    }

    public void al(View.OnClickListener onClickListener) {
        if (this.nrP != null) {
            this.nrP.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.iLn != null) {
            this.iLn.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.mActivity != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        if (this.nrR != null) {
            this.nrR.onChangeSkinType(i);
        }
        if (this.gLk != null) {
            this.gLk.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.mActivity != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setViewTextColor(this.nrP, R.color.CAM_X0105, 1);
        ap.setBackgroundColor(this.cDe, R.color.CAM_X0205);
        ap.setBackgroundColor(this.nrO, R.color.CAM_X0207);
        ap.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
    }

    public void setSearchHint(String str) {
        if (this.iLn != null) {
            this.iLn.setSearchHint(str);
        }
    }

    public void am(View.OnClickListener onClickListener) {
        this.nrT = onClickListener;
    }

    public void qa(boolean z) {
        if (!cqZ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mActivity, this.nrT);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.nrS, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean cqZ() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.nrS);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.nrS);
            this.gLk = null;
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(this.mActivity);
                this.gLk.setTopMargin(l.getDimens(this.mActivity, R.dimen.ds250));
            }
            this.gLk.onChangeSkinType();
            this.gLk.attachView(this.nrS, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dLK() {
        hideLoadingView();
        hideNoDataView();
        qa(true);
        if (this.nrR != null) {
            this.nrR.Hb(8);
        }
    }

    public void dLL() {
        Xc();
        hideNoDataView();
        ir(true);
    }

    public void dLM() {
        hideLoadingView();
        Xc();
        hideNoDataView();
        if (this.nrR != null) {
            this.nrR.hideLoadingView();
            this.nrR.Hb(0);
        }
    }

    public void dLN() {
        hideLoadingView();
        Xc();
        hideNoDataView();
        if (this.nrR != null) {
            this.nrR.ir(true);
            this.nrR.Jw(8);
        }
    }

    public void dLO() {
        if (this.nrR != null) {
            this.nrR.dLO();
        }
    }

    public void dLP() {
        if (this.nrR != null) {
            this.nrR.dLP();
        }
    }

    public void dLQ() {
        if (this.nrR != null) {
            this.nrR.dLQ();
        }
    }

    public void bSE() {
        if (this.nrR != null) {
            this.nrR.bSE();
        }
    }

    public boolean yi(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dLQ();
            } else {
                dLO();
            }
            return true;
        }
        dLP();
        return false;
    }
}
