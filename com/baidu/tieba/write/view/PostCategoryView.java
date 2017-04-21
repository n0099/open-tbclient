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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow RC;
    private LinearLayout bKa;
    private View cbL;
    private TabMenuPopView cbZ;
    private boolean fRR;
    private LinearLayout fRS;
    private Drawable fRT;
    private Drawable fRU;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fRR = false;
        this.fRT = aq.getDrawable(w.g.icon_title_down);
        this.fRT.setBounds(0, 0, this.fRT.getIntrinsicWidth(), this.fRT.getIntrinsicHeight());
        this.fRU = aq.getDrawable(w.g.icon_title_up);
        this.fRU.setBounds(0, 0, this.fRU.getIntrinsicWidth(), this.fRT.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fRT, null);
        setPadding(0, 0, k.g(getContext(), w.f.ds50), 0);
        this.bKa = (LinearLayout) LayoutInflater.from(this.mContext).inflate(w.j.pop_category, (ViewGroup) null);
        this.fRS = (LinearLayout) this.bKa.findViewById(w.h.pop_category_layout);
        this.cbZ = (TabMenuPopView) this.fRS.findViewById(w.h.pop_category_view);
        this.cbL = this.bKa.findViewById(w.h.pop_category_grav);
        this.cbL.setOnClickListener(new e(this));
    }

    public void b(List<bv> list, bv bvVar, int i) {
        this.cbZ.a(list, bvVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cbZ.setOnItemClickCallBack(aVar);
    }

    public void bpt() {
        if (this.fRR) {
            setCompoundDrawables(null, null, this.fRT, null);
            this.fRR = false;
        } else {
            a(this);
            if (this.RC != null) {
                this.RC.refresh();
                this.RC.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.RC.setHeight(-1);
                this.RC.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fRU, null);
                this.fRR = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.RC == null) {
            this.RC = new MorePopupWindow((Activity) this.mContext, this.bKa, this, aq.getDrawable(w.g.transparent_bg), new f(this));
            this.RC.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void xl() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.c(this, w.e.cp_cont_b, 1);
        if (this.fRS != null) {
            aq.k(this.fRS, w.e.cp_bg_line_d);
        }
        if (this.cbZ != null) {
            this.cbZ.xl();
        }
    }

    public void bpu() {
        if (this.RC != null) {
            this.RC.dismiss();
        }
    }
}
