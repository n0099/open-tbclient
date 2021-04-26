package com.baidu.wallet.core.utils.contacts;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24771a;

    /* renamed from: b  reason: collision with root package name */
    public String f24772b;

    /* renamed from: c  reason: collision with root package name */
    public int f24773c;

    public ContractInfo() {
        this.f24771a = "";
        this.f24772b = "";
        this.f24773c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24772b;
            if (str == null) {
                if (contractInfo.f24772b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24772b)) {
                return false;
            }
            String str2 = this.f24771a;
            if (str2 == null) {
                if (contractInfo.f24771a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24771a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24773c;
    }

    public String getMobile() {
        return this.f24772b;
    }

    public String getName() {
        return this.f24771a;
    }

    public int hashCode() {
        String str = this.f24772b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24771a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i2) {
        this.f24773c = i2;
    }

    public void setMobile(String str) {
        this.f24772b = str;
    }

    public void setName(String str) {
        this.f24771a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24771a + ", mobile=" + this.f24772b + "]";
    }

    public ContractInfo(String str) {
        this.f24771a = "";
        this.f24772b = "";
        this.f24773c = -1;
        this.f24772b = str;
        this.f24771a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24771a = "";
        this.f24772b = "";
        this.f24773c = -1;
        this.f24772b = str;
        this.f24771a = str2;
    }
}
