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
    private View dEO;
    private ProgressBar hFj;
    private ValidateActivity hKk;
    private ImageView hKq;
    private BdListView hKr;
    private a hKs;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.hKk = validateActivity;
        initView();
        this.hKs = new a(this.hKk);
        this.hKr.setAdapter((ListAdapter) this.hKs);
        this.hKr.setOnSrollToBottomListener(this.hKk);
    }

    void initView() {
        this.dEO = View.inflate(this.hKk.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.hKk.setContentView(this.dEO);
        this.mNavigationBar = (NavigationBar) this.hKk.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hKk.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hKk.finish();
            }
        });
        this.hKr = (BdListView) this.dEO.findViewById(R.id.validate_list);
        this.hFj = (ProgressBar) this.dEO.findViewById(R.id.pro_load);
        nK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hKs != null) {
            this.hKs.destroy();
            this.hKs = null;
        }
        this.hKk = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.hKs != null) {
            this.hKs.setData(list);
        }
    }

    public void nK(boolean z) {
        this.hFj.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hKk.getLayoutMode().setNightMode(i == 1);
        this.hKk.getLayoutMode().onModeChanged(this.dEO);
        this.mNavigationBar.onChangeSkinType(this.hKk.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.hKr.setDivider(new ColorDrawable(this.hKk.getResources().getColor(R.color.common_color_10179)));
            this.hKr.setDividerHeight(this.hKk.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.hKr.setDivider(new ColorDrawable(this.hKk.getResources().getColor(R.color.common_color_10241)));
        this.hKr.setDividerHeight(this.hKk.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bYr() {
        return this.hKq;
    }

    public a bYs() {
        return this.hKs;
    }
}
