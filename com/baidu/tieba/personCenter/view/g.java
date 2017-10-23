package com.baidu.tieba.personCenter.view;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tieba.personCenter.b.d fbh;
    TbPageContext mH;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public g(TbPageContext tbPageContext) {
        this.mH = tbPageContext;
    }

    public void X(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(d.h.person_more_navigation_bar);
        aiw();
        this.mListView = (BdTypeListView) view.findViewById(d.h.person_more_listview);
        this.fbh = new com.baidu.tieba.personCenter.b.d(this.mH, this.mListView);
    }

    private void aiw() {
        this.mNavigationBar.setCenterTextTitle(this.mH.getString(d.l.more));
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mH.getPageActivity().finish();
            }
        });
        this.mNavigationBar.onChangeSkinType(this.mH, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mListView.setData(list);
    }
}
