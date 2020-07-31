package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ad;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class e extends a {
    private ItemCardView aer;
    private AbsThreadDataSupport kAs;
    private bv kAv;
    private ad kAz;
    private LinearLayout mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
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
        if (this.kAz == null) {
            this.kAz = new ad(this.dVN);
            this.kAz.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kAz.getView(), layoutParams);
        if (this.aer == null) {
            this.aer = new ItemCardView(this.dVN.getPageActivity());
        }
        this.aer.setBackGroundColor(R.color.cp_bg_line_e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        layoutParams2.leftMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.rightMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.bottomMargin = this.dVN.getResources().getDimensionPixelOffset(R.dimen.tbds42);
        this.mRootView.addView(this.aer, layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kAr = originalThreadInfo;
        this.kAv = originalThreadInfo == null ? null : originalThreadInfo.aUM();
        this.kAs = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bv aTN() {
                return e.this.kAv;
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
        if (this.aer != null && originalThreadInfo != null) {
            this.aer.setData(originalThreadInfo.item, 17);
        }
        if (this.kAz != null) {
            this.kAz.D(this.kAs);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kAz != null) {
            this.kAz.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.adO != null) {
                        e.this.adO.a(e.this.kAs);
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
            if (this.kAz != null) {
                this.kAz.onChangeSkinType(tbPageContext, i);
            }
            if (this.aer != null) {
                this.aer.onChangeSkinType();
            }
        }
    }
}
