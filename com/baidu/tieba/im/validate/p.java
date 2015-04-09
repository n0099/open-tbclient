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
    private ValidateActivity bnX;
    private ImageView bod;
    private BdListView boe;
    private h bof;
    private NavigationBar mNavigationBar;
    private View parent;
    private ProgressBar pro_load;

    public p(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.bnX = validateActivity;
        initView();
        this.bof = new h(this.bnX);
        this.boe.setAdapter((ListAdapter) this.bof);
        this.boe.setOnSrollToBottomListener(this.bnX);
    }

    void initView() {
        this.parent = View.inflate(this.bnX.getPageContext().getPageActivity(), w.validate_activity, null);
        this.bnX.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.bnX.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bnX.getPageContext().getString(y.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new q(this));
        this.boe = (BdListView) this.parent.findViewById(v.validate_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(v.pro_load);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.bof != null) {
            this.bof.destroy();
            this.bof = null;
        }
        this.bnX = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.bof != null) {
            this.bof.setData(list);
        }
    }

    public void setLoadProgressBarVisable(boolean z) {
        this.pro_load.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bnX.getLayoutMode().X(i == 1);
        this.bnX.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.bnX.getPageContext(), i);
        if (i == 1) {
            this.boe.setDivider(new ColorDrawable(this.bnX.getResources().getColor(s.night_divider)));
            this.boe.setDividerHeight(this.bnX.getResources().getDimensionPixelSize(t.onedip));
            return;
        }
        this.boe.setDivider(new ColorDrawable(this.bnX.getResources().getColor(s.day_divider)));
        this.boe.setDividerHeight(this.bnX.getResources().getDimensionPixelSize(t.onedip));
    }

    public ImageView TQ() {
        return this.bod;
    }

    public h TR() {
        return this.bof;
    }
}
