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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.w;
import java.util.List;
/* loaded from: classes13.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow cLb;
    private View gKb;
    private TabMenuPopView gKm;
    private LinearLayout gbA;
    private boolean kRh;
    private LinearLayout kRi;
    private Drawable kRj;
    private Drawable kRk;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.kRh = false;
        this.kRj = am.getDrawable(R.drawable.icon_title_down);
        this.kRj.setBounds(0, 0, this.kRj.getIntrinsicWidth(), this.kRj.getIntrinsicHeight());
        this.kRk = am.getDrawable(R.drawable.icon_title_up);
        this.kRk.setBounds(0, 0, this.kRk.getIntrinsicWidth(), this.kRj.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.kRj, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.gbA = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.kRi = (LinearLayout) this.gbA.findViewById(R.id.pop_category_layout);
        this.gKm = (TabMenuPopView) this.kRi.findViewById(R.id.pop_category_view);
        this.gKb = this.gbA.findViewById(R.id.pop_category_grav);
        this.gKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cVx();
            }
        });
    }

    public void setCategoryContainerData(List<as> list, as asVar) {
        this.gKm.setData(list, asVar);
    }

    public void setCategoryContainerData(List<w> list, w wVar, int i) {
        this.gKm.setData(list, wVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.gKm.setOnItemClickCallBack(aVar);
    }

    public void cVw() {
        if (this.kRh) {
            setCompoundDrawables(null, null, this.kRj, null);
            this.kRh = false;
        } else {
            a(this);
            if (this.cLb != null) {
                this.cLb.refresh();
                this.cLb.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.cLb.setHeight(-1);
                this.cLb.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.kRk, null);
                this.kRh = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.cLb == null) {
            this.cLb = new MorePopupWindow((Activity) this.mContext, this.gbA, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azI() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azJ() {
                    if (PostCategoryView.this.cLb != null) {
                        PostCategoryView.this.cLb.dismiss();
                    }
                }
            });
            this.cLb.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cVw();
                    }
                }
            });
        }
    }

    public void aHN() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.kRi != null) {
            am.setBackgroundColor(this.kRi, R.color.cp_bg_line_d);
        }
        if (this.gKm != null) {
            this.gKm.aHN();
        }
    }

    public void cVx() {
        if (this.cLb != null) {
            this.cLb.dismiss();
        }
    }
}
