package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.c.e klQ;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.klQ != null) {
            this.klQ.HH();
        }
    }

    public void c(EditorTools editorTools) {
        View nz;
        if (editorTools != null && editorTools.etQ != null && this.mPageContext != null && (nz = editorTools.etQ.nz(26)) != null) {
            if (this.klQ == null) {
                this.klQ = new com.baidu.tieba.c.e(this.mPageContext, nz);
                this.klQ.cS(R.drawable.bg_tip_blue_down);
                this.klQ.cR(32);
                this.klQ.sV(2);
                this.klQ.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.klQ.HH();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.klQ.y(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.klQ.sZ(0);
                this.klQ.setYOffset(-dimensionPixelSize3);
                this.klQ.cT(3000);
            }
            this.klQ.aC(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
