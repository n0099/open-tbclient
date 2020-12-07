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
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> ePC;
    private int mSkinType;
    private LinearLayout mls;
    private AutoBannerView mlt;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ePC = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                if (e.this.mlt != null && str != null) {
                    if (e.this.mlt.checkIndex(i)) {
                        TiebaStatic.log(new ar("c13247").al("obj_locate", i).dY("obj_param1", str));
                    }
                    e.this.mlt.bwC();
                    e.this.mlt.dq(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.mlt != null && aVar != null && aVar.bmM() != null && e.this.mlt.checkIndex(i)) {
                    TiebaStatic.log(new ar("c13246").dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_locate", i).dY("obj_param1", aVar.bmM()));
                }
            }
        };
        View view = getView();
        this.mls = (LinearLayout) view.findViewById(R.id.viewpager);
        this.mlt = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.mlt.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.mlt.getCoverFlowView().setCallback(this.ePC);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.mlt != null) {
                this.mlt.onChangeSkinType(i);
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
        if (this.mls != null && nVar != null && nVar.mka != null && this.mlt != null && nVar.mka.size() != 0) {
            this.mlt.r(nVar.mka);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.mlt != null) {
            this.mlt.bwC();
        }
    }
}
