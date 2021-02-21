package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<ValidateActivity> {
    private View fKN;
    private ProgressBar kHT;
    private ValidateActivity kMP;
    private ImageView kMV;
    private BdListView kMW;
    private a kMX;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kMP = validateActivity;
        initView();
        this.kMX = new a(this.kMP);
        this.kMW.setAdapter((ListAdapter) this.kMX);
        this.kMW.setOnSrollToBottomListener(this.kMP);
    }

    void initView() {
        this.fKN = View.inflate(this.kMP.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kMP.setContentView(this.fKN);
        this.mNavigationBar = (NavigationBar) this.kMP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kMP.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kMP.finish();
            }
        });
        this.kMW = (BdListView) this.fKN.findViewById(R.id.validate_list);
        this.kHT = (ProgressBar) this.fKN.findViewById(R.id.pro_load);
        sW(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kMX != null) {
            this.kMX.destroy();
            this.kMX = null;
        }
        this.kMP = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kMX != null) {
            this.kMX.setData(list);
        }
    }

    public void sW(boolean z) {
        this.kHT.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kMP.getLayoutMode().setNightMode(i == 1);
        this.kMP.getLayoutMode().onModeChanged(this.fKN);
        this.mNavigationBar.onChangeSkinType(this.kMP.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kMW.setDivider(new ColorDrawable(this.kMP.getResources().getColor(R.color.common_color_10179)));
            this.kMW.setDividerHeight(this.kMP.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kMW.setDivider(new ColorDrawable(this.kMP.getResources().getColor(R.color.common_color_10241)));
        this.kMW.setDividerHeight(this.kMP.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cYg() {
        return this.kMV;
    }

    public a cYh() {
        return this.kMX;
    }
}
