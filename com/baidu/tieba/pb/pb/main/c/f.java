package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class f extends a {
    private int kCO;
    private AbsThreadDataSupport kQg;
    private bw kQj;
    private n kQp;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kCO = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.kQp == null) {
            this.kQp = new n(this.efr.getPageActivity());
            this.kQp.b((Boolean) true);
            this.kQp.setFrom("pb");
            this.kQp.setFromForPb(0);
            this.kQp.e(this.efr.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.efr.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.efr.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.efr.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.kQp.aH(false);
        }
        this.mRootView = this.kQp.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kQf = originalThreadInfo;
        this.kQj = originalThreadInfo == null ? null : originalThreadInfo.bdf();
        this.kQg = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bce() {
                return f.this.kQj;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bcg() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.kQp != null) {
            this.kQp.F(this.kQg);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kQp != null) {
            this.kQp.setOnCardSubClickListener(this.kQe);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kQp != null) {
            this.kQp.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.aeW != null) {
                        f.this.aeW.a(f.this.kQg);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.kQp != null) {
                this.kQp.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
