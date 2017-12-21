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
    private MorePopupWindow So;
    private View cZG;
    private TabMenuPopView cZU;
    private LinearLayout cwy;
    private boolean hje;
    private LinearLayout hjf;
    private Drawable hjg;
    private Drawable hjh;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hje = false;
        this.hjg = aj.getDrawable(d.f.icon_title_down);
        this.hjg.setBounds(0, 0, this.hjg.getIntrinsicWidth(), this.hjg.getIntrinsicHeight());
        this.hjh = aj.getDrawable(d.f.icon_title_up);
        this.hjh.setBounds(0, 0, this.hjh.getIntrinsicWidth(), this.hjg.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hjg, null);
        setPadding(0, 0, l.f(getContext(), d.e.ds50), 0);
        this.cwy = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hjf = (LinearLayout) this.cwy.findViewById(d.g.pop_category_layout);
        this.cZU = (TabMenuPopView) this.hjf.findViewById(d.g.pop_category_view);
        this.cZG = this.cwy.findViewById(d.g.pop_category_grav);
        this.cZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHt();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.cZU.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cZU.setOnItemClickCallBack(aVar);
    }

    public void bHs() {
        if (this.hje) {
            setCompoundDrawables(null, null, this.hjg, null);
            this.hje = false;
        } else {
            a(this);
            if (this.So != null) {
                this.So.refresh();
                this.So.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.So.setHeight(-1);
                this.So.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hjh, null);
                this.hje = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.So == null) {
            this.So = new MorePopupWindow((Activity) this.mContext, this.cwy, this, aj.getDrawable(d.f.transparent_bg), new e.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.e.a
                public void ou() {
                }

                @Override // com.baidu.tbadk.core.view.e.a
                public void ov() {
                    if (PostCategoryView.this.So != null) {
                        PostCategoryView.this.So.dismiss();
                    }
                }
            });
            this.So.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHs();
                    }
                }
            });
        }
    }

    public void wC() {
        aj.k(this, d.C0095d.cp_bg_line_d);
        aj.c(this, d.C0095d.cp_cont_b, 1);
        if (this.hjf != null) {
            aj.k(this.hjf, d.C0095d.cp_bg_line_d);
        }
        if (this.cZU != null) {
            this.cZU.wC();
        }
    }

    public void bHt() {
        if (this.So != null) {
            this.So.dismiss();
        }
    }
}
