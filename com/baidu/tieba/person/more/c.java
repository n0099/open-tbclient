package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.c.h;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private BdTypeListView gAY;
    private ab<h> jBb;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private a mvq;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void am(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        this.gAY = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.mvq = new a(this.mPageContext, this.gAY, this.jBb);
        bEP();
    }

    private void bEP() {
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

    public void setData(List<n> list) {
        this.gAY.setData(list);
    }

    public void onChangeSkinType() {
        this.mvq.notifyDataSetChanged();
        ap.setBackgroundColor(this.gAY, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(ab<h> abVar) {
        this.jBb = abVar;
    }
}
