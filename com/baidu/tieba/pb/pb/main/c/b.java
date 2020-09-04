package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ae;
import com.baidu.card.an;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class b extends a {
    private int kCO;
    private AbsThreadDataSupport kQg;
    private ae kQh;
    private an kQi;
    private bw kQj;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
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
        if (this.kQi == null) {
            this.kQi = new an(this.efr.getPageActivity());
        }
        this.mRootView.addView(this.kQi.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kQf = originalThreadInfo;
        this.kQj = originalThreadInfo == null ? null : originalThreadInfo.bdf();
        this.kQg = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bce() {
                return b.this.kQj;
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
            this.kQi.F(this.kQg);
        }
        if (this.kQh != null) {
            this.kQh.F(this.kQg);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kQi != null) {
            this.kQi.setOnCardSubClickListener(this.kQe);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kQi != null) {
            this.kQi.a(aVar);
        }
        if (this.kQh != null) {
            this.kQh.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.aeW != null) {
                        b.this.aeW.a(b.this.kQg);
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
            if (this.kQi != null) {
                this.kQi.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
