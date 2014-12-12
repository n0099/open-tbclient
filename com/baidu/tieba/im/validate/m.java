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
    private ImageView boA;
    private BdListView boB;
    private h boC;
    private ValidateActivity bou;
    private NavigationBar mNavigationBar;
    private View parent;
    private ProgressBar pro_load;

    public m(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.bou = validateActivity;
        initView();
        this.boC = new h(this.bou);
        this.boB.setAdapter((ListAdapter) this.boC);
        this.boB.setOnSrollToBottomListener(this.bou);
    }

    void initView() {
        this.parent = View.inflate(this.bou.getPageContext().getPageActivity(), x.validate_activity, null);
        this.bou.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.bou.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bou.getPageContext().getString(z.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        this.boB = (BdListView) this.parent.findViewById(w.validate_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(w.pro_load);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.boC != null) {
            this.boC.destroy();
            this.boC = null;
        }
        this.bou = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.boC != null) {
            this.boC.setData(list);
        }
    }

    public void setLoadProgressBarVisable(boolean z) {
        this.pro_load.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bou.getLayoutMode().ab(i == 1);
        this.bou.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.bou.getPageContext(), i);
        if (i == 1) {
            this.boB.setDivider(new ColorDrawable(this.bou.getResources().getColor(t.night_divider)));
            this.boB.setDividerHeight(this.bou.getResources().getDimensionPixelSize(u.onedip));
            return;
        }
        this.boB.setDivider(new ColorDrawable(this.bou.getResources().getColor(t.day_divider)));
        this.boB.setDividerHeight(this.bou.getResources().getDimensionPixelSize(u.onedip));
    }

    public ImageView Tm() {
        return this.boA;
    }

    public h Tn() {
        return this.boC;
    }
}
