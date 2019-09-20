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
    private MorePopupWindow bCN;
    private View fRX;
    private TabMenuPopView fSi;
    private LinearLayout ffS;
    private boolean jUZ;
    private LinearLayout jVa;
    private Drawable jVb;
    private Drawable jVc;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jUZ = false;
        this.jVb = am.getDrawable(R.drawable.icon_title_down);
        this.jVb.setBounds(0, 0, this.jVb.getIntrinsicWidth(), this.jVb.getIntrinsicHeight());
        this.jVc = am.getDrawable(R.drawable.icon_title_up);
        this.jVc.setBounds(0, 0, this.jVc.getIntrinsicWidth(), this.jVb.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.jVb, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        this.ffS = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.jVa = (LinearLayout) this.ffS.findViewById(R.id.pop_category_layout);
        this.fSi = (TabMenuPopView) this.jVa.findViewById(R.id.pop_category_view);
        this.fRX = this.ffS.findViewById(R.id.pop_category_grav);
        this.fRX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cCu();
            }
        });
    }

    public void setCategoryContainerData(List<ar> list, ar arVar) {
        this.fSi.setData(list, arVar);
    }

    public void setCategoryContainerData(List<v> list, v vVar, int i) {
        this.fSi.setData(list, vVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.fSi.setOnItemClickCallBack(aVar);
    }

    public void cCt() {
        if (this.jUZ) {
            setCompoundDrawables(null, null, this.jVb, null);
            this.jUZ = false;
        } else {
            a(this);
            if (this.bCN != null) {
                this.bCN.refresh();
                this.bCN.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.bCN.setHeight(-1);
                this.bCN.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.jVc, null);
                this.jUZ = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.bCN == null) {
            this.bCN = new MorePopupWindow((Activity) this.mContext, this.ffS, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abD() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abE() {
                    if (PostCategoryView.this.bCN != null) {
                        PostCategoryView.this.bCN.dismiss();
                    }
                }
            });
            this.bCN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cCt();
                    }
                }
            });
        }
    }

    public void akZ() {
        am.l(this, R.color.cp_bg_line_d);
        am.f(this, R.color.cp_cont_b, 1);
        if (this.jVa != null) {
            am.l(this.jVa, R.color.cp_bg_line_d);
        }
        if (this.fSi != null) {
            this.fSi.akZ();
        }
    }

    public void cCu() {
        if (this.bCN != null) {
            this.bCN.dismiss();
        }
    }
}
