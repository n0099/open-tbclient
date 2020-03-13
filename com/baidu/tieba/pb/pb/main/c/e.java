package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class e extends a {
    private int iHb;
    private com.baidu.tbadk.core.data.a iTj;
    private bj iTm;
    private l iTq;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iHb = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iTq == null) {
            this.iTq = new l(this.cVi.getPageActivity());
            this.iTq.b((Boolean) true);
            this.iTq.setFrom("pb");
            this.iTq.e(this.cVi.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cVi.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.cVi.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cVi.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.iTq.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iTi = originalThreadInfo;
        this.iTm = originalThreadInfo == null ? null : originalThreadInfo.aAW();
        this.iTj = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aAg() {
                return e.this.iTm;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al aAi() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.iTq != null) {
            this.iTq.A(this.iTj);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
        if (this.iTq != null) {
            this.iTq.setOnCardSubClickListener(this.iTh);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iTq != null) {
            this.iTq.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.Ka != null) {
                        e.this.Ka.a(e.this.iTj);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.iTq != null) {
                this.iTq.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
