package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.c.h;
import java.util.List;
/* loaded from: classes24.dex */
public class c {
    private BdTypeListView gpZ;
    private ab<h> jlF;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private a mju;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void an(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        this.gpZ = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.mju = new a(this.mPageContext, this.gpZ, this.jlF);
        bFP();
    }

    private void bFP() {
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
        this.gpZ.setData(list);
    }

    public void onChangeSkinType() {
        this.mju.notifyDataSetChanged();
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(ab<h> abVar) {
        this.jlF = abVar;
    }
}
