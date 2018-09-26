package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d fLL;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fLL != null) {
            this.fLL.amz();
        }
    }

    public void c(EditorTools editorTools) {
        View eX;
        if (editorTools != null && editorTools.aPD != null && this.mPageContext != null && (eX = editorTools.aPD.eX(26)) != null) {
            if (this.fLL == null) {
                this.fLL = new com.baidu.tieba.c.d(this.mPageContext, eX);
                this.fLL.jN(e.f.bg_tip_blue_down);
                this.fLL.jM(32);
                this.fLL.jL(2);
                this.fLL.k(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.fLL.amz();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds4);
                this.fLL.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fLL.jQ(0);
                this.fLL.jR(-dimensionPixelSize3);
                this.fLL.jO(3000);
            }
            this.fLL.aW(this.mPageContext.getResources().getString(e.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
