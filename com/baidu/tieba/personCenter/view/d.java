package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes5.dex */
public class d extends com.baidu.tieba.card.a<i> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> ats;
    private LinearLayout gkj;
    private AutoBannerView gkk;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ats = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (d.this.gkk != null && str != null) {
                    if (d.this.gkk.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").x("obj_locate", i).ax("obj_param1", str));
                    }
                    d.this.gkk.Eq();
                    d.this.gkk.or(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.gkk != null && aVar != null && aVar.aHi() != null && d.this.gkk.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").ax("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_locate", i).ax("obj_param1", aVar.aHi()));
                }
            }
        };
        this.gkj = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.gkk = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.gkk.setMarqueenTime(3000L);
        this.gkk.getCoverFlowView().setCallback(this.ats);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.gkk != null) {
                this.gkk.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(i iVar) {
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.gkj != null && iVar != null && iVar.gjr != null && this.gkk != null && this.gkj.getChildCount() != 1 && iVar.gjr.size() != 0) {
            this.gkk.bV(iVar.gjr);
            this.gkj.addView(this.gkk);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.gkk != null) {
            this.gkk.Eq();
        }
    }
}
