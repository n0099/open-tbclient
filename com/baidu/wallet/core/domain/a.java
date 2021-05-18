package com.baidu.wallet.core.domain;
/* loaded from: classes5.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23930a = "life_host";

    /* renamed from: b  reason: collision with root package name */
    public static final String f23931b = "xinyongka_host";

    /* renamed from: c  reason: collision with root package name */
    public static final String f23932c = "nfc_host";

    /* renamed from: d  reason: collision with root package name */
    public static final String f23933d = "app_host";

    /* renamed from: e  reason: collision with root package name */
    public static final String f23934e = "dxm_host";

    /* renamed from: f  reason: collision with root package name */
    public static final String f23935f = "zhifu_host";

    /* renamed from: g  reason: collision with root package name */
    public static final String f23936g = "comet_host";

    /* renamed from: h  reason: collision with root package name */
    public static final String f23937h = "my_host";

    String getAppHost();

    String getAppPayHost();

    String getCOHost();

    String getCometHost();

    String getCreditCardHost();

    String getInitHost(boolean z);

    String getLifeHost();

    String getMHost();

    String getMyHost();

    String getNfcHost();

    String getQianbaoHost();

    String getWebCacheHost();

    String getZhiFuHost();

    void setDomainConfig(String str);
}
