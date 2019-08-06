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
import com.baidu.tbadk.core.util.bb;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class x {
    public int hRQ;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void xH(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> oo = bb.oo(str);
        if (oo != null) {
            this.hRQ = 5;
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c10320");
            anVar.bT("obj_locate", oo.get("obj_locate"));
            anVar.P("obj_type", 1);
            anVar.bT("tid", oo.get("tid"));
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oo.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            anVar.bT("obj_param2", oo.get("obj_param2"));
            anVar.P("obj_to", 3);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, oo.get("bdid"));
            if (!com.baidu.tbadk.core.util.aq.isEmpty(oo.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(oo.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.bT(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    public String au(Intent intent) {
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11895").bT("tid", matcher.group(2)));
                        } else {
                            xH(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        xH(decode);
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
