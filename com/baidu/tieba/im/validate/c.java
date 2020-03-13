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
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View dFb;
    private ProgressBar hFv;
    private ImageView hKC;
    private BdListView hKD;
    private a hKE;
    private ValidateActivity hKw;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.hKw = validateActivity;
        initView();
        this.hKE = new a(this.hKw);
        this.hKD.setAdapter((ListAdapter) this.hKE);
        this.hKD.setOnSrollToBottomListener(this.hKw);
    }

    void initView() {
        this.dFb = View.inflate(this.hKw.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.hKw.setContentView(this.dFb);
        this.mNavigationBar = (NavigationBar) this.hKw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hKw.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hKw.finish();
            }
        });
        this.hKD = (BdListView) this.dFb.findViewById(R.id.validate_list);
        this.hFv = (ProgressBar) this.dFb.findViewById(R.id.pro_load);
        nK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hKE != null) {
            this.hKE.destroy();
            this.hKE = null;
        }
        this.hKw = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.hKE != null) {
            this.hKE.setData(list);
        }
    }

    public void nK(boolean z) {
        this.hFv.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hKw.getLayoutMode().setNightMode(i == 1);
        this.hKw.getLayoutMode().onModeChanged(this.dFb);
        this.mNavigationBar.onChangeSkinType(this.hKw.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.hKD.setDivider(new ColorDrawable(this.hKw.getResources().getColor(R.color.common_color_10179)));
            this.hKD.setDividerHeight(this.hKw.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.hKD.setDivider(new ColorDrawable(this.hKw.getResources().getColor(R.color.common_color_10241)));
        this.hKD.setDividerHeight(this.hKw.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bYs() {
        return this.hKC;
    }

    public a bYt() {
        return this.hKE;
    }
}
