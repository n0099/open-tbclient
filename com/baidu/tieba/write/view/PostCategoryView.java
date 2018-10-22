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
    private MorePopupWindow aiH;
    private TabMenuPopView dUD;
    private View dUs;
    private LinearLayout dkp;
    private boolean hNq;
    private LinearLayout hNr;
    private Drawable hNs;
    private Drawable hNt;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hNq = false;
        this.hNs = al.getDrawable(e.f.icon_title_down);
        this.hNs.setBounds(0, 0, this.hNs.getIntrinsicWidth(), this.hNs.getIntrinsicHeight());
        this.hNt = al.getDrawable(e.f.icon_title_up);
        this.hNt.setBounds(0, 0, this.hNt.getIntrinsicWidth(), this.hNs.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hNs, null);
        setPadding(0, 0, l.h(getContext(), e.C0175e.ds50), 0);
        this.dkp = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.pop_category, (ViewGroup) null);
        this.hNr = (LinearLayout) this.dkp.findViewById(e.g.pop_category_layout);
        this.dUD = (TabMenuPopView) this.hNr.findViewById(e.g.pop_category_view);
        this.dUs = this.dkp.findViewById(e.g.pop_category_grav);
        this.dUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bNj();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.dUD.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.dUD.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dUD.setOnItemClickCallBack(aVar);
    }

    public void bNi() {
        if (this.hNq) {
            setCompoundDrawables(null, null, this.hNs, null);
            this.hNq = false;
        } else {
            a(this);
            if (this.aiH != null) {
                this.aiH.refresh();
                this.aiH.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aiH.setHeight(-1);
                this.aiH.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hNt, null);
                this.hNq = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aiH == null) {
            this.aiH = new MorePopupWindow((Activity) this.mContext, this.dkp, this, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void vR() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void vS() {
                    if (PostCategoryView.this.aiH != null) {
                        PostCategoryView.this.aiH.dismiss();
                    }
                }
            });
            this.aiH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bNi();
                    }
                }
            });
        }
    }

    public void DV() {
        al.j(this, e.d.cp_bg_line_d);
        al.c(this, e.d.cp_cont_b, 1);
        if (this.hNr != null) {
            al.j(this.hNr, e.d.cp_bg_line_d);
        }
        if (this.dUD != null) {
            this.dUD.DV();
        }
    }

    public void bNj() {
        if (this.aiH != null) {
            this.aiH.dismiss();
        }
    }
}
