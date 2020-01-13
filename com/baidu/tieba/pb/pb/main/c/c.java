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
/* loaded from: classes7.dex */
public class c extends a {
    private OriginalThreadCardView fIC;
    private int fqf;
    private int iFj;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.fqf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.iFj = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.fIC == null) {
            this.fIC = new OriginalThreadCardView(this.cRe.getPageActivity());
            this.fIC.fJm = this.iFj;
            this.fIC.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.iRy != null) {
                        c.this.iRy.a(c.this.fIC, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bj axQ() {
                                if (c.this.iRz != null) {
                                    return c.this.iRz.ayG();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public al axS() {
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
            layoutParams.bottomMargin = this.fqf;
            layoutParams.leftMargin = this.fqf;
            layoutParams.rightMargin = this.fqf;
            this.fIC.setLayoutParams(layoutParams);
            this.fIC.onChangeSkinType();
        }
        return this.fIC;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void f(OriginalThreadInfo originalThreadInfo) {
        this.iRz = originalThreadInfo;
        if (this.fIC != null) {
            this.fIC.b(this.iRz);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fIC != null) {
                this.fIC.onChangeSkinType();
            }
        }
    }
}
