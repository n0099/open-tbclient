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
    private MorePopupWindow buo;
    private LinearLayout eIu;
    private View ftB;
    private TabMenuPopView ftM;
    private boolean jrp;
    private LinearLayout jrq;
    private Drawable jrr;
    private Drawable jrs;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jrp = false;
        this.jrr = al.getDrawable(d.f.icon_title_down);
        this.jrr.setBounds(0, 0, this.jrr.getIntrinsicWidth(), this.jrr.getIntrinsicHeight());
        this.jrs = al.getDrawable(d.f.icon_title_up);
        this.jrs.setBounds(0, 0, this.jrs.getIntrinsicWidth(), this.jrr.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jrr, null);
        setPadding(0, 0, l.h(getContext(), d.e.ds50), 0);
        this.eIu = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.jrq = (LinearLayout) this.eIu.findViewById(d.g.pop_category_layout);
        this.ftM = (TabMenuPopView) this.jrq.findViewById(d.g.pop_category_view);
        this.ftB = this.eIu.findViewById(d.g.pop_category_grav);
        this.ftB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cqh();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.ftM.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.ftM.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.ftM.setOnItemClickCallBack(aVar);
    }

    public void cqg() {
        if (this.jrp) {
            setCompoundDrawables(null, null, this.jrr, null);
            this.jrp = false;
        } else {
            a(this);
            if (this.buo != null) {
                this.buo.refresh();
                this.buo.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.buo.setHeight(-1);
                this.buo.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jrs, null);
                this.jrp = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.buo == null) {
            this.buo = new MorePopupWindow((Activity) this.mContext, this.eIu, this, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VU() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VV() {
                    if (PostCategoryView.this.buo != null) {
                        PostCategoryView.this.buo.dismiss();
                    }
                }
            });
            this.buo.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cqg();
                    }
                }
            });
        }
    }

    public void aeH() {
        al.l(this, d.C0277d.cp_bg_line_d);
        al.d(this, d.C0277d.cp_cont_b, 1);
        if (this.jrq != null) {
            al.l(this.jrq, d.C0277d.cp_bg_line_d);
        }
        if (this.ftM != null) {
            this.ftM.aeH();
        }
    }

    public void cqh() {
        if (this.buo != null) {
            this.buo.dismiss();
        }
    }
}
