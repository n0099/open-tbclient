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
    private MorePopupWindow adK;
    private TabMenuPopView dMH;
    private View dMw;
    private LinearLayout dcf;
    private boolean hGd;
    private LinearLayout hGe;
    private Drawable hGf;
    private Drawable hGg;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hGd = false;
        this.hGf = al.getDrawable(e.f.icon_title_down);
        this.hGf.setBounds(0, 0, this.hGf.getIntrinsicWidth(), this.hGf.getIntrinsicHeight());
        this.hGg = al.getDrawable(e.f.icon_title_up);
        this.hGg.setBounds(0, 0, this.hGg.getIntrinsicWidth(), this.hGf.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hGf, null);
        setPadding(0, 0, l.h(getContext(), e.C0141e.ds50), 0);
        this.dcf = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.pop_category, (ViewGroup) null);
        this.hGe = (LinearLayout) this.dcf.findViewById(e.g.pop_category_layout);
        this.dMH = (TabMenuPopView) this.hGe.findViewById(e.g.pop_category_view);
        this.dMw = this.dcf.findViewById(e.g.pop_category_grav);
        this.dMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bJX();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.dMH.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.dMH.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dMH.setOnItemClickCallBack(aVar);
    }

    public void bJW() {
        if (this.hGd) {
            setCompoundDrawables(null, null, this.hGf, null);
            this.hGd = false;
        } else {
            a(this);
            if (this.adK != null) {
                this.adK.refresh();
                this.adK.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.adK.setHeight(-1);
                this.adK.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hGg, null);
                this.hGd = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.adK == null) {
            this.adK = new MorePopupWindow((Activity) this.mContext, this.dcf, this, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void tI() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void tJ() {
                    if (PostCategoryView.this.adK != null) {
                        PostCategoryView.this.adK.dismiss();
                    }
                }
            });
            this.adK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bJW();
                    }
                }
            });
        }
    }

    public void BQ() {
        al.j(this, e.d.cp_bg_line_d);
        al.c(this, e.d.cp_cont_b, 1);
        if (this.hGe != null) {
            al.j(this.hGe, e.d.cp_bg_line_d);
        }
        if (this.dMH != null) {
            this.dMH.BQ();
        }
    }

    public void bJX() {
        if (this.adK != null) {
            this.adK.dismiss();
        }
    }
}
