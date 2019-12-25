package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes6.dex */
public class c extends a {
    private OriginalThreadCardView fFs;
    private int fmV;
    private int iBF;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.fmV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.iBF = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.fFs == null) {
            this.fFs = new OriginalThreadCardView(this.cQU.getPageActivity());
            this.fFs.fGc = this.iBF;
            this.fFs.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.iNU != null) {
                        c.this.iNU.a(c.this.fFs, new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.a
                            public bj axx() {
                                if (c.this.iNV != null) {
                                    return c.this.iNV.ayn();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.a
                            public al axz() {
                                return null;
                            }

                            @Override // com.baidu.adp.widget.ListView.m
                            public BdUniqueId getType() {
                                return null;
                            }
                        });
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.fmV;
            layoutParams.leftMargin = this.fmV;
            layoutParams.rightMargin = this.fmV;
            this.fFs.setLayoutParams(layoutParams);
            this.fFs.onChangeSkinType();
        }
        return this.fFs;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void f(OriginalThreadInfo originalThreadInfo) {
        this.iNV = originalThreadInfo;
        if (this.fFs != null) {
            this.fFs.b(this.iNV);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fFs != null) {
                this.fFs.onChangeSkinType();
            }
        }
    }
}
