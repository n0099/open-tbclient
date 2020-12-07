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
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class g extends a {
    private ItemCardView ahq;
    private com.baidu.tbadk.core.data.a lUF;
    private by lUI;
    private af lUM;
    private as lUQ;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eNx.getPageActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lUM == null) {
            this.lUM = new af(this.eNx);
            this.lUM.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lUM.getView(), layoutParams);
        if (this.lUQ == null) {
            this.lUQ = new as(this.eNx.getPageActivity());
            this.lUQ.setFrom("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.mRootView.addView(this.lUQ.getView(), layoutParams2);
        if (this.ahq == null) {
            this.ahq = new ItemCardView(this.eNx.getPageActivity());
        }
        this.ahq.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.ahq, layoutParams3);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUE = originalThreadInfo;
        this.lUI = originalThreadInfo == null ? null : originalThreadInfo.bnq();
        this.lUF = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.a
            public by bmn() {
                return g.this.lUI;
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
        if (this.ahq != null && originalThreadInfo != null) {
            this.ahq.setData(originalThreadInfo.item, 17);
        }
        if (this.lUM != null) {
            this.lUM.H(this.lUF);
        }
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
        if (this.lUM != null) {
            this.lUM.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.agH != null) {
                        g.this.agH.a(g.this.lUF);
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
            if (this.lUM != null) {
                this.lUM.onChangeSkinType(tbPageContext, i);
            }
            if (this.ahq != null) {
                this.ahq.onChangeSkinType();
            }
            if (this.lUQ != null) {
                this.lUQ.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
