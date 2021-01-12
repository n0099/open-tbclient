package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends d<ValidateActivity> {
    private View fIC;
    private ImageView kEC;
    private BdListView kED;
    private a kEE;
    private ValidateActivity kEw;
    private ProgressBar kzA;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kEw = validateActivity;
        initView();
        this.kEE = new a(this.kEw);
        this.kED.setAdapter((ListAdapter) this.kEE);
        this.kED.setOnSrollToBottomListener(this.kEw);
    }

    void initView() {
        this.fIC = View.inflate(this.kEw.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kEw.setContentView(this.fIC);
        this.mNavigationBar = (NavigationBar) this.kEw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kEw.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kEw.finish();
            }
        });
        this.kED = (BdListView) this.fIC.findViewById(R.id.validate_list);
        this.kzA = (ProgressBar) this.fIC.findViewById(R.id.pro_load);
        sJ(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kEE != null) {
            this.kEE.destroy();
            this.kEE = null;
        }
        this.kEw = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kEE != null) {
            this.kEE.setData(list);
        }
    }

    public void sJ(boolean z) {
        this.kzA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kEw.getLayoutMode().setNightMode(i == 1);
        this.kEw.getLayoutMode().onModeChanged(this.fIC);
        this.mNavigationBar.onChangeSkinType(this.kEw.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kED.setDivider(new ColorDrawable(this.kEw.getResources().getColor(R.color.common_color_10179)));
            this.kED.setDividerHeight(this.kEw.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kED.setDivider(new ColorDrawable(this.kEw.getResources().getColor(R.color.common_color_10241)));
        this.kED.setDividerHeight(this.kEw.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cWb() {
        return this.kEC;
    }

    public a cWc() {
        return this.kEE;
    }
}
