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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bPo;
    private LinearLayout iol;
    private AutoBannerView iom;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bPo = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void B(int i, String str) {
                if (e.this.iom != null && str != null) {
                    if (e.this.iom.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").P("obj_locate", i).bT("obj_param1", str));
                    }
                    e.this.iom.alB();
                    e.this.iom.yC(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.iom != null && aVar != null && aVar.ccl() != null && e.this.iom.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_locate", i).bT("obj_param1", aVar.ccl()));
                }
            }
        };
        View view = getView();
        this.iol = (LinearLayout) view.findViewById(R.id.viewpager);
        this.iom = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.iom.setMarqueenTime(3000L);
        this.iom.getCoverFlowView().setCallback(this.bPo);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.iom != null) {
                this.iom.onChangeSkinType(i);
            }
            am.l(getView(), R.color.cp_bg_line_e);
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
        if (this.iol != null && mVar != null && mVar.imZ != null && this.iom != null && mVar.imZ.size() != 0) {
            this.iom.cC(mVar.imZ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.iom != null) {
            this.iom.alB();
        }
    }
}
