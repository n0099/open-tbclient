package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.af;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class e extends a {
    private ItemCardView afU;
    private AbsThreadDataSupport kYI;
    private bw kYL;
    private af kYP;
    private LinearLayout mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.ehG.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.kYP == null) {
            this.kYP = new af(this.ehG);
            this.kYP.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kYP.getView(), layoutParams);
        if (this.afU == null) {
            this.afU = new ItemCardView(this.ehG.getPageActivity());
        }
        this.afU.setBackGroundColor(R.color.cp_bg_line_e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        layoutParams2.leftMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.rightMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.bottomMargin = this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds42);
        this.mRootView.addView(this.afU, layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kYH = originalThreadInfo;
        this.kYL = originalThreadInfo == null ? null : originalThreadInfo.bdZ();
        this.kYI = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bcY() {
                return e.this.kYL;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bda() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.afU != null && originalThreadInfo != null) {
            this.afU.setData(originalThreadInfo.item, 17);
        }
        if (this.kYP != null) {
            this.kYP.G(this.kYI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kYP != null) {
            this.kYP.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.afo != null) {
                        e.this.afo.a(e.this.kYI);
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
            if (this.kYP != null) {
                this.kYP.onChangeSkinType(tbPageContext, i);
            }
            if (this.afU != null) {
                this.afU.onChangeSkinType();
            }
        }
    }
}
