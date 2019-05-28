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
    private LinearLayout eYE;
    private TabMenuPopView fKD;
    private View fKs;
    private boolean jKs;
    private LinearLayout jKt;
    private Drawable jKu;
    private Drawable jKv;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jKs = false;
        this.jKu = al.getDrawable(R.drawable.icon_title_down);
        this.jKu.setBounds(0, 0, this.jKu.getIntrinsicWidth(), this.jKu.getIntrinsicHeight());
        this.jKv = al.getDrawable(R.drawable.icon_title_up);
        this.jKv.setBounds(0, 0, this.jKv.getIntrinsicWidth(), this.jKu.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jKu, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        this.eYE = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jKt = (LinearLayout) this.eYE.findViewById(R.id.pop_category_layout);
        this.fKD = (TabMenuPopView) this.jKt.findViewById(R.id.pop_category_view);
        this.fKs = this.eYE.findViewById(R.id.pop_category_grav);
        this.fKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cyo();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fKD.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fKD.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fKD.setOnItemClickCallBack(aVar);
    }

    public void cyn() {
        if (this.jKs) {
            setCompoundDrawables(null, null, this.jKu, null);
            this.jKs = false;
        } else {
            a(this);
            if (this.bBr != null) {
                this.bBr.refresh();
                this.bBr.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bBr.setHeight(-1);
                this.bBr.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jKv, null);
                this.jKs = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bBr == null) {
            this.bBr = new MorePopupWindow((Activity) this.mContext, this.eYE, this, al.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
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
                        postCategoryView.cyn();
                    }
                }
            });
        }
    }

    public void ajG() {
        al.l(this, R.color.cp_bg_line_d);
        al.f(this, R.color.cp_cont_b, 1);
        if (this.jKt != null) {
            al.l(this.jKt, R.color.cp_bg_line_d);
        }
        if (this.fKD != null) {
            this.fKD.ajG();
        }
    }

    public void cyo() {
        if (this.bBr != null) {
            this.bBr.dismiss();
        }
    }
}
