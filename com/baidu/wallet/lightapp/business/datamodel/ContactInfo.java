package com.baidu.wallet.lightapp.business.datamodel;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class ContactInfo implements Comparator<ContactInfo> {

    /* renamed from: a  reason: collision with root package name */
    public String f24854a;

    /* renamed from: b  reason: collision with root package name */
    public String f24855b;

    /* loaded from: classes5.dex */
    public static class Phone implements Serializable {
        public String number;
        public int type;

        public String getTypeName() {
            int i2 = this.type;
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 10 ? i2 != 12 ? "其他" : "主机" : "公司总机" : "家庭传真" : "工作传真" : "工作" : "手机" : "住宅" : "自定义";
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
            contactInfo.f24855b = a(contactInfo.f24854a);
            contactInfo2.f24855b = a(contactInfo2.f24854a);
            if (TextUtils.isEmpty(contactInfo.f24855b) && TextUtils.isEmpty(contactInfo2.f24855b)) {
                return 0;
            }
            if (TextUtils.isEmpty(contactInfo.f24855b)) {
                return !TextUtils.isEmpty(contactInfo2.f24855b) ? 1 : 0;
            }
            if (TextUtils.isEmpty(contactInfo2.f24855b)) {
                return TextUtils.isEmpty(contactInfo.f24855b) ? 0 : -1;
            }
            contactInfo.f24855b = contactInfo.f24855b.toUpperCase();
            String upperCase = contactInfo2.f24855b.toUpperCase();
            contactInfo2.f24855b = upperCase;
            if (contactInfo.f24855b.equals(upperCase)) {
                return 0;
            }
            if (contactInfo.f24855b.equals("#")) {
                return 1;
            }
            if (contactInfo2.f24855b.equals("#")) {
                return -1;
            }
            return contactInfo.f24855b.compareTo(contactInfo2.f24855b);
        }
    }

    public String a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 1 || !str.substring(0, 1).toUpperCase().matches("[A-Z]")) ? "#" : str;
    }
}
