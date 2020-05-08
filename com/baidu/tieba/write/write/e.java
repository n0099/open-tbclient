package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.c.d jzD;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.jzD != null) {
            this.jzD.ED();
        }
    }

    public void c(EditorTools editorTools) {
        View mB;
        if (editorTools != null && editorTools.dWV != null && this.mPageContext != null && (mB = editorTools.dWV.mB(26)) != null) {
            if (this.jzD == null) {
                this.jzD = new com.baidu.tieba.c.d(this.mPageContext, mB);
                this.jzD.cz(R.drawable.bg_tip_blue_down);
                this.jzD.cy(32);
                this.jzD.rR(2);
                this.jzD.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jzD.ED();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.jzD.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.jzD.rS(0);
                this.jzD.setYOffset(-dimensionPixelSize3);
                this.jzD.cA(3000);
            }
            this.jzD.al(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
