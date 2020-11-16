package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes21.dex */
public class f extends a {
    private com.baidu.tbadk.core.data.a lGM;
    private bx lGP;
    private o lGV;
    private int ltn;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.ltn = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.lGV == null) {
            this.lGV = new o(this.eGu.getPageActivity());
            this.lGV.b((Boolean) true);
            this.lGV.setFrom("pb");
            this.lGV.setFromForPb(0);
            this.lGV.e(this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eGu.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.lGV.aH(false);
            this.lGV.aI(true);
        }
        this.mRootView = this.lGV.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lGL = originalThreadInfo;
        this.lGP = originalThreadInfo == null ? null : originalThreadInfo.bkd();
        this.lGM = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public bx bjd() {
                return f.this.lGP;
            }

            @Override // com.baidu.tbadk.core.data.a
            public as bjf() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lGV != null) {
            this.lGV.H(this.lGM);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lGV != null) {
            this.lGV.setOnCardSubClickListener(this.lGK);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lGV != null) {
            this.lGV.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.afL != null) {
                        f.this.afL.a(f.this.lGM);
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
            if (this.lGV != null) {
                this.lGV.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
