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
    private LinearLayout cLr;
    private View dpb;
    private TabMenuPopView dpp;
    private boolean hfs;
    private LinearLayout hft;
    private Drawable hfu;
    private Drawable hfv;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.hfs = false;
        this.hfu = ak.getDrawable(d.f.icon_title_down);
        this.hfu.setBounds(0, 0, this.hfu.getIntrinsicWidth(), this.hfu.getIntrinsicHeight());
        this.hfv = ak.getDrawable(d.f.icon_title_up);
        this.hfv.setBounds(0, 0, this.hfv.getIntrinsicWidth(), this.hfu.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.hfu, null);
        setPadding(0, 0, l.e(getContext(), d.e.ds50), 0);
        this.cLr = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.i.pop_category, (ViewGroup) null);
        this.hft = (LinearLayout) this.cLr.findViewById(d.g.pop_category_layout);
        this.dpp = (TabMenuPopView) this.hft.findViewById(d.g.pop_category_view);
        this.dpb = this.cLr.findViewById(d.g.pop_category_grav);
        this.dpb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PostCategoryView.this.bCN();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.dpp.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.dpp.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.dpp.setOnItemClickCallBack(aVar);
    }

    public void bCM() {
        if (this.hfs) {
            setCompoundDrawables(null, null, this.hfu, null);
            this.hfs = false;
        } else {
            a(this);
            if (this.Tv != null) {
                this.Tv.refresh();
                this.Tv.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.Tv.setHeight(-1);
                this.Tv.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.hfv, null);
                this.hfs = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.Tv == null) {
            this.Tv = new MorePopupWindow((Activity) this.mContext, this.cLr, this, ak.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
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
        if (this.hft != null) {
            ak.j(this.hft, d.C0126d.cp_bg_line_d);
        }
        if (this.dpp != null) {
            this.dpp.wY();
        }
    }

    public void bCN() {
        if (this.Tv != null) {
            this.Tv.dismiss();
        }
    }
}
