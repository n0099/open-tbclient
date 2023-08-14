package com.baidu.tieba;

import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public interface m5 extends a7 {
    @Override // com.baidu.tieba.a7
    void dispose();

    int e();

    ShortBuffer getBuffer();

    void invalidate();
}
