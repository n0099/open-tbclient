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
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import java.util.List;
/* loaded from: classes13.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow cLn;
    private TabMenuPopView gLD;
    private View gLs;
    private LinearLayout gcw;
    private boolean kSW;
    private LinearLayout kSX;
    private Drawable kSY;
    private Drawable kSZ;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.kSW = false;
        this.kSY = am.getDrawable(R.drawable.icon_title_down);
        this.kSY.setBounds(0, 0, this.kSY.getIntrinsicWidth(), this.kSY.getIntrinsicHeight());
        this.kSZ = am.getDrawable(R.drawable.icon_title_up);
        this.kSZ.setBounds(0, 0, this.kSZ.getIntrinsicWidth(), this.kSY.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.kSY, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.gcw = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.kSX = (LinearLayout) this.gcw.findViewById(R.id.pop_category_layout);
        this.gLD = (TabMenuPopView) this.kSX.findViewById(R.id.pop_category_view);
        this.gLs = this.gcw.findViewById(R.id.pop_category_grav);
        this.gLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cVV();
            }
        });
    }

    public void setCategoryContainerData(List<at> list, at atVar) {
        this.gLD.setData(list, atVar);
    }

    public void setCategoryContainerData(List<x> list, x xVar, int i) {
        this.gLD.setData(list, xVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.gLD.setOnItemClickCallBack(aVar);
    }

    public void cVU() {
        if (this.kSW) {
            setCompoundDrawables(null, null, this.kSY, null);
            this.kSW = false;
        } else {
            a(this);
            if (this.cLn != null) {
                this.cLn.refresh();
                this.cLn.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.cLn.setHeight(-1);
                this.cLn.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.kSZ, null);
                this.kSW = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.cLn == null) {
            this.cLn = new MorePopupWindow((Activity) this.mContext, this.gcw, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azL() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azM() {
                    if (PostCategoryView.this.cLn != null) {
                        PostCategoryView.this.cLn.dismiss();
                    }
                }
            });
            this.cLn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cVU();
                    }
                }
            });
        }
    }

    public void aHS() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.kSX != null) {
            am.setBackgroundColor(this.kSX, R.color.cp_bg_line_d);
        }
        if (this.gLD != null) {
            this.gLD.aHS();
        }
    }

    public void cVV() {
        if (this.cLn != null) {
            this.cLn.dismiss();
        }
    }
}
