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
    private OriginalThreadCardView hle;
    private int kCM;
    private int kCO;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kCM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.kCO = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.hle == null) {
            this.hle = new OriginalThreadCardView(this.efr.getPageActivity());
            this.hle.hlS = this.kCO;
            this.hle.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.kQe != null) {
                        c.this.kQe.a(c.this.hle, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bw bce() {
                                if (c.this.kQf != null) {
                                    return c.this.kQf.bdf();
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
            layoutParams.bottomMargin = this.kCM;
            layoutParams.leftMargin = this.kCM;
            layoutParams.rightMargin = this.kCM;
            this.hle.setLayoutParams(layoutParams);
            this.hle.onChangeSkinType();
        }
        return this.hle;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kQf = originalThreadInfo;
        if (this.hle != null) {
            this.hle.b(this.kQf);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hle != null) {
                this.hle.onChangeSkinType();
            }
        }
    }
}
