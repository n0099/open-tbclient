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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes2.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow Rq;
    private View cEV;
    private TabMenuPopView cFj;
    private LinearLayout cfR;
    private Drawable gEA;
    private boolean gEx;
    private LinearLayout gEy;
    private Drawable gEz;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gEx = false;
        this.gEz = aj.getDrawable(d.g.icon_title_down);
        this.gEz.setBounds(0, 0, this.gEz.getIntrinsicWidth(), this.gEz.getIntrinsicHeight());
        this.gEA = aj.getDrawable(d.g.icon_title_up);
        this.gEA.setBounds(0, 0, this.gEA.getIntrinsicWidth(), this.gEz.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gEz, null);
        setPadding(0, 0, k.g(getContext(), d.f.ds50), 0);
        this.cfR = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.j.pop_category, (ViewGroup) null);
        this.gEy = (LinearLayout) this.cfR.findViewById(d.h.pop_category_layout);
        this.cFj = (TabMenuPopView) this.gEy.findViewById(d.h.pop_category_view);
        this.cEV = this.cfR.findViewById(d.h.pop_category_grav);
        this.cEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.byW();
            }
        });
    }

    public void b(List<x> list, x xVar, int i) {
        this.cFj.a(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cFj.setOnItemClickCallBack(aVar);
    }

    public void byV() {
        if (this.gEx) {
            setCompoundDrawables(null, null, this.gEz, null);
            this.gEx = false;
        } else {
            a(this);
            if (this.Rq != null) {
                this.Rq.refresh();
                this.Rq.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Rq.setHeight(-1);
                this.Rq.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gEA, null);
                this.gEx = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Rq == null) {
            this.Rq = new MorePopupWindow((Activity) this.mContext, this.cfR, this, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void oo() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                    if (PostCategoryView.this.Rq != null) {
                        PostCategoryView.this.Rq.dismiss();
                    }
                }
            });
            this.Rq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.byV();
                    }
                }
            });
        }
    }

    public void xc() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.c(this, d.e.cp_cont_b, 1);
        if (this.gEy != null) {
            aj.k(this.gEy, d.e.cp_bg_line_d);
        }
        if (this.cFj != null) {
            this.cFj.xc();
        }
    }

    public void byW() {
        if (this.Rq != null) {
            this.Rq.dismiss();
        }
    }
}
