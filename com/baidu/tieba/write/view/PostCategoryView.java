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
/* loaded from: classes13.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow cLc;
    private View gKn;
    private TabMenuPopView gKy;
    private LinearLayout gbN;
    private boolean kRt;
    private LinearLayout kRu;
    private Drawable kRv;
    private Drawable kRw;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.kRt = false;
        this.kRv = am.getDrawable(R.drawable.icon_title_down);
        this.kRv.setBounds(0, 0, this.kRv.getIntrinsicWidth(), this.kRv.getIntrinsicHeight());
        this.kRw = am.getDrawable(R.drawable.icon_title_up);
        this.kRw.setBounds(0, 0, this.kRw.getIntrinsicWidth(), this.kRv.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.kRv, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.gbN = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.kRu = (LinearLayout) this.gbN.findViewById(R.id.pop_category_layout);
        this.gKy = (TabMenuPopView) this.kRu.findViewById(R.id.pop_category_view);
        this.gKn = this.gbN.findViewById(R.id.pop_category_grav);
        this.gKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cVy();
            }
        });
    }

    public void setCategoryContainerData(List<as> list, as asVar) {
        this.gKy.setData(list, asVar);
    }

    public void setCategoryContainerData(List<w> list, w wVar, int i) {
        this.gKy.setData(list, wVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.gKy.setOnItemClickCallBack(aVar);
    }

    public void cVx() {
        if (this.kRt) {
            setCompoundDrawables(null, null, this.kRv, null);
            this.kRt = false;
        } else {
            a(this);
            if (this.cLc != null) {
                this.cLc.refresh();
                this.cLc.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.cLc.setHeight(-1);
                this.cLc.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.kRw, null);
                this.kRt = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.cLc == null) {
            this.cLc = new MorePopupWindow((Activity) this.mContext, this.gbN, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azI() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azJ() {
                    if (PostCategoryView.this.cLc != null) {
                        PostCategoryView.this.cLc.dismiss();
                    }
                }
            });
            this.cLc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cVx();
                    }
                }
            });
        }
    }

    public void aHO() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.kRu != null) {
            am.setBackgroundColor(this.kRu, R.color.cp_bg_line_d);
        }
        if (this.gKy != null) {
            this.gKy.aHO();
        }
    }

    public void cVy() {
        if (this.cLc != null) {
            this.cLc.dismiss();
        }
    }
}
