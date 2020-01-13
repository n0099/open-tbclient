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
/* loaded from: classes7.dex */
public class f extends a {
    private int iFj;
    private com.baidu.tbadk.core.data.a iRA;
    private z iRB;
    private bj iRD;
    private ak iRJ;
    private LinearLayout mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iFj = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.cRe.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.iRB == null) {
            this.iRB = new z(this.cRe);
            this.iRB.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.cRe.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.cRe.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.cRe.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.iRB.getView(), layoutParams);
        if (this.iRJ == null) {
            this.iRJ = new ak(this.cRe.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.cRe.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.iRJ.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void f(OriginalThreadInfo originalThreadInfo) {
        this.iRz = originalThreadInfo;
        this.iRD = originalThreadInfo == null ? null : originalThreadInfo.ayG();
        this.iRA = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public bj axQ() {
                return f.this.iRD;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al axS() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.iRJ != null) {
            this.iRJ.A(this.iRA);
        }
        if (this.iRB != null) {
            this.iRB.A(this.iRA);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.iRJ != null) {
            this.iRJ.setOnCardSubClickListener(this.iRy);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iRJ != null) {
            this.iRJ.a(aVar);
        }
        if (this.iRB != null) {
            this.iRB.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.JF != null) {
                        f.this.JF.a(f.this.iRA);
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
            if (this.iRB != null) {
                this.iRB.onChangeSkinType(tbPageContext, i);
            }
            if (this.iRJ != null) {
                this.iRJ.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
