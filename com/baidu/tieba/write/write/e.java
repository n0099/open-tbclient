package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.e kuN;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.kuN != null) {
            this.kuN.HN();
        }
    }

    public void d(EditorTools editorTools) {
        View nR;
        if (editorTools != null && editorTools.eAi != null && this.mPageContext != null && (nR = editorTools.eAi.nR(26)) != null) {
            if (this.kuN == null) {
                this.kuN = new com.baidu.tieba.c.e(this.mPageContext, nR);
                this.kuN.cS(R.drawable.bg_tip_blue_down);
                this.kuN.cR(32);
                this.kuN.tn(2);
                this.kuN.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.kuN.HN();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kuN.z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.kuN.tr(0);
                this.kuN.setYOffset(-dimensionPixelSize3);
                this.kuN.cT(3000);
            }
            this.kuN.aC(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
