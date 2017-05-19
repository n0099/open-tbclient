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
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow QU;
    private LinearLayout bJe;
    private View bZE;
    private TabMenuPopView bZS;
    private boolean fPW;
    private LinearLayout fPX;
    private Drawable fPY;
    private Drawable fPZ;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fPW = false;
        this.fPY = aq.getDrawable(w.g.icon_title_down);
        this.fPY.setBounds(0, 0, this.fPY.getIntrinsicWidth(), this.fPY.getIntrinsicHeight());
        this.fPZ = aq.getDrawable(w.g.icon_title_up);
        this.fPZ.setBounds(0, 0, this.fPZ.getIntrinsicWidth(), this.fPY.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fPY, null);
        setPadding(0, 0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds50), 0);
        this.bJe = (LinearLayout) LayoutInflater.from(this.mContext).inflate(w.j.pop_category, (ViewGroup) null);
        this.fPX = (LinearLayout) this.bJe.findViewById(w.h.pop_category_layout);
        this.bZS = (TabMenuPopView) this.fPX.findViewById(w.h.pop_category_view);
        this.bZE = this.bJe.findViewById(w.h.pop_category_grav);
        this.bZE.setOnClickListener(new j(this));
    }

    public void b(List<bo> list, bo boVar, int i) {
        this.bZS.a(list, boVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bZS.setOnItemClickCallBack(aVar);
    }

    public void bnv() {
        if (this.fPW) {
            setCompoundDrawables(null, null, this.fPY, null);
            this.fPW = false;
        } else {
            a(this);
            if (this.QU != null) {
                this.QU.refresh();
                this.QU.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.QU.setHeight(-1);
                this.QU.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fPZ, null);
                this.fPW = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.QU == null) {
            this.QU = new MorePopupWindow((Activity) this.mContext, this.bJe, this, aq.getDrawable(w.g.transparent_bg), new k(this));
            this.QU.setOnDismissListener(new l(this, postCategoryView));
        }
    }

    public void ww() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.c(this, w.e.cp_cont_b, 1);
        if (this.fPX != null) {
            aq.k(this.fPX, w.e.cp_bg_line_d);
        }
        if (this.bZS != null) {
            this.bZS.ww();
        }
    }

    public void bnw() {
        if (this.QU != null) {
            this.QU.dismiss();
        }
    }
}
