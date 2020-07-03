package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ad;
import com.baidu.card.am;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class b extends a {
    private int keB;
    private AbsThreadDataSupport kru;
    private ad krv;
    private am krw;
    private bu krx;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.keB = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.dPv.getPageActivity());
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.krv == null) {
            this.krv = new ad(this.dPv);
            this.krv.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.krv.getView(), layoutParams);
        if (this.krw == null) {
            this.krw = new am(this.dPv.getPageActivity());
        }
        this.mRootView.addView(this.krw.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.krt = originalThreadInfo;
        this.krx = originalThreadInfo == null ? null : originalThreadInfo.aQQ();
        this.kru = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bu aPS() {
                return b.this.krx;
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
        if (this.krw != null) {
            this.krw.D(this.kru);
        }
        if (this.krv != null) {
            this.krv.D(this.kru);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.krw != null) {
            this.krw.setOnCardSubClickListener(this.krs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.krw != null) {
            this.krw.a(aVar);
        }
        if (this.krv != null) {
            this.krv.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.adY != null) {
                        b.this.adY.a(b.this.kru);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.krv != null) {
                this.krv.onChangeSkinType(tbPageContext, i);
            }
            if (this.krw != null) {
                this.krw.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
