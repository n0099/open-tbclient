package com.baidu.turbonet.net;

import java.nio.ByteBuffer;
/* loaded from: classes17.dex */
final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("ByteBuffer is already full.");
        }
    }
}
