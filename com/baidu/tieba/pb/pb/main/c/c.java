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
    private OriginalThreadCardView iAm;
    private int lSU;
    private int lSW;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lSU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lSW = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iAm == null) {
            this.iAm = new OriginalThreadCardView(this.eWx.getPageActivity());
            this.iAm.iBd = this.lSW;
            this.iAm.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.mgI != null) {
                        c.this.mgI.a(c.this.iAm, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public cb blp() {
                                if (c.this.mgJ != null) {
                                    return c.this.mgJ.bms();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public av blr() {
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
            layoutParams.bottomMargin = this.lSU;
            layoutParams.leftMargin = this.lSU;
            layoutParams.rightMargin = this.lSU;
            this.iAm.setLayoutParams(layoutParams);
            this.iAm.onChangeSkinType();
        }
        return this.iAm;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.mgJ = originalThreadInfo;
        if (this.iAm != null) {
            this.iAm.b(this.mgJ);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.iAm != null) {
                this.iAm.onChangeSkinType();
            }
        }
    }
}
