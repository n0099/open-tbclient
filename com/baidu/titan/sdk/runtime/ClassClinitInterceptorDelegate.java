package com.baidu.titan.sdk.runtime;
/* loaded from: classes11.dex */
public abstract class ClassClinitInterceptorDelegate implements ClassClinitInterceptable {
    public volatile ClassClinitInterceptable delegate;

    @Override // com.baidu.titan.sdk.runtime.ClassClinitInterceptable
    public InterceptResult invokeClinit(int i2, String str) {
        if (this.delegate == null) {
            waitLoad(i2, str);
        }
        if (this.delegate == null) {
            return null;
        }
        return this.delegate.invokeClinit(i2, str);
    }

    @Override // com.baidu.titan.sdk.runtime.ClassClinitInterceptable
    public InterceptResult invokePostClinit(int i2, String str) {
        if (this.delegate == null) {
            waitLoad(i2, str);
        }
        if (this.delegate == null) {
            return null;
        }
        return this.delegate.invokePostClinit(i2, str);
    }

    public abstract boolean waitLoad(int i2, String str);
}
