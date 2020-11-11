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
    private OriginalThreadCardView hZv;
    private int lsV;
    private int lsX;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lsV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lsX = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.hZv == null) {
            this.hZv = new OriginalThreadCardView(this.eIc.getPageActivity());
            this.hZv.iaj = this.lsX;
            this.hZv.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lGt != null) {
                        c.this.lGt.a(c.this.hZv, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bw bjZ() {
                                if (c.this.lGu != null) {
                                    return c.this.lGu.blb();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ar bkb() {
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
            layoutParams.bottomMargin = this.lsV;
            layoutParams.leftMargin = this.lsV;
            layoutParams.rightMargin = this.lsV;
            this.hZv.setLayoutParams(layoutParams);
            this.hZv.onChangeSkinType();
        }
        return this.hZv;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lGu = originalThreadInfo;
        if (this.hZv != null) {
            this.hZv.b(this.lGu);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hZv != null) {
                this.hZv.onChangeSkinType();
            }
        }
    }
}
