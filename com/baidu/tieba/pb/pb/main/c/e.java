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
    private ItemCardView agm;
    private AbsThreadDataSupport lnW;
    private bw lnZ;
    private af loe;
    private LinearLayout mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.etO.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.loe == null) {
            this.loe = new af(this.etO);
            this.loe.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.loe.getView(), layoutParams);
        if (this.agm == null) {
            this.agm = new ItemCardView(this.etO.getPageActivity());
        }
        this.agm.setBackGroundColor(R.color.cp_bg_line_e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        layoutParams2.leftMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.rightMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams2.bottomMargin = this.etO.getResources().getDimensionPixelOffset(R.dimen.tbds42);
        this.mRootView.addView(this.agm, layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lnV = originalThreadInfo;
        this.lnZ = originalThreadInfo == null ? null : originalThreadInfo.bgI();
        this.lnW = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bfG() {
                return e.this.lnZ;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bfI() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.agm != null && originalThreadInfo != null) {
            this.agm.setData(originalThreadInfo.item, 17);
        }
        if (this.loe != null) {
            this.loe.H(this.lnW);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.loe != null) {
            this.loe.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.afF != null) {
                        e.this.afF.a(e.this.lnW);
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
            if (this.loe != null) {
                this.loe.onChangeSkinType(tbPageContext, i);
            }
            if (this.agm != null) {
                this.agm.onChangeSkinType();
            }
        }
    }
}
