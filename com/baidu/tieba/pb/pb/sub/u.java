package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TbRichTextView.f {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
    public void b(View view, String str) {
        this.eqU.i(null, str, "LINK_IMAGE");
    }
}
