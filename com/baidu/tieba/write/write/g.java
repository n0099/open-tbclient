package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class g {
    private com.baidu.tieba.c.e eYv;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.eYv != null) {
            this.eYv.VL();
        }
    }

    public void d(EditorTools editorTools) {
        View st;
        if (editorTools != null && editorTools.fDQ != null && this.mPageContext != null && (st = editorTools.fDQ.st(26)) != null) {
            if (this.eYv == null) {
                this.eYv = new com.baidu.tieba.c.e(this.mPageContext, st);
                this.eYv.fP(R.drawable.bg_tip_blue_down);
                this.eYv.fO(32);
                this.eYv.setAnchor(2);
                this.eYv.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.eYv.VL();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eYv.G(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.eYv.yH(0);
                this.eYv.setYOffset(-dimensionPixelSize3);
                this.eYv.fQ(3000);
            }
            this.eYv.aK(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
