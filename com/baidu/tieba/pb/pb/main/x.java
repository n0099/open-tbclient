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
import com.baidu.tbadk.core.util.ba;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class x {
    public int hKE;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void wZ(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> nW = ba.nW(str);
        if (nW != null) {
            this.hKE = 5;
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c10320");
            amVar.bT("obj_locate", nW.get("obj_locate"));
            amVar.P("obj_type", 1);
            amVar.bT("tid", nW.get("tid"));
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, nW.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            amVar.bT("obj_param2", nW.get("obj_param2"));
            amVar.P("obj_to", 3);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, nW.get("bdid"));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(nW.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(nW.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        amVar.bT(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    public String as(Intent intent) {
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11895").bT("tid", matcher.group(2)));
                        } else {
                            wZ(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        wZ(decode);
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
