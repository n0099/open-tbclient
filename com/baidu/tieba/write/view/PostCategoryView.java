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
    private MorePopupWindow Sq;
    private TabMenuPopView cZE;
    private View cZq;
    private LinearLayout cwl;
    private boolean hgg;
    private LinearLayout hgh;
    private Drawable hgi;
    private Drawable hgj;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hgg = false;
        this.hgi = aj.getDrawable(d.f.icon_title_down);
        this.hgi.setBounds(0, 0, this.hgi.getIntrinsicWidth(), this.hgi.getIntrinsicHeight());
        this.hgj = aj.getDrawable(d.f.icon_title_up);
        this.hgj.setBounds(0, 0, this.hgj.getIntrinsicWidth(), this.hgi.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hgi, null);
        setPadding(0, 0, l.f(getContext(), d.e.ds50), 0);
        this.cwl = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hgh = (LinearLayout) this.cwl.findViewById(d.g.pop_category_layout);
        this.cZE = (TabMenuPopView) this.hgh.findViewById(d.g.pop_category_view);
        this.cZq = this.cwl.findViewById(d.g.pop_category_grav);
        this.cZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bGH();
            }
        });
    }

    public void b(List<y> list, y yVar, int i) {
        this.cZE.a(list, yVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cZE.setOnItemClickCallBack(aVar);
    }

    public void bGG() {
        if (this.hgg) {
            setCompoundDrawables(null, null, this.hgi, null);
            this.hgg = false;
        } else {
            a(this);
            if (this.Sq != null) {
                this.Sq.refresh();
                this.Sq.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Sq.setHeight(-1);
                this.Sq.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hgj, null);
                this.hgg = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Sq == null) {
            this.Sq = new MorePopupWindow((Activity) this.mContext, this.cwl, this, aj.getDrawable(d.f.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void ow() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ox() {
                    if (PostCategoryView.this.Sq != null) {
                        PostCategoryView.this.Sq.dismiss();
                    }
                }
            });
            this.Sq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bGG();
                    }
                }
            });
        }
    }

    public void wE() {
        aj.k(this, d.C0082d.cp_bg_line_d);
        aj.c(this, d.C0082d.cp_cont_b, 1);
        if (this.hgh != null) {
            aj.k(this.hgh, d.C0082d.cp_bg_line_d);
        }
        if (this.cZE != null) {
            this.cZE.wE();
        }
    }

    public void bGH() {
        if (this.Sq != null) {
            this.Sq.dismiss();
        }
    }
}
