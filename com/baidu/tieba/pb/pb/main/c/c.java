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
/* loaded from: classes16.dex */
public class c extends a {
    private OriginalThreadCardView hla;
    private int kCF;
    private int kCH;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kCF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.kCH = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.hla == null) {
            this.hla = new OriginalThreadCardView(this.efn.getPageActivity());
            this.hla.hlO = this.kCH;
            this.hla.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.kPX != null) {
                        c.this.kPX.a(c.this.hla, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bw bce() {
                                if (c.this.kPY != null) {
                                    return c.this.kPY.bdf();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ar bcg() {
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
            layoutParams.bottomMargin = this.kCF;
            layoutParams.leftMargin = this.kCF;
            layoutParams.rightMargin = this.kCF;
            this.hla.setLayoutParams(layoutParams);
            this.hla.onChangeSkinType();
        }
        return this.hla;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kPY = originalThreadInfo;
        if (this.hla != null) {
            this.hla.b(this.kPY);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hla != null) {
                this.hla.onChangeSkinType();
            }
        }
    }
}
