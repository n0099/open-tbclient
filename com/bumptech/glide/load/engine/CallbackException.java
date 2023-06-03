package com.bumptech.glide.load.engine;
/* loaded from: classes9.dex */
public final class CallbackException extends RuntimeException {
    public static final long serialVersionUID = -7530898992688511851L;

    public CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
