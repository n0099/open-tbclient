package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d gbC;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.gbC != null) {
            this.gbC.arm();
        }
    }

    public void c(EditorTools editorTools) {
        View fI;
        if (editorTools != null && editorTools.aYr != null && this.mPageContext != null && (fI = editorTools.aYr.fI(26)) != null) {
            if (this.gbC == null) {
                this.gbC = new com.baidu.tieba.c.d(this.mPageContext, fI);
                this.gbC.kU(e.f.bg_tip_blue_down);
                this.gbC.kT(32);
                this.gbC.kS(2);
                this.gbC.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.gbC.arm();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4);
                this.gbC.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.gbC.kX(0);
                this.gbC.setYOffset(-dimensionPixelSize3);
                this.gbC.kV(3000);
            }
            this.gbC.bo(this.mPageContext.getResources().getString(e.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
