package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.b;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends a {
    private int iGN;
    private com.baidu.tbadk.core.data.a iSV;
    private z iSW;
    private bj iSY;
    private ak iTe;
    private LinearLayout mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iGN = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.cVg.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.iSW == null) {
            this.iSW = new z(this.cVg);
            this.iSW.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.cVg.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.cVg.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.cVg.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.iSW.getView(), layoutParams);
        if (this.iTe == null) {
            this.iTe = new ak(this.cVg.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.cVg.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.iTe.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iSU = originalThreadInfo;
        this.iSY = originalThreadInfo == null ? null : originalThreadInfo.aAU();
        this.iSV = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aAe() {
                return f.this.iSY;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al aAg() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.iTe != null) {
            this.iTe.A(this.iSV);
        }
        if (this.iSW != null) {
            this.iSW.A(this.iSV);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.iTe != null) {
            this.iTe.setOnCardSubClickListener(this.iST);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iTe != null) {
            this.iTe.a(aVar);
        }
        if (this.iSW != null) {
            this.iSW.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.Ka != null) {
                        f.this.Ka.a(f.this.iSV);
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
            if (this.iSW != null) {
                this.iSW.onChangeSkinType(tbPageContext, i);
            }
            if (this.iTe != null) {
                this.iTe.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
