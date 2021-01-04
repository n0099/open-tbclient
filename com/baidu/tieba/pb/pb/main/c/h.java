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
    private int lMq;
    private com.baidu.tbadk.core.data.a lZT;
    private bz lZW;
    private View mRootView;
    private o mad;

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lMq = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mad == null) {
            this.mad = new o(this.eXu.getPageActivity());
            this.mad.c(true);
            this.mad.setFrom("pb");
            this.mad.setFromForPb(0);
            this.mad.e(this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eXu.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.mad.aF(false);
            this.mad.aG(true);
        }
        this.mRootView = this.mad.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lZS = originalThreadInfo;
        this.lZW = originalThreadInfo == null ? null : originalThreadInfo.bpQ();
        this.lZT = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.h.1
            @Override // com.baidu.tbadk.core.data.a
            public bz boO() {
                return h.this.lZW;
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
        if (this.mad != null) {
            this.mad.D(this.lZT);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.mad != null) {
            this.mad.setOnCardSubClickListener(this.lZR);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0089a interfaceC0089a) {
        super.a(interfaceC0089a);
        if (this.mad != null) {
            this.mad.a(interfaceC0089a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.ahg != null) {
                        h.this.ahg.a(h.this.lZT);
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
            if (this.mad != null) {
                this.mad.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
