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
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.bf;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow eAK;
    private LinearLayout iGd;
    private View juF;
    private TabMenuPopView juR;
    private Context mContext;
    private boolean oac;
    private LinearLayout oad;
    private Drawable oae;
    private Drawable oaf;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.oac = false;
        this.oae = ap.getDrawable(R.drawable.icon_title_down);
        this.oae.setBounds(0, 0, this.oae.getIntrinsicWidth(), this.oae.getIntrinsicHeight());
        this.oaf = ap.getDrawable(R.drawable.icon_title_up);
        this.oaf.setBounds(0, 0, this.oaf.getIntrinsicWidth(), this.oae.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.oae, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iGd = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.oad = (LinearLayout) this.iGd.findViewById(R.id.pop_category_layout);
        this.juR = (TabMenuPopView) this.oad.findViewById(R.id.pop_category_view);
        this.juF = this.iGd.findViewById(R.id.pop_category_grav);
        this.juF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dZW();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.juR.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<ae> list, ae aeVar, int i) {
        this.juR.setData(list, aeVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.juR.setOnItemClickCallBack(aVar);
    }

    public void dZV() {
        if (this.oac) {
            setCompoundDrawables(null, null, this.oae, null);
            this.oac = false;
        } else {
            a(this);
            if (this.eAK != null) {
                this.eAK.refresh();
                this.eAK.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eAK.setHeight(-1);
                this.eAK.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.oaf, null);
                this.oac = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eAK == null) {
            this.eAK = new MorePopupWindow((Activity) this.mContext, this.iGd, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void blL() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void blM() {
                    if (PostCategoryView.this.eAK != null) {
                        PostCategoryView.this.eAK.dismiss();
                    }
                }
            });
            this.eAK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dZV();
                    }
                }
            });
        }
    }

    public void bvt() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.oad != null) {
            ap.setBackgroundColor(this.oad, R.color.CAM_X0201);
        }
        if (this.juR != null) {
            this.juR.bvt();
        }
    }

    public void dZW() {
        if (this.eAK != null) {
            this.eAK.dismiss();
        }
    }
}
