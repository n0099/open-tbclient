package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.c.e luR;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.luR != null) {
            this.luR.Qh();
        }
    }

    public void d(EditorTools editorTools) {
        View qY;
        if (editorTools != null && editorTools.fhE != null && this.mPageContext != null && (qY = editorTools.fhE.qY(26)) != null) {
            if (this.luR == null) {
                this.luR = new com.baidu.tieba.c.e(this.mPageContext, qY);
                this.luR.fh(R.drawable.bg_tip_blue_down);
                this.luR.fg(32);
                this.luR.setAnchor(2);
                this.luR.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.luR.Qh();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.luR.A(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.luR.xd(0);
                this.luR.setYOffset(-dimensionPixelSize3);
                this.luR.fi(3000);
            }
            this.luR.aL(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
