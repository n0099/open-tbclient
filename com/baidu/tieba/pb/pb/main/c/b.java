package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.af;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class b extends a {
    private AbsThreadDataSupport lGv;
    private af lGw;
    private ao lGx;
    private bw lGy;
    private int lsX;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.lsX = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eIc.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lGw == null) {
            this.lGw = new af(this.eIc);
            this.lGw.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.eIc.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.lGw.getView(), layoutParams);
        if (this.lGx == null) {
            this.lGx = new ao(this.eIc.getPageActivity());
        }
        this.mRootView.addView(this.lGx.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lGu = originalThreadInfo;
        this.lGy = originalThreadInfo == null ? null : originalThreadInfo.blb();
        this.lGv = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bjZ() {
                return b.this.lGy;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bkb() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.lGx != null) {
            this.lGx.H(this.lGv);
        }
        if (this.lGw != null) {
            this.lGw.H(this.lGv);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(ab abVar) {
        super.a(abVar);
        if (this.lGx != null) {
            this.lGx.setOnCardSubClickListener(this.lGt);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.lGx != null) {
            this.lGx.a(aVar);
        }
        if (this.lGw != null) {
            this.lGw.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.afG != null) {
                        b.this.afG.a(b.this.lGv);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            if (this.lGw != null) {
                this.lGw.onChangeSkinType(tbPageContext, i);
            }
            if (this.lGx != null) {
                this.lGx.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
