package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View erz;
    private ProgressBar etL;
    private ValidateActivity eyO;
    private ImageView eyU;
    private BdListView eyV;
    private a eyW;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eyO = validateActivity;
        initView();
        this.eyW = new a(this.eyO);
        this.eyV.setAdapter((ListAdapter) this.eyW);
        this.eyV.setOnSrollToBottomListener(this.eyO);
    }

    void initView() {
        this.erz = View.inflate(this.eyO.getPageContext().getPageActivity(), d.i.validate_activity, null);
        this.eyO.setContentView(this.erz);
        this.mNavigationBar = (NavigationBar) this.eyO.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eyO.getPageContext().getString(d.k.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eyO.finish();
            }
        });
        this.eyV = (BdListView) this.erz.findViewById(d.g.validate_list);
        this.etL = (ProgressBar) this.erz.findViewById(d.g.pro_load);
        hG(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eyW != null) {
            this.eyW.destroy();
            this.eyW = null;
        }
        this.eyO = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eyW != null) {
            this.eyW.setData(list);
        }
    }

    public void hG(boolean z) {
        this.etL.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eyO.getLayoutMode().setNightMode(i == 1);
        this.eyO.getLayoutMode().onModeChanged(this.erz);
        this.mNavigationBar.onChangeSkinType(this.eyO.getPageContext(), i);
        if (i == 1) {
            this.eyV.setDivider(new ColorDrawable(this.eyO.getResources().getColor(d.C0142d.common_color_10179)));
            this.eyV.setDividerHeight(this.eyO.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eyV.setDivider(new ColorDrawable(this.eyO.getResources().getColor(d.C0142d.common_color_10241)));
        this.eyV.setDividerHeight(this.eyO.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aML() {
        return this.eyU;
    }

    public a aMM() {
        return this.eyW;
    }
}
