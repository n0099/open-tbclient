package com.baidu.tieba.write.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow bVi;
    private TabMenuPopView fRB;
    private View fRq;
    private LinearLayout fiG;
    private boolean jSY;
    private LinearLayout jSZ;
    private Drawable jTa;
    private Drawable jTb;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jSY = false;
        this.jTa = am.getDrawable(R.drawable.icon_title_down);
        this.jTa.setBounds(0, 0, this.jTa.getIntrinsicWidth(), this.jTa.getIntrinsicHeight());
        this.jTb = am.getDrawable(R.drawable.icon_title_up);
        this.jTb.setBounds(0, 0, this.jTb.getIntrinsicWidth(), this.jTa.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jTa, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.fiG = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jSZ = (LinearLayout) this.fiG.findViewById(R.id.pop_category_layout);
        this.fRB = (TabMenuPopView) this.jSZ.findViewById(R.id.pop_category_view);
        this.fRq = this.fiG.findViewById(R.id.pop_category_grav);
        this.fRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cze();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fRB.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fRB.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fRB.setOnItemClickCallBack(aVar);
    }

    public void czd() {
        if (this.jSY) {
            setCompoundDrawables(null, null, this.jTa, null);
            this.jSY = false;
        } else {
            a(this);
            if (this.bVi != null) {
                this.bVi.refresh();
                this.bVi.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bVi.setHeight(-1);
                this.bVi.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jTb, null);
                this.jSY = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bVi == null) {
            this.bVi = new MorePopupWindow((Activity) this.mContext, this.fiG, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agj() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agk() {
                    if (PostCategoryView.this.bVi != null) {
                        PostCategoryView.this.bVi.dismiss();
                    }
                }
            });
            this.bVi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.czd();
                    }
                }
            });
        }
    }

    public void anO() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.jSZ != null) {
            am.setBackgroundColor(this.jSZ, R.color.cp_bg_line_d);
        }
        if (this.fRB != null) {
            this.fRB.anO();
        }
    }

    public void cze() {
        if (this.bVi != null) {
            this.bVi.dismiss();
        }
    }
}
