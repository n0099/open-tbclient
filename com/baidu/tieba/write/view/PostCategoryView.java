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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow QG;
    private LinearLayout bOS;
    private View cfQ;
    private TabMenuPopView cge;
    private boolean fXS;
    private LinearLayout fXT;
    private Drawable fXU;
    private Drawable fXV;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fXS = false;
        this.fXU = aq.getDrawable(w.g.icon_title_down);
        this.fXU.setBounds(0, 0, this.fXU.getIntrinsicWidth(), this.fXU.getIntrinsicHeight());
        this.fXV = aq.getDrawable(w.g.icon_title_up);
        this.fXV.setBounds(0, 0, this.fXV.getIntrinsicWidth(), this.fXU.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fXU, null);
        setPadding(0, 0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds50), 0);
        this.bOS = (LinearLayout) LayoutInflater.from(this.mContext).inflate(w.j.pop_category, (ViewGroup) null);
        this.fXT = (LinearLayout) this.bOS.findViewById(w.h.pop_category_layout);
        this.cge = (TabMenuPopView) this.fXT.findViewById(w.h.pop_category_view);
        this.cfQ = this.bOS.findViewById(w.h.pop_category_grav);
        this.cfQ.setOnClickListener(new j(this));
    }

    public void b(List<bp> list, bp bpVar, int i) {
        this.cge.a(list, bpVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cge.setOnItemClickCallBack(aVar);
    }

    public void boU() {
        if (this.fXS) {
            setCompoundDrawables(null, null, this.fXU, null);
            this.fXS = false;
        } else {
            a(this);
            if (this.QG != null) {
                this.QG.refresh();
                this.QG.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.QG.setHeight(-1);
                this.QG.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fXV, null);
                this.fXS = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.QG == null) {
            this.QG = new MorePopupWindow((Activity) this.mContext, this.bOS, this, aq.getDrawable(w.g.transparent_bg), new k(this));
            this.QG.setOnDismissListener(new l(this, postCategoryView));
        }
    }

    public void ws() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.c(this, w.e.cp_cont_b, 1);
        if (this.fXT != null) {
            aq.k(this.fXT, w.e.cp_bg_line_d);
        }
        if (this.cge != null) {
            this.cge.ws();
        }
    }

    public void boV() {
        if (this.QG != null) {
            this.QG.dismiss();
        }
    }
}
