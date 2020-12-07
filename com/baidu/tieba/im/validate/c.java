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
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View fDE;
    private ValidateActivity kDQ;
    private ImageView kDW;
    private BdListView kDX;
    private a kDY;
    private ProgressBar kyH;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kDQ = validateActivity;
        initView();
        this.kDY = new a(this.kDQ);
        this.kDX.setAdapter((ListAdapter) this.kDY);
        this.kDX.setOnSrollToBottomListener(this.kDQ);
    }

    void initView() {
        this.fDE = View.inflate(this.kDQ.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kDQ.setContentView(this.fDE);
        this.mNavigationBar = (NavigationBar) this.kDQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kDQ.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kDQ.finish();
            }
        });
        this.kDX = (BdListView) this.fDE.findViewById(R.id.validate_list);
        this.kyH = (ProgressBar) this.fDE.findViewById(R.id.pro_load);
        sJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kDY != null) {
            this.kDY.destroy();
            this.kDY = null;
        }
        this.kDQ = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kDY != null) {
            this.kDY.setData(list);
        }
    }

    public void sJ(boolean z) {
        this.kyH.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kDQ.getLayoutMode().setNightMode(i == 1);
        this.kDQ.getLayoutMode().onModeChanged(this.fDE);
        this.mNavigationBar.onChangeSkinType(this.kDQ.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kDX.setDivider(new ColorDrawable(this.kDQ.getResources().getColor(R.color.common_color_10179)));
            this.kDX.setDividerHeight(this.kDQ.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kDX.setDivider(new ColorDrawable(this.kDQ.getResources().getColor(R.color.common_color_10241)));
        this.kDX.setDividerHeight(this.kDQ.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView dao() {
        return this.kDW;
    }

    public a dap() {
        return this.kDY;
    }
}
