package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ah;
import com.baidu.card.b;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends a {
    private int iGP;
    private com.baidu.tbadk.core.data.a iSX;
    private z iSY;
    private ah iSZ;
    private bj iTa;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iGP = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.cVh.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.iSY == null) {
            this.iSY = new z(this.cVh);
            this.iSY.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.cVh.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.cVh.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.cVh.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.iSY.getView(), layoutParams);
        if (this.iSZ == null) {
            this.iSZ = new ah(this.cVh.getPageActivity());
        }
        this.mRootView.addView(this.iSZ.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iSW = originalThreadInfo;
        this.iTa = originalThreadInfo == null ? null : originalThreadInfo.aAW();
        this.iSX = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aAg() {
                return b.this.iTa;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al aAi() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.iSZ != null) {
            this.iSZ.A(this.iSX);
        }
        if (this.iSY != null) {
            this.iSY.A(this.iSX);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.iSZ != null) {
            this.iSZ.setOnCardSubClickListener(this.iSV);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iSZ != null) {
            this.iSZ.a(aVar);
        }
        if (this.iSY != null) {
            this.iSY.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.Ka != null) {
                        b.this.Ka.a(b.this.iSX);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.iSY != null) {
                this.iSY.onChangeSkinType(tbPageContext, i);
            }
            if (this.iSZ != null) {
                this.iSZ.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
