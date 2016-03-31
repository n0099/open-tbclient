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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow PS;
    private LinearLayout bez;
    private View bug;
    private TabMenuPopView buu;
    private boolean eKq;
    private LinearLayout eKr;
    private Drawable eKs;
    private Drawable eKt;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.eKq = false;
        this.eKs = at.getDrawable(t.f.icon_title_down);
        this.eKs.setBounds(0, 0, this.eKs.getIntrinsicWidth(), this.eKs.getIntrinsicHeight());
        this.eKt = at.getDrawable(t.f.icon_title_up);
        this.eKt.setBounds(0, 0, this.eKt.getIntrinsicWidth(), this.eKs.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.eKs, null);
        setPadding(0, 0, k.c(getContext(), t.e.ds50), 0);
        this.bez = (LinearLayout) LayoutInflater.from(this.mContext).inflate(t.h.pop_category, (ViewGroup) null);
        this.eKr = (LinearLayout) this.bez.findViewById(t.g.pop_category_layout);
        this.buu = (TabMenuPopView) this.eKr.findViewById(t.g.pop_category_view);
        this.bug = this.bez.findViewById(t.g.pop_category_grav);
        this.bug.setOnClickListener(new g(this));
    }

    public void b(List<ev> list, ev evVar, int i) {
        this.buu.a(list, evVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.buu.setOnItemClickCallBack(aVar);
    }

    public void bay() {
        if (this.eKq) {
            setCompoundDrawables(null, null, this.eKs, null);
            this.eKq = false;
        } else {
            a(this);
            if (this.PS != null) {
                this.PS.refresh();
                this.PS.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.PS.setHeight(-1);
                this.PS.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.eKt, null);
                this.eKq = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.PS == null) {
            this.PS = new MorePopupWindow((Activity) this.mContext, this.bez, this, at.getDrawable(t.f.transparent_bg), new h(this));
            this.PS.setOnDismissListener(new i(this, postCategoryView));
        }
    }

    public void xy() {
        at.l(this, t.d.cp_bg_line_d);
        at.b(this, t.d.cp_cont_b, 1);
        if (this.eKr != null) {
            at.l(this.eKr, t.d.cp_bg_line_d);
        }
        if (this.buu != null) {
            this.buu.xy();
        }
    }

    public void baz() {
        if (this.PS != null) {
            this.PS.dismiss();
        }
    }
}
