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
    private OriginalThreadCardView hHb;
    private int law;
    private int lay;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.law = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lay = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.hHb == null) {
            this.hHb = new OriginalThreadCardView(this.etO.getPageActivity());
            this.hHb.hHP = this.lay;
            this.hHb.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lnU != null) {
                        c.this.lnU.a(c.this.hHb, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bw bfG() {
                                if (c.this.lnV != null) {
                                    return c.this.lnV.bgI();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ar bfI() {
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
            layoutParams.bottomMargin = this.law;
            layoutParams.leftMargin = this.law;
            layoutParams.rightMargin = this.law;
            this.hHb.setLayoutParams(layoutParams);
            this.hHb.onChangeSkinType();
        }
        return this.hHb;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lnV = originalThreadInfo;
        if (this.hHb != null) {
            this.hHb.b(this.lnV);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hHb != null) {
                this.hHb.onChangeSkinType();
            }
        }
    }
}
