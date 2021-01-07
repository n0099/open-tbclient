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
/* loaded from: classes8.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow eKn;
    private LinearLayout iSr;
    private View jHc;
    private TabMenuPopView jHo;
    private Context mContext;
    private boolean ocq;
    private LinearLayout ocs;
    private Drawable oct;
    private Drawable ocu;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.ocq = false;
        this.oct = ao.getDrawable(R.drawable.icon_title_down);
        this.oct.setBounds(0, 0, this.oct.getIntrinsicWidth(), this.oct.getIntrinsicHeight());
        this.ocu = ao.getDrawable(R.drawable.icon_title_up);
        this.ocu.setBounds(0, 0, this.ocu.getIntrinsicWidth(), this.oct.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.oct, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iSr = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.ocs = (LinearLayout) this.iSr.findViewById(R.id.pop_category_layout);
        this.jHo = (TabMenuPopView) this.ocs.findViewById(R.id.pop_category_view);
        this.jHc = this.iSr.findViewById(R.id.pop_category_grav);
        this.jHc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dZh();
            }
        });
    }

    public void setCategoryContainerData(List<bc> list, bc bcVar) {
        this.jHo.setData(list, bcVar);
    }

    public void setCategoryContainerData(List<ab> list, ab abVar, int i) {
        this.jHo.setData(list, abVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jHo.setOnItemClickCallBack(aVar);
    }

    public void dZg() {
        if (this.ocq) {
            setCompoundDrawables(null, null, this.oct, null);
            this.ocq = false;
        } else {
            a(this);
            if (this.eKn != null) {
                this.eKn.refresh();
                this.eKn.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eKn.setHeight(-1);
                this.eKn.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.ocu, null);
                this.ocq = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eKn == null) {
            this.eKn = new MorePopupWindow((Activity) this.mContext, this.iSr, this, ao.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bol() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bom() {
                    if (PostCategoryView.this.eKn != null) {
                        PostCategoryView.this.eKn.dismiss();
                    }
                }
            });
            this.eKn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dZg();
                    }
                }
            });
        }
    }

    public void bxP() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.ocs != null) {
            ao.setBackgroundColor(this.ocs, R.color.CAM_X0201);
        }
        if (this.jHo != null) {
            this.jHo.bxP();
        }
    }

    public void dZh() {
        if (this.eKn != null) {
            this.eKn.dismiss();
        }
    }
}
