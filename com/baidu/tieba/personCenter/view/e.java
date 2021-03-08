package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> eYF;
    private int mSkinType;
    private LinearLayout mxp;
    private AutoBannerView mxq;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eYF = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                if (e.this.mxq != null && str != null) {
                    if (e.this.mxq.checkIndex(i)) {
                        TiebaStatic.log(new ar("c13247").aq("obj_locate", i).dR("obj_param1", str));
                    }
                    e.this.mxq.bvz();
                    e.this.mxq.di(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.mxq != null && aVar != null && aVar.blM() != null && e.this.mxq.checkIndex(i)) {
                    TiebaStatic.log(new ar("c13246").dR("uid", TbadkCoreApplication.getCurrentAccount()).aq("obj_locate", i).dR("obj_param1", aVar.blM()));
                }
            }
        };
        View view = getView();
        this.mxp = (LinearLayout) view.findViewById(R.id.viewpager);
        this.mxq = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.mxq.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.mxq.getCoverFlowView().setCallback(this.eYF);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.mxq != null) {
                this.mxq.onChangeSkinType(i);
            }
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
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
        if (this.mxp != null && nVar != null && nVar.mvY != null && this.mxq != null && nVar.mvY.size() != 0) {
            this.mxq.r(nVar.mvY);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.mxq != null) {
            this.mxq.bvz();
        }
    }
}
