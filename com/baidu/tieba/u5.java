package com.baidu.tieba;

import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public interface u5 extends i7 {
    @Override // com.baidu.tieba.i7
    void dispose();

    int e();

    ShortBuffer getBuffer();

    void invalidate();
}
