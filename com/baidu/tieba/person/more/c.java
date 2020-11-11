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
    private BdTypeListView gih;
    private ab<h> iXs;
    private a lUT;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void al(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        this.gih = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.lUT = new a(this.mPageContext, this.gih, this.iXs);
        bCV();
    }

    private void bCV() {
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
        this.gih.setData(list);
    }

    public void onChangeSkinType() {
        this.lUT.notifyDataSetChanged();
        ap.setBackgroundColor(this.gih, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(ab<h> abVar) {
        this.iXs = abVar;
    }
}
