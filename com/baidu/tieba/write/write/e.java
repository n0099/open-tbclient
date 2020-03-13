package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class e {
    private com.baidu.tieba.c.d iNP;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.iNP != null) {
            this.iNP.zz();
        }
    }

    public void c(EditorTools editorTools) {
        View mn;
        if (editorTools != null && editorTools.dwW != null && this.mPageContext != null && (mn = editorTools.dwW.mn(26)) != null) {
            if (this.iNP == null) {
                this.iNP = new com.baidu.tieba.c.d(this.mPageContext, mn);
                this.iNP.ck(R.drawable.bg_tip_blue_down);
                this.iNP.cj(32);
                this.iNP.rx(2);
                this.iNP.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.iNP.zz();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.iNP.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.iNP.rz(0);
                this.iNP.setYOffset(-dimensionPixelSize3);
                this.iNP.cl(3000);
            }
            this.iNP.aj(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
