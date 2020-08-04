package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ad;
import com.baidu.card.aq;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class g extends a {
    private aq kAF;
    private AbsThreadDataSupport kAu;
    private ad kAv;
    private bv kAx;
    private int knq;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.knq = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.dVN.getPageActivity());
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.kAv == null) {
            this.kAv = new ad(this.dVN);
            this.kAv.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kAv.getView(), layoutParams);
        if (this.kAF == null) {
            this.kAF = new aq(this.dVN.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.kAF.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kAt = originalThreadInfo;
        this.kAx = originalThreadInfo == null ? null : originalThreadInfo.aUM();
        this.kAu = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bv aTN() {
                return g.this.kAx;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public com.baidu.tbadk.core.data.aq aTP() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.kAF != null) {
            this.kAF.D(this.kAu);
        }
        if (this.kAv != null) {
            this.kAv.D(this.kAu);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kAF != null) {
            this.kAF.setOnCardSubClickListener(this.kAs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kAF != null) {
            this.kAF.a(aVar);
        }
        if (this.kAv != null) {
            this.kAv.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.adO != null) {
                        g.this.adO.a(g.this.kAu);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.kAv != null) {
                this.kAv.onChangeSkinType(tbPageContext, i);
            }
            if (this.kAF != null) {
                this.kAF.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
