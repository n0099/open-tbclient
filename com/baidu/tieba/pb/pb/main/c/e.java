package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class e extends a {
    private int jKQ;
    private AbsThreadDataSupport jXE;
    private bk jXH;
    private m jXL;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jKQ = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.jXL == null) {
            this.jXL = new m(this.dIF.getPageActivity());
            this.jXL.b((Boolean) true);
            this.jXL.setFrom("pb");
            this.jXL.e(this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.jXL.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jXD = originalThreadInfo;
        this.jXH = originalThreadInfo == null ? null : originalThreadInfo.aPf();
        this.jXE = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bk aOi() {
                return e.this.jXH;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ak aOk() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.jXL != null) {
            this.jXL.D(this.jXE);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.jXL != null) {
            this.jXL.setOnCardSubClickListener(this.jXC);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.jXL != null) {
            this.jXL.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.adu != null) {
                        e.this.adu.a(e.this.jXE);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.jXL != null) {
                this.jXL.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
