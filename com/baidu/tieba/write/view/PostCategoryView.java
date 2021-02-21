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
/* loaded from: classes8.dex */
public class PostCategoryView extends TextView {
    private MorePopupWindow eHI;
    private LinearLayout iTF;
    private TabMenuPopView jIA;
    private View jIo;
    private Context mContext;
    private boolean oir;
    private LinearLayout ois;
    private Drawable oit;
    private Drawable oiu;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.oir = false;
        this.oit = ap.getDrawable(R.drawable.icon_title_down);
        this.oit.setBounds(0, 0, this.oit.getIntrinsicWidth(), this.oit.getIntrinsicHeight());
        this.oiu = ap.getDrawable(R.drawable.icon_title_up);
        this.oiu.setBounds(0, 0, this.oiu.getIntrinsicWidth(), this.oit.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.oit, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.iTF = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.ois = (LinearLayout) this.iTF.findViewById(R.id.pop_category_layout);
        this.jIA = (TabMenuPopView) this.ois.findViewById(R.id.pop_category_view);
        this.jIo = this.iTF.findViewById(R.id.pop_category_grav);
        this.jIo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.dXL();
            }
        });
    }

    public void setCategoryContainerData(List<bc> list, bc bcVar) {
        this.jIA.setData(list, bcVar);
    }

    public void setCategoryContainerData(List<ab> list, ab abVar, int i) {
        this.jIA.setData(list, abVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.jIA.setOnItemClickCallBack(aVar);
    }

    public void dXK() {
        if (this.oir) {
            setCompoundDrawables(null, null, this.oit, null);
            this.oir = false;
        } else {
            a(this);
            if (this.eHI != null) {
                this.eHI.refresh();
                this.eHI.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.eHI.setHeight(-1);
                this.eHI.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.oiu, null);
                this.oir = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.eHI == null) {
            this.eHI = new MorePopupWindow((Activity) this.mContext, this.iTF, this, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkJ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkK() {
                    if (PostCategoryView.this.eHI != null) {
                        PostCategoryView.this.eHI.dismiss();
                    }
                }
            });
            this.eHI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.dXK();
                    }
                }
            });
        }
    }

    public void bup() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this, R.color.CAM_X0105, 1);
        if (this.ois != null) {
            ap.setBackgroundColor(this.ois, R.color.CAM_X0201);
        }
        if (this.jIA != null) {
            this.jIA.bup();
        }
    }

    public void dXL() {
        if (this.eHI != null) {
            this.eHI.dismiss();
        }
    }
}
