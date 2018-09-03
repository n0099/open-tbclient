package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d fEb;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fEb != null) {
            this.fEb.akO();
        }
    }

    public void c(EditorTools editorTools) {
        View eL;
        if (editorTools != null && editorTools.aMl != null && this.mPageContext != null && (eL = editorTools.aMl.eL(26)) != null) {
            if (this.fEb == null) {
                this.fEb = new com.baidu.tieba.c.d(this.mPageContext, eL);
                this.fEb.jo(f.C0146f.bg_tip_blue_down);
                this.fEb.jn(32);
                this.fEb.jm(2);
                this.fEb.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.fEb.akO();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds4);
                this.fEb.n(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fEb.jr(0);
                this.fEb.js(-dimensionPixelSize3);
                this.fEb.jp(3000);
            }
            this.fEb.aO(this.mPageContext.getResources().getString(f.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
