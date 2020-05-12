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
    private MorePopupWindow dkz;
    private LinearLayout gLM;
    private View huP;
    private TabMenuPopView hvb;
    private boolean lDa;
    private LinearLayout lDb;
    private Drawable lDc;
    private Drawable lDd;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.lDa = false;
        this.lDc = am.getDrawable(R.drawable.icon_title_down);
        this.lDc.setBounds(0, 0, this.lDc.getIntrinsicWidth(), this.lDc.getIntrinsicHeight());
        this.lDd = am.getDrawable(R.drawable.icon_title_up);
        this.lDd.setBounds(0, 0, this.lDd.getIntrinsicWidth(), this.lDc.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.lDc, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.gLM = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.lDb = (LinearLayout) this.gLM.findViewById(R.id.pop_category_layout);
        this.hvb = (TabMenuPopView) this.lDb.findViewById(R.id.pop_category_view);
        this.huP = this.gLM.findViewById(R.id.pop_category_grav);
        this.huP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dgB();
            }
        });
    }

    public void setCategoryContainerData(List<ax> list, ax axVar) {
        this.hvb.setData(list, axVar);
    }

    public void setCategoryContainerData(List<aa> list, aa aaVar, int i) {
        this.hvb.setData(list, aaVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hvb.setOnItemClickCallBack(aVar);
    }

    public void dgA() {
        if (this.lDa) {
            setCompoundDrawables(null, null, this.lDc, null);
            this.lDa = false;
        } else {
            a(this);
            if (this.dkz != null) {
                this.dkz.refresh();
                this.dkz.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dkz.setHeight(-1);
                this.dkz.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.lDd, null);
                this.lDa = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dkz == null) {
            this.dkz = new MorePopupWindow((Activity) this.mContext, this.gLM, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHW() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHX() {
                    if (PostCategoryView.this.dkz != null) {
                        PostCategoryView.this.dkz.dismiss();
                    }
                }
            });
            this.dkz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dgA();
                    }
                }
            });
        }
    }

    public void aQm() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.lDb != null) {
            am.setBackgroundColor(this.lDb, R.color.cp_bg_line_d);
        }
        if (this.hvb != null) {
            this.hvb.aQm();
        }
    }

    public void dgB() {
        if (this.dkz != null) {
            this.dkz.dismiss();
        }
    }
}
