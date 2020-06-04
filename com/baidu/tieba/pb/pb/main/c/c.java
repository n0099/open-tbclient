package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes9.dex */
public class c extends a {
    private OriginalThreadCardView gFJ;
    private int jKO;
    private int jKQ;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jKO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.jKQ = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.gFJ == null) {
            this.gFJ = new OriginalThreadCardView(this.dIF.getPageActivity());
            this.gFJ.gGt = this.jKQ;
            this.gFJ.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.jXC != null) {
                        c.this.jXC.a(c.this.gFJ, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bk aOi() {
                                if (c.this.jXD != null) {
                                    return c.this.jXD.aPf();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ak aOk() {
                                return null;
                            }

                            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
                            public BdUniqueId getType() {
                                return null;
                            }
                        });
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.jKO;
            layoutParams.leftMargin = this.jKO;
            layoutParams.rightMargin = this.jKO;
            this.gFJ.setLayoutParams(layoutParams);
            this.gFJ.onChangeSkinType();
        }
        return this.gFJ;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jXD = originalThreadInfo;
        if (this.gFJ != null) {
            this.gFJ.b(this.jXD);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gFJ != null) {
                this.gFJ.onChangeSkinType();
            }
        }
    }
}
