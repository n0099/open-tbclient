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
    private int lGZ;
    private com.baidu.tbadk.core.data.a lUF;
    private by lUI;
    private o lUO;
    private View mRootView;

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lGZ = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.lUO == null) {
            this.lUO = new o(this.eNx.getPageActivity());
            this.lUO.b((Boolean) true);
            this.lUO.setFrom("pb");
            this.lUO.setFromForPb(0);
            this.lUO.e(this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eNx.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.lUO.aG(false);
            this.lUO.aH(true);
        }
        this.mRootView = this.lUO.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUE = originalThreadInfo;
        this.lUI = originalThreadInfo == null ? null : originalThreadInfo.bnq();
        this.lUF = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.h.1
            @Override // com.baidu.tbadk.core.data.a
            public by bmn() {
                return h.this.lUI;
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
        if (this.lUO != null) {
            this.lUO.H(this.lUF);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lUO != null) {
            this.lUO.setOnCardSubClickListener(this.lUD);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lUO != null) {
            this.lUO.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.agH != null) {
                        h.this.agH.a(h.this.lUF);
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
            if (this.lUO != null) {
                this.lUO.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
