package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.c.d jzz;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.jzz != null) {
            this.jzz.EE();
        }
    }

    public void c(EditorTools editorTools) {
        View mB;
        if (editorTools != null && editorTools.dWQ != null && this.mPageContext != null && (mB = editorTools.dWQ.mB(26)) != null) {
            if (this.jzz == null) {
                this.jzz = new com.baidu.tieba.c.d(this.mPageContext, mB);
                this.jzz.cz(R.drawable.bg_tip_blue_down);
                this.jzz.cy(32);
                this.jzz.rR(2);
                this.jzz.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.jzz.EE();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.jzz.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.jzz.rS(0);
                this.jzz.setYOffset(-dimensionPixelSize3);
                this.jzz.cA(3000);
            }
            this.jzz.al(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
