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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow buk;
    private LinearLayout eIH;
    private View ftP;
    private TabMenuPopView fua;
    private Drawable jrA;
    private Drawable jrB;
    private boolean jry;
    private LinearLayout jrz;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jry = false;
        this.jrA = al.getDrawable(d.f.icon_title_down);
        this.jrA.setBounds(0, 0, this.jrA.getIntrinsicWidth(), this.jrA.getIntrinsicHeight());
        this.jrB = al.getDrawable(d.f.icon_title_up);
        this.jrB.setBounds(0, 0, this.jrB.getIntrinsicWidth(), this.jrA.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jrA, null);
        setPadding(0, 0, l.h(getContext(), d.e.ds50), 0);
        this.eIH = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.jrz = (LinearLayout) this.eIH.findViewById(d.g.pop_category_layout);
        this.fua = (TabMenuPopView) this.jrz.findViewById(d.g.pop_category_view);
        this.ftP = this.eIH.findViewById(d.g.pop_category_grav);
        this.ftP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cqj();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fua.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fua.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fua.setOnItemClickCallBack(aVar);
    }

    public void cqi() {
        if (this.jry) {
            setCompoundDrawables(null, null, this.jrA, null);
            this.jry = false;
        } else {
            a(this);
            if (this.buk != null) {
                this.buk.refresh();
                this.buk.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.buk.setHeight(-1);
                this.buk.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jrB, null);
                this.jry = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.buk == null) {
            this.buk = new MorePopupWindow((Activity) this.mContext, this.eIH, this, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VX() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VY() {
                    if (PostCategoryView.this.buk != null) {
                        PostCategoryView.this.buk.dismiss();
                    }
                }
            });
            this.buk.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cqi();
                    }
                }
            });
        }
    }

    public void aeK() {
        al.l(this, d.C0277d.cp_bg_line_d);
        al.d(this, d.C0277d.cp_cont_b, 1);
        if (this.jrz != null) {
            al.l(this.jrz, d.C0277d.cp_bg_line_d);
        }
        if (this.fua != null) {
            this.fua.aeK();
        }
    }

    public void cqj() {
        if (this.buk != null) {
            this.buk.dismiss();
        }
    }
}
