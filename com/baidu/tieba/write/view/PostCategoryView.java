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
    private MorePopupWindow etI;
    private LinearLayout ivl;
    private View jhc;
    private TabMenuPopView jho;
    private Context mContext;
    private boolean nLW;
    private LinearLayout nLX;
    private Drawable nLY;
    private Drawable nLZ;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.nLW = false;
        this.nLY = ap.getDrawable(R.drawable.icon_title_down);
        this.nLY.setBounds(0, 0, this.nLY.getIntrinsicWidth(), this.nLY.getIntrinsicHeight());
        this.nLZ = ap.getDrawable(R.drawable.icon_title_up);
        this.nLZ.setBounds(0, 0, this.nLZ.getIntrinsicWidth(), this.nLY.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.nLY, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.ivl = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.nLX = (LinearLayout) this.ivl.findViewById(R.id.pop_category_layout);
        this.jho = (TabMenuPopView) this.nLX.findViewById(R.id.pop_category_view);
        this.jhc = this.ivl.findViewById(R.id.pop_category_grav);
        this.jhc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dUC();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.jho.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<af> list, af afVar, int i) {
        this.jho.setData(list, afVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jho.setOnItemClickCallBack(aVar);
    }

    public void dUB() {
        if (this.nLW) {
            setCompoundDrawables(null, null, this.nLY, null);
            this.nLW = false;
        } else {
            a(this);
            if (this.etI != null) {
                this.etI.refresh();
                this.etI.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.etI.setHeight(-1);
                this.etI.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.nLZ, null);
                this.nLW = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.etI == null) {
            this.etI = new MorePopupWindow((Activity) this.mContext, this.ivl, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void biB() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void biC() {
                    if (PostCategoryView.this.etI != null) {
                        PostCategoryView.this.etI.dismiss();
                    }
                }
            });
            this.etI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dUB();
                    }
                }
            });
        }
    }

    public void brT() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.nLX != null) {
            ap.setBackgroundColor(this.nLX, R.color.CAM_X0201);
        }
        if (this.jho != null) {
            this.jho.brT();
        }
    }

    public void dUC() {
        if (this.etI != null) {
            this.etI.dismiss();
        }
    }
}
