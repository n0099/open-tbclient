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
    private View ebj;
    private ProgressBar edx;
    private ImageView eiF;
    private BdListView eiG;
    private a eiH;
    private ValidateActivity eiz;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eiz = validateActivity;
        initView();
        this.eiH = new a(this.eiz);
        this.eiG.setAdapter((ListAdapter) this.eiH);
        this.eiG.setOnSrollToBottomListener(this.eiz);
    }

    void initView() {
        this.ebj = View.inflate(this.eiz.getPageContext().getPageActivity(), d.i.validate_activity, null);
        this.eiz.setContentView(this.ebj);
        this.mNavigationBar = (NavigationBar) this.eiz.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eiz.getPageContext().getString(d.k.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.eiz.finish();
            }
        });
        this.eiG = (BdListView) this.ebj.findViewById(d.g.validate_list);
        this.edx = (ProgressBar) this.ebj.findViewById(d.g.pro_load);
        hp(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eiH != null) {
            this.eiH.destroy();
            this.eiH = null;
        }
        this.eiz = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eiH != null) {
            this.eiH.setData(list);
        }
    }

    public void hp(boolean z) {
        this.edx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eiz.getLayoutMode().setNightMode(i == 1);
        this.eiz.getLayoutMode().u(this.ebj);
        this.mNavigationBar.onChangeSkinType(this.eiz.getPageContext(), i);
        if (i == 1) {
            this.eiG.setDivider(new ColorDrawable(this.eiz.getResources().getColor(d.C0126d.common_color_10179)));
            this.eiG.setDividerHeight(this.eiz.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eiG.setDivider(new ColorDrawable(this.eiz.getResources().getColor(d.C0126d.common_color_10241)));
        this.eiG.setDividerHeight(this.eiz.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aHm() {
        return this.eiF;
    }

    public a aHn() {
        return this.eiH;
    }
}
