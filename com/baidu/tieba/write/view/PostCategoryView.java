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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow MV;
    private LinearLayout bMU;
    private View chK;
    private TabMenuPopView chY;
    private boolean gmv;
    private LinearLayout gmw;
    private Drawable gmx;
    private Drawable gmy;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gmv = false;
        this.gmx = at.getDrawable(r.f.icon_title_down);
        this.gmx.setBounds(0, 0, this.gmx.getIntrinsicWidth(), this.gmx.getIntrinsicHeight());
        this.gmy = at.getDrawable(r.f.icon_title_up);
        this.gmy.setBounds(0, 0, this.gmy.getIntrinsicWidth(), this.gmx.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gmx, null);
        setPadding(0, 0, k.e(getContext(), r.e.ds50), 0);
        this.bMU = (LinearLayout) LayoutInflater.from(this.mContext).inflate(r.h.pop_category, (ViewGroup) null);
        this.gmw = (LinearLayout) this.bMU.findViewById(r.g.pop_category_layout);
        this.chY = (TabMenuPopView) this.gmw.findViewById(r.g.pop_category_view);
        this.chK = this.bMU.findViewById(r.g.pop_category_grav);
        this.chK.setOnClickListener(new e(this));
    }

    public void b(List<bw> list, bw bwVar, int i) {
        this.chY.a(list, bwVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.chY.setOnItemClickCallBack(aVar);
    }

    public void bvz() {
        if (this.gmv) {
            setCompoundDrawables(null, null, this.gmx, null);
            this.gmv = false;
        } else {
            a(this);
            if (this.MV != null) {
                this.MV.refresh();
                this.MV.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.MV.setHeight(-1);
                this.MV.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gmy, null);
                this.gmv = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.MV == null) {
            this.MV = new MorePopupWindow((Activity) this.mContext, this.bMU, this, at.getDrawable(r.f.transparent_bg), new f(this));
            this.MV.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void wM() {
        at.l(this, r.d.cp_bg_line_d);
        at.c(this, r.d.cp_cont_b, 1);
        if (this.gmw != null) {
            at.l(this.gmw, r.d.cp_bg_line_d);
        }
        if (this.chY != null) {
            this.chY.wM();
        }
    }

    public void bvA() {
        if (this.MV != null) {
            this.MV.dismiss();
        }
    }
}
