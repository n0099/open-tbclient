package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes16.dex */
public class c extends a {
    private OriginalThreadCardView gYh;
    private int kno;
    private int knq;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kno = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.knq = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.gYh == null) {
            this.gYh = new OriginalThreadCardView(this.dVN.getPageActivity());
            this.gYh.gYV = this.knq;
            this.gYh.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.kAs != null) {
                        c.this.kAs.a(c.this.gYh, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bv aTN() {
                                if (c.this.kAt != null) {
                                    return c.this.kAt.aUM();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public aq aTP() {
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
            layoutParams.bottomMargin = this.kno;
            layoutParams.leftMargin = this.kno;
            layoutParams.rightMargin = this.kno;
            this.gYh.setLayoutParams(layoutParams);
            this.gYh.onChangeSkinType();
        }
        return this.gYh;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kAt = originalThreadInfo;
        if (this.gYh != null) {
            this.gYh.b(this.kAt);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gYh != null) {
                this.gYh.onChangeSkinType();
            }
        }
    }
}
