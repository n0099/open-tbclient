package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<ValidateActivity> {
    private View fNj;
    private ProgressBar kEf;
    private ValidateActivity kJb;
    private ImageView kJh;
    private BdListView kJi;
    private a kJj;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kJb = validateActivity;
        initView();
        this.kJj = new a(this.kJb);
        this.kJi.setAdapter((ListAdapter) this.kJj);
        this.kJi.setOnSrollToBottomListener(this.kJb);
    }

    void initView() {
        this.fNj = View.inflate(this.kJb.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kJb.setContentView(this.fNj);
        this.mNavigationBar = (NavigationBar) this.kJb.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kJb.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kJb.finish();
            }
        });
        this.kJi = (BdListView) this.fNj.findViewById(R.id.validate_list);
        this.kEf = (ProgressBar) this.fNj.findViewById(R.id.pro_load);
        sN(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kJj != null) {
            this.kJj.destroy();
            this.kJj = null;
        }
        this.kJb = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kJj != null) {
            this.kJj.setData(list);
        }
    }

    public void sN(boolean z) {
        this.kEf.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kJb.getLayoutMode().setNightMode(i == 1);
        this.kJb.getLayoutMode().onModeChanged(this.fNj);
        this.mNavigationBar.onChangeSkinType(this.kJb.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kJi.setDivider(new ColorDrawable(this.kJb.getResources().getColor(R.color.common_color_10179)));
            this.kJi.setDividerHeight(this.kJb.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kJi.setDivider(new ColorDrawable(this.kJb.getResources().getColor(R.color.common_color_10241)));
        this.kJi.setDividerHeight(this.kJb.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cZT() {
        return this.kJh;
    }

    public a cZU() {
        return this.kJj;
    }
}
