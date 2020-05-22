package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.b;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class e extends a {
    private int jJK;
    private bk jWB;
    private m jWF;
    private AbsThreadDataSupport jWy;
    private View mRootView;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.jJK = i;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.jWF == null) {
            this.jWF = new m(this.dIF.getPageActivity());
            this.jWF.b((Boolean) true);
            this.jWF.setFrom("pb");
            this.jWF.e(this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds39), this.dIF.getResources().getDimensionPixelOffset(R.dimen.tbds44), this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds40));
        }
        this.mRootView = this.jWF.getView();
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.jWx = originalThreadInfo;
        this.jWB = originalThreadInfo == null ? null : originalThreadInfo.aPf();
        this.jWy = new AbsThreadDataSupport() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
            public bk aOi() {
                return e.this.jWB;
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
        if (this.jWF != null) {
            this.jWF.D(this.jWy);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.jWF != null) {
            this.jWF.setOnCardSubClickListener(this.jWw);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
        if (this.jWF != null) {
            this.jWF.a(aVar);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.adu != null) {
                        e.this.adu.a(e.this.jWy);
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
            if (this.jWF != null) {
                this.jWF.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
