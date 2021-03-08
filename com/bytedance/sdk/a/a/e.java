package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public interface e extends s, ReadableByteChannel {
    void a(long j) throws IOException;

    void a(byte[] bArr) throws IOException;

    boolean a(long j, f fVar) throws IOException;

    String b(Charset charset) throws IOException;

    long e(byte b) throws IOException;

    String e(long j) throws IOException;

    boolean e() throws IOException;

    @Deprecated
    c eoG();

    InputStream eoI();

    byte eoJ() throws IOException;

    short eoK() throws IOException;

    short eoL() throws IOException;

    void h(long j) throws IOException;

    f ii(long j) throws IOException;

    byte[] ik(long j) throws IOException;

    int j() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    String p() throws IOException;
}
