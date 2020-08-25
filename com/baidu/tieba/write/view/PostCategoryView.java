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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.bf;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow dSK;
    private LinearLayout hFW;
    private View irJ;
    private TabMenuPopView irV;
    private Context mContext;
    private boolean mSr;
    private LinearLayout mSs;
    private Drawable mSt;
    private Drawable mSu;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mSr = false;
        this.mSt = ap.getDrawable(R.drawable.icon_title_down);
        this.mSt.setBounds(0, 0, this.mSt.getIntrinsicWidth(), this.mSt.getIntrinsicHeight());
        this.mSu = ap.getDrawable(R.drawable.icon_title_up);
        this.mSu.setBounds(0, 0, this.mSu.getIntrinsicWidth(), this.mSt.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.mSt, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hFW = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.mSs = (LinearLayout) this.hFW.findViewById(R.id.pop_category_layout);
        this.irV = (TabMenuPopView) this.mSs.findViewById(R.id.pop_category_view);
        this.irJ = this.hFW.findViewById(R.id.pop_category_grav);
        this.irJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dHg();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.irV.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<af> list, af afVar, int i) {
        this.irV.setData(list, afVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.irV.setOnItemClickCallBack(aVar);
    }

    public void dHf() {
        if (this.mSr) {
            setCompoundDrawables(null, null, this.mSt, null);
            this.mSr = false;
        } else {
            a(this);
            if (this.dSK != null) {
                this.dSK.refresh();
                this.dSK.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dSK.setHeight(-1);
                this.dSK.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.mSu, null);
                this.mSr = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dSK == null) {
            this.dSK = new MorePopupWindow((Activity) this.mContext, this.hFW, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbC() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbD() {
                    if (PostCategoryView.this.dSK != null) {
                        PostCategoryView.this.dSK.dismiss();
                    }
                }
            });
            this.dSK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dHf();
                    }
                }
            });
        }
    }

    public void bkF() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.mSs != null) {
            ap.setBackgroundColor(this.mSs, R.color.cp_bg_line_d);
        }
        if (this.irV != null) {
            this.irV.bkF();
        }
    }

    public void dHg() {
        if (this.dSK != null) {
            this.dSK.dismiss();
        }
    }
}
