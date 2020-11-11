package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.c.e lAO;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lAO != null) {
            this.lAO.SR();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.lAO == null) {
                this.lAO = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.lAO.fu(R.drawable.pic_sign_tip_down);
                this.lAO.xr(1);
                this.lAO.ft(32);
                this.lAO.setAnchor(2);
                this.lAO.oF(false);
                this.lAO.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.lAO.A(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.lAO.xq(-dimensionPixelSize4);
                this.lAO.setYOffset(-dimensionPixelSize5);
                this.lAO.fv(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.lAO.xs(R.drawable.icon_pure_guide_haowu16);
            this.lAO.oI(true);
            this.lAO.aM(string, "commodity_tip_show_controller");
        }
    }
}
