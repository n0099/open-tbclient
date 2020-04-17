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
    private com.baidu.tbadk.core.data.a jET;
    private bj jEW;
    private l jFa;
    private int jsJ;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jsJ = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.jFa == null) {
            this.jFa = new l(this.duG.getPageActivity());
            this.jFa.b((Boolean) true);
            this.jFa.setFrom("pb");
            this.jFa.e(this.duG.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.duG.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.duG.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.duG.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.jFa.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jES = originalThreadInfo;
        this.jEW = originalThreadInfo == null ? null : originalThreadInfo.aJm();
        this.jET = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aIw() {
                return e.this.jEW;
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
        if (this.jFa != null) {
            this.jFa.A(this.jET);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
        if (this.jFa != null) {
            this.jFa.setOnCardSubClickListener(this.jER);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.jFa != null) {
            this.jFa.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.acY != null) {
                        e.this.acY.a(e.this.jET);
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
            if (this.jFa != null) {
                this.jFa.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
