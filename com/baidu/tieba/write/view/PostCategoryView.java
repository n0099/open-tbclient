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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.bd;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow dJC;
    private LinearLayout hsG;
    private View idD;
    private TabMenuPopView idP;
    private LinearLayout mAa;
    private Drawable mAb;
    private Drawable mAc;
    private Context mContext;
    private boolean mzZ;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mzZ = false;
        this.mAb = ao.getDrawable(R.drawable.icon_title_down);
        this.mAb.setBounds(0, 0, this.mAb.getIntrinsicWidth(), this.mAb.getIntrinsicHeight());
        this.mAc = ao.getDrawable(R.drawable.icon_title_up);
        this.mAc.setBounds(0, 0, this.mAc.getIntrinsicWidth(), this.mAb.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.mAb, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hsG = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.mAa = (LinearLayout) this.hsG.findViewById(R.id.pop_category_layout);
        this.idP = (TabMenuPopView) this.mAa.findViewById(R.id.pop_category_view);
        this.idD = this.hsG.findViewById(R.id.pop_category_grav);
        this.idD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dvJ();
            }
        });
    }

    public void setCategoryContainerData(List<bd> list, bd bdVar) {
        this.idP.setData(list, bdVar);
    }

    public void setCategoryContainerData(List<ad> list, ad adVar, int i) {
        this.idP.setData(list, adVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.idP.setOnItemClickCallBack(aVar);
    }

    public void dvI() {
        if (this.mzZ) {
            setCompoundDrawables(null, null, this.mAb, null);
            this.mzZ = false;
        } else {
            a(this);
            if (this.dJC != null) {
                this.dJC.refresh();
                this.dJC.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dJC.setHeight(-1);
                this.dJC.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.mAc, null);
                this.mzZ = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dJC == null) {
            this.dJC = new MorePopupWindow((Activity) this.mContext, this.hsG, this, ao.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aTl() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aTm() {
                    if (PostCategoryView.this.dJC != null) {
                        PostCategoryView.this.dJC.dismiss();
                    }
                }
            });
            this.dJC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dvI();
                    }
                }
            });
        }
    }

    public void bci() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.mAa != null) {
            ao.setBackgroundColor(this.mAa, R.color.cp_bg_line_d);
        }
        if (this.idP != null) {
            this.idP.bci();
        }
    }

    public void dvJ() {
        if (this.dJC != null) {
            this.dJC.dismiss();
        }
    }
}
