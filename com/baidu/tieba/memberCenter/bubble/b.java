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
    private GridView dlY;
    private View lhs;
    private a lht;
    private BubbleChooseActivity lhu;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        this.lhu = tbPageContext.getOrignalPage();
        this.lhu.setContentView(R.layout.bubble_activity_view);
        this.mNavigationBar = (NavigationBar) this.lhu.findViewById(R.id.lay_title_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.lhs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.lhu);
        this.mRootView = (ViewGroup) this.lhu.findViewById(R.id.container);
        this.dlY = (GridView) this.lhu.findViewById(R.id.gv_bubble_list);
        this.lht = new a(tbPageContext);
        this.dlY.setAdapter((ListAdapter) this.lht);
        this.mProgressBar = (ProgressBar) this.lhu.findViewById(R.id.bubble_progress);
    }

    public void setData(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.lht != null) {
            this.lht.tK(z);
            this.lht.setData(list);
        }
    }

    public a dgL() {
        return this.lht;
    }

    public View dgM() {
        return this.lhs;
    }

    public GridView dgN() {
        return this.dlY;
    }

    public BubbleListData.BubbleData FD(int i) {
        if (this.lht == null) {
            return null;
        }
        return this.lht.getItem(i);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.lhu.getLayoutMode().setNightMode(i == 1);
        this.lhu.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
