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
    private View fvP;
    private ProgressBar kll;
    private ImageView kqA;
    private BdListView kqB;
    private a kqC;
    private ValidateActivity kqu;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kqu = validateActivity;
        initView();
        this.kqC = new a(this.kqu);
        this.kqB.setAdapter((ListAdapter) this.kqC);
        this.kqB.setOnSrollToBottomListener(this.kqu);
    }

    void initView() {
        this.fvP = View.inflate(this.kqu.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kqu.setContentView(this.fvP);
        this.mNavigationBar = (NavigationBar) this.kqu.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kqu.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kqu.finish();
            }
        });
        this.kqB = (BdListView) this.fvP.findViewById(R.id.validate_list);
        this.kll = (ProgressBar) this.fvP.findViewById(R.id.pro_load);
        sh(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kqC != null) {
            this.kqC.destroy();
            this.kqC = null;
        }
        this.kqu = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kqC != null) {
            this.kqC.setData(list);
        }
    }

    public void sh(boolean z) {
        this.kll.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kqu.getLayoutMode().setNightMode(i == 1);
        this.kqu.getLayoutMode().onModeChanged(this.fvP);
        this.mNavigationBar.onChangeSkinType(this.kqu.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kqB.setDivider(new ColorDrawable(this.kqu.getResources().getColor(R.color.common_color_10179)));
            this.kqB.setDividerHeight(this.kqu.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kqB.setDivider(new ColorDrawable(this.kqu.getResources().getColor(R.color.common_color_10241)));
        this.kqB.setDividerHeight(this.kqu.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cVc() {
        return this.kqA;
    }

    public a cVd() {
        return this.kqC;
    }
}
