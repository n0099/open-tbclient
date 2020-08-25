package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> egC;
    private LinearLayout lgl;
    private AutoBannerView lgm;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.egC = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                if (e.this.lgm != null && str != null) {
                    if (e.this.lgm.checkIndex(i)) {
                        TiebaStatic.log(new aq("c13247").ai("obj_locate", i).dD("obj_param1", str));
                    }
                    e.this.lgm.blP();
                    e.this.lgm.di(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.lgm != null && aVar != null && aVar.bcB() != null && e.this.lgm.checkIndex(i)) {
                    TiebaStatic.log(new aq("c13246").dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_locate", i).dD("obj_param1", aVar.bcB()));
                }
            }
        };
        View view = getView();
        this.lgl = (LinearLayout) view.findViewById(R.id.viewpager);
        this.lgm = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.lgm.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.lgm.getCoverFlowView().setCallback(this.egC);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.lgm != null) {
                this.lgm.onChangeSkinType(i);
            }
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(n nVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.lgl != null && nVar != null && nVar.leS != null && this.lgm != null && nVar.leS.size() != 0) {
            this.lgm.r(nVar.leS);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.lgm != null) {
            this.lgm.blP();
        }
    }
}
