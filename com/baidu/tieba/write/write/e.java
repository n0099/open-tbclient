package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d fUM;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fUM != null) {
            this.fUM.apA();
        }
    }

    public void c(EditorTools editorTools) {
        View fu;
        if (editorTools != null && editorTools.aUU != null && this.mPageContext != null && (fu = editorTools.aUU.fu(26)) != null) {
            if (this.fUM == null) {
                this.fUM = new com.baidu.tieba.c.d(this.mPageContext, fu);
                this.fUM.kE(e.f.bg_tip_blue_down);
                this.fUM.kD(32);
                this.fUM.kC(2);
                this.fUM.n(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.fUM.apA();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds4);
                this.fUM.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fUM.kH(0);
                this.fUM.setYOffset(-dimensionPixelSize3);
                this.fUM.kF(3000);
            }
            this.fUM.bj(this.mPageContext.getResources().getString(e.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
