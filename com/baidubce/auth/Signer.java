package com.baidubce.auth;

import com.baidubce.internal.InternalRequest;
/* loaded from: classes25.dex */
public interface Signer {
    void sign(InternalRequest internalRequest, BceCredentials bceCredentials);

    void sign(InternalRequest internalRequest, BceCredentials bceCredentials, SignOptions signOptions);
}
