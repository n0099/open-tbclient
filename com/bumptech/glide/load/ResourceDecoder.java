package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
/* loaded from: classes7.dex */
public interface ResourceDecoder {
    Resource decode(Object obj, int i, int i2, Options options) throws IOException;

    boolean handles(Object obj, Options options) throws IOException;
}
