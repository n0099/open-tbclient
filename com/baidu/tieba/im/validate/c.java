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
    private View bMz;
    private ProgressBar eIR;
    private ValidateActivity eNS;
    private ImageView eNY;
    private BdListView eNZ;
    private a eOa;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eNS = validateActivity;
        initView();
        this.eOa = new a(this.eNS);
        this.eNZ.setAdapter((ListAdapter) this.eOa);
        this.eNZ.setOnSrollToBottomListener(this.eNS);
    }

    void initView() {
        this.bMz = View.inflate(this.eNS.getPageContext().getPageActivity(), d.h.validate_activity, null);
        this.eNS.setContentView(this.bMz);
        this.mNavigationBar = (NavigationBar) this.eNS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eNS.getPageContext().getString(d.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eNS.finish();
            }
        });
        this.eNZ = (BdListView) this.bMz.findViewById(d.g.validate_list);
        this.eIR = (ProgressBar) this.bMz.findViewById(d.g.pro_load);
        hK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eOa != null) {
            this.eOa.destroy();
            this.eOa = null;
        }
        this.eNS = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eOa != null) {
            this.eOa.setData(list);
        }
    }

    public void hK(boolean z) {
        this.eIR.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eNS.getLayoutMode().aQ(i == 1);
        this.eNS.getLayoutMode().aM(this.bMz);
        this.mNavigationBar.onChangeSkinType(this.eNS.getPageContext(), i);
        if (i == 1) {
            this.eNZ.setDivider(new ColorDrawable(this.eNS.getResources().getColor(d.C0140d.common_color_10179)));
            this.eNZ.setDividerHeight(this.eNS.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.eNZ.setDivider(new ColorDrawable(this.eNS.getResources().getColor(d.C0140d.common_color_10241)));
        this.eNZ.setDividerHeight(this.eNS.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView aMm() {
        return this.eNY;
    }

    public a aMn() {
        return this.eOa;
    }
}
