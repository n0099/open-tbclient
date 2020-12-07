package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes22.dex */
public class c extends a {
    private OriginalThreadCardView ikR;
    private int lGX;
    private int lGZ;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lGX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lGZ = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.ikR == null) {
            this.ikR = new OriginalThreadCardView(this.eNx.getPageActivity());
            this.ikR.ilG = this.lGZ;
            this.ikR.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lUD != null) {
                        c.this.lUD.a(c.this.ikR, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public by bmn() {
                                if (c.this.lUE != null) {
                                    return c.this.lUE.bnq();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public at bmp() {
                                return null;
                            }

                            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
                            public BdUniqueId getType() {
                                return null;
                            }
                        });
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.lGX;
            layoutParams.leftMargin = this.lGX;
            layoutParams.rightMargin = this.lGX;
            this.ikR.setLayoutParams(layoutParams);
            this.ikR.onChangeSkinType();
        }
        return this.ikR;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUE = originalThreadInfo;
        if (this.ikR != null) {
            this.ikR.b(this.lUE);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ikR != null) {
                this.ikR.onChangeSkinType();
            }
        }
    }
}
