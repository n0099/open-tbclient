package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.af;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class i extends a {
    private int lGZ;
    private com.baidu.tbadk.core.data.a lUF;
    private af lUG;
    private by lUI;
    private as lUQ;
    private VoteView lUT;
    private LinearLayout mRootView;

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lGZ = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eNx.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lUG == null) {
            this.lUG = new af(this.eNx);
            this.lUG.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lUG.getView(), layoutParams);
        if (this.lUQ == null) {
            this.lUQ = new as(this.eNx.getPageActivity());
            this.lUQ.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.lUQ.getView(), layoutParams2);
        if (this.lUT == null) {
            this.lUT = new VoteView(this.eNx.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.lUT, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUE = originalThreadInfo;
        this.lUI = originalThreadInfo == null ? null : originalThreadInfo.bnq();
        this.lUF = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.i.1
            @Override // com.baidu.tbadk.core.data.a
            public by bmn() {
                return i.this.lUI;
            }

            @Override // com.baidu.tbadk.core.data.a
            public at bmp() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lUQ != null) {
            this.lUQ.H(this.lUF);
        }
        if (this.lUG != null) {
            this.lUG.H(this.lUF);
        }
        if (this.lUE.pollData != null && this.lUE.pollData.getOptions() != null && this.lUE.pollData.getOptions().size() > 0) {
            this.lUT.setIsTransmit(true);
            this.lUT.setData(this.lUE.pollData, this.lUE.threadId, this.lUE.forumId);
            this.lUT.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.lUT);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lUQ != null) {
            this.lUQ.setOnCardSubClickListener(this.lUD);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lUQ != null) {
            this.lUQ.a(aVar);
        }
        if (this.lUG != null) {
            this.lUG.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.agH != null) {
                        i.this.agH.a(i.this.lUF);
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
            if (this.lUG != null) {
                this.lUG.onChangeSkinType(tbPageContext, i);
            }
            if (this.lUQ != null) {
                this.lUQ.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
