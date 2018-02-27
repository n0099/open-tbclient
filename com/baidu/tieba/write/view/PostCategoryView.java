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
    private MorePopupWindow aIc;
    private LinearLayout dsx;
    private boolean hIr;
    private LinearLayout hIs;
    private TabMenuPopView hIt;
    private View hIu;
    private Drawable hIv;
    private Drawable hIw;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hIr = false;
        this.hIv = aj.getDrawable(d.f.icon_title_down);
        this.hIv.setBounds(0, 0, this.hIv.getIntrinsicWidth(), this.hIv.getIntrinsicHeight());
        this.hIw = aj.getDrawable(d.f.icon_title_up);
        this.hIw.setBounds(0, 0, this.hIw.getIntrinsicWidth(), this.hIv.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hIv, null);
        setPadding(0, 0, l.t(getContext(), d.e.ds50), 0);
        this.dsx = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hIs = (LinearLayout) this.dsx.findViewById(d.g.pop_category_layout);
        this.hIt = (TabMenuPopView) this.hIs.findViewById(d.g.pop_category_view);
        this.hIu = this.dsx.findViewById(d.g.pop_category_grav);
        this.hIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHw();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.hIt.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hIt.setOnItemClickCallBack(aVar);
    }

    public void bHv() {
        if (this.hIr) {
            setCompoundDrawables(null, null, this.hIv, null);
            this.hIr = false;
        } else {
            a(this);
            if (this.aIc != null) {
                this.aIc.refresh();
                this.aIc.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aIc.setHeight(-1);
                this.aIc.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hIw, null);
                this.hIr = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aIc == null) {
            this.aIc = new MorePopupWindow((Activity) this.mContext, this.dsx, this, aj.getDrawable(d.f.transparent_bg), new f.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.f.a
                public void wK() {
                }

                @Override // com.baidu.tbadk.core.view.f.a
                public void wL() {
                    if (PostCategoryView.this.aIc != null) {
                        PostCategoryView.this.aIc.dismiss();
                    }
                }
            });
            this.aIc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHv();
                    }
                }
            });
        }
    }

    public void Em() {
        aj.t(this, d.C0141d.cp_bg_line_d);
        aj.e(this, d.C0141d.cp_cont_b, 1);
        if (this.hIs != null) {
            aj.t(this.hIs, d.C0141d.cp_bg_line_d);
        }
        if (this.hIt != null) {
            this.hIt.Em();
        }
    }

    public void bHw() {
        if (this.aIc != null) {
            this.aIc.dismiss();
        }
    }
}
