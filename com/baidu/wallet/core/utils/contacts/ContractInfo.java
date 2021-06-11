package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24048a;

    /* renamed from: b  reason: collision with root package name */
    public String f24049b;

    /* renamed from: c  reason: collision with root package name */
    public int f24050c;

    public ContractInfo() {
        this.f24048a = "";
        this.f24049b = "";
        this.f24050c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24049b;
            if (str == null) {
                if (contractInfo.f24049b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24049b)) {
                return false;
            }
            String str2 = this.f24048a;
            if (str2 == null) {
                if (contractInfo.f24048a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24048a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24050c;
    }

    public String getMobile() {
        return this.f24049b;
    }

    public String getName() {
        return this.f24048a;
    }

    public int hashCode() {
        String str = this.f24049b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24048a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i2) {
        this.f24050c = i2;
    }

    public void setMobile(String str) {
        this.f24049b = str;
    }

    public void setName(String str) {
        this.f24048a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24048a + ", mobile=" + this.f24049b + "]";
    }

    public ContractInfo(String str) {
        this.f24048a = "";
        this.f24049b = "";
        this.f24050c = -1;
        this.f24049b = str;
        this.f24048a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24048a = "";
        this.f24049b = "";
        this.f24050c = -1;
        this.f24049b = str;
        this.f24048a = str2;
    }
}
