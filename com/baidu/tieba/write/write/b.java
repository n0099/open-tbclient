package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.c.e kKu;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.kKu != null) {
            this.kKu.NG();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.kKu == null) {
                this.kKu = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kKu.eL(R.drawable.pic_sign_tip_down);
                this.kKu.vG(1);
                this.kKu.eK(32);
                this.kKu.setAnchor(2);
                this.kKu.nr(false);
                this.kKu.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.kKu.z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.kKu.vF(-dimensionPixelSize4);
                this.kKu.setYOffset(-dimensionPixelSize5);
                this.kKu.eM(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.kKu.vH(R.drawable.icon_pure_guide_haowu16);
            this.kKu.nu(true);
            this.kKu.aG(string, "commodity_tip_show_controller");
        }
    }
}
