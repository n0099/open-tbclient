package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<i> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bGd;
    private LinearLayout hMF;
    private AutoBannerView hMG;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGd = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void y(int i, String str) {
                if (d.this.hMG != null && str != null) {
                    if (d.this.hMG.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").T("obj_locate", i).bJ("obj_param1", str));
                    }
                    d.this.hMG.afm();
                    d.this.hMG.wh(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.hMG != null && aVar != null && aVar.bQx() != null && d.this.hMG.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_locate", i).bJ("obj_param1", aVar.bQx()));
                }
            }
        };
        this.hMF = (LinearLayout) getView().findViewById(d.g.viewpager);
        this.hMG = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.hMG.setMarqueenTime(3000L);
        this.hMG.getCoverFlowView().setCallback(this.bGd);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.hMG != null) {
                this.hMG.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(i iVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.hMF != null && iVar != null && iVar.hLO != null && this.hMG != null && this.hMF.getChildCount() != 1 && iVar.hLO.size() != 0) {
            this.hMG.cx(iVar.hLO);
            this.hMF.addView(this.hMG);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.hMG != null) {
            this.hMG.afm();
        }
    }
}
