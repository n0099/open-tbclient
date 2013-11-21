package com.baidu.tieba.pb;
/* loaded from: classes.dex */
public class PbEditorCacheModel {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum OP_TYPE {
        GET,
        SET
    }

    public static void a(String str, cm cmVar) {
        if (!com.baidu.tieba.util.be.c(str)) {
            new cl(OP_TYPE.GET, str, cmVar, null).execute(new String[0]);
        }
    }

    public static void a(String str, String str2, cm cmVar) {
        if (!com.baidu.tieba.util.be.c(str)) {
            new cl(OP_TYPE.SET, str, cmVar, str2).execute(new String[0]);
        }
    }
}
