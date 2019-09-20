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
    private View cCh;
    private ProgressBar gOr;
    private BdListView gTA;
    private a gTB;
    private ValidateActivity gTt;
    private ImageView gTz;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.gTt = validateActivity;
        initView();
        this.gTB = new a(this.gTt);
        this.gTA.setAdapter((ListAdapter) this.gTB);
        this.gTA.setOnSrollToBottomListener(this.gTt);
    }

    void initView() {
        this.cCh = View.inflate(this.gTt.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.gTt.setContentView(this.cCh);
        this.mNavigationBar = (NavigationBar) this.gTt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gTt.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.gTt.finish();
            }
        });
        this.gTA = (BdListView) this.cCh.findViewById(R.id.validate_list);
        this.gOr = (ProgressBar) this.cCh.findViewById(R.id.pro_load);
        mv(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gTB != null) {
            this.gTB.destroy();
            this.gTB = null;
        }
        this.gTt = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.gTB != null) {
            this.gTB.setData(list);
        }
    }

    public void mv(boolean z) {
        this.gOr.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gTt.getLayoutMode().setNightMode(i == 1);
        this.gTt.getLayoutMode().onModeChanged(this.cCh);
        this.mNavigationBar.onChangeSkinType(this.gTt.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.gTA.setDivider(new ColorDrawable(this.gTt.getResources().getColor(R.color.common_color_10179)));
            this.gTA.setDividerHeight(this.gTt.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.gTA.setDivider(new ColorDrawable(this.gTt.getResources().getColor(R.color.common_color_10241)));
        this.gTA.setDividerHeight(this.gTt.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView bHK() {
        return this.gTz;
    }

    public a bHL() {
        return this.gTB;
    }
}
