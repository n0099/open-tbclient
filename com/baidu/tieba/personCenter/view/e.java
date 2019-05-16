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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bNG;
    private LinearLayout ieM;
    private AutoBannerView ieN;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bNG = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void B(int i, String str) {
                if (e.this.ieN != null && str != null) {
                    if (e.this.ieN.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").P("obj_locate", i).bT("obj_param1", str));
                    }
                    e.this.ieN.aki();
                    e.this.ieN.xv(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.ieN != null && aVar != null && aVar.bYm() != null && e.this.ieN.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_locate", i).bT("obj_param1", aVar.bYm()));
                }
            }
        };
        View view = getView();
        this.ieM = (LinearLayout) view.findViewById(R.id.viewpager);
        this.ieN = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.ieN.setMarqueenTime(3000L);
        this.ieN.getCoverFlowView().setCallback(this.bNG);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.ieN != null) {
                this.ieN.onChangeSkinType(i);
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
        if (this.ieM != null && mVar != null && mVar.idE != null && this.ieN != null && mVar.idE.size() != 0) {
            this.ieN.cC(mVar.idE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.ieN != null) {
            this.ieN.aki();
        }
    }
}
