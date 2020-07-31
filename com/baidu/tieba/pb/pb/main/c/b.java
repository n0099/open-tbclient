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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class b extends a {
    private AbsThreadDataSupport kAs;
    private ad kAt;
    private am kAu;
    private bv kAv;
    private int kno;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kno = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.dVN.getPageActivity());
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.kAt == null) {
            this.kAt = new ad(this.dVN);
            this.kAt.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kAt.getView(), layoutParams);
        if (this.kAu == null) {
            this.kAu = new am(this.dVN.getPageActivity());
        }
        this.mRootView.addView(this.kAu.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kAr = originalThreadInfo;
        this.kAv = originalThreadInfo == null ? null : originalThreadInfo.aUM();
        this.kAs = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bv aTN() {
                return b.this.kAv;
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
        if (this.kAu != null) {
            this.kAu.D(this.kAs);
        }
        if (this.kAt != null) {
            this.kAt.D(this.kAs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kAu != null) {
            this.kAu.setOnCardSubClickListener(this.kAq);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kAu != null) {
            this.kAu.a(aVar);
        }
        if (this.kAt != null) {
            this.kAt.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.adO != null) {
                        b.this.adO.a(b.this.kAs);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.kAt != null) {
                this.kAt.onChangeSkinType(tbPageContext, i);
            }
            if (this.kAu != null) {
                this.kAu.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
