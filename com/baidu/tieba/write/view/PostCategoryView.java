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
    private MorePopupWindow dUY;
    private LinearLayout hNd;
    private View izf;
    private TabMenuPopView izr;
    private Context mContext;
    private boolean ncD;
    private LinearLayout ncE;
    private Drawable ncF;
    private Drawable ncG;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.ncD = false;
        this.ncF = ap.getDrawable(R.drawable.icon_title_down);
        this.ncF.setBounds(0, 0, this.ncF.getIntrinsicWidth(), this.ncF.getIntrinsicHeight());
        this.ncG = ap.getDrawable(R.drawable.icon_title_up);
        this.ncG.setBounds(0, 0, this.ncG.getIntrinsicWidth(), this.ncF.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.ncF, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hNd = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.ncE = (LinearLayout) this.hNd.findViewById(R.id.pop_category_layout);
        this.izr = (TabMenuPopView) this.ncE.findViewById(R.id.pop_category_view);
        this.izf = this.hNd.findViewById(R.id.pop_category_grav);
        this.izf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dLj();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.izr.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<af> list, af afVar, int i) {
        this.izr.setData(list, afVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.izr.setOnItemClickCallBack(aVar);
    }

    public void dLi() {
        if (this.ncD) {
            setCompoundDrawables(null, null, this.ncF, null);
            this.ncD = false;
        } else {
            a(this);
            if (this.dUY != null) {
                this.dUY.refresh();
                this.dUY.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dUY.setHeight(-1);
                this.dUY.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.ncG, null);
                this.ncD = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dUY == null) {
            this.dUY = new MorePopupWindow((Activity) this.mContext, this.hNd, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bcw() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bcx() {
                    if (PostCategoryView.this.dUY != null) {
                        PostCategoryView.this.dUY.dismiss();
                    }
                }
            });
            this.dUY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dLi();
                    }
                }
            });
        }
    }

    public void blA() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.ncE != null) {
            ap.setBackgroundColor(this.ncE, R.color.cp_bg_line_d);
        }
        if (this.izr != null) {
            this.izr.blA();
        }
    }

    public void dLj() {
        if (this.dUY != null) {
            this.dUY.dismiss();
        }
    }
}
