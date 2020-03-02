package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes9.dex */
public class c extends a {
    private OriginalThreadCardView fLb;
    private int fsJ;
    private int iGP;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.fsJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.iGP = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.fLb == null) {
            this.fLb = new OriginalThreadCardView(this.cVh.getPageActivity());
            this.fLb.fLL = this.iGP;
            this.fLb.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.iSV != null) {
                        c.this.iSV.a(c.this.fLb, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bj aAg() {
                                if (c.this.iSW != null) {
                                    return c.this.iSW.aAW();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public al aAi() {
                                return null;
                            }

                            @Override // com.baidu.adp.widget.ListView.m
                            public BdUniqueId getType() {
                                return null;
                            }
                        });
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.fsJ;
            layoutParams.leftMargin = this.fsJ;
            layoutParams.rightMargin = this.fsJ;
            this.fLb.setLayoutParams(layoutParams);
            this.fLb.onChangeSkinType();
        }
        return this.fLb;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iSW = originalThreadInfo;
        if (this.fLb != null) {
            this.fLb.b(this.iSW);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fLb != null) {
                this.fLb.onChangeSkinType();
            }
        }
    }
}
