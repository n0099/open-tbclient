package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ae;
import com.baidu.card.an;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class b extends a {
    private int kCH;
    private AbsThreadDataSupport kPZ;
    private ae kQa;
    private an kQb;
    private bw kQc;
    private LinearLayout mRootView;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kCH = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.efn.getPageActivity());
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.kQa == null) {
            this.kQa = new ae(this.efn);
            this.kQa.b((Boolean) true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds39);
        layoutParams.leftMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        layoutParams.rightMargin = this.efn.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        this.mRootView.addView(this.kQa.getView(), layoutParams);
        if (this.kQb == null) {
            this.kQb = new an(this.efn.getPageActivity());
        }
        this.mRootView.addView(this.kQb.getView());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kPY = originalThreadInfo;
        this.kQc = originalThreadInfo == null ? null : originalThreadInfo.bdf();
        this.kPZ = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.b.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bce() {
                return b.this.kQc;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bcg() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.kQb != null) {
            this.kQb.F(this.kPZ);
        }
        if (this.kQa != null) {
            this.kQa.F(this.kPZ);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kQb != null) {
            this.kQb.setOnCardSubClickListener(this.kPX);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kQb != null) {
            this.kQb.a(aVar);
        }
        if (this.kQa != null) {
            this.kQa.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.aeU != null) {
                        b.this.aeU.a(b.this.kPZ);
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
            if (this.kQa != null) {
                this.kQa.onChangeSkinType(tbPageContext, i);
            }
            if (this.kQb != null) {
                this.kQb.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
