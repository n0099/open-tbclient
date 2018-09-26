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
    private View eCG;
    private ProgressBar eER;
    private ValidateActivity eJS;
    private ImageView eJY;
    private BdListView eJZ;
    private a eKa;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eJS = validateActivity;
        initView();
        this.eKa = new a(this.eJS);
        this.eJZ.setAdapter((ListAdapter) this.eKa);
        this.eJZ.setOnSrollToBottomListener(this.eJS);
    }

    void initView() {
        this.eCG = View.inflate(this.eJS.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.eJS.setContentView(this.eCG);
        this.mNavigationBar = (NavigationBar) this.eJS.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eJS.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eJS.finish();
            }
        });
        this.eJZ = (BdListView) this.eCG.findViewById(e.g.validate_list);
        this.eER = (ProgressBar) this.eCG.findViewById(e.g.pro_load);
        ih(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eKa != null) {
            this.eKa.destroy();
            this.eKa = null;
        }
        this.eJS = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eKa != null) {
            this.eKa.setData(list);
        }
    }

    public void ih(boolean z) {
        this.eER.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eJS.getLayoutMode().setNightMode(i == 1);
        this.eJS.getLayoutMode().onModeChanged(this.eCG);
        this.mNavigationBar.onChangeSkinType(this.eJS.getPageContext(), i);
        if (i == 1) {
            this.eJZ.setDivider(new ColorDrawable(this.eJS.getResources().getColor(e.d.common_color_10179)));
            this.eJZ.setDividerHeight(this.eJS.getResources().getDimensionPixelSize(e.C0141e.ds2));
            return;
        }
        this.eJZ.setDivider(new ColorDrawable(this.eJS.getResources().getColor(e.d.common_color_10241)));
        this.eJZ.setDividerHeight(this.eJS.getResources().getDimensionPixelSize(e.C0141e.ds2));
    }

    public ImageView aPX() {
        return this.eJY;
    }

    public a aPY() {
        return this.eKa;
    }
}
