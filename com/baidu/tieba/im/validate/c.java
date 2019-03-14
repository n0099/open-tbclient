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
    private View crF;
    private ProgressBar got;
    private ImageView gtA;
    private BdListView gtB;
    private a gtC;
    private ValidateActivity gtu;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gtu = validateActivity;
        initView();
        this.gtC = new a(this.gtu);
        this.gtB.setAdapter((ListAdapter) this.gtC);
        this.gtB.setOnSrollToBottomListener(this.gtu);
    }

    void initView() {
        this.crF = View.inflate(this.gtu.getPageContext().getPageActivity(), d.h.validate_activity, null);
        this.gtu.setContentView(this.crF);
        this.mNavigationBar = (NavigationBar) this.gtu.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gtu.getPageContext().getString(d.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gtu.finish();
            }
        });
        this.gtB = (BdListView) this.crF.findViewById(d.g.validate_list);
        this.got = (ProgressBar) this.crF.findViewById(d.g.pro_load);
        lo(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gtC != null) {
            this.gtC.destroy();
            this.gtC = null;
        }
        this.gtu = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gtC != null) {
            this.gtC.setData(list);
        }
    }

    public void lo(boolean z) {
        this.got.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gtu.getLayoutMode().setNightMode(i == 1);
        this.gtu.getLayoutMode().onModeChanged(this.crF);
        this.mNavigationBar.onChangeSkinType(this.gtu.getPageContext(), i);
        if (i == 1) {
            this.gtB.setDivider(new ColorDrawable(this.gtu.getResources().getColor(d.C0277d.common_color_10179)));
            this.gtB.setDividerHeight(this.gtu.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.gtB.setDivider(new ColorDrawable(this.gtu.getResources().getColor(d.C0277d.common_color_10241)));
        this.gtB.setDividerHeight(this.gtu.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView bws() {
        return this.gtA;
    }

    public a bwt() {
        return this.gtC;
    }
}
