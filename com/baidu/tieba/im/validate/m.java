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
    private ValidateActivity bpQ;
    private ImageView bpW;
    private BdListView bpX;
    private h bpY;
    private NavigationBar mNavigationBar;
    private View parent;
    private ProgressBar pro_load;

    public m(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.bpQ = validateActivity;
        initView();
        this.bpY = new h(this.bpQ);
        this.bpX.setAdapter((ListAdapter) this.bpY);
        this.bpX.setOnSrollToBottomListener(this.bpQ);
    }

    void initView() {
        this.parent = View.inflate(this.bpQ.getPageContext().getPageActivity(), x.validate_activity, null);
        this.bpQ.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.bpQ.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bpQ.getPageContext().getString(z.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        this.bpX = (BdListView) this.parent.findViewById(w.validate_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(w.pro_load);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.bpY != null) {
            this.bpY.destroy();
            this.bpY = null;
        }
        this.bpQ = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.bpY != null) {
            this.bpY.setData(list);
        }
    }

    public void setLoadProgressBarVisable(boolean z) {
        this.pro_load.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bpQ.getLayoutMode().ab(i == 1);
        this.bpQ.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.bpQ.getPageContext(), i);
        if (i == 1) {
            this.bpX.setDivider(new ColorDrawable(this.bpQ.getResources().getColor(t.night_divider)));
            this.bpX.setDividerHeight(this.bpQ.getResources().getDimensionPixelSize(u.onedip));
            return;
        }
        this.bpX.setDivider(new ColorDrawable(this.bpQ.getResources().getColor(t.day_divider)));
        this.bpX.setDividerHeight(this.bpQ.getResources().getDimensionPixelSize(u.onedip));
    }

    public ImageView TD() {
        return this.bpW;
    }

    public h TE() {
        return this.bpY;
    }
}
