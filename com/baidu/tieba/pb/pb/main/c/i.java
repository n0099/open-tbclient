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
    private int lHb;
    private com.baidu.tbadk.core.data.a lUH;
    private af lUI;
    private by lUK;
    private as lUS;
    private VoteView lUV;
    private LinearLayout mRootView;

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lHb = i;
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
        if (this.lUI == null) {
            this.lUI = new af(this.eNx);
            this.lUI.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lUI.getView(), layoutParams);
        if (this.lUS == null) {
            this.lUS = new as(this.eNx.getPageActivity());
            this.lUS.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.lUS.getView(), layoutParams2);
        if (this.lUV == null) {
            this.lUV = new VoteView(this.eNx.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.lUV, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUG = originalThreadInfo;
        this.lUK = originalThreadInfo == null ? null : originalThreadInfo.bnq();
        this.lUH = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.i.1
            @Override // com.baidu.tbadk.core.data.a
            public by bmn() {
                return i.this.lUK;
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
        if (this.lUS != null) {
            this.lUS.H(this.lUH);
        }
        if (this.lUI != null) {
            this.lUI.H(this.lUH);
        }
        if (this.lUG.pollData != null && this.lUG.pollData.getOptions() != null && this.lUG.pollData.getOptions().size() > 0) {
            this.lUV.setIsTransmit(true);
            this.lUV.setData(this.lUG.pollData, this.lUG.threadId, this.lUG.forumId);
            this.lUV.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.lUV);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lUS != null) {
            this.lUS.setOnCardSubClickListener(this.lUF);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lUS != null) {
            this.lUS.a(aVar);
        }
        if (this.lUI != null) {
            this.lUI.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.agH != null) {
                        i.this.agH.a(i.this.lUH);
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
            if (this.lUI != null) {
                this.lUI.onChangeSkinType(tbPageContext, i);
            }
            if (this.lUS != null) {
                this.lUS.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
