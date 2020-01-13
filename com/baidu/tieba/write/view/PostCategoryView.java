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
/* loaded from: classes11.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow cGX;
    private LinearLayout fZy;
    private View gIa;
    private TabMenuPopView gIl;
    private boolean kQu;
    private LinearLayout kQv;
    private Drawable kQw;
    private Drawable kQx;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.kQu = false;
        this.kQw = am.getDrawable(R.drawable.icon_title_down);
        this.kQw.setBounds(0, 0, this.kQw.getIntrinsicWidth(), this.kQw.getIntrinsicHeight());
        this.kQx = am.getDrawable(R.drawable.icon_title_up);
        this.kQx.setBounds(0, 0, this.kQx.getIntrinsicWidth(), this.kQw.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.kQw, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.fZy = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.kQv = (LinearLayout) this.fZy.findViewById(R.id.pop_category_layout);
        this.gIl = (TabMenuPopView) this.kQv.findViewById(R.id.pop_category_view);
        this.gIa = this.fZy.findViewById(R.id.pop_category_grav);
        this.gIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cUf();
            }
        });
    }

    public void setCategoryContainerData(List<as> list, as asVar) {
        this.gIl.setData(list, asVar);
    }

    public void setCategoryContainerData(List<w> list, w wVar, int i) {
        this.gIl.setData(list, wVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.gIl.setOnItemClickCallBack(aVar);
    }

    public void cUe() {
        if (this.kQu) {
            setCompoundDrawables(null, null, this.kQw, null);
            this.kQu = false;
        } else {
            a(this);
            if (this.cGX != null) {
                this.cGX.refresh();
                this.cGX.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.cGX.setHeight(-1);
                this.cGX.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.kQx, null);
                this.kQu = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.cGX == null) {
            this.cGX = new MorePopupWindow((Activity) this.mContext, this.fZy, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axs() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axt() {
                    if (PostCategoryView.this.cGX != null) {
                        PostCategoryView.this.cGX.dismiss();
                    }
                }
            });
            this.cGX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cUe();
                    }
                }
            });
        }
    }

    public void aFw() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.kQv != null) {
            am.setBackgroundColor(this.kQv, R.color.cp_bg_line_d);
        }
        if (this.gIl != null) {
            this.gIl.aFw();
        }
    }

    public void cUf() {
        if (this.cGX != null) {
            this.cGX.dismiss();
        }
    }
}
