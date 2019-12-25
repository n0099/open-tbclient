package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e {
    private com.baidu.tieba.c.d iID;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.iID != null) {
            this.iID.wP();
        }
    }

    public void c(EditorTools editorTools) {
        View lV;
        if (editorTools != null && editorTools.dsq != null && this.mPageContext != null && (lV = editorTools.dsq.lV(26)) != null) {
            if (this.iID == null) {
                this.iID = new com.baidu.tieba.c.d(this.mPageContext, lV);
                this.iID.bT(R.drawable.bg_tip_blue_down);
                this.iID.bS(32);
                this.iID.rl(2);
                this.iID.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.iID.wP();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.iID.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.iID.rn(0);
                this.iID.setYOffset(-dimensionPixelSize3);
                this.iID.bU(3000);
            }
            this.iID.Z(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
