package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b {
    private com.baidu.tieba.c.e eYv;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.eYv != null) {
            this.eYv.VL();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.eYv == null) {
                this.eYv = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.eYv.fP(R.drawable.pic_sign_tip_down);
                this.eYv.setLines(1);
                this.eYv.fO(32);
                this.eYv.setAnchor(2);
                this.eYv.pC(false);
                this.eYv.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.eYv.G(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.eYv.yH(-dimensionPixelSize4);
                this.eYv.setYOffset(-dimensionPixelSize5);
                this.eYv.fQ(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.eYv.yI(R.drawable.icon_pure_guide_haowu16);
            this.eYv.pF(true);
            this.eYv.aK(string, "commodity_tip_show_controller");
        }
    }
}
