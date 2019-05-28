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
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View czN;
    private ProgressBar gFv;
    private ImageView gKC;
    private BdListView gKD;
    private a gKE;
    private ValidateActivity gKw;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gKw = validateActivity;
        initView();
        this.gKE = new a(this.gKw);
        this.gKD.setAdapter((ListAdapter) this.gKE);
        this.gKD.setOnSrollToBottomListener(this.gKw);
    }

    void initView() {
        this.czN = View.inflate(this.gKw.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gKw.setContentView(this.czN);
        this.mNavigationBar = (NavigationBar) this.gKw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gKw.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gKw.finish();
            }
        });
        this.gKD = (BdListView) this.czN.findViewById(R.id.validate_list);
        this.gFv = (ProgressBar) this.czN.findViewById(R.id.pro_load);
        md(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gKE != null) {
            this.gKE.destroy();
            this.gKE = null;
        }
        this.gKw = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gKE != null) {
            this.gKE.setData(list);
        }
    }

    public void md(boolean z) {
        this.gFv.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gKw.getLayoutMode().setNightMode(i == 1);
        this.gKw.getLayoutMode().onModeChanged(this.czN);
        this.mNavigationBar.onChangeSkinType(this.gKw.getPageContext(), i);
        if (i == 1) {
            this.gKD.setDivider(new ColorDrawable(this.gKw.getResources().getColor(R.color.common_color_10179)));
            this.gKD.setDividerHeight(this.gKw.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gKD.setDivider(new ColorDrawable(this.gKw.getResources().getColor(R.color.common_color_10241)));
        this.gKD.setDividerHeight(this.gKw.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bEa() {
        return this.gKC;
    }

    public a bEb() {
        return this.gKE;
    }
}
