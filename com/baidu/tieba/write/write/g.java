package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class g {
    private com.baidu.tieba.c.e eTK;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.eTK != null) {
            this.eTK.RS();
        }
    }

    public void d(EditorTools editorTools) {
        View qN;
        if (editorTools != null && editorTools.fzi != null && this.mPageContext != null && (qN = editorTools.fzi.qN(26)) != null) {
            if (this.eTK == null) {
                this.eTK = new com.baidu.tieba.c.e(this.mPageContext, qN);
                this.eTK.ej(R.drawable.bg_tip_blue_down);
                this.eTK.ei(32);
                this.eTK.wX(2);
                this.eTK.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.eTK.RS();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eTK.G(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.eTK.xb(0);
                this.eTK.setYOffset(-dimensionPixelSize3);
                this.eTK.ek(3000);
            }
            this.eTK.aJ(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
