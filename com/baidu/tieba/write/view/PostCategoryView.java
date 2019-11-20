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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow bUr;
    private TabMenuPopView fQK;
    private View fQz;
    private LinearLayout fhN;
    private boolean jSh;
    private LinearLayout jSi;
    private Drawable jSj;
    private Drawable jSk;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jSh = false;
        this.jSj = am.getDrawable(R.drawable.icon_title_down);
        this.jSj.setBounds(0, 0, this.jSj.getIntrinsicWidth(), this.jSj.getIntrinsicHeight());
        this.jSk = am.getDrawable(R.drawable.icon_title_up);
        this.jSk.setBounds(0, 0, this.jSk.getIntrinsicWidth(), this.jSj.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jSj, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.fhN = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jSi = (LinearLayout) this.fhN.findViewById(R.id.pop_category_layout);
        this.fQK = (TabMenuPopView) this.jSi.findViewById(R.id.pop_category_view);
        this.fQz = this.fhN.findViewById(R.id.pop_category_grav);
        this.fQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.czc();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fQK.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fQK.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fQK.setOnItemClickCallBack(aVar);
    }

    public void czb() {
        if (this.jSh) {
            setCompoundDrawables(null, null, this.jSj, null);
            this.jSh = false;
        } else {
            a(this);
            if (this.bUr != null) {
                this.bUr.refresh();
                this.bUr.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bUr.setHeight(-1);
                this.bUr.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jSk, null);
                this.jSh = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bUr == null) {
            this.bUr = new MorePopupWindow((Activity) this.mContext, this.fhN, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agh() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agi() {
                    if (PostCategoryView.this.bUr != null) {
                        PostCategoryView.this.bUr.dismiss();
                    }
                }
            });
            this.bUr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.czb();
                    }
                }
            });
        }
    }

    public void anM() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.jSi != null) {
            am.setBackgroundColor(this.jSi, R.color.cp_bg_line_d);
        }
        if (this.fQK != null) {
            this.fQK.anM();
        }
    }

    public void czc() {
        if (this.bUr != null) {
            this.bUr.dismiss();
        }
    }
}
