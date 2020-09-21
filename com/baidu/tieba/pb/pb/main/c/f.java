package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class f extends a {
    private int kLm;
    private AbsThreadDataSupport kYI;
    private bw kYL;
    private o kYR;
    private View mRootView;

    public f(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.kLm = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.kYR == null) {
            this.kYR = new o(this.ehG.getPageActivity());
            this.kYR.b((Boolean) true);
            this.kYR.setFrom("pb");
            this.kYR.setFromForPb(0);
            this.kYR.e(this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.ehG.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.ehG.getResources().getDimensionPixelSize(R.dimen.tbds40));
            this.kYR.aH(false);
        }
        this.mRootView = this.kYR.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.kYH = originalThreadInfo;
        this.kYL = originalThreadInfo == null ? null : originalThreadInfo.bdZ();
        this.kYI = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bw bcY() {
                return f.this.kYL;
            }

            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public ar bda() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.kYR != null) {
            this.kYR.G(this.kYI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.kYR != null) {
            this.kYR.setOnCardSubClickListener(this.kYG);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.kYR != null) {
            this.kYR.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.afo != null) {
                        f.this.afo.a(f.this.kYI);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.kYR != null) {
                this.kYR.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
