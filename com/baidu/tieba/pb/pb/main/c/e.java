package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ae;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class e extends a {
    private ItemCardView afA;
    private AbsThreadDataSupport kPZ;
    private bw kQc;
    private ae kQg;
    private LinearLayout mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.efn.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.kQg == null) {
            this.kQg = new ae(this.efn);
            this.kQg.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kQg.getView(), layoutParams);
        if (this.afA == null) {
            this.afA = new ItemCardView(this.efn.getPageActivity());
        }
        this.afA.setBackGroundColor(R.color.cp_bg_line_e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        layoutParams2.leftMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.rightMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.bottomMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds42);
        this.mRootView.addView(this.afA, layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kPY = originalThreadInfo;
        this.kQc = originalThreadInfo == null ? null : originalThreadInfo.bdf();
        this.kPZ = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bce() {
                return e.this.kQc;
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
        if (this.afA != null && originalThreadInfo != null) {
            this.afA.setData(originalThreadInfo.item, 17);
        }
        if (this.kQg != null) {
            this.kQg.F(this.kPZ);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kQg != null) {
            this.kQg.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.aeU != null) {
                        e.this.aeU.a(e.this.kPZ);
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
            if (this.kQg != null) {
                this.kQg.onChangeSkinType(tbPageContext, i);
            }
            if (this.afA != null) {
                this.afA.onChangeSkinType();
            }
        }
    }
}
