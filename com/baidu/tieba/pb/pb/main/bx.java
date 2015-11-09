package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements TbRichTextView.e {
    final /* synthetic */ bw cks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar) {
        this.cks = bwVar;
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
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.az.uX().b(this.cks.cjZ.getPageContext(), new String[]{str})) {
            j = this.cks.ckr;
            if (j != 0) {
                j2 = this.cks.ckr;
                cVar = this.cks.chP;
                String id = cVar.afg().getId();
                cVar2 = this.cks.chP;
                String name = cVar2.afg().getName();
                cVar3 = this.cks.chP;
                com.baidu.tieba.pb.a.a(j2, str, "PB", "LINK_IMAGE", "CLICK", "tpoint", id, name, cVar3.afh().getTid());
            }
        }
    }
}
