package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.d.c fnt;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fnt != null) {
            this.fnt.ahf();
        }
    }

    public void c(EditorTools editorTools) {
        View eF;
        if (editorTools != null && editorTools.aCV != null && this.mPageContext != null && (eF = editorTools.aCV.eF(26)) != null) {
            if (this.fnt == null) {
                this.fnt = new com.baidu.tieba.d.c(this.mPageContext, eF);
                this.fnt.jd(d.f.bg_tip_blue_down);
                this.fnt.jc(32);
                this.fnt.jb(2);
                this.fnt.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        e.this.fnt.ahf();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.fnt.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fnt.jg(0);
                this.fnt.jh(-dimensionPixelSize3);
                this.fnt.je(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            }
            this.fnt.aJ(this.mPageContext.getResources().getString(d.k.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
