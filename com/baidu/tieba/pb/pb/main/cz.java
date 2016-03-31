package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements TbRichTextView.e {
    final /* synthetic */ cy dip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cy cyVar) {
        this.dip = cyVar;
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
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bg.wM().c(this.dip.dfw.getPageContext(), new String[]{str})) {
            j = this.dip.dio;
            if (j != 0) {
                j2 = this.dip.dio;
                eVar = this.dip.ddq;
                String id = eVar.avu().getId();
                eVar2 = this.dip.ddq;
                String name = eVar2.avu().getName();
                eVar3 = this.dip.ddq;
                com.baidu.tieba.pb.b.a(j2, str, "PB", "LINK_IMAGE", "CLICK", "tpoint", id, name, eVar3.avv().getTid());
            }
        }
    }
}
