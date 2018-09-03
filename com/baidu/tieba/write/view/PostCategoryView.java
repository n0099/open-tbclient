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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow abh;
    private LinearLayout cWm;
    private TabMenuPopView dFA;
    private View dFo;
    private boolean hxG;
    private LinearLayout hxH;
    private Drawable hxI;
    private Drawable hxJ;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hxG = false;
        this.hxI = am.getDrawable(f.C0146f.icon_title_down);
        this.hxI.setBounds(0, 0, this.hxI.getIntrinsicWidth(), this.hxI.getIntrinsicHeight());
        this.hxJ = am.getDrawable(f.C0146f.icon_title_up);
        this.hxJ.setBounds(0, 0, this.hxJ.getIntrinsicWidth(), this.hxI.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hxI, null);
        setPadding(0, 0, l.f(getContext(), f.e.ds50), 0);
        this.cWm = (LinearLayout) LayoutInflater.from(this.mContext).inflate(f.h.pop_category, (ViewGroup) null);
        this.hxH = (LinearLayout) this.cWm.findViewById(f.g.pop_category_layout);
        this.dFA = (TabMenuPopView) this.hxH.findViewById(f.g.pop_category_view);
        this.dFo = this.cWm.findViewById(f.g.pop_category_grav);
        this.dFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHg();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.dFA.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.dFA.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dFA.setOnItemClickCallBack(aVar);
    }

    public void bHf() {
        if (this.hxG) {
            setCompoundDrawables(null, null, this.hxI, null);
            this.hxG = false;
        } else {
            a(this);
            if (this.abh != null) {
                this.abh.refresh();
                this.abh.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.abh.setHeight(-1);
                this.abh.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hxJ, null);
                this.hxG = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.abh == null) {
            this.abh = new MorePopupWindow((Activity) this.mContext, this.cWm, this, am.getDrawable(f.C0146f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sB() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sC() {
                    if (PostCategoryView.this.abh != null) {
                        PostCategoryView.this.abh.dismiss();
                    }
                }
            });
            this.abh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHf();
                    }
                }
            });
        }
    }

    public void AD() {
        am.j(this, f.d.cp_bg_line_d);
        am.c(this, f.d.cp_cont_b, 1);
        if (this.hxH != null) {
            am.j(this.hxH, f.d.cp_bg_line_d);
        }
        if (this.dFA != null) {
            this.dFA.AD();
        }
    }

    public void bHg() {
        if (this.abh != null) {
            this.abh.dismiss();
        }
    }
}
