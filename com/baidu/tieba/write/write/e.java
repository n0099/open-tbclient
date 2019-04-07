package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hvo;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hvo != null) {
            this.hvo.aSp();
        }
    }

    public void c(EditorTools editorTools) {
        View jt;
        if (editorTools != null && editorTools.ciF != null && this.mPageContext != null && (jt = editorTools.ciF.jt(26)) != null) {
            if (this.hvo == null) {
                this.hvo = new com.baidu.tieba.c.d(this.mPageContext, jt);
                this.hvo.oG(d.f.bg_tip_blue_down);
                this.hvo.oF(32);
                this.hvo.oE(2);
                this.hvo.o(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hvo.aSp();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.hvo.s(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hvo.oJ(0);
                this.hvo.setYOffset(-dimensionPixelSize3);
                this.hvo.oH(3000);
            }
            this.hvo.cv(this.mPageContext.getResources().getString(d.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
