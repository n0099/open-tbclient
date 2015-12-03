package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements TbRichTextView.e {
    final /* synthetic */ by cCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar) {
        this.cCR = byVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void b(View view, String str) {
        long j;
        long j2;
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bf.vD().b(this.cCR.cCy.getPageContext(), new String[]{str})) {
            j = this.cCR.cCQ;
            if (j != 0) {
                j2 = this.cCR.cCQ;
                cVar = this.cCR.cAm;
                String id = cVar.ajy().getId();
                cVar2 = this.cCR.cAm;
                String name = cVar2.ajy().getName();
                cVar3 = this.cCR.cAm;
                com.baidu.tieba.pb.a.a(j2, str, "PB", "LINK_IMAGE", "CLICK", "tpoint", id, name, cVar3.ajz().getTid());
            }
        }
    }
}
