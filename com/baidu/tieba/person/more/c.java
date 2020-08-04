package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.c.h;
import java.util.List;
/* loaded from: classes18.dex */
public class c {
    private BdTypeListView frv;
    private aa<h> hUR;
    private a kOv;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void aj(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        this.frv = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.kOv = new a(this.mPageContext, this.frv, this.hUR);
        bmb();
    }

    private void bmb() {
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

    public void setData(List<q> list) {
        this.frv.setData(list);
    }

    public void onChangeSkinType() {
        this.kOv.notifyDataSetChanged();
        ao.setBackgroundColor(this.frv, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(aa<h> aaVar) {
        this.hUR = aaVar;
    }
}
