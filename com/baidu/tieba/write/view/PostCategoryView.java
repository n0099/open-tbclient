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
    private MorePopupWindow cLa;
    private View gJZ;
    private TabMenuPopView gKk;
    private LinearLayout gby;
    private boolean kRf;
    private LinearLayout kRg;
    private Drawable kRh;
    private Drawable kRi;
    private Context mContext;

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.kRf = false;
        this.kRh = am.getDrawable(R.drawable.icon_title_down);
        this.kRh.setBounds(0, 0, this.kRh.getIntrinsicWidth(), this.kRh.getIntrinsicHeight());
        this.kRi = am.getDrawable(R.drawable.icon_title_up);
        this.kRi.setBounds(0, 0, this.kRi.getIntrinsicWidth(), this.kRh.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.kRh, null);
        setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds50), 0);
        this.gby = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.pop_category, (ViewGroup) null);
        this.kRg = (LinearLayout) this.gby.findViewById(R.id.pop_category_layout);
        this.gKk = (TabMenuPopView) this.kRg.findViewById(R.id.pop_category_view);
        this.gJZ = this.gby.findViewById(R.id.pop_category_grav);
        this.gJZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCategoryView.this.cVv();
            }
        });
    }

    public void setCategoryContainerData(List<as> list, as asVar) {
        this.gKk.setData(list, asVar);
    }

    public void setCategoryContainerData(List<w> list, w wVar, int i) {
        this.gKk.setData(list, wVar, i);
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.a aVar) {
        this.gKk.setOnItemClickCallBack(aVar);
    }

    public void cVu() {
        if (this.kRf) {
            setCompoundDrawables(null, null, this.kRh, null);
            this.kRf = false;
        } else {
            a(this);
            if (this.cLa != null) {
                this.cLa.refresh();
                this.cLa.setWidthAsWidthOfDeviceScreen((Activity) this.mContext);
                this.cLa.setHeight(-1);
                this.cLa.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.kRi, null);
                this.kRf = true;
            }
        }
        invalidate();
    }

    private void a(final PostCategoryView postCategoryView) {
        if (this.cLa == null) {
            this.cLa = new MorePopupWindow((Activity) this.mContext, this.gby, this, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.write.view.PostCategoryView.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azG() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azH() {
                    if (PostCategoryView.this.cLa != null) {
                        PostCategoryView.this.cLa.dismiss();
                    }
                }
            });
            this.cLa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.view.PostCategoryView.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (postCategoryView != null) {
                        postCategoryView.cVu();
                    }
                }
            });
        }
    }

    public void aHL() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this, R.color.cp_cont_b, 1);
        if (this.kRg != null) {
            am.setBackgroundColor(this.kRg, R.color.cp_bg_line_d);
        }
        if (this.gKk != null) {
            this.gKk.aHL();
        }
    }

    public void cVv() {
        if (this.cLa != null) {
            this.cLa.dismiss();
        }
    }
}
