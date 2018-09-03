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
    public int fBQ;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void nd(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> eP = az.eP(str);
        if (eP != null) {
            this.fBQ = 5;
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c10320");
            anVar.ae("obj_locate", eP.get("obj_locate"));
            anVar.r("obj_type", 1);
            anVar.ae("tid", eP.get("tid"));
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eP.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            anVar.ae("obj_param2", eP.get("obj_param2"));
            anVar.r("obj_to", 3);
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, eP.get("bdid"));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(eP.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(eP.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.ae(next, jSONObject.getString(next));
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11895").ae("tid", matcher.group(2)));
                        } else {
                            nd(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        nd(decode);
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
