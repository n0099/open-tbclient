package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes2.dex */
public class c extends a {
    private OriginalThreadCardView isH;
    private int lHJ;
    private int lHL;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lHJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lHL = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.isH == null) {
            this.isH = new OriginalThreadCardView(this.eSJ.getPageActivity());
            this.isH.itw = this.lHL;
            this.isH.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lVm != null) {
                        c.this.lVm.a(c.this.isH, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bz bkV() {
                                if (c.this.lVn != null) {
                                    return c.this.lVn.blX();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public at bkX() {
                                return null;
                            }

                            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
                            public BdUniqueId getType() {
                                return null;
                            }
                        });
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.lHJ;
            layoutParams.leftMargin = this.lHJ;
            layoutParams.rightMargin = this.lHJ;
            this.isH.setLayoutParams(layoutParams);
            this.isH.onChangeSkinType();
        }
        return this.isH;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lVn = originalThreadInfo;
        if (this.isH != null) {
            this.isH.b(this.lVn);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.isH != null) {
                this.isH.onChangeSkinType();
            }
        }
    }
}
