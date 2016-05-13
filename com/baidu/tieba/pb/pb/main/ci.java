package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements TbRichTextView.e {
    final /* synthetic */ ch dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.dky = chVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void b(View view, String str) {
        long j;
        long j2;
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bg.ut().c(this.dky.dhY.getPageContext(), new String[]{str})) {
            j = this.dky.dkx;
            if (j != 0) {
                j2 = this.dky.dkx;
                eVar = this.dky.dfK;
                String id = eVar.avD().getId();
                eVar2 = this.dky.dfK;
                String name = eVar2.avD().getName();
                eVar3 = this.dky.dfK;
                com.baidu.tieba.pb.b.a(j2, str, "PB", "LINK_IMAGE", "CLICK", "tpoint", id, name, eVar3.avE().getTid());
            }
        }
    }
}
