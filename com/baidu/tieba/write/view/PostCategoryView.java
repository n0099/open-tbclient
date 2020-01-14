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
/* loaded from: classes11.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow cGX;
    private LinearLayout fZy;
    private View gIa;
    private TabMenuPopView gIl;
    private LinearLayout kQA;
    private Drawable kQB;
    private Drawable kQC;
    private boolean kQz;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.kQz = false;
        this.kQB = am.getDrawable(R.drawable.icon_title_down);
        this.kQB.setBounds(0, 0, this.kQB.getIntrinsicWidth(), this.kQB.getIntrinsicHeight());
        this.kQC = am.getDrawable(R.drawable.icon_title_up);
        this.kQC.setBounds(0, 0, this.kQC.getIntrinsicWidth(), this.kQB.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.kQB, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.fZy = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.kQA = (LinearLayout) this.fZy.findViewById(R.id.pop_category_layout);
        this.gIl = (TabMenuPopView) this.kQA.findViewById(R.id.pop_category_view);
        this.gIa = this.fZy.findViewById(R.id.pop_category_grav);
        this.gIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cUh();
            }
        });
    }

    public void setCategoryContainerData(List<as> list, as asVar) {
        this.gIl.setData(list, asVar);
    }

    public void setCategoryContainerData(List<w> list, w wVar, int i) {
        this.gIl.setData(list, wVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.gIl.setOnItemClickCallBack(aVar);
    }

    public void cUg() {
        if (this.kQz) {
            setCompoundDrawables(null, null, this.kQB, null);
            this.kQz = false;
        } else {
            a(this);
            if (this.cGX != null) {
                this.cGX.refresh();
                this.cGX.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.cGX.setHeight(-1);
                this.cGX.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.kQC, null);
                this.kQz = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.cGX == null) {
            this.cGX = new MorePopupWindow((Activity) this.mContext, this.fZy, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axs() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axt() {
                    if (PostCategoryView.this.cGX != null) {
                        PostCategoryView.this.cGX.dismiss();
                    }
                }
            });
            this.cGX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cUg();
                    }
                }
            });
        }
    }

    public void aFw() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.kQA != null) {
            am.setBackgroundColor(this.kQA, R.color.cp_bg_line_d);
        }
        if (this.gIl != null) {
            this.gIl.aFw();
        }
    }

    public void cUh() {
        if (this.cGX != null) {
            this.cGX.dismiss();
        }
    }
}
