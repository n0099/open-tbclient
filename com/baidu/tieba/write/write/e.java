package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d fEi;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fEi != null) {
            this.fEi.akM();
        }
    }

    public void c(EditorTools editorTools) {
        View eM;
        if (editorTools != null && editorTools.aMo != null && this.mPageContext != null && (eM = editorTools.aMo.eM(26)) != null) {
            if (this.fEi == null) {
                this.fEi = new com.baidu.tieba.c.d(this.mPageContext, eM);
                this.fEi.jp(d.f.bg_tip_blue_down);
                this.fEi.jo(32);
                this.fEi.jn(2);
                this.fEi.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.fEi.akM();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.fEi.n(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fEi.js(0);
                this.fEi.jt(-dimensionPixelSize3);
                this.fEi.jq(3000);
            }
            this.fEi.aO(this.mPageContext.getResources().getString(d.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
