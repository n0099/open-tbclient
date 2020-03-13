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
    private OriginalThreadCardView fLo;
    private int fsW;
    private int iHb;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.fsW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.iHb = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.fLo == null) {
            this.fLo = new OriginalThreadCardView(this.cVi.getPageActivity());
            this.fLo.fLY = this.iHb;
            this.fLo.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.iTh != null) {
                        c.this.iTh.a(c.this.fLo, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bj aAg() {
                                if (c.this.iTi != null) {
                                    return c.this.iTi.aAW();
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
            layoutParams.bottomMargin = this.fsW;
            layoutParams.leftMargin = this.fsW;
            layoutParams.rightMargin = this.fsW;
            this.fLo.setLayoutParams(layoutParams);
            this.fLo.onChangeSkinType();
        }
        return this.fLo;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iTi = originalThreadInfo;
        if (this.fLo != null) {
            this.fLo.b(this.iTi);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fLo != null) {
                this.fLo.onChangeSkinType();
            }
        }
    }
}
