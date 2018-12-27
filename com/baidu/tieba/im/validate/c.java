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
    private View eVo;
    private ProgressBar eXz;
    private ValidateActivity fcA;
    private ImageView fcG;
    private BdListView fcH;
    private a fcI;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.fcA = validateActivity;
        initView();
        this.fcI = new a(this.fcA);
        this.fcH.setAdapter((ListAdapter) this.fcI);
        this.fcH.setOnSrollToBottomListener(this.fcA);
    }

    void initView() {
        this.eVo = View.inflate(this.fcA.getPageContext().getPageActivity(), e.h.validate_activity, null);
        this.fcA.setContentView(this.eVo);
        this.mNavigationBar = (NavigationBar) this.fcA.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fcA.getPageContext().getString(e.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fcA.finish();
            }
        });
        this.fcH = (BdListView) this.eVo.findViewById(e.g.validate_list);
        this.eXz = (ProgressBar) this.eVo.findViewById(e.g.pro_load);
        iO(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.fcI != null) {
            this.fcI.destroy();
            this.fcI = null;
        }
        this.fcA = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.fcI != null) {
            this.fcI.setData(list);
        }
    }

    public void iO(boolean z) {
        this.eXz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.fcA.getLayoutMode().setNightMode(i == 1);
        this.fcA.getLayoutMode().onModeChanged(this.eVo);
        this.mNavigationBar.onChangeSkinType(this.fcA.getPageContext(), i);
        if (i == 1) {
            this.fcH.setDivider(new ColorDrawable(this.fcA.getResources().getColor(e.d.common_color_10179)));
            this.fcH.setDividerHeight(this.fcA.getResources().getDimensionPixelSize(e.C0210e.ds2));
            return;
        }
        this.fcH.setDivider(new ColorDrawable(this.fcA.getResources().getColor(e.d.common_color_10241)));
        this.fcH.setDividerHeight(this.fcA.getResources().getDimensionPixelSize(e.C0210e.ds2));
    }

    public ImageView aVn() {
        return this.fcG;
    }

    public a aVo() {
        return this.fcI;
    }
}
