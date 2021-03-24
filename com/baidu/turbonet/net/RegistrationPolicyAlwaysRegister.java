package com.baidu.turbonet.net;

import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
/* loaded from: classes5.dex */
public class RegistrationPolicyAlwaysRegister extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {
    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void a() {
    }

    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        super.b(networkChangeNotifierAutoDetect);
        c();
    }
}
