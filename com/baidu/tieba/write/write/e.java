package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d gfy;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.gfy != null) {
            this.gfy.asz();
        }
    }

    public void c(EditorTools editorTools) {
        View fJ;
        if (editorTools != null && editorTools.aZe != null && this.mPageContext != null && (fJ = editorTools.aZe.fJ(26)) != null) {
            if (this.gfy == null) {
                this.gfy = new com.baidu.tieba.c.d(this.mPageContext, fJ);
                this.gfy.li(e.f.bg_tip_blue_down);
                this.gfy.lh(32);
                this.gfy.lg(2);
                this.gfy.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.gfy.asz();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4);
                this.gfy.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.gfy.ll(0);
                this.gfy.setYOffset(-dimensionPixelSize3);
                this.gfy.lj(3000);
            }
            this.gfy.bp(this.mPageContext.getResources().getString(e.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
