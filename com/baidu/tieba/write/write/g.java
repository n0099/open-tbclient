package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.c.e lAO;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lAO != null) {
            this.lAO.SR();
        }
    }

    public void d(EditorTools editorTools) {
        View ri;
        if (editorTools != null && editorTools.fny != null && this.mPageContext != null && (ri = editorTools.fny.ri(26)) != null) {
            if (this.lAO == null) {
                this.lAO = new com.baidu.tieba.c.e(this.mPageContext, ri);
                this.lAO.fu(R.drawable.bg_tip_blue_down);
                this.lAO.ft(32);
                this.lAO.setAnchor(2);
                this.lAO.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.lAO.SR();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lAO.A(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.lAO.xq(0);
                this.lAO.setYOffset(-dimensionPixelSize3);
                this.lAO.fv(3000);
            }
            this.lAO.aM(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
