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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> eXg;
    private int mSkinType;
    private LinearLayout mvn;
    private AutoBannerView mvo;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eXg = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                if (e.this.mvo != null && str != null) {
                    if (e.this.mvo.checkIndex(i)) {
                        TiebaStatic.log(new ar("c13247").ap("obj_locate", i).dR("obj_param1", str));
                    }
                    e.this.mvo.bvw();
                    e.this.mvo.de(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.mvo != null && aVar != null && aVar.blK() != null && e.this.mvo.checkIndex(i)) {
                    TiebaStatic.log(new ar("c13246").dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_locate", i).dR("obj_param1", aVar.blK()));
                }
            }
        };
        View view = getView();
        this.mvn = (LinearLayout) view.findViewById(R.id.viewpager);
        this.mvo = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.mvo.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.mvo.getCoverFlowView().setCallback(this.eXg);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.mvo != null) {
                this.mvo.onChangeSkinType(i);
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
        if (this.mvn != null && nVar != null && nVar.mtW != null && this.mvo != null && nVar.mtW.size() != 0) {
            this.mvo.r(nVar.mtW);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.mvo != null) {
            this.mvo.bvw();
        }
    }
}
