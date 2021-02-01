package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class g {
    private com.baidu.tieba.c.e eWa;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.eWa != null) {
            this.eWa.Tz();
        }
    }

    public void d(EditorTools editorTools) {
        View qS;
        if (editorTools != null && editorTools.fBx != null && this.mPageContext != null && (qS = editorTools.fBx.qS(26)) != null) {
            if (this.eWa == null) {
                this.eWa = new com.baidu.tieba.c.e(this.mPageContext, qS);
                this.eWa.en(R.drawable.bg_tip_blue_down);
                this.eWa.em(32);
                this.eWa.xh(2);
                this.eWa.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.eWa.Tz();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eWa.G(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.eWa.xl(0);
                this.eWa.setYOffset(-dimensionPixelSize3);
                this.eWa.eo(3000);
            }
            this.eWa.aJ(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
