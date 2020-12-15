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
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View fDE;
    private ValidateActivity kDS;
    private ImageView kDY;
    private BdListView kDZ;
    private a kEa;
    private ProgressBar kyJ;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kDS = validateActivity;
        initView();
        this.kEa = new a(this.kDS);
        this.kDZ.setAdapter((ListAdapter) this.kEa);
        this.kDZ.setOnSrollToBottomListener(this.kDS);
    }

    void initView() {
        this.fDE = View.inflate(this.kDS.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kDS.setContentView(this.fDE);
        this.mNavigationBar = (NavigationBar) this.kDS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kDS.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kDS.finish();
            }
        });
        this.kDZ = (BdListView) this.fDE.findViewById(R.id.validate_list);
        this.kyJ = (ProgressBar) this.fDE.findViewById(R.id.pro_load);
        sJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kEa != null) {
            this.kEa.destroy();
            this.kEa = null;
        }
        this.kDS = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kEa != null) {
            this.kEa.setData(list);
        }
    }

    public void sJ(boolean z) {
        this.kyJ.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kDS.getLayoutMode().setNightMode(i == 1);
        this.kDS.getLayoutMode().onModeChanged(this.fDE);
        this.mNavigationBar.onChangeSkinType(this.kDS.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kDZ.setDivider(new ColorDrawable(this.kDS.getResources().getColor(R.color.common_color_10179)));
            this.kDZ.setDividerHeight(this.kDS.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kDZ.setDivider(new ColorDrawable(this.kDS.getResources().getColor(R.color.common_color_10241)));
        this.kDZ.setDividerHeight(this.kDS.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView dap() {
        return this.kDY;
    }

    public a daq() {
        return this.kEa;
    }
}
