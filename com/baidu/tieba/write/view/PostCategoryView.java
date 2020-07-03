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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.bd;
import java.util.List;
/* loaded from: classes2.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow dDF;
    private View hXB;
    private TabMenuPopView hXN;
    private LinearLayout hmU;
    private Context mContext;
    private boolean mrW;
    private LinearLayout mrX;
    private Drawable mrY;
    private Drawable mrZ;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mrW = false;
        this.mrY = an.getDrawable(R.drawable.icon_title_down);
        this.mrY.setBounds(0, 0, this.mrY.getIntrinsicWidth(), this.mrY.getIntrinsicHeight());
        this.mrZ = an.getDrawable(R.drawable.icon_title_up);
        this.mrZ.setBounds(0, 0, this.mrZ.getIntrinsicWidth(), this.mrY.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.mrY, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hmU = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.mrX = (LinearLayout) this.hmU.findViewById(R.id.pop_category_layout);
        this.hXN = (TabMenuPopView) this.mrX.findViewById(R.id.pop_category_view);
        this.hXB = this.hmU.findViewById(R.id.pop_category_grav);
        this.hXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dst();
            }
        });
    }

    public void setCategoryContainerData(List<bd> list, bd bdVar) {
        this.hXN.setData(list, bdVar);
    }

    public void setCategoryContainerData(List<ad> list, ad adVar, int i) {
        this.hXN.setData(list, adVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hXN.setOnItemClickCallBack(aVar);
    }

    public void dss() {
        if (this.mrW) {
            setCompoundDrawables(null, null, this.mrY, null);
            this.mrW = false;
        } else {
            a(this);
            if (this.dDF != null) {
                this.dDF.refresh();
                this.dDF.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dDF.setHeight(-1);
                this.dDF.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.mrZ, null);
                this.mrW = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dDF == null) {
            this.dDF = new MorePopupWindow((Activity) this.mContext, this.hmU, this, an.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aPq() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aPr() {
                    if (PostCategoryView.this.dDF != null) {
                        PostCategoryView.this.dDF.dismiss();
                    }
                }
            });
            this.dDF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dss();
                    }
                }
            });
        }
    }

    public void aYj() {
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        an.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.mrX != null) {
            an.setBackgroundColor(this.mrX, R.color.cp_bg_line_d);
        }
        if (this.hXN != null) {
            this.hXN.aYj();
        }
    }

    public void dst() {
        if (this.dDF != null) {
            this.dDF.dismiss();
        }
    }
}
