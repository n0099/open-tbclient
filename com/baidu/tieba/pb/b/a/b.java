package com.baidu.tieba.pb.b.a;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bd;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes17.dex */
public class b implements c {
    private SpannableString kEh;
    private TbPageContext<?> pageContext;
    private String url;

    public b(TbPageContext<?> tbPageContext, ExcContent excContent) {
        if (excContent != null && excContent.type.longValue() == 1 && !StringUtils.isNull(excContent.text)) {
            this.pageContext = tbPageContext;
            this.kEh = new SpannableString(excContent.text);
            this.kEh.setSpan(new a(), 0, excContent.text.length(), 17);
            this.url = excContent.link;
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cSz() {
        return this.kEh;
    }

    /* loaded from: classes17.dex */
    private class a extends ClickableSpan {
        private a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            bd.baV().b(b.this.pageContext, new String[]{b.this.url});
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cSA() {
        return false;
    }
}
