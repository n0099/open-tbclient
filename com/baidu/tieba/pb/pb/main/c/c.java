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
    private OriginalThreadCardView fKZ;
    private int fsI;
    private int iGN;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.fsI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.iGN = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.fKZ == null) {
            this.fKZ = new OriginalThreadCardView(this.cVg.getPageActivity());
            this.fKZ.fLJ = this.iGN;
            this.fKZ.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.iST != null) {
                        c.this.iST.a(c.this.fKZ, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bj aAe() {
                                if (c.this.iSU != null) {
                                    return c.this.iSU.aAU();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public al aAg() {
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
            layoutParams.bottomMargin = this.fsI;
            layoutParams.leftMargin = this.fsI;
            layoutParams.rightMargin = this.fsI;
            this.fKZ.setLayoutParams(layoutParams);
            this.fKZ.onChangeSkinType();
        }
        return this.fKZ;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iSU = originalThreadInfo;
        if (this.fKZ != null) {
            this.fKZ.b(this.iSU);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fKZ != null) {
                this.fKZ.onChangeSkinType();
            }
        }
    }
}
