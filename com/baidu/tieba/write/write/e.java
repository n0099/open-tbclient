package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d fzU;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fzU != null) {
            this.fzU.akT();
        }
    }

    public void c(EditorTools editorTools) {
        View eK;
        if (editorTools != null && editorTools.aLs != null && this.mPageContext != null && (eK = editorTools.aLs.eK(26)) != null) {
            if (this.fzU == null) {
                this.fzU = new com.baidu.tieba.c.d(this.mPageContext, eK);
                this.fzU.jf(d.f.bg_tip_blue_down);
                this.fzU.je(32);
                this.fzU.jd(2);
                this.fzU.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.fzU.akT();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.fzU.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fzU.ji(0);
                this.fzU.jj(-dimensionPixelSize3);
                this.fzU.jg(3000);
            }
            this.fzU.aQ(this.mPageContext.getResources().getString(d.k.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
