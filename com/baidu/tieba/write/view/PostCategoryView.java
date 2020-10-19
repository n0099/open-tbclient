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
    private MorePopupWindow eha;
    private View iNY;
    private TabMenuPopView iOk;
    private LinearLayout ibY;
    private Context mContext;
    private boolean nsc;
    private LinearLayout nsd;
    private Drawable nse;
    private Drawable nsf;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.nsc = false;
        this.nse = ap.getDrawable(R.drawable.icon_title_down);
        this.nse.setBounds(0, 0, this.nse.getIntrinsicWidth(), this.nse.getIntrinsicHeight());
        this.nsf = ap.getDrawable(R.drawable.icon_title_up);
        this.nsf.setBounds(0, 0, this.nsf.getIntrinsicWidth(), this.nse.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.nse, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.ibY = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.nsd = (LinearLayout) this.ibY.findViewById(R.id.pop_category_layout);
        this.iOk = (TabMenuPopView) this.nsd.findViewById(R.id.pop_category_view);
        this.iNY = this.ibY.findViewById(R.id.pop_category_grav);
        this.iNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dOV();
            }
        });
    }

    public void setCategoryContainerData(List<bf> list, bf bfVar) {
        this.iOk.setData(list, bfVar);
    }

    public void setCategoryContainerData(List<af> list, af afVar, int i) {
        this.iOk.setData(list, afVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.iOk.setOnItemClickCallBack(aVar);
    }

    public void dOU() {
        if (this.nsc) {
            setCompoundDrawables(null, null, this.nse, null);
            this.nsc = false;
        } else {
            a(this);
            if (this.eha != null) {
                this.eha.refresh();
                this.eha.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eha.setHeight(-1);
                this.eha.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.nsf, null);
                this.nsc = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eha == null) {
            this.eha = new MorePopupWindow((Activity) this.mContext, this.ibY, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bfe() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bff() {
                    if (PostCategoryView.this.eha != null) {
                        PostCategoryView.this.eha.dismiss();
                    }
                }
            });
            this.eha.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dOU();
                    }
                }
            });
        }
    }

    public void bok() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.nsd != null) {
            ap.setBackgroundColor(this.nsd, R.color.cp_bg_line_d);
        }
        if (this.iOk != null) {
            this.iOk.bok();
        }
    }

    public void dOV() {
        if (this.eha != null) {
            this.eha.dismiss();
        }
    }
}
