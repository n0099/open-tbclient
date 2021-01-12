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
    private GridView dhj;
    private View lcM;
    private a lcN;
    private BubbleChooseActivity lcO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        this.lcO = tbPageContext.getOrignalPage();
        this.lcO.setContentView(R.layout.bubble_activity_view);
        this.mNavigationBar = (NavigationBar) this.lcO.findViewById(R.id.lay_title_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.editor_privilege);
        this.lcM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.lcO);
        this.mRootView = (ViewGroup) this.lcO.findViewById(R.id.container);
        this.dhj = (GridView) this.lcO.findViewById(R.id.gv_bubble_list);
        this.lcN = new a(tbPageContext);
        this.dhj.setAdapter((ListAdapter) this.lcN);
        this.mProgressBar = (ProgressBar) this.lcO.findViewById(R.id.bubble_progress);
    }

    public void setData(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.lcN != null) {
            this.lcN.tG(z);
            this.lcN.setData(list);
        }
    }

    public a dcT() {
        return this.lcN;
    }

    public View dcU() {
        return this.lcM;
    }

    public GridView dcV() {
        return this.dhj;
    }

    public BubbleListData.BubbleData DX(int i) {
        if (this.lcN == null) {
            return null;
        }
        return this.lcN.getItem(i);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType((TbPageContext) getPageContext(), i);
        this.lcO.getLayoutMode().setNightMode(i == 1);
        this.lcO.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
