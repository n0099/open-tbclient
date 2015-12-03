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
    private LinearLayout aTy;
    private TabMenuPopView biN;
    private View biz;
    private boolean dOd;
    private LinearLayout dOe;
    private Drawable dOf;
    private Drawable dOg;
    private Context mContext;
    private MorePopupWindow mPopWindow;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.dOd = false;
        this.dOf = as.getDrawable(n.e.icon_title_down);
        this.dOf.setBounds(0, 0, this.dOf.getIntrinsicWidth(), this.dOf.getIntrinsicHeight());
        this.dOg = as.getDrawable(n.e.icon_title_up);
        this.dOg.setBounds(0, 0, this.dOg.getIntrinsicWidth(), this.dOf.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.dOf, null);
        setPadding(0, 0, k.d(getContext(), n.d.ds50), 0);
        this.aTy = (LinearLayout) LayoutInflater.from(this.mContext).inflate(n.g.pop_category, (ViewGroup) null);
        this.dOe = (LinearLayout) this.aTy.findViewById(n.f.pop_category_layout);
        this.biN = (TabMenuPopView) this.dOe.findViewById(n.f.pop_category_view);
        this.biz = this.aTy.findViewById(n.f.pop_category_grav);
        this.biz.setOnClickListener(new g(this));
    }

    public void b(List<ec> list, ec ecVar, int i) {
        this.biN.a(list, ecVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.biN.setOnItemClickCallBack(aVar);
    }

    public void aII() {
        if (this.dOd) {
            setCompoundDrawables(null, null, this.dOf, null);
            this.dOd = false;
        } else {
            a(this);
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
                this.mPopWindow.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.mPopWindow.setHeight(-1);
                this.mPopWindow.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.dOg, null);
                this.dOd = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow((Activity) this.mContext, this.aTy, this, as.getDrawable(n.e.transparent_bg), new h(this));
            this.mPopWindow.setOnDismissListener(new i(this, postCategoryView));
        }
    }

    public void wh() {
        as.j((View) this, n.c.cp_bg_line_d);
        as.b(this, n.c.cp_cont_b, 1);
        if (this.dOe != null) {
            as.j(this.dOe, n.c.cp_bg_line_d);
        }
        if (this.biN != null) {
            this.biN.wh();
        }
    }

    public void aIJ() {
        if (this.mPopWindow != null) {
            this.mPopWindow.dismiss();
        }
    }
}
