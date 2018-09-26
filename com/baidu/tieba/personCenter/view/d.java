package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.a<i> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> aoA;
    private LinearLayout gcH;
    private AutoBannerView gcI;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aoA = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (d.this.gcI != null && str != null) {
                    if (d.this.gcI.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").w("obj_locate", i).al("obj_param1", str));
                    }
                    d.this.gcI.Cl();
                    d.this.gcI.nN(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.gcI != null && aVar != null && aVar.aDQ() != null && d.this.gcI.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").al("uid", TbadkCoreApplication.getCurrentAccount()).w("obj_locate", i).al("obj_param1", aVar.aDQ()));
                }
            }
        };
        this.gcH = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.gcI = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.gcI.setMarqueenTime(3000L);
        this.gcI.getCoverFlowView().setCallback(this.aoA);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.gcI != null) {
                this.gcI.onChangeSkinType(i);
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
        if (this.gcH != null && iVar != null && iVar.gbP != null && this.gcI != null && this.gcH.getChildCount() != 1 && iVar.gbP.size() != 0) {
            this.gcI.bF(iVar.gbP);
            this.gcH.addView(this.gcI);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.gcI != null) {
            this.gcI.Cl();
        }
    }
}
