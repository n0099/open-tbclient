package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> eUQ;
    private int mSkinType;
    private LinearLayout mlX;
    private AutoBannerView mlY;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eUQ = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                if (e.this.mlY != null && str != null) {
                    if (e.this.mlY.checkIndex(i)) {
                        TiebaStatic.log(new aq("c13247").an("obj_locate", i).dW("obj_param1", str));
                    }
                    e.this.mlY.bvc();
                    e.this.mlY.de(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.mlY != null && aVar != null && aVar.bls() != null && e.this.mlY.checkIndex(i)) {
                    TiebaStatic.log(new aq("c13246").dW("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_locate", i).dW("obj_param1", aVar.bls()));
                }
            }
        };
        View view = getView();
        this.mlX = (LinearLayout) view.findViewById(R.id.viewpager);
        this.mlY = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.mlY.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.mlY.getCoverFlowView().setCallback(this.eUQ);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.mlY != null) {
                this.mlY.onChangeSkinType(i);
            }
            ao.setBackgroundColor(getView(), R.color.CAM_X0205);
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
        if (this.mlX != null && nVar != null && nVar.mkF != null && this.mlY != null && nVar.mkF.size() != 0) {
            this.mlY.r(nVar.mkF);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.mlY != null) {
            this.mlY.bvc();
        }
    }
}
