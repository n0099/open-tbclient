package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public interface e extends s, ReadableByteChannel {
    void a(long j) throws IOException;

    void a(byte[] bArr) throws IOException;

    boolean a(long j, f fVar) throws IOException;

    String b(Charset charset) throws IOException;

    long e(byte b2) throws IOException;

    String e(long j) throws IOException;

    boolean e() throws IOException;

    @Deprecated
    c elX();

    InputStream elZ();

    byte ema() throws IOException;

    short emb() throws IOException;

    short emc() throws IOException;

    void h(long j) throws IOException;

    /* renamed from: if */
    f mo54if(long j) throws IOException;

    byte[] ih(long j) throws IOException;

    int j() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    String p() throws IOException;
}
