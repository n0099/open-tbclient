package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View czO;
    private ProgressBar gFx;
    private ImageView gKE;
    private BdListView gKF;
    private a gKG;
    private ValidateActivity gKy;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gKy = validateActivity;
        initView();
        this.gKG = new a(this.gKy);
        this.gKF.setAdapter((ListAdapter) this.gKG);
        this.gKF.setOnSrollToBottomListener(this.gKy);
    }

    void initView() {
        this.czO = View.inflate(this.gKy.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gKy.setContentView(this.czO);
        this.mNavigationBar = (NavigationBar) this.gKy.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gKy.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gKy.finish();
            }
        });
        this.gKF = (BdListView) this.czO.findViewById(R.id.validate_list);
        this.gFx = (ProgressBar) this.czO.findViewById(R.id.pro_load);
        me(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gKG != null) {
            this.gKG.destroy();
            this.gKG = null;
        }
        this.gKy = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gKG != null) {
            this.gKG.setData(list);
        }
    }

    public void me(boolean z) {
        this.gFx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gKy.getLayoutMode().setNightMode(i == 1);
        this.gKy.getLayoutMode().onModeChanged(this.czO);
        this.mNavigationBar.onChangeSkinType(this.gKy.getPageContext(), i);
        if (i == 1) {
            this.gKF.setDivider(new ColorDrawable(this.gKy.getResources().getColor(R.color.common_color_10179)));
            this.gKF.setDividerHeight(this.gKy.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gKF.setDivider(new ColorDrawable(this.gKy.getResources().getColor(R.color.common_color_10241)));
        this.gKF.setDividerHeight(this.gKy.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bEb() {
        return this.gKE;
    }

    public a bEc() {
        return this.gKG;
    }
}
