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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow So;
    private LinearLayout cct;
    private TabMenuPopView cyG;
    private View cys;
    private boolean gFR;
    private LinearLayout gFS;
    private Drawable gFT;
    private Drawable gFU;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gFR = false;
        this.gFT = ai.getDrawable(d.g.icon_title_down);
        this.gFT.setBounds(0, 0, this.gFT.getIntrinsicWidth(), this.gFT.getIntrinsicHeight());
        this.gFU = ai.getDrawable(d.g.icon_title_up);
        this.gFU.setBounds(0, 0, this.gFU.getIntrinsicWidth(), this.gFT.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gFT, null);
        setPadding(0, 0, k.g(getContext(), d.f.ds50), 0);
        this.cct = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.j.pop_category, (ViewGroup) null);
        this.gFS = (LinearLayout) this.cct.findViewById(d.h.pop_category_layout);
        this.cyG = (TabMenuPopView) this.gFS.findViewById(d.h.pop_category_view);
        this.cys = this.cct.findViewById(d.h.pop_category_grav);
        this.cys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bzP();
            }
        });
    }

    public void b(List<x> list, x xVar, int i) {
        this.cyG.a(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cyG.setOnItemClickCallBack(aVar);
    }

    public void bzO() {
        if (this.gFR) {
            setCompoundDrawables(null, null, this.gFT, null);
            this.gFR = false;
        } else {
            a(this);
            if (this.So != null) {
                this.So.refresh();
                this.So.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.So.setHeight(-1);
                this.So.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gFU, null);
                this.gFR = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.So == null) {
            this.So = new MorePopupWindow((Activity) this.mContext, this.cct, this, ai.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void ot() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ou() {
                    if (PostCategoryView.this.So != null) {
                        PostCategoryView.this.So.dismiss();
                    }
                }
            });
            this.So.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bzO();
                    }
                }
            });
        }
    }

    public void xd() {
        ai.k(this, d.e.cp_bg_line_d);
        ai.c(this, d.e.cp_cont_b, 1);
        if (this.gFS != null) {
            ai.k(this.gFS, d.e.cp_bg_line_d);
        }
        if (this.cyG != null) {
            this.cyG.xd();
        }
    }

    public void bzP() {
        if (this.So != null) {
            this.So.dismiss();
        }
    }
}
