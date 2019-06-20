package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.m;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bNH;
    private LinearLayout ieQ;
    private AutoBannerView ieR;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bNH = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void B(int i, String str) {
                if (e.this.ieR != null && str != null) {
                    if (e.this.ieR.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").P("obj_locate", i).bT("obj_param1", str));
                    }
                    e.this.ieR.aki();
                    e.this.ieR.xx(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.ieR != null && aVar != null && aVar.bYq() != null && e.this.ieR.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_locate", i).bT("obj_param1", aVar.bYq()));
                }
            }
        };
        View view = getView();
        this.ieQ = (LinearLayout) view.findViewById(R.id.viewpager);
        this.ieR = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.ieR.setMarqueenTime(3000L);
        this.ieR.getCoverFlowView().setCallback(this.bNH);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.ieR != null) {
                this.ieR.onChangeSkinType(i);
            }
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
        if (this.ieQ != null && mVar != null && mVar.idI != null && this.ieR != null && mVar.idI.size() != 0) {
            this.ieR.cC(mVar.idI);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.ieR != null) {
            this.ieR.aki();
        }
    }
}
