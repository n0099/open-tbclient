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
    private com.baidu.tbadk.core.data.a jEX;
    private bj jFa;
    private l jFe;
    private int jsN;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jsN = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.jFe == null) {
            this.jFe = new l(this.duK.getPageActivity());
            this.jFe.b((Boolean) true);
            this.jFe.setFrom("pb");
            this.jFe.e(this.duK.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.duK.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.duK.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.duK.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.jFe.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jEW = originalThreadInfo;
        this.jFa = originalThreadInfo == null ? null : originalThreadInfo.aJk();
        this.jEX = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bj aIu() {
                return e.this.jFa;
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
        if (this.jFe != null) {
            this.jFe.B(this.jEX);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
        if (this.jFe != null) {
            this.jFe.setOnCardSubClickListener(this.jEV);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.jFe != null) {
            this.jFe.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.adb != null) {
                        e.this.adb.a(e.this.jEX);
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
            if (this.jFe != null) {
                this.jFe.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
