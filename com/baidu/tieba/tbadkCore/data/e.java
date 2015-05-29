package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.h {
    final /* synthetic */ c csa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, Context context) {
        super(context);
        this.csa = cVar;
    }

    @Override // com.baidu.tbadk.util.h, android.text.style.ClickableSpan
    public void onClick(View view) {
        Pattern pattern;
        String str;
        Pattern pattern2;
        String str2;
        String str3;
        pattern = c.pbPattern0;
        str = this.csa.link;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                fi(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pattern2 = c.crZ;
        str2 = this.csa.link;
        Matcher matcher2 = pattern2.matcher(str2);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                fi(group2.substring(group2.lastIndexOf("=") + 1));
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        str3 = this.csa.link;
        fh(str3);
    }
}
