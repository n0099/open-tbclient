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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow bBr;
    private LinearLayout eYD;
    private TabMenuPopView fKC;
    private View fKr;
    private boolean jKr;
    private LinearLayout jKs;
    private Drawable jKt;
    private Drawable jKu;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jKr = false;
        this.jKt = al.getDrawable(R.drawable.icon_title_down);
        this.jKt.setBounds(0, 0, this.jKt.getIntrinsicWidth(), this.jKt.getIntrinsicHeight());
        this.jKu = al.getDrawable(R.drawable.icon_title_up);
        this.jKu.setBounds(0, 0, this.jKu.getIntrinsicWidth(), this.jKt.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jKt, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        this.eYD = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jKs = (LinearLayout) this.eYD.findViewById(R.id.pop_category_layout);
        this.fKC = (TabMenuPopView) this.jKs.findViewById(R.id.pop_category_view);
        this.fKr = this.eYD.findViewById(R.id.pop_category_grav);
        this.fKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cym();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fKC.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fKC.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fKC.setOnItemClickCallBack(aVar);
    }

    public void cyl() {
        if (this.jKr) {
            setCompoundDrawables(null, null, this.jKt, null);
            this.jKr = false;
        } else {
            a(this);
            if (this.bBr != null) {
                this.bBr.refresh();
                this.bBr.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bBr.setHeight(-1);
                this.bBr.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jKu, null);
                this.jKr = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bBr == null) {
            this.bBr = new MorePopupWindow((Activity) this.mContext, this.eYD, this, al.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaA() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaB() {
                    if (PostCategoryView.this.bBr != null) {
                        PostCategoryView.this.bBr.dismiss();
                    }
                }
            });
            this.bBr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cyl();
                    }
                }
            });
        }
    }

    public void ajG() {
        al.l(this, R.color.cp_bg_line_d);
        al.f(this, R.color.cp_cont_b, 1);
        if (this.jKs != null) {
            al.l(this.jKs, R.color.cp_bg_line_d);
        }
        if (this.fKC != null) {
            this.fKC.ajG();
        }
    }

    public void cym() {
        if (this.bBr != null) {
            this.bBr.dismiss();
        }
    }
}
