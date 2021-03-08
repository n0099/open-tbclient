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
    private ItemCardView ais;
    private LinearLayout mRootView;
    private com.baidu.tbadk.core.data.a mgK;
    private cb mgN;
    private o mgT;

    public f(TbPageContext tbPageContext) {
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
        if (this.mgT == null) {
            this.mgT = new o(this.eWx.getPageActivity());
            this.mgT.c(true);
            this.mgT.setFrom("pb");
            this.mgT.setFromForPb(0);
            this.mgT.e(this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.mgT.aF(false);
            this.mgT.aG(true);
        }
        this.mRootView.addView(this.mgT.getView());
        if (this.ais == null) {
            this.ais = new ItemCardView(this.eWx.getPageActivity());
        }
        this.ais.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.ais, layoutParams);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mgJ = originalThreadInfo;
        this.mgN = originalThreadInfo == null ? null : originalThreadInfo.bms();
        this.mgK = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public cb blp() {
                return f.this.mgN;
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
        if (this.ais != null && originalThreadInfo != null) {
            this.ais.setData(originalThreadInfo.item, 17);
        }
        if (this.mgT != null) {
            this.mgT.E(this.mgK);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.mgT != null) {
            this.mgT.setOnCardSubClickListener(this.mgI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0094a interfaceC0094a) {
        super.a(interfaceC0094a);
        if (this.mgT != null) {
            this.mgT.a(interfaceC0094a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.ahz != null) {
                        f.this.ahz.a(f.this.mgK);
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
            if (this.mgT != null) {
                this.mgT.onChangeSkinType(tbPageContext, i);
            }
            if (this.ais != null) {
                this.ais.onChangeSkinType();
            }
        }
    }
}
