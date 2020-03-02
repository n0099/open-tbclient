package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class e {
    private com.baidu.tieba.c.d iND;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.iND != null) {
            this.iND.zz();
        }
    }

    public void c(EditorTools editorTools) {
        View mn;
        if (editorTools != null && editorTools.dwJ != null && this.mPageContext != null && (mn = editorTools.dwJ.mn(26)) != null) {
            if (this.iND == null) {
                this.iND = new com.baidu.tieba.c.d(this.mPageContext, mn);
                this.iND.ck(R.drawable.bg_tip_blue_down);
                this.iND.cj(32);
                this.iND.rx(2);
                this.iND.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.iND.zz();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.iND.x(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.iND.rz(0);
                this.iND.setYOffset(-dimensionPixelSize3);
                this.iND.cl(3000);
            }
            this.iND.aj(this.mPageContext.getResources().getString(R.string.hot_topic_tip), SharedPrefConfig.KEY_SHOW_HOTTOPIC_TIP);
        }
    }
}
