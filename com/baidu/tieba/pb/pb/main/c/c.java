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
    private int fXV;
    private OriginalThreadCardView gqJ;
    private int jsN;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.fXV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.jsN = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.gqJ == null) {
            this.gqJ = new OriginalThreadCardView(this.duK.getPageActivity());
            this.gqJ.grt = this.jsN;
            this.gqJ.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.jEV != null) {
                        c.this.jEV.a(c.this.gqJ, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bj aIu() {
                                if (c.this.jEW != null) {
                                    return c.this.jEW.aJk();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public al aIw() {
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
            layoutParams.bottomMargin = this.fXV;
            layoutParams.leftMargin = this.fXV;
            layoutParams.rightMargin = this.fXV;
            this.gqJ.setLayoutParams(layoutParams);
            this.gqJ.onChangeSkinType();
        }
        return this.gqJ;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jEW = originalThreadInfo;
        if (this.gqJ != null) {
            this.gqJ.b(this.jEW);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gqJ != null) {
                this.gqJ.onChangeSkinType();
            }
        }
    }
}
