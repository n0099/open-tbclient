package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.util.h {
    final /* synthetic */ k fud;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, Context context) {
        super(context);
        this.fud = kVar;
    }

    @Override // com.baidu.tbadk.util.h, android.text.style.ClickableSpan
    public void onClick(View view) {
        Pattern pattern;
        String str;
        Pattern pattern2;
        String str2;
        String str3;
        pattern = k.pbPattern0;
        str = this.fud.link;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                gc(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pattern2 = k.fuc;
        str2 = this.fud.link;
        Matcher matcher2 = pattern2.matcher(str2);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                gc(group2.substring(group2.lastIndexOf("=") + 1));
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        str3 = this.fud.link;
        gb(str3);
    }
}
