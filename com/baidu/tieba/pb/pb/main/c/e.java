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
    private int iGN;
    private com.baidu.tbadk.core.data.a iSV;
    private bj iSY;
    private l iTc;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iGN = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iTc == null) {
            this.iTc = new l(this.cVg.getPageActivity());
            this.iTc.b((Boolean) true);
            this.iTc.setFrom("pb");
            this.iTc.e(this.cVg.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cVg.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.cVg.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cVg.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.iTc.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iSU = originalThreadInfo;
        this.iSY = originalThreadInfo == null ? null : originalThreadInfo.aAU();
        this.iSV = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aAe() {
                return e.this.iSY;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al aAg() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.iTc != null) {
            this.iTc.A(this.iSV);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
        if (this.iTc != null) {
            this.iTc.setOnCardSubClickListener(this.iST);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iTc != null) {
            this.iTc.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.Ka != null) {
                        e.this.Ka.a(e.this.iSV);
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
            if (this.iTc != null) {
                this.iTc.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
