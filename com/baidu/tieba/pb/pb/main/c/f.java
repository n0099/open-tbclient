package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class f extends a {
    private ItemCardView agZ;
    private LinearLayout mRootView;
    private o meC;
    private com.baidu.tbadk.core.data.a met;
    private cb mew;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eUY.getPageActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.meC == null) {
            this.meC = new o(this.eUY.getPageActivity());
            this.meC.c(true);
            this.meC.setFrom("pb");
            this.meC.setFromForPb(0);
            this.meC.e(this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.meC.aF(false);
            this.meC.aG(true);
        }
        this.mRootView.addView(this.meC.getView());
        if (this.agZ == null) {
            this.agZ = new ItemCardView(this.eUY.getPageActivity());
        }
        this.agZ.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.agZ, layoutParams);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mes = originalThreadInfo;
        this.mew = originalThreadInfo == null ? null : originalThreadInfo.bmq();
        this.met = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public cb bln() {
                return f.this.mew;
            }

            @Override // com.baidu.tbadk.core.data.a
            public av blp() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.agZ != null && originalThreadInfo != null) {
            this.agZ.setData(originalThreadInfo.item, 17);
        }
        if (this.meC != null) {
            this.meC.C(this.met);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.meC != null) {
            this.meC.setOnCardSubClickListener(this.mer);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.meC != null) {
            this.meC.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.agh != null) {
                        f.this.agh.a(f.this.met);
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
            if (this.meC != null) {
                this.meC.onChangeSkinType(tbPageContext, i);
            }
            if (this.agZ != null) {
                this.agZ.onChangeSkinType();
            }
        }
    }
}
