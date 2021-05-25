package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f23945a;

    /* renamed from: b  reason: collision with root package name */
    public String f23946b;

    /* renamed from: c  reason: collision with root package name */
    public int f23947c;

    public ContractInfo() {
        this.f23945a = "";
        this.f23946b = "";
        this.f23947c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f23946b;
            if (str == null) {
                if (contractInfo.f23946b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f23946b)) {
                return false;
            }
            String str2 = this.f23945a;
            if (str2 == null) {
                if (contractInfo.f23945a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f23945a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f23947c;
    }

    public String getMobile() {
        return this.f23946b;
    }

    public String getName() {
        return this.f23945a;
    }

    public int hashCode() {
        String str = this.f23946b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f23945a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i2) {
        this.f23947c = i2;
    }

    public void setMobile(String str) {
        this.f23946b = str;
    }

    public void setName(String str) {
        this.f23945a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f23945a + ", mobile=" + this.f23946b + "]";
    }

    public ContractInfo(String str) {
        this.f23945a = "";
        this.f23946b = "";
        this.f23947c = -1;
        this.f23946b = str;
        this.f23945a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f23945a = "";
        this.f23946b = "";
        this.f23947c = -1;
        this.f23946b = str;
        this.f23945a = str2;
    }
}
