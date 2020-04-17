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
    private View eeY;
    private ProgressBar iqL;
    private ValidateActivity ivM;
    private ImageView ivS;
    private BdListView ivT;
    private a ivU;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.ivM = validateActivity;
        initView();
        this.ivU = new a(this.ivM);
        this.ivT.setAdapter((ListAdapter) this.ivU);
        this.ivT.setOnSrollToBottomListener(this.ivM);
    }

    void initView() {
        this.eeY = View.inflate(this.ivM.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.ivM.setContentView(this.eeY);
        this.mNavigationBar = (NavigationBar) this.ivM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ivM.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ivM.finish();
            }
        });
        this.ivT = (BdListView) this.eeY.findViewById(R.id.validate_list);
        this.iqL = (ProgressBar) this.eeY.findViewById(R.id.pro_load);
        oU(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.ivU != null) {
            this.ivU.destroy();
            this.ivU = null;
        }
        this.ivM = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.ivU != null) {
            this.ivU.setData(list);
        }
    }

    public void oU(boolean z) {
        this.iqL.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.ivM.getLayoutMode().setNightMode(i == 1);
        this.ivM.getLayoutMode().onModeChanged(this.eeY);
        this.mNavigationBar.onChangeSkinType(this.ivM.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.ivT.setDivider(new ColorDrawable(this.ivM.getResources().getColor(R.color.common_color_10179)));
            this.ivT.setDividerHeight(this.ivM.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.ivT.setDivider(new ColorDrawable(this.ivM.getResources().getColor(R.color.common_color_10241)));
        this.ivT.setDividerHeight(this.ivM.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cjl() {
        return this.ivS;
    }

    public a cjm() {
        return this.ivU;
    }
}
