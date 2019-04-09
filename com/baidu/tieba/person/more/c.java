package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.f;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private a hKX;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    TbPageContext mPageContext;
    private ab<f> vd;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void O(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_more_navigation_bar);
        aBy();
        this.mListView = (BdTypeListView) view.findViewById(d.g.person_more_listview);
        this.hKX = new a(this.mPageContext, this.mListView, this.vd);
    }

    private void aBy() {
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

    public void setData(List<m> list) {
        this.mListView.setData(list);
    }

    public void onChangeSkinType() {
        this.hKX.notifyDataSetChanged();
        al.l(this.mListView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(ab<f> abVar) {
        this.vd = abVar;
    }
}
