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
    private MorePopupWindow amW;
    private LinearLayout duK;
    private View eeS;
    private TabMenuPopView efd;
    private boolean hZv;
    private LinearLayout hZw;
    private Drawable hZx;
    private Drawable hZy;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hZv = false;
        this.hZx = al.getDrawable(e.f.icon_title_down);
        this.hZx.setBounds(0, 0, this.hZx.getIntrinsicWidth(), this.hZx.getIntrinsicHeight());
        this.hZy = al.getDrawable(e.f.icon_title_up);
        this.hZy.setBounds(0, 0, this.hZy.getIntrinsicWidth(), this.hZx.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hZx, null);
        setPadding(0, 0, l.h(getContext(), e.C0210e.ds50), 0);
        this.duK = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.pop_category, (ViewGroup) null);
        this.hZw = (LinearLayout) this.duK.findViewById(e.g.pop_category_layout);
        this.efd = (TabMenuPopView) this.hZw.findViewById(e.g.pop_category_view);
        this.eeS = this.duK.findViewById(e.g.pop_category_grav);
        this.eeS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bPE();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.efd.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.efd.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.efd.setOnItemClickCallBack(aVar);
    }

    public void bPD() {
        if (this.hZv) {
            setCompoundDrawables(null, null, this.hZx, null);
            this.hZv = false;
        } else {
            a(this);
            if (this.amW != null) {
                this.amW.refresh();
                this.amW.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.amW.setHeight(-1);
                this.amW.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hZy, null);
                this.hZv = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.amW == null) {
            this.amW = new MorePopupWindow((Activity) this.mContext, this.duK, this, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xd() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xe() {
                    if (PostCategoryView.this.amW != null) {
                        PostCategoryView.this.amW.dismiss();
                    }
                }
            });
            this.amW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bPD();
                    }
                }
            });
        }
    }

    public void Fj() {
        al.j(this, e.d.cp_bg_line_d);
        al.c(this, e.d.cp_cont_b, 1);
        if (this.hZw != null) {
            al.j(this.hZw, e.d.cp_bg_line_d);
        }
        if (this.efd != null) {
            this.efd.Fj();
        }
    }

    public void bPE() {
        if (this.amW != null) {
            this.amW.dismiss();
        }
    }
}
