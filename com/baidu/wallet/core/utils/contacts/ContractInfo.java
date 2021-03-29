package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24329a;

    /* renamed from: b  reason: collision with root package name */
    public String f24330b;

    /* renamed from: c  reason: collision with root package name */
    public int f24331c;

    public ContractInfo() {
        this.f24329a = "";
        this.f24330b = "";
        this.f24331c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24330b;
            if (str == null) {
                if (contractInfo.f24330b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24330b)) {
                return false;
            }
            String str2 = this.f24329a;
            if (str2 == null) {
                if (contractInfo.f24329a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24329a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24331c;
    }

    public String getMobile() {
        return this.f24330b;
    }

    public String getName() {
        return this.f24329a;
    }

    public int hashCode() {
        String str = this.f24330b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24329a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i) {
        this.f24331c = i;
    }

    public void setMobile(String str) {
        this.f24330b = str;
    }

    public void setName(String str) {
        this.f24329a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24329a + ", mobile=" + this.f24330b + "]";
    }

    public ContractInfo(String str) {
        this.f24329a = "";
        this.f24330b = "";
        this.f24331c = -1;
        this.f24330b = str;
        this.f24329a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24329a = "";
        this.f24330b = "";
        this.f24331c = -1;
        this.f24330b = str;
        this.f24329a = str2;
    }
}
