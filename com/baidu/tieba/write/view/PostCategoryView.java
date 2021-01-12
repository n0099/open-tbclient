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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.bc;
import java.util.List;
/* loaded from: classes7.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow eFC;
    private LinearLayout iNK;
    private TabMenuPopView jCI;
    private View jCw;
    private Context mContext;
    private boolean nXK;
    private LinearLayout nXL;
    private Drawable nXM;
    private Drawable nXN;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.nXK = false;
        this.nXM = ao.getDrawable(R.drawable.icon_title_down);
        this.nXM.setBounds(0, 0, this.nXM.getIntrinsicWidth(), this.nXM.getIntrinsicHeight());
        this.nXN = ao.getDrawable(R.drawable.icon_title_up);
        this.nXN.setBounds(0, 0, this.nXN.getIntrinsicWidth(), this.nXM.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.nXM, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iNK = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.nXL = (LinearLayout) this.iNK.findViewById(R.id.pop_category_layout);
        this.jCI = (TabMenuPopView) this.nXL.findViewById(R.id.pop_category_view);
        this.jCw = this.iNK.findViewById(R.id.pop_category_grav);
        this.jCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dVp();
            }
        });
    }

    public void setCategoryContainerData(List<bc> list, bc bcVar) {
        this.jCI.setData(list, bcVar);
    }

    public void setCategoryContainerData(List<ab> list, ab abVar, int i) {
        this.jCI.setData(list, abVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jCI.setOnItemClickCallBack(aVar);
    }

    public void dVo() {
        if (this.nXK) {
            setCompoundDrawables(null, null, this.nXM, null);
            this.nXK = false;
        } else {
            a(this);
            if (this.eFC != null) {
                this.eFC.refresh();
                this.eFC.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eFC.setHeight(-1);
                this.eFC.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.nXN, null);
                this.nXK = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eFC == null) {
            this.eFC = new MorePopupWindow((Activity) this.mContext, this.iNK, this, ao.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkr() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bks() {
                    if (PostCategoryView.this.eFC != null) {
                        PostCategoryView.this.eFC.dismiss();
                    }
                }
            });
            this.eFC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dVo();
                    }
                }
            });
        }
    }

    public void btV() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.nXL != null) {
            ao.setBackgroundColor(this.nXL, R.color.CAM_X0201);
        }
        if (this.jCI != null) {
            this.jCI.btV();
        }
    }

    public void dVp() {
        if (this.eFC != null) {
            this.eFC.dismiss();
        }
    }
}
