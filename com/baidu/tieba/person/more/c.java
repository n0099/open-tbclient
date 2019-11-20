package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.g;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdTypeListView duK;
    private ab<g> fHU;
    private a ikm;
    private NavigationBar mNavigationBar;
    TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void W(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        aJv();
        this.duK = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.ikm = new a(this.mPageContext, this.duK, this.fHU);
    }

    private void aJv() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.more));
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
        this.duK.setData(list);
    }

    public void onChangeSkinType() {
        this.ikm.notifyDataSetChanged();
        am.setBackgroundColor(this.duK, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(ab<g> abVar) {
        this.fHU = abVar;
    }
}
