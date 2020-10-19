package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.c.e lio;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lio != null) {
            this.lio.Po();
        }
    }

    public void d(EditorTools editorTools) {
        View qN;
        if (editorTools != null && editorTools.eZi != null && this.mPageContext != null && (qN = editorTools.eZi.qN(26)) != null) {
            if (this.lio == null) {
                this.lio = new com.baidu.tieba.c.e(this.mPageContext, qN);
                this.lio.ff(R.drawable.bg_tip_blue_down);
                this.lio.fe(32);
                this.lio.setAnchor(2);
                this.lio.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.lio.Po();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lio.z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.lio.wK(0);
                this.lio.setYOffset(-dimensionPixelSize3);
                this.lio.fg(3000);
            }
            this.lio.aJ(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
