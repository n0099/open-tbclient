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
    private int kCH;
    private AbsThreadDataSupport kPZ;
    private bw kQc;
    private n kQi;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kCH = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.kQi == null) {
            this.kQi = new n(this.efn.getPageActivity());
            this.kQi.b((Boolean) true);
            this.kQi.setFrom("pb");
            this.kQi.setFromForPb(0);
            this.kQi.e(this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.efn.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.kQi.aH(false);
        }
        this.mRootView = this.kQi.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kPY = originalThreadInfo;
        this.kQc = originalThreadInfo == null ? null : originalThreadInfo.bdf();
        this.kPZ = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bce() {
                return f.this.kQc;
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
        if (this.kQi != null) {
            this.kQi.F(this.kPZ);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kQi != null) {
            this.kQi.setOnCardSubClickListener(this.kPX);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kQi != null) {
            this.kQi.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.aeU != null) {
                        f.this.aeU.a(f.this.kPZ);
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
            if (this.kQi != null) {
                this.kQi.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
