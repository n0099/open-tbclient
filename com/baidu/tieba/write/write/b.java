package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.c.e luR;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.luR != null) {
            this.luR.Qh();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.luR == null) {
                this.luR = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.luR.fh(R.drawable.pic_sign_tip_down);
                this.luR.xe(1);
                this.luR.fg(32);
                this.luR.setAnchor(2);
                this.luR.ow(false);
                this.luR.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.luR.A(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.luR.xd(-dimensionPixelSize4);
                this.luR.setYOffset(-dimensionPixelSize5);
                this.luR.fi(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.luR.xf(R.drawable.icon_pure_guide_haowu16);
            this.luR.oz(true);
            this.luR.aL(string, "commodity_tip_show_controller");
        }
    }
}
