package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hWb;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hWb != null) {
            this.hWb.bcf();
        }
    }

    public void c(EditorTools editorTools) {
        View kr;
        if (editorTools != null && editorTools.cte != null && this.mPageContext != null && (kr = editorTools.cte.kr(26)) != null) {
            if (this.hWb == null) {
                this.hWb = new com.baidu.tieba.c.d(this.mPageContext, kr);
                this.hWb.qf(R.drawable.bg_tip_blue_down);
                this.hWb.qe(32);
                this.hWb.qd(2);
                this.hWb.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hWb.bcf();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.hWb.w(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hWb.qi(0);
                this.hWb.setYOffset(-dimensionPixelSize3);
                this.hWb.qg(3000);
            }
            this.hWb.cJ(this.mPageContext.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
