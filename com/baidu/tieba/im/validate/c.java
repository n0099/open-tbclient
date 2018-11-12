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
    private View eLI;
    private ProgressBar eNT;
    private ValidateActivity eSU;
    private ImageView eTa;
    private BdListView eTb;
    private a eTc;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eSU = validateActivity;
        initView();
        this.eTc = new a(this.eSU);
        this.eTb.setAdapter((ListAdapter) this.eTc);
        this.eTb.setOnSrollToBottomListener(this.eSU);
    }

    void initView() {
        this.eLI = View.inflate(this.eSU.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.eSU.setContentView(this.eLI);
        this.mNavigationBar = (NavigationBar) this.eSU.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eSU.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eSU.finish();
            }
        });
        this.eTb = (BdListView) this.eLI.findViewById(e.g.validate_list);
        this.eNT = (ProgressBar) this.eLI.findViewById(e.g.pro_load);
        iI(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eTc != null) {
            this.eTc.destroy();
            this.eTc = null;
        }
        this.eSU = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eTc != null) {
            this.eTc.setData(list);
        }
    }

    public void iI(boolean z) {
        this.eNT.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eSU.getLayoutMode().setNightMode(i == 1);
        this.eSU.getLayoutMode().onModeChanged(this.eLI);
        this.mNavigationBar.onChangeSkinType(this.eSU.getPageContext(), i);
        if (i == 1) {
            this.eTb.setDivider(new ColorDrawable(this.eSU.getResources().getColor(e.d.common_color_10179)));
            this.eTb.setDividerHeight(this.eSU.getResources().getDimensionPixelSize(e.C0200e.ds2));
            return;
        }
        this.eTb.setDivider(new ColorDrawable(this.eSU.getResources().getColor(e.d.common_color_10241)));
        this.eTb.setDividerHeight(this.eSU.getResources().getDimensionPixelSize(e.C0200e.ds2));
    }

    public ImageView aSI() {
        return this.eTa;
    }

    public a aSJ() {
        return this.eTc;
    }
}
