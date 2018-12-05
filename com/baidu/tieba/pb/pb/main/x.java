package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x {
    public int fZq;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void oM(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> fN = ay.fN(str);
        if (fN != null) {
            this.fZq = 5;
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c10320");
            amVar.aA("obj_locate", fN.get("obj_locate"));
            amVar.x("obj_type", 1);
            amVar.aA("tid", fN.get("tid"));
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, fN.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            amVar.aA("obj_param2", fN.get("obj_param2"));
            amVar.x("obj_to", 3);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, fN.get("bdid"));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(fN.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(fN.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        amVar.aA(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    public String Y(Intent intent) {
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11895").aA("tid", matcher.group(2)));
                        } else {
                            oM(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        oM(decode);
                        int indexOf = decode.indexOf("tid=");
                        if (indexOf >= 0 && (length = indexOf + "tid=".length()) <= decode.length()) {
                            str = decode.substring(length);
                        }
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                    httpMessage.addParam("call_url", dataString);
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        }
        return str;
    }
}
