package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class f extends a {
    private int lay;
    private AbsThreadDataSupport lnW;
    private bw lnZ;
    private o loh;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lay = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.loh == null) {
            this.loh = new o(this.etO.getPageActivity());
            this.loh.b((Boolean) true);
            this.loh.setFrom("pb");
            this.loh.setFromForPb(0);
            this.loh.e(this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.etO.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.loh.aH(false);
        }
        this.mRootView = this.loh.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lnV = originalThreadInfo;
        this.lnZ = originalThreadInfo == null ? null : originalThreadInfo.bgI();
        this.lnW = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bfG() {
                return f.this.lnZ;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bfI() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.loh != null) {
            this.loh.H(this.lnW);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.loh != null) {
            this.loh.setOnCardSubClickListener(this.lnU);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.loh != null) {
            this.loh.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.afF != null) {
                        f.this.afF.a(f.this.lnW);
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
            if (this.loh != null) {
                this.loh.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
