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
    private ValidateActivity eCF;
    private ImageView eCL;
    private BdListView eCM;
    private a eCN;
    private View evr;
    private ProgressBar exD;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eCF = validateActivity;
        initView();
        this.eCN = new a(this.eCF);
        this.eCM.setAdapter((ListAdapter) this.eCN);
        this.eCM.setOnSrollToBottomListener(this.eCF);
    }

    void initView() {
        this.evr = View.inflate(this.eCF.getPageContext().getPageActivity(), d.h.validate_activity, null);
        this.eCF.setContentView(this.evr);
        this.mNavigationBar = (NavigationBar) this.eCF.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eCF.getPageContext().getString(d.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eCF.finish();
            }
        });
        this.eCM = (BdListView) this.evr.findViewById(d.g.validate_list);
        this.exD = (ProgressBar) this.evr.findViewById(d.g.pro_load);
        hJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eCN != null) {
            this.eCN.destroy();
            this.eCN = null;
        }
        this.eCF = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eCN != null) {
            this.eCN.setData(list);
        }
    }

    public void hJ(boolean z) {
        this.exD.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eCF.getLayoutMode().setNightMode(i == 1);
        this.eCF.getLayoutMode().onModeChanged(this.evr);
        this.mNavigationBar.onChangeSkinType(this.eCF.getPageContext(), i);
        if (i == 1) {
            this.eCM.setDivider(new ColorDrawable(this.eCF.getResources().getColor(d.C0140d.common_color_10179)));
            this.eCM.setDividerHeight(this.eCF.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eCM.setDivider(new ColorDrawable(this.eCF.getResources().getColor(d.C0140d.common_color_10241)));
        this.eCM.setDividerHeight(this.eCF.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aNL() {
        return this.eCL;
    }

    public a aNM() {
        return this.eCN;
    }
}
