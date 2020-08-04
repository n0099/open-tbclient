package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.e kuP;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.kuP != null) {
            this.kuP.HN();
        }
    }

    public void d(EditorTools editorTools) {
        View nR;
        if (editorTools != null && editorTools.eAi != null && this.mPageContext != null && (nR = editorTools.eAi.nR(26)) != null) {
            if (this.kuP == null) {
                this.kuP = new com.baidu.tieba.c.e(this.mPageContext, nR);
                this.kuP.cS(R.drawable.bg_tip_blue_down);
                this.kuP.cR(32);
                this.kuP.tn(2);
                this.kuP.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.kuP.HN();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kuP.z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.kuP.tr(0);
                this.kuP.setYOffset(-dimensionPixelSize3);
                this.kuP.cT(3000);
            }
            this.kuP.aC(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
