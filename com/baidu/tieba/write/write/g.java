package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.d.e lBg;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lBg != null) {
            this.lBg.Si();
        }
    }

    public void d(EditorTools editorTools) {
        View rG;
        if (editorTools != null && editorTools.fmG != null && this.mPageContext != null && (rG = editorTools.fmG.rG(26)) != null) {
            if (this.lBg == null) {
                this.lBg = new com.baidu.tieba.d.e(this.mPageContext, rG);
                this.lBg.fq(R.drawable.bg_tip_blue_down);
                this.lBg.fp(32);
                this.lBg.setAnchor(2);
                this.lBg.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.lBg.Si();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lBg.B(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.lBg.xO(0);
                this.lBg.setYOffset(-dimensionPixelSize3);
                this.lBg.fr(3000);
            }
            this.lBg.aL(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
