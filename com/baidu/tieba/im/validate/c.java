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
    private View ecq;
    private ProgressBar eeE;
    private ValidateActivity ejG;
    private ImageView ejM;
    private BdListView ejN;
    private a ejO;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.ejG = validateActivity;
        initView();
        this.ejO = new a(this.ejG);
        this.ejN.setAdapter((ListAdapter) this.ejO);
        this.ejN.setOnSrollToBottomListener(this.ejG);
    }

    void initView() {
        this.ecq = View.inflate(this.ejG.getPageContext().getPageActivity(), d.i.validate_activity, null);
        this.ejG.setContentView(this.ecq);
        this.mNavigationBar = (NavigationBar) this.ejG.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ejG.getPageContext().getString(d.k.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.ejG.finish();
            }
        });
        this.ejN = (BdListView) this.ecq.findViewById(d.g.validate_list);
        this.eeE = (ProgressBar) this.ecq.findViewById(d.g.pro_load);
        hq(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.ejO != null) {
            this.ejO.destroy();
            this.ejO = null;
        }
        this.ejG = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.ejO != null) {
            this.ejO.setData(list);
        }
    }

    public void hq(boolean z) {
        this.eeE.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.ejG.getLayoutMode().setNightMode(i == 1);
        this.ejG.getLayoutMode().u(this.ecq);
        this.mNavigationBar.onChangeSkinType(this.ejG.getPageContext(), i);
        if (i == 1) {
            this.ejN.setDivider(new ColorDrawable(this.ejG.getResources().getColor(d.C0126d.common_color_10179)));
            this.ejN.setDividerHeight(this.ejG.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.ejN.setDivider(new ColorDrawable(this.ejG.getResources().getColor(d.C0126d.common_color_10241)));
        this.ejN.setDividerHeight(this.ejG.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aHk() {
        return this.ejM;
    }

    public a aHl() {
        return this.ejO;
    }
}
