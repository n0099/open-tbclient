package com.baidu.turbonet.net;

import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
/* loaded from: classes10.dex */
public class RegistrationPolicyAlwaysRegister extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void a(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        super.a(networkChangeNotifierAutoDetect);
        register();
    }

    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    protected void destroy() {
    }
}
