package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ae;
import com.baidu.card.ar;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class g extends a {
    private int kCO;
    private AbsThreadDataSupport kQg;
    private ae kQh;
    private bw kQj;
    private ar kQr;
    private LinearLayout mRootView;

    public g(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kCO = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.efr.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.kQh == null) {
            this.kQh = new ae(this.efr);
            this.kQh.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.efr.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.efr.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.efr.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kQh.getView(), layoutParams);
        if (this.kQr == null) {
            this.kQr = new ar(this.efr.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.efr.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.kQr.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kQf = originalThreadInfo;
        this.kQj = originalThreadInfo == null ? null : originalThreadInfo.bdf();
        this.kQg = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.g.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bce() {
                return g.this.kQj;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public com.baidu.tbadk.core.data.ar bcg() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.kQr != null) {
            this.kQr.F(this.kQg);
        }
        if (this.kQh != null) {
            this.kQh.F(this.kQg);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kQr != null) {
            this.kQr.setOnCardSubClickListener(this.kQe);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kQr != null) {
            this.kQr.a(aVar);
        }
        if (this.kQh != null) {
            this.kQh.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.aeW != null) {
                        g.this.aeW.a(g.this.kQg);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.kQh != null) {
                this.kQh.onChangeSkinType(tbPageContext, i);
            }
            if (this.kQr != null) {
                this.kQr.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
