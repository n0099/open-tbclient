package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes21.dex */
public class c extends a {
    private OriginalThreadCardView hZV;
    private int ltl;
    private int ltn;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.ltl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.ltn = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.hZV == null) {
            this.hZV = new OriginalThreadCardView(this.eGu.getPageActivity());
            this.hZV.iaK = this.ltn;
            this.hZV.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lGK != null) {
                        c.this.lGK.a(c.this.hZV, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bx bjd() {
                                if (c.this.lGL != null) {
                                    return c.this.lGL.bkd();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public as bjf() {
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
            layoutParams.bottomMargin = this.ltl;
            layoutParams.leftMargin = this.ltl;
            layoutParams.rightMargin = this.ltl;
            this.hZV.setLayoutParams(layoutParams);
            this.hZV.onChangeSkinType();
        }
        return this.hZV;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lGL = originalThreadInfo;
        if (this.hZV != null) {
            this.hZV.b(this.lGL);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hZV != null) {
                this.hZV.onChangeSkinType();
            }
        }
    }
}
