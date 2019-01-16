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
    private View eWb;
    private ProgressBar eYm;
    private ValidateActivity fdn;
    private ImageView fdt;
    private BdListView fdu;
    private a fdv;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.fdn = validateActivity;
        initView();
        this.fdv = new a(this.fdn);
        this.fdu.setAdapter((ListAdapter) this.fdv);
        this.fdu.setOnSrollToBottomListener(this.fdn);
    }

    void initView() {
        this.eWb = View.inflate(this.fdn.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.fdn.setContentView(this.eWb);
        this.mNavigationBar = (NavigationBar) this.fdn.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fdn.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fdn.finish();
            }
        });
        this.fdu = (BdListView) this.eWb.findViewById(e.g.validate_list);
        this.eYm = (ProgressBar) this.eWb.findViewById(e.g.pro_load);
        iO(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.fdv != null) {
            this.fdv.destroy();
            this.fdv = null;
        }
        this.fdn = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.fdv != null) {
            this.fdv.setData(list);
        }
    }

    public void iO(boolean z) {
        this.eYm.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.fdn.getLayoutMode().setNightMode(i == 1);
        this.fdn.getLayoutMode().onModeChanged(this.eWb);
        this.mNavigationBar.onChangeSkinType(this.fdn.getPageContext(), i);
        if (i == 1) {
            this.fdu.setDivider(new ColorDrawable(this.fdn.getResources().getColor(e.d.common_color_10179)));
            this.fdu.setDividerHeight(this.fdn.getResources().getDimensionPixelSize(e.C0210e.ds2));
            return;
        }
        this.fdu.setDivider(new ColorDrawable(this.fdn.getResources().getColor(e.d.common_color_10241)));
        this.fdu.setDividerHeight(this.fdn.getResources().getDimensionPixelSize(e.C0210e.ds2));
    }

    public ImageView aVN() {
        return this.fdt;
    }

    public a aVO() {
        return this.fdv;
    }
}
