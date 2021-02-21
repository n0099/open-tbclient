package com.baidu.tieba.memberCenter.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends d<BubbleChooseActivity> {
    private GridView djx;
    private View lld;
    private a lle;
    private BubbleChooseActivity llf;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        this.llf = tbPageContext.getOrignalPage();
        this.llf.setContentView(R.layout.bubble_activity_view);
        this.mNavigationBar = (NavigationBar) this.llf.findViewById(R.id.lay_title_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.lld = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.llf);
        this.mRootView = (ViewGroup) this.llf.findViewById(R.id.container);
        this.djx = (GridView) this.llf.findViewById(R.id.gv_bubble_list);
        this.lle = new a(tbPageContext);
        this.djx.setAdapter((ListAdapter) this.lle);
        this.mProgressBar = (ProgressBar) this.llf.findViewById(R.id.bubble_progress);
    }

    public void setData(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.lle != null) {
            this.lle.tT(z);
            this.lle.setData(list);
        }
    }

    public a dfa() {
        return this.lle;
    }

    public View dfb() {
        return this.lld;
    }

    public GridView dfc() {
        return this.djx;
    }

    public BubbleListData.BubbleData Ep(int i) {
        if (this.lle == null) {
            return null;
        }
        return this.lle.getItem(i);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.llf.getLayoutMode().setNightMode(i == 1);
        this.llf.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
