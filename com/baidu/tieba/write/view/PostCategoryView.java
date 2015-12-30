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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private LinearLayout aXA;
    private TabMenuPopView bmE;
    private View bmq;
    private boolean dVC;
    private LinearLayout dVD;
    private Drawable dVE;
    private Drawable dVF;
    private Context mContext;
    private MorePopupWindow mPopWindow;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.dVC = false;
        this.dVE = as.getDrawable(n.f.icon_title_down);
        this.dVE.setBounds(0, 0, this.dVE.getIntrinsicWidth(), this.dVE.getIntrinsicHeight());
        this.dVF = as.getDrawable(n.f.icon_title_up);
        this.dVF.setBounds(0, 0, this.dVF.getIntrinsicWidth(), this.dVE.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.dVE, null);
        setPadding(0, 0, k.d(getContext(), n.e.ds50), 0);
        this.aXA = (LinearLayout) LayoutInflater.from(this.mContext).inflate(n.h.pop_category, (ViewGroup) null);
        this.dVD = (LinearLayout) this.aXA.findViewById(n.g.pop_category_layout);
        this.bmE = (TabMenuPopView) this.dVD.findViewById(n.g.pop_category_view);
        this.bmq = this.aXA.findViewById(n.g.pop_category_grav);
        this.bmq.setOnClickListener(new g(this));
    }

    public void b(List<ec> list, ec ecVar, int i) {
        this.bmE.a(list, ecVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bmE.setOnItemClickCallBack(aVar);
    }

    public void aLd() {
        if (this.dVC) {
            setCompoundDrawables(null, null, this.dVE, null);
            this.dVC = false;
        } else {
            a(this);
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
                this.mPopWindow.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.mPopWindow.setHeight(-1);
                this.mPopWindow.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.dVF, null);
                this.dVC = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow((Activity) this.mContext, this.aXA, this, as.getDrawable(n.f.transparent_bg), new h(this));
            this.mPopWindow.setOnDismissListener(new i(this, postCategoryView));
        }
    }

    public void vR() {
        as.j((View) this, n.d.cp_bg_line_d);
        as.b(this, n.d.cp_cont_b, 1);
        if (this.dVD != null) {
            as.j(this.dVD, n.d.cp_bg_line_d);
        }
        if (this.bmE != null) {
            this.bmE.vR();
        }
    }

    public void aLe() {
        if (this.mPopWindow != null) {
            this.mPopWindow.dismiss();
        }
    }
}
