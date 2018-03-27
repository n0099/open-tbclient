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
    private View bMp;
    private ProgressBar eIV;
    private ValidateActivity eNW;
    private ImageView eOc;
    private BdListView eOd;
    private a eOe;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eNW = validateActivity;
        initView();
        this.eOe = new a(this.eNW);
        this.eOd.setAdapter((ListAdapter) this.eOe);
        this.eOd.setOnSrollToBottomListener(this.eNW);
    }

    void initView() {
        this.bMp = View.inflate(this.eNW.getPageContext().getPageActivity(), d.h.validate_activity, null);
        this.eNW.setContentView(this.bMp);
        this.mNavigationBar = (NavigationBar) this.eNW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eNW.getPageContext().getString(d.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eNW.finish();
            }
        });
        this.eOd = (BdListView) this.bMp.findViewById(d.g.validate_list);
        this.eIV = (ProgressBar) this.bMp.findViewById(d.g.pro_load);
        hP(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eOe != null) {
            this.eOe.destroy();
            this.eOe = null;
        }
        this.eNW = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eOe != null) {
            this.eOe.setData(list);
        }
    }

    public void hP(boolean z) {
        this.eIV.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eNW.getLayoutMode().aQ(i == 1);
        this.eNW.getLayoutMode().aM(this.bMp);
        this.mNavigationBar.onChangeSkinType(this.eNW.getPageContext(), i);
        if (i == 1) {
            this.eOd.setDivider(new ColorDrawable(this.eNW.getResources().getColor(d.C0141d.common_color_10179)));
            this.eOd.setDividerHeight(this.eNW.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eOd.setDivider(new ColorDrawable(this.eNW.getResources().getColor(d.C0141d.common_color_10241)));
        this.eOd.setDividerHeight(this.eNW.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aMm() {
        return this.eOc;
    }

    public a aMn() {
        return this.eOe;
    }
}
