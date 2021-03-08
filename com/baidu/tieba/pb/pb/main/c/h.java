package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class h extends a {
    private int lSW;
    private View mRootView;
    private com.baidu.tbadk.core.data.a mgK;
    private cb mgN;
    private o mgT;

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lSW = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mgT == null) {
            this.mgT = new o(this.eWx.getPageActivity());
            this.mgT.c(true);
            this.mgT.setFrom("pb");
            this.mgT.setFromForPb(0);
            this.mgT.e(this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eWx.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.mgT.aF(false);
            this.mgT.aG(true);
        }
        this.mRootView = this.mgT.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mgJ = originalThreadInfo;
        this.mgN = originalThreadInfo == null ? null : originalThreadInfo.bms();
        this.mgK = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.h.1
            @Override // com.baidu.tbadk.core.data.a
            public cb blp() {
                return h.this.mgN;
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
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.ahz != null) {
                        h.this.ahz.a(h.this.mgK);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
            if (this.mgT != null) {
                this.mgT.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
