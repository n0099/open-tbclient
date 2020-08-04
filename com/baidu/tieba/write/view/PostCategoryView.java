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
    private View idF;
    private TabMenuPopView idR;
    private boolean mAb;
    private LinearLayout mAc;
    private Drawable mAd;
    private Drawable mAe;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mAb = false;
        this.mAd = ao.getDrawable(R.drawable.icon_title_down);
        this.mAd.setBounds(0, 0, this.mAd.getIntrinsicWidth(), this.mAd.getIntrinsicHeight());
        this.mAe = ao.getDrawable(R.drawable.icon_title_up);
        this.mAe.setBounds(0, 0, this.mAe.getIntrinsicWidth(), this.mAd.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.mAd, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hsG = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.mAc = (LinearLayout) this.hsG.findViewById(R.id.pop_category_layout);
        this.idR = (TabMenuPopView) this.mAc.findViewById(R.id.pop_category_view);
        this.idF = this.hsG.findViewById(R.id.pop_category_grav);
        this.idF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dvK();
            }
        });
    }

    public void setCategoryContainerData(List<bd> list, bd bdVar) {
        this.idR.setData(list, bdVar);
    }

    public void setCategoryContainerData(List<ad> list, ad adVar, int i) {
        this.idR.setData(list, adVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.idR.setOnItemClickCallBack(aVar);
    }

    public void dvJ() {
        if (this.mAb) {
            setCompoundDrawables(null, null, this.mAd, null);
            this.mAb = false;
        } else {
            a(this);
            if (this.dJC != null) {
                this.dJC.refresh();
                this.dJC.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dJC.setHeight(-1);
                this.dJC.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.mAe, null);
                this.mAb = true;
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
                        postCategoryView.dvJ();
                    }
                }
            });
        }
    }

    public void bci() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.mAc != null) {
            ao.setBackgroundColor(this.mAc, R.color.cp_bg_line_d);
        }
        if (this.idR != null) {
            this.idR.bci();
        }
    }

    public void dvK() {
        if (this.dJC != null) {
            this.dJC.dismiss();
        }
    }
}
