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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow Mf;
    private LinearLayout bAK;
    private View bTH;
    private TabMenuPopView bTV;
    private boolean fJt;
    private LinearLayout fJu;
    private Drawable fJv;
    private Drawable fJw;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fJt = false;
        this.fJv = ap.getDrawable(r.g.icon_title_down);
        this.fJv.setBounds(0, 0, this.fJv.getIntrinsicWidth(), this.fJv.getIntrinsicHeight());
        this.fJw = ap.getDrawable(r.g.icon_title_up);
        this.fJw.setBounds(0, 0, this.fJw.getIntrinsicWidth(), this.fJv.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fJv, null);
        setPadding(0, 0, k.e(getContext(), r.f.ds50), 0);
        this.bAK = (LinearLayout) LayoutInflater.from(this.mContext).inflate(r.j.pop_category, (ViewGroup) null);
        this.fJu = (LinearLayout) this.bAK.findViewById(r.h.pop_category_layout);
        this.bTV = (TabMenuPopView) this.fJu.findViewById(r.h.pop_category_view);
        this.bTH = this.bAK.findViewById(r.h.pop_category_grav);
        this.bTH.setOnClickListener(new e(this));
    }

    public void b(List<bt> list, bt btVar, int i) {
        this.bTV.a(list, btVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bTV.setOnItemClickCallBack(aVar);
    }

    public void bnV() {
        if (this.fJt) {
            setCompoundDrawables(null, null, this.fJv, null);
            this.fJt = false;
        } else {
            a(this);
            if (this.Mf != null) {
                this.Mf.refresh();
                this.Mf.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Mf.setHeight(-1);
                this.Mf.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fJw, null);
                this.fJt = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.Mf == null) {
            this.Mf = new MorePopupWindow((Activity) this.mContext, this.bAK, this, ap.getDrawable(r.g.transparent_bg), new f(this));
            this.Mf.setOnDismissListener(new g(this, postCategoryView));
        }
    }

    public void ws() {
        ap.k(this, r.e.cp_bg_line_d);
        ap.c(this, r.e.cp_cont_b, 1);
        if (this.fJu != null) {
            ap.k(this.fJu, r.e.cp_bg_line_d);
        }
        if (this.bTV != null) {
            this.bTV.ws();
        }
    }

    public void bnW() {
        if (this.Mf != null) {
            this.Mf.dismiss();
        }
    }
}
