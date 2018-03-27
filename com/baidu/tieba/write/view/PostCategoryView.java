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
    private MorePopupWindow aId;
    private LinearLayout dsA;
    private boolean hIP;
    private LinearLayout hIQ;
    private TabMenuPopView hIR;
    private View hIS;
    private Drawable hIT;
    private Drawable hIU;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hIP = false;
        this.hIT = aj.getDrawable(d.f.icon_title_down);
        this.hIT.setBounds(0, 0, this.hIT.getIntrinsicWidth(), this.hIT.getIntrinsicHeight());
        this.hIU = aj.getDrawable(d.f.icon_title_up);
        this.hIU.setBounds(0, 0, this.hIU.getIntrinsicWidth(), this.hIT.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hIT, null);
        setPadding(0, 0, l.t(getContext(), d.e.ds50), 0);
        this.dsA = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hIQ = (LinearLayout) this.dsA.findViewById(d.g.pop_category_layout);
        this.hIR = (TabMenuPopView) this.hIQ.findViewById(d.g.pop_category_view);
        this.hIS = this.dsA.findViewById(d.g.pop_category_grav);
        this.hIS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHB();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.hIR.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hIR.setOnItemClickCallBack(aVar);
    }

    public void bHA() {
        if (this.hIP) {
            setCompoundDrawables(null, null, this.hIT, null);
            this.hIP = false;
        } else {
            a(this);
            if (this.aId != null) {
                this.aId.refresh();
                this.aId.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aId.setHeight(-1);
                this.aId.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hIU, null);
                this.hIP = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aId == null) {
            this.aId = new MorePopupWindow((Activity) this.mContext, this.dsA, this, aj.getDrawable(d.f.transparent_bg), new f.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.f.a
                public void wK() {
                }

                @Override // com.baidu.tbadk.core.view.f.a
                public void wL() {
                    if (PostCategoryView.this.aId != null) {
                        PostCategoryView.this.aId.dismiss();
                    }
                }
            });
            this.aId.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHA();
                    }
                }
            });
        }
    }

    public void En() {
        aj.t(this, d.C0141d.cp_bg_line_d);
        aj.e(this, d.C0141d.cp_cont_b, 1);
        if (this.hIQ != null) {
            aj.t(this.hIQ, d.C0141d.cp_bg_line_d);
        }
        if (this.hIR != null) {
            this.hIR.En();
        }
    }

    public void bHB() {
        if (this.aId != null) {
            this.aId.dismiss();
        }
    }
}
