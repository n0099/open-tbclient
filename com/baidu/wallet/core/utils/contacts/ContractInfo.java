package com.baidu.wallet.core.utils.contacts;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes5.dex */
public class ContractInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f24130a;

    /* renamed from: b  reason: collision with root package name */
    public String f24131b;

    /* renamed from: c  reason: collision with root package name */
    public int f24132c;

    public ContractInfo() {
        this.f24130a = "";
        this.f24131b = "";
        this.f24132c = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContractInfo.class == obj.getClass()) {
            ContractInfo contractInfo = (ContractInfo) obj;
            String str = this.f24131b;
            if (str == null) {
                if (contractInfo.f24131b != null) {
                    return false;
                }
            } else if (!str.equals(contractInfo.f24131b)) {
                return false;
            }
            String str2 = this.f24130a;
            if (str2 == null) {
                if (contractInfo.f24130a != null) {
                    return false;
                }
            } else if (!str2.equals(contractInfo.f24130a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getErrordigit() {
        return this.f24132c;
    }

    public String getMobile() {
        return this.f24131b;
    }

    public String getName() {
        return this.f24130a;
    }

    public int hashCode() {
        String str = this.f24131b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f24130a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setErrordigit(int i2) {
        this.f24132c = i2;
    }

    public void setMobile(String str) {
        this.f24131b = str;
    }

    public void setName(String str) {
        this.f24130a = str;
    }

    public String toString() {
        return "通讯录 [name=" + this.f24130a + ", mobile=" + this.f24131b + PreferencesUtil.RIGHT_MOUNT;
    }

    public ContractInfo(String str) {
        this.f24130a = "";
        this.f24131b = "";
        this.f24132c = -1;
        this.f24131b = str;
        this.f24130a = "";
    }

    public ContractInfo(String str, String str2) {
        this.f24130a = "";
        this.f24131b = "";
        this.f24132c = -1;
        this.f24131b = str;
        this.f24130a = str2;
    }
}
