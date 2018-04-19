package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.d.c fnw;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void hideTip() {
        if (this.fnw != null) {
            this.fnw.ahf();
        }
    }

    public void c(EditorTools editorTools) {
        View eF;
        if (editorTools != null && editorTools.aCV != null && this.mPageContext != null && (eF = editorTools.aCV.eF(26)) != null) {
            if (this.fnw == null) {
                this.fnw = new com.baidu.tieba.d.c(this.mPageContext, eF);
                this.fnw.jd(d.f.bg_tip_blue_down);
                this.fnw.jc(32);
                this.fnw.jb(2);
                this.fnw.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        e.this.fnw.ahf();
                    }
                });
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds4);
                this.fnw.o(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.fnw.jg(0);
                this.fnw.jh(-dimensionPixelSize3);
                this.fnw.je(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            }
            this.fnw.aJ(this.mPageContext.getResources().getString(d.k.hot_topic_tip), "key_show_hottopic_tip");
        }
    }
}
