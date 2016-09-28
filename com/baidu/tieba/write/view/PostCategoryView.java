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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow MU;
    private LinearLayout bKb;
    private View cdJ;
    private TabMenuPopView cdX;
    private boolean geR;
    private LinearLayout geS;
    private Drawable geT;
    private Drawable geU;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.geR = false;
        this.geT = av.getDrawable(r.f.icon_title_down);
        this.geT.setBounds(0, 0, this.geT.getIntrinsicWidth(), this.geT.getIntrinsicHeight());
        this.geU = av.getDrawable(r.f.icon_title_up);
        this.geU.setBounds(0, 0, this.geU.getIntrinsicWidth(), this.geT.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.geT, null);
        setPadding(0, 0, k.e(getContext(), r.e.ds50), 0);
        this.bKb = (LinearLayout) LayoutInflater.from(this.mContext).inflate(r.h.pop_category, (ViewGroup) null);
        this.geS = (LinearLayout) this.bKb.findViewById(r.g.pop_category_layout);
        this.cdX = (TabMenuPopView) this.geS.findViewById(r.g.pop_category_view);
        this.cdJ = this.bKb.findViewById(r.g.pop_category_grav);
        this.cdJ.setOnClickListener(new e(this));
    }

    public void b(List<cy> list, cy cyVar, int i) {
        this.cdX.a(list, cyVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cdX.setOnItemClickCallBack(aVar);
    }

    public void bte() {
        if (this.geR) {
            setCompoundDrawables(null, null, this.geT, null);
            this.geR = false;
        } else {
            a(this);
            if (this.MU != null) {
                this.MU.refresh();
                this.MU.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.MU.setHeight(-1);
                this.MU.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.geU, null);
                this.geR = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.MU == null) {
            this.MU = new MorePopupWindow((Activity) this.mContext, this.bKb, this, av.getDrawable(r.f.transparent_bg), new f(this));
            this.MU.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void wH() {
        av.l(this, r.d.cp_bg_line_d);
        av.c(this, r.d.cp_cont_b, 1);
        if (this.geS != null) {
            av.l(this.geS, r.d.cp_bg_line_d);
        }
        if (this.cdX != null) {
            this.cdX.wH();
        }
    }

    public void btf() {
        if (this.MU != null) {
            this.MU.dismiss();
        }
    }
}
