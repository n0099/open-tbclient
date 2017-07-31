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
    private MorePopupWindow Sm;
    private LinearLayout cbH;
    private TabMenuPopView cwF;
    private View cwr;
    private boolean gDZ;
    private LinearLayout gEa;
    private Drawable gEb;
    private Drawable gEc;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gDZ = false;
        this.gEb = ai.getDrawable(d.g.icon_title_down);
        this.gEb.setBounds(0, 0, this.gEb.getIntrinsicWidth(), this.gEb.getIntrinsicHeight());
        this.gEc = ai.getDrawable(d.g.icon_title_up);
        this.gEc.setBounds(0, 0, this.gEc.getIntrinsicWidth(), this.gEb.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gEb, null);
        setPadding(0, 0, k.g(getContext(), d.f.ds50), 0);
        this.cbH = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.j.pop_category, (ViewGroup) null);
        this.gEa = (LinearLayout) this.cbH.findViewById(d.h.pop_category_layout);
        this.cwF = (TabMenuPopView) this.gEa.findViewById(d.h.pop_category_view);
        this.cwr = this.cbH.findViewById(d.h.pop_category_grav);
        this.cwr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bzi();
            }
        });
    }

    public void b(List<x> list, x xVar, int i) {
        this.cwF.a(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cwF.setOnItemClickCallBack(aVar);
    }

    public void bzh() {
        if (this.gDZ) {
            setCompoundDrawables(null, null, this.gEb, null);
            this.gDZ = false;
        } else {
            a(this);
            if (this.Sm != null) {
                this.Sm.refresh();
                this.Sm.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Sm.setHeight(-1);
                this.Sm.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gEc, null);
                this.gDZ = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Sm == null) {
            this.Sm = new MorePopupWindow((Activity) this.mContext, this.cbH, this, ai.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void ot() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ou() {
                    if (PostCategoryView.this.Sm != null) {
                        PostCategoryView.this.Sm.dismiss();
                    }
                }
            });
            this.Sm.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bzh();
                    }
                }
            });
        }
    }

    public void xd() {
        ai.k(this, d.e.cp_bg_line_d);
        ai.c(this, d.e.cp_cont_b, 1);
        if (this.gEa != null) {
            ai.k(this.gEa, d.e.cp_bg_line_d);
        }
        if (this.cwF != null) {
            this.cwF.xd();
        }
    }

    public void bzi() {
        if (this.Sm != null) {
            this.Sm.dismiss();
        }
    }
}
