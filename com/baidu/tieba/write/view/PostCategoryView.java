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
    private MorePopupWindow RA;
    private LinearLayout bHJ;
    private TabMenuPopView bZI;
    private View bZu;
    private boolean fPv;
    private LinearLayout fPw;
    private Drawable fPx;
    private Drawable fPy;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fPv = false;
        this.fPx = aq.getDrawable(w.g.icon_title_down);
        this.fPx.setBounds(0, 0, this.fPx.getIntrinsicWidth(), this.fPx.getIntrinsicHeight());
        this.fPy = aq.getDrawable(w.g.icon_title_up);
        this.fPy.setBounds(0, 0, this.fPy.getIntrinsicWidth(), this.fPx.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fPx, null);
        setPadding(0, 0, k.g(getContext(), w.f.ds50), 0);
        this.bHJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(w.j.pop_category, (ViewGroup) null);
        this.fPw = (LinearLayout) this.bHJ.findViewById(w.h.pop_category_layout);
        this.bZI = (TabMenuPopView) this.fPw.findViewById(w.h.pop_category_view);
        this.bZu = this.bHJ.findViewById(w.h.pop_category_grav);
        this.bZu.setOnClickListener(new e(this));
    }

    public void b(List<bv> list, bv bvVar, int i) {
        this.bZI.a(list, bvVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bZI.setOnItemClickCallBack(aVar);
    }

    public void bos() {
        if (this.fPv) {
            setCompoundDrawables(null, null, this.fPx, null);
            this.fPv = false;
        } else {
            a(this);
            if (this.RA != null) {
                this.RA.refresh();
                this.RA.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.RA.setHeight(-1);
                this.RA.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fPy, null);
                this.fPv = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.RA == null) {
            this.RA = new MorePopupWindow((Activity) this.mContext, this.bHJ, this, aq.getDrawable(w.g.transparent_bg), new f(this));
            this.RA.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void xl() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.c(this, w.e.cp_cont_b, 1);
        if (this.fPw != null) {
            aq.k(this.fPw, w.e.cp_bg_line_d);
        }
        if (this.bZI != null) {
            this.bZI.xl();
        }
    }

    public void bot() {
        if (this.RA != null) {
            this.RA.dismiss();
        }
    }
}
