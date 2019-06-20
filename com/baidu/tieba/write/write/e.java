package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hMV;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hMV != null) {
            this.hMV.aZA();
        }
    }

    public void c(EditorTools editorTools) {
        View kh;
        if (editorTools != null && editorTools.cqO != null && this.mPageContext != null && (kh = editorTools.cqO.kh(26)) != null) {
            if (this.hMV == null) {
                this.hMV = new com.baidu.tieba.c.d(this.mPageContext, kh);
                this.hMV.pK(R.drawable.bg_tip_blue_down);
                this.hMV.pJ(32);
                this.hMV.pI(2);
                this.hMV.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hMV.aZA();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.hMV.s(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hMV.pN(0);
                this.hMV.setYOffset(-dimensionPixelSize3);
                this.hMV.pL(3000);
            }
            this.hMV.cH(this.mPageContext.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
