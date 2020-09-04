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
    private MorePopupWindow dSO;
    private LinearLayout hGc;
    private View irP;
    private TabMenuPopView isb;
    private Context mContext;
    private boolean mSK;
    private LinearLayout mSL;
    private Drawable mSM;
    private Drawable mSN;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mSK = false;
        this.mSM = ap.getDrawable(R.drawable.icon_title_down);
        this.mSM.setBounds(0, 0, this.mSM.getIntrinsicWidth(), this.mSM.getIntrinsicHeight());
        this.mSN = ap.getDrawable(R.drawable.icon_title_up);
        this.mSN.setBounds(0, 0, this.mSN.getIntrinsicWidth(), this.mSM.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.mSM, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hGc = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.mSL = (LinearLayout) this.hGc.findViewById(R.id.pop_category_layout);
        this.isb = (TabMenuPopView) this.mSL.findViewById(R.id.pop_category_view);
        this.irP = this.hGc.findViewById(R.id.pop_category_grav);
        this.irP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dHp();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.isb.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<af> list, af afVar, int i) {
        this.isb.setData(list, afVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.isb.setOnItemClickCallBack(aVar);
    }

    public void dHo() {
        if (this.mSK) {
            setCompoundDrawables(null, null, this.mSM, null);
            this.mSK = false;
        } else {
            a(this);
            if (this.dSO != null) {
                this.dSO.refresh();
                this.dSO.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dSO.setHeight(-1);
                this.dSO.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.mSN, null);
                this.mSK = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dSO == null) {
            this.dSO = new MorePopupWindow((Activity) this.mContext, this.hGc, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbC() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbD() {
                    if (PostCategoryView.this.dSO != null) {
                        PostCategoryView.this.dSO.dismiss();
                    }
                }
            });
            this.dSO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dHo();
                    }
                }
            });
        }
    }

    public void bkF() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.mSL != null) {
            ap.setBackgroundColor(this.mSL, R.color.cp_bg_line_d);
        }
        if (this.isb != null) {
            this.isb.bkF();
        }
    }

    public void dHp() {
        if (this.dSO != null) {
            this.dSO.dismiss();
        }
    }
}
