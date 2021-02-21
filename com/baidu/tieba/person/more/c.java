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
/* loaded from: classes8.dex */
public class c {
    private BdTypeListView gzp;
    private ab<h> jzs;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private a mto;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void am(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        this.gzp = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.mto = new a(this.mPageContext, this.gzp, this.jzs);
        bEL();
    }

    private void bEL() {
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
        this.gzp.setData(list);
    }

    public void onChangeSkinType() {
        this.mto.notifyDataSetChanged();
        ap.setBackgroundColor(this.gzp, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(ab<h> abVar) {
        this.jzs = abVar;
    }
}
