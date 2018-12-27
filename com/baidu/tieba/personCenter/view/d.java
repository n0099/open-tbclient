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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> axG;
    private LinearLayout gvq;
    private AutoBannerView gvr;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.axG = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void g(int i, String str) {
                if (d.this.gvr != null && str != null) {
                    if (d.this.gvr.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").x("obj_locate", i).aA("obj_param1", str));
                    }
                    d.this.gvr.FF();
                    d.this.gvr.oU(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.gvr != null && aVar != null && aVar.aJh() != null && d.this.gvr.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").aA("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_locate", i).aA("obj_param1", aVar.aJh()));
                }
            }
        };
        this.gvq = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.gvr = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.gvr.setMarqueenTime(3000L);
        this.gvr.getCoverFlowView().setCallback(this.axG);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.gvr != null) {
                this.gvr.onChangeSkinType(i);
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
        if (this.gvq != null && iVar != null && iVar.guy != null && this.gvr != null && this.gvq.getChildCount() != 1 && iVar.guy.size() != 0) {
            this.gvr.bW(iVar.guy);
            this.gvq.addView(this.gvr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.gvr != null) {
            this.gvr.FF();
        }
    }
}
