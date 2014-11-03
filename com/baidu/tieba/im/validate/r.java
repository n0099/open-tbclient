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
    private View aGS;
    private ProgressBar bcA;
    private ValidateActivity bjg;
    private ImageView bjp;
    private BdListView bjq;
    private g bjr;
    private NavigationBar mNavigationBar;

    public r(ValidateActivity validateActivity) {
        super(validateActivity);
        this.bjg = validateActivity;
        nu();
        this.bjr = new g(this.bjg);
        this.bjq.setAdapter((ListAdapter) this.bjr);
        this.bjq.setOnSrollToBottomListener(this.bjg);
    }

    void nu() {
        this.aGS = View.inflate(this.bjg, w.validate_activity, null);
        this.bjg.setContentView(this.aGS);
        this.mNavigationBar = (NavigationBar) this.bjg.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bjg.getString(y.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        this.bjq = (BdListView) this.aGS.findViewById(v.validate_list);
        this.bcA = (ProgressBar) this.aGS.findViewById(v.pro_load);
        dg(false);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        super.destroy();
        if (this.bjr != null) {
            this.bjr.destroy();
            this.bjr = null;
        }
        this.bjg = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.bjr != null) {
            this.bjr.setData(list);
        }
    }

    public void dg(boolean z) {
        this.bcA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bjg.getLayoutMode().L(i == 1);
        this.bjg.getLayoutMode().h(this.aGS);
        this.mNavigationBar.onChangeSkinType(i);
        if (i == 1) {
            this.bjq.setDivider(new ColorDrawable(this.bjg.getResources().getColor(com.baidu.tieba.s.night_divider)));
            this.bjq.setDividerHeight(this.bjg.getResources().getDimensionPixelSize(t.onedip));
            return;
        }
        this.bjq.setDivider(new ColorDrawable(this.bjg.getResources().getColor(com.baidu.tieba.s.day_divider)));
        this.bjq.setDividerHeight(this.bjg.getResources().getDimensionPixelSize(t.onedip));
    }

    public ImageView RU() {
        return this.bjp;
    }

    public g RV() {
        return this.bjr;
    }
}
