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
    private MorePopupWindow RH;
    private View cPH;
    private TabMenuPopView cPV;
    private LinearLayout cnf;
    private boolean gTV;
    private LinearLayout gTW;
    private Drawable gTX;
    private Drawable gTY;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gTV = false;
        this.gTX = aj.getDrawable(d.f.icon_title_down);
        this.gTX.setBounds(0, 0, this.gTX.getIntrinsicWidth(), this.gTX.getIntrinsicHeight());
        this.gTY = aj.getDrawable(d.f.icon_title_up);
        this.gTY.setBounds(0, 0, this.gTY.getIntrinsicWidth(), this.gTX.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.gTX, null);
        setPadding(0, 0, l.f(getContext(), d.e.ds50), 0);
        this.cnf = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.gTW = (LinearLayout) this.cnf.findViewById(d.g.pop_category_layout);
        this.cPV = (TabMenuPopView) this.gTW.findViewById(d.g.pop_category_view);
        this.cPH = this.cnf.findViewById(d.g.pop_category_grav);
        this.cPH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bDM();
            }
        });
    }

    public void b(List<y> list, y yVar, int i) {
        this.cPV.a(list, yVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.cPV.setOnItemClickCallBack(aVar);
    }

    public void bDL() {
        if (this.gTV) {
            setCompoundDrawables(null, null, this.gTX, null);
            this.gTV = false;
        } else {
            a(this);
            if (this.RH != null) {
                this.RH.refresh();
                this.RH.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.RH.setHeight(-1);
                this.RH.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.gTY, null);
                this.gTV = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.RH == null) {
            this.RH = new MorePopupWindow((Activity) this.mContext, this.cnf, this, aj.getDrawable(d.f.transparent_bg), new d.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void oq() {
                    if (PostCategoryView.this.RH != null) {
                        PostCategoryView.this.RH.dismiss();
                    }
                }
            });
            this.RH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bDL();
                    }
                }
            });
        }
    }

    public void wB() {
        aj.k(this, d.C0080d.cp_bg_line_d);
        aj.c(this, d.C0080d.cp_cont_b, 1);
        if (this.gTW != null) {
            aj.k(this.gTW, d.C0080d.cp_bg_line_d);
        }
        if (this.cPV != null) {
            this.cPV.wB();
        }
    }

    public void bDM() {
        if (this.RH != null) {
            this.RH.dismiss();
        }
    }
}
