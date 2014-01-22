package com.baidu.tieba.pb;
/* loaded from: classes.dex */
public class PbEditorCacheModel {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum OP_TYPE {
        GET,
        SET
    }

    public static void a(String str, cl clVar) {
        if (!com.baidu.tieba.util.bu.c(str)) {
            new ck(OP_TYPE.GET, str, clVar, null).execute(new String[0]);
        }
    }

    public static void a(String str, String str2, cl clVar) {
        if (!com.baidu.tieba.util.bu.c(str)) {
            new ck(OP_TYPE.SET, str, clVar, str2).execute(new String[0]);
        }
    }
}
