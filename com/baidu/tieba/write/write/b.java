package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b {
    private com.baidu.tieba.c.e eWa;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.eWa != null) {
            this.eWa.Tz();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.eWa == null) {
                this.eWa = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.eWa.en(R.drawable.pic_sign_tip_down);
                this.eWa.setLines(1);
                this.eWa.em(32);
                this.eWa.xh(2);
                this.eWa.pI(false);
                this.eWa.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.eWa.G(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.eWa.xl(-dimensionPixelSize4);
                this.eWa.setYOffset(-dimensionPixelSize5);
                this.eWa.eo(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.eWa.xm(R.drawable.icon_pure_guide_haowu16);
            this.eWa.pL(true);
            this.eWa.aJ(string, "commodity_tip_show_controller");
        }
    }
}
