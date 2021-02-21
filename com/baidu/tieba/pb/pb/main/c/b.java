package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.af;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class b extends a {
    private int lQU;
    private LinearLayout mRootView;
    private com.baidu.tbadk.core.data.a meI;
    private af meJ;
    private an meK;
    private cb meL;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lQU = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eUY.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.meJ == null) {
            this.meJ = new af(this.eUY);
            this.meJ.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.meJ.getView(), layoutParams);
        if (this.meK == null) {
            this.meK = new an(this.eUY.getPageActivity());
        }
        this.mRootView.addView(this.meK.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.meH = originalThreadInfo;
        this.meL = originalThreadInfo == null ? null : originalThreadInfo.bmq();
        this.meI = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public cb bln() {
                return b.this.meL;
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
        if (this.meK != null) {
            this.meK.C(this.meI);
        }
        if (this.meJ != null) {
            this.meJ.C(this.meI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.meK != null) {
            this.meK.setOnCardSubClickListener(this.meG);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.meK != null) {
            this.meK.a(interfaceC0088a);
        }
        if (this.meJ != null) {
            this.meJ.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.agh != null) {
                        b.this.agh.a(b.this.meI);
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
            if (this.meJ != null) {
                this.meJ.onChangeSkinType(tbPageContext, i);
            }
            if (this.meK != null) {
                this.meK.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
