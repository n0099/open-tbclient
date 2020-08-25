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
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View eTd;
    private ProgressBar juz;
    private ValidateActivity jzJ;
    private ImageView jzP;
    private BdListView jzQ;
    private a jzR;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.jzJ = validateActivity;
        initView();
        this.jzR = new a(this.jzJ);
        this.jzQ.setAdapter((ListAdapter) this.jzR);
        this.jzQ.setOnSrollToBottomListener(this.jzJ);
    }

    void initView() {
        this.eTd = View.inflate(this.jzJ.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.jzJ.setContentView(this.eTd);
        this.mNavigationBar = (NavigationBar) this.jzJ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jzJ.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.jzJ.finish();
            }
        });
        this.jzQ = (BdListView) this.eTd.findViewById(R.id.validate_list);
        this.juz = (ProgressBar) this.eTd.findViewById(R.id.pro_load);
        qN(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jzR != null) {
            this.jzR.destroy();
            this.jzR = null;
        }
        this.jzJ = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.jzR != null) {
            this.jzR.setData(list);
        }
    }

    public void qN(boolean z) {
        this.juz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jzJ.getLayoutMode().setNightMode(i == 1);
        this.jzJ.getLayoutMode().onModeChanged(this.eTd);
        this.mNavigationBar.onChangeSkinType(this.jzJ.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.jzQ.setDivider(new ColorDrawable(this.jzJ.getResources().getColor(R.color.common_color_10179)));
            this.jzQ.setDividerHeight(this.jzJ.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.jzQ.setDivider(new ColorDrawable(this.jzJ.getResources().getColor(R.color.common_color_10241)));
        this.jzQ.setDividerHeight(this.jzJ.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cIz() {
        return this.jzP;
    }

    public a cIA() {
        return this.jzR;
    }
}
