package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d fTm;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fTm != null) {
            this.fTm.apY();
        }
    }

    public void c(EditorTools editorTools) {
        View fg;
        if (editorTools != null && editorTools.aUe != null && this.mPageContext != null && (fg = editorTools.aUe.fg(26)) != null) {
            if (this.fTm == null) {
                this.fTm = new com.baidu.tieba.c.d(this.mPageContext, fg);
                this.fTm.kl(e.f.bg_tip_blue_down);
                this.fTm.kk(32);
                this.fTm.kj(2);
                this.fTm.l(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.fTm.apY();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds4);
                this.fTm.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fTm.ko(0);
                this.fTm.kp(-dimensionPixelSize3);
                this.fTm.km(3000);
            }
            this.fTm.bj(this.mPageContext.getResources().getString(e.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
