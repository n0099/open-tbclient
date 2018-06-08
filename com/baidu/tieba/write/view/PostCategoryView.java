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
    private MorePopupWindow abA;
    private LinearLayout cVB;
    private TabMenuPopView dzG;
    private View dzs;
    private boolean hso;
    private LinearLayout hsp;
    private Drawable hsq;
    private Drawable hsr;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hso = false;
        this.hsq = al.getDrawable(d.f.icon_title_down);
        this.hsq.setBounds(0, 0, this.hsq.getIntrinsicWidth(), this.hsq.getIntrinsicHeight());
        this.hsr = al.getDrawable(d.f.icon_title_up);
        this.hsr.setBounds(0, 0, this.hsr.getIntrinsicWidth(), this.hsq.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hsq, null);
        setPadding(0, 0, l.e(getContext(), d.e.ds50), 0);
        this.cVB = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.i.pop_category, (ViewGroup) null);
        this.hsp = (LinearLayout) this.cVB.findViewById(d.g.pop_category_layout);
        this.dzG = (TabMenuPopView) this.hsp.findViewById(d.g.pop_category_view);
        this.dzs = this.cVB.findViewById(d.g.pop_category_grav);
        this.dzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHQ();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.dzG.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.dzG.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dzG.setOnItemClickCallBack(aVar);
    }

    public void bHP() {
        if (this.hso) {
            setCompoundDrawables(null, null, this.hsq, null);
            this.hso = false;
        } else {
            a(this);
            if (this.abA != null) {
                this.abA.refresh();
                this.abA.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.abA.setHeight(-1);
                this.abA.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hsr, null);
                this.hso = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.abA == null) {
            this.abA = new MorePopupWindow((Activity) this.mContext, this.cVB, this, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sO() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sP() {
                    if (PostCategoryView.this.abA != null) {
                        PostCategoryView.this.abA.dismiss();
                    }
                }
            });
            this.abA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHP();
                    }
                }
            });
        }
    }

    public void Ay() {
        al.j(this, d.C0141d.cp_bg_line_d);
        al.c(this, d.C0141d.cp_cont_b, 1);
        if (this.hsp != null) {
            al.j(this.hsp, d.C0141d.cp_bg_line_d);
        }
        if (this.dzG != null) {
            this.dzG.Ay();
        }
    }

    public void bHQ() {
        if (this.abA != null) {
            this.abA.dismiss();
        }
    }
}
