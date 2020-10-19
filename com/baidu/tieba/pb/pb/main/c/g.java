package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.af;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class g extends a {
    private int lay;
    private AbsThreadDataSupport lnW;
    private af lnX;
    private bw lnZ;
    private as loj;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lay = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.etO.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lnX == null) {
            this.lnX = new af(this.etO);
            this.lnX.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.lnX.getView(), layoutParams);
        if (this.loj == null) {
            this.loj = new as(this.etO.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.loj.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lnV = originalThreadInfo;
        this.lnZ = originalThreadInfo == null ? null : originalThreadInfo.bgI();
        this.lnW = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bfG() {
                return g.this.lnZ;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bfI() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.loj != null) {
            this.loj.H(this.lnW);
        }
        if (this.lnX != null) {
            this.lnX.H(this.lnW);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.loj != null) {
            this.loj.setOnCardSubClickListener(this.lnU);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.loj != null) {
            this.loj.a(aVar);
        }
        if (this.lnX != null) {
            this.lnX.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.afF != null) {
                        g.this.afF.a(g.this.lnW);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.lnX != null) {
                this.lnX.onChangeSkinType(tbPageContext, i);
            }
            if (this.loj != null) {
                this.loj.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
