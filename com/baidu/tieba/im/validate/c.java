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
    private View dEN;
    private ProgressBar hFh;
    private ValidateActivity hKi;
    private ImageView hKo;
    private BdListView hKp;
    private a hKq;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.hKi = validateActivity;
        initView();
        this.hKq = new a(this.hKi);
        this.hKp.setAdapter((ListAdapter) this.hKq);
        this.hKp.setOnSrollToBottomListener(this.hKi);
    }

    void initView() {
        this.dEN = View.inflate(this.hKi.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.hKi.setContentView(this.dEN);
        this.mNavigationBar = (NavigationBar) this.hKi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hKi.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hKi.finish();
            }
        });
        this.hKp = (BdListView) this.dEN.findViewById(R.id.validate_list);
        this.hFh = (ProgressBar) this.dEN.findViewById(R.id.pro_load);
        nK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hKq != null) {
            this.hKq.destroy();
            this.hKq = null;
        }
        this.hKi = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.hKq != null) {
            this.hKq.setData(list);
        }
    }

    public void nK(boolean z) {
        this.hFh.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hKi.getLayoutMode().setNightMode(i == 1);
        this.hKi.getLayoutMode().onModeChanged(this.dEN);
        this.mNavigationBar.onChangeSkinType(this.hKi.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.hKp.setDivider(new ColorDrawable(this.hKi.getResources().getColor(R.color.common_color_10179)));
            this.hKp.setDividerHeight(this.hKi.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.hKp.setDivider(new ColorDrawable(this.hKi.getResources().getColor(R.color.common_color_10241)));
        this.hKp.setDividerHeight(this.hKi.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bYp() {
        return this.hKo;
    }

    public a bYq() {
        return this.hKq;
    }
}
