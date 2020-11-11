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
    private MorePopupWindow evr;
    private LinearLayout iux;
    private TabMenuPopView jgD;
    private View jgr;
    private Context mContext;
    private boolean nKv;
    private LinearLayout nKw;
    private Drawable nKx;
    private Drawable nKy;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.nKv = false;
        this.nKx = ap.getDrawable(R.drawable.icon_title_down);
        this.nKx.setBounds(0, 0, this.nKx.getIntrinsicWidth(), this.nKx.getIntrinsicHeight());
        this.nKy = ap.getDrawable(R.drawable.icon_title_up);
        this.nKy.setBounds(0, 0, this.nKy.getIntrinsicWidth(), this.nKx.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.nKx, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iux = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.nKw = (LinearLayout) this.iux.findViewById(R.id.pop_category_layout);
        this.jgD = (TabMenuPopView) this.nKw.findViewById(R.id.pop_category_view);
        this.jgr = this.iux.findViewById(R.id.pop_category_grav);
        this.jgr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dUD();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.jgD.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<af> list, af afVar, int i) {
        this.jgD.setData(list, afVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jgD.setOnItemClickCallBack(aVar);
    }

    public void dUC() {
        if (this.nKv) {
            setCompoundDrawables(null, null, this.nKx, null);
            this.nKv = false;
        } else {
            a(this);
            if (this.evr != null) {
                this.evr.refresh();
                this.evr.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.evr.setHeight(-1);
                this.evr.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.nKy, null);
                this.nKv = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.evr == null) {
            this.evr = new MorePopupWindow((Activity) this.mContext, this.iux, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bjx() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bjy() {
                    if (PostCategoryView.this.evr != null) {
                        PostCategoryView.this.evr.dismiss();
                    }
                }
            });
            this.evr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dUC();
                    }
                }
            });
        }
    }

    public void bsD() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.nKw != null) {
            ap.setBackgroundColor(this.nKw, R.color.cp_bg_line_d);
        }
        if (this.jgD != null) {
            this.jgD.bsD();
        }
    }

    public void dUD() {
        if (this.evr != null) {
            this.evr.dismiss();
        }
    }
}
