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
    private LinearLayout drW;
    private View ecb;
    private TabMenuPopView ecm;
    private boolean hWk;
    private LinearLayout hWl;
    private Drawable hWm;
    private Drawable hWn;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hWk = false;
        this.hWm = al.getDrawable(e.f.icon_title_down);
        this.hWm.setBounds(0, 0, this.hWm.getIntrinsicWidth(), this.hWm.getIntrinsicHeight());
        this.hWn = al.getDrawable(e.f.icon_title_up);
        this.hWn.setBounds(0, 0, this.hWn.getIntrinsicWidth(), this.hWm.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hWm, null);
        setPadding(0, 0, l.h(getContext(), e.C0210e.ds50), 0);
        this.drW = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.pop_category, (ViewGroup) null);
        this.hWl = (LinearLayout) this.drW.findViewById(e.g.pop_category_layout);
        this.ecm = (TabMenuPopView) this.hWl.findViewById(e.g.pop_category_view);
        this.ecb = this.drW.findViewById(e.g.pop_category_grav);
        this.ecb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bON();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.ecm.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.ecm.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.ecm.setOnItemClickCallBack(aVar);
    }

    public void bOM() {
        if (this.hWk) {
            setCompoundDrawables(null, null, this.hWm, null);
            this.hWk = false;
        } else {
            a(this);
            if (this.amW != null) {
                this.amW.refresh();
                this.amW.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.amW.setHeight(-1);
                this.amW.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hWn, null);
                this.hWk = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.amW == null) {
            this.amW = new MorePopupWindow((Activity) this.mContext, this.drW, this, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
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
                        postCategoryView.bOM();
                    }
                }
            });
        }
    }

    public void Fj() {
        al.j(this, e.d.cp_bg_line_d);
        al.c(this, e.d.cp_cont_b, 1);
        if (this.hWl != null) {
            al.j(this.hWl, e.d.cp_bg_line_d);
        }
        if (this.ecm != null) {
            this.ecm.Fj();
        }
    }

    public void bON() {
        if (this.amW != null) {
            this.amW.dismiss();
        }
    }
}
