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
    private int lHL;
    private com.baidu.tbadk.core.data.a lVo;
    private af lVp;
    private an lVq;
    private bz lVr;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lHL = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eSJ.getPageActivity());
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lVp == null) {
            this.lVp = new af(this.eSJ);
            this.lVp.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lVp.getView(), layoutParams);
        if (this.lVq == null) {
            this.lVq = new an(this.eSJ.getPageActivity());
        }
        this.mRootView.addView(this.lVq.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lVn = originalThreadInfo;
        this.lVr = originalThreadInfo == null ? null : originalThreadInfo.blX();
        this.lVo = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public bz bkV() {
                return b.this.lVr;
            }

            @Override // com.baidu.tbadk.core.data.a
            public at bkX() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lVq != null) {
            this.lVq.C(this.lVo);
        }
        if (this.lVp != null) {
            this.lVp.C(this.lVo);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.lVq != null) {
            this.lVq.setOnCardSubClickListener(this.lVm);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.lVq != null) {
            this.lVq.a(interfaceC0088a);
        }
        if (this.lVp != null) {
            this.lVp.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.agp != null) {
                        b.this.agp.a(b.this.lVo);
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
            if (this.lVp != null) {
                this.lVp.onChangeSkinType(tbPageContext, i);
            }
            if (this.lVq != null) {
                this.lVq.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
