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
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View etr;
    private ProgressBar iFx;
    private ImageView iKE;
    private BdListView iKF;
    private a iKG;
    private ValidateActivity iKy;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.iKy = validateActivity;
        initView();
        this.iKG = new a(this.iKy);
        this.iKF.setAdapter((ListAdapter) this.iKG);
        this.iKF.setOnSrollToBottomListener(this.iKy);
    }

    void initView() {
        this.etr = View.inflate(this.iKy.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.iKy.setContentView(this.etr);
        this.mNavigationBar = (NavigationBar) this.iKy.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iKy.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.iKy.finish();
            }
        });
        this.iKF = (BdListView) this.etr.findViewById(R.id.validate_list);
        this.iFx = (ProgressBar) this.etr.findViewById(R.id.pro_load);
        pq(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iKG != null) {
            this.iKG.destroy();
            this.iKG = null;
        }
        this.iKy = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.iKG != null) {
            this.iKG.setData(list);
        }
    }

    public void pq(boolean z) {
        this.iFx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.iKy.getLayoutMode().setNightMode(i == 1);
        this.iKy.getLayoutMode().onModeChanged(this.etr);
        this.mNavigationBar.onChangeSkinType(this.iKy.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.iKF.setDivider(new ColorDrawable(this.iKy.getResources().getColor(R.color.common_color_10179)));
            this.iKF.setDividerHeight(this.iKy.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.iKF.setDivider(new ColorDrawable(this.iKy.getResources().getColor(R.color.common_color_10241)));
        this.iKF.setDividerHeight(this.iKy.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cpH() {
        return this.iKE;
    }

    public a cpI() {
        return this.iKG;
    }
}
