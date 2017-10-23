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
    private MorePopupWindow Rq;
    private TabMenuPopView cGI;
    private View cGu;
    private LinearLayout cfL;
    private boolean gJW;
    private LinearLayout gJX;
    private Drawable gJY;
    private Drawable gJZ;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gJW = false;
        this.gJY = aj.getDrawable(d.g.icon_title_down);
        this.gJY.setBounds(0, 0, this.gJY.getIntrinsicWidth(), this.gJY.getIntrinsicHeight());
        this.gJZ = aj.getDrawable(d.g.icon_title_up);
        this.gJZ.setBounds(0, 0, this.gJZ.getIntrinsicWidth(), this.gJY.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gJY, null);
        setPadding(0, 0, l.f(getContext(), d.f.ds50), 0);
        this.cfL = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.j.pop_category, (ViewGroup) null);
        this.gJX = (LinearLayout) this.cfL.findViewById(d.h.pop_category_layout);
        this.cGI = (TabMenuPopView) this.gJX.findViewById(d.h.pop_category_view);
        this.cGu = this.cfL.findViewById(d.h.pop_category_grav);
        this.cGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bAo();
            }
        });
    }

    public void b(List<y> list, y yVar, int i) {
        this.cGI.a(list, yVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cGI.setOnItemClickCallBack(aVar);
    }

    public void bAn() {
        if (this.gJW) {
            setCompoundDrawables(null, null, this.gJY, null);
            this.gJW = false;
        } else {
            a(this);
            if (this.Rq != null) {
                this.Rq.refresh();
                this.Rq.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Rq.setHeight(-1);
                this.Rq.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gJZ, null);
                this.gJW = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Rq == null) {
            this.Rq = new MorePopupWindow((Activity) this.mContext, this.cfL, this, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void oi() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void oj() {
                    if (PostCategoryView.this.Rq != null) {
                        PostCategoryView.this.Rq.dismiss();
                    }
                }
            });
            this.Rq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bAn();
                    }
                }
            });
        }
    }

    public void wu() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.c(this, d.e.cp_cont_b, 1);
        if (this.gJX != null) {
            aj.k(this.gJX, d.e.cp_bg_line_d);
        }
        if (this.cGI != null) {
            this.cGI.wu();
        }
    }

    public void bAo() {
        if (this.Rq != null) {
            this.Rq.dismiss();
        }
    }
}
