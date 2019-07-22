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
    private TabMenuPopView fPD;
    private View fPs;
    private LinearLayout fdF;
    private boolean jRw;
    private LinearLayout jRx;
    private Drawable jRy;
    private Drawable jRz;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jRw = false;
        this.jRy = am.getDrawable(R.drawable.icon_title_down);
        this.jRy.setBounds(0, 0, this.jRy.getIntrinsicWidth(), this.jRy.getIntrinsicHeight());
        this.jRz = am.getDrawable(R.drawable.icon_title_up);
        this.jRz.setBounds(0, 0, this.jRz.getIntrinsicWidth(), this.jRy.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jRy, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        this.fdF = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jRx = (LinearLayout) this.fdF.findViewById(R.id.pop_category_layout);
        this.fPD = (TabMenuPopView) this.jRx.findViewById(R.id.pop_category_view);
        this.fPs = this.fdF.findViewById(R.id.pop_category_grav);
        this.fPs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cBl();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fPD.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fPD.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fPD.setOnItemClickCallBack(aVar);
    }

    public void cBk() {
        if (this.jRw) {
            setCompoundDrawables(null, null, this.jRy, null);
            this.jRw = false;
        } else {
            a(this);
            if (this.bCp != null) {
                this.bCp.refresh();
                this.bCp.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bCp.setHeight(-1);
                this.bCp.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jRz, null);
                this.jRw = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bCp == null) {
            this.bCp = new MorePopupWindow((Activity) this.mContext, this.fdF, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
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
                        postCategoryView.cBk();
                    }
                }
            });
        }
    }

    public void akL() {
        am.l(this, R.color.cp_bg_line_d);
        am.f(this, R.color.cp_cont_b, 1);
        if (this.jRx != null) {
            am.l(this.jRx, R.color.cp_bg_line_d);
        }
        if (this.fPD != null) {
            this.fPD.akL();
        }
    }

    public void cBl() {
        if (this.bCp != null) {
            this.bCp.dismiss();
        }
    }
}
