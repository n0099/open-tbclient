package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.tieba.c.d iMh;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.iMh != null) {
            this.iMh.xg();
        }
    }

    public void c(EditorTools editorTools) {
        View lV;
        if (editorTools != null && editorTools.dsC != null && this.mPageContext != null && (lV = editorTools.dsC.lV(26)) != null) {
            if (this.iMh == null) {
                this.iMh = new com.baidu.tieba.c.d(this.mPageContext, lV);
                this.iMh.bU(R.drawable.bg_tip_blue_down);
                this.iMh.bT(32);
                this.iMh.rq(2);
                this.iMh.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.iMh.xg();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.iMh.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.iMh.rs(0);
                this.iMh.setYOffset(-dimensionPixelSize3);
                this.iMh.bV(3000);
            }
            this.iMh.Y(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
