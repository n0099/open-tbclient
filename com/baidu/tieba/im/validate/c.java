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
    private View cNq;
    private ProgressBar gMs;
    private BdListView gRA;
    private a gRB;
    private ValidateActivity gRt;
    private ImageView gRz;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gRt = validateActivity;
        initView();
        this.gRB = new a(this.gRt);
        this.gRA.setAdapter((ListAdapter) this.gRB);
        this.gRA.setOnSrollToBottomListener(this.gRt);
    }

    void initView() {
        this.cNq = View.inflate(this.gRt.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gRt.setContentView(this.cNq);
        this.mNavigationBar = (NavigationBar) this.gRt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gRt.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gRt.finish();
            }
        });
        this.gRA = (BdListView) this.cNq.findViewById(R.id.validate_list);
        this.gMs = (ProgressBar) this.cNq.findViewById(R.id.pro_load);
        mj(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gRB != null) {
            this.gRB.destroy();
            this.gRB = null;
        }
        this.gRt = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gRB != null) {
            this.gRB.setData(list);
        }
    }

    public void mj(boolean z) {
        this.gMs.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gRt.getLayoutMode().setNightMode(i == 1);
        this.gRt.getLayoutMode().onModeChanged(this.cNq);
        this.mNavigationBar.onChangeSkinType(this.gRt.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.gRA.setDivider(new ColorDrawable(this.gRt.getResources().getColor(R.color.common_color_10179)));
            this.gRA.setDividerHeight(this.gRt.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gRA.setDivider(new ColorDrawable(this.gRt.getResources().getColor(R.color.common_color_10241)));
        this.gRA.setDividerHeight(this.gRt.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bEv() {
        return this.gRz;
    }

    public a bEw() {
        return this.gRB;
    }
}
