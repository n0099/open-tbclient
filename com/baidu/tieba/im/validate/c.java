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
    private View bMm;
    private ProgressBar eIF;
    private ValidateActivity eNG;
    private ImageView eNM;
    private BdListView eNN;
    private a eNO;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eNG = validateActivity;
        initView();
        this.eNO = new a(this.eNG);
        this.eNN.setAdapter((ListAdapter) this.eNO);
        this.eNN.setOnSrollToBottomListener(this.eNG);
    }

    void initView() {
        this.bMm = View.inflate(this.eNG.getPageContext().getPageActivity(), d.h.validate_activity, null);
        this.eNG.setContentView(this.bMm);
        this.mNavigationBar = (NavigationBar) this.eNG.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eNG.getPageContext().getString(d.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eNG.finish();
            }
        });
        this.eNN = (BdListView) this.bMm.findViewById(d.g.validate_list);
        this.eIF = (ProgressBar) this.bMm.findViewById(d.g.pro_load);
        hK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eNO != null) {
            this.eNO.destroy();
            this.eNO = null;
        }
        this.eNG = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eNO != null) {
            this.eNO.setData(list);
        }
    }

    public void hK(boolean z) {
        this.eIF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eNG.getLayoutMode().aQ(i == 1);
        this.eNG.getLayoutMode().aM(this.bMm);
        this.mNavigationBar.onChangeSkinType(this.eNG.getPageContext(), i);
        if (i == 1) {
            this.eNN.setDivider(new ColorDrawable(this.eNG.getResources().getColor(d.C0141d.common_color_10179)));
            this.eNN.setDividerHeight(this.eNG.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eNN.setDivider(new ColorDrawable(this.eNG.getResources().getColor(d.C0141d.common_color_10241)));
        this.eNN.setDividerHeight(this.eNG.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aMl() {
        return this.eNM;
    }

    public a aMm() {
        return this.eNO;
    }
}
