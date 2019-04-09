package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hvp;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hvp != null) {
            this.hvp.aSp();
        }
    }

    public void c(EditorTools editorTools) {
        View jt;
        if (editorTools != null && editorTools.ciG != null && this.mPageContext != null && (jt = editorTools.ciG.jt(26)) != null) {
            if (this.hvp == null) {
                this.hvp = new com.baidu.tieba.c.d(this.mPageContext, jt);
                this.hvp.oG(d.f.bg_tip_blue_down);
                this.hvp.oF(32);
                this.hvp.oE(2);
                this.hvp.o(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hvp.aSp();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.hvp.s(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hvp.oJ(0);
                this.hvp.setYOffset(-dimensionPixelSize3);
                this.hvp.oH(3000);
            }
            this.hvp.cv(this.mPageContext.getResources().getString(d.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
