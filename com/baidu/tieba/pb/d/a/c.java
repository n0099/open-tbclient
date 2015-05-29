package com.baidu.tieba.pb.d.a;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends ClickableSpan {
    final /* synthetic */ b bQE;

    private c(b bVar) {
        this.bQE = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(b bVar, c cVar) {
        this(bVar);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        String str;
        bi tO = bi.tO();
        tbPageContext = this.bQE.pageContext;
        str = this.bQE.url;
        tO.b(tbPageContext, new String[]{str});
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
