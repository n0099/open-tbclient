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
/* loaded from: classes7.dex */
public class c extends d<ValidateActivity> {
    private View fMn;
    private ProgressBar kJV;
    private ValidateActivity kOR;
    private ImageView kOX;
    private BdListView kOY;
    private a kOZ;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kOR = validateActivity;
        initView();
        this.kOZ = new a(this.kOR);
        this.kOY.setAdapter((ListAdapter) this.kOZ);
        this.kOY.setOnSrollToBottomListener(this.kOR);
    }

    void initView() {
        this.fMn = View.inflate(this.kOR.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kOR.setContentView(this.fMn);
        this.mNavigationBar = (NavigationBar) this.kOR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kOR.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kOR.finish();
            }
        });
        this.kOY = (BdListView) this.fMn.findViewById(R.id.validate_list);
        this.kJV = (ProgressBar) this.fMn.findViewById(R.id.pro_load);
        sW(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kOZ != null) {
            this.kOZ.destroy();
            this.kOZ = null;
        }
        this.kOR = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kOZ != null) {
            this.kOZ.setData(list);
        }
    }

    public void sW(boolean z) {
        this.kJV.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kOR.getLayoutMode().setNightMode(i == 1);
        this.kOR.getLayoutMode().onModeChanged(this.fMn);
        this.mNavigationBar.onChangeSkinType(this.kOR.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kOY.setDivider(new ColorDrawable(this.kOR.getResources().getColor(R.color.common_color_10179)));
            this.kOY.setDividerHeight(this.kOR.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kOY.setDivider(new ColorDrawable(this.kOR.getResources().getColor(R.color.common_color_10241)));
        this.kOY.setDividerHeight(this.kOR.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cYn() {
        return this.kOX;
    }

    public a cYo() {
        return this.kOZ;
    }
}
