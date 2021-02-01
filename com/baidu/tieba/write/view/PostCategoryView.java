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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.bc;
import java.util.List;
/* loaded from: classes8.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow eHI;
    private LinearLayout iTr;
    private View jIa;
    private TabMenuPopView jIm;
    private Context mContext;
    private boolean ohR;
    private LinearLayout ohS;
    private Drawable ohT;
    private Drawable ohU;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.ohR = false;
        this.ohT = ap.getDrawable(R.drawable.icon_title_down);
        this.ohT.setBounds(0, 0, this.ohT.getIntrinsicWidth(), this.ohT.getIntrinsicHeight());
        this.ohU = ap.getDrawable(R.drawable.icon_title_up);
        this.ohU.setBounds(0, 0, this.ohU.getIntrinsicWidth(), this.ohT.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.ohT, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iTr = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.ohS = (LinearLayout) this.iTr.findViewById(R.id.pop_category_layout);
        this.jIm = (TabMenuPopView) this.ohS.findViewById(R.id.pop_category_view);
        this.jIa = this.iTr.findViewById(R.id.pop_category_grav);
        this.jIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dXD();
            }
        });
    }

    public void setCategoryContainerData(List<bc> list, bc bcVar) {
        this.jIm.setData(list, bcVar);
    }

    public void setCategoryContainerData(List<ab> list, ab abVar, int i) {
        this.jIm.setData(list, abVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jIm.setOnItemClickCallBack(aVar);
    }

    public void dXC() {
        if (this.ohR) {
            setCompoundDrawables(null, null, this.ohT, null);
            this.ohR = false;
        } else {
            a(this);
            if (this.eHI != null) {
                this.eHI.refresh();
                this.eHI.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eHI.setHeight(-1);
                this.eHI.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.ohU, null);
                this.ohR = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eHI == null) {
            this.eHI = new MorePopupWindow((Activity) this.mContext, this.iTr, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkJ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkK() {
                    if (PostCategoryView.this.eHI != null) {
                        PostCategoryView.this.eHI.dismiss();
                    }
                }
            });
            this.eHI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dXC();
                    }
                }
            });
        }
    }

    public void bup() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.ohS != null) {
            ap.setBackgroundColor(this.ohS, R.color.CAM_X0201);
        }
        if (this.jIm != null) {
            this.jIm.bup();
        }
    }

    public void dXD() {
        if (this.eHI != null) {
            this.eHI.dismiss();
        }
    }
}
