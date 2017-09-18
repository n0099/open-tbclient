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
    private View cFN;
    private TabMenuPopView cGb;
    private LinearLayout cgJ;
    private boolean gFq;
    private LinearLayout gFr;
    private Drawable gFs;
    private Drawable gFt;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gFq = false;
        this.gFs = aj.getDrawable(d.g.icon_title_down);
        this.gFs.setBounds(0, 0, this.gFs.getIntrinsicWidth(), this.gFs.getIntrinsicHeight());
        this.gFt = aj.getDrawable(d.g.icon_title_up);
        this.gFt.setBounds(0, 0, this.gFt.getIntrinsicWidth(), this.gFs.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gFs, null);
        setPadding(0, 0, k.f(getContext(), d.f.ds50), 0);
        this.cgJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.j.pop_category, (ViewGroup) null);
        this.gFr = (LinearLayout) this.cgJ.findViewById(d.h.pop_category_layout);
        this.cGb = (TabMenuPopView) this.gFr.findViewById(d.h.pop_category_view);
        this.cFN = this.cgJ.findViewById(d.h.pop_category_grav);
        this.cFN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bzh();
            }
        });
    }

    public void b(List<x> list, x xVar, int i) {
        this.cGb.a(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cGb.setOnItemClickCallBack(aVar);
    }

    public void bzg() {
        if (this.gFq) {
            setCompoundDrawables(null, null, this.gFs, null);
            this.gFq = false;
        } else {
            a(this);
            if (this.Rq != null) {
                this.Rq.refresh();
                this.Rq.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Rq.setHeight(-1);
                this.Rq.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gFt, null);
                this.gFq = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Rq == null) {
            this.Rq = new MorePopupWindow((Activity) this.mContext, this.cgJ, this, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
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
                        postCategoryView.bzg();
                    }
                }
            });
        }
    }

    public void xc() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.c(this, d.e.cp_cont_b, 1);
        if (this.gFr != null) {
            aj.k(this.gFr, d.e.cp_bg_line_d);
        }
        if (this.cGb != null) {
            this.cGb.xc();
        }
    }

    public void bzh() {
        if (this.Rq != null) {
            this.Rq.dismiss();
        }
    }
}
