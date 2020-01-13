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
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View dAM;
    private ProgressBar hDi;
    private ValidateActivity hIj;
    private ImageView hIp;
    private BdListView hIq;
    private a hIr;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.hIj = validateActivity;
        initView();
        this.hIr = new a(this.hIj);
        this.hIq.setAdapter((ListAdapter) this.hIr);
        this.hIq.setOnSrollToBottomListener(this.hIj);
    }

    void initView() {
        this.dAM = View.inflate(this.hIj.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.hIj.setContentView(this.dAM);
        this.mNavigationBar = (NavigationBar) this.hIj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hIj.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hIj.finish();
            }
        });
        this.hIq = (BdListView) this.dAM.findViewById(R.id.validate_list);
        this.hDi = (ProgressBar) this.dAM.findViewById(R.id.pro_load);
        nI(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hIr != null) {
            this.hIr.destroy();
            this.hIr = null;
        }
        this.hIj = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.hIr != null) {
            this.hIr.setData(list);
        }
    }

    public void nI(boolean z) {
        this.hDi.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hIj.getLayoutMode().setNightMode(i == 1);
        this.hIj.getLayoutMode().onModeChanged(this.dAM);
        this.mNavigationBar.onChangeSkinType(this.hIj.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.hIq.setDivider(new ColorDrawable(this.hIj.getResources().getColor(R.color.common_color_10179)));
            this.hIq.setDividerHeight(this.hIj.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.hIq.setDivider(new ColorDrawable(this.hIj.getResources().getColor(R.color.common_color_10241)));
        this.hIq.setDividerHeight(this.hIj.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bWO() {
        return this.hIp;
    }

    public a bWP() {
        return this.hIr;
    }
}
