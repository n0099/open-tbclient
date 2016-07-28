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
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow KI;
    private View bSE;
    private TabMenuPopView bSS;
    private LinearLayout byy;
    private boolean fSC;
    private LinearLayout fSD;
    private Drawable fSE;
    private Drawable fSF;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fSC = false;
        this.fSE = av.getDrawable(u.f.icon_title_down);
        this.fSE.setBounds(0, 0, this.fSE.getIntrinsicWidth(), this.fSE.getIntrinsicHeight());
        this.fSF = av.getDrawable(u.f.icon_title_up);
        this.fSF.setBounds(0, 0, this.fSF.getIntrinsicWidth(), this.fSE.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fSE, null);
        setPadding(0, 0, k.c(getContext(), u.e.ds50), 0);
        this.byy = (LinearLayout) LayoutInflater.from(this.mContext).inflate(u.h.pop_category, (ViewGroup) null);
        this.fSD = (LinearLayout) this.byy.findViewById(u.g.pop_category_layout);
        this.bSS = (TabMenuPopView) this.fSD.findViewById(u.g.pop_category_view);
        this.bSE = this.byy.findViewById(u.g.pop_category_grav);
        this.bSE.setOnClickListener(new e(this));
    }

    public void b(List<dc> list, dc dcVar, int i) {
        this.bSS.a(list, dcVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bSS.setOnItemClickCallBack(aVar);
    }

    public void boj() {
        if (this.fSC) {
            setCompoundDrawables(null, null, this.fSE, null);
            this.fSC = false;
        } else {
            a(this);
            if (this.KI != null) {
                this.KI.refresh();
                this.KI.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.KI.setHeight(-1);
                this.KI.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fSF, null);
                this.fSC = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.KI == null) {
            this.KI = new MorePopupWindow((Activity) this.mContext, this.byy, this, av.getDrawable(u.f.transparent_bg), new f(this));
            this.KI.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void vm() {
        av.l(this, u.d.cp_bg_line_d);
        av.c(this, u.d.cp_cont_b, 1);
        if (this.fSD != null) {
            av.l(this.fSD, u.d.cp_bg_line_d);
        }
        if (this.bSS != null) {
            this.bSS.vm();
        }
    }

    public void bok() {
        if (this.KI != null) {
            this.KI.dismiss();
        }
    }
}
