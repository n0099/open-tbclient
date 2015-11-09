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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private LinearLayout aOv;
    private View bbU;
    private TabMenuPopView bci;
    private boolean doZ;
    private LinearLayout dpa;
    private Drawable dpb;
    private Drawable dpc;
    private Context mContext;
    private MorePopupWindow mPopWindow;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.doZ = false;
        this.dpb = an.getDrawable(i.e.icon_title_down);
        this.dpb.setBounds(0, 0, this.dpb.getIntrinsicWidth(), this.dpb.getIntrinsicHeight());
        this.dpc = an.getDrawable(i.e.icon_title_up);
        this.dpc.setBounds(0, 0, this.dpc.getIntrinsicWidth(), this.dpb.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.dpb, null);
        setPadding(0, 0, k.d(getContext(), i.d.ds50), 0);
        this.aOv = (LinearLayout) LayoutInflater.from(this.mContext).inflate(i.g.pop_category, (ViewGroup) null);
        this.dpa = (LinearLayout) this.aOv.findViewById(i.f.pop_category_layout);
        this.bci = (TabMenuPopView) this.dpa.findViewById(i.f.pop_category_view);
        this.bbU = this.aOv.findViewById(i.f.pop_category_grav);
        this.bbU.setOnClickListener(new g(this));
    }

    public void b(List<dm> list, dm dmVar, int i) {
        this.bci.a(list, dmVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bci.setOnItemClickCallBack(aVar);
    }

    public void aDl() {
        if (this.doZ) {
            setCompoundDrawables(null, null, this.dpb, null);
            this.doZ = false;
        } else {
            a(this);
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
                this.mPopWindow.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.mPopWindow.setHeight(-1);
                this.mPopWindow.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.dpc, null);
                this.doZ = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow((Activity) this.mContext, this.aOv, this, an.getDrawable(i.e.transparent_bg), new h(this));
            this.mPopWindow.setOnDismissListener(new i(this, postCategoryView));
        }
    }

    public void vB() {
        an.j((View) this, i.c.cp_bg_line_d);
        an.b(this, i.c.cp_cont_b, 1);
        if (this.dpa != null) {
            an.j(this.dpa, i.c.cp_bg_line_d);
        }
        if (this.bci != null) {
            this.bci.vB();
        }
    }

    public void aDm() {
        if (this.mPopWindow != null) {
            this.mPopWindow.dismiss();
        }
    }
}
