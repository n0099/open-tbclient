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
/* loaded from: classes9.dex */
public class e extends a {
    private int iIC;
    private com.baidu.tbadk.core.data.a iUK;
    private bj iUN;
    private l iUR;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.iIC = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.iUR == null) {
            this.iUR = new l(this.cVv.getPageActivity());
            this.iUR.b((Boolean) true);
            this.iUR.setFrom("pb");
            this.iUR.e(this.cVv.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cVv.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.cVv.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.cVv.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.iUR.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.iUJ = originalThreadInfo;
        this.iUN = originalThreadInfo == null ? null : originalThreadInfo.aAZ();
        this.iUK = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aAj() {
                return e.this.iUN;
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
        if (this.iUR != null) {
            this.iUR.A(this.iUK);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
        if (this.iUR != null) {
            this.iUR.setOnCardSubClickListener(this.iUI);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.iUR != null) {
            this.iUR.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.Ka != null) {
                        e.this.Ka.a(e.this.iUK);
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
            if (this.iUR != null) {
                this.iUR.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
