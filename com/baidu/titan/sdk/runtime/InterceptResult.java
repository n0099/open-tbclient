package com.baidu.titan.sdk.runtime;

import com.baidu.titan.sdk.runtime.annotation.DisableIntercept;
@DisableIntercept
/* loaded from: classes6.dex */
public class InterceptResult {
    public static final int MAX_POOL_SIZE = 50;
    public static InterceptResult sPool;
    public static int sPoolSize;
    public static final Object sPoolSync = new Object();
    public boolean booleanValue;
    public byte byteValue;
    public char charValue;
    public double doubleValue;
    public int flags;
    public float floatValue;
    public int intValue;
    public Interceptable interceptor;
    public long longValue;
    public InterceptResult next;
    public Object objValue;
    public short shortValue;

    public static InterceptResult obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                InterceptResult interceptResult = sPool;
                sPool = interceptResult.next;
                interceptResult.next = null;
                sPoolSize--;
                return interceptResult;
            }
            return new InterceptResult();
        }
    }

    public void recycle() {
        this.objValue = null;
        this.interceptor = null;
        synchronized (sPoolSync) {
            if (sPoolSize < 50) {
                this.next = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }
}
