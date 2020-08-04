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
    private View eIx;
    private ProgressBar jfz;
    private ValidateActivity jkK;
    private ImageView jkQ;
    private BdListView jkR;
    private a jkS;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.jkK = validateActivity;
        initView();
        this.jkS = new a(this.jkK);
        this.jkR.setAdapter((ListAdapter) this.jkS);
        this.jkR.setOnSrollToBottomListener(this.jkK);
    }

    void initView() {
        this.eIx = View.inflate(this.jkK.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.jkK.setContentView(this.eIx);
        this.mNavigationBar = (NavigationBar) this.jkK.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jkK.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.jkK.finish();
            }
        });
        this.jkR = (BdListView) this.eIx.findViewById(R.id.validate_list);
        this.jfz = (ProgressBar) this.eIx.findViewById(R.id.pro_load);
        qh(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jkS != null) {
            this.jkS.destroy();
            this.jkS = null;
        }
        this.jkK = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.jkS != null) {
            this.jkS.setData(list);
        }
    }

    public void qh(boolean z) {
        this.jfz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jkK.getLayoutMode().setNightMode(i == 1);
        this.jkK.getLayoutMode().onModeChanged(this.eIx);
        this.mNavigationBar.onChangeSkinType(this.jkK.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.jkR.setDivider(new ColorDrawable(this.jkK.getResources().getColor(R.color.common_color_10179)));
            this.jkR.setDividerHeight(this.jkK.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.jkR.setDivider(new ColorDrawable(this.jkK.getResources().getColor(R.color.common_color_10241)));
        this.jkR.setDividerHeight(this.jkK.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cxI() {
        return this.jkQ;
    }

    public a cxJ() {
        return this.jkS;
    }
}
