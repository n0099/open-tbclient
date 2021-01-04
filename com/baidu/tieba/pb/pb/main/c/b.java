package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.af;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public class b extends a {
    private int lMq;
    private com.baidu.tbadk.core.data.a lZT;
    private af lZU;
    private an lZV;
    private bz lZW;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lMq = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eXu.getPageActivity());
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lZU == null) {
            this.lZU = new af(this.eXu);
            this.lZU.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lZU.getView(), layoutParams);
        if (this.lZV == null) {
            this.lZV = new an(this.eXu.getPageActivity());
        }
        this.mRootView.addView(this.lZV.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lZS = originalThreadInfo;
        this.lZW = originalThreadInfo == null ? null : originalThreadInfo.bpQ();
        this.lZT = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public bz boO() {
                return b.this.lZW;
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
        if (this.lZV != null) {
            this.lZV.D(this.lZT);
        }
        if (this.lZU != null) {
            this.lZU.D(this.lZT);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.lZV != null) {
            this.lZV.setOnCardSubClickListener(this.lZR);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0089a interfaceC0089a) {
        super.a(interfaceC0089a);
        if (this.lZV != null) {
            this.lZV.a(interfaceC0089a);
        }
        if (this.lZU != null) {
            this.lZU.a(interfaceC0089a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ahg != null) {
                        b.this.ahg.a(b.this.lZT);
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
            if (this.lZU != null) {
                this.lZU.onChangeSkinType(tbPageContext, i);
            }
            if (this.lZV != null) {
                this.lZV.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
