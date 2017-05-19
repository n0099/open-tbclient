package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class eb {
    private BaseActivity bdY;
    private PbModel efE;

    public eb(PbModel pbModel, BaseActivity baseActivity) {
        this.efE = pbModel;
        this.bdY = baseActivity;
    }

    public String U(Intent intent) {
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (StringUtils.isNull(dataString) || !dataString.startsWith("tbpb://")) {
            return null;
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode)) {
            return null;
        }
        Matcher matcher = Pattern.compile(".*fr=(.*)&tid=([\\\\d]+).*").matcher(decode);
        if (matcher.find()) {
            if ("mpush".equals(matcher.group(1))) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11895").aa("tid", matcher.group(2)));
            } else if ("bpush".equals(matcher.group(1))) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10320").s("obj_locate", 3).s("obj_type", 1));
            }
            return matcher.group(2);
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10320").s("obj_locate", 3).s("obj_type", 1));
        int indexOf = decode.indexOf("tid=");
        if (indexOf < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }
}
