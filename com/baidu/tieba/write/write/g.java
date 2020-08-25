package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.c.e kKu;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.kKu != null) {
            this.kKu.NG();
        }
    }

    public void d(EditorTools editorTools) {
        View qc;
        if (editorTools != null && editorTools.eKG != null && this.mPageContext != null && (qc = editorTools.eKG.qc(26)) != null) {
            if (this.kKu == null) {
                this.kKu = new com.baidu.tieba.c.e(this.mPageContext, qc);
                this.kKu.eL(R.drawable.bg_tip_blue_down);
                this.kKu.eK(32);
                this.kKu.setAnchor(2);
                this.kKu.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.kKu.NG();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kKu.z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.kKu.vF(0);
                this.kKu.setYOffset(-dimensionPixelSize3);
                this.kKu.eM(3000);
            }
            this.kKu.aG(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
