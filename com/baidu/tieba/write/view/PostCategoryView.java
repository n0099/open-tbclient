package com.baidu.tieba.write.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow anz;
    private LinearLayout dvu;
    private TabMenuPopView efK;
    private View efz;
    private boolean iaD;
    private LinearLayout iaE;
    private Drawable iaF;
    private Drawable iaG;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.iaD = false;
        this.iaF = al.getDrawable(e.f.icon_title_down);
        this.iaF.setBounds(0, 0, this.iaF.getIntrinsicWidth(), this.iaF.getIntrinsicHeight());
        this.iaG = al.getDrawable(e.f.icon_title_up);
        this.iaG.setBounds(0, 0, this.iaG.getIntrinsicWidth(), this.iaF.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.iaF, null);
        setPadding(0, 0, l.h(getContext(), e.C0210e.ds50), 0);
        this.dvu = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.pop_category, (ViewGroup) null);
        this.iaE = (LinearLayout) this.dvu.findViewById(e.g.pop_category_layout);
        this.efK = (TabMenuPopView) this.iaE.findViewById(e.g.pop_category_view);
        this.efz = this.dvu.findViewById(e.g.pop_category_grav);
        this.efz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bQm();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.efK.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.efK.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.efK.setOnItemClickCallBack(aVar);
    }

    public void bQl() {
        if (this.iaD) {
            setCompoundDrawables(null, null, this.iaF, null);
            this.iaD = false;
        } else {
            a(this);
            if (this.anz != null) {
                this.anz.refresh();
                this.anz.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.anz.setHeight(-1);
                this.anz.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.iaG, null);
                this.iaD = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.anz == null) {
            this.anz = new MorePopupWindow((Activity) this.mContext, this.dvu, this, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xq() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xr() {
                    if (PostCategoryView.this.anz != null) {
                        PostCategoryView.this.anz.dismiss();
                    }
                }
            });
            this.anz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bQl();
                    }
                }
            });
        }
    }

    public void Fw() {
        al.j(this, e.d.cp_bg_line_d);
        al.c(this, e.d.cp_cont_b, 1);
        if (this.iaE != null) {
            al.j(this.iaE, e.d.cp_bg_line_d);
        }
        if (this.efK != null) {
            this.efK.Fw();
        }
    }

    public void bQm() {
        if (this.anz != null) {
            this.anz.dismiss();
        }
    }
}
