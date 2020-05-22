package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes9.dex */
public class c extends a {
    private OriginalThreadCardView gFy;
    private int jJI;
    private int jJK;

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jJI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.jJK = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.gFy == null) {
            this.gFy = new OriginalThreadCardView(this.dIF.getPageActivity());
            this.gFy.gGi = this.jJK;
            this.gFy.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.c.c.1
                @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                public void a(OriginalThreadInfo originalThreadInfo) {
                    if (c.this.jWw != null) {
                        c.this.jWw.a(c.this.gFy, new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.c.1.1
                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public bk aOi() {
                                if (c.this.jWx != null) {
                                    return c.this.jWx.aPf();
                                }
                                return null;
                            }

                            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
                            public ak aOk() {
                                return null;
                            }

                            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
                            public BdUniqueId getType() {
                                return null;
                            }
                        });
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.jJI;
            layoutParams.leftMargin = this.jJI;
            layoutParams.rightMargin = this.jJI;
            this.gFy.setLayoutParams(layoutParams);
            this.gFy.onChangeSkinType();
        }
        return this.gFy;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jWx = originalThreadInfo;
        if (this.gFy != null) {
            this.gFy.b(this.jWx);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gFy != null) {
                this.gFy.onChangeSkinType();
            }
        }
    }
}
