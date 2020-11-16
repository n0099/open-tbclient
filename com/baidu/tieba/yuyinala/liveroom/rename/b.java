package com.baidu.tieba.yuyinala.liveroom.rename;

import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {
    public static int v(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        Pattern compile = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);
        int i = 0;
        while (compile.matcher(charSequence).find()) {
            i++;
        }
        for (String str : compile.split(charSequence)) {
            i += str.length();
        }
        return i;
    }
}
