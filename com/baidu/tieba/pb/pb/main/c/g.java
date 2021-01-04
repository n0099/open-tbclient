package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.af;
import com.baidu.card.ar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public class g extends a {
    private ItemCardView aib;
    private com.baidu.tbadk.core.data.a lZT;
    private bz lZW;
    private LinearLayout mRootView;
    private af maa;
    private ar maf;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eXu.getPageActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.maa == null) {
            this.maa = new af(this.eXu);
            this.maa.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.maa.getView(), layoutParams);
        if (this.maf == null) {
            this.maf = new ar(this.eXu.getPageActivity());
            this.maf.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.mRootView.addView(this.maf.getView(), layoutParams2);
        if (this.aib == null) {
            this.aib = new ItemCardView(this.eXu.getPageActivity());
        }
        this.aib.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.aib, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lZS = originalThreadInfo;
        this.lZW = originalThreadInfo == null ? null : originalThreadInfo.bpQ();
        this.lZT = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.a
            public bz boO() {
                return g.this.lZW;
            }

            @Override // com.baidu.tbadk.core.data.a
            public at boQ() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.maf != null) {
            this.maf.D(this.lZT);
        }
        if (this.aib != null && originalThreadInfo != null) {
            this.aib.setData(originalThreadInfo.item, 17);
        }
        if (this.maa != null) {
            this.maa.D(this.lZT);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.maf != null) {
            this.maf.setOnCardSubClickListener(this.lZR);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0089a interfaceC0089a) {
        super.a(interfaceC0089a);
        if (this.maf != null) {
            this.maf.a(interfaceC0089a);
        }
        if (this.maa != null) {
            this.maa.a(interfaceC0089a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.ahg != null) {
                        g.this.ahg.a(g.this.lZT);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.maa != null) {
                this.maa.onChangeSkinType(tbPageContext, i);
            }
            if (this.aib != null) {
                this.aib.onChangeSkinType();
            }
            if (this.maf != null) {
                this.maf.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
