package com.baidu.tieba;

import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public interface n5 extends b7 {
    @Override // com.baidu.tieba.b7
    void dispose();

    int e();

    ShortBuffer getBuffer();

    void invalidate();
}
