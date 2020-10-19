package com.baidu.tieba.pb.b.a;

import com.baidu.tbadk.TbPageContext;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes23.dex */
public class f {
    public static final d c(ExcContent excContent) {
        if (excContent == null || excContent.type == null || !excContent.type.equals(3L)) {
            return null;
        }
        return new e(excContent);
    }

    public static final c a(TbPageContext<?> tbPageContext, ExcContent excContent) {
        if (excContent == null || excContent.type == null) {
            return null;
        }
        if (excContent.type.longValue() == 2) {
            return new a(excContent);
        }
        if (excContent.type.longValue() == 0) {
            return new g(tbPageContext.getPageActivity(), excContent);
        }
        if (excContent.type.longValue() == 1) {
            return new b(tbPageContext, excContent);
        }
        return null;
    }
}
