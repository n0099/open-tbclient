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
    private int lQU;
    private LinearLayout mRootView;
    private com.baidu.tbadk.core.data.a meI;
    private af meJ;
    private cb meL;
    private ar meT;
    private VoteView meW;

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lQU = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eUY.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.meJ == null) {
            this.meJ = new af(this.eUY);
            this.meJ.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.meJ.getView(), layoutParams);
        if (this.meT == null) {
            this.meT = new ar(this.eUY.getPageActivity());
            this.meT.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.meT.getView(), layoutParams2);
        if (this.meW == null) {
            this.meW = new VoteView(this.eUY.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.meW, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.meH = originalThreadInfo;
        this.meL = originalThreadInfo == null ? null : originalThreadInfo.bmq();
        this.meI = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.i.1
            @Override // com.baidu.tbadk.core.data.a
            public cb bln() {
                return i.this.meL;
            }

            @Override // com.baidu.tbadk.core.data.a
            public av blp() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.meT != null) {
            this.meT.C(this.meI);
        }
        if (this.meJ != null) {
            this.meJ.C(this.meI);
        }
        if (this.meH.pollData != null && this.meH.pollData.getOptions() != null && this.meH.pollData.getOptions().size() > 0) {
            this.meW.setIsTransmit(true);
            this.meW.setData(this.meH.pollData, this.meH.threadId, this.meH.forumId);
            this.meW.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.meW);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.meT != null) {
            this.meT.setOnCardSubClickListener(this.meG);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.meT != null) {
            this.meT.a(interfaceC0088a);
        }
        if (this.meJ != null) {
            this.meJ.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.agh != null) {
                        i.this.agh.a(i.this.meI);
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
            if (this.meJ != null) {
                this.meJ.onChangeSkinType(tbPageContext, i);
            }
            if (this.meT != null) {
                this.meT.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
