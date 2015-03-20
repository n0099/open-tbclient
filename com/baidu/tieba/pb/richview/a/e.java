package com.baidu.tieba.pb.richview.a;

import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class e {
    public static final c c(Content content) {
        if (content.type.longValue() == 3) {
            return new d(content);
        }
        return null;
    }

    public static final b d(Content content) {
        if (content.type.longValue() == 2) {
            return new a(content);
        }
        if (content.type.longValue() == 0) {
            return new f(content);
        }
        return null;
    }
}
