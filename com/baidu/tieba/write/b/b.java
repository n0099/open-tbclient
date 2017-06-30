package com.baidu.tieba.write.b;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a gha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.gha = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        textView = this.gha.ggX;
        if (view == textView) {
            this.gha.b(new com.baidu.tbadk.editortools.a(51, -1, null));
        }
    }
}
