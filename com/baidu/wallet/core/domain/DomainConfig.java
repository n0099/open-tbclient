package com.baidu.wallet.core.domain;
/* loaded from: classes5.dex */
public class DomainConfig implements com.baidu.wallet.core.domain.a {

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.wallet.core.domain.a f23959i;
    public com.baidu.wallet.core.domain.a j;
    public com.baidu.wallet.core.domain.a k;

    /* renamed from: com.baidu.wallet.core.domain.DomainConfig$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23960a;

        static {
            int[] iArr = new int[DomainStrategyType.values().length];
            f23960a = iArr;
            try {
                iArr[DomainStrategyType.QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23960a[DomainStrategyType.ONLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum DomainStrategyType {
        ONLINE,
        QA
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final DomainConfig f23961a = new DomainConfig(null);
    }

    public /* synthetic */ DomainConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static DomainConfig getInstance() {
        return a.f23961a;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost() {
        return this.f23959i.getAppHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        return this.f23959i.getAppPayHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        return this.f23959i.getCOHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        return this.f23959i.getCometHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        return this.f23959i.getCreditCardHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        return this.f23959i.getInitHost(z);
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        return this.f23959i.getLifeHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        return this.f23959i.getMHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        return this.f23959i.getMyHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        return this.f23959i.getNfcHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        return this.f23959i.getQianbaoHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        return this.f23959i.getWebCacheHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        return this.f23959i.getZhiFuHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        com.baidu.wallet.core.domain.a aVar = this.f23959i;
        if (aVar != null) {
            aVar.setDomainConfig(str);
        }
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        int i2 = AnonymousClass1.f23960a[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.f23959i = this.k;
        } else if (i2 != 2) {
        } else {
            this.f23959i = this.j;
        }
    }

    public DomainConfig() {
        this.j = new b();
        this.k = c.a();
        this.f23959i = this.j;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        int i2 = AnonymousClass1.f23960a[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.f23959i = this.k;
        } else if (i2 == 2) {
            this.f23959i = this.j;
        }
        this.f23959i.setDomainConfig(str);
    }
}
