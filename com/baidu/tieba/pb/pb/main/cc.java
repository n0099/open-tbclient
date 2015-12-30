package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements TbRichTextView.e {
    final /* synthetic */ cb cGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.cGE = cbVar;
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
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bf.vn().b(this.cGE.cGj.getPageContext(), new String[]{str})) {
            j = this.cGE.cGD;
            if (j != 0) {
                j2 = this.cGE.cGD;
                cVar = this.cGE.cDR;
                String id = cVar.akG().getId();
                cVar2 = this.cGE.cDR;
                String name = cVar2.akG().getName();
                cVar3 = this.cGE.cDR;
                com.baidu.tieba.pb.a.a(j2, str, "PB", "LINK_IMAGE", "CLICK", "tpoint", id, name, cVar3.akH().getTid());
            }
        }
    }
}
