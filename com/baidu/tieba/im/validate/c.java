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
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View fwA;
    private ProgressBar kkB;
    private ValidateActivity kpK;
    private ImageView kpQ;
    private BdListView kpR;
    private a kpS;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kpK = validateActivity;
        initView();
        this.kpS = new a(this.kpK);
        this.kpR.setAdapter((ListAdapter) this.kpS);
        this.kpR.setOnSrollToBottomListener(this.kpK);
    }

    void initView() {
        this.fwA = View.inflate(this.kpK.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kpK.setContentView(this.fwA);
        this.mNavigationBar = (NavigationBar) this.kpK.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kpK.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kpK.finish();
            }
        });
        this.kpR = (BdListView) this.fwA.findViewById(R.id.validate_list);
        this.kkB = (ProgressBar) this.fwA.findViewById(R.id.pro_load);
        se(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kpS != null) {
            this.kpS.destroy();
            this.kpS = null;
        }
        this.kpK = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kpS != null) {
            this.kpS.setData(list);
        }
    }

    public void se(boolean z) {
        this.kkB.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kpK.getLayoutMode().setNightMode(i == 1);
        this.kpK.getLayoutMode().onModeChanged(this.fwA);
        this.mNavigationBar.onChangeSkinType(this.kpK.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kpR.setDivider(new ColorDrawable(this.kpK.getResources().getColor(R.color.common_color_10179)));
            this.kpR.setDividerHeight(this.kpK.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kpR.setDivider(new ColorDrawable(this.kpK.getResources().getColor(R.color.common_color_10241)));
        this.kpR.setDividerHeight(this.kpK.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cVw() {
        return this.kpQ;
    }

    public a cVx() {
        return this.kpS;
    }
}
