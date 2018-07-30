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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow abg;
    private LinearLayout cWq;
    private TabMenuPopView dFE;
    private View dFr;
    private boolean hxE;
    private LinearLayout hxF;
    private Drawable hxG;
    private Drawable hxH;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hxE = false;
        this.hxG = am.getDrawable(d.f.icon_title_down);
        this.hxG.setBounds(0, 0, this.hxG.getIntrinsicWidth(), this.hxG.getIntrinsicHeight());
        this.hxH = am.getDrawable(d.f.icon_title_up);
        this.hxH.setBounds(0, 0, this.hxH.getIntrinsicWidth(), this.hxG.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hxG, null);
        setPadding(0, 0, l.f(getContext(), d.e.ds50), 0);
        this.cWq = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hxF = (LinearLayout) this.cWq.findViewById(d.g.pop_category_layout);
        this.dFE = (TabMenuPopView) this.hxF.findViewById(d.g.pop_category_view);
        this.dFr = this.cWq.findViewById(d.g.pop_category_grav);
        this.dFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHc();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.dFE.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.dFE.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dFE.setOnItemClickCallBack(aVar);
    }

    public void bHb() {
        if (this.hxE) {
            setCompoundDrawables(null, null, this.hxG, null);
            this.hxE = false;
        } else {
            a(this);
            if (this.abg != null) {
                this.abg.refresh();
                this.abg.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.abg.setHeight(-1);
                this.abg.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hxH, null);
                this.hxE = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.abg == null) {
            this.abg = new MorePopupWindow((Activity) this.mContext, this.cWq, this, am.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sC() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sD() {
                    if (PostCategoryView.this.abg != null) {
                        PostCategoryView.this.abg.dismiss();
                    }
                }
            });
            this.abg.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHb();
                    }
                }
            });
        }
    }

    public void AG() {
        am.j(this, d.C0140d.cp_bg_line_d);
        am.c(this, d.C0140d.cp_cont_b, 1);
        if (this.hxF != null) {
            am.j(this.hxF, d.C0140d.cp_bg_line_d);
        }
        if (this.dFE != null) {
            this.dFE.AG();
        }
    }

    public void bHc() {
        if (this.abg != null) {
            this.abg.dismiss();
        }
    }
}
