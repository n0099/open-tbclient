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
    private View crH;
    private ProgressBar gog;
    private ValidateActivity gth;
    private ImageView gtn;
    private BdListView gto;
    private a gtp;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gth = validateActivity;
        initView();
        this.gtp = new a(this.gth);
        this.gto.setAdapter((ListAdapter) this.gtp);
        this.gto.setOnSrollToBottomListener(this.gth);
    }

    void initView() {
        this.crH = View.inflate(this.gth.getPageContext().getPageActivity(), d.h.validate_activity, null);
        this.gth.setContentView(this.crH);
        this.mNavigationBar = (NavigationBar) this.gth.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gth.getPageContext().getString(d.j.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gth.finish();
            }
        });
        this.gto = (BdListView) this.crH.findViewById(d.g.validate_list);
        this.gog = (ProgressBar) this.crH.findViewById(d.g.pro_load);
        lo(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gtp != null) {
            this.gtp.destroy();
            this.gtp = null;
        }
        this.gth = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gtp != null) {
            this.gtp.setData(list);
        }
    }

    public void lo(boolean z) {
        this.gog.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gth.getLayoutMode().setNightMode(i == 1);
        this.gth.getLayoutMode().onModeChanged(this.crH);
        this.mNavigationBar.onChangeSkinType(this.gth.getPageContext(), i);
        if (i == 1) {
            this.gto.setDivider(new ColorDrawable(this.gth.getResources().getColor(d.C0277d.common_color_10179)));
            this.gto.setDividerHeight(this.gth.getResources().getDimensionPixelSize(d.e.ds2));
            return;
        }
        this.gto.setDivider(new ColorDrawable(this.gth.getResources().getColor(d.C0277d.common_color_10241)));
        this.gto.setDividerHeight(this.gth.getResources().getDimensionPixelSize(d.e.ds2));
    }

    public ImageView bwp() {
        return this.gtn;
    }

    public a bwq() {
        return this.gtp;
    }
}
