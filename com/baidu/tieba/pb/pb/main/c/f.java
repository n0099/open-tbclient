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
    private int iIC;
    private com.baidu.tbadk.core.data.a iUK;
    private z iUL;
    private bj iUN;
    private ak iUT;
    private LinearLayout mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iIC = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.cVv.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.iUL == null) {
            this.iUL = new z(this.cVv);
            this.iUL.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.cVv.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.cVv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.cVv.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.iUL.getView(), layoutParams);
        if (this.iUT == null) {
            this.iUT = new ak(this.cVv.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.cVv.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.iUT.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iUJ = originalThreadInfo;
        this.iUN = originalThreadInfo == null ? null : originalThreadInfo.aAZ();
        this.iUK = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aAj() {
                return f.this.iUN;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al aAl() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.iUT != null) {
            this.iUT.A(this.iUK);
        }
        if (this.iUL != null) {
            this.iUL.A(this.iUK);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.iUT != null) {
            this.iUT.setOnCardSubClickListener(this.iUI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iUT != null) {
            this.iUT.a(aVar);
        }
        if (this.iUL != null) {
            this.iUL.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.Ka != null) {
                        f.this.Ka.a(f.this.iUK);
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
            if (this.iUL != null) {
                this.iUL.onChangeSkinType(tbPageContext, i);
            }
            if (this.iUT != null) {
                this.iUT.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
