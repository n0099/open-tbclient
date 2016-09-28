package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements TbRichTextView.f {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
    public void b(View view, String str) {
        this.exF.g(null, str, "LINK_IMAGE");
    }
}
