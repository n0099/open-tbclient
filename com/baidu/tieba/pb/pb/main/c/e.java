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
/* loaded from: classes6.dex */
public class e extends a {
    private int iBF;
    private com.baidu.tbadk.core.data.a iNW;
    private bj iNZ;
    private l iOd;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iBF = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iOd == null) {
            this.iOd = new l(this.cQU.getPageActivity());
            this.iOd.b((Boolean) true);
            this.iOd.setFrom("pb");
            this.iOd.e(this.cQU.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cQU.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.cQU.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cQU.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.iOd.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void f(OriginalThreadInfo originalThreadInfo) {
        this.iNV = originalThreadInfo;
        this.iNZ = originalThreadInfo == null ? null : originalThreadInfo.ayn();
        this.iNW = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bj axx() {
                return e.this.iNZ;
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
        if (this.iOd != null) {
            this.iOd.A(this.iNW);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
        if (this.iOd != null) {
            this.iOd.setOnCardSubClickListener(this.iNU);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iOd != null) {
            this.iOd.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.Jz != null) {
                        e.this.Jz.a(e.this.iNW);
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
            if (this.iOd != null) {
                this.iOd.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
