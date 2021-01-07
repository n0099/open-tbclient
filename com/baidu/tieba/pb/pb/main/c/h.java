package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public class h extends a {
    private int lMp;
    private com.baidu.tbadk.core.data.a lZS;
    private bz lZV;
    private View mRootView;
    private o mab;

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lMp = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mab == null) {
            this.mab = new o(this.eXu.getPageActivity());
            this.mab.c(true);
            this.mab.setFrom("pb");
            this.mab.setFromForPb(0);
            this.mab.e(this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eXu.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.mab.aF(false);
            this.mab.aG(true);
        }
        this.mRootView = this.mab.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lZR = originalThreadInfo;
        this.lZV = originalThreadInfo == null ? null : originalThreadInfo.bpR();
        this.lZS = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.h.1
            @Override // com.baidu.tbadk.core.data.a
            public bz boP() {
                return h.this.lZV;
            }

            @Override // com.baidu.tbadk.core.data.a
            public at boR() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.mab != null) {
            this.mab.D(this.lZS);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.mab != null) {
            this.mab.setOnCardSubClickListener(this.lZQ);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0089a interfaceC0089a) {
        super.a(interfaceC0089a);
        if (this.mab != null) {
            this.mab.a(interfaceC0089a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.ahg != null) {
                        h.this.ahg.a(h.this.lZS);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
            if (this.mab != null) {
                this.mab.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
