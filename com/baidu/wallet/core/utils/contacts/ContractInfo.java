package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24014a;

    /* renamed from: b  reason: collision with root package name */
    public String f24015b;

    /* renamed from: c  reason: collision with root package name */
    public int f24016c;

    public ContractInfo() {
        this.f24014a = "";
        this.f24015b = "";
        this.f24016c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24015b;
            if (str == null) {
                if (contractInfo.f24015b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24015b)) {
                return false;
            }
            String str2 = this.f24014a;
            if (str2 == null) {
                if (contractInfo.f24014a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24014a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24016c;
    }

    public String getMobile() {
        return this.f24015b;
    }

    public String getName() {
        return this.f24014a;
    }

    public int hashCode() {
        String str = this.f24015b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24014a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i) {
        this.f24016c = i;
    }

    public void setMobile(String str) {
        this.f24015b = str;
    }

    public void setName(String str) {
        this.f24014a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24014a + ", mobile=" + this.f24015b + "]";
    }

    public ContractInfo(String str) {
        this.f24014a = "";
        this.f24015b = "";
        this.f24016c = -1;
        this.f24015b = str;
        this.f24014a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24014a = "";
        this.f24015b = "";
        this.f24016c = -1;
        this.f24015b = str;
        this.f24014a = str2;
    }
}
