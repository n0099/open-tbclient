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
    private int lQF;
    private LinearLayout mRootView;
    private ar meE;
    private VoteView meH;
    private com.baidu.tbadk.core.data.a met;
    private af meu;
    private cb mew;

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lQF = i;
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
        if (this.meu == null) {
            this.meu = new af(this.eUY);
            this.meu.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.meu.getView(), layoutParams);
        if (this.meE == null) {
            this.meE = new ar(this.eUY.getPageActivity());
            this.meE.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mRootView.addView(this.meE.getView(), layoutParams2);
        if (this.meH == null) {
            this.meH = new VoteView(this.eUY.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.meH, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mes = originalThreadInfo;
        this.mew = originalThreadInfo == null ? null : originalThreadInfo.bmq();
        this.met = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.i.1
            @Override // com.baidu.tbadk.core.data.a
            public cb bln() {
                return i.this.mew;
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
        if (this.meE != null) {
            this.meE.C(this.met);
        }
        if (this.meu != null) {
            this.meu.C(this.met);
        }
        if (this.mes.pollData != null && this.mes.pollData.getOptions() != null && this.mes.pollData.getOptions().size() > 0) {
            this.meH.setIsTransmit(true);
            this.meH.setData(this.mes.pollData, this.mes.threadId, this.mes.forumId);
            this.meH.setVisibility(0);
            return;
        }
        this.mRootView.removeView(this.meH);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.meE != null) {
            this.meE.setOnCardSubClickListener(this.mer);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.meE != null) {
            this.meE.a(interfaceC0088a);
        }
        if (this.meu != null) {
            this.meu.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.agh != null) {
                        i.this.agh.a(i.this.met);
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
            if (this.meu != null) {
                this.meu.onChangeSkinType(tbPageContext, i);
            }
            if (this.meE != null) {
                this.meE.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
