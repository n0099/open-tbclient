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
/* loaded from: classes25.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View eVX;
    private ProgressBar jDh;
    private ValidateActivity jIr;
    private ImageView jIx;
    private BdListView jIy;
    private a jIz;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.jIr = validateActivity;
        initView();
        this.jIz = new a(this.jIr);
        this.jIy.setAdapter((ListAdapter) this.jIz);
        this.jIy.setOnSrollToBottomListener(this.jIr);
    }

    void initView() {
        this.eVX = View.inflate(this.jIr.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.jIr.setContentView(this.eVX);
        this.mNavigationBar = (NavigationBar) this.jIr.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jIr.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.jIr.finish();
            }
        });
        this.jIy = (BdListView) this.eVX.findViewById(R.id.validate_list);
        this.jDh = (ProgressBar) this.eVX.findViewById(R.id.pro_load);
        qX(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jIz != null) {
            this.jIz.destroy();
            this.jIz = null;
        }
        this.jIr = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.jIz != null) {
            this.jIz.setData(list);
        }
    }

    public void qX(boolean z) {
        this.jDh.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jIr.getLayoutMode().setNightMode(i == 1);
        this.jIr.getLayoutMode().onModeChanged(this.eVX);
        this.mNavigationBar.onChangeSkinType(this.jIr.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.jIy.setDivider(new ColorDrawable(this.jIr.getResources().getColor(R.color.common_color_10179)));
            this.jIy.setDividerHeight(this.jIr.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.jIy.setDivider(new ColorDrawable(this.jIr.getResources().getColor(R.color.common_color_10241)));
        this.jIy.setDividerHeight(this.jIr.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cMg() {
        return this.jIx;
    }

    public a cMh() {
        return this.jIz;
    }
}
