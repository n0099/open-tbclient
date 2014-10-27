package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f {
    private View aGI;
    private ProgressBar bcm;
    private ValidateActivity biS;
    private ImageView bjb;
    private BdListView bjc;
    private g bjd;
    private NavigationBar mNavigationBar;

    public r(ValidateActivity validateActivity) {
        super(validateActivity);
        this.biS = validateActivity;
        nu();
        this.bjd = new g(this.biS);
        this.bjc.setAdapter((ListAdapter) this.bjd);
        this.bjc.setOnSrollToBottomListener(this.biS);
    }

    void nu() {
        this.aGI = View.inflate(this.biS, w.validate_activity, null);
        this.biS.setContentView(this.aGI);
        this.mNavigationBar = (NavigationBar) this.biS.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.biS.getString(y.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        this.bjc = (BdListView) this.aGI.findViewById(v.validate_list);
        this.bcm = (ProgressBar) this.aGI.findViewById(v.pro_load);
        dg(false);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        super.destroy();
        if (this.bjd != null) {
            this.bjd.destroy();
            this.bjd = null;
        }
        this.biS = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.bjd != null) {
            this.bjd.setData(list);
        }
    }

    public void dg(boolean z) {
        this.bcm.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.biS.getLayoutMode().L(i == 1);
        this.biS.getLayoutMode().h(this.aGI);
        this.mNavigationBar.onChangeSkinType(i);
        if (i == 1) {
            this.bjc.setDivider(new ColorDrawable(this.biS.getResources().getColor(com.baidu.tieba.s.night_divider)));
            this.bjc.setDividerHeight(this.biS.getResources().getDimensionPixelSize(t.onedip));
            return;
        }
        this.bjc.setDivider(new ColorDrawable(this.biS.getResources().getColor(com.baidu.tieba.s.day_divider)));
        this.bjc.setDividerHeight(this.biS.getResources().getDimensionPixelSize(t.onedip));
    }

    public ImageView RR() {
        return this.bjb;
    }

    public g RS() {
        return this.bjd;
    }
}
