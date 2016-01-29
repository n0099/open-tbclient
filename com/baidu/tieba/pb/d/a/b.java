package com.baidu.tieba.pb.d.a;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class b implements c {
    private SpannableString cVa;
    private TbPageContext<?> pageContext;
    private String url;

    public b(TbPageContext<?> tbPageContext, ExcContent excContent) {
        if (excContent != null && excContent.type.longValue() == 1 && !StringUtils.isNull(excContent.text)) {
            this.pageContext = tbPageContext;
            this.cVa = new SpannableString(excContent.text);
            this.cVa.setSpan(new a(this, null), 0, excContent.text.length(), 17);
            this.url = excContent.link;
        }
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tieba.pb.d.a.c
    public CharSequence asP() {
        return this.cVa;
    }

    /* loaded from: classes.dex */
    private class a extends ClickableSpan {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            be.wt().c(b.this.pageContext, new String[]{b.this.url});
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    @Override // com.baidu.tieba.pb.d.a.c
    public boolean asQ() {
        return false;
    }
}
