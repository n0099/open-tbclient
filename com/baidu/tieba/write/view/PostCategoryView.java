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
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ax;
import java.util.List;
/* loaded from: classes2.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow dyz;
    private TabMenuPopView hKB;
    private View hKp;
    private LinearLayout haJ;
    private LinearLayout lXA;
    private Drawable lXB;
    private Drawable lXC;
    private boolean lXz;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.lXz = false;
        this.lXB = am.getDrawable(R.drawable.icon_title_down);
        this.lXB.setBounds(0, 0, this.lXB.getIntrinsicWidth(), this.lXB.getIntrinsicHeight());
        this.lXC = am.getDrawable(R.drawable.icon_title_up);
        this.lXC.setBounds(0, 0, this.lXC.getIntrinsicWidth(), this.lXB.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.lXB, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.haJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.lXA = (LinearLayout) this.haJ.findViewById(R.id.pop_category_layout);
        this.hKB = (TabMenuPopView) this.lXA.findViewById(R.id.pop_category_view);
        this.hKp = this.haJ.findViewById(R.id.pop_category_grav);
        this.hKp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.doh();
            }
        });
    }

    public void setCategoryContainerData(List<ax> list, ax axVar) {
        this.hKB.setData(list, axVar);
    }

    public void setCategoryContainerData(List<aa> list, aa aaVar, int i) {
        this.hKB.setData(list, aaVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hKB.setOnItemClickCallBack(aVar);
    }

    public void dog() {
        if (this.lXz) {
            setCompoundDrawables(null, null, this.lXB, null);
            this.lXz = false;
        } else {
            a(this);
            if (this.dyz != null) {
                this.dyz.refresh();
                this.dyz.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dyz.setHeight(-1);
                this.dyz.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.lXC, null);
                this.lXz = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dyz == null) {
            this.dyz = new MorePopupWindow((Activity) this.mContext, this.haJ, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aNK() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aNL() {
                    if (PostCategoryView.this.dyz != null) {
                        PostCategoryView.this.dyz.dismiss();
                    }
                }
            });
            this.dyz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dog();
                    }
                }
            });
        }
    }

    public void aWr() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.lXA != null) {
            am.setBackgroundColor(this.lXA, R.color.cp_bg_line_d);
        }
        if (this.hKB != null) {
            this.hKB.aWr();
        }
    }

    public void doh() {
        if (this.dyz != null) {
            this.dyz.dismiss();
        }
    }
}
