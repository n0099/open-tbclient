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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.y;
import java.util.List;
/* loaded from: classes2.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow RC;
    private View cGG;
    private TabMenuPopView cGU;
    private LinearLayout cfX;
    private boolean gKm;
    private LinearLayout gKn;
    private Drawable gKo;
    private Drawable gKp;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gKm = false;
        this.gKo = aj.getDrawable(d.g.icon_title_down);
        this.gKo.setBounds(0, 0, this.gKo.getIntrinsicWidth(), this.gKo.getIntrinsicHeight());
        this.gKp = aj.getDrawable(d.g.icon_title_up);
        this.gKp.setBounds(0, 0, this.gKp.getIntrinsicWidth(), this.gKo.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gKo, null);
        setPadding(0, 0, l.f(getContext(), d.f.ds50), 0);
        this.cfX = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.j.pop_category, (ViewGroup) null);
        this.gKn = (LinearLayout) this.cfX.findViewById(d.h.pop_category_layout);
        this.cGU = (TabMenuPopView) this.gKn.findViewById(d.h.pop_category_view);
        this.cGG = this.cfX.findViewById(d.h.pop_category_grav);
        this.cGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bAv();
            }
        });
    }

    public void b(List<y> list, y yVar, int i) {
        this.cGU.a(list, yVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cGU.setOnItemClickCallBack(aVar);
    }

    public void bAu() {
        if (this.gKm) {
            setCompoundDrawables(null, null, this.gKo, null);
            this.gKm = false;
        } else {
            a(this);
            if (this.RC != null) {
                this.RC.refresh();
                this.RC.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.RC.setHeight(-1);
                this.RC.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gKp, null);
                this.gKm = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.RC == null) {
            this.RC = new MorePopupWindow((Activity) this.mContext, this.cfX, this, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void oq() {
                    if (PostCategoryView.this.RC != null) {
                        PostCategoryView.this.RC.dismiss();
                    }
                }
            });
            this.RC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bAu();
                    }
                }
            });
        }
    }

    public void wB() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.c(this, d.e.cp_cont_b, 1);
        if (this.gKn != null) {
            aj.k(this.gKn, d.e.cp_bg_line_d);
        }
        if (this.cGU != null) {
            this.cGU.wB();
        }
    }

    public void bAv() {
        if (this.RC != null) {
            this.RC.dismiss();
        }
    }
}
