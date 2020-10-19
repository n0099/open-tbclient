package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.c.e lio;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lio != null) {
            this.lio.Po();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.lio == null) {
                this.lio = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.lio.ff(R.drawable.pic_sign_tip_down);
                this.lio.wL(1);
                this.lio.fe(32);
                this.lio.setAnchor(2);
                this.lio.oe(false);
                this.lio.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.lio.z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.lio.wK(-dimensionPixelSize4);
                this.lio.setYOffset(-dimensionPixelSize5);
                this.lio.fg(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.lio.wM(R.drawable.icon_pure_guide_haowu16);
            this.lio.oh(true);
            this.lio.aJ(string, "commodity_tip_show_controller");
        }
    }
}
