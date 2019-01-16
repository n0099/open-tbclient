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
    private MorePopupWindow any;
    private LinearLayout dvt;
    private TabMenuPopView efJ;
    private View efy;
    private boolean iaC;
    private LinearLayout iaD;
    private Drawable iaE;
    private Drawable iaF;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.iaC = false;
        this.iaE = al.getDrawable(e.f.icon_title_down);
        this.iaE.setBounds(0, 0, this.iaE.getIntrinsicWidth(), this.iaE.getIntrinsicHeight());
        this.iaF = al.getDrawable(e.f.icon_title_up);
        this.iaF.setBounds(0, 0, this.iaF.getIntrinsicWidth(), this.iaE.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.iaE, null);
        setPadding(0, 0, l.h(getContext(), e.C0210e.ds50), 0);
        this.dvt = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.pop_category, (ViewGroup) null);
        this.iaD = (LinearLayout) this.dvt.findViewById(e.g.pop_category_layout);
        this.efJ = (TabMenuPopView) this.iaD.findViewById(e.g.pop_category_view);
        this.efy = this.dvt.findViewById(e.g.pop_category_grav);
        this.efy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bQm();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.efJ.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.efJ.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.efJ.setOnItemClickCallBack(aVar);
    }

    public void bQl() {
        if (this.iaC) {
            setCompoundDrawables(null, null, this.iaE, null);
            this.iaC = false;
        } else {
            a(this);
            if (this.any != null) {
                this.any.refresh();
                this.any.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.any.setHeight(-1);
                this.any.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.iaF, null);
                this.iaC = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.any == null) {
            this.any = new MorePopupWindow((Activity) this.mContext, this.dvt, this, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xq() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xr() {
                    if (PostCategoryView.this.any != null) {
                        PostCategoryView.this.any.dismiss();
                    }
                }
            });
            this.any.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
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
        if (this.iaD != null) {
            al.j(this.iaD, e.d.cp_bg_line_d);
        }
        if (this.efJ != null) {
            this.efJ.Fw();
        }
    }

    public void bQm() {
        if (this.any != null) {
            this.any.dismiss();
        }
    }
}
