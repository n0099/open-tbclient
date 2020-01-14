package com.baidu.tieba.person.more;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.data.g;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView efW;
    private z<g> gzt;
    private a jfM;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void initView(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        this.efW = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.jfM = new a(this.mPageContext, this.efW, this.gzt);
        bas();
    }

    private void bas() {
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

    public void setData(List<m> list) {
        this.efW.setData(list);
    }

    public void onChangeSkinType() {
        this.jfM.notifyDataSetChanged();
        am.setBackgroundColor(this.efW, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(z<g> zVar) {
        this.gzt = zVar;
    }
}
