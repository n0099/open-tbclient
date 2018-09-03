package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.a<i> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> alV;
    private LinearLayout fVs;
    private AutoBannerView fVt;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.alV = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (d.this.fVt != null && str != null) {
                    if (d.this.fVt.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").r("obj_locate", i).ae("obj_param1", str));
                    }
                    d.this.fVt.AZ();
                    d.this.fVt.ni(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.fVt != null && aVar != null && aVar.aBD() != null && d.this.fVt.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").ae("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i).ae("obj_param1", aVar.aBD()));
                }
            }
        };
        this.fVs = (LinearLayout) getView().findViewById(f.g.viewpager);
        this.fVt = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.fVt.setMarqueenTime(3000L);
        this.fVt.getCoverFlowView().setCallback(this.alV);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.fVt != null) {
                this.fVt.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(i iVar) {
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.fVs != null && iVar != null && iVar.fUz != null && this.fVt != null && this.fVs.getChildCount() != 1 && iVar.fUz.size() != 0) {
            this.fVt.bE(iVar.fUz);
            this.fVs.addView(this.fVt);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.fVt != null) {
            this.fVt.AZ();
        }
    }
}
