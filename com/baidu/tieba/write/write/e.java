package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class e {
    private com.baidu.tieba.c.d iNB;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.iNB != null) {
            this.iNB.zx();
        }
    }

    public void c(EditorTools editorTools) {
        View mn;
        if (editorTools != null && editorTools.dwI != null && this.mPageContext != null && (mn = editorTools.dwI.mn(26)) != null) {
            if (this.iNB == null) {
                this.iNB = new com.baidu.tieba.c.d(this.mPageContext, mn);
                this.iNB.ck(R.drawable.bg_tip_blue_down);
                this.iNB.cj(32);
                this.iNB.rx(2);
                this.iNB.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.iNB.zx();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.iNB.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.iNB.rz(0);
                this.iNB.setYOffset(-dimensionPixelSize3);
                this.iNB.cl(3000);
            }
            this.iNB.aj(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
