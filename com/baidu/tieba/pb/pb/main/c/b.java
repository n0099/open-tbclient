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
    private AbsThreadDataSupport kAu;
    private ad kAv;
    private am kAw;
    private bv kAx;
    private int knq;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.knq = i;
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
        if (this.kAv == null) {
            this.kAv = new ad(this.dVN);
            this.kAv.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kAv.getView(), layoutParams);
        if (this.kAw == null) {
            this.kAw = new am(this.dVN.getPageActivity());
        }
        this.mRootView.addView(this.kAw.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kAt = originalThreadInfo;
        this.kAx = originalThreadInfo == null ? null : originalThreadInfo.aUM();
        this.kAu = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bv aTN() {
                return b.this.kAx;
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
        if (this.kAw != null) {
            this.kAw.D(this.kAu);
        }
        if (this.kAv != null) {
            this.kAv.D(this.kAu);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kAw != null) {
            this.kAw.setOnCardSubClickListener(this.kAs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kAw != null) {
            this.kAw.a(aVar);
        }
        if (this.kAv != null) {
            this.kAv.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.adO != null) {
                        b.this.adO.a(b.this.kAu);
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
            if (this.kAv != null) {
                this.kAv.onChangeSkinType(tbPageContext, i);
            }
            if (this.kAw != null) {
                this.kAw.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
