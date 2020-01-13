package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes7.dex */
public class e extends a {
    private int iFj;
    private com.baidu.tbadk.core.data.a iRA;
    private bj iRD;
    private l iRH;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iFj = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iRH == null) {
            this.iRH = new l(this.cRe.getPageActivity());
            this.iRH.b((Boolean) true);
            this.iRH.setFrom("pb");
            this.iRH.e(this.cRe.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cRe.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.cRe.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cRe.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.iRH.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void f(OriginalThreadInfo originalThreadInfo) {
        this.iRz = originalThreadInfo;
        this.iRD = originalThreadInfo == null ? null : originalThreadInfo.ayG();
        this.iRA = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bj axQ() {
                return e.this.iRD;
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
        if (this.iRH != null) {
            this.iRH.A(this.iRA);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
        if (this.iRH != null) {
            this.iRH.setOnCardSubClickListener(this.iRy);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iRH != null) {
            this.iRH.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.JF != null) {
                        e.this.JF.a(e.this.iRA);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            if (this.iRH != null) {
                this.iRH.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
