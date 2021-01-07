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
    private int lMp;
    private com.baidu.tbadk.core.data.a lZS;
    private af lZT;
    private bz lZV;
    private LinearLayout mRootView;
    private ar mae;
    private VoteView mah;

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lMp = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eXu.getPageActivity());
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lZT == null) {
            this.lZT = new af(this.eXu);
            this.lZT.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lZT.getView(), layoutParams);
        if (this.mae == null) {
            this.mae = new ar(this.eXu.getPageActivity());
            this.mae.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.mae.getView(), layoutParams2);
        if (this.mah == null) {
            this.mah = new VoteView(this.eXu.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.mah, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lZR = originalThreadInfo;
        this.lZV = originalThreadInfo == null ? null : originalThreadInfo.bpR();
        this.lZS = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.i.1
            @Override // com.baidu.tbadk.core.data.a
            public bz boP() {
                return i.this.lZV;
            }

            @Override // com.baidu.tbadk.core.data.a
            public at boR() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.mae != null) {
            this.mae.D(this.lZS);
        }
        if (this.lZT != null) {
            this.lZT.D(this.lZS);
        }
        if (this.lZR.pollData != null && this.lZR.pollData.getOptions() != null && this.lZR.pollData.getOptions().size() > 0) {
            this.mah.setIsTransmit(true);
            this.mah.setData(this.lZR.pollData, this.lZR.threadId, this.lZR.forumId);
            this.mah.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.mah);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.mae != null) {
            this.mae.setOnCardSubClickListener(this.lZQ);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0089a interfaceC0089a) {
        super.a(interfaceC0089a);
        if (this.mae != null) {
            this.mae.a(interfaceC0089a);
        }
        if (this.lZT != null) {
            this.lZT.a(interfaceC0089a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.ahg != null) {
                        i.this.ahg.a(i.this.lZS);
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
            if (this.lZT != null) {
                this.lZT.onChangeSkinType(tbPageContext, i);
            }
            if (this.mae != null) {
                this.mae.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
