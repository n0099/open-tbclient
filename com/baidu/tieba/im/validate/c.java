package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View fih;
    private ProgressBar jSe;
    private ValidateActivity jXo;
    private ImageView jXu;
    private BdListView jXv;
    private a jXw;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.jXo = validateActivity;
        initView();
        this.jXw = new a(this.jXo);
        this.jXv.setAdapter((ListAdapter) this.jXw);
        this.jXv.setOnSrollToBottomListener(this.jXo);
    }

    void initView() {
        this.fih = View.inflate(this.jXo.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.jXo.setContentView(this.fih);
        this.mNavigationBar = (NavigationBar) this.jXo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jXo.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.jXo.finish();
            }
        });
        this.jXv = (BdListView) this.fih.findViewById(R.id.validate_list);
        this.jSe = (ProgressBar) this.fih.findViewById(R.id.pro_load);
        rD(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jXw != null) {
            this.jXw.destroy();
            this.jXw = null;
        }
        this.jXo = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.jXw != null) {
            this.jXw.setData(list);
        }
    }

    public void rD(boolean z) {
        this.jSe.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jXo.getLayoutMode().setNightMode(i == 1);
        this.jXo.getLayoutMode().onModeChanged(this.fih);
        this.mNavigationBar.onChangeSkinType(this.jXo.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.jXv.setDivider(new ColorDrawable(this.jXo.getResources().getColor(R.color.common_color_10179)));
            this.jXv.setDividerHeight(this.jXo.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.jXv.setDivider(new ColorDrawable(this.jXo.getResources().getColor(R.color.common_color_10241)));
        this.jXv.setDividerHeight(this.jXo.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cPO() {
        return this.jXu;
    }

    public a cPP() {
        return this.jXw;
    }
}
