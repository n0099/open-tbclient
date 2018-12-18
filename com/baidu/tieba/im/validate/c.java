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
    private View eSx;
    private ProgressBar eUI;
    private ValidateActivity eZJ;
    private ImageView eZP;
    private BdListView eZQ;
    private a eZR;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eZJ = validateActivity;
        initView();
        this.eZR = new a(this.eZJ);
        this.eZQ.setAdapter((ListAdapter) this.eZR);
        this.eZQ.setOnSrollToBottomListener(this.eZJ);
    }

    void initView() {
        this.eSx = View.inflate(this.eZJ.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.eZJ.setContentView(this.eSx);
        this.mNavigationBar = (NavigationBar) this.eZJ.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eZJ.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eZJ.finish();
            }
        });
        this.eZQ = (BdListView) this.eSx.findViewById(e.g.validate_list);
        this.eUI = (ProgressBar) this.eSx.findViewById(e.g.pro_load);
        iL(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eZR != null) {
            this.eZR.destroy();
            this.eZR = null;
        }
        this.eZJ = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eZR != null) {
            this.eZR.setData(list);
        }
    }

    public void iL(boolean z) {
        this.eUI.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eZJ.getLayoutMode().setNightMode(i == 1);
        this.eZJ.getLayoutMode().onModeChanged(this.eSx);
        this.mNavigationBar.onChangeSkinType(this.eZJ.getPageContext(), i);
        if (i == 1) {
            this.eZQ.setDivider(new ColorDrawable(this.eZJ.getResources().getColor(e.d.common_color_10179)));
            this.eZQ.setDividerHeight(this.eZJ.getResources().getDimensionPixelSize(e.C0210e.ds2));
            return;
        }
        this.eZQ.setDivider(new ColorDrawable(this.eZJ.getResources().getColor(e.d.common_color_10241)));
        this.eZQ.setDividerHeight(this.eZJ.getResources().getDimensionPixelSize(e.C0210e.ds2));
    }

    public ImageView aUz() {
        return this.eZP;
    }

    public a aUA() {
        return this.eZR;
    }
}
