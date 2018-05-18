package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.d.c foB;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.foB != null) {
            this.foB.ahf();
        }
    }

    public void c(EditorTools editorTools) {
        View eG;
        if (editorTools != null && editorTools.aCW != null && this.mPageContext != null && (eG = editorTools.aCW.eG(26)) != null) {
            if (this.foB == null) {
                this.foB = new com.baidu.tieba.d.c(this.mPageContext, eG);
                this.foB.jc(d.f.bg_tip_blue_down);
                this.foB.jb(32);
                this.foB.ja(2);
                this.foB.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        e.this.foB.ahf();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.foB.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.foB.jf(0);
                this.foB.jg(-dimensionPixelSize3);
                this.foB.jd(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            }
            this.foB.aJ(this.mPageContext.getResources().getString(d.k.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
