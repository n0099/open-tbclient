package com.baidu.ubc;

import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class ad {
    public abstract void close();

    public abstract String getBody() throws IOException;

    public abstract String getMessage();

    public abstract boolean isSuccessful();
}
