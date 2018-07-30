package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.e;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private a fUg;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    TbPageContext mPageContext;
    private ad<e> rO;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void Y(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_more_navigation_bar);
        asl();
        this.mListView = (BdTypeListView) view.findViewById(d.g.person_more_listview);
        this.fUg = new a(this.mPageContext, this.mListView, this.rO);
    }

    private void asl() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.more));
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
        this.fUg.notifyDataSetChanged();
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(ad<e> adVar) {
        this.rO = adVar;
    }
}
