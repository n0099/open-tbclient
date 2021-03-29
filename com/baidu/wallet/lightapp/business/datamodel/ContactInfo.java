package com.baidu.wallet.lightapp.business.datamodel;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class ContactInfo implements Comparator<ContactInfo> {

    /* renamed from: a  reason: collision with root package name */
    public String f25120a;

    /* renamed from: b  reason: collision with root package name */
    public String f25121b;

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
            contactInfo.f25121b = a(contactInfo.f25120a);
            contactInfo2.f25121b = a(contactInfo2.f25120a);
            if (TextUtils.isEmpty(contactInfo.f25121b) && TextUtils.isEmpty(contactInfo2.f25121b)) {
                return 0;
            }
            if (TextUtils.isEmpty(contactInfo.f25121b)) {
                return !TextUtils.isEmpty(contactInfo2.f25121b) ? 1 : 0;
            }
            if (TextUtils.isEmpty(contactInfo2.f25121b)) {
                return TextUtils.isEmpty(contactInfo.f25121b) ? 0 : -1;
            }
            contactInfo.f25121b = contactInfo.f25121b.toUpperCase();
            String upperCase = contactInfo2.f25121b.toUpperCase();
            contactInfo2.f25121b = upperCase;
            if (contactInfo.f25121b.equals(upperCase)) {
                return 0;
            }
            if (contactInfo.f25121b.equals("#")) {
                return 1;
            }
            if (contactInfo2.f25121b.equals("#")) {
                return -1;
            }
            return contactInfo.f25121b.compareTo(contactInfo2.f25121b);
        }
    }

    public String a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 1 || !str.substring(0, 1).toUpperCase().matches("[A-Z]")) ? "#" : str;
    }
}
