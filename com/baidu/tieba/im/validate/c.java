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
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View dAC;
    private ValidateActivity hEG;
    private ImageView hEM;
    private BdListView hEN;
    private a hEO;
    private ProgressBar hzF;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.hEG = validateActivity;
        initView();
        this.hEO = new a(this.hEG);
        this.hEN.setAdapter((ListAdapter) this.hEO);
        this.hEN.setOnSrollToBottomListener(this.hEG);
    }

    void initView() {
        this.dAC = View.inflate(this.hEG.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.hEG.setContentView(this.dAC);
        this.mNavigationBar = (NavigationBar) this.hEG.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hEG.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hEG.finish();
            }
        });
        this.hEN = (BdListView) this.dAC.findViewById(R.id.validate_list);
        this.hzF = (ProgressBar) this.dAC.findViewById(R.id.pro_load);
        nw(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hEO != null) {
            this.hEO.destroy();
            this.hEO = null;
        }
        this.hEG = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.hEO != null) {
            this.hEO.setData(list);
        }
    }

    public void nw(boolean z) {
        this.hzF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hEG.getLayoutMode().setNightMode(i == 1);
        this.hEG.getLayoutMode().onModeChanged(this.dAC);
        this.mNavigationBar.onChangeSkinType(this.hEG.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.hEN.setDivider(new ColorDrawable(this.hEG.getResources().getColor(R.color.common_color_10179)));
            this.hEN.setDividerHeight(this.hEG.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.hEN.setDivider(new ColorDrawable(this.hEG.getResources().getColor(R.color.common_color_10241)));
        this.hEN.setDividerHeight(this.hEG.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bVF() {
        return this.hEM;
    }

    public a bVG() {
        return this.hEO;
    }
}
