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
/* loaded from: classes21.dex */
public class c extends a {
    private OriginalThreadCardView hsh;
    private int kLk;
    private int kLm;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kLk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.kLm = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.hsh == null) {
            this.hsh = new OriginalThreadCardView(this.ehG.getPageActivity());
            this.hsh.hsV = this.kLm;
            this.hsh.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.kYG != null) {
                        c.this.kYG.a(c.this.hsh, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bw bcY() {
                                if (c.this.kYH != null) {
                                    return c.this.kYH.bdZ();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ar bda() {
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
            layoutParams.bottomMargin = this.kLk;
            layoutParams.leftMargin = this.kLk;
            layoutParams.rightMargin = this.kLk;
            this.hsh.setLayoutParams(layoutParams);
            this.hsh.onChangeSkinType();
        }
        return this.hsh;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kYH = originalThreadInfo;
        if (this.hsh != null) {
            this.hsh.b(this.kYH);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hsh != null) {
                this.hsh.onChangeSkinType();
            }
        }
    }
}
