package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d fDV;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fDV != null) {
            this.fDV.akn();
        }
    }

    public void c(EditorTools editorTools) {
        View eL;
        if (editorTools != null && editorTools.aMo != null && this.mPageContext != null && (eL = editorTools.aMo.eL(26)) != null) {
            if (this.fDV == null) {
                this.fDV = new com.baidu.tieba.c.d(this.mPageContext, eL);
                this.fDV.jd(d.f.bg_tip_blue_down);
                this.fDV.jc(32);
                this.fDV.jb(2);
                this.fDV.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.fDV.akn();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.fDV.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fDV.jg(0);
                this.fDV.jh(-dimensionPixelSize3);
                this.fDV.je(3000);
            }
            this.fDV.aQ(this.mPageContext.getResources().getString(d.k.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
