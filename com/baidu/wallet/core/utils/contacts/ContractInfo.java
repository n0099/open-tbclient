package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24022a;

    /* renamed from: b  reason: collision with root package name */
    public String f24023b;

    /* renamed from: c  reason: collision with root package name */
    public int f24024c;

    public ContractInfo() {
        this.f24022a = "";
        this.f24023b = "";
        this.f24024c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24023b;
            if (str == null) {
                if (contractInfo.f24023b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24023b)) {
                return false;
            }
            String str2 = this.f24022a;
            if (str2 == null) {
                if (contractInfo.f24022a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24022a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24024c;
    }

    public String getMobile() {
        return this.f24023b;
    }

    public String getName() {
        return this.f24022a;
    }

    public int hashCode() {
        String str = this.f24023b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24022a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i) {
        this.f24024c = i;
    }

    public void setMobile(String str) {
        this.f24023b = str;
    }

    public void setName(String str) {
        this.f24022a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24022a + ", mobile=" + this.f24023b + "]";
    }

    public ContractInfo(String str) {
        this.f24022a = "";
        this.f24023b = "";
        this.f24024c = -1;
        this.f24023b = str;
        this.f24022a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24022a = "";
        this.f24023b = "";
        this.f24024c = -1;
        this.f24023b = str;
        this.f24022a = str2;
    }
}
