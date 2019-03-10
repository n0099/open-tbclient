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
    private MorePopupWindow bui;
    private LinearLayout eIL;
    private View ftQ;
    private TabMenuPopView fub;
    private boolean jrG;
    private LinearLayout jrH;
    private Drawable jrI;
    private Drawable jrJ;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jrG = false;
        this.jrI = al.getDrawable(d.f.icon_title_down);
        this.jrI.setBounds(0, 0, this.jrI.getIntrinsicWidth(), this.jrI.getIntrinsicHeight());
        this.jrJ = al.getDrawable(d.f.icon_title_up);
        this.jrJ.setBounds(0, 0, this.jrJ.getIntrinsicWidth(), this.jrI.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jrI, null);
        setPadding(0, 0, l.h(getContext(), d.e.ds50), 0);
        this.eIL = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.jrH = (LinearLayout) this.eIL.findViewById(d.g.pop_category_layout);
        this.fub = (TabMenuPopView) this.jrH.findViewById(d.g.pop_category_view);
        this.ftQ = this.eIL.findViewById(d.g.pop_category_grav);
        this.ftQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cqg();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fub.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fub.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fub.setOnItemClickCallBack(aVar);
    }

    public void cqf() {
        if (this.jrG) {
            setCompoundDrawables(null, null, this.jrI, null);
            this.jrG = false;
        } else {
            a(this);
            if (this.bui != null) {
                this.bui.refresh();
                this.bui.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bui.setHeight(-1);
                this.bui.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jrJ, null);
                this.jrG = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bui == null) {
            this.bui = new MorePopupWindow((Activity) this.mContext, this.eIL, this, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VX() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VY() {
                    if (PostCategoryView.this.bui != null) {
                        PostCategoryView.this.bui.dismiss();
                    }
                }
            });
            this.bui.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cqf();
                    }
                }
            });
        }
    }

    public void aeK() {
        al.l(this, d.C0236d.cp_bg_line_d);
        al.d(this, d.C0236d.cp_cont_b, 1);
        if (this.jrH != null) {
            al.l(this.jrH, d.C0236d.cp_bg_line_d);
        }
        if (this.fub != null) {
            this.fub.aeK();
        }
    }

    public void cqg() {
        if (this.bui != null) {
            this.bui.dismiss();
        }
    }
}
