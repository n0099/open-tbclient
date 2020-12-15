package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class h extends a {
    private int lHb;
    private com.baidu.tbadk.core.data.a lUH;
    private by lUK;
    private o lUQ;
    private View mRootView;

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lHb = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.lUQ == null) {
            this.lUQ = new o(this.eNx.getPageActivity());
            this.lUQ.b((Boolean) true);
            this.lUQ.setFrom("pb");
            this.lUQ.setFromForPb(0);
            this.lUQ.e(this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eNx.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.lUQ.aG(false);
            this.lUQ.aH(true);
        }
        this.mRootView = this.lUQ.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUG = originalThreadInfo;
        this.lUK = originalThreadInfo == null ? null : originalThreadInfo.bnq();
        this.lUH = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.h.1
            @Override // com.baidu.tbadk.core.data.a
            public by bmn() {
                return h.this.lUK;
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
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.agH != null) {
                        h.this.agH.a(h.this.lUH);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
            if (this.lUQ != null) {
                this.lUQ.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
