package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.af;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes21.dex */
public class g extends a {
    private com.baidu.tbadk.core.data.a lGM;
    private af lGN;
    private bx lGP;
    private as lGX;
    private VoteView lGY;
    private int ltn;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.ltn = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eGu.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lGN == null) {
            this.lGN = new af(this.eGu);
            this.lGN.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lGN.getView(), layoutParams);
        if (this.lGX == null) {
            this.lGX = new as(this.eGu.getPageActivity());
            this.lGX.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.lGX.getView(), layoutParams2);
        if (this.lGY == null) {
            this.lGY = new VoteView(this.eGu.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.lGY, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lGL = originalThreadInfo;
        this.lGP = originalThreadInfo == null ? null : originalThreadInfo.bkd();
        this.lGM = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.a
            public bx bjd() {
                return g.this.lGP;
            }

            @Override // com.baidu.tbadk.core.data.a
            public com.baidu.tbadk.core.data.as bjf() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lGX != null) {
            this.lGX.H(this.lGM);
        }
        if (this.lGN != null) {
            this.lGN.H(this.lGM);
        }
        if (this.lGL.pollData != null && this.lGL.pollData.getOptions() != null && this.lGL.pollData.getOptions().size() > 0) {
            this.lGY.setIsTransmit(true);
            this.lGY.setData(this.lGL.pollData, this.lGL.threadId, this.lGL.forumId);
            this.lGY.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.lGY);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lGX != null) {
            this.lGX.setOnCardSubClickListener(this.lGK);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lGX != null) {
            this.lGX.a(aVar);
        }
        if (this.lGN != null) {
            this.lGN.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.afL != null) {
                        g.this.afL.a(g.this.lGM);
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
            if (this.lGN != null) {
                this.lGN.onChangeSkinType(tbPageContext, i);
            }
            if (this.lGX != null) {
                this.lGX.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
