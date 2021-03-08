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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.bc;
import java.util.List;
/* loaded from: classes7.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow eJj;
    private LinearLayout iVo;
    private View jJX;
    private TabMenuPopView jKj;
    private Context mContext;
    private boolean okw;
    private LinearLayout okx;
    private Drawable oky;
    private Drawable okz;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.okw = false;
        this.oky = ap.getDrawable(R.drawable.icon_title_down);
        this.oky.setBounds(0, 0, this.oky.getIntrinsicWidth(), this.oky.getIntrinsicHeight());
        this.okz = ap.getDrawable(R.drawable.icon_title_up);
        this.okz.setBounds(0, 0, this.okz.getIntrinsicWidth(), this.oky.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.oky, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iVo = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.okx = (LinearLayout) this.iVo.findViewById(R.id.pop_category_layout);
        this.jKj = (TabMenuPopView) this.okx.findViewById(R.id.pop_category_view);
        this.jJX = this.iVo.findViewById(R.id.pop_category_grav);
        this.jJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dXT();
            }
        });
    }

    public void setCategoryContainerData(List<bc> list, bc bcVar) {
        this.jKj.setData(list, bcVar);
    }

    public void setCategoryContainerData(List<ab> list, ab abVar, int i) {
        this.jKj.setData(list, abVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jKj.setOnItemClickCallBack(aVar);
    }

    public void dXS() {
        if (this.okw) {
            setCompoundDrawables(null, null, this.oky, null);
            this.okw = false;
        } else {
            a(this);
            if (this.eJj != null) {
                this.eJj.refresh();
                this.eJj.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eJj.setHeight(-1);
                this.eJj.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.okz, null);
                this.okw = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eJj == null) {
            this.eJj = new MorePopupWindow((Activity) this.mContext, this.iVo, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkL() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkM() {
                    if (PostCategoryView.this.eJj != null) {
                        PostCategoryView.this.eJj.dismiss();
                    }
                }
            });
            this.eJj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dXS();
                    }
                }
            });
        }
    }

    public void bus() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.okx != null) {
            ap.setBackgroundColor(this.okx, R.color.CAM_X0201);
        }
        if (this.jKj != null) {
            this.jKj.bus();
        }
    }

    public void dXT() {
        if (this.eJj != null) {
            this.eJj.dismiss();
        }
    }
}
