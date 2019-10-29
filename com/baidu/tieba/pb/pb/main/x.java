package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class x {
    public int hSv;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void wy(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = ba.getParamPair(str);
        if (paramPair != null) {
            this.hSv = 5;
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c10320");
            anVar.bS("obj_locate", paramPair.get("obj_locate"));
            anVar.O("obj_type", 1);
            anVar.bS("tid", paramPair.get("tid"));
            anVar.bS("obj_source", paramPair.get("obj_source"));
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            anVar.O(TiebaInitialize.Params.OBJ_TO, 3);
            anVar.bS("obj_id", paramPair.get("bdid"));
            if (!com.baidu.tbadk.core.util.aq.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.bS(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    public String aC(Intent intent) {
        int length;
        String str = null;
        if (intent != null && intent.getData() != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    Matcher matcher = Pattern.compile(".*fr=(.*)&tid=([\\d]+).*").matcher(decode);
                    if (matcher.find()) {
                        if ("mpush".equals(matcher.group(1))) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11895").bS("tid", matcher.group(2)));
                        } else {
                            wy(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        wy(decode);
                        int indexOf = decode.indexOf("tid=");
                        if (indexOf >= 0 && (length = indexOf + "tid=".length()) <= decode.length()) {
                            str = decode.substring(length);
                        }
                    }
                    HttpMessage httpMessage = new HttpMessage(1003393);
                    httpMessage.addParam("call_url", dataString);
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        }
        return str;
    }
}
