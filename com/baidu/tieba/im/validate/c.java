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
    private ProgressBar kHF;
    private ValidateActivity kMB;
    private ImageView kMH;
    private BdListView kMI;
    private a kMJ;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kMB = validateActivity;
        initView();
        this.kMJ = new a(this.kMB);
        this.kMI.setAdapter((ListAdapter) this.kMJ);
        this.kMI.setOnSrollToBottomListener(this.kMB);
    }

    void initView() {
        this.fKN = View.inflate(this.kMB.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kMB.setContentView(this.fKN);
        this.mNavigationBar = (NavigationBar) this.kMB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kMB.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kMB.finish();
            }
        });
        this.kMI = (BdListView) this.fKN.findViewById(R.id.validate_list);
        this.kHF = (ProgressBar) this.fKN.findViewById(R.id.pro_load);
        sW(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kMJ != null) {
            this.kMJ.destroy();
            this.kMJ = null;
        }
        this.kMB = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kMJ != null) {
            this.kMJ.setData(list);
        }
    }

    public void sW(boolean z) {
        this.kHF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kMB.getLayoutMode().setNightMode(i == 1);
        this.kMB.getLayoutMode().onModeChanged(this.fKN);
        this.mNavigationBar.onChangeSkinType(this.kMB.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kMI.setDivider(new ColorDrawable(this.kMB.getResources().getColor(R.color.common_color_10179)));
            this.kMI.setDividerHeight(this.kMB.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kMI.setDivider(new ColorDrawable(this.kMB.getResources().getColor(R.color.common_color_10241)));
        this.kMI.setDividerHeight(this.kMB.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cXZ() {
        return this.kMH;
    }

    public a cYa() {
        return this.kMJ;
    }
}
