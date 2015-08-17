package com.baidu.tieba.pb.c.a;

import com.baidu.tbadk.TbPageContext;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class f {
    public static final d c(Content content) {
        if (content == null || content.type == null || content.type.longValue() != 3) {
            return null;
        }
        return new e(content);
    }

    public static final c a(TbPageContext<?> tbPageContext, Content content) {
        if (content == null || content.type == null) {
            return null;
        }
        if (content.type.longValue() == 2) {
            return new a(content);
        }
        if (content.type.longValue() == 0) {
            return new g(tbPageContext.getPageActivity(), content);
        }
        if (content.type.longValue() == 1) {
            return new b(tbPageContext, content);
        }
        return null;
    }
}
