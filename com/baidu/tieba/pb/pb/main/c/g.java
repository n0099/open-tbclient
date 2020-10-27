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
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class g extends a {
    private af lAA;
    private bw lAC;
    private as lAK;
    private AbsThreadDataSupport lAz;
    private int lmW;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lmW = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eCn.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lAA == null) {
            this.lAA = new af(this.eCn);
            this.lAA.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eCn.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.eCn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.eCn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.lAA.getView(), layoutParams);
        if (this.lAK == null) {
            this.lAK = new as(this.eCn.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eCn.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.lAK.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lAy = originalThreadInfo;
        this.lAC = originalThreadInfo == null ? null : originalThreadInfo.biB();
        this.lAz = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bhz() {
                return g.this.lAC;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bhB() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lAK != null) {
            this.lAK.H(this.lAz);
        }
        if (this.lAA != null) {
            this.lAA.H(this.lAz);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lAK != null) {
            this.lAK.setOnCardSubClickListener(this.lAx);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lAK != null) {
            this.lAK.a(aVar);
        }
        if (this.lAA != null) {
            this.lAA.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.afG != null) {
                        g.this.afG.a(g.this.lAz);
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
            if (this.lAA != null) {
                this.lAA.onChangeSkinType(tbPageContext, i);
            }
            if (this.lAK != null) {
                this.lAK.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
