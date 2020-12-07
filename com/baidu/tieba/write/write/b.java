package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.d.e lOT;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lOT != null) {
            this.lOT.UG();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.lOT == null) {
                this.lOT = new com.baidu.tieba.d.e(this.mPageContext, view);
                this.lOT.fO(R.drawable.pic_sign_tip_down);
                this.lOT.yu(1);
                this.lOT.fN(32);
                this.lOT.setAnchor(2);
                this.lOT.pe(false);
                this.lOT.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        b.this.hideTip();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds50);
                int dimensionPixelSize5 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6);
                this.lOT.F(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.lOT.yt(-dimensionPixelSize4);
                this.lOT.setYOffset(-dimensionPixelSize5);
                this.lOT.fP(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.lOT.yv(R.drawable.icon_pure_guide_haowu16);
            this.lOT.ph(true);
            this.lOT.aP(string, "commodity_tip_show_controller");
        }
    }
}
