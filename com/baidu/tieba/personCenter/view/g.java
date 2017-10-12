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
    private com.baidu.tieba.personCenter.b.d fbv;
    TbPageContext mG;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public g(TbPageContext tbPageContext) {
        this.mG = tbPageContext;
    }

    public void X(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(d.h.person_more_navigation_bar);
        aiB();
        this.mListView = (BdTypeListView) view.findViewById(d.h.person_more_listview);
        this.fbv = new com.baidu.tieba.personCenter.b.d(this.mG, this.mListView);
    }

    private void aiB() {
        this.mNavigationBar.setCenterTextTitle(this.mG.getString(d.l.more));
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mG.getPageActivity().finish();
            }
        });
        this.mNavigationBar.onChangeSkinType(this.mG, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mListView.setData(list);
    }
}
