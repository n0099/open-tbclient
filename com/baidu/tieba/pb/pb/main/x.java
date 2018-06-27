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
import com.baidu.tbadk.core.util.az;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x {
    public int fBK;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void nc(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> eR = az.eR(str);
        if (eR != null) {
            this.fBK = 5;
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c10320");
            anVar.ah("obj_locate", eR.get("obj_locate"));
            anVar.r("obj_type", 1);
            anVar.ah("tid", eR.get("tid"));
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eR.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            anVar.ah("obj_param2", eR.get("obj_param2"));
            anVar.r("obj_to", 3);
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, eR.get("bdid"));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(eR.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(eR.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.ah(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    public String U(Intent intent) {
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11895").ah("tid", matcher.group(2)));
                        } else {
                            nc(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        nc(decode);
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
