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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow Tr;
    private LinearLayout cMv;
    private View dqg;
    private TabMenuPopView dqu;
    private boolean hgt;
    private LinearLayout hgu;
    private Drawable hgv;
    private Drawable hgw;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hgt = false;
        this.hgv = ak.getDrawable(d.f.icon_title_down);
        this.hgv.setBounds(0, 0, this.hgv.getIntrinsicWidth(), this.hgv.getIntrinsicHeight());
        this.hgw = ak.getDrawable(d.f.icon_title_up);
        this.hgw.setBounds(0, 0, this.hgw.getIntrinsicWidth(), this.hgv.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hgv, null);
        setPadding(0, 0, l.e(getContext(), d.e.ds50), 0);
        this.cMv = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.i.pop_category, (ViewGroup) null);
        this.hgu = (LinearLayout) this.cMv.findViewById(d.g.pop_category_layout);
        this.dqu = (TabMenuPopView) this.hgu.findViewById(d.g.pop_category_view);
        this.dqg = this.cMv.findViewById(d.g.pop_category_grav);
        this.dqg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PostCategoryView.this.bCL();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.dqu.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.dqu.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dqu.setOnItemClickCallBack(aVar);
    }

    public void bCK() {
        if (this.hgt) {
            setCompoundDrawables(null, null, this.hgv, null);
            this.hgt = false;
        } else {
            a(this);
            if (this.Tr != null) {
                this.Tr.refresh();
                this.Tr.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Tr.setHeight(-1);
                this.Tr.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hgw, null);
                this.hgt = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Tr == null) {
            this.Tr = new MorePopupWindow((Activity) this.mContext, this.cMv, this, ak.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pt() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pu() {
                    if (PostCategoryView.this.Tr != null) {
                        PostCategoryView.this.Tr.dismiss();
                    }
                }
            });
            this.Tr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bCK();
                    }
                }
            });
        }
    }

    public void wX() {
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.c(this, d.C0126d.cp_cont_b, 1);
        if (this.hgu != null) {
            ak.j(this.hgu, d.C0126d.cp_bg_line_d);
        }
        if (this.dqu != null) {
            this.dqu.wX();
        }
    }

    public void bCL() {
        if (this.Tr != null) {
            this.Tr.dismiss();
        }
    }
}
