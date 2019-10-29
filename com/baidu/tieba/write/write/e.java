package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hUJ;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hUJ != null) {
            this.hUJ.uP();
        }
    }

    public void c(EditorTools editorTools) {
        View jJ;
        if (editorTools != null && editorTools.cFn != null && this.mPageContext != null && (jJ = editorTools.cFn.jJ(26)) != null) {
            if (this.hUJ == null) {
                this.hUJ = new com.baidu.tieba.c.d(this.mPageContext, jJ);
                this.hUJ.bB(R.drawable.bg_tip_blue_down);
                this.hUJ.bA(32);
                this.hUJ.pf(2);
                this.hUJ.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hUJ.uP();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.hUJ.t(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hUJ.ph(0);
                this.hUJ.setYOffset(-dimensionPixelSize3);
                this.hUJ.bC(3000);
            }
            this.hUJ.R(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
