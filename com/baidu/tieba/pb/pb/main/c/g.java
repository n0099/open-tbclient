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
/* loaded from: classes21.dex */
public class g extends a {
    private int kLm;
    private AbsThreadDataSupport kYI;
    private af kYJ;
    private bw kYL;
    private as kYT;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kLm = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.ehG.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.kYJ == null) {
            this.kYJ = new af(this.ehG);
            this.kYJ.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kYJ.getView(), layoutParams);
        if (this.kYT == null) {
            this.kYT = new as(this.ehG.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.kYT.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kYH = originalThreadInfo;
        this.kYL = originalThreadInfo == null ? null : originalThreadInfo.bdZ();
        this.kYI = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bcY() {
                return g.this.kYL;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bda() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.kYT != null) {
            this.kYT.G(this.kYI);
        }
        if (this.kYJ != null) {
            this.kYJ.G(this.kYI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kYT != null) {
            this.kYT.setOnCardSubClickListener(this.kYG);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kYT != null) {
            this.kYT.a(aVar);
        }
        if (this.kYJ != null) {
            this.kYJ.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.afo != null) {
                        g.this.afo.a(g.this.kYI);
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
            if (this.kYJ != null) {
                this.kYJ.onChangeSkinType(tbPageContext, i);
            }
            if (this.kYT != null) {
                this.kYT.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
