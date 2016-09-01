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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow MV;
    private LinearLayout bKa;
    private View cdK;
    private TabMenuPopView cdY;
    private boolean gcH;
    private LinearLayout gcI;
    private Drawable gcJ;
    private Drawable gcK;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gcH = false;
        this.gcJ = av.getDrawable(t.f.icon_title_down);
        this.gcJ.setBounds(0, 0, this.gcJ.getIntrinsicWidth(), this.gcJ.getIntrinsicHeight());
        this.gcK = av.getDrawable(t.f.icon_title_up);
        this.gcK.setBounds(0, 0, this.gcK.getIntrinsicWidth(), this.gcJ.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gcJ, null);
        setPadding(0, 0, k.e(getContext(), t.e.ds50), 0);
        this.bKa = (LinearLayout) LayoutInflater.from(this.mContext).inflate(t.h.pop_category, (ViewGroup) null);
        this.gcI = (LinearLayout) this.bKa.findViewById(t.g.pop_category_layout);
        this.cdY = (TabMenuPopView) this.gcI.findViewById(t.g.pop_category_view);
        this.cdK = this.bKa.findViewById(t.g.pop_category_grav);
        this.cdK.setOnClickListener(new e(this));
    }

    public void b(List<cy> list, cy cyVar, int i) {
        this.cdY.a(list, cyVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cdY.setOnItemClickCallBack(aVar);
    }

    public void bsy() {
        if (this.gcH) {
            setCompoundDrawables(null, null, this.gcJ, null);
            this.gcH = false;
        } else {
            a(this);
            if (this.MV != null) {
                this.MV.refresh();
                this.MV.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.MV.setHeight(-1);
                this.MV.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gcK, null);
                this.gcH = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.MV == null) {
            this.MV = new MorePopupWindow((Activity) this.mContext, this.bKa, this, av.getDrawable(t.f.transparent_bg), new f(this));
            this.MV.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void wq() {
        av.l(this, t.d.cp_bg_line_d);
        av.c(this, t.d.cp_cont_b, 1);
        if (this.gcI != null) {
            av.l(this.gcI, t.d.cp_bg_line_d);
        }
        if (this.cdY != null) {
            this.cdY.wq();
        }
    }

    public void bsz() {
        if (this.MV != null) {
            this.MV.dismiss();
        }
    }
}
