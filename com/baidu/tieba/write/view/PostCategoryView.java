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
    private MorePopupWindow aGQ;
    private LinearLayout dpv;
    private boolean hGO;
    private LinearLayout hGP;
    private TabMenuPopView hGQ;
    private View hGR;
    private Drawable hGS;
    private Drawable hGT;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hGO = false;
        this.hGS = aj.getDrawable(d.f.icon_title_down);
        this.hGS.setBounds(0, 0, this.hGS.getIntrinsicWidth(), this.hGS.getIntrinsicHeight());
        this.hGT = aj.getDrawable(d.f.icon_title_up);
        this.hGT.setBounds(0, 0, this.hGT.getIntrinsicWidth(), this.hGS.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hGS, null);
        setPadding(0, 0, l.s(getContext(), d.e.ds50), 0);
        this.dpv = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hGP = (LinearLayout) this.dpv.findViewById(d.g.pop_category_layout);
        this.hGQ = (TabMenuPopView) this.hGP.findViewById(d.g.pop_category_view);
        this.hGR = this.dpv.findViewById(d.g.pop_category_grav);
        this.hGR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bGH();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.hGQ.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hGQ.setOnItemClickCallBack(aVar);
    }

    public void bGG() {
        if (this.hGO) {
            setCompoundDrawables(null, null, this.hGS, null);
            this.hGO = false;
        } else {
            a(this);
            if (this.aGQ != null) {
                this.aGQ.refresh();
                this.aGQ.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aGQ.setHeight(-1);
                this.aGQ.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hGT, null);
                this.hGO = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aGQ == null) {
            this.aGQ = new MorePopupWindow((Activity) this.mContext, this.dpv, this, aj.getDrawable(d.f.transparent_bg), new f.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.f.a
                public void vW() {
                }

                @Override // com.baidu.tbadk.core.view.f.a
                public void vX() {
                    if (PostCategoryView.this.aGQ != null) {
                        PostCategoryView.this.aGQ.dismiss();
                    }
                }
            });
            this.aGQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bGG();
                    }
                }
            });
        }
    }

    public void DR() {
        aj.t(this, d.C0107d.cp_bg_line_d);
        aj.e(this, d.C0107d.cp_cont_b, 1);
        if (this.hGP != null) {
            aj.t(this.hGP, d.C0107d.cp_bg_line_d);
        }
        if (this.hGQ != null) {
            this.hGQ.DR();
        }
    }

    public void bGH() {
        if (this.aGQ != null) {
            this.aGQ.dismiss();
        }
    }
}
