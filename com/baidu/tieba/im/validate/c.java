package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View eWc;
    private ProgressBar eYn;
    private ValidateActivity fdo;
    private ImageView fdu;
    private BdListView fdv;
    private a fdw;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.fdo = validateActivity;
        initView();
        this.fdw = new a(this.fdo);
        this.fdv.setAdapter((ListAdapter) this.fdw);
        this.fdv.setOnSrollToBottomListener(this.fdo);
    }

    void initView() {
        this.eWc = View.inflate(this.fdo.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.fdo.setContentView(this.eWc);
        this.mNavigationBar = (NavigationBar) this.fdo.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fdo.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fdo.finish();
            }
        });
        this.fdv = (BdListView) this.eWc.findViewById(e.g.validate_list);
        this.eYn = (ProgressBar) this.eWc.findViewById(e.g.pro_load);
        iO(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.fdw != null) {
            this.fdw.destroy();
            this.fdw = null;
        }
        this.fdo = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.fdw != null) {
            this.fdw.setData(list);
        }
    }

    public void iO(boolean z) {
        this.eYn.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.fdo.getLayoutMode().setNightMode(i == 1);
        this.fdo.getLayoutMode().onModeChanged(this.eWc);
        this.mNavigationBar.onChangeSkinType(this.fdo.getPageContext(), i);
        if (i == 1) {
            this.fdv.setDivider(new ColorDrawable(this.fdo.getResources().getColor(e.d.common_color_10179)));
            this.fdv.setDividerHeight(this.fdo.getResources().getDimensionPixelSize(e.C0210e.ds2));
            return;
        }
        this.fdv.setDivider(new ColorDrawable(this.fdo.getResources().getColor(e.d.common_color_10241)));
        this.fdv.setDividerHeight(this.fdo.getResources().getDimensionPixelSize(e.C0210e.ds2));
    }

    public ImageView aVN() {
        return this.fdu;
    }

    public a aVO() {
        return this.fdw;
    }
}
