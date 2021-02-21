package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes2.dex */
public class c extends a {
    private OriginalThreadCardView iyD;
    private int lQS;
    private int lQU;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lQS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lQU = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iyD == null) {
            this.iyD = new OriginalThreadCardView(this.eUY.getPageActivity());
            this.iyD.izu = this.lQU;
            this.iyD.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.meG != null) {
                        c.this.meG.a(c.this.iyD, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public cb bln() {
                                if (c.this.meH != null) {
                                    return c.this.meH.bmq();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public av blp() {
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
            layoutParams.bottomMargin = this.lQS;
            layoutParams.leftMargin = this.lQS;
            layoutParams.rightMargin = this.lQS;
            this.iyD.setLayoutParams(layoutParams);
            this.iyD.onChangeSkinType();
        }
        return this.iyD;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.meH = originalThreadInfo;
        if (this.iyD != null) {
            this.iyD.b(this.meH);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.iyD != null) {
                this.iyD.onChangeSkinType();
            }
        }
    }
}
