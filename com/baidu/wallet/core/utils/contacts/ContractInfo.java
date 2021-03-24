package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24328a;

    /* renamed from: b  reason: collision with root package name */
    public String f24329b;

    /* renamed from: c  reason: collision with root package name */
    public int f24330c;

    public ContractInfo() {
        this.f24328a = "";
        this.f24329b = "";
        this.f24330c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24329b;
            if (str == null) {
                if (contractInfo.f24329b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24329b)) {
                return false;
            }
            String str2 = this.f24328a;
            if (str2 == null) {
                if (contractInfo.f24328a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24328a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24330c;
    }

    public String getMobile() {
        return this.f24329b;
    }

    public String getName() {
        return this.f24328a;
    }

    public int hashCode() {
        String str = this.f24329b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24328a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i) {
        this.f24330c = i;
    }

    public void setMobile(String str) {
        this.f24329b = str;
    }

    public void setName(String str) {
        this.f24328a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24328a + ", mobile=" + this.f24329b + "]";
    }

    public ContractInfo(String str) {
        this.f24328a = "";
        this.f24329b = "";
        this.f24330c = -1;
        this.f24329b = str;
        this.f24328a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24328a = "";
        this.f24329b = "";
        this.f24330c = -1;
        this.f24329b = str;
        this.f24328a = str2;
    }
}
