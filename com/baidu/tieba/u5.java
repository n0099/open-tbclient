package com.baidu.tieba;

import java.nio.FloatBuffer;
/* loaded from: classes8.dex */
public interface u5 extends b7 {
    n3 b();

    int c();

    @Override // com.baidu.tieba.b7
    void dispose();

    FloatBuffer getBuffer();

    void invalidate();
}
