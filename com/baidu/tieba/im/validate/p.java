package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.g<ValidateActivity> {
    private ValidateActivity bnH;
    private ImageView bnN;
    private BdListView bnO;
    private h bnP;
    private NavigationBar mNavigationBar;
    private View parent;
    private ProgressBar pro_load;

    public p(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.bnH = validateActivity;
        initView();
        this.bnP = new h(this.bnH);
        this.bnO.setAdapter((ListAdapter) this.bnP);
        this.bnO.setOnSrollToBottomListener(this.bnH);
    }

    void initView() {
        this.parent = View.inflate(this.bnH.getPageContext().getPageActivity(), w.validate_activity, null);
        this.bnH.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.bnH.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bnH.getPageContext().getString(y.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new q(this));
        this.bnO = (BdListView) this.parent.findViewById(v.validate_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(v.pro_load);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.bnP != null) {
            this.bnP.destroy();
            this.bnP = null;
        }
        this.bnH = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.bnP != null) {
            this.bnP.setData(list);
        }
    }

    public void setLoadProgressBarVisable(boolean z) {
        this.pro_load.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bnH.getLayoutMode().X(i == 1);
        this.bnH.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.bnH.getPageContext(), i);
        if (i == 1) {
            this.bnO.setDivider(new ColorDrawable(this.bnH.getResources().getColor(s.night_divider)));
            this.bnO.setDividerHeight(this.bnH.getResources().getDimensionPixelSize(t.onedip));
            return;
        }
        this.bnO.setDivider(new ColorDrawable(this.bnH.getResources().getColor(s.day_divider)));
        this.bnO.setDividerHeight(this.bnH.getResources().getDimensionPixelSize(t.onedip));
    }

    public ImageView TD() {
        return this.bnN;
    }

    public h TE() {
        return this.bnP;
    }
}
