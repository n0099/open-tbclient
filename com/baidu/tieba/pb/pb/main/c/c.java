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
    private OriginalThreadCardView fLW;
    private int ftw;
    private int iIC;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.ftw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.iIC = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.fLW == null) {
            this.fLW = new OriginalThreadCardView(this.cVv.getPageActivity());
            this.fLW.fMG = this.iIC;
            this.fLW.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.iUI != null) {
                        c.this.iUI.a(c.this.fLW, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bj aAj() {
                                if (c.this.iUJ != null) {
                                    return c.this.iUJ.aAZ();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public al aAl() {
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
            layoutParams.bottomMargin = this.ftw;
            layoutParams.leftMargin = this.ftw;
            layoutParams.rightMargin = this.ftw;
            this.fLW.setLayoutParams(layoutParams);
            this.fLW.onChangeSkinType();
        }
        return this.fLW;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iUJ = originalThreadInfo;
        if (this.fLW != null) {
            this.fLW.b(this.iUJ);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fLW != null) {
                this.fLW.onChangeSkinType();
            }
        }
    }
}
