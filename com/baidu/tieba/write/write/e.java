package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.c.d hUe;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.hUe != null) {
            this.hUe.bbB();
        }
    }

    public void c(EditorTools editorTools) {
        View ko;
        if (editorTools != null && editorTools.csj != null && this.mPageContext != null && (ko = editorTools.csj.ko(26)) != null) {
            if (this.hUe == null) {
                this.hUe = new com.baidu.tieba.c.d(this.mPageContext, ko);
                this.hUe.qc(R.drawable.bg_tip_blue_down);
                this.hUe.qb(32);
                this.hUe.qa(2);
                this.hUe.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.hUe.bbB();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.hUe.t(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.hUe.qf(0);
                this.hUe.setYOffset(-dimensionPixelSize3);
                this.hUe.qd(3000);
            }
            this.hUe.cI(this.mPageContext.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
