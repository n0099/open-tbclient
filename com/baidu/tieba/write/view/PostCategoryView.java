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
import com.baidu.tieba.frs.em;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow KJ;
    private LinearLayout ban;
    private View btc;
    private TabMenuPopView btq;
    private boolean fbg;
    private LinearLayout fbh;
    private Drawable fbi;
    private Drawable fbj;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fbg = false;
        this.fbi = at.getDrawable(t.f.icon_title_down);
        this.fbi.setBounds(0, 0, this.fbi.getIntrinsicWidth(), this.fbi.getIntrinsicHeight());
        this.fbj = at.getDrawable(t.f.icon_title_up);
        this.fbj.setBounds(0, 0, this.fbj.getIntrinsicWidth(), this.fbi.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fbi, null);
        setPadding(0, 0, k.c(getContext(), t.e.ds50), 0);
        this.ban = (LinearLayout) LayoutInflater.from(this.mContext).inflate(t.h.pop_category, (ViewGroup) null);
        this.fbh = (LinearLayout) this.ban.findViewById(t.g.pop_category_layout);
        this.btq = (TabMenuPopView) this.fbh.findViewById(t.g.pop_category_view);
        this.btc = this.ban.findViewById(t.g.pop_category_grav);
        this.btc.setOnClickListener(new g(this));
    }

    public void b(List<em> list, em emVar, int i) {
        this.btq.a(list, emVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.btq.setOnItemClickCallBack(aVar);
    }

    public void bcS() {
        if (this.fbg) {
            setCompoundDrawables(null, null, this.fbi, null);
            this.fbg = false;
        } else {
            a(this);
            if (this.KJ != null) {
                this.KJ.refresh();
                this.KJ.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.KJ.setHeight(-1);
                this.KJ.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fbj, null);
                this.fbg = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.KJ == null) {
            this.KJ = new MorePopupWindow((Activity) this.mContext, this.ban, this, at.getDrawable(t.f.transparent_bg), new h(this));
            this.KJ.setOnDismissListener(new i(this, postCategoryView));
        }
    }

    public void vm() {
        at.l(this, t.d.cp_bg_line_d);
        at.c(this, t.d.cp_cont_b, 1);
        if (this.fbh != null) {
            at.l(this.fbh, t.d.cp_bg_line_d);
        }
        if (this.btq != null) {
            this.btq.vm();
        }
    }

    public void bcT() {
        if (this.KJ != null) {
            this.KJ.dismiss();
        }
    }
}
