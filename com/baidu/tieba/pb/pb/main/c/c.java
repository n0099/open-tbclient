package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes9.dex */
public class c extends a {
    private OriginalThreadCardView gSC;
    private int keB;
    private int kez;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kez = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.keB = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.gSC == null) {
            this.gSC = new OriginalThreadCardView(this.dPv.getPageActivity());
            this.gSC.gTq = this.keB;
            this.gSC.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.krs != null) {
                        c.this.krs.a(c.this.gSC, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bu aPS() {
                                if (c.this.krt != null) {
                                    return c.this.krt.aQQ();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ap aPU() {
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
            layoutParams.bottomMargin = this.kez;
            layoutParams.leftMargin = this.kez;
            layoutParams.rightMargin = this.kez;
            this.gSC.setLayoutParams(layoutParams);
            this.gSC.onChangeSkinType();
        }
        return this.gSC;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.krt = originalThreadInfo;
        if (this.gSC != null) {
            this.gSC.b(this.krt);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gSC != null) {
                this.gSC.onChangeSkinType();
            }
        }
    }
}
