package com.baidu.tieba.pb.c.a;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.az;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class b implements c {
    private SpannableString cnH;
    private TbPageContext<?> pageContext;
    private String url;

    public b(TbPageContext<?> tbPageContext, Content content) {
        if (content != null && content.type.longValue() == 1 && !StringUtils.isNull(content.text)) {
            this.pageContext = tbPageContext;
            this.cnH = new SpannableString(content.text);
            this.cnH.setSpan(new a(this, null), 0, content.text.length(), 17);
            this.url = content.link;
        }
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence ahQ() {
        return this.cnH;
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
            az.uW().b(b.this.pageContext, new String[]{b.this.url});
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean ahR() {
        return false;
    }
}
