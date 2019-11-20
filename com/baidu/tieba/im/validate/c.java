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
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View cMz;
    private ProgressBar gLB;
    private ValidateActivity gQC;
    private ImageView gQI;
    private BdListView gQJ;
    private a gQK;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gQC = validateActivity;
        initView();
        this.gQK = new a(this.gQC);
        this.gQJ.setAdapter((ListAdapter) this.gQK);
        this.gQJ.setOnSrollToBottomListener(this.gQC);
    }

    void initView() {
        this.cMz = View.inflate(this.gQC.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gQC.setContentView(this.cMz);
        this.mNavigationBar = (NavigationBar) this.gQC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gQC.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gQC.finish();
            }
        });
        this.gQJ = (BdListView) this.cMz.findViewById(R.id.validate_list);
        this.gLB = (ProgressBar) this.cMz.findViewById(R.id.pro_load);
        mj(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gQK != null) {
            this.gQK.destroy();
            this.gQK = null;
        }
        this.gQC = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gQK != null) {
            this.gQK.setData(list);
        }
    }

    public void mj(boolean z) {
        this.gLB.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gQC.getLayoutMode().setNightMode(i == 1);
        this.gQC.getLayoutMode().onModeChanged(this.cMz);
        this.mNavigationBar.onChangeSkinType(this.gQC.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.gQJ.setDivider(new ColorDrawable(this.gQC.getResources().getColor(R.color.common_color_10179)));
            this.gQJ.setDividerHeight(this.gQC.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gQJ.setDivider(new ColorDrawable(this.gQC.getResources().getColor(R.color.common_color_10241)));
        this.gQJ.setDividerHeight(this.gQC.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bEt() {
        return this.gQI;
    }

    public a bEu() {
        return this.gQK;
    }
}
