package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TbRichTextView.f {
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
    public void b(View view, String str) {
        this.eis.g(null, str, "LINK_IMAGE");
    }
}
