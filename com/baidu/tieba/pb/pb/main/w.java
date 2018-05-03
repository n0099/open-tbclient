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
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class w {
    public int flh;

    public w(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void ms(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> ep = com.baidu.tbadk.core.util.ax.ep(str);
        if (ep != null) {
            this.flh = 5;
            com.baidu.tbadk.core.util.al alVar = new com.baidu.tbadk.core.util.al("c10320");
            alVar.ac("obj_locate", ep.get("obj_locate"));
            alVar.r("obj_type", 1);
            alVar.ac("tid", ep.get("tid"));
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ep.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            alVar.ac("obj_param2", ep.get("obj_param2"));
            alVar.r("obj_to", 3);
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, ep.get("bdid"));
            if (!com.baidu.tbadk.core.util.an.isEmpty(ep.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(ep.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        alVar.ac(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(alVar);
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11895").ac("tid", matcher.group(2)));
                        } else {
                            ms(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        ms(decode);
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
