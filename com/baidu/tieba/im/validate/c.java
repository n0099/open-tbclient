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
    private View eIx;
    private ProgressBar jfx;
    private ValidateActivity jkI;
    private ImageView jkO;
    private BdListView jkP;
    private a jkQ;
    private NavigationBar mNavigationBar;

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.jkI = validateActivity;
        initView();
        this.jkQ = new a(this.jkI);
        this.jkP.setAdapter((ListAdapter) this.jkQ);
        this.jkP.setOnSrollToBottomListener(this.jkI);
    }

    void initView() {
        this.eIx = View.inflate(this.jkI.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.jkI.setContentView(this.eIx);
        this.mNavigationBar = (NavigationBar) this.jkI.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jkI.getPageContext().getString(R.string.validate));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.jkI.finish();
            }
        });
        this.jkP = (BdListView) this.eIx.findViewById(R.id.validate_list);
        this.jfx = (ProgressBar) this.eIx.findViewById(R.id.pro_load);
        qh(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jkQ != null) {
            this.jkQ.destroy();
            this.jkQ = null;
        }
        this.jkI = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (this.jkQ != null) {
            this.jkQ.setData(list);
        }
    }

    public void qh(boolean z) {
        this.jfx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jkI.getLayoutMode().setNightMode(i == 1);
        this.jkI.getLayoutMode().onModeChanged(this.eIx);
        this.mNavigationBar.onChangeSkinType(this.jkI.getPageContext(), i);
        if (i == 1 || i == 4) {
            this.jkP.setDivider(new ColorDrawable(this.jkI.getResources().getColor(R.color.common_color_10179)));
            this.jkP.setDividerHeight(this.jkI.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.jkP.setDivider(new ColorDrawable(this.jkI.getResources().getColor(R.color.common_color_10241)));
        this.jkP.setDividerHeight(this.jkI.getResources().getDimensionPixelSize(R.dimen.ds2));
    }

    public ImageView cxI() {
        return this.jkO;
    }

    public a cxJ() {
        return this.jkQ;
    }
}
