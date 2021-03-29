package com.baidu.wallet.core.domain;
/* loaded from: classes5.dex */
public class DomainConfig implements com.baidu.wallet.core.domain.a {
    public com.baidu.wallet.core.domain.a i;
    public com.baidu.wallet.core.domain.a j;
    public com.baidu.wallet.core.domain.a k;

    /* renamed from: com.baidu.wallet.core.domain.DomainConfig$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24244a;

        static {
            int[] iArr = new int[DomainStrategyType.values().length];
            f24244a = iArr;
            try {
                iArr[DomainStrategyType.QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24244a[DomainStrategyType.ONLINE.ordinal()] = 2;
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
        public static final DomainConfig f24245a = new DomainConfig(null);
    }

    public /* synthetic */ DomainConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static DomainConfig getInstance() {
        return a.f24245a;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost() {
        return this.i.getAppHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        return this.i.getAppPayHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        return this.i.getCOHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        return this.i.getCometHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        return this.i.getCreditCardHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        return this.i.getInitHost(z);
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        return this.i.getLifeHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        return this.i.getMHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        return this.i.getMyHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        return this.i.getNfcHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        return this.i.getQianbaoHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        return this.i.getWebCacheHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        return this.i.getZhiFuHost();
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        com.baidu.wallet.core.domain.a aVar = this.i;
        if (aVar != null) {
            aVar.setDomainConfig(str);
        }
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        int i = AnonymousClass1.f24244a[domainStrategyType.ordinal()];
        if (i == 1) {
            this.i = this.k;
        } else if (i != 2) {
        } else {
            this.i = this.j;
        }
    }

    public DomainConfig() {
        this.j = new b();
        this.k = c.a();
        this.i = this.j;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        int i = AnonymousClass1.f24244a[domainStrategyType.ordinal()];
        if (i == 1) {
            this.i = this.k;
        } else if (i == 2) {
            this.i = this.j;
        }
        this.i.setDomainConfig(str);
    }
}
