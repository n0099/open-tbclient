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
    private MorePopupWindow aGS;
    private LinearLayout dkU;
    private boolean hRg;
    private LinearLayout hRh;
    private TabMenuPopView hRi;
    private View hRj;
    private Drawable hRk;
    private Drawable hRl;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hRg = false;
        this.hRk = aj.getDrawable(d.f.icon_title_down);
        this.hRk.setBounds(0, 0, this.hRk.getIntrinsicWidth(), this.hRk.getIntrinsicHeight());
        this.hRl = aj.getDrawable(d.f.icon_title_up);
        this.hRl.setBounds(0, 0, this.hRl.getIntrinsicWidth(), this.hRk.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hRk, null);
        setPadding(0, 0, l.s(getContext(), d.e.ds50), 0);
        this.dkU = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hRh = (LinearLayout) this.dkU.findViewById(d.g.pop_category_layout);
        this.hRi = (TabMenuPopView) this.hRh.findViewById(d.g.pop_category_view);
        this.hRj = this.dkU.findViewById(d.g.pop_category_grav);
        this.hRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bNh();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.hRi.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hRi.setOnItemClickCallBack(aVar);
    }

    public void bNg() {
        if (this.hRg) {
            setCompoundDrawables(null, null, this.hRk, null);
            this.hRg = false;
        } else {
            a(this);
            if (this.aGS != null) {
                this.aGS.refresh();
                this.aGS.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aGS.setHeight(-1);
                this.aGS.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hRl, null);
                this.hRg = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aGS == null) {
            this.aGS = new MorePopupWindow((Activity) this.mContext, this.dkU, this, aj.getDrawable(d.f.transparent_bg), new e.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.e.a
                public void vX() {
                }

                @Override // com.baidu.tbadk.core.view.e.a
                public void vY() {
                    if (PostCategoryView.this.aGS != null) {
                        PostCategoryView.this.aGS.dismiss();
                    }
                }
            });
            this.aGS.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bNg();
                    }
                }
            });
        }
    }

    public void Ea() {
        aj.t(this, d.C0108d.cp_bg_line_d);
        aj.e(this, d.C0108d.cp_cont_b, 1);
        if (this.hRh != null) {
            aj.t(this.hRh, d.C0108d.cp_bg_line_d);
        }
        if (this.hRi != null) {
            this.hRi.Ea();
        }
    }

    public void bNh() {
        if (this.aGS != null) {
            this.aGS.dismiss();
        }
    }
}
