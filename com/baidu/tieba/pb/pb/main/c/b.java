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
/* loaded from: classes7.dex */
public class b extends a {
    private int iFj;
    private com.baidu.tbadk.core.data.a iRA;
    private z iRB;
    private ah iRC;
    private bj iRD;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
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
        if (this.iRC == null) {
            this.iRC = new ah(this.cRe.getPageActivity());
        }
        this.mRootView.addView(this.iRC.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void f(OriginalThreadInfo originalThreadInfo) {
        this.iRz = originalThreadInfo;
        this.iRD = originalThreadInfo == null ? null : originalThreadInfo.ayG();
        this.iRA = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public bj axQ() {
                return b.this.iRD;
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
        if (this.iRC != null) {
            this.iRC.A(this.iRA);
        }
        if (this.iRB != null) {
            this.iRB.A(this.iRA);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.iRC != null) {
            this.iRC.setOnCardSubClickListener(this.iRy);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iRC != null) {
            this.iRC.a(aVar);
        }
        if (this.iRB != null) {
            this.iRB.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.JF != null) {
                        b.this.JF.a(b.this.iRA);
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
            if (this.iRC != null) {
                this.iRC.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
