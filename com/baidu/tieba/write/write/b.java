package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.c.e kKB;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.kKB != null) {
            this.kKB.NG();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.kKB == null) {
                this.kKB = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kKB.eL(R.drawable.pic_sign_tip_down);
                this.kKB.vG(1);
                this.kKB.eK(32);
                this.kKB.setAnchor(2);
                this.kKB.nt(false);
                this.kKB.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.kKB.z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.kKB.vF(-dimensionPixelSize4);
                this.kKB.setYOffset(-dimensionPixelSize5);
                this.kKB.eM(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.kKB.vH(R.drawable.icon_pure_guide_haowu16);
            this.kKB.nw(true);
            this.kKB.aG(string, "commodity_tip_show_controller");
        }
    }
}
