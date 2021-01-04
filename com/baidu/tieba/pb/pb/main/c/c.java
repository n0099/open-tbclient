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
    private OriginalThreadCardView ixo;
    private int lMo;
    private int lMq;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lMo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lMq = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.ixo == null) {
            this.ixo = new OriginalThreadCardView(this.eXu.getPageActivity());
            this.ixo.iyd = this.lMq;
            this.ixo.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lZR != null) {
                        c.this.lZR.a(c.this.ixo, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bz boO() {
                                if (c.this.lZS != null) {
                                    return c.this.lZS.bpQ();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public at boQ() {
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
            layoutParams.bottomMargin = this.lMo;
            layoutParams.leftMargin = this.lMo;
            layoutParams.rightMargin = this.lMo;
            this.ixo.setLayoutParams(layoutParams);
            this.ixo.onChangeSkinType();
        }
        return this.ixo;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lZS = originalThreadInfo;
        if (this.ixo != null) {
            this.ixo.b(this.lZS);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ixo != null) {
                this.ixo.onChangeSkinType();
            }
        }
    }
}
