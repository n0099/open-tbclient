package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class f extends a {
    private m kAB;
    private AbsThreadDataSupport kAs;
    private bv kAv;
    private int kno;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kno = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.kAB == null) {
            this.kAB = new m(this.dVN.getPageActivity());
            this.kAB.b((Boolean) true);
            this.kAB.setFrom("pb");
            this.kAB.setFromForPb(0);
            this.kAB.e(this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dVN.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.kAB.aG(false);
        }
        this.mRootView = this.kAB.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kAr = originalThreadInfo;
        this.kAv = originalThreadInfo == null ? null : originalThreadInfo.aUM();
        this.kAs = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bv aTN() {
                return f.this.kAv;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public aq aTP() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.kAB != null) {
            this.kAB.D(this.kAs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kAB != null) {
            this.kAB.setOnCardSubClickListener(this.kAq);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kAB != null) {
            this.kAB.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.adO != null) {
                        f.this.adO.a(f.this.kAs);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.kAB != null) {
                this.kAB.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
