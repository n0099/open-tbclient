package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class f extends a {
    private ItemCardView ahq;
    private com.baidu.tbadk.core.data.a lUH;
    private by lUK;
    private o lUQ;
    private LinearLayout mRootView;

    public f(TbPageContext tbPageContext) {
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
        if (this.lUQ == null) {
            this.lUQ = new o(this.eNx.getPageActivity());
            this.lUQ.b((Boolean) true);
            this.lUQ.setFrom("pb");
            this.lUQ.setFromForPb(0);
            this.lUQ.e(this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.lUQ.aG(false);
            this.lUQ.aH(true);
        }
        this.mRootView.addView(this.lUQ.getView());
        if (this.ahq == null) {
            this.ahq = new ItemCardView(this.eNx.getPageActivity());
        }
        this.ahq.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.ahq, layoutParams);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUG = originalThreadInfo;
        this.lUK = originalThreadInfo == null ? null : originalThreadInfo.bnq();
        this.lUH = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public by bmn() {
                return f.this.lUK;
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
        if (this.ahq != null && originalThreadInfo != null) {
            this.ahq.setData(originalThreadInfo.item, 17);
        }
        if (this.lUQ != null) {
            this.lUQ.H(this.lUH);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lUQ != null) {
            this.lUQ.setOnCardSubClickListener(this.lUF);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lUQ != null) {
            this.lUQ.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.agH != null) {
                        f.this.agH.a(f.this.lUH);
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
            if (this.lUQ != null) {
                this.lUQ.onChangeSkinType(tbPageContext, i);
            }
            if (this.ahq != null) {
                this.ahq.onChangeSkinType();
            }
        }
    }
}
