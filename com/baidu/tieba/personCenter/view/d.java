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
    private LinearLayout gkk;
    private AutoBannerView gkl;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ats = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (d.this.gkl != null && str != null) {
                    if (d.this.gkl.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").x("obj_locate", i).ax("obj_param1", str));
                    }
                    d.this.gkl.Eq();
                    d.this.gkl.or(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.gkl != null && aVar != null && aVar.aHi() != null && d.this.gkl.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").ax("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_locate", i).ax("obj_param1", aVar.aHi()));
                }
            }
        };
        this.gkk = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.gkl = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.gkl.setMarqueenTime(3000L);
        this.gkl.getCoverFlowView().setCallback(this.ats);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.gkl != null) {
                this.gkl.onChangeSkinType(i);
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
        if (this.gkk != null && iVar != null && iVar.gjs != null && this.gkl != null && this.gkk.getChildCount() != 1 && iVar.gjs.size() != 0) {
            this.gkl.bV(iVar.gjs);
            this.gkk.addView(this.gkl);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.gkl != null) {
            this.gkl.Eq();
        }
    }
}
