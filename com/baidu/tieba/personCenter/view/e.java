package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.m;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> cgr;
    private LinearLayout imV;
    private AutoBannerView imW;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cgr = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void F(int i, String str) {
                if (e.this.imW != null && str != null) {
                    if (e.this.imW.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").O("obj_locate", i).bS("obj_param1", str));
                    }
                    e.this.imW.aop();
                    e.this.imW.wV(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.imW != null && aVar != null && aVar.bZn() != null && e.this.imW.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").bS("uid", TbadkCoreApplication.getCurrentAccount()).O("obj_locate", i).bS("obj_param1", aVar.bZn()));
                }
            }
        };
        View view = getView();
        this.imV = (LinearLayout) view.findViewById(R.id.viewpager);
        this.imW = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.imW.setMarqueenTime(3000L);
        this.imW.getCoverFlowView().setCallback(this.cgr);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.imW != null) {
                this.imW.onChangeSkinType(i);
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
        if (this.imV != null && mVar != null && mVar.ilI != null && this.imW != null && mVar.ilI.size() != 0) {
            this.imW.cP(mVar.ilI);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.imW != null) {
            this.imW.aop();
        }
    }
}
