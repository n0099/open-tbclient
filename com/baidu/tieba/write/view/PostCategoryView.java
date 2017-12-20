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
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.z;
import java.util.List;
/* loaded from: classes2.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow Sn;
    private View cZC;
    private TabMenuPopView cZQ;
    private LinearLayout cwu;
    private boolean hiZ;
    private LinearLayout hja;
    private Drawable hjb;
    private Drawable hjc;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hiZ = false;
        this.hjb = aj.getDrawable(d.f.icon_title_down);
        this.hjb.setBounds(0, 0, this.hjb.getIntrinsicWidth(), this.hjb.getIntrinsicHeight());
        this.hjc = aj.getDrawable(d.f.icon_title_up);
        this.hjc.setBounds(0, 0, this.hjc.getIntrinsicWidth(), this.hjb.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hjb, null);
        setPadding(0, 0, l.f(getContext(), d.e.ds50), 0);
        this.cwu = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hja = (LinearLayout) this.cwu.findViewById(d.g.pop_category_layout);
        this.cZQ = (TabMenuPopView) this.hja.findViewById(d.g.pop_category_view);
        this.cZC = this.cwu.findViewById(d.g.pop_category_grav);
        this.cZC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHs();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.cZQ.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cZQ.setOnItemClickCallBack(aVar);
    }

    public void bHr() {
        if (this.hiZ) {
            setCompoundDrawables(null, null, this.hjb, null);
            this.hiZ = false;
        } else {
            a(this);
            if (this.Sn != null) {
                this.Sn.refresh();
                this.Sn.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Sn.setHeight(-1);
                this.Sn.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hjc, null);
                this.hiZ = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Sn == null) {
            this.Sn = new MorePopupWindow((Activity) this.mContext, this.cwu, this, aj.getDrawable(d.f.transparent_bg), new e.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.e.a
                public void ou() {
                }

                @Override // com.baidu.tbadk.core.view.e.a
                public void ov() {
                    if (PostCategoryView.this.Sn != null) {
                        PostCategoryView.this.Sn.dismiss();
                    }
                }
            });
            this.Sn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHr();
                    }
                }
            });
        }
    }

    public void wC() {
        aj.k(this, d.C0096d.cp_bg_line_d);
        aj.c(this, d.C0096d.cp_cont_b, 1);
        if (this.hja != null) {
            aj.k(this.hja, d.C0096d.cp_bg_line_d);
        }
        if (this.cZQ != null) {
            this.cZQ.wC();
        }
    }

    public void bHs() {
        if (this.Sn != null) {
            this.Sn.dismiss();
        }
    }
}
