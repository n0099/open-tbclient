package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.c.e kKB;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.kKB != null) {
            this.kKB.NG();
        }
    }

    public void d(EditorTools editorTools) {
        View qc;
        if (editorTools != null && editorTools.eKK != null && this.mPageContext != null && (qc = editorTools.eKK.qc(26)) != null) {
            if (this.kKB == null) {
                this.kKB = new com.baidu.tieba.c.e(this.mPageContext, qc);
                this.kKB.eL(R.drawable.bg_tip_blue_down);
                this.kKB.eK(32);
                this.kKB.setAnchor(2);
                this.kKB.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.kKB.NG();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kKB.z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.kKB.vF(0);
                this.kKB.setYOffset(-dimensionPixelSize3);
                this.kKB.eM(3000);
            }
            this.kKB.aG(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
