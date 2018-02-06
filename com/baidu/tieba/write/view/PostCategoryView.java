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
    private MorePopupWindow aIn;
    private LinearLayout dsJ;
    private boolean hIE;
    private LinearLayout hIF;
    private TabMenuPopView hIG;
    private View hIH;
    private Drawable hII;
    private Drawable hIJ;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hIE = false;
        this.hII = aj.getDrawable(d.f.icon_title_down);
        this.hII.setBounds(0, 0, this.hII.getIntrinsicWidth(), this.hII.getIntrinsicHeight());
        this.hIJ = aj.getDrawable(d.f.icon_title_up);
        this.hIJ.setBounds(0, 0, this.hIJ.getIntrinsicWidth(), this.hII.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hII, null);
        setPadding(0, 0, l.t(getContext(), d.e.ds50), 0);
        this.dsJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.pop_category, (ViewGroup) null);
        this.hIF = (LinearLayout) this.dsJ.findViewById(d.g.pop_category_layout);
        this.hIG = (TabMenuPopView) this.hIF.findViewById(d.g.pop_category_view);
        this.hIH = this.dsJ.findViewById(d.g.pop_category_grav);
        this.hIH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.bHx();
            }
        });
    }

    public void b(List<z> list, z zVar, int i) {
        this.hIG.a(list, zVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hIG.setOnItemClickCallBack(aVar);
    }

    public void bHw() {
        if (this.hIE) {
            setCompoundDrawables(null, null, this.hII, null);
            this.hIE = false;
        } else {
            a(this);
            if (this.aIn != null) {
                this.aIn.refresh();
                this.aIn.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.aIn.setHeight(-1);
                this.aIn.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hIJ, null);
                this.hIE = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.aIn == null) {
            this.aIn = new MorePopupWindow((Activity) this.mContext, this.dsJ, this, aj.getDrawable(d.f.transparent_bg), new f.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.f.a
                public void wK() {
                }

                @Override // com.baidu.tbadk.core.view.f.a
                public void wL() {
                    if (PostCategoryView.this.aIn != null) {
                        PostCategoryView.this.aIn.dismiss();
                    }
                }
            });
            this.aIn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bHw();
                    }
                }
            });
        }
    }

    public void En() {
        aj.t(this, d.C0140d.cp_bg_line_d);
        aj.e(this, d.C0140d.cp_cont_b, 1);
        if (this.hIF != null) {
            aj.t(this.hIF, d.C0140d.cp_bg_line_d);
        }
        if (this.hIG != null) {
            this.hIG.En();
        }
    }

    public void bHx() {
        if (this.aIn != null) {
            this.aIn.dismiss();
        }
    }
}
