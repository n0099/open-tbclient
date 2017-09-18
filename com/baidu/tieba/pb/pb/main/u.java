package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class u {
    private BaseActivity bnc;
    private PbModel eHJ;

    public u(PbModel pbModel, BaseActivity baseActivity) {
        this.eHJ = pbModel;
        this.bnc = baseActivity;
    }

    private void kY(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> ea = au.ea(str);
        if (ea != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10320").ad("obj_locate", ea.get("obj_locate")).r("obj_type", 1).ad("tid", ea.get("tid")).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ea.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)).ad("obj_param2", ea.get("obj_param2")).r("obj_to", 3));
        }
    }

    public String X(Intent intent) {
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
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11895").ad("tid", matcher.group(2)));
            } else {
                kY(decode);
            }
            return matcher.group(2);
        }
        kY(decode);
        int indexOf = decode.indexOf("tid=");
        if (indexOf < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }
}
