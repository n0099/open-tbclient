package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class f extends a {
    private int keB;
    private m krD;
    private AbsThreadDataSupport kru;
    private bu krx;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.keB = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.krD == null) {
            this.krD = new m(this.dPv.getPageActivity());
            this.krD.b((Boolean) true);
            this.krD.setFrom("pb");
            this.krD.setFromForPb(0);
            this.krD.e(this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dPv.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.krD.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.krt = originalThreadInfo;
        this.krx = originalThreadInfo == null ? null : originalThreadInfo.aQQ();
        this.kru = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bu aPS() {
                return f.this.krx;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ap aPU() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.krD != null) {
            this.krD.D(this.kru);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.krD != null) {
            this.krD.setOnCardSubClickListener(this.krs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.krD != null) {
            this.krD.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.adY != null) {
                        f.this.adY.a(f.this.kru);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.krD != null) {
                this.krD.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
