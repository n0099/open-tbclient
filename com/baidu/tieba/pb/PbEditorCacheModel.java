package com.baidu.tieba.pb;
/* loaded from: classes.dex */
public class PbEditorCacheModel {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum OP_TYPE {
        GET,
        SET
    }

    public static void a(String str, ck ckVar) {
        if (!com.baidu.tieba.util.be.c(str)) {
            new cj(OP_TYPE.GET, str, ckVar, null).execute(new String[0]);
        }
    }

    public static void a(String str, String str2, ck ckVar) {
        if (!com.baidu.tieba.util.be.c(str)) {
            new cj(OP_TYPE.SET, str, ckVar, str2).execute(new String[0]);
        }
    }
}
