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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.y;
import java.util.List;
/* loaded from: classes2.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow RH;
    private View cQb;
    private TabMenuPopView cQp;
    private LinearLayout cnz;
    private boolean gVf;
    private LinearLayout gVg;
    private Drawable gVh;
    private Drawable gVi;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gVf = false;
        this.gVh = aj.getDrawable(d.f.icon_title_down);
        this.gVh.setBounds(0, 0, this.gVh.getIntrinsicWidth(), this.gVh.getIntrinsicHeight());
        this.gVi = aj.getDrawable(d.f.icon_title_up);
        this.gVi.setBounds(0, 0, this.gVi.getIntrinsicWidth(), this.gVh.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gVh, null);
        setPadding(0, 0, l.f(getContext(), d.e.ds50), 0);
        this.cnz = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.gVg = (LinearLayout) this.cnz.findViewById(d.g.pop_category_layout);
        this.cQp = (TabMenuPopView) this.gVg.findViewById(d.g.pop_category_view);
        this.cQb = this.cnz.findViewById(d.g.pop_category_grav);
        this.cQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bDZ();
            }
        });
    }

    public void b(List<y> list, y yVar, int i) {
        this.cQp.a(list, yVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cQp.setOnItemClickCallBack(aVar);
    }

    public void bDY() {
        if (this.gVf) {
            setCompoundDrawables(null, null, this.gVh, null);
            this.gVf = false;
        } else {
            a(this);
            if (this.RH != null) {
                this.RH.refresh();
                this.RH.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.RH.setHeight(-1);
                this.RH.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gVi, null);
                this.gVf = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.RH == null) {
            this.RH = new MorePopupWindow((Activity) this.mContext, this.cnz, this, aj.getDrawable(d.f.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void oq() {
                    if (PostCategoryView.this.RH != null) {
                        PostCategoryView.this.RH.dismiss();
                    }
                }
            });
            this.RH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bDY();
                    }
                }
            });
        }
    }

    public void wB() {
        aj.k(this, d.C0080d.cp_bg_line_d);
        aj.c(this, d.C0080d.cp_cont_b, 1);
        if (this.gVg != null) {
            aj.k(this.gVg, d.C0080d.cp_bg_line_d);
        }
        if (this.cQp != null) {
            this.cQp.wB();
        }
    }

    public void bDZ() {
        if (this.RH != null) {
            this.RH.dismiss();
        }
    }
}
