package com.baidu.video.download;

import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class StringUtil {
    public static String bytes2String(byte[] bArr) {
        try {
            return new String(bArr, "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
