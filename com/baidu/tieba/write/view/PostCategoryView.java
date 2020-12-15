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
    private LinearLayout iGf;
    private View juH;
    private TabMenuPopView juT;
    private Context mContext;
    private boolean oae;
    private LinearLayout oaf;
    private Drawable oag;
    private Drawable oah;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.oae = false;
        this.oag = ap.getDrawable(R.drawable.icon_title_down);
        this.oag.setBounds(0, 0, this.oag.getIntrinsicWidth(), this.oag.getIntrinsicHeight());
        this.oah = ap.getDrawable(R.drawable.icon_title_up);
        this.oah.setBounds(0, 0, this.oah.getIntrinsicWidth(), this.oag.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.oag, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iGf = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.oaf = (LinearLayout) this.iGf.findViewById(R.id.pop_category_layout);
        this.juT = (TabMenuPopView) this.oaf.findViewById(R.id.pop_category_view);
        this.juH = this.iGf.findViewById(R.id.pop_category_grav);
        this.juH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dZX();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.juT.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<ae> list, ae aeVar, int i) {
        this.juT.setData(list, aeVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.juT.setOnItemClickCallBack(aVar);
    }

    public void dZW() {
        if (this.oae) {
            setCompoundDrawables(null, null, this.oag, null);
            this.oae = false;
        } else {
            a(this);
            if (this.eAK != null) {
                this.eAK.refresh();
                this.eAK.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eAK.setHeight(-1);
                this.eAK.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.oah, null);
                this.oae = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eAK == null) {
            this.eAK = new MorePopupWindow((Activity) this.mContext, this.iGf, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
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
                        postCategoryView.dZW();
                    }
                }
            });
        }
    }

    public void bvt() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.oaf != null) {
            ap.setBackgroundColor(this.oaf, R.color.CAM_X0201);
        }
        if (this.juT != null) {
            this.juT.bvt();
        }
    }

    public void dZX() {
        if (this.eAK != null) {
            this.eAK.dismiss();
        }
    }
}
