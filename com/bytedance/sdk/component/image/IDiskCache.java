package com.bytedance.sdk.component.image;

import com.bytedance.sdk.component.image.c.a.a;
import java.io.InputStream;
/* loaded from: classes9.dex */
public interface IDiskCache extends a<String, byte[]> {
    InputStream getCacheStream(String str);

    boolean remove(String str);

    boolean removeForce(String str);
}
