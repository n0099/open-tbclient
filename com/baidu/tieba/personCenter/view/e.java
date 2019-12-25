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
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> cRZ;
    private LinearLayout jdY;
    private AutoBannerView jdZ;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cRZ = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void M(int i, String str) {
                if (e.this.jdZ != null && str != null) {
                    if (e.this.jdZ.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").Z("obj_locate", i).cp("obj_param1", str));
                    }
                    e.this.jdZ.aFQ();
                    e.this.jdZ.Gi(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.jdZ != null && aVar != null && aVar.csD() != null && e.this.jdZ.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("obj_locate", i).cp("obj_param1", aVar.csD()));
                }
            }
        };
        View view = getView();
        this.jdY = (LinearLayout) view.findViewById(R.id.viewpager);
        this.jdZ = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.jdZ.setMarqueenTime(3000L);
        this.jdZ.getCoverFlowView().setCallback(this.cRZ);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.jdZ != null) {
                this.jdZ.onChangeSkinType(i);
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
        if (this.jdY != null && mVar != null && mVar.jcM != null && this.jdZ != null && mVar.jcM.size() != 0) {
            this.jdZ.dS(mVar.jcM);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.jdZ != null) {
            this.jdZ.aFQ();
        }
    }
}
