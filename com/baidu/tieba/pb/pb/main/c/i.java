package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.af;
import com.baidu.card.ar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public class i extends a {
    private int lHL;
    private VoteView lVC;
    private com.baidu.tbadk.core.data.a lVo;
    private af lVp;
    private bz lVr;
    private ar lVz;
    private LinearLayout mRootView;

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lHL = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eSJ.getPageActivity());
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lVp == null) {
            this.lVp = new af(this.eSJ);
            this.lVp.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lVp.getView(), layoutParams);
        if (this.lVz == null) {
            this.lVz = new ar(this.eSJ.getPageActivity());
            this.lVz.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.lVz.getView(), layoutParams2);
        if (this.lVC == null) {
            this.lVC = new VoteView(this.eSJ.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.lVC, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lVn = originalThreadInfo;
        this.lVr = originalThreadInfo == null ? null : originalThreadInfo.blX();
        this.lVo = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.i.1
            @Override // com.baidu.tbadk.core.data.a
            public bz bkV() {
                return i.this.lVr;
            }

            @Override // com.baidu.tbadk.core.data.a
            public at bkX() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lVz != null) {
            this.lVz.C(this.lVo);
        }
        if (this.lVp != null) {
            this.lVp.C(this.lVo);
        }
        if (this.lVn.pollData != null && this.lVn.pollData.getOptions() != null && this.lVn.pollData.getOptions().size() > 0) {
            this.lVC.setIsTransmit(true);
            this.lVC.setData(this.lVn.pollData, this.lVn.threadId, this.lVn.forumId);
            this.lVC.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.lVC);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.lVz != null) {
            this.lVz.setOnCardSubClickListener(this.lVm);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.lVz != null) {
            this.lVz.a(interfaceC0088a);
        }
        if (this.lVp != null) {
            this.lVp.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.agp != null) {
                        i.this.agp.a(i.this.lVo);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.lVp != null) {
                this.lVp.onChangeSkinType(tbPageContext, i);
            }
            if (this.lVz != null) {
                this.lVz.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
