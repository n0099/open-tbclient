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
    private int lQU;
    private View mRootView;
    private com.baidu.tbadk.core.data.a meI;
    private cb meL;
    private o meR;

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lQU = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.meR == null) {
            this.meR = new o(this.eUY.getPageActivity());
            this.meR.c(true);
            this.meR.setFrom("pb");
            this.meR.setFromForPb(0);
            this.meR.e(this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eUY.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.meR.aF(false);
            this.meR.aG(true);
        }
        this.mRootView = this.meR.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.meH = originalThreadInfo;
        this.meL = originalThreadInfo == null ? null : originalThreadInfo.bmq();
        this.meI = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.h.1
            @Override // com.baidu.tbadk.core.data.a
            public cb bln() {
                return h.this.meL;
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
        if (this.meR != null) {
            this.meR.C(this.meI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.meR != null) {
            this.meR.setOnCardSubClickListener(this.meG);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.meR != null) {
            this.meR.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.agh != null) {
                        h.this.agh.a(h.this.meI);
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
            if (this.meR != null) {
                this.meR.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
