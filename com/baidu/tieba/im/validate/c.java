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
    private View fqG;
    private ProgressBar keE;
    private ValidateActivity kjO;
    private ImageView kjU;
    private BdListView kjV;
    private a kjW;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.kjO = validateActivity;
        initView();
        this.kjW = new a(this.kjO);
        this.kjV.setAdapter((ListAdapter) this.kjW);
        this.kjV.setOnSrollToBottomListener(this.kjO);
    }

    void initView() {
        this.fqG = View.inflate(this.kjO.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.kjO.setContentView(this.fqG);
        this.mNavigationBar = (NavigationBar) this.kjO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kjO.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.kjO.finish();
            }
        });
        this.kjV = (BdListView) this.fqG.findViewById(R.id.validate_list);
        this.keE = (ProgressBar) this.fqG.findViewById(R.id.pro_load);
        rV(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kjW != null) {
            this.kjW.destroy();
            this.kjW = null;
        }
        this.kjO = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.kjW != null) {
            this.kjW.setData(list);
        }
    }

    public void rV(boolean z) {
        this.keE.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kjO.getLayoutMode().setNightMode(i == 1);
        this.kjO.getLayoutMode().onModeChanged(this.fqG);
        this.mNavigationBar.onChangeSkinType(this.kjO.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.kjV.setDivider(new ColorDrawable(this.kjO.getResources().getColor(R.color.common_color_10179)));
            this.kjV.setDividerHeight(this.kjO.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.kjV.setDivider(new ColorDrawable(this.kjO.getResources().getColor(R.color.common_color_10241)));
        this.kjV.setDividerHeight(this.kjO.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cSV() {
        return this.kjU;
    }

    public a cSW() {
        return this.kjW;
    }
}
