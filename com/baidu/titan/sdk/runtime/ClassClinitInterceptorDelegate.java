package com.baidu.titan.sdk.runtime;
/* loaded from: classes4.dex */
public abstract class ClassClinitInterceptorDelegate implements ClassClinitInterceptable {
    public volatile ClassClinitInterceptable delegate;

    @Override // com.baidu.titan.sdk.runtime.ClassClinitInterceptable
    public InterceptResult invokeClinit(int i, String str) {
        if (this.delegate == null) {
            waitLoad(i, str);
        }
        if (this.delegate == null) {
            return null;
        }
        return this.delegate.invokeClinit(i, str);
    }

    @Override // com.baidu.titan.sdk.runtime.ClassClinitInterceptable
    public InterceptResult invokePostClinit(int i, String str) {
        if (this.delegate == null) {
            waitLoad(i, str);
        }
        if (this.delegate == null) {
            return null;
        }
        return this.delegate.invokePostClinit(i, str);
    }

    public abstract boolean waitLoad(int i, String str);
}
