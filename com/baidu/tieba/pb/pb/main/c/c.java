package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes22.dex */
public class c extends a {
    private OriginalThreadCardView ikT;
    private int lGZ;
    private int lHb;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lGZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.lHb = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.ikT == null) {
            this.ikT = new OriginalThreadCardView(this.eNx.getPageActivity());
            this.ikT.ilI = this.lHb;
            this.ikT.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.lUF != null) {
                        c.this.lUF.a(c.this.ikT, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public by bmn() {
                                if (c.this.lUG != null) {
                                    return c.this.lUG.bnq();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public at bmp() {
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
            layoutParams.bottomMargin = this.lGZ;
            layoutParams.leftMargin = this.lGZ;
            layoutParams.rightMargin = this.lGZ;
            this.ikT.setLayoutParams(layoutParams);
            this.ikT.onChangeSkinType();
        }
        return this.ikT;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lUG = originalThreadInfo;
        if (this.ikT != null) {
            this.ikT.b(this.lUG);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ikT != null) {
                this.ikT.onChangeSkinType();
            }
        }
    }
}
