package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private ValidateActivity eCB;
    private ImageView eCH;
    private BdListView eCI;
    private a eCJ;
    private View evn;
    private ProgressBar exz;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eCB = validateActivity;
        initView();
        this.eCJ = new a(this.eCB);
        this.eCI.setAdapter((ListAdapter) this.eCJ);
        this.eCI.setOnSrollToBottomListener(this.eCB);
    }

    void initView() {
        this.evn = View.inflate(this.eCB.getPageContext().getPageActivity(), f.h.validate_activity, null);
        this.eCB.setContentView(this.evn);
        this.mNavigationBar = (NavigationBar) this.eCB.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eCB.getPageContext().getString(f.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eCB.finish();
            }
        });
        this.eCI = (BdListView) this.evn.findViewById(f.g.validate_list);
        this.exz = (ProgressBar) this.evn.findViewById(f.g.pro_load);
        hJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eCJ != null) {
            this.eCJ.destroy();
            this.eCJ = null;
        }
        this.eCB = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eCJ != null) {
            this.eCJ.setData(list);
        }
    }

    public void hJ(boolean z) {
        this.exz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eCB.getLayoutMode().setNightMode(i == 1);
        this.eCB.getLayoutMode().onModeChanged(this.evn);
        this.mNavigationBar.onChangeSkinType(this.eCB.getPageContext(), i);
        if (i == 1) {
            this.eCI.setDivider(new ColorDrawable(this.eCB.getResources().getColor(f.d.common_color_10179)));
            this.eCI.setDividerHeight(this.eCB.getResources().getDimensionPixelSize(f.e.ds2));
            return;
        }
        this.eCI.setDivider(new ColorDrawable(this.eCB.getResources().getColor(f.d.common_color_10241)));
        this.eCI.setDividerHeight(this.eCB.getResources().getDimensionPixelSize(f.e.ds2));
    }

    public ImageView aNI() {
        return this.eCH;
    }

    public a aNJ() {
        return this.eCJ;
    }
}
