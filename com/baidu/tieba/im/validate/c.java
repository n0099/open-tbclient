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
    private View cBl;
    private ProgressBar gMz;
    private ValidateActivity gRA;
    private ImageView gRG;
    private BdListView gRH;
    private a gRI;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gRA = validateActivity;
        initView();
        this.gRI = new a(this.gRA);
        this.gRH.setAdapter((ListAdapter) this.gRI);
        this.gRH.setOnSrollToBottomListener(this.gRA);
    }

    void initView() {
        this.cBl = View.inflate(this.gRA.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gRA.setContentView(this.cBl);
        this.mNavigationBar = (NavigationBar) this.gRA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gRA.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gRA.finish();
            }
        });
        this.gRH = (BdListView) this.cBl.findViewById(R.id.validate_list);
        this.gMz = (ProgressBar) this.cBl.findViewById(R.id.pro_load);
        ms(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gRI != null) {
            this.gRI.destroy();
            this.gRI = null;
        }
        this.gRA = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gRI != null) {
            this.gRI.setData(list);
        }
    }

    public void ms(boolean z) {
        this.gMz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gRA.getLayoutMode().setNightMode(i == 1);
        this.gRA.getLayoutMode().onModeChanged(this.cBl);
        this.mNavigationBar.onChangeSkinType(this.gRA.getPageContext(), i);
        if (i == 1) {
            this.gRH.setDivider(new ColorDrawable(this.gRA.getResources().getColor(R.color.common_color_10179)));
            this.gRH.setDividerHeight(this.gRA.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gRH.setDivider(new ColorDrawable(this.gRA.getResources().getColor(R.color.common_color_10241)));
        this.gRH.setDividerHeight(this.gRA.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bGW() {
        return this.gRG;
    }

    public a bGX() {
        return this.gRI;
    }
}
