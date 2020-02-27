package com.baidu.tieba.recapp.download.http;

import java.io.IOException;
/* loaded from: classes13.dex */
public class BdHttpCancelException extends IOException {
    private static final long serialVersionUID = 6712119810502114101L;

    public BdHttpCancelException() {
        super("request cancelled.");
    }

    public BdHttpCancelException(String str) {
        super(str);
    }

    public BdHttpCancelException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
