package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.c.d jQU;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.jQU != null) {
            this.jQU.Gu();
        }
    }

    public void c(EditorTools editorTools) {
        View nd;
        if (editorTools != null && editorTools.ele != null && this.mPageContext != null && (nd = editorTools.ele.nd(26)) != null) {
            if (this.jQU == null) {
                this.jQU = new com.baidu.tieba.c.d(this.mPageContext, nd);
                this.jQU.cG(R.drawable.bg_tip_blue_down);
                this.jQU.cF(32);
                this.jQU.sv(2);
                this.jQU.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jQU.Gu();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.jQU.y(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.jQU.sx(0);
                this.jQU.setYOffset(-dimensionPixelSize3);
                this.jQU.cH(3000);
            }
            this.jQU.aA(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
