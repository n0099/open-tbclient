package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class e {
    private com.baidu.tieba.c.d iPq;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.iPq != null) {
            this.iPq.zG();
        }
    }

    public void c(EditorTools editorTools) {
        View mp;
        if (editorTools != null && editorTools.dxj != null && this.mPageContext != null && (mp = editorTools.dxj.mp(26)) != null) {
            if (this.iPq == null) {
                this.iPq = new com.baidu.tieba.c.d(this.mPageContext, mp);
                this.iPq.ck(R.drawable.bg_tip_blue_down);
                this.iPq.cj(32);
                this.iPq.rz(2);
                this.iPq.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.iPq.zG();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.iPq.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.iPq.rB(0);
                this.iPq.setYOffset(-dimensionPixelSize3);
                this.iPq.cl(3000);
            }
            this.iPq.ai(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
