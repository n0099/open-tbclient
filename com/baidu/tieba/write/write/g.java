package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class g {
    private com.baidu.tieba.c.e eXz;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.eXz != null) {
            this.eXz.TC();
        }
    }

    public void d(EditorTools editorTools) {
        View qT;
        if (editorTools != null && editorTools.fCW != null && this.mPageContext != null && (qT = editorTools.fCW.qT(26)) != null) {
            if (this.eXz == null) {
                this.eXz = new com.baidu.tieba.c.e(this.mPageContext, qT);
                this.eXz.eo(R.drawable.bg_tip_blue_down);
                this.eXz.en(32);
                this.eXz.xi(2);
                this.eXz.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        g.this.eXz.TC();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eXz.G(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.eXz.xm(0);
                this.eXz.setYOffset(-dimensionPixelSize3);
                this.eXz.ep(3000);
            }
            this.eXz.aJ(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
