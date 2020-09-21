package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.c.e kTb;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.kTb != null) {
            this.kTb.Oj();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.kTb == null) {
                this.kTb = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kTb.eW(R.drawable.pic_sign_tip_down);
                this.kTb.wf(1);
                this.kTb.eV(32);
                this.kTb.setAnchor(2);
                this.kTb.nz(false);
                this.kTb.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.kTb.z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.kTb.we(-dimensionPixelSize4);
                this.kTb.setYOffset(-dimensionPixelSize5);
                this.kTb.eX(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.kTb.wg(R.drawable.icon_pure_guide_haowu16);
            this.kTb.nC(true);
            this.kTb.aG(string, "commodity_tip_show_controller");
        }
    }
}
