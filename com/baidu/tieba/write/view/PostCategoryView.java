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
    private MorePopupWindow dyz;
    private View hJC;
    private TabMenuPopView hJO;
    private LinearLayout hay;
    private boolean lWo;
    private LinearLayout lWp;
    private Drawable lWq;
    private Drawable lWr;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.lWo = false;
        this.lWq = am.getDrawable(R.drawable.icon_title_down);
        this.lWq.setBounds(0, 0, this.lWq.getIntrinsicWidth(), this.lWq.getIntrinsicHeight());
        this.lWr = am.getDrawable(R.drawable.icon_title_up);
        this.lWr.setBounds(0, 0, this.lWr.getIntrinsicWidth(), this.lWq.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.lWq, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.hay = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.lWp = (LinearLayout) this.hay.findViewById(R.id.pop_category_layout);
        this.hJO = (TabMenuPopView) this.lWp.findViewById(R.id.pop_category_view);
        this.hJC = this.hay.findViewById(R.id.pop_category_grav);
        this.hJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dnS();
            }
        });
    }

    public void setCategoryContainerData(List<ax> list, ax axVar) {
        this.hJO.setData(list, axVar);
    }

    public void setCategoryContainerData(List<aa> list, aa aaVar, int i) {
        this.hJO.setData(list, aaVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.hJO.setOnItemClickCallBack(aVar);
    }

    public void dnR() {
        if (this.lWo) {
            setCompoundDrawables(null, null, this.lWq, null);
            this.lWo = false;
        } else {
            a(this);
            if (this.dyz != null) {
                this.dyz.refresh();
                this.dyz.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.dyz.setHeight(-1);
                this.dyz.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.lWr, null);
                this.lWo = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.dyz == null) {
            this.dyz = new MorePopupWindow((Activity) this.mContext, this.hay, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aNK() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aNL() {
                    if (PostCategoryView.this.dyz != null) {
                        PostCategoryView.this.dyz.dismiss();
                    }
                }
            });
            this.dyz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dnR();
                    }
                }
            });
        }
    }

    public void aWq() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.lWp != null) {
            am.setBackgroundColor(this.lWp, R.color.cp_bg_line_d);
        }
        if (this.hJO != null) {
            this.hJO.aWq();
        }
    }

    public void dnS() {
        if (this.dyz != null) {
            this.dyz.dismiss();
        }
    }
}
