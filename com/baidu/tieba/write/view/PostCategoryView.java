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
    private MorePopupWindow dkv;
    private LinearLayout gLG;
    private View huJ;
    private TabMenuPopView huV;
    private boolean lCW;
    private LinearLayout lCX;
    private Drawable lCY;
    private Drawable lCZ;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.lCW = false;
        this.lCY = am.getDrawable(R.drawable.icon_title_down);
        this.lCY.setBounds(0, 0, this.lCY.getIntrinsicWidth(), this.lCY.getIntrinsicHeight());
        this.lCZ = am.getDrawable(R.drawable.icon_title_up);
        this.lCZ.setBounds(0, 0, this.lCZ.getIntrinsicWidth(), this.lCY.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.lCY, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.gLG = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.lCX = (LinearLayout) this.gLG.findViewById(R.id.pop_category_layout);
        this.huV = (TabMenuPopView) this.lCX.findViewById(R.id.pop_category_view);
        this.huJ = this.gLG.findViewById(R.id.pop_category_grav);
        this.huJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dgD();
            }
        });
    }

    public void setCategoryContainerData(List<ax> list, ax axVar) {
        this.huV.setData(list, axVar);
    }

    public void setCategoryContainerData(List<aa> list, aa aaVar, int i) {
        this.huV.setData(list, aaVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.huV.setOnItemClickCallBack(aVar);
    }

    public void dgC() {
        if (this.lCW) {
            setCompoundDrawables(null, null, this.lCY, null);
            this.lCW = false;
        } else {
            a(this);
            if (this.dkv != null) {
                this.dkv.refresh();
                this.dkv.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dkv.setHeight(-1);
                this.dkv.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.lCZ, null);
                this.lCW = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dkv == null) {
            this.dkv = new MorePopupWindow((Activity) this.mContext, this.gLG, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHY() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHZ() {
                    if (PostCategoryView.this.dkv != null) {
                        PostCategoryView.this.dkv.dismiss();
                    }
                }
            });
            this.dkv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dgC();
                    }
                }
            });
        }
    }

    public void aQp() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.lCX != null) {
            am.setBackgroundColor(this.lCX, R.color.cp_bg_line_d);
        }
        if (this.huV != null) {
            this.huV.aQp();
        }
    }

    public void dgD() {
        if (this.dkv != null) {
            this.dkv.dismiss();
        }
    }
}
