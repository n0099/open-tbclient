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
    private m kAD;
    private AbsThreadDataSupport kAu;
    private bv kAx;
    private int knq;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.knq = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.kAD == null) {
            this.kAD = new m(this.dVN.getPageActivity());
            this.kAD.b((Boolean) true);
            this.kAD.setFrom("pb");
            this.kAD.setFromForPb(0);
            this.kAD.e(this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dVN.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.kAD.aG(false);
        }
        this.mRootView = this.kAD.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kAt = originalThreadInfo;
        this.kAx = originalThreadInfo == null ? null : originalThreadInfo.aUM();
        this.kAu = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bv aTN() {
                return f.this.kAx;
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
        if (this.kAD != null) {
            this.kAD.D(this.kAu);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kAD != null) {
            this.kAD.setOnCardSubClickListener(this.kAs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kAD != null) {
            this.kAD.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.adO != null) {
                        f.this.adO.a(f.this.kAu);
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
            if (this.kAD != null) {
                this.kAD.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
