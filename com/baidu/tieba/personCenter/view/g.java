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
    private com.baidu.tieba.personCenter.b.d fjy;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void Z(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_more_navigation_bar);
        akI();
        this.mListView = (BdTypeListView) view.findViewById(d.g.person_more_listview);
        this.fjy = new com.baidu.tieba.personCenter.b.d(this.mPageContext, this.mListView);
    }

    private void akI() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.more));
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mPageContext.getPageActivity().finish();
            }
        });
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mListView.setData(list);
    }
}
