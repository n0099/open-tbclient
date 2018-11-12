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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow aju;
    private TabMenuPopView dVJ;
    private View dVy;
    private LinearLayout dlu;
    private boolean hPa;
    private LinearLayout hPb;
    private Drawable hPc;
    private Drawable hPd;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hPa = false;
        this.hPc = al.getDrawable(e.f.icon_title_down);
        this.hPc.setBounds(0, 0, this.hPc.getIntrinsicWidth(), this.hPc.getIntrinsicHeight());
        this.hPd = al.getDrawable(e.f.icon_title_up);
        this.hPd.setBounds(0, 0, this.hPd.getIntrinsicWidth(), this.hPc.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hPc, null);
        setPadding(0, 0, l.h(getContext(), e.C0200e.ds50), 0);
        this.dlu = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.pop_category, (ViewGroup) null);
        this.hPb = (LinearLayout) this.dlu.findViewById(e.g.pop_category_layout);
        this.dVJ = (TabMenuPopView) this.hPb.findViewById(e.g.pop_category_view);
        this.dVy = this.dlu.findViewById(e.g.pop_category_grav);
        this.dVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bMI();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.dVJ.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.dVJ.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dVJ.setOnItemClickCallBack(aVar);
    }

    public void bMH() {
        if (this.hPa) {
            setCompoundDrawables(null, null, this.hPc, null);
            this.hPa = false;
        } else {
            a(this);
            if (this.aju != null) {
                this.aju.refresh();
                this.aju.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aju.setHeight(-1);
                this.aju.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hPd, null);
                this.hPa = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aju == null) {
            this.aju = new MorePopupWindow((Activity) this.mContext, this.dlu, this, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void vZ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void wa() {
                    if (PostCategoryView.this.aju != null) {
                        PostCategoryView.this.aju.dismiss();
                    }
                }
            });
            this.aju.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bMH();
                    }
                }
            });
        }
    }

    public void Ef() {
        al.j(this, e.d.cp_bg_line_d);
        al.c(this, e.d.cp_cont_b, 1);
        if (this.hPb != null) {
            al.j(this.hPb, e.d.cp_bg_line_d);
        }
        if (this.dVJ != null) {
            this.dVJ.Ef();
        }
    }

    public void bMI() {
        if (this.aju != null) {
            this.aju.dismiss();
        }
    }
}
