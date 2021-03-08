package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b {
    private com.baidu.tieba.c.e eXz;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.eXz != null) {
            this.eXz.TC();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.eXz == null) {
                this.eXz = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.eXz.eo(R.drawable.pic_sign_tip_down);
                this.eXz.setLines(1);
                this.eXz.en(32);
                this.eXz.xi(2);
                this.eXz.pI(false);
                this.eXz.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.eXz.G(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.eXz.xm(-dimensionPixelSize4);
                this.eXz.setYOffset(-dimensionPixelSize5);
                this.eXz.ep(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.eXz.xn(R.drawable.icon_pure_guide_haowu16);
            this.eXz.pL(true);
            this.eXz.aJ(string, "commodity_tip_show_controller");
        }
    }
}
