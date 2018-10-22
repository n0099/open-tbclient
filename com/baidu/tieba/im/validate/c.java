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
    private View eKq;
    private ProgressBar eMB;
    private ValidateActivity eRC;
    private ImageView eRI;
    private BdListView eRJ;
    private a eRK;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.eRC = validateActivity;
        initView();
        this.eRK = new a(this.eRC);
        this.eRJ.setAdapter((ListAdapter) this.eRK);
        this.eRJ.setOnSrollToBottomListener(this.eRC);
    }

    void initView() {
        this.eKq = View.inflate(this.eRC.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.eRC.setContentView(this.eKq);
        this.mNavigationBar = (NavigationBar) this.eRC.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eRC.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eRC.finish();
            }
        });
        this.eRJ = (BdListView) this.eKq.findViewById(e.g.validate_list);
        this.eMB = (ProgressBar) this.eKq.findViewById(e.g.pro_load);
        iz(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eRK != null) {
            this.eRK.destroy();
            this.eRK = null;
        }
        this.eRC = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.eRK != null) {
            this.eRK.setData(list);
        }
    }

    public void iz(boolean z) {
        this.eMB.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eRC.getLayoutMode().setNightMode(i == 1);
        this.eRC.getLayoutMode().onModeChanged(this.eKq);
        this.mNavigationBar.onChangeSkinType(this.eRC.getPageContext(), i);
        if (i == 1) {
            this.eRJ.setDivider(new ColorDrawable(this.eRC.getResources().getColor(e.d.common_color_10179)));
            this.eRJ.setDividerHeight(this.eRC.getResources().getDimensionPixelSize(e.C0175e.ds2));
            return;
        }
        this.eRJ.setDivider(new ColorDrawable(this.eRC.getResources().getColor(e.d.common_color_10241)));
        this.eRJ.setDividerHeight(this.eRC.getResources().getDimensionPixelSize(e.C0175e.ds2));
    }

    public ImageView aTl() {
        return this.eRI;
    }

    public a aTm() {
        return this.eRK;
    }
}
