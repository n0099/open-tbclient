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
    private MorePopupWindow abD;
    private LinearLayout cTD;
    private View dCF;
    private TabMenuPopView dCS;
    private Drawable hwA;
    private boolean hwx;
    private LinearLayout hwy;
    private Drawable hwz;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hwx = false;
        this.hwz = am.getDrawable(d.f.icon_title_down);
        this.hwz.setBounds(0, 0, this.hwz.getIntrinsicWidth(), this.hwz.getIntrinsicHeight());
        this.hwA = am.getDrawable(d.f.icon_title_up);
        this.hwA.setBounds(0, 0, this.hwA.getIntrinsicWidth(), this.hwz.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hwz, null);
        setPadding(0, 0, l.e(getContext(), d.e.ds50), 0);
        this.cTD = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.i.pop_category, (ViewGroup) null);
        this.hwy = (LinearLayout) this.cTD.findViewById(d.g.pop_category_layout);
        this.dCS = (TabMenuPopView) this.hwy.findViewById(d.g.pop_category_view);
        this.dCF = this.cTD.findViewById(d.g.pop_category_grav);
        this.dCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bIr();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.dCS.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.dCS.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dCS.setOnItemClickCallBack(aVar);
    }

    public void bIq() {
        if (this.hwx) {
            setCompoundDrawables(null, null, this.hwz, null);
            this.hwx = false;
        } else {
            a(this);
            if (this.abD != null) {
                this.abD.refresh();
                this.abD.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.abD.setHeight(-1);
                this.abD.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hwA, null);
                this.hwx = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.abD == null) {
            this.abD = new MorePopupWindow((Activity) this.mContext, this.cTD, this, am.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sQ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sR() {
                    if (PostCategoryView.this.abD != null) {
                        PostCategoryView.this.abD.dismiss();
                    }
                }
            });
            this.abD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bIq();
                    }
                }
            });
        }
    }

    public void AP() {
        am.j(this, d.C0142d.cp_bg_line_d);
        am.c(this, d.C0142d.cp_cont_b, 1);
        if (this.hwy != null) {
            am.j(this.hwy, d.C0142d.cp_bg_line_d);
        }
        if (this.dCS != null) {
            this.dCS.AP();
        }
    }

    public void bIr() {
        if (this.abD != null) {
            this.abD.dismiss();
        }
    }
}
