package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.m;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.a<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> dvL;
    private LinearLayout jUA;
    private AutoBannerView jUB;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dvL = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void ah(int i, String str) {
                if (e.this.jUB != null && str != null) {
                    if (e.this.jUB.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").af("obj_locate", i).cI("obj_param1", str));
                    }
                    e.this.jUB.aRb();
                    e.this.jUB.Io(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.jUB != null && aVar != null && aVar.cGl() != null && e.this.jUB.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_locate", i).cI("obj_param1", aVar.cGl()));
                }
            }
        };
        View view = getView();
        this.jUA = (LinearLayout) view.findViewById(R.id.viewpager);
        this.jUB = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.jUB.setMarqueenTime(3000L);
        this.jUB.getCoverFlowView().setCallback(this.dvL);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.jUB != null) {
                this.jUB.onChangeSkinType(i);
            }
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(m mVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.jUA != null && mVar != null && mVar.jTm != null && this.jUB != null && mVar.jTm.size() != 0) {
            this.jUB.dZ(mVar.jTm);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.jUB != null) {
            this.jUB.aRb();
        }
    }
}
