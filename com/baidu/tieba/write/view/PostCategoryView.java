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
    private boolean mrZ;
    private LinearLayout msa;
    private Drawable msb;
    private Drawable msc;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mrZ = false;
        this.msb = an.getDrawable(R.drawable.icon_title_down);
        this.msb.setBounds(0, 0, this.msb.getIntrinsicWidth(), this.msb.getIntrinsicHeight());
        this.msc = an.getDrawable(R.drawable.icon_title_up);
        this.msc.setBounds(0, 0, this.msc.getIntrinsicWidth(), this.msb.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.msb, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hmU = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.msa = (LinearLayout) this.hmU.findViewById(R.id.pop_category_layout);
        this.hXN = (TabMenuPopView) this.msa.findViewById(R.id.pop_category_view);
        this.hXB = this.hmU.findViewById(R.id.pop_category_grav);
        this.hXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dsx();
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

    public void dsw() {
        if (this.mrZ) {
            setCompoundDrawables(null, null, this.msb, null);
            this.mrZ = false;
        } else {
            a(this);
            if (this.dDF != null) {
                this.dDF.refresh();
                this.dDF.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dDF.setHeight(-1);
                this.dDF.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.msc, null);
                this.mrZ = true;
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
                        postCategoryView.dsw();
                    }
                }
            });
        }
    }

    public void aYj() {
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        an.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.msa != null) {
            an.setBackgroundColor(this.msa, R.color.cp_bg_line_d);
        }
        if (this.hXN != null) {
            this.hXN.aYj();
        }
    }

    public void dsx() {
        if (this.dDF != null) {
            this.dDF.dismiss();
        }
    }
}
