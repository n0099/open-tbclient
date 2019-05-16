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
    private View czN;
    private ProgressBar gFu;
    private ImageView gKB;
    private BdListView gKC;
    private a gKD;
    private ValidateActivity gKv;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gKv = validateActivity;
        initView();
        this.gKD = new a(this.gKv);
        this.gKC.setAdapter((ListAdapter) this.gKD);
        this.gKC.setOnSrollToBottomListener(this.gKv);
    }

    void initView() {
        this.czN = View.inflate(this.gKv.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gKv.setContentView(this.czN);
        this.mNavigationBar = (NavigationBar) this.gKv.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gKv.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gKv.finish();
            }
        });
        this.gKC = (BdListView) this.czN.findViewById(R.id.validate_list);
        this.gFu = (ProgressBar) this.czN.findViewById(R.id.pro_load);
        md(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gKD != null) {
            this.gKD.destroy();
            this.gKD = null;
        }
        this.gKv = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gKD != null) {
            this.gKD.setData(list);
        }
    }

    public void md(boolean z) {
        this.gFu.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gKv.getLayoutMode().setNightMode(i == 1);
        this.gKv.getLayoutMode().onModeChanged(this.czN);
        this.mNavigationBar.onChangeSkinType(this.gKv.getPageContext(), i);
        if (i == 1) {
            this.gKC.setDivider(new ColorDrawable(this.gKv.getResources().getColor(R.color.common_color_10179)));
            this.gKC.setDividerHeight(this.gKv.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gKC.setDivider(new ColorDrawable(this.gKv.getResources().getColor(R.color.common_color_10241)));
        this.gKC.setDividerHeight(this.gKv.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bDX() {
        return this.gKB;
    }

    public a bDY() {
        return this.gKD;
    }
}
