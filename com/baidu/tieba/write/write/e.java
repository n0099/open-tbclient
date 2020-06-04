package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.c.d jSa;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.jSa != null) {
            this.jSa.Gu();
        }
    }

    public void c(EditorTools editorTools) {
        View nf;
        if (editorTools != null && editorTools.ele != null && this.mPageContext != null && (nf = editorTools.ele.nf(26)) != null) {
            if (this.jSa == null) {
                this.jSa = new com.baidu.tieba.c.d(this.mPageContext, nf);
                this.jSa.cI(R.drawable.bg_tip_blue_down);
                this.jSa.cH(32);
                this.jSa.sx(2);
                this.jSa.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jSa.Gu();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.jSa.y(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.jSa.sz(0);
                this.jSa.setYOffset(-dimensionPixelSize3);
                this.jSa.cJ(3000);
            }
            this.jSa.aA(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
