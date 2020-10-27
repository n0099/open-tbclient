package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class f extends a {
    private bw lAC;
    private o lAI;
    private AbsThreadDataSupport lAz;
    private int lmW;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lmW = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.lAI == null) {
            this.lAI = new o(this.eCn.getPageActivity());
            this.lAI.b((Boolean) true);
            this.lAI.setFrom("pb");
            this.lAI.setFromForPb(0);
            this.lAI.e(this.eCn.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.eCn.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.eCn.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.eCn.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.lAI.aH(false);
        }
        this.mRootView = this.lAI.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lAy = originalThreadInfo;
        this.lAC = originalThreadInfo == null ? null : originalThreadInfo.biB();
        this.lAz = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bhz() {
                return f.this.lAC;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bhB() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lAI != null) {
            this.lAI.H(this.lAz);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lAI != null) {
            this.lAI.setOnCardSubClickListener(this.lAx);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lAI != null) {
            this.lAI.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.afG != null) {
                        f.this.afG.a(f.this.lAz);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.lAI != null) {
                this.lAI.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
