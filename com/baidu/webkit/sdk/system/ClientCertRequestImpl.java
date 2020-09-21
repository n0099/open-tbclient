package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import com.baidu.webkit.sdk.ClientCertRequest;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
@TargetApi(21)
/* loaded from: classes8.dex */
final class ClientCertRequestImpl extends ClientCertRequest {
    private final android.webkit.ClientCertRequest mRequest;

    private ClientCertRequestImpl(android.webkit.ClientCertRequest clientCertRequest) {
        this.mRequest = clientCertRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClientCertRequest from(android.webkit.ClientCertRequest clientCertRequest) {
        if (clientCertRequest == null) {
            return null;
        }
        return new ClientCertRequestImpl(clientCertRequest);
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final void cancel() {
        this.mRequest.cancel();
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final String getHost() {
        return this.mRequest.getHost();
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final String[] getKeyTypes() {
        return this.mRequest.getKeyTypes();
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final int getPort() {
        return this.mRequest.getPort();
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final Principal[] getPrincipals() {
        return this.mRequest.getPrincipals();
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final void ignore() {
        this.mRequest.ignore();
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        this.mRequest.proceed(privateKey, x509CertificateArr);
    }
}
