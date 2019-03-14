package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hvB;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hvB != null) {
            this.hvB.aSr();
        }
    }

    public void c(EditorTools editorTools) {
        View ju;
        if (editorTools != null && editorTools.ciD != null && this.mPageContext != null && (ju = editorTools.ciD.ju(26)) != null) {
            if (this.hvB == null) {
                this.hvB = new com.baidu.tieba.c.d(this.mPageContext, ju);
                this.hvB.oK(d.f.bg_tip_blue_down);
                this.hvB.oJ(32);
                this.hvB.oI(2);
                this.hvB.o(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hvB.aSr();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.hvB.s(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hvB.oN(0);
                this.hvB.setYOffset(-dimensionPixelSize3);
                this.hvB.oL(3000);
            }
            this.hvB.cu(this.mPageContext.getResources().getString(d.j.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
