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
    private View dFr;
    private ProgressBar hGV;
    private ValidateActivity hLW;
    private ImageView hMc;
    private BdListView hMd;
    private a hMe;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.hLW = validateActivity;
        initView();
        this.hMe = new a(this.hLW);
        this.hMd.setAdapter((ListAdapter) this.hMe);
        this.hMd.setOnSrollToBottomListener(this.hLW);
    }

    void initView() {
        this.dFr = View.inflate(this.hLW.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.hLW.setContentView(this.dFr);
        this.mNavigationBar = (NavigationBar) this.hLW.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hLW.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hLW.finish();
            }
        });
        this.hMd = (BdListView) this.dFr.findViewById(R.id.validate_list);
        this.hGV = (ProgressBar) this.dFr.findViewById(R.id.pro_load);
        nQ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hMe != null) {
            this.hMe.destroy();
            this.hMe = null;
        }
        this.hLW = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.hMe != null) {
            this.hMe.setData(list);
        }
    }

    public void nQ(boolean z) {
        this.hGV.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hLW.getLayoutMode().setNightMode(i == 1);
        this.hLW.getLayoutMode().onModeChanged(this.dFr);
        this.mNavigationBar.onChangeSkinType(this.hLW.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.hMd.setDivider(new ColorDrawable(this.hLW.getResources().getColor(R.color.common_color_10179)));
            this.hMd.setDividerHeight(this.hLW.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.hMd.setDivider(new ColorDrawable(this.hLW.getResources().getColor(R.color.common_color_10241)));
        this.hMd.setDividerHeight(this.hLW.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bYK() {
        return this.hMc;
    }

    public a bYL() {
        return this.hMe;
    }
}
