package com.baidu.wallet.core.domain;

import androidx.annotation.NonNull;
/* loaded from: classes11.dex */
public interface a {
    public static final String a = "life_host";

    /* renamed from: b  reason: collision with root package name */
    public static final String f52392b = "xinyongka_host";

    /* renamed from: c  reason: collision with root package name */
    public static final String f52393c = "nfc_host";

    /* renamed from: d  reason: collision with root package name */
    public static final String f52394d = "app_host";

    /* renamed from: e  reason: collision with root package name */
    public static final String f52395e = "dxm_host";

    /* renamed from: f  reason: collision with root package name */
    public static final String f52396f = "zhifu_host";

    /* renamed from: g  reason: collision with root package name */
    public static final String f52397g = "comet_host";

    /* renamed from: h  reason: collision with root package name */
    public static final String f52398h = "my_host";

    /* renamed from: i  reason: collision with root package name */
    public static final String f52399i = "init_host";

    /* renamed from: j  reason: collision with root package name */
    public static final String f52400j = "sensors_host";

    /* renamed from: k  reason: collision with root package name */
    public static final String f52401k = "hawking_host";
    public static final String l = "net_check_host";

    String getAppHost(@NonNull Boolean[] boolArr);

    String getAppPayHost(@NonNull Boolean[] boolArr);

    String getCOHost(@NonNull Boolean[] boolArr);

    String getCometHost(@NonNull Boolean[] boolArr);

    String getCreditCardHost(@NonNull Boolean[] boolArr);

    String getHawkinghost(@NonNull Boolean[] boolArr);

    String getInitHost(int i2, @NonNull Boolean[] boolArr);

    String getLifeHost(@NonNull Boolean[] boolArr);

    String getMHost(@NonNull Boolean[] boolArr);

    String getMyHost(@NonNull Boolean[] boolArr);

    String getNetcheckhost(@NonNull Boolean[] boolArr);

    String getNfcHost(@NonNull Boolean[] boolArr);

    String getQianbaoHost(@NonNull Boolean[] boolArr);

    String getSensorhost(@NonNull Boolean[] boolArr);

    String getWebCacheHost(@NonNull Boolean[] boolArr);

    String getZhiFuHost(@NonNull Boolean[] boolArr);

    void setDomainConfig(String str);
}
