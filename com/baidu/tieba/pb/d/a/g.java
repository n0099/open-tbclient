package com.baidu.tieba.pb.d.a;

import com.baidu.tbadk.TbPageContext;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class g {
    public static final e c(Content content) {
        if (content == null || content.type == null || content.type.longValue() != 3) {
            return null;
        }
        return new f(content);
    }

    public static final d a(TbPageContext<?> tbPageContext, Content content) {
        if (content == null || content.type == null) {
            return null;
        }
        if (content.type.longValue() == 2) {
            return new a(content);
        }
        if (content.type.longValue() == 0) {
            return new h(content);
        }
        if (content.type.longValue() == 1) {
            return new b(tbPageContext, content);
        }
        return null;
    }
}
