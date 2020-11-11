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
    private o lGE;
    private AbsThreadDataSupport lGv;
    private bw lGy;
    private int lsX;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lsX = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.lGE == null) {
            this.lGE = new o(this.eIc.getPageActivity());
            this.lGE.b((Boolean) true);
            this.lGE.setFrom("pb");
            this.lGE.setFromForPb(0);
            this.lGE.e(this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.eIc.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.lGE.aH(false);
        }
        this.mRootView = this.lGE.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lGu = originalThreadInfo;
        this.lGy = originalThreadInfo == null ? null : originalThreadInfo.blb();
        this.lGv = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bjZ() {
                return f.this.lGy;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bkb() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lGE != null) {
            this.lGE.H(this.lGv);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lGE != null) {
            this.lGE.setOnCardSubClickListener(this.lGt);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lGE != null) {
            this.lGE.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.afG != null) {
                        f.this.afG.a(f.this.lGv);
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
            if (this.lGE != null) {
                this.lGE.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
