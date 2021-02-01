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
    private View lkP;
    private a lkQ;
    private BubbleChooseActivity lkR;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        this.lkR = tbPageContext.getOrignalPage();
        this.lkR.setContentView(R.layout.bubble_activity_view);
        this.mNavigationBar = (NavigationBar) this.lkR.findViewById(R.id.lay_title_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.lkP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.lkR);
        this.mRootView = (ViewGroup) this.lkR.findViewById(R.id.container);
        this.djx = (GridView) this.lkR.findViewById(R.id.gv_bubble_list);
        this.lkQ = new a(tbPageContext);
        this.djx.setAdapter((ListAdapter) this.lkQ);
        this.mProgressBar = (ProgressBar) this.lkR.findViewById(R.id.bubble_progress);
    }

    public void setData(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.lkQ != null) {
            this.lkQ.tT(z);
            this.lkQ.setData(list);
        }
    }

    public a deT() {
        return this.lkQ;
    }

    public View deU() {
        return this.lkP;
    }

    public GridView deV() {
        return this.djx;
    }

    public BubbleListData.BubbleData Ep(int i) {
        if (this.lkQ == null) {
            return null;
        }
        return this.lkQ.getItem(i);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.lkR.getLayoutMode().setNightMode(i == 1);
        this.lkR.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
