package com.baidu.wallet.lightapp.business.datamodel;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class ContactInfo implements Comparator<ContactInfo> {

    /* renamed from: a  reason: collision with root package name */
    public String f24813a;

    /* renamed from: b  reason: collision with root package name */
    public String f24814b;

    /* loaded from: classes5.dex */
    public static class Phone implements Serializable {
        public String number;
        public int type;

        public String getTypeName() {
            int i = this.type;
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 10 ? i != 12 ? "其他" : "主机" : "公司总机" : "家庭传真" : "工作传真" : "工作" : "手机" : "住宅" : "自定义";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ContactInfo contactInfo, ContactInfo contactInfo2) {
        if (contactInfo == null && contactInfo2 == null) {
            return 0;
        }
        if (contactInfo == null) {
            return contactInfo2 == null ? 0 : 1;
        } else if (contactInfo2 == null) {
            return contactInfo == null ? 0 : -1;
        } else {
            contactInfo.f24814b = a(contactInfo.f24813a);
            contactInfo2.f24814b = a(contactInfo2.f24813a);
            if (TextUtils.isEmpty(contactInfo.f24814b) && TextUtils.isEmpty(contactInfo2.f24814b)) {
                return 0;
            }
            if (TextUtils.isEmpty(contactInfo.f24814b)) {
                return !TextUtils.isEmpty(contactInfo2.f24814b) ? 1 : 0;
            }
            if (TextUtils.isEmpty(contactInfo2.f24814b)) {
                return TextUtils.isEmpty(contactInfo.f24814b) ? 0 : -1;
            }
            contactInfo.f24814b = contactInfo.f24814b.toUpperCase();
            String upperCase = contactInfo2.f24814b.toUpperCase();
            contactInfo2.f24814b = upperCase;
            if (contactInfo.f24814b.equals(upperCase)) {
                return 0;
            }
            if (contactInfo.f24814b.equals("#")) {
                return 1;
            }
            if (contactInfo2.f24814b.equals("#")) {
                return -1;
            }
            return contactInfo.f24814b.compareTo(contactInfo2.f24814b);
        }
    }

    public String a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 1 || !str.substring(0, 1).toUpperCase().matches("[A-Z]")) ? "#" : str;
    }
}
