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
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View eCi;
    private ProgressBar iXn;
    private ValidateActivity jcn;
    private ImageView jct;
    private BdListView jcu;
    private a jcv;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.jcn = validateActivity;
        initView();
        this.jcv = new a(this.jcn);
        this.jcu.setAdapter((ListAdapter) this.jcv);
        this.jcu.setOnSrollToBottomListener(this.jcn);
    }

    void initView() {
        this.eCi = View.inflate(this.jcn.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.jcn.setContentView(this.eCi);
        this.mNavigationBar = (NavigationBar) this.jcn.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jcn.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.jcn.finish();
            }
        });
        this.jcu = (BdListView) this.eCi.findViewById(R.id.validate_list);
        this.iXn = (ProgressBar) this.eCi.findViewById(R.id.pro_load);
        pA(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jcv != null) {
            this.jcv.destroy();
            this.jcv = null;
        }
        this.jcn = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.jcv != null) {
            this.jcv.setData(list);
        }
    }

    public void pA(boolean z) {
        this.iXn.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jcn.getLayoutMode().setNightMode(i == 1);
        this.jcn.getLayoutMode().onModeChanged(this.eCi);
        this.mNavigationBar.onChangeSkinType(this.jcn.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.jcu.setDivider(new ColorDrawable(this.jcn.getResources().getColor(R.color.common_color_10179)));
            this.jcu.setDividerHeight(this.jcn.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.jcu.setDivider(new ColorDrawable(this.jcn.getResources().getColor(R.color.common_color_10241)));
        this.jcu.setDividerHeight(this.jcn.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView ctG() {
        return this.jct;
    }

    public a ctH() {
        return this.jcv;
    }
}
