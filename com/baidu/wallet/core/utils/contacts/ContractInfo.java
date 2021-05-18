package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24016a;

    /* renamed from: b  reason: collision with root package name */
    public String f24017b;

    /* renamed from: c  reason: collision with root package name */
    public int f24018c;

    public ContractInfo() {
        this.f24016a = "";
        this.f24017b = "";
        this.f24018c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24017b;
            if (str == null) {
                if (contractInfo.f24017b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24017b)) {
                return false;
            }
            String str2 = this.f24016a;
            if (str2 == null) {
                if (contractInfo.f24016a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24016a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24018c;
    }

    public String getMobile() {
        return this.f24017b;
    }

    public String getName() {
        return this.f24016a;
    }

    public int hashCode() {
        String str = this.f24017b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24016a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i2) {
        this.f24018c = i2;
    }

    public void setMobile(String str) {
        this.f24017b = str;
    }

    public void setName(String str) {
        this.f24016a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24016a + ", mobile=" + this.f24017b + "]";
    }

    public ContractInfo(String str) {
        this.f24016a = "";
        this.f24017b = "";
        this.f24018c = -1;
        this.f24017b = str;
        this.f24016a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24016a = "";
        this.f24017b = "";
        this.f24018c = -1;
        this.f24017b = str;
        this.f24016a = str2;
    }
}
