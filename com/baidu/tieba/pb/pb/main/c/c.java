package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes22.dex */
public class c extends a {
    private OriginalThreadCardView hTy;
    private int lmU;
    private int lmW;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lmU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lmW = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.hTy == null) {
            this.hTy = new OriginalThreadCardView(this.eCn.getPageActivity());
            this.hTy.hUm = this.lmW;
            this.hTy.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lAx != null) {
                        c.this.lAx.a(c.this.hTy, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bw bhz() {
                                if (c.this.lAy != null) {
                                    return c.this.lAy.biB();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ar bhB() {
                                return null;
                            }

                            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
                            public BdUniqueId getType() {
                                return null;
                            }
                        });
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.lmU;
            layoutParams.leftMargin = this.lmU;
            layoutParams.rightMargin = this.lmU;
            this.hTy.setLayoutParams(layoutParams);
            this.hTy.onChangeSkinType();
        }
        return this.hTy;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lAy = originalThreadInfo;
        if (this.hTy != null) {
            this.hTy.b(this.lAy);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hTy != null) {
                this.hTy.onChangeSkinType();
            }
        }
    }
}
