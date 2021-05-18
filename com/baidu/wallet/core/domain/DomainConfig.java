package com.baidu.wallet.core.domain;
/* loaded from: classes5.dex */
public class DomainConfig implements com.baidu.wallet.core.domain.a {

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.wallet.core.domain.a f23927i;
    public com.baidu.wallet.core.domain.a j;
    public com.baidu.wallet.core.domain.a k;

    /* renamed from: com.baidu.wallet.core.domain.DomainConfig$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23928a;

        static {
            int[] iArr = new int[DomainStrategyType.values().length];
            f23928a = iArr;
            try {
                iArr[DomainStrategyType.QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23928a[DomainStrategyType.ONLINE.ordinal()] = 2;
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
        public static final DomainConfig f23929a = new DomainConfig(null);
    }

    public /* synthetic */ DomainConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static DomainConfig getInstance() {
        return a.f23929a;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost() {
        return this.f23927i.getAppHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        return this.f23927i.getAppPayHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        return this.f23927i.getCOHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        return this.f23927i.getCometHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        return this.f23927i.getCreditCardHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        return this.f23927i.getInitHost(z);
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        return this.f23927i.getLifeHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        return this.f23927i.getMHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        return this.f23927i.getMyHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        return this.f23927i.getNfcHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        return this.f23927i.getQianbaoHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        return this.f23927i.getWebCacheHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        return this.f23927i.getZhiFuHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        com.baidu.wallet.core.domain.a aVar = this.f23927i;
        if (aVar != null) {
            aVar.setDomainConfig(str);
        }
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        int i2 = AnonymousClass1.f23928a[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.f23927i = this.k;
        } else if (i2 != 2) {
        } else {
            this.f23927i = this.j;
        }
    }

    public DomainConfig() {
        this.j = new b();
        this.k = c.a();
        this.f23927i = this.j;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        int i2 = AnonymousClass1.f23928a[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.f23927i = this.k;
        } else if (i2 == 2) {
            this.f23927i = this.j;
        }
        this.f23927i.setDomainConfig(str);
    }
}
