package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.g<ValidateActivity> {
    private ValidateActivity bpR;
    private ImageView bpX;
    private BdListView bpY;
    private h bpZ;
    private NavigationBar mNavigationBar;
    private View parent;
    private ProgressBar pro_load;

    public m(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.bpR = validateActivity;
        initView();
        this.bpZ = new h(this.bpR);
        this.bpY.setAdapter((ListAdapter) this.bpZ);
        this.bpY.setOnSrollToBottomListener(this.bpR);
    }

    void initView() {
        this.parent = View.inflate(this.bpR.getPageContext().getPageActivity(), x.validate_activity, null);
        this.bpR.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.bpR.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bpR.getPageContext().getString(z.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        this.bpY = (BdListView) this.parent.findViewById(w.validate_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(w.pro_load);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.bpZ != null) {
            this.bpZ.destroy();
            this.bpZ = null;
        }
        this.bpR = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.bpZ != null) {
            this.bpZ.setData(list);
        }
    }

    public void setLoadProgressBarVisable(boolean z) {
        this.pro_load.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bpR.getLayoutMode().ab(i == 1);
        this.bpR.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.bpR.getPageContext(), i);
        if (i == 1) {
            this.bpY.setDivider(new ColorDrawable(this.bpR.getResources().getColor(t.night_divider)));
            this.bpY.setDividerHeight(this.bpR.getResources().getDimensionPixelSize(u.onedip));
            return;
        }
        this.bpY.setDivider(new ColorDrawable(this.bpR.getResources().getColor(t.day_divider)));
        this.bpY.setDividerHeight(this.bpR.getResources().getDimensionPixelSize(u.onedip));
    }

    public ImageView TI() {
        return this.bpX;
    }

    public h TJ() {
        return this.bpZ;
    }
}
