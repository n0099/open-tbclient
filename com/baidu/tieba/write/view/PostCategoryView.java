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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.en;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow Su;
    private LinearLayout aZO;
    private View bpe;
    private TabMenuPopView bpt;
    private boolean eqv;
    private LinearLayout eqw;
    private Drawable eqx;
    private Drawable eqy;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.eqv = false;
        this.eqx = ar.getDrawable(t.f.icon_title_down);
        this.eqx.setBounds(0, 0, this.eqx.getIntrinsicWidth(), this.eqx.getIntrinsicHeight());
        this.eqy = ar.getDrawable(t.f.icon_title_up);
        this.eqy.setBounds(0, 0, this.eqy.getIntrinsicWidth(), this.eqx.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.eqx, null);
        setPadding(0, 0, k.c(getContext(), t.e.ds50), 0);
        this.aZO = (LinearLayout) LayoutInflater.from(this.mContext).inflate(t.h.pop_category, (ViewGroup) null);
        this.eqw = (LinearLayout) this.aZO.findViewById(t.g.pop_category_layout);
        this.bpt = (TabMenuPopView) this.eqw.findViewById(t.g.pop_category_view);
        this.bpe = this.aZO.findViewById(t.g.pop_category_grav);
        this.bpe.setOnClickListener(new g(this));
    }

    public void b(List<en> list, en enVar, int i) {
        this.bpt.a(list, enVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bpt.setOnItemClickCallBack(aVar);
    }

    public void aTY() {
        if (this.eqv) {
            setCompoundDrawables(null, null, this.eqx, null);
            this.eqv = false;
        } else {
            a(this);
            if (this.Su != null) {
                this.Su.refresh();
                this.Su.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Su.setHeight(-1);
                this.Su.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.eqy, null);
                this.eqv = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.Su == null) {
            this.Su = new MorePopupWindow((Activity) this.mContext, this.aZO, this, ar.getDrawable(t.f.transparent_bg), new h(this));
            this.Su.setOnDismissListener(new i(this, postCategoryView));
        }
    }

    public void xf() {
        ar.l(this, t.d.cp_bg_line_d);
        ar.b(this, t.d.cp_cont_b, 1);
        if (this.eqw != null) {
            ar.l(this.eqw, t.d.cp_bg_line_d);
        }
        if (this.bpt != null) {
            this.bpt.xf();
        }
    }

    public void aTZ() {
        if (this.Su != null) {
            this.Su.dismiss();
        }
    }
}
