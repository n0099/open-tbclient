package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TbRichTextView.e {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void b(View view, String str) {
        this.cnS.g(null, str, "LINK_IMAGE");
    }
}
