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
    private MorePopupWindow epy;
    private LinearLayout ioA;
    private TabMenuPopView jaG;
    private View jau;
    private Context mContext;
    private boolean nEB;
    private LinearLayout nEC;
    private Drawable nED;
    private Drawable nEE;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.nEB = false;
        this.nED = ap.getDrawable(R.drawable.icon_title_down);
        this.nED.setBounds(0, 0, this.nED.getIntrinsicWidth(), this.nED.getIntrinsicHeight());
        this.nEE = ap.getDrawable(R.drawable.icon_title_up);
        this.nEE.setBounds(0, 0, this.nEE.getIntrinsicWidth(), this.nED.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.nED, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.ioA = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.nEC = (LinearLayout) this.ioA.findViewById(R.id.pop_category_layout);
        this.jaG = (TabMenuPopView) this.nEC.findViewById(R.id.pop_category_view);
        this.jau = this.ioA.findViewById(R.id.pop_category_grav);
        this.jau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dSd();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.jaG.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<af> list, af afVar, int i) {
        this.jaG.setData(list, afVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jaG.setOnItemClickCallBack(aVar);
    }

    public void dSc() {
        if (this.nEB) {
            setCompoundDrawables(null, null, this.nED, null);
            this.nEB = false;
        } else {
            a(this);
            if (this.epy != null) {
                this.epy.refresh();
                this.epy.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.epy.setHeight(-1);
                this.epy.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.nEE, null);
                this.nEB = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.epy == null) {
            this.epy = new MorePopupWindow((Activity) this.mContext, this.ioA, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bgX() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bgY() {
                    if (PostCategoryView.this.epy != null) {
                        PostCategoryView.this.epy.dismiss();
                    }
                }
            });
            this.epy.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dSc();
                    }
                }
            });
        }
    }

    public void bqd() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.nEC != null) {
            ap.setBackgroundColor(this.nEC, R.color.cp_bg_line_d);
        }
        if (this.jaG != null) {
            this.jaG.bqd();
        }
    }

    public void dSd() {
        if (this.epy != null) {
            this.epy.dismiss();
        }
    }
}
