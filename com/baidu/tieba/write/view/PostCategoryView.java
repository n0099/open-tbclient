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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.z;
import java.util.List;
/* loaded from: classes2.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow aGT;
    private LinearLayout dpQ;
    private boolean hHi;
    private LinearLayout hHj;
    private TabMenuPopView hHk;
    private View hHl;
    private Drawable hHm;
    private Drawable hHn;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hHi = false;
        this.hHm = aj.getDrawable(d.f.icon_title_down);
        this.hHm.setBounds(0, 0, this.hHm.getIntrinsicWidth(), this.hHm.getIntrinsicHeight());
        this.hHn = aj.getDrawable(d.f.icon_title_up);
        this.hHn.setBounds(0, 0, this.hHn.getIntrinsicWidth(), this.hHm.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hHm, null);
        setPadding(0, 0, l.s(getContext(), d.e.ds50), 0);
        this.dpQ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hHj = (LinearLayout) this.dpQ.findViewById(d.g.pop_category_layout);
        this.hHk = (TabMenuPopView) this.hHj.findViewById(d.g.pop_category_view);
        this.hHl = this.dpQ.findViewById(d.g.pop_category_grav);
        this.hHl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bGJ();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.hHk.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hHk.setOnItemClickCallBack(aVar);
    }

    public void bGI() {
        if (this.hHi) {
            setCompoundDrawables(null, null, this.hHm, null);
            this.hHi = false;
        } else {
            a(this);
            if (this.aGT != null) {
                this.aGT.refresh();
                this.aGT.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aGT.setHeight(-1);
                this.aGT.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hHn, null);
                this.hHi = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aGT == null) {
            this.aGT = new MorePopupWindow((Activity) this.mContext, this.dpQ, this, aj.getDrawable(d.f.transparent_bg), new f.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.f.a
                public void vX() {
                }

                @Override // com.baidu.tbadk.core.view.f.a
                public void vY() {
                    if (PostCategoryView.this.aGT != null) {
                        PostCategoryView.this.aGT.dismiss();
                    }
                }
            });
            this.aGT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bGI();
                    }
                }
            });
        }
    }

    public void DT() {
        aj.t(this, d.C0108d.cp_bg_line_d);
        aj.e(this, d.C0108d.cp_cont_b, 1);
        if (this.hHj != null) {
            aj.t(this.hHj, d.C0108d.cp_bg_line_d);
        }
        if (this.hHk != null) {
            this.hHk.DT();
        }
    }

    public void bGJ() {
        if (this.aGT != null) {
            this.aGT.dismiss();
        }
    }
}
