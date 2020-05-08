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
    private View efd;
    private ProgressBar iqR;
    private ValidateActivity ivS;
    private ImageView ivY;
    private BdListView ivZ;
    private a iwa;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.ivS = validateActivity;
        initView();
        this.iwa = new a(this.ivS);
        this.ivZ.setAdapter((ListAdapter) this.iwa);
        this.ivZ.setOnSrollToBottomListener(this.ivS);
    }

    void initView() {
        this.efd = View.inflate(this.ivS.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.ivS.setContentView(this.efd);
        this.mNavigationBar = (NavigationBar) this.ivS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ivS.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ivS.finish();
            }
        });
        this.ivZ = (BdListView) this.efd.findViewById(R.id.validate_list);
        this.iqR = (ProgressBar) this.efd.findViewById(R.id.pro_load);
        oU(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iwa != null) {
            this.iwa.destroy();
            this.iwa = null;
        }
        this.ivS = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.iwa != null) {
            this.iwa.setData(list);
        }
    }

    public void oU(boolean z) {
        this.iqR.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.ivS.getLayoutMode().setNightMode(i == 1);
        this.ivS.getLayoutMode().onModeChanged(this.efd);
        this.mNavigationBar.onChangeSkinType(this.ivS.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.ivZ.setDivider(new ColorDrawable(this.ivS.getResources().getColor(R.color.common_color_10179)));
            this.ivZ.setDividerHeight(this.ivS.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.ivZ.setDivider(new ColorDrawable(this.ivS.getResources().getColor(R.color.common_color_10241)));
        this.ivZ.setDividerHeight(this.ivS.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cjj() {
        return this.ivY;
    }

    public a cjk() {
        return this.iwa;
    }
}
