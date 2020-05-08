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
    private com.baidu.tbadk.core.data.a jEX;
    private z jEY;
    private bj jFa;
    private ak jFg;
    private int jsN;
    private LinearLayout mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jsN = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.duK.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.jEY == null) {
            this.jEY = new z(this.duK);
            this.jEY.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.duK.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.duK.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.duK.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.jEY.getView(), layoutParams);
        if (this.jFg == null) {
            this.jFg = new ak(this.duK.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.duK.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.jFg.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jEW = originalThreadInfo;
        this.jFa = originalThreadInfo == null ? null : originalThreadInfo.aJk();
        this.jEX = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aIu() {
                return f.this.jFa;
            }

            @Override // com.baidu.tbadk.core.data.a
            public al aIw() {
                return null;
            }

            @Override // com.baidu.adp.widget.ListView.m
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.jFg != null) {
            this.jFg.B(this.jEX);
        }
        if (this.jEY != null) {
            this.jEY.B(this.jEX);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.z zVar) {
        super.a(zVar);
        if (this.jFg != null) {
            this.jFg.setOnCardSubClickListener(this.jEV);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.jFg != null) {
            this.jFg.a(aVar);
        }
        if (this.jEY != null) {
            this.jEY.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.adb != null) {
                        f.this.adb.a(f.this.jEX);
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
            if (this.jEY != null) {
                this.jEY.onChangeSkinType(tbPageContext, i);
            }
            if (this.jFg != null) {
                this.jFg.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
