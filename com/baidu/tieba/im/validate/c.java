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
    private View enE;
    private ProgressBar epT;
    private ValidateActivity euX;
    private ImageView evd;
    private BdListView eve;
    private a evf;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.euX = validateActivity;
        initView();
        this.evf = new a(this.euX);
        this.eve.setAdapter((ListAdapter) this.evf);
        this.eve.setOnSrollToBottomListener(this.euX);
    }

    void initView() {
        this.enE = View.inflate(this.euX.getPageContext().getPageActivity(), d.i.validate_activity, null);
        this.euX.setContentView(this.enE);
        this.mNavigationBar = (NavigationBar) this.euX.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.euX.getPageContext().getString(d.k.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.euX.finish();
            }
        });
        this.eve = (BdListView) this.enE.findViewById(d.g.validate_list);
        this.epT = (ProgressBar) this.enE.findViewById(d.g.pro_load);
        hw(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.evf != null) {
            this.evf.destroy();
            this.evf = null;
        }
        this.euX = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.evf != null) {
            this.evf.setData(list);
        }
    }

    public void hw(boolean z) {
        this.epT.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.euX.getLayoutMode().setNightMode(i == 1);
        this.euX.getLayoutMode().onModeChanged(this.enE);
        this.mNavigationBar.onChangeSkinType(this.euX.getPageContext(), i);
        if (i == 1) {
            this.eve.setDivider(new ColorDrawable(this.euX.getResources().getColor(d.C0141d.common_color_10179)));
            this.eve.setDividerHeight(this.euX.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eve.setDivider(new ColorDrawable(this.euX.getResources().getColor(d.C0141d.common_color_10241)));
        this.eve.setDividerHeight(this.euX.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aMf() {
        return this.evd;
    }

    public a aMg() {
        return this.evf;
    }
}
