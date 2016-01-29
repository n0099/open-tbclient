package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements TbRichTextView.e {
    final /* synthetic */ cw cPA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cw cwVar) {
        this.cPA = cwVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void b(View view, String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.util.be.wt().c(this.cPA.cNL.getPageContext(), new String[]{str});
        }
    }
}
