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
/* loaded from: classes8.dex */
public class b extends d<BubbleChooseActivity> {
    private GridView dkY;
    private View lnf;
    private a lnh;
    private BubbleChooseActivity lni;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        this.lni = tbPageContext.getOrignalPage();
        this.lni.setContentView(R.layout.bubble_activity_view);
        this.mNavigationBar = (NavigationBar) this.lni.findViewById(R.id.lay_title_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.lnf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.lni);
        this.mRootView = (ViewGroup) this.lni.findViewById(R.id.container);
        this.dkY = (GridView) this.lni.findViewById(R.id.gv_bubble_list);
        this.lnh = new a(tbPageContext);
        this.dkY.setAdapter((ListAdapter) this.lnh);
        this.mProgressBar = (ProgressBar) this.lni.findViewById(R.id.bubble_progress);
    }

    public void setData(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.lnh != null) {
            this.lnh.tT(z);
            this.lnh.setData(list);
        }
    }

    public a dfj() {
        return this.lnh;
    }

    public View dfk() {
        return this.lnf;
    }

    public GridView dfl() {
        return this.dkY;
    }

    public BubbleListData.BubbleData Es(int i) {
        if (this.lnh == null) {
            return null;
        }
        return this.lnh.getItem(i);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.lni.getLayoutMode().setNightMode(i == 1);
        this.lni.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
