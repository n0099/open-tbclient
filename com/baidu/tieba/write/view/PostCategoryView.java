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
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow Ri;
    private LinearLayout bHQ;
    private View caT;
    private TabMenuPopView cbh;
    private boolean fNM;
    private LinearLayout fNN;
    private Drawable fNO;
    private Drawable fNP;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fNM = false;
        this.fNO = aq.getDrawable(w.g.icon_title_down);
        this.fNO.setBounds(0, 0, this.fNO.getIntrinsicWidth(), this.fNO.getIntrinsicHeight());
        this.fNP = aq.getDrawable(w.g.icon_title_up);
        this.fNP.setBounds(0, 0, this.fNP.getIntrinsicWidth(), this.fNO.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fNO, null);
        setPadding(0, 0, k.g(getContext(), w.f.ds50), 0);
        this.bHQ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(w.j.pop_category, (ViewGroup) null);
        this.fNN = (LinearLayout) this.bHQ.findViewById(w.h.pop_category_layout);
        this.cbh = (TabMenuPopView) this.fNN.findViewById(w.h.pop_category_view);
        this.caT = this.bHQ.findViewById(w.h.pop_category_grav);
        this.caT.setOnClickListener(new e(this));
    }

    public void b(List<bt> list, bt btVar, int i) {
        this.cbh.a(list, btVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cbh.setOnItemClickCallBack(aVar);
    }

    public void bnI() {
        if (this.fNM) {
            setCompoundDrawables(null, null, this.fNO, null);
            this.fNM = false;
        } else {
            a(this);
            if (this.Ri != null) {
                this.Ri.refresh();
                this.Ri.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Ri.setHeight(-1);
                this.Ri.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fNP, null);
                this.fNM = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.Ri == null) {
            this.Ri = new MorePopupWindow((Activity) this.mContext, this.bHQ, this, aq.getDrawable(w.g.transparent_bg), new f(this));
            this.Ri.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void wP() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.c(this, w.e.cp_cont_b, 1);
        if (this.fNN != null) {
            aq.k(this.fNN, w.e.cp_bg_line_d);
        }
        if (this.cbh != null) {
            this.cbh.wP();
        }
    }

    public void bnJ() {
        if (this.Ri != null) {
            this.Ri.dismiss();
        }
    }
}
