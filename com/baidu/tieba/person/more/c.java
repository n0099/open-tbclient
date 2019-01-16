package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private a guY;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    TbPageContext mPageContext;
    private ad<f> vh;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void initView(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.person_more_navigation_bar);
        azR();
        this.mListView = (BdTypeListView) view.findViewById(e.g.person_more_listview);
        this.guY = new a(this.mPageContext, this.mListView, this.vh);
    }

    private void azR() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(e.j.more));
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.person.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.mPageContext.getPageActivity().finish();
            }
        });
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<h> list) {
        this.mListView.setData(list);
    }

    public void onChangeSkinType() {
        this.guY.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(ad<f> adVar) {
        this.vh = adVar;
    }
}
