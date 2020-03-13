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
    private int iHb;
    private com.baidu.tbadk.core.data.a iTj;
    private z iTk;
    private ah iTl;
    private bj iTm;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iHb = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.cVi.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.iTk == null) {
            this.iTk = new z(this.cVi);
            this.iTk.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.cVi.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.cVi.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.cVi.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.iTk.getView(), layoutParams);
        if (this.iTl == null) {
            this.iTl = new ah(this.cVi.getPageActivity());
        }
        this.mRootView.addView(this.iTl.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iTi = originalThreadInfo;
        this.iTm = originalThreadInfo == null ? null : originalThreadInfo.aAW();
        this.iTj = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aAg() {
                return b.this.iTm;
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
        if (this.iTl != null) {
            this.iTl.A(this.iTj);
        }
        if (this.iTk != null) {
            this.iTk.A(this.iTj);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.iTl != null) {
            this.iTl.setOnCardSubClickListener(this.iTh);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iTl != null) {
            this.iTl.a(aVar);
        }
        if (this.iTk != null) {
            this.iTk.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.Ka != null) {
                        b.this.Ka.a(b.this.iTj);
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
            if (this.iTk != null) {
                this.iTk.onChangeSkinType(tbPageContext, i);
            }
            if (this.iTl != null) {
                this.iTl.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
