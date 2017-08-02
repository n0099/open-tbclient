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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow QN;
    private LinearLayout caB;
    private View cuZ;
    private TabMenuPopView cvn;
    private boolean gCO;
    private LinearLayout gCP;
    private Drawable gCQ;
    private Drawable gCR;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gCO = false;
        this.gCQ = ai.getDrawable(d.g.icon_title_down);
        this.gCQ.setBounds(0, 0, this.gCQ.getIntrinsicWidth(), this.gCQ.getIntrinsicHeight());
        this.gCR = ai.getDrawable(d.g.icon_title_up);
        this.gCR.setBounds(0, 0, this.gCR.getIntrinsicWidth(), this.gCQ.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gCQ, null);
        setPadding(0, 0, k.g(getContext(), d.f.ds50), 0);
        this.caB = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.j.pop_category, (ViewGroup) null);
        this.gCP = (LinearLayout) this.caB.findViewById(d.h.pop_category_layout);
        this.cvn = (TabMenuPopView) this.gCP.findViewById(d.h.pop_category_view);
        this.cuZ = this.caB.findViewById(d.h.pop_category_grav);
        this.cuZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bzb();
            }
        });
    }

    public void b(List<x> list, x xVar, int i) {
        this.cvn.a(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cvn.setOnItemClickCallBack(aVar);
    }

    public void bza() {
        if (this.gCO) {
            setCompoundDrawables(null, null, this.gCQ, null);
            this.gCO = false;
        } else {
            a(this);
            if (this.QN != null) {
                this.QN.refresh();
                this.QN.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.QN.setHeight(-1);
                this.QN.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gCR, null);
                this.gCO = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.QN == null) {
            this.QN = new MorePopupWindow((Activity) this.mContext, this.caB, this, ai.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void oj() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ok() {
                    if (PostCategoryView.this.QN != null) {
                        PostCategoryView.this.QN.dismiss();
                    }
                }
            });
            this.QN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bza();
                    }
                }
            });
        }
    }

    public void wV() {
        ai.k(this, d.e.cp_bg_line_d);
        ai.c(this, d.e.cp_cont_b, 1);
        if (this.gCP != null) {
            ai.k(this.gCP, d.e.cp_bg_line_d);
        }
        if (this.cvn != null) {
            this.cvn.wV();
        }
    }

    public void bzb() {
        if (this.QN != null) {
            this.QN.dismiss();
        }
    }
}
