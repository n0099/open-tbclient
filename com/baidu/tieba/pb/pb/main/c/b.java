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
    private com.baidu.tbadk.core.data.a jET;
    private z jEU;
    private ah jEV;
    private bj jEW;
    private int jsJ;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jsJ = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.duG.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.jEU == null) {
            this.jEU = new z(this.duG);
            this.jEU.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.duG.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.duG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.duG.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.jEU.getView(), layoutParams);
        if (this.jEV == null) {
            this.jEV = new ah(this.duG.getPageActivity());
        }
        this.mRootView.addView(this.jEV.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jES = originalThreadInfo;
        this.jEW = originalThreadInfo == null ? null : originalThreadInfo.aJm();
        this.jET = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aIw() {
                return b.this.jEW;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al aIy() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.jEV != null) {
            this.jEV.A(this.jET);
        }
        if (this.jEU != null) {
            this.jEU.A(this.jET);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.jEV != null) {
            this.jEV.setOnCardSubClickListener(this.jER);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.jEV != null) {
            this.jEV.a(aVar);
        }
        if (this.jEU != null) {
            this.jEU.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.acY != null) {
                        b.this.acY.a(b.this.jET);
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
            if (this.jEU != null) {
                this.jEU.onChangeSkinType(tbPageContext, i);
            }
            if (this.jEV != null) {
                this.jEV.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
