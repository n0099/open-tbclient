package com.baidu.tieba.write.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow MS;
    private TabMenuPopView bNH;
    private View bNt;
    private LinearLayout bsY;
    private boolean fAY;
    private LinearLayout fAZ;
    private Drawable fBa;
    private Drawable fBb;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fAY = false;
        this.fBa = ar.getDrawable(r.f.icon_title_down);
        this.fBa.setBounds(0, 0, this.fBa.getIntrinsicWidth(), this.fBa.getIntrinsicHeight());
        this.fBb = ar.getDrawable(r.f.icon_title_up);
        this.fBb.setBounds(0, 0, this.fBb.getIntrinsicWidth(), this.fBa.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fBa, null);
        setPadding(0, 0, k.e(getContext(), r.e.ds50), 0);
        this.bsY = (LinearLayout) LayoutInflater.from(this.mContext).inflate(r.h.pop_category, (ViewGroup) null);
        this.fAZ = (LinearLayout) this.bsY.findViewById(r.g.pop_category_layout);
        this.bNH = (TabMenuPopView) this.fAZ.findViewById(r.g.pop_category_view);
        this.bNt = this.bsY.findViewById(r.g.pop_category_grav);
        this.bNt.setOnClickListener(new e(this));
    }

    public void b(List<bv> list, bv bvVar, int i) {
        this.bNH.a(list, bvVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bNH.setOnItemClickCallBack(aVar);
    }

    public void bmx() {
        if (this.fAY) {
            setCompoundDrawables(null, null, this.fBa, null);
            this.fAY = false;
        } else {
            a(this);
            if (this.MS != null) {
                this.MS.refresh();
                this.MS.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.MS.setHeight(-1);
                this.MS.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fBb, null);
                this.fAY = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.MS == null) {
            this.MS = new MorePopupWindow((Activity) this.mContext, this.bsY, this, ar.getDrawable(r.f.transparent_bg), new f(this));
            this.MS.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void wx() {
        ar.l(this, r.d.cp_bg_line_d);
        ar.c(this, r.d.cp_cont_b, 1);
        if (this.fAZ != null) {
            ar.l(this.fAZ, r.d.cp_bg_line_d);
        }
        if (this.bNH != null) {
            this.bNH.wx();
        }
    }

    public void bmy() {
        if (this.MS != null) {
            this.MS.dismiss();
        }
    }
}
