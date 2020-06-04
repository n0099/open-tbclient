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
    private View etr;
    private ProgressBar iGk;
    private ValidateActivity iLl;
    private ImageView iLr;
    private BdListView iLs;
    private a iLt;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.iLl = validateActivity;
        initView();
        this.iLt = new a(this.iLl);
        this.iLs.setAdapter((ListAdapter) this.iLt);
        this.iLs.setOnSrollToBottomListener(this.iLl);
    }

    void initView() {
        this.etr = View.inflate(this.iLl.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.iLl.setContentView(this.etr);
        this.mNavigationBar = (NavigationBar) this.iLl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iLl.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.iLl.finish();
            }
        });
        this.iLs = (BdListView) this.etr.findViewById(R.id.validate_list);
        this.iGk = (ProgressBar) this.etr.findViewById(R.id.pro_load);
        pq(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iLt != null) {
            this.iLt.destroy();
            this.iLt = null;
        }
        this.iLl = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.iLt != null) {
            this.iLt.setData(list);
        }
    }

    public void pq(boolean z) {
        this.iGk.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.iLl.getLayoutMode().setNightMode(i == 1);
        this.iLl.getLayoutMode().onModeChanged(this.etr);
        this.mNavigationBar.onChangeSkinType(this.iLl.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.iLs.setDivider(new ColorDrawable(this.iLl.getResources().getColor(R.color.common_color_10179)));
            this.iLs.setDividerHeight(this.iLl.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.iLs.setDivider(new ColorDrawable(this.iLl.getResources().getColor(R.color.common_color_10241)));
        this.iLs.setDividerHeight(this.iLl.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cpQ() {
        return this.iLr;
    }

    public a cpR() {
        return this.iLt;
    }
}
