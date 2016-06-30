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
    private MorePopupWindow KJ;
    private View bQG;
    private TabMenuPopView bQU;
    private LinearLayout bwk;
    private boolean fGL;
    private LinearLayout fGM;
    private Drawable fGN;
    private Drawable fGO;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.fGL = false;
        this.fGN = av.getDrawable(u.f.icon_title_down);
        this.fGN.setBounds(0, 0, this.fGN.getIntrinsicWidth(), this.fGN.getIntrinsicHeight());
        this.fGO = av.getDrawable(u.f.icon_title_up);
        this.fGO.setBounds(0, 0, this.fGO.getIntrinsicWidth(), this.fGN.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.fGN, null);
        setPadding(0, 0, k.c(getContext(), u.e.ds50), 0);
        this.bwk = (LinearLayout) LayoutInflater.from(this.mContext).inflate(u.h.pop_category, (ViewGroup) null);
        this.fGM = (LinearLayout) this.bwk.findViewById(u.g.pop_category_layout);
        this.bQU = (TabMenuPopView) this.fGM.findViewById(u.g.pop_category_view);
        this.bQG = this.bwk.findViewById(u.g.pop_category_grav);
        this.bQG.setOnClickListener(new g(this));
    }

    public void b(List<dc> list, dc dcVar, int i) {
        this.bQU.a(list, dcVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.bQU.setOnItemClickCallBack(aVar);
    }

    public void blo() {
        if (this.fGL) {
            setCompoundDrawables(null, null, this.fGN, null);
            this.fGL = false;
        } else {
            a(this);
            if (this.KJ != null) {
                this.KJ.refresh();
                this.KJ.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.KJ.setHeight(-1);
                this.KJ.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.fGO, null);
                this.fGL = true;
            }
        }
        invalidate();
    }

    private void a(PostCategoryView postCategoryView) {
        if (this.KJ == null) {
            this.KJ = new MorePopupWindow((Activity) this.mContext, this.bwk, this, av.getDrawable(u.f.transparent_bg), new h(this));
            this.KJ.setOnDismissListener(new i(this, postCategoryView));
        }
    }

    public void vm() {
        av.l(this, u.d.cp_bg_line_d);
        av.c(this, u.d.cp_cont_b, 1);
        if (this.fGM != null) {
            av.l(this.fGM, u.d.cp_bg_line_d);
        }
        if (this.bQU != null) {
            this.bQU.vm();
        }
    }

    public void blp() {
        if (this.KJ != null) {
            this.KJ.dismiss();
        }
    }
}
