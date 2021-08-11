package com.bytedance.sdk.component.b.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes9.dex */
public interface e extends s, ReadableByteChannel {
    long a(byte b2) throws IOException;

    String a(Charset charset) throws IOException;

    void a(long j2) throws IOException;

    void a(byte[] bArr) throws IOException;

    boolean a(long j2, f fVar) throws IOException;

    @Deprecated
    c c();

    f c(long j2) throws IOException;

    String e(long j2) throws IOException;

    boolean e() throws IOException;

    InputStream f();

    byte[] g(long j2) throws IOException;

    byte h() throws IOException;

    void h(long j2) throws IOException;

    short i() throws IOException;

    int j() throws IOException;

    short k() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    String p() throws IOException;

    byte[] q() throws IOException;
}
