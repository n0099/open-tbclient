package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hTi;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hTi != null) {
            this.hTi.bbz();
        }
    }

    public void c(EditorTools editorTools) {
        View kn;
        if (editorTools != null && editorTools.csc != null && this.mPageContext != null && (kn = editorTools.csc.kn(26)) != null) {
            if (this.hTi == null) {
                this.hTi = new com.baidu.tieba.c.d(this.mPageContext, kn);
                this.hTi.qb(R.drawable.bg_tip_blue_down);
                this.hTi.qa(32);
                this.hTi.pZ(2);
                this.hTi.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hTi.bbz();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.hTi.t(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hTi.qe(0);
                this.hTi.setYOffset(-dimensionPixelSize3);
                this.hTi.qc(3000);
            }
            this.hTi.cI(this.mPageContext.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
