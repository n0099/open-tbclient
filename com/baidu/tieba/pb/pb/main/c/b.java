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
/* loaded from: classes6.dex */
public class b extends a {
    private int iBF;
    private com.baidu.tbadk.core.data.a iNW;
    private z iNX;
    private ah iNY;
    private bj iNZ;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iBF = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.cQU.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.iNX == null) {
            this.iNX = new z(this.cQU);
            this.iNX.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.cQU.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.cQU.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.cQU.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.iNX.getView(), layoutParams);
        if (this.iNY == null) {
            this.iNY = new ah(this.cQU.getPageActivity());
        }
        this.mRootView.addView(this.iNY.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void f(OriginalThreadInfo originalThreadInfo) {
        this.iNV = originalThreadInfo;
        this.iNZ = originalThreadInfo == null ? null : originalThreadInfo.ayn();
        this.iNW = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public bj axx() {
                return b.this.iNZ;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al axz() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.iNY != null) {
            this.iNY.A(this.iNW);
        }
        if (this.iNX != null) {
            this.iNX.A(this.iNW);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.iNY != null) {
            this.iNY.setOnCardSubClickListener(this.iNU);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iNY != null) {
            this.iNY.a(aVar);
        }
        if (this.iNX != null) {
            this.iNX.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.Jz != null) {
                        b.this.Jz.a(b.this.iNW);
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
            if (this.iNX != null) {
                this.iNX.onChangeSkinType(tbPageContext, i);
            }
            if (this.iNY != null) {
                this.iNY.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
