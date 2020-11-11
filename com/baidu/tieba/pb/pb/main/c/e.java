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
/* loaded from: classes22.dex */
public class e extends a {
    private ItemCardView agn;
    private af lGC;
    private AbsThreadDataSupport lGv;
    private bw lGy;
    private LinearLayout mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eIc.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lGC == null) {
            this.lGC = new af(this.eIc);
            this.lGC.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.lGC.getView(), layoutParams);
        if (this.agn == null) {
            this.agn = new ItemCardView(this.eIc.getPageActivity());
        }
        this.agn.setBackGroundColor(R.color.cp_bg_line_e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        layoutParams2.leftMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.rightMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.bottomMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds42);
        this.mRootView.addView(this.agn, layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lGu = originalThreadInfo;
        this.lGy = originalThreadInfo == null ? null : originalThreadInfo.blb();
        this.lGv = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bjZ() {
                return e.this.lGy;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bkb() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.agn != null && originalThreadInfo != null) {
            this.agn.setData(originalThreadInfo.item, 17);
        }
        if (this.lGC != null) {
            this.lGC.H(this.lGv);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lGC != null) {
            this.lGC.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.afG != null) {
                        e.this.afG.a(e.this.lGv);
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
            if (this.lGC != null) {
                this.lGC.onChangeSkinType(tbPageContext, i);
            }
            if (this.agn != null) {
                this.agn.onChangeSkinType();
            }
        }
    }
}
