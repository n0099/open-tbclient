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
    private OriginalThreadCardView iyp;
    private int lQD;
    private int lQF;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lQD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lQF = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iyp == null) {
            this.iyp = new OriginalThreadCardView(this.eUY.getPageActivity());
            this.iyp.izg = this.lQF;
            this.iyp.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.mer != null) {
                        c.this.mer.a(c.this.iyp, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public cb bln() {
                                if (c.this.mes != null) {
                                    return c.this.mes.bmq();
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
            layoutParams.bottomMargin = this.lQD;
            layoutParams.leftMargin = this.lQD;
            layoutParams.rightMargin = this.lQD;
            this.iyp.setLayoutParams(layoutParams);
            this.iyp.onChangeSkinType();
        }
        return this.iyp;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mes = originalThreadInfo;
        if (this.iyp != null) {
            this.iyp.b(this.mes);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.iyp != null) {
                this.iyp.onChangeSkinType();
            }
        }
    }
}
