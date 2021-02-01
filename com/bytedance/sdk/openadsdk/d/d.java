package com.bytedance.sdk.openadsdk.d;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.Locale;
/* loaded from: classes6.dex */
public enum d implements e {
    IDENTITY { // from class: com.bytedance.sdk.openadsdk.d.d.1
        @Override // com.bytedance.sdk.openadsdk.d.e
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.bytedance.sdk.openadsdk.d.d.2
        @Override // com.bytedance.sdk.openadsdk.d.e
        public String a(Field field) {
            return a(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.bytedance.sdk.openadsdk.d.d.3
        @Override // com.bytedance.sdk.openadsdk.d.e
        public String a(Field field) {
            return a(a(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.bytedance.sdk.openadsdk.d.d.4
        @Override // com.bytedance.sdk.openadsdk.d.e
        public String a(Field field) {
            return a(field.getName(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.bytedance.sdk.openadsdk.d.d.5
        @Override // com.bytedance.sdk.openadsdk.d.e
        public String a(Field field) {
            return a(field.getName(), Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: com.bytedance.sdk.openadsdk.d.d.6
        @Override // com.bytedance.sdk.openadsdk.d.e
        public String a(Field field) {
            return a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String a(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char charAt = str.charAt(i);
        if (!Character.isUpperCase(charAt)) {
            char upperCase = Character.toUpperCase(charAt);
            if (i == 0) {
                return upperCase + str.substring(1);
            }
            return str.substring(0, i) + upperCase + str.substring(i + 1);
        }
        return str;
    }
}
