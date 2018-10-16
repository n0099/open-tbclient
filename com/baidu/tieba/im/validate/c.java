package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View eKp;
    private ProgressBar eMA;
    private ValidateActivity eRB;
    private ImageView eRH;
    private BdListView eRI;
    private a eRJ;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eRB = validateActivity;
        initView();
        this.eRJ = new a(this.eRB);
        this.eRI.setAdapter((ListAdapter) this.eRJ);
        this.eRI.setOnSrollToBottomListener(this.eRB);
    }

    void initView() {
        this.eKp = View.inflate(this.eRB.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.eRB.setContentView(this.eKp);
        this.mNavigationBar = (NavigationBar) this.eRB.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eRB.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eRB.finish();
            }
        });
        this.eRI = (BdListView) this.eKp.findViewById(e.g.validate_list);
        this.eMA = (ProgressBar) this.eKp.findViewById(e.g.pro_load);
        iz(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eRJ != null) {
            this.eRJ.destroy();
            this.eRJ = null;
        }
        this.eRB = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eRJ != null) {
            this.eRJ.setData(list);
        }
    }

    public void iz(boolean z) {
        this.eMA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eRB.getLayoutMode().setNightMode(i == 1);
        this.eRB.getLayoutMode().onModeChanged(this.eKp);
        this.mNavigationBar.onChangeSkinType(this.eRB.getPageContext(), i);
        if (i == 1) {
            this.eRI.setDivider(new ColorDrawable(this.eRB.getResources().getColor(e.d.common_color_10179)));
            this.eRI.setDividerHeight(this.eRB.getResources().getDimensionPixelSize(e.C0175e.ds2));
            return;
        }
        this.eRI.setDivider(new ColorDrawable(this.eRB.getResources().getColor(e.d.common_color_10241)));
        this.eRI.setDividerHeight(this.eRB.getResources().getDimensionPixelSize(e.C0175e.ds2));
    }

    public ImageView aTl() {
        return this.eRH;
    }

    public a aTm() {
        return this.eRJ;
    }
}
