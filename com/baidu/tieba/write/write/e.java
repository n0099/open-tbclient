package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hMU;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hMU != null) {
            this.hMU.aZA();
        }
    }

    public void c(EditorTools editorTools) {
        View kh;
        if (editorTools != null && editorTools.cqN != null && this.mPageContext != null && (kh = editorTools.cqN.kh(26)) != null) {
            if (this.hMU == null) {
                this.hMU = new com.baidu.tieba.c.d(this.mPageContext, kh);
                this.hMU.pK(R.drawable.bg_tip_blue_down);
                this.hMU.pJ(32);
                this.hMU.pI(2);
                this.hMU.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hMU.aZA();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.hMU.s(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hMU.pN(0);
                this.hMU.setYOffset(-dimensionPixelSize3);
                this.hMU.pL(3000);
            }
            this.hMU.cH(this.mPageContext.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
