package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.aa;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends a {
    private int jJK;
    private bk jWB;
    private al jWH;
    private AbsThreadDataSupport jWy;
    private aa jWz;
    private LinearLayout mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jJK = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.dIF.getPageActivity());
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.jWz == null) {
            this.jWz = new aa(this.dIF);
            this.jWz.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.jWz.getView(), layoutParams);
        if (this.jWH == null) {
            this.jWH = new al(this.dIF.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds22);
        this.mRootView.addView(this.jWH.getView(), layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jWx = originalThreadInfo;
        this.jWB = originalThreadInfo == null ? null : originalThreadInfo.aPf();
        this.jWy = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bk aOi() {
                return f.this.jWB;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ak aOk() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.jWH != null) {
            this.jWH.D(this.jWy);
        }
        if (this.jWz != null) {
            this.jWz.D(this.jWy);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(com.baidu.tieba.card.aa aaVar) {
        super.a(aaVar);
        if (this.jWH != null) {
            this.jWH.setOnCardSubClickListener(this.jWw);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.jWH != null) {
            this.jWH.a(aVar);
        }
        if (this.jWz != null) {
            this.jWz.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.adu != null) {
                        f.this.adu.a(f.this.jWy);
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
            if (this.jWz != null) {
                this.jWz.onChangeSkinType(tbPageContext, i);
            }
            if (this.jWH != null) {
                this.jWH.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
