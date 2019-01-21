package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d gfz;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.gfz != null) {
            this.gfz.asz();
        }
    }

    public void c(EditorTools editorTools) {
        View fJ;
        if (editorTools != null && editorTools.aZf != null && this.mPageContext != null && (fJ = editorTools.aZf.fJ(26)) != null) {
            if (this.gfz == null) {
                this.gfz = new com.baidu.tieba.c.d(this.mPageContext, fJ);
                this.gfz.li(e.f.bg_tip_blue_down);
                this.gfz.lh(32);
                this.gfz.lg(2);
                this.gfz.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.gfz.asz();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4);
                this.gfz.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.gfz.ll(0);
                this.gfz.setYOffset(-dimensionPixelSize3);
                this.gfz.lj(3000);
            }
            this.gfz.bp(this.mPageContext.getResources().getString(e.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
