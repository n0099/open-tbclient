package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ad;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends a {
    private ItemCardView aeB;
    private ad krB;
    private AbsThreadDataSupport kru;
    private bu krx;
    private LinearLayout mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
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
        if (this.krB == null) {
            this.krB = new ad(this.dPv);
            this.krB.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.krB.getView(), layoutParams);
        if (this.aeB == null) {
            this.aeB = new ItemCardView(this.dPv.getPageActivity());
        }
        this.aeB.setBackGroundColor(R.color.cp_bg_line_e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        layoutParams2.leftMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.rightMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.bottomMargin = this.dPv.getResources().getDimensionPixelOffset(R.dimen.tbds42);
        this.mRootView.addView(this.aeB, layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.krt = originalThreadInfo;
        this.krx = originalThreadInfo == null ? null : originalThreadInfo.aQQ();
        this.kru = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bu aPS() {
                return e.this.krx;
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
        if (this.aeB != null && originalThreadInfo != null) {
            this.aeB.setData(originalThreadInfo.item, 17);
        }
        if (this.krB != null) {
            this.krB.D(this.kru);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.krB != null) {
            this.krB.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.adY != null) {
                        e.this.adY.a(e.this.kru);
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
            if (this.krB != null) {
                this.krB.onChangeSkinType(tbPageContext, i);
            }
            if (this.aeB != null) {
                this.aeB.onChangeSkinType();
            }
        }
    }
}
