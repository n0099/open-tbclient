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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow Tv;
    private LinearLayout cLo;
    private View doY;
    private TabMenuPopView dpm;
    private boolean hfp;
    private LinearLayout hfq;
    private Drawable hfr;
    private Drawable hfs;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hfp = false;
        this.hfr = ak.getDrawable(d.f.icon_title_down);
        this.hfr.setBounds(0, 0, this.hfr.getIntrinsicWidth(), this.hfr.getIntrinsicHeight());
        this.hfs = ak.getDrawable(d.f.icon_title_up);
        this.hfs.setBounds(0, 0, this.hfs.getIntrinsicWidth(), this.hfr.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hfr, null);
        setPadding(0, 0, l.e(getContext(), d.e.ds50), 0);
        this.cLo = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.i.pop_category, (ViewGroup) null);
        this.hfq = (LinearLayout) this.cLo.findViewById(d.g.pop_category_layout);
        this.dpm = (TabMenuPopView) this.hfq.findViewById(d.g.pop_category_view);
        this.doY = this.cLo.findViewById(d.g.pop_category_grav);
        this.doY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PostCategoryView.this.bCN();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.dpm.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.dpm.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dpm.setOnItemClickCallBack(aVar);
    }

    public void bCM() {
        if (this.hfp) {
            setCompoundDrawables(null, null, this.hfr, null);
            this.hfp = false;
        } else {
            a(this);
            if (this.Tv != null) {
                this.Tv.refresh();
                this.Tv.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Tv.setHeight(-1);
                this.Tv.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hfs, null);
                this.hfp = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Tv == null) {
            this.Tv = new MorePopupWindow((Activity) this.mContext, this.cLo, this, ak.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pu() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pv() {
                    if (PostCategoryView.this.Tv != null) {
                        PostCategoryView.this.Tv.dismiss();
                    }
                }
            });
            this.Tv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.bCM();
                    }
                }
            });
        }
    }

    public void wY() {
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.c(this, d.C0126d.cp_cont_b, 1);
        if (this.hfq != null) {
            ak.j(this.hfq, d.C0126d.cp_bg_line_d);
        }
        if (this.dpm != null) {
            this.dpm.wY();
        }
    }

    public void bCN() {
        if (this.Tv != null) {
            this.Tv.dismiss();
        }
    }
}
