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
    private MorePopupWindow bBt;
    private LinearLayout eYE;
    private TabMenuPopView fKF;
    private View fKu;
    private boolean jKv;
    private LinearLayout jKw;
    private Drawable jKx;
    private Drawable jKy;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jKv = false;
        this.jKx = al.getDrawable(R.drawable.icon_title_down);
        this.jKx.setBounds(0, 0, this.jKx.getIntrinsicWidth(), this.jKx.getIntrinsicHeight());
        this.jKy = al.getDrawable(R.drawable.icon_title_up);
        this.jKy.setBounds(0, 0, this.jKy.getIntrinsicWidth(), this.jKx.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jKx, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        this.eYE = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jKw = (LinearLayout) this.eYE.findViewById(R.id.pop_category_layout);
        this.fKF = (TabMenuPopView) this.jKw.findViewById(R.id.pop_category_view);
        this.fKu = this.eYE.findViewById(R.id.pop_category_grav);
        this.fKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cyn();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fKF.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fKF.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fKF.setOnItemClickCallBack(aVar);
    }

    public void cym() {
        if (this.jKv) {
            setCompoundDrawables(null, null, this.jKx, null);
            this.jKv = false;
        } else {
            a(this);
            if (this.bBt != null) {
                this.bBt.refresh();
                this.bBt.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bBt.setHeight(-1);
                this.bBt.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jKy, null);
                this.jKv = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bBt == null) {
            this.bBt = new MorePopupWindow((Activity) this.mContext, this.eYE, this, al.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaA() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaB() {
                    if (PostCategoryView.this.bBt != null) {
                        PostCategoryView.this.bBt.dismiss();
                    }
                }
            });
            this.bBt.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cym();
                    }
                }
            });
        }
    }

    public void ajG() {
        al.l(this, R.color.cp_bg_line_d);
        al.f(this, R.color.cp_cont_b, 1);
        if (this.jKw != null) {
            al.l(this.jKw, R.color.cp_bg_line_d);
        }
        if (this.fKF != null) {
            this.fKF.ajG();
        }
    }

    public void cyn() {
        if (this.bBt != null) {
            this.bBt.dismiss();
        }
    }
}
