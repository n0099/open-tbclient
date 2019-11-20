package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hTS;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hTS != null) {
            this.hTS.uQ();
        }
    }

    public void c(EditorTools editorTools) {
        View jI;
        if (editorTools != null && editorTools.cEw != null && this.mPageContext != null && (jI = editorTools.cEw.jI(26)) != null) {
            if (this.hTS == null) {
                this.hTS = new com.baidu.tieba.c.d(this.mPageContext, jI);
                this.hTS.bB(R.drawable.bg_tip_blue_down);
                this.hTS.bA(32);
                this.hTS.pe(2);
                this.hTS.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hTS.uQ();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.hTS.t(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hTS.pg(0);
                this.hTS.setYOffset(-dimensionPixelSize3);
                this.hTS.bC(3000);
            }
            this.hTS.R(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
