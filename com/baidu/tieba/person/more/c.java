package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.c.g;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private BdTypeListView fbb;
    private aa<g> hBI;
    private a klF;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void ag(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        this.fbb = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.klF = new a(this.mPageContext, this.fbb, this.hBI);
        brd();
    }

    private void brd() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.person_center_more));
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.person.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.mPageContext.getPageActivity().finish();
            }
        });
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<o> list) {
        this.fbb.setData(list);
    }

    public void onChangeSkinType() {
        this.klF.notifyDataSetChanged();
        am.setBackgroundColor(this.fbb, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(aa<g> aaVar) {
        this.hBI = aaVar;
    }
}
