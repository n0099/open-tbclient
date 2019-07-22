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
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<ValidateActivity> {
    private View cBe;
    private ProgressBar gLH;
    private ValidateActivity gQI;
    private ImageView gQO;
    private BdListView gQP;
    private a gQQ;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gQI = validateActivity;
        initView();
        this.gQQ = new a(this.gQI);
        this.gQP.setAdapter((ListAdapter) this.gQQ);
        this.gQP.setOnSrollToBottomListener(this.gQI);
    }

    void initView() {
        this.cBe = View.inflate(this.gQI.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gQI.setContentView(this.cBe);
        this.mNavigationBar = (NavigationBar) this.gQI.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gQI.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gQI.finish();
            }
        });
        this.gQP = (BdListView) this.cBe.findViewById(R.id.validate_list);
        this.gLH = (ProgressBar) this.cBe.findViewById(R.id.pro_load);
        ms(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gQQ != null) {
            this.gQQ.destroy();
            this.gQQ = null;
        }
        this.gQI = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gQQ != null) {
            this.gQQ.setData(list);
        }
    }

    public void ms(boolean z) {
        this.gLH.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gQI.getLayoutMode().setNightMode(i == 1);
        this.gQI.getLayoutMode().onModeChanged(this.cBe);
        this.mNavigationBar.onChangeSkinType(this.gQI.getPageContext(), i);
        if (i == 1) {
            this.gQP.setDivider(new ColorDrawable(this.gQI.getResources().getColor(R.color.common_color_10179)));
            this.gQP.setDividerHeight(this.gQI.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gQP.setDivider(new ColorDrawable(this.gQI.getResources().getColor(R.color.common_color_10241)));
        this.gQP.setDividerHeight(this.gQI.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bGI() {
        return this.gQO;
    }

    public a bGJ() {
        return this.gQQ;
    }
}
