package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d gev;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.gev != null) {
            this.gev.asb();
        }
    }

    public void c(EditorTools editorTools) {
        View fJ;
        if (editorTools != null && editorTools.aYu != null && this.mPageContext != null && (fJ = editorTools.aYu.fJ(26)) != null) {
            if (this.gev == null) {
                this.gev = new com.baidu.tieba.c.d(this.mPageContext, fJ);
                this.gev.lh(e.f.bg_tip_blue_down);
                this.gev.lg(32);
                this.gev.lf(2);
                this.gev.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.gev.asb();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4);
                this.gev.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.gev.lk(0);
                this.gev.setYOffset(-dimensionPixelSize3);
                this.gev.li(3000);
            }
            this.gev.bo(this.mPageContext.getResources().getString(e.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
