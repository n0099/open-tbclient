package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x {
    public int fNY;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void me(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> el = com.baidu.tbadk.core.util.av.el(str);
        if (el != null) {
            this.fNY = 5;
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c10320");
            akVar.aa("obj_locate", el.get("obj_locate"));
            akVar.s("obj_type", 1);
            akVar.aa("tid", el.get("tid"));
            akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, el.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            akVar.aa("obj_param2", el.get("obj_param2"));
            akVar.s("obj_to", 3);
            akVar.aa("obj_id", el.get("bdid"));
            if (!com.baidu.tbadk.core.util.am.isEmpty(el.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(el.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        akVar.aa(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(akVar);
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
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11895").aa("tid", matcher.group(2)));
            } else {
                me(decode);
            }
            return matcher.group(2);
        }
        me(decode);
        int indexOf = decode.indexOf("tid=");
        if (indexOf < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }
}
