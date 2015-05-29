package com.baidu.tieba.pb.d.a;

import android.text.SpannableString;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class b implements d {
    private SpannableString bQD;
    private TbPageContext<?> pageContext;
    private String url;

    public b(TbPageContext<?> tbPageContext, Content content) {
        if (content != null && content.type.longValue() == 1 && !StringUtils.isNull(content.text)) {
            this.pageContext = tbPageContext;
            this.bQD = new SpannableString(content.text);
            this.bQD.setSpan(new c(this, null), 0, content.text.length(), 17);
            this.url = content.link;
        }
    }

    @Override // com.baidu.tieba.pb.d.a.e
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public CharSequence adM() {
        return this.bQD;
    }
}
