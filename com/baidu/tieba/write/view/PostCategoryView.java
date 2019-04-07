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
    private MorePopupWindow bun;
    private LinearLayout eIt;
    private View ftB;
    private TabMenuPopView ftM;
    private boolean jro;
    private LinearLayout jrp;
    private Drawable jrq;
    private Drawable jrr;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jro = false;
        this.jrq = al.getDrawable(d.f.icon_title_down);
        this.jrq.setBounds(0, 0, this.jrq.getIntrinsicWidth(), this.jrq.getIntrinsicHeight());
        this.jrr = al.getDrawable(d.f.icon_title_up);
        this.jrr.setBounds(0, 0, this.jrr.getIntrinsicWidth(), this.jrq.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jrq, null);
        setPadding(0, 0, l.h(getContext(), d.e.ds50), 0);
        this.eIt = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.jrp = (LinearLayout) this.eIt.findViewById(d.g.pop_category_layout);
        this.ftM = (TabMenuPopView) this.jrp.findViewById(d.g.pop_category_view);
        this.ftB = this.eIt.findViewById(d.g.pop_category_grav);
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
        if (this.jro) {
            setCompoundDrawables(null, null, this.jrq, null);
            this.jro = false;
        } else {
            a(this);
            if (this.bun != null) {
                this.bun.refresh();
                this.bun.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bun.setHeight(-1);
                this.bun.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jrr, null);
                this.jro = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bun == null) {
            this.bun = new MorePopupWindow((Activity) this.mContext, this.eIt, this, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VU() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VV() {
                    if (PostCategoryView.this.bun != null) {
                        PostCategoryView.this.bun.dismiss();
                    }
                }
            });
            this.bun.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
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
        if (this.jrp != null) {
            al.l(this.jrp, d.C0277d.cp_bg_line_d);
        }
        if (this.ftM != null) {
            this.ftM.aeH();
        }
    }

    public void cqh() {
        if (this.bun != null) {
            this.bun.dismiss();
        }
    }
}
