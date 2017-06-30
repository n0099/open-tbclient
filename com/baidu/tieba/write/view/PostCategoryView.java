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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow QA;
    private LinearLayout bVP;
    private View cog;
    private TabMenuPopView cou;
    private boolean giS;
    private LinearLayout giT;
    private Drawable giU;
    private Drawable giV;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.giS = false;
        this.giU = as.getDrawable(w.g.icon_title_down);
        this.giU.setBounds(0, 0, this.giU.getIntrinsicWidth(), this.giU.getIntrinsicHeight());
        this.giV = as.getDrawable(w.g.icon_title_up);
        this.giV.setBounds(0, 0, this.giV.getIntrinsicWidth(), this.giU.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.giU, null);
        setPadding(0, 0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds50), 0);
        this.bVP = (LinearLayout) LayoutInflater.from(this.mContext).inflate(w.j.pop_category, (ViewGroup) null);
        this.giT = (LinearLayout) this.bVP.findViewById(w.h.pop_category_layout);
        this.cou = (TabMenuPopView) this.giT.findViewById(w.h.pop_category_view);
        this.cog = this.bVP.findViewById(w.h.pop_category_grav);
        this.cog.setOnClickListener(new j(this));
    }

    public void b(List<bq> list, bq bqVar, int i) {
        this.cou.a(list, bqVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cou.setOnItemClickCallBack(aVar);
    }

    public void bts() {
        if (this.giS) {
            setCompoundDrawables(null, null, this.giU, null);
            this.giS = false;
        } else {
            a(this);
            if (this.QA != null) {
                this.QA.refresh();
                this.QA.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.QA.setHeight(-1);
                this.QA.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.giV, null);
                this.giS = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.QA == null) {
            this.QA = new MorePopupWindow((Activity) this.mContext, this.bVP, this, as.getDrawable(w.g.transparent_bg), new k(this));
            this.QA.setOnDismissListener(new l(this, postCategoryView));
        }
    }

    public void wK() {
        as.k(this, w.e.cp_bg_line_d);
        as.c(this, w.e.cp_cont_b, 1);
        if (this.giT != null) {
            as.k(this.giT, w.e.cp_bg_line_d);
        }
        if (this.cou != null) {
            this.cou.wK();
        }
    }

    public void btt() {
        if (this.QA != null) {
            this.QA.dismiss();
        }
    }
}
