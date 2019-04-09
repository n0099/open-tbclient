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
    private View crI;
    private ProgressBar goh;
    private ValidateActivity gti;
    private ImageView gto;
    private BdListView gtp;
    private a gtq;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gti = validateActivity;
        initView();
        this.gtq = new a(this.gti);
        this.gtp.setAdapter((ListAdapter) this.gtq);
        this.gtp.setOnSrollToBottomListener(this.gti);
    }

    void initView() {
        this.crI = View.inflate(this.gti.getPageContext().getPageActivity(), d.h.validate_activity, null);
        this.gti.setContentView(this.crI);
        this.mNavigationBar = (NavigationBar) this.gti.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gti.getPageContext().getString(d.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gti.finish();
            }
        });
        this.gtp = (BdListView) this.crI.findViewById(d.g.validate_list);
        this.goh = (ProgressBar) this.crI.findViewById(d.g.pro_load);
        lo(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gtq != null) {
            this.gtq.destroy();
            this.gtq = null;
        }
        this.gti = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gtq != null) {
            this.gtq.setData(list);
        }
    }

    public void lo(boolean z) {
        this.goh.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gti.getLayoutMode().setNightMode(i == 1);
        this.gti.getLayoutMode().onModeChanged(this.crI);
        this.mNavigationBar.onChangeSkinType(this.gti.getPageContext(), i);
        if (i == 1) {
            this.gtp.setDivider(new ColorDrawable(this.gti.getResources().getColor(d.C0277d.common_color_10179)));
            this.gtp.setDividerHeight(this.gti.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.gtp.setDivider(new ColorDrawable(this.gti.getResources().getColor(d.C0277d.common_color_10241)));
        this.gtp.setDividerHeight(this.gti.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView bwp() {
        return this.gto;
    }

    public a bwq() {
        return this.gtq;
    }
}
