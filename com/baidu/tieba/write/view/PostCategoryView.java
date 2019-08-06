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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes3.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow bCp;
    private View fQg;
    private TabMenuPopView fQr;
    private LinearLayout fef;
    private boolean jSC;
    private LinearLayout jSD;
    private Drawable jSE;
    private Drawable jSF;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jSC = false;
        this.jSE = am.getDrawable(R.drawable.icon_title_down);
        this.jSE.setBounds(0, 0, this.jSE.getIntrinsicWidth(), this.jSE.getIntrinsicHeight());
        this.jSF = am.getDrawable(R.drawable.icon_title_up);
        this.jSF.setBounds(0, 0, this.jSF.getIntrinsicWidth(), this.jSE.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jSE, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        this.fef = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jSD = (LinearLayout) this.fef.findViewById(R.id.pop_category_layout);
        this.fQr = (TabMenuPopView) this.jSD.findViewById(R.id.pop_category_view);
        this.fQg = this.fef.findViewById(R.id.pop_category_grav);
        this.fQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cBG();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fQr.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fQr.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fQr.setOnItemClickCallBack(aVar);
    }

    public void cBF() {
        if (this.jSC) {
            setCompoundDrawables(null, null, this.jSE, null);
            this.jSC = false;
        } else {
            a(this);
            if (this.bCp != null) {
                this.bCp.refresh();
                this.bCp.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bCp.setHeight(-1);
                this.bCp.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jSF, null);
                this.jSC = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bCp == null) {
            this.bCp = new MorePopupWindow((Activity) this.mContext, this.fef, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abz() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abA() {
                    if (PostCategoryView.this.bCp != null) {
                        PostCategoryView.this.bCp.dismiss();
                    }
                }
            });
            this.bCp.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cBF();
                    }
                }
            });
        }
    }

    public void akN() {
        am.l(this, R.color.cp_bg_line_d);
        am.f(this, R.color.cp_cont_b, 1);
        if (this.jSD != null) {
            am.l(this.jSD, R.color.cp_bg_line_d);
        }
        if (this.fQr != null) {
            this.fQr.akN();
        }
    }

    public void cBG() {
        if (this.bCp != null) {
            this.bCp.dismiss();
        }
    }
}
