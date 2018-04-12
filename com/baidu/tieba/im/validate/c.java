package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View ebm;
    private ProgressBar edA;
    private ValidateActivity eiC;
    private ImageView eiI;
    private BdListView eiJ;
    private a eiK;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eiC = validateActivity;
        initView();
        this.eiK = new a(this.eiC);
        this.eiJ.setAdapter((ListAdapter) this.eiK);
        this.eiJ.setOnSrollToBottomListener(this.eiC);
    }

    void initView() {
        this.ebm = View.inflate(this.eiC.getPageContext().getPageActivity(), d.i.validate_activity, null);
        this.eiC.setContentView(this.ebm);
        this.mNavigationBar = (NavigationBar) this.eiC.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eiC.getPageContext().getString(d.k.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.eiC.finish();
            }
        });
        this.eiJ = (BdListView) this.ebm.findViewById(d.g.validate_list);
        this.edA = (ProgressBar) this.ebm.findViewById(d.g.pro_load);
        hp(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eiK != null) {
            this.eiK.destroy();
            this.eiK = null;
        }
        this.eiC = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eiK != null) {
            this.eiK.setData(list);
        }
    }

    public void hp(boolean z) {
        this.edA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eiC.getLayoutMode().setNightMode(i == 1);
        this.eiC.getLayoutMode().u(this.ebm);
        this.mNavigationBar.onChangeSkinType(this.eiC.getPageContext(), i);
        if (i == 1) {
            this.eiJ.setDivider(new ColorDrawable(this.eiC.getResources().getColor(d.C0126d.common_color_10179)));
            this.eiJ.setDividerHeight(this.eiC.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eiJ.setDivider(new ColorDrawable(this.eiC.getResources().getColor(d.C0126d.common_color_10241)));
        this.eiJ.setDividerHeight(this.eiC.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aHm() {
        return this.eiI;
    }

    public a aHn() {
        return this.eiK;
    }
}
