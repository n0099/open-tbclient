package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.af;
import com.baidu.card.ar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class g extends a {
    private ItemCardView ais;
    private LinearLayout mRootView;
    private com.baidu.tbadk.core.data.a mgK;
    private cb mgN;
    private af mgR;
    private ar mgV;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eWx.getPageActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.mgR == null) {
            this.mgR = new af(this.eWx);
            this.mgR.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.mgR.getView(), layoutParams);
        if (this.mgV == null) {
            this.mgV = new ar(this.eWx.getPageActivity());
            this.mgV.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.mRootView.addView(this.mgV.getView(), layoutParams2);
        if (this.ais == null) {
            this.ais = new ItemCardView(this.eWx.getPageActivity());
        }
        this.ais.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.ais, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mgJ = originalThreadInfo;
        this.mgN = originalThreadInfo == null ? null : originalThreadInfo.bms();
        this.mgK = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.a
            public cb blp() {
                return g.this.mgN;
            }

            @Override // com.baidu.tbadk.core.data.a
            public av blr() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.mgV != null) {
            this.mgV.E(this.mgK);
        }
        if (this.ais != null && originalThreadInfo != null) {
            this.ais.setData(originalThreadInfo.item, 17);
        }
        if (this.mgR != null) {
            this.mgR.E(this.mgK);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.mgV != null) {
            this.mgV.setOnCardSubClickListener(this.mgI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0094a interfaceC0094a) {
        super.a(interfaceC0094a);
        if (this.mgV != null) {
            this.mgV.a(interfaceC0094a);
        }
        if (this.mgR != null) {
            this.mgR.a(interfaceC0094a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.ahz != null) {
                        g.this.ahz.a(g.this.mgK);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.mgR != null) {
                this.mgR.onChangeSkinType(tbPageContext, i);
            }
            if (this.ais != null) {
                this.ais.onChangeSkinType();
            }
            if (this.mgV != null) {
                this.mgV.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
