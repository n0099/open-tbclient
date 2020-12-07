package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.tieba.d.e lOT;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.lOT != null) {
            this.lOT.UG();
        }
    }

    public void d(EditorTools editorTools) {
        View sh;
        if (editorTools != null && editorTools.fuk != null && this.mPageContext != null && (sh = editorTools.fuk.sh(26)) != null) {
            if (this.lOT == null) {
                this.lOT = new com.baidu.tieba.d.e(this.mPageContext, sh);
                this.lOT.fO(R.drawable.bg_tip_blue_down);
                this.lOT.fN(32);
                this.lOT.setAnchor(2);
                this.lOT.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.lOT.UG();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lOT.F(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.lOT.yt(0);
                this.lOT.setYOffset(-dimensionPixelSize3);
                this.lOT.fP(3000);
            }
            this.lOT.aP(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
