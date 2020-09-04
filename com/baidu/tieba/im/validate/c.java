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
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View eTh;
    private ProgressBar juF;
    private ValidateActivity jzP;
    private ImageView jzV;
    private BdListView jzW;
    private a jzX;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.jzP = validateActivity;
        initView();
        this.jzX = new a(this.jzP);
        this.jzW.setAdapter((ListAdapter) this.jzX);
        this.jzW.setOnSrollToBottomListener(this.jzP);
    }

    void initView() {
        this.eTh = View.inflate(this.jzP.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.jzP.setContentView(this.eTh);
        this.mNavigationBar = (NavigationBar) this.jzP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jzP.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.jzP.finish();
            }
        });
        this.jzW = (BdListView) this.eTh.findViewById(R.id.validate_list);
        this.juF = (ProgressBar) this.eTh.findViewById(R.id.pro_load);
        qP(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jzX != null) {
            this.jzX.destroy();
            this.jzX = null;
        }
        this.jzP = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.jzX != null) {
            this.jzX.setData(list);
        }
    }

    public void qP(boolean z) {
        this.juF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jzP.getLayoutMode().setNightMode(i == 1);
        this.jzP.getLayoutMode().onModeChanged(this.eTh);
        this.mNavigationBar.onChangeSkinType(this.jzP.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.jzW.setDivider(new ColorDrawable(this.jzP.getResources().getColor(R.color.common_color_10179)));
            this.jzW.setDividerHeight(this.jzP.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.jzW.setDivider(new ColorDrawable(this.jzP.getResources().getColor(R.color.common_color_10241)));
        this.jzW.setDividerHeight(this.jzP.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cIA() {
        return this.jzV;
    }

    public a cIB() {
        return this.jzX;
    }
}
