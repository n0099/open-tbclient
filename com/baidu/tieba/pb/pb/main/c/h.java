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
    private int lQF;
    private View mRootView;
    private o meC;
    private com.baidu.tbadk.core.data.a met;
    private cb mew;

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lQF = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.meC == null) {
            this.meC = new o(this.eUY.getPageActivity());
            this.meC.c(true);
            this.meC.setFrom("pb");
            this.meC.setFromForPb(0);
            this.meC.e(this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eUY.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.meC.aF(false);
            this.meC.aG(true);
        }
        this.mRootView = this.meC.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mes = originalThreadInfo;
        this.mew = originalThreadInfo == null ? null : originalThreadInfo.bmq();
        this.met = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.h.1
            @Override // com.baidu.tbadk.core.data.a
            public cb bln() {
                return h.this.mew;
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
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.agh != null) {
                        h.this.agh.a(h.this.met);
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
            if (this.meC != null) {
                this.meC.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
