package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements TbRichTextView.e {
    final /* synthetic */ ci cOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar) {
        this.cOi = ciVar;
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
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.be.wt().c(this.cOi.cNL.getPageContext(), new String[]{str})) {
            j = this.cOi.cOh;
            if (j != 0) {
                j2 = this.cOi.cOh;
                cVar = this.cOi.cJZ;
                String id = cVar.aoE().getId();
                cVar2 = this.cOi.cJZ;
                String name = cVar2.aoE().getName();
                cVar3 = this.cOi.cJZ;
                com.baidu.tieba.pb.a.a(j2, str, "PB", "LINK_IMAGE", "CLICK", "tpoint", id, name, cVar3.aoF().getTid());
            }
        }
    }
}
