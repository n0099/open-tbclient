package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.d.e lOV;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lOV != null) {
            this.lOV.UG();
        }
    }

    public void showTip(View view) {
        if (this.mPageContext != null && view != null) {
            if (this.lOV == null) {
                this.lOV = new com.baidu.tieba.d.e(this.mPageContext, view);
                this.lOV.fO(R.drawable.pic_sign_tip_down);
                this.lOV.yu(1);
                this.lOV.fN(32);
                this.lOV.setAnchor(2);
                this.lOV.pe(false);
                this.lOV.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.b.1
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
                this.lOV.F(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.lOV.yt(-dimensionPixelSize4);
                this.lOV.setYOffset(-dimensionPixelSize5);
                this.lOV.fP(3000);
            }
            String string = this.mPageContext.getResources().getString(R.string.write_activity_tip_content);
            this.lOV.yv(R.drawable.icon_pure_guide_haowu16);
            this.lOV.ph(true);
            this.lOV.aP(string, "commodity_tip_show_controller");
        }
    }
}
