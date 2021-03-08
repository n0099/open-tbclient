package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.af;
import com.baidu.card.ar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class i extends a {
    private int lSW;
    private LinearLayout mRootView;
    private com.baidu.tbadk.core.data.a mgK;
    private af mgL;
    private cb mgN;
    private ar mgV;
    private VoteView mgY;

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lSW = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eWx.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.mgL == null) {
            this.mgL = new af(this.eWx);
            this.mgL.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.mgL.getView(), layoutParams);
        if (this.mgV == null) {
            this.mgV = new ar(this.eWx.getPageActivity());
            this.mgV.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.mgV.getView(), layoutParams2);
        if (this.mgY == null) {
            this.mgY = new VoteView(this.eWx.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.mgY, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mgJ = originalThreadInfo;
        this.mgN = originalThreadInfo == null ? null : originalThreadInfo.bms();
        this.mgK = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.i.1
            @Override // com.baidu.tbadk.core.data.a
            public cb blp() {
                return i.this.mgN;
            }

            @Override // com.baidu.tbadk.core.data.a
            public av blr() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.mgV != null) {
            this.mgV.E(this.mgK);
        }
        if (this.mgL != null) {
            this.mgL.E(this.mgK);
        }
        if (this.mgJ.pollData != null && this.mgJ.pollData.getOptions() != null && this.mgJ.pollData.getOptions().size() > 0) {
            this.mgY.setIsTransmit(true);
            this.mgY.setData(this.mgJ.pollData, this.mgJ.threadId, this.mgJ.forumId);
            this.mgY.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.mgY);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.mgV != null) {
            this.mgV.setOnCardSubClickListener(this.mgI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0094a interfaceC0094a) {
        super.a(interfaceC0094a);
        if (this.mgV != null) {
            this.mgV.a(interfaceC0094a);
        }
        if (this.mgL != null) {
            this.mgL.a(interfaceC0094a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.ahz != null) {
                        i.this.ahz.a(i.this.mgK);
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
            if (this.mgL != null) {
                this.mgL.onChangeSkinType(tbPageContext, i);
            }
            if (this.mgV != null) {
                this.mgV.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
