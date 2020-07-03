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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class g extends a {
    private int keB;
    private aq krF;
    private AbsThreadDataSupport kru;
    private ad krv;
    private bu krx;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.keB = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.dPv.getPageActivity());
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.krv == null) {
            this.krv = new ad(this.dPv);
            this.krv.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.krv.getView(), layoutParams);
        if (this.krF == null) {
            this.krF = new aq(this.dPv.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.krF.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.krt = originalThreadInfo;
        this.krx = originalThreadInfo == null ? null : originalThreadInfo.aQQ();
        this.kru = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bu aPS() {
                return g.this.krx;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ap aPU() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.krF != null) {
            this.krF.D(this.kru);
        }
        if (this.krv != null) {
            this.krv.D(this.kru);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.krF != null) {
            this.krF.setOnCardSubClickListener(this.krs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.krF != null) {
            this.krF.a(aVar);
        }
        if (this.krv != null) {
            this.krv.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.adY != null) {
                        g.this.adY.a(g.this.kru);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.krv != null) {
                this.krv.onChangeSkinType(tbPageContext, i);
            }
            if (this.krF != null) {
                this.krF.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
