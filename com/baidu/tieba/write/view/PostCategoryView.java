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
/* loaded from: classes10.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow cGL;
    private LinearLayout fWp;
    private View gEL;
    private TabMenuPopView gEW;
    private boolean kMT;
    private LinearLayout kMU;
    private Drawable kMV;
    private Drawable kMW;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.kMT = false;
        this.kMV = am.getDrawable(R.drawable.icon_title_down);
        this.kMV.setBounds(0, 0, this.kMV.getIntrinsicWidth(), this.kMV.getIntrinsicHeight());
        this.kMW = am.getDrawable(R.drawable.icon_title_up);
        this.kMW.setBounds(0, 0, this.kMW.getIntrinsicWidth(), this.kMV.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.kMV, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.fWp = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.kMU = (LinearLayout) this.fWp.findViewById(R.id.pop_category_layout);
        this.gEW = (TabMenuPopView) this.kMU.findViewById(R.id.pop_category_view);
        this.gEL = this.fWp.findViewById(R.id.pop_category_grav);
        this.gEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cTc();
            }
        });
    }

    public void setCategoryContainerData(List<as> list, as asVar) {
        this.gEW.setData(list, asVar);
    }

    public void setCategoryContainerData(List<w> list, w wVar, int i) {
        this.gEW.setData(list, wVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.gEW.setOnItemClickCallBack(aVar);
    }

    public void cTb() {
        if (this.kMT) {
            setCompoundDrawables(null, null, this.kMV, null);
            this.kMT = false;
        } else {
            a(this);
            if (this.cGL != null) {
                this.cGL.refresh();
                this.cGL.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.cGL.setHeight(-1);
                this.cGL.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.kMW, null);
                this.kMT = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.cGL == null) {
            this.cGL = new MorePopupWindow((Activity) this.mContext, this.fWp, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void awZ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axa() {
                    if (PostCategoryView.this.cGL != null) {
                        PostCategoryView.this.cGL.dismiss();
                    }
                }
            });
            this.cGL.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cTb();
                    }
                }
            });
        }
    }

    public void aFd() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.kMU != null) {
            am.setBackgroundColor(this.kMU, R.color.cp_bg_line_d);
        }
        if (this.gEW != null) {
            this.gEW.aFd();
        }
    }

    public void cTc() {
        if (this.cGL != null) {
            this.cGL.dismiss();
        }
    }
}
